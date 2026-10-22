package Z6;

import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.event.CopyEventType;
import com.volcengine.tos.comm.event.DownloadEventType;
import com.volcengine.tos.comm.event.UploadEventType;
import com.volcengine.tos.model.object.CopyEvent;
import com.volcengine.tos.model.object.CopyPartInfo;
import com.volcengine.tos.model.object.DownloadEvent;
import com.volcengine.tos.model.object.DownloadFileCheckpoint;
import com.volcengine.tos.model.object.DownloadPartInfo;
import com.volcengine.tos.model.object.GetObjectV2Input;
import com.volcengine.tos.model.object.GetObjectV2Output;
import com.volcengine.tos.model.object.ObjectMetaRequestOptions;
import com.volcengine.tos.model.object.ResumableCopyObjectCheckpoint;
import com.volcengine.tos.model.object.UploadEvent;
import com.volcengine.tos.model.object.UploadFileV2Checkpoint;
import com.volcengine.tos.model.object.UploadPartCopyV2Input;
import com.volcengine.tos.model.object.UploadPartCopyV2Output;
import com.volcengine.tos.model.object.UploadPartInfo;
import com.volcengine.tos.model.object.UploadPartV2Input;
import com.volcengine.tos.model.object.UploadPartV2Output;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.CheckedInputStream;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1598a;
    public final /* synthetic */ h b;

    public /* synthetic */ b(h hVar, int i) {
        this.f1598a = i;
        this.b = hVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        RandomAccessFile randomAccessFile;
        InputStream content;
        byte[] bArr;
        int i = this.f1598a;
        h hVar = this.b;
        switch (i) {
            case 0:
                c cVar = (c) hVar;
                AtomicLong atomicLong = cVar.f1600j;
                DownloadEventType downloadEventType = DownloadEventType.d;
                DownloadPartInfo downloadPartInfo = cVar.c;
                DownloadEvent downloadEvent = new DownloadEvent();
                DownloadFileCheckpoint downloadFileCheckpoint = cVar.f1599a;
                DownloadEvent checkpointFile = downloadEvent.setBucket(downloadFileCheckpoint.getBucket()).setKey(downloadFileCheckpoint.getKey()).setVersionID(downloadFileCheckpoint.getVersionID()).setFilePath(downloadFileCheckpoint.getDownloadFileInfo().getFilePath()).setTempFilePath(downloadFileCheckpoint.getDownloadFileInfo().getTempFilePath()).setCheckpointFile(cVar.e);
                downloadFileCheckpoint.getDownloadObjectInfo().getObjectSize();
                try {
                    randomAccessFile = new RandomAccessFile(downloadFileCheckpoint.getDownloadFileInfo().getTempFilePath(), "rw");
                    try {
                        randomAccessFile.seek(downloadPartInfo.getRangeStart());
                        ObjectMetaRequestOptions options = cVar.b.getOptions();
                        if (options == null) {
                            options = new ObjectMetaRequestOptions();
                        }
                        options.setRange(downloadPartInfo.getRangeStart(), downloadPartInfo.getRangeEnd());
                        long j5 = cVar.i;
                        if (j5 != 0) {
                            options.setTrafficLimit(j5);
                        }
                        GetObjectV2Output getObjectV2OutputM = cVar.h.m(new GetObjectV2Input().setBucket(cVar.b.getBucket()).setKey(cVar.b.getKey()).setOptions(options).setVersionID(cVar.b.getVersionID()).setRateLimiter(null));
                        downloadFileCheckpoint.getDownloadObjectInfo().getObjectSize();
                        content = getObjectV2OutputM.getContent();
                        try {
                            try {
                                InputStream content2 = getObjectV2OutputM.getContent();
                                content = cVar.f ? new CheckedInputStream(content2, new Y6.a()) : content2;
                                bArr = new byte[8192];
                            } catch (Throwable th) {
                                if (content != null) {
                                    content.close();
                                }
                                throw th;
                            }
                        } catch (IOException e) {
                            TosClientException tosClientException = new TosClientException("tos: write data to local file failed", e);
                            k.L(cVar.g, checkpointFile.setTosException(tosClientException).setDownloadPartInfo(downloadPartInfo).setDownloadEventType(downloadEventType));
                            atomicLong.get();
                            throw tosClientException;
                        }
                    } finally {
                    }
                } catch (TosException e6) {
                    if (k.I(e6.getStatusCode())) {
                        k.L(cVar.g, checkpointFile.setTosException(e6).setDownloadPartInfo(downloadPartInfo).setDownloadEventType(DownloadEventType.e));
                        atomicLong.get();
                        throw e6;
                    }
                    k.L(cVar.g, checkpointFile.setTosException(e6).setDownloadPartInfo(downloadPartInfo).setDownloadEventType(downloadEventType));
                } catch (IOException e9) {
                    TosClientException tosClientException2 = new TosClientException("tos: write data to local file failed", e9);
                    k.L(cVar.g, checkpointFile.setTosException(tosClientException2).setDownloadPartInfo(downloadPartInfo).setDownloadEventType(downloadEventType));
                    atomicLong.get();
                    throw tosClientException2;
                }
                while (true) {
                    int i6 = content.read(bArr);
                    if (i6 <= 0) {
                        downloadPartInfo.setCompleted(true);
                        if (cVar.f) {
                            downloadPartInfo.setHashCrc64ecma(((CheckedInputStream) content).getChecksum().getValue());
                        }
                        if (cVar.d) {
                            downloadFileCheckpoint.writeToFile(cVar.e);
                        }
                        checkpointFile.setDownloadEventType(DownloadEventType.c).setDownloadPartInfo(downloadPartInfo);
                        k.L(cVar.g, checkpointFile);
                        content.close();
                        randomAccessFile.close();
                        return cVar;
                    }
                    randomAccessFile.write(bArr, 0, i6);
                }
            case 1:
                e eVar = (e) hVar;
                ResumableCopyObjectCheckpoint resumableCopyObjectCheckpoint = eVar.f1602a;
                CopyPartInfo copyPartInfo = eVar.c;
                int partNumber = copyPartInfo.getPartNumber();
                CopyEventType copyEventType = CopyEventType.e;
                CopyEventType copyEventType2 = CopyEventType.d;
                CopyEventType copyEventType3 = CopyEventType.c;
                if (partNumber == 1 && copyPartInfo.getCopySourceRangeStart() == 0 && copyPartInfo.getCopySourceRangeEnd() == 0) {
                    UploadPartV2Input uploadPartV2InputBuild = UploadPartV2Input.builder().content(new ByteArrayInputStream("".getBytes())).contentLength(0L).bucket(resumableCopyObjectCheckpoint.getBucket()).key(resumableCopyObjectCheckpoint.getKey()).partNumber(1).uploadID(resumableCopyObjectCheckpoint.getUploadID()).options(eVar.i).build();
                    CopyEvent uploadID = new CopyEvent().setBucket(resumableCopyObjectCheckpoint.getBucket()).setKey(resumableCopyObjectCheckpoint.getKey()).setSrcBucket(resumableCopyObjectCheckpoint.getSrcBucket()).setSrcKey(resumableCopyObjectCheckpoint.getSrcKey()).setSrcVersionID(resumableCopyObjectCheckpoint.getSrcVersionID()).setCheckpointFile(eVar.e).setUploadID(resumableCopyObjectCheckpoint.getUploadID());
                    try {
                        UploadPartV2Output uploadPartV2OutputZ = eVar.g.z(uploadPartV2InputBuild);
                        eVar.h = new UploadPartCopyV2Output().etag(uploadPartV2OutputZ.getEtag()).partNumber(1).requestInfo(uploadPartV2OutputZ.getRequestInfo());
                        copyPartInfo.setCompleted(true);
                        copyPartInfo.setEtag(eVar.h.getEtag());
                        if (eVar.d) {
                            resumableCopyObjectCheckpoint.writeToFile(eVar.e);
                        }
                        k.K(eVar.f, uploadID.setCopyPartInfo(copyPartInfo).setType(copyEventType3));
                    } catch (TosException e10) {
                        if (k.I(e10.getStatusCode())) {
                            k.K(eVar.f, uploadID.setException(e10).setType(copyEventType));
                            throw e10;
                        }
                        k.K(eVar.f, uploadID.setException(e10).setType(copyEventType2));
                    }
                } else {
                    if (eVar.f1603j != 0) {
                        if (eVar.i == null) {
                            eVar.i = new ObjectMetaRequestOptions();
                        }
                        eVar.i.setTrafficLimit(eVar.f1603j);
                    }
                    UploadPartCopyV2Input uploadPartCopyV2InputBuild = UploadPartCopyV2Input.builder().bucket(resumableCopyObjectCheckpoint.getBucket()).key(resumableCopyObjectCheckpoint.getKey()).sourceBucket(resumableCopyObjectCheckpoint.getSrcBucket()).sourceKey(resumableCopyObjectCheckpoint.getSrcKey()).sourceVersionID(resumableCopyObjectCheckpoint.getSrcVersionID()).uploadID(resumableCopyObjectCheckpoint.getUploadID()).partNumber(copyPartInfo.getPartNumber()).copySourceRange(copyPartInfo.getCopySourceRangeStart(), copyPartInfo.getCopySourceRangeEnd()).copySourceIfMatch(resumableCopyObjectCheckpoint.getCopySourceIfMatch()).copySourceIfModifiedSinceDate(resumableCopyObjectCheckpoint.getCopySourceIfModifiedSince()).copySourceIfNoneMatch(resumableCopyObjectCheckpoint.getCopySourceIfNoneMatch()).copySourceIfUnmodifiedSinceDate(resumableCopyObjectCheckpoint.getCopySourceIfUnModifiedSince()).copySourceSSECAlgorithm(resumableCopyObjectCheckpoint.getCopySourceSSECAlgorithm()).copySourceSSECKeyMD5(resumableCopyObjectCheckpoint.getCopySourceSSECKeyMD5()).copySourceSSECKey(eVar.b).options(eVar.i).build();
                    CopyEvent uploadID2 = new CopyEvent().setBucket(resumableCopyObjectCheckpoint.getBucket()).setKey(resumableCopyObjectCheckpoint.getKey()).setSrcBucket(resumableCopyObjectCheckpoint.getSrcBucket()).setSrcKey(resumableCopyObjectCheckpoint.getSrcKey()).setSrcVersionID(resumableCopyObjectCheckpoint.getSrcVersionID()).setCheckpointFile(eVar.e).setUploadID(resumableCopyObjectCheckpoint.getUploadID());
                    try {
                        eVar.h = eVar.g.A(uploadPartCopyV2InputBuild);
                        copyPartInfo.setCompleted(true);
                        copyPartInfo.setEtag(eVar.h.getEtag());
                        if (eVar.d) {
                            resumableCopyObjectCheckpoint.writeToFile(eVar.e);
                        }
                        k.K(eVar.f, uploadID2.setCopyPartInfo(copyPartInfo).setType(copyEventType3));
                    } catch (TosException e11) {
                        if (k.I(e11.getStatusCode())) {
                            k.K(eVar.f, uploadID2.setException(e11).setType(copyEventType));
                            throw e11;
                        }
                        k.K(eVar.f, uploadID2.setException(e11).setType(copyEventType2));
                    }
                }
                return eVar;
            default:
                i iVar = (i) hVar;
                UploadFileV2Checkpoint uploadFileV2Checkpoint = iVar.f1605a;
                String filePath = uploadFileV2Checkpoint.getFilePath();
                UploadPartInfo uploadPartInfo = iVar.b;
                V6.a aVarW = k.w(null, null, filePath, uploadPartInfo.getOffset(), uploadPartInfo.getPartSize());
                if (iVar.i != 0) {
                    if (iVar.h == null) {
                        iVar.h = new ObjectMetaRequestOptions();
                    }
                    iVar.h.setTrafficLimit(iVar.i);
                }
                UploadPartV2Input uploadPartV2InputBuild2 = UploadPartV2Input.builder().bucket(uploadFileV2Checkpoint.getBucket()).key(uploadFileV2Checkpoint.getKey()).uploadID(uploadFileV2Checkpoint.getUploadID()).partNumber(uploadPartInfo.getPartNumber()).rateLimiter(null).options(iVar.h).content(aVarW).contentLength(uploadPartInfo.getPartSize()).build();
                UploadEvent filePath2 = new UploadEvent().setBucket(uploadFileV2Checkpoint.getBucket()).setKey(uploadFileV2Checkpoint.getKey()).setCheckpointFile(iVar.d).setUploadID(uploadFileV2Checkpoint.getUploadID()).setFilePath(uploadFileV2Checkpoint.getFilePath());
                uploadFileV2Checkpoint.getFileSize();
                try {
                    iVar.g = iVar.f.z(uploadPartV2InputBuild2);
                    uploadPartInfo.setCompleted(true);
                    uploadPartInfo.setEtag(iVar.g.getEtag());
                    uploadPartInfo.setHashCrc64ecma(U7.a.Z(iVar.g.getHashCrc64ecma()));
                    if (iVar.c) {
                        uploadFileV2Checkpoint.writeToFile(iVar.d);
                    }
                    k.M(iVar.e, filePath2.setUploadPartInfo(uploadPartInfo).setUploadEventType(UploadEventType.c));
                } catch (TosException e12) {
                    if (k.I(e12.getStatusCode())) {
                        k.M(iVar.e, filePath2.setTosException(e12).setUploadEventType(UploadEventType.e));
                        iVar.f1606j.get();
                        throw e12;
                    }
                    k.M(iVar.e, filePath2.setTosException(e12).setUploadEventType(UploadEventType.d));
                }
                return iVar;
        }
    }
}
