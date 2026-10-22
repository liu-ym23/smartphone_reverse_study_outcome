package X6;

import F9.C0234l;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosException;
import com.volcengine.tos.comm.event.UploadEventType;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Input;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Output;
import com.volcengine.tos.model.object.CreateMultipartUploadInput;
import com.volcengine.tos.model.object.CreateMultipartUploadOutput;
import com.volcengine.tos.model.object.UploadEvent;
import com.volcengine.tos.model.object.UploadFileInfo;
import com.volcengine.tos.model.object.UploadFileV2Checkpoint;
import com.volcengine.tos.model.object.UploadFileV2Input;
import com.volcengine.tos.model.object.UploadFileV2Output;
import com.volcengine.tos.model.object.UploadPartInfo;
import com.volcengine.tos.model.object.UploadPartV2Output;
import com.volcengine.tos.model.object.UploadedPartV2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public A0.b f1514a;
    public C0234l b;
    public boolean c;

    public final UploadFileV2Output a(UploadFileV2Input uploadFileV2Input) throws InterruptedException, IOException {
        UploadFileV2Checkpoint uploadFileV2CheckpointC;
        boolean zIsValid;
        UploadFileV2Input uploadFileV2Input2;
        ArrayList arrayList;
        G6.f fVar = new G6.f(uploadFileV2Input, this.b, this.c);
        AtomicLong atomicLong = (AtomicLong) fVar.h;
        C0234l c0234l = (C0234l) fVar.c;
        UploadFileV2Input uploadFileV2Input3 = (UploadFileV2Input) fVar.b;
        if (uploadFileV2Input3.getPartSize() == 0) {
            uploadFileV2Input3.setPartSize(20971520L);
        }
        Z6.k.Q(uploadFileV2Input3.getPartSize());
        int taskNum = uploadFileV2Input3.getTaskNum();
        if (taskNum > 1000) {
            taskNum = 1000;
        } else if (taskNum < 1) {
            taskNum = 1;
        }
        uploadFileV2Input3.setTaskNum(taskNum);
        File file = new File(uploadFileV2Input3.getFilePath());
        if (!file.exists()) {
            throw new TosClientException("invalid file path, the file does not exist: " + uploadFileV2Input3.getFilePath(), null);
        }
        if (file.isDirectory()) {
            throw new TosClientException("do not support directory, please specific your file path", null);
        }
        if (uploadFileV2Input3.isEnableCheckpoint()) {
            String str = Z6.k.n(uploadFileV2Input3.getBucket(), uploadFileV2Input3.getKey(), "") + ".upload";
            if (AbstractC0291a.x(uploadFileV2Input3.getCheckpointFile())) {
                uploadFileV2Input3.setCheckpointFile(uploadFileV2Input3.getFilePath() + "." + str);
            } else if (new File(uploadFileV2Input3.getCheckpointFile()).isDirectory()) {
                uploadFileV2Input3.setCheckpointFile(uploadFileV2Input3.getCheckpointFile() + File.separator + str);
            }
            AbstractC0307c.a(uploadFileV2Input3.getCheckpointFile(), "checkpointFilePath");
        }
        String filePath = uploadFileV2Input3.getFilePath();
        File file2 = new File(filePath);
        UploadFileInfo lastModified = new UploadFileInfo().setFilePath(filePath).setFileSize(file2.length()).setLastModified(file2.lastModified());
        if (uploadFileV2Input3.isEnableCheckpoint()) {
            try {
                uploadFileV2CheckpointC = G6.f.c(uploadFileV2Input3.getCheckpointFile());
            } catch (IOException | ClassNotFoundException unused) {
                Z6.k.u(uploadFileV2Input3.getCheckpointFile());
            }
        } else {
            uploadFileV2CheckpointC = null;
        }
        if (uploadFileV2CheckpointC != null) {
            zIsValid = uploadFileV2CheckpointC.isValid(lastModified.getFileSize(), lastModified.getLastModified(), uploadFileV2Input3.getBucket(), uploadFileV2Input3.getKey(), uploadFileV2Input3.getFilePath());
            if (zIsValid) {
                long partSize = 0;
                for (UploadPartInfo uploadPartInfo : uploadFileV2CheckpointC.getUploadPartInfos()) {
                    if (uploadPartInfo.isCompleted()) {
                        partSize += uploadPartInfo.getPartSize();
                    }
                }
                atomicLong.compareAndSet(atomicLong.get(), partSize);
            } else {
                Z6.k.u(uploadFileV2Input3.getCheckpointFile());
            }
        } else {
            zIsValid = false;
        }
        if (uploadFileV2CheckpointC == null || !zIsValid) {
            UploadFileV2Checkpoint key = new UploadFileV2Checkpoint().setBucket(uploadFileV2Input3.getBucket()).setKey(uploadFileV2Input3.getKey());
            long fileSize = lastModified.getFileSize();
            long partSize2 = uploadFileV2Input3.getPartSize();
            long j5 = fileSize / partSize2;
            long j6 = fileSize % partSize2;
            if (j6 != 0) {
                j5++;
            }
            if (j5 > 10000) {
                throw new TosClientException("unsupported part number, the maximum is 10000", null);
            }
            ArrayList arrayList2 = new ArrayList((int) j5);
            uploadFileV2Input2 = uploadFileV2Input3;
            int i = 0;
            while (true) {
                long j10 = i;
                if (j10 >= j5) {
                    break;
                }
                if (j10 < j5 - 1) {
                    arrayList2.add(new UploadPartInfo().setPartSize(partSize2).setPartNumber(i + 1).setOffset(j10 * partSize2));
                } else {
                    arrayList2.add(new UploadPartInfo().setPartSize(j6).setPartNumber(i + 1).setOffset(j10 * partSize2));
                }
                i++;
            }
            if (j5 == 0) {
                arrayList2.add(new UploadPartInfo().setPartNumber(1).setPartSize(0L).setOffset(0L));
            }
            uploadFileV2CheckpointC = key.setUploadPartInfos(arrayList2).setFilePath(lastModified.getFilePath()).setFileSize(lastModified.getFileSize()).setLastModified(lastModified.getLastModified());
            UploadEvent filePath2 = new UploadEvent().setBucket(uploadFileV2Input2.getBucket()).setKey(uploadFileV2Input2.getKey()).setCheckpointFile(uploadFileV2Input2.getCheckpointFile()).setFilePath(uploadFileV2Input2.getFilePath());
            try {
                CreateMultipartUploadOutput createMultipartUploadOutputH = c0234l.h(new CreateMultipartUploadInput().setBucket(uploadFileV2Input2.getBucket()).setKey(uploadFileV2Input2.getKey()).setOptions(uploadFileV2Input2.getOptions()).setEncodingType(uploadFileV2Input2.getEncodingType()));
                Z6.k.M(uploadFileV2Input2.getUploadEventListener(), filePath2.setUploadID(createMultipartUploadOutputH.getUploadID()).setUploadEventType(UploadEventType.f4235a));
                uploadFileV2CheckpointC.setUploadID(createMultipartUploadOutputH.getUploadID()).setEncodingType(createMultipartUploadOutputH.getEncodingType());
                if (uploadFileV2Input2.isEnableCheckpoint()) {
                    try {
                        uploadFileV2CheckpointC.writeToFile(uploadFileV2Input2.getCheckpointFile());
                    } catch (IOException e) {
                        throw new TosClientException("tos: record to checkpoint file failed", e);
                    }
                }
            } catch (TosException e6) {
                Z6.k.M(uploadFileV2Input2.getUploadEventListener(), filePath2.setTosException(e6).setUploadEventType(UploadEventType.b));
                throw e6;
            }
        } else {
            uploadFileV2Input2 = uploadFileV2Input3;
        }
        fVar.d = uploadFileV2CheckpointC;
        int size = uploadFileV2CheckpointC.getUploadPartInfos().size();
        K1.a aVar = (K1.a) fVar.e;
        String bucket = ((UploadFileV2Checkpoint) fVar.d).getBucket();
        String key2 = ((UploadFileV2Checkpoint) fVar.d).getKey();
        String uploadID = ((UploadFileV2Checkpoint) fVar.d).getUploadID();
        String checkpointFile = uploadFileV2Input2.getCheckpointFile();
        boolean zIsEnableCheckpoint = uploadFileV2Input2.isEnableCheckpoint();
        Z6.j jVar = new Z6.j();
        jVar.f1607a = c0234l;
        jVar.g = aVar;
        jVar.b = bucket;
        jVar.c = key2;
        jVar.d = uploadID;
        jVar.e = checkpointFile;
        jVar.f = zIsEnableCheckpoint;
        jVar.i = new ReentrantLock();
        fVar.g = jVar;
        fVar.e = new K1.a(uploadFileV2Input2.getTaskNum(), size, (Z6.j) fVar.g);
        if (uploadFileV2Input2.getCancelHook() != null && (uploadFileV2Input2.getCancelHook() instanceof Z6.j)) {
            Z6.j jVar2 = (Z6.j) uploadFileV2Input2.getCancelHook();
            jVar2.f1607a = c0234l;
            jVar2.g = (K1.a) fVar.e;
            jVar2.b = ((UploadFileV2Checkpoint) fVar.d).getBucket();
            jVar2.c = ((UploadFileV2Checkpoint) fVar.d).getKey();
            jVar2.d = ((UploadFileV2Checkpoint) fVar.d).getUploadID();
            jVar2.f = uploadFileV2Input2.isEnableCheckpoint();
            jVar2.e = uploadFileV2Input2.getCheckpointFile();
        }
        fVar.f = new ArrayList(size);
        UploadFileV2Input uploadFileV2Input4 = (UploadFileV2Input) fVar.b;
        for (int i6 = 0; i6 < ((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos().size(); i6++) {
            if (((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos().get(i6).isCompleted()) {
                UploadPartInfo uploadPartInfo2 = ((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos().get(i6);
                ((ArrayList) fVar.f).add(new UploadedPartV2().setEtag(uploadPartInfo2.getEtag()).setPartNumber(uploadPartInfo2.getPartNumber()));
            } else {
                K1.a aVar2 = (K1.a) fVar.e;
                Z6.i iVar = new Z6.i((UploadFileV2Checkpoint) fVar.d, i6, atomicLong);
                iVar.c = uploadFileV2Input4.isEnableCheckpoint();
                iVar.d = uploadFileV2Input4.getCheckpointFile();
                iVar.e = uploadFileV2Input4.getUploadEventListener();
                iVar.h = uploadFileV2Input4.getOptions();
                uploadFileV2Input4.getRateLimiter();
                uploadFileV2Input4.getDataTransferListener();
                iVar.f = (C0234l) fVar.c;
                iVar.i = uploadFileV2Input4.getTrafficLimit();
                ((ArrayList) aVar2.d).add(iVar);
            }
        }
        boolean z10 = fVar.f682a;
        UploadFileV2Input uploadFileV2Input5 = (UploadFileV2Input) fVar.b;
        uploadFileV2Input5.getDataTransferListener();
        ((UploadFileV2Checkpoint) fVar.d).getFileSize();
        atomicLong.get();
        ((K1.a) fVar.e).f();
        Iterator it = ((ArrayList) ((K1.a) fVar.e).c).iterator();
        while (it.hasNext()) {
            UploadPartV2Output uploadPartV2Output = (UploadPartV2Output) ((Z6.g) it.next()).a();
            if (uploadPartV2Output != null) {
                ((ArrayList) fVar.f).add(new UploadedPartV2().setPartNumber(uploadPartV2Output.getPartNumber()).setEtag(uploadPartV2Output.getEtag()));
            }
        }
        ((UploadFileV2Checkpoint) fVar.d).getFileSize();
        atomicLong.get();
        UploadFileV2Checkpoint uploadFileV2Checkpoint = (UploadFileV2Checkpoint) fVar.d;
        if (uploadFileV2Checkpoint != null && uploadFileV2Checkpoint.getBucket() != null && ((UploadFileV2Checkpoint) fVar.d).getKey() != null && ((UploadFileV2Checkpoint) fVar.d).getUploadID() != null && ((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos() != null && (arrayList = (ArrayList) fVar.f) != null && arrayList.size() == ((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos().size()) {
            for (UploadPartInfo uploadPartInfo3 : ((UploadFileV2Checkpoint) fVar.d).getUploadPartInfos()) {
                if (!uploadPartInfo3.isCompleted() || (z10 && uploadPartInfo3.getPartSize() > 0 && uploadPartInfo3.getHashCrc64ecma() == 0)) {
                }
            }
            uploadFileV2Input5.getDataTransferListener();
            uploadFileV2Input5.getDataTransferListener();
            CompleteMultipartUploadV2Input uploadedParts = new CompleteMultipartUploadV2Input().setBucket(((UploadFileV2Checkpoint) fVar.d).getBucket()).setKey(((UploadFileV2Checkpoint) fVar.d).getKey()).setUploadID(((UploadFileV2Checkpoint) fVar.d).getUploadID()).setUploadedParts((ArrayList) fVar.f);
            UploadEvent filePath3 = new UploadEvent().setUploadID(((UploadFileV2Checkpoint) fVar.d).getUploadID()).setBucket(((UploadFileV2Checkpoint) fVar.d).getBucket()).setKey(((UploadFileV2Checkpoint) fVar.d).getKey()).setCheckpointFile(uploadFileV2Input5.getCheckpointFile()).setFilePath(uploadFileV2Input5.getFilePath());
            try {
                CompleteMultipartUploadV2Output completeMultipartUploadV2OutputF = ((C0234l) fVar.c).f(uploadedParts);
                if (z10) {
                    fVar.b(completeMultipartUploadV2OutputF.getHashCrc64ecma());
                }
                Z6.k.M(uploadFileV2Input5.getUploadEventListener(), filePath3.setUploadEventType(UploadEventType.f));
                if (uploadFileV2Input5.isEnableCheckpoint()) {
                    Z6.k.u(uploadFileV2Input5.getCheckpointFile());
                }
                return new UploadFileV2Output().setRequestInfo(completeMultipartUploadV2OutputF.getRequestInfo()).setBucket(completeMultipartUploadV2OutputF.getBucket()).setKey(completeMultipartUploadV2OutputF.getKey()).setUploadID(((UploadFileV2Checkpoint) fVar.d).getUploadID()).setEtag(completeMultipartUploadV2OutputF.getEtag()).setLocation(completeMultipartUploadV2OutputF.getLocation()).setHashCrc64ecma(completeMultipartUploadV2OutputF.getHashCrc64ecma()).setVersionID(completeMultipartUploadV2OutputF.getVersionID()).setSsecAlgorithm(((UploadFileV2Checkpoint) fVar.d).getSseAlgorithm()).setSsecKeyMD5(((UploadFileV2Checkpoint) fVar.d).getSseKeyMd5()).setEncodingType(((UploadFileV2Checkpoint) fVar.d).getEncodingType());
            } catch (TosException e9) {
                Z6.k.M(uploadFileV2Input5.getUploadEventListener(), filePath3.setTosException(e9).setUploadEventType(UploadEventType.g));
                throw e9;
            }
        }
        throw new TosClientException("tos: some upload tasks failed. bucket is " + uploadFileV2Input5.getBucket() + ", key is " + uploadFileV2Input5.getKey(), null);
    }
}
