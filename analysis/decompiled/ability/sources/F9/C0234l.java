package F9;

import a.AbstractC0291a;
import a7.AbstractC0306b;
import a7.AbstractC0307c;
import a7.AbstractC0308d;
import androidx.compose.runtime.ComposerKt;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.UnexpectedStatusCodeException;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.object.AbortMultipartUploadInput;
import com.volcengine.tos.model.object.AbortMultipartUploadOutput;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Input;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Output;
import com.volcengine.tos.model.object.CopyObjectV2Input;
import com.volcengine.tos.model.object.CopyObjectV2Output;
import com.volcengine.tos.model.object.CreateMultipartUploadInput;
import com.volcengine.tos.model.object.CreateMultipartUploadOutput;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Input;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Output;
import com.volcengine.tos.model.object.DeleteObjectInput;
import com.volcengine.tos.model.object.DeleteObjectOutput;
import com.volcengine.tos.model.object.GetObjectACLV2Input;
import com.volcengine.tos.model.object.GetObjectACLV2Output;
import com.volcengine.tos.model.object.GetObjectBasicOutput;
import com.volcengine.tos.model.object.GetObjectV2Input;
import com.volcengine.tos.model.object.GetObjectV2Output;
import com.volcengine.tos.model.object.HeadObjectV2Input;
import com.volcengine.tos.model.object.HeadObjectV2Output;
import com.volcengine.tos.model.object.ListMultipartUploadsV2Input;
import com.volcengine.tos.model.object.ListMultipartUploadsV2Output;
import com.volcengine.tos.model.object.ListObjectVersionsV2Input;
import com.volcengine.tos.model.object.ListObjectVersionsV2Output;
import com.volcengine.tos.model.object.ListObjectsType2Input;
import com.volcengine.tos.model.object.ListObjectsType2Output;
import com.volcengine.tos.model.object.ListObjectsV2Input;
import com.volcengine.tos.model.object.ListObjectsV2Output;
import com.volcengine.tos.model.object.ListPartsInput;
import com.volcengine.tos.model.object.ListPartsOutput;
import com.volcengine.tos.model.object.ObjectTobeDeleted;
import com.volcengine.tos.model.object.PutObjectACLInput;
import com.volcengine.tos.model.object.PutObjectACLOutput;
import com.volcengine.tos.model.object.PutObjectBasicInput;
import com.volcengine.tos.model.object.PutObjectInput;
import com.volcengine.tos.model.object.PutObjectOutput;
import com.volcengine.tos.model.object.SetObjectMetaInput;
import com.volcengine.tos.model.object.SetObjectMetaOutput;
import com.volcengine.tos.model.object.TosObjectInputStream;
import com.volcengine.tos.model.object.UploadPartBasicInput;
import com.volcengine.tos.model.object.UploadPartCopyV2Input;
import com.volcengine.tos.model.object.UploadPartCopyV2Output;
import com.volcengine.tos.model.object.UploadPartV2Input;
import com.volcengine.tos.model.object.UploadPartV2Output;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import okhttp3.TlsVersion;

/* renamed from: F9.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0234l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f649a = true;
    public boolean b;
    public Object c;
    public Object d;

    public static ArrayList l(Map map) {
        ArrayList arrayList = new ArrayList(1);
        if (map == null) {
            arrayList.add(200);
            return arrayList;
        }
        arrayList.add(200);
        if (map.get("Range") != null) {
            arrayList.add(Integer.valueOf(ComposerKt.referenceKey));
        }
        return arrayList;
    }

    public UploadPartCopyV2Output A(UploadPartCopyV2Input uploadPartCopyV2Input) {
        AbstractC0307c.a(uploadPartCopyV2Input, "UploadPartCopyV2Input");
        AbstractC0307c.a(uploadPartCopyV2Input.getUploadID(), "UploadID");
        int partNumber = uploadPartCopyV2Input.getPartNumber();
        if (partNumber < 1 || partNumber > 10000) {
            throw new TosClientException("part number should be between [1, 10000]", null);
        }
        k(uploadPartCopyV2Input.getBucket());
        AbstractC0307c.c(uploadPartCopyV2Input.getKey());
        k(uploadPartCopyV2Input.getSourceBucket());
        AbstractC0307c.c(uploadPartCopyV2Input.getSourceKey());
        X6.c cVarC = ((X6.o) this.d).c(uploadPartCopyV2Input.getBucket(), uploadPartCopyV2Input.getKey(), uploadPartCopyV2Input.getAllSettedHeaders());
        cVarC.d("partNumber", a7.f.c(uploadPartCopyV2Input.getPartNumber()));
        cVarC.d("uploadId", uploadPartCopyV2Input.getUploadID());
        cVarC.d("versionId", uploadPartCopyV2Input.getSourceVersionID());
        X6.o oVar = (X6.o) this.d;
        String sourceBucket = uploadPartCopyV2Input.getSourceBucket();
        String sourceKey = uploadPartCopyV2Input.getSourceKey();
        oVar.getClass();
        return (UploadPartCopyV2Output) ((A0.b) this.c).z(X6.o.b(cVarC, sourceBucket, sourceKey), 200, new A6.a(3, this, uploadPartCopyV2Input));
    }

    public AbortMultipartUploadOutput a(AbortMultipartUploadInput abortMultipartUploadInput) {
        AbstractC0307c.a(abortMultipartUploadInput, "AbortMultipartUploadInput");
        AbstractC0307c.a(abortMultipartUploadInput.getUploadID(), "uploadID");
        k(abortMultipartUploadInput.getBucket());
        AbstractC0307c.c(abortMultipartUploadInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(abortMultipartUploadInput.getBucket(), abortMultipartUploadInput.getKey(), null);
        cVarC.d("uploadId", abortMultipartUploadInput.getUploadID());
        ((X6.o) this.d).getClass();
        X6.n nVarA = X6.o.a(cVarC, "DELETE", null);
        nVarA.g = false;
        return (AbortMultipartUploadOutput) ((A0.b) this.c).z(nVarA, ComposerKt.providerMapsKey, new X6.h(6));
    }

    public void b(X6.c cVar, String str) {
        if (AbstractC0291a.x((String) cVar.i.get(HttpHeaders.CONTENT_TYPE)) && this.f649a && cVar.k) {
            cVar.c(HttpHeaders.CONTENT_TYPE, T6.a.a().b(str));
        }
    }

    public C0235m c() {
        return new C0235m(this.f649a, this.b, (String[]) this.c, (String[]) this.d);
    }

    public void d(C0232j... cipherSuites) {
        kotlin.jvm.internal.k.f(cipherSuites, "cipherSuites");
        if (!this.f649a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(cipherSuites.length);
        for (C0232j c0232j : cipherSuites) {
            arrayList.add(c0232j.f647a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void e(String... cipherSuites) {
        kotlin.jvm.internal.k.f(cipherSuites, "cipherSuites");
        if (!this.f649a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (cipherSuites.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.c = (String[]) cipherSuites.clone();
    }

    public CompleteMultipartUploadV2Output f(CompleteMultipartUploadV2Input completeMultipartUploadV2Input) {
        String str;
        AbstractC0307c.a(completeMultipartUploadV2Input, "CompleteMultipartUploadV2Input");
        AbstractC0307c.a(completeMultipartUploadV2Input.getUploadID(), "uploadID");
        k(completeMultipartUploadV2Input.getBucket());
        AbstractC0307c.c(completeMultipartUploadV2Input.getKey());
        X6.c cVarC = ((X6.o) this.d).c(completeMultipartUploadV2Input.getBucket(), completeMultipartUploadV2Input.getKey(), null);
        cVarC.d("uploadId", completeMultipartUploadV2Input.getUploadID());
        cVarC.c("x-tos-callback", completeMultipartUploadV2Input.getCallback());
        cVarC.c("x-tos-callback-var", completeMultipartUploadV2Input.getCallbackVar());
        byte[] bArr = new byte[0];
        if (completeMultipartUploadV2Input.isCompleteAll()) {
            if (completeMultipartUploadV2Input.getUploadedParts() != null && completeMultipartUploadV2Input.getUploadedParts().size() != 0) {
                throw new TosClientException("tos: you should not set uploadedParts while using completeAll.", null);
            }
            cVarC.c("x-tos-complete-all", "yes");
            str = null;
        } else {
            if (completeMultipartUploadV2Input.getUploadedParts() == null || completeMultipartUploadV2Input.getUploadedParts().size() == 0) {
                throw new TosClientException("tos: you must specify at least one part.", null);
            }
            F.g gVarC = AbstractC0308d.c(completeMultipartUploadV2Input);
            str = (String) gVarC.b;
            bArr = (byte[]) gVarC.c;
        }
        cVarC.c("Content-MD5", str);
        X6.o oVar = (X6.o) this.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        oVar.getClass();
        X6.n nVarA = X6.o.a(cVarC, "POST", byteArrayInputStream);
        nVarA.f = bArr.length;
        nVarA.g = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(ComposerKt.providerValuesKey));
        A0.b bVar = (A0.b) this.c;
        B5.a aVar = new B5.a(this, completeMultipartUploadV2Input);
        bVar.getClass();
        try {
            TosResponse tosResponseX = bVar.x(nVarA);
            try {
                if (tosResponseX.f4236a == 200) {
                    Object objC = aVar.c(tosResponseX);
                    tosResponseX.close();
                    return (CompleteMultipartUploadV2Output) objC;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (tosResponseX.f4236a == ((Integer) it.next()).intValue()) {
                        A0.b.u(tosResponseX.f4236a, AbstractC0291a.I(tosResponseX.d, "response body"), tosResponseX.f());
                        throw null;
                    }
                }
                A0.b.v(tosResponseX);
                throw new UnexpectedStatusCodeException(tosResponseX.f4236a, 200, tosResponseX.f());
            } finally {
            }
        } catch (IOException e) {
            throw new TosClientException("tos: close body failed", e);
        }
    }

    public CopyObjectV2Output g(CopyObjectV2Input copyObjectV2Input) {
        AbstractC0307c.a(copyObjectV2Input, "CopyObjectV2Input");
        k(copyObjectV2Input.getBucket());
        AbstractC0307c.c(copyObjectV2Input.getKey());
        k(copyObjectV2Input.getSrcBucket());
        AbstractC0307c.c(copyObjectV2Input.getSrcKey());
        X6.c cVarC = ((X6.o) this.d).c(copyObjectV2Input.getBucket(), copyObjectV2Input.getKey(), copyObjectV2Input.getAllSettedHeaders());
        cVarC.d("versionId", copyObjectV2Input.getSrcVersionID());
        X6.o oVar = (X6.o) this.d;
        String srcBucket = copyObjectV2Input.getSrcBucket();
        String srcKey = copyObjectV2Input.getSrcKey();
        oVar.getClass();
        return (CopyObjectV2Output) ((A0.b) this.c).z(X6.o.b(cVarC, srcBucket, srcKey), 200, new X6.k(this, 2));
    }

    public CreateMultipartUploadOutput h(CreateMultipartUploadInput createMultipartUploadInput) {
        AbstractC0307c.a(createMultipartUploadInput, "CreateMultipartUploadInput");
        k(createMultipartUploadInput.getBucket());
        AbstractC0307c.c(createMultipartUploadInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(createMultipartUploadInput.getBucket(), createMultipartUploadInput.getKey(), createMultipartUploadInput.getAllSettedHeaders());
        cVarC.d("uploads", "");
        b(cVarC, createMultipartUploadInput.getKey());
        ((X6.o) this.d).getClass();
        X6.n nVarA = X6.o.a(cVarC, "POST", null);
        nVarA.g = false;
        return (CreateMultipartUploadOutput) ((A0.b) this.c).z(nVarA, 200, new X6.h(this, 10));
    }

    public DeleteMultiObjectsV2Output i(DeleteMultiObjectsV2Input deleteMultiObjectsV2Input) {
        AbstractC0307c.a(deleteMultiObjectsV2Input, "DeleteMultiObjectsV2Input");
        AbstractC0307c.a(deleteMultiObjectsV2Input.getObjects(), "objects to be deleted");
        k(deleteMultiObjectsV2Input.getBucket());
        Iterator<ObjectTobeDeleted> it = deleteMultiObjectsV2Input.getObjects().iterator();
        while (it.hasNext()) {
            AbstractC0307c.c(it.next().getKey());
        }
        F.g gVarC = AbstractC0308d.c(deleteMultiObjectsV2Input);
        byte[] bArr = (byte[]) gVarC.c;
        X6.c cVarC = ((X6.o) this.d).c(deleteMultiObjectsV2Input.getBucket(), "", null);
        cVarC.c("Content-MD5", (String) gVarC.b);
        cVarC.d("delete", "");
        X6.o oVar = (X6.o) this.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        oVar.getClass();
        X6.n nVarA = X6.o.a(cVarC, "POST", byteArrayInputStream);
        nVarA.f = bArr.length;
        return (DeleteMultiObjectsV2Output) ((A0.b) this.c).z(nVarA, 200, new X6.k(this, 4));
    }

    public DeleteObjectOutput j(DeleteObjectInput deleteObjectInput) {
        AbstractC0307c.a(deleteObjectInput, "DeleteObjectInput");
        k(deleteObjectInput.getBucket());
        AbstractC0307c.c(deleteObjectInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(deleteObjectInput.getBucket(), deleteObjectInput.getKey(), null);
        cVarC.d("versionId", deleteObjectInput.getVersionID());
        ((X6.o) this.d).getClass();
        return (DeleteObjectOutput) ((A0.b) this.c).z(X6.o.a(cVarC, "DELETE", null), ComposerKt.providerMapsKey, new X6.h(7));
    }

    public void k(String str) {
        ((X6.o) this.d).getClass();
        AbstractC0307c.b(str);
    }

    public GetObjectV2Output m(GetObjectV2Input getObjectV2Input) throws IOException {
        AbstractC0307c.a(getObjectV2Input, "GetObjectV2Input");
        k(getObjectV2Input.getBucket());
        AbstractC0307c.c(getObjectV2Input.getKey());
        X6.c cVarC = ((X6.o) this.d).c(getObjectV2Input.getBucket(), getObjectV2Input.getKey(), getObjectV2Input.getAllSettedHeaders());
        cVarC.d("versionId", getObjectV2Input.getVersionID());
        cVarC.d("response-cache-control", getObjectV2Input.getResponseCacheControl());
        cVarC.d("response-content-disposition", getObjectV2Input.getResponseContentDisposition());
        cVarC.d("response-content-encoding", getObjectV2Input.getResponseContentEncoding());
        cVarC.d("response-content-type", getObjectV2Input.getResponseContentType());
        cVarC.d("response-content-language", getObjectV2Input.getResponseContentLanguage());
        cVarC.d("response-expires", AbstractC0306b.a(getObjectV2Input.getResponseExpires()));
        cVarC.d("x-tos-process", getObjectV2Input.getProcess());
        ((X6.o) this.d).getClass();
        TosResponse tosResponseY = ((A0.b) this.c).y(X6.o.a(cVarC, "GET", null), l(getObjectV2Input.getAllSettedHeaders()));
        getObjectV2Input.getRateLimiter();
        getObjectV2Input.getDataTransferListener();
        GetObjectBasicOutput fromTosResponse = new GetObjectBasicOutput().setRequestInfo(tosResponseY.b()).parseFromTosResponse(tosResponseY);
        InputStream bVar = tosResponseY.d;
        if (this.b && tosResponseY.f4236a != 206) {
            bVar = new Y6.b(bVar, new Y6.a(), tosResponseY.c("x-tos-hash-crc64ecma"));
        }
        GetObjectV2Output getObjectV2Output = new GetObjectV2Output(fromTosResponse, new TosObjectInputStream(bVar));
        V9.i iVar = tosResponseY.e;
        B0.f fVar = new B0.f();
        fVar.f177a = bVar;
        fVar.c = iVar;
        fVar.b = false;
        return getObjectV2Output.setHook(fVar);
    }

    public GetObjectACLV2Output n(GetObjectACLV2Input getObjectACLV2Input) {
        AbstractC0307c.a(getObjectACLV2Input, "GetObjectACLV2Input");
        k(getObjectACLV2Input.getBucket());
        AbstractC0307c.c(getObjectACLV2Input.getKey());
        X6.c cVarC = ((X6.o) this.d).c(getObjectACLV2Input.getBucket(), getObjectACLV2Input.getKey(), null);
        cVarC.d("acl", "");
        ((X6.o) this.d).getClass();
        return (GetObjectACLV2Output) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.k(this, 7));
    }

    public HeadObjectV2Output o(HeadObjectV2Input headObjectV2Input) {
        AbstractC0307c.a(headObjectV2Input, "HeadObjectV2Input");
        k(headObjectV2Input.getBucket());
        AbstractC0307c.c(headObjectV2Input.getKey());
        X6.c cVarC = ((X6.o) this.d).c(headObjectV2Input.getBucket(), headObjectV2Input.getKey(), headObjectV2Input.getAllSettedHeaders());
        ((X6.o) this.d).getClass();
        X6.n nVarA = X6.o.a(cVarC, "HEAD", null);
        A0.b bVar = (A0.b) this.c;
        ArrayList arrayListL = l(headObjectV2Input.getAllSettedHeaders());
        bVar.getClass();
        try {
            TosResponse tosResponseY = bVar.y(nVarA, arrayListL);
            try {
                HeadObjectV2Output headObjectV2Output = new HeadObjectV2Output(new GetObjectBasicOutput().setRequestInfo(tosResponseY.b()).parseFromTosResponse(tosResponseY));
                tosResponseY.close();
                return headObjectV2Output;
            } finally {
            }
        } catch (IOException e) {
            throw new TosClientException("tos: close body failed", e);
        }
    }

    public ListMultipartUploadsV2Output p(ListMultipartUploadsV2Input listMultipartUploadsV2Input) {
        AbstractC0307c.a(listMultipartUploadsV2Input, "ListMultipartUploadsV2Input");
        k(listMultipartUploadsV2Input.getBucket());
        if (listMultipartUploadsV2Input.getMaxUploads() < 0) {
            throw new TosClientException("ListMultipartUploadsV2Input maxUploads is small than 0", null);
        }
        X6.c cVarC = ((X6.o) this.d).c(listMultipartUploadsV2Input.getBucket(), "", null);
        cVarC.d("uploads", "");
        cVarC.d("prefix", listMultipartUploadsV2Input.getPrefix());
        cVarC.d("delimiter", listMultipartUploadsV2Input.getDelimiter());
        cVarC.d("key-marker", listMultipartUploadsV2Input.getKeyMarker());
        cVarC.d("upload-id-marker", listMultipartUploadsV2Input.getUploadIDMarker());
        cVarC.d("max-uploads", a7.f.c(listMultipartUploadsV2Input.getMaxUploads()));
        cVarC.d("encoding-type", listMultipartUploadsV2Input.getEncodingType());
        ((X6.o) this.d).getClass();
        return (ListMultipartUploadsV2Output) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.k(this, 8));
    }

    public ListObjectVersionsV2Output q(ListObjectVersionsV2Input listObjectVersionsV2Input) {
        AbstractC0307c.a(listObjectVersionsV2Input, "ListObjectVersionsV2Input");
        k(listObjectVersionsV2Input.getBucket());
        X6.c cVarC = ((X6.o) this.d).c(listObjectVersionsV2Input.getBucket(), "", null);
        cVarC.d("prefix", listObjectVersionsV2Input.getPrefix());
        cVarC.d("delimiter", listObjectVersionsV2Input.getDelimiter());
        cVarC.d("key-marker", listObjectVersionsV2Input.getKeyMarker());
        cVarC.d("max-keys", a7.f.c(listObjectVersionsV2Input.getMaxKeys()));
        cVarC.d("encoding-type", listObjectVersionsV2Input.getEncodingType());
        cVarC.d("version-id-marker", listObjectVersionsV2Input.getVersionIDMarker());
        cVarC.d("versions", "");
        ((X6.o) this.d).getClass();
        return (ListObjectVersionsV2Output) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.k(this, 0));
    }

    public ListObjectsV2Output r(ListObjectsV2Input listObjectsV2Input) {
        AbstractC0307c.a(listObjectsV2Input, "ListObjectsV2Input");
        k(listObjectsV2Input.getBucket());
        X6.c cVarC = ((X6.o) this.d).c(listObjectsV2Input.getBucket(), "", null);
        cVarC.d("prefix", listObjectsV2Input.getPrefix());
        cVarC.d("delimiter", listObjectsV2Input.getDelimiter());
        cVarC.d("marker", listObjectsV2Input.getMarker());
        cVarC.d("max-keys", a7.f.c(listObjectsV2Input.getMaxKeys()));
        cVarC.d("reverse", String.valueOf(listObjectsV2Input.isReverse()));
        cVarC.d("encoding-type", listObjectsV2Input.getEncodingType());
        ((X6.o) this.d).getClass();
        return (ListObjectsV2Output) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.k(this, 11));
    }

    public ListObjectsType2Output s(ListObjectsType2Input listObjectsType2Input) {
        AbstractC0307c.a(listObjectsType2Input, "ListObjectsType2Input");
        k(listObjectsType2Input.getBucket());
        X6.c cVarC = ((X6.o) this.d).c(listObjectsType2Input.getBucket(), "", null);
        cVarC.d("list-type", "2");
        cVarC.d("prefix", listObjectsType2Input.getPrefix());
        cVarC.d("delimiter", listObjectsType2Input.getDelimiter());
        cVarC.d("start-after", listObjectsType2Input.getStartAfter());
        cVarC.d("continuation-token", listObjectsType2Input.getContinuationToken());
        cVarC.d("max-keys", a7.f.c(listObjectsType2Input.getMaxKeys()));
        cVarC.d("encoding-type", listObjectsType2Input.getEncodingType());
        ((X6.o) this.d).getClass();
        return (ListObjectsType2Output) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.h(this, 2));
    }

    public ListPartsOutput t(ListPartsInput listPartsInput) {
        AbstractC0307c.a(listPartsInput, "ListPartsInput");
        AbstractC0307c.a(listPartsInput.getUploadID(), "uploadID");
        k(listPartsInput.getBucket());
        AbstractC0307c.c(listPartsInput.getKey());
        if (listPartsInput.getMaxParts() < 0 || listPartsInput.getPartNumberMarker() < 0) {
            throw new TosClientException("ListPartsInput maxParts or partNumberMarker is small than 0", null);
        }
        X6.c cVarC = ((X6.o) this.d).c(listPartsInput.getBucket(), listPartsInput.getKey(), null);
        cVarC.d("uploadId", listPartsInput.getUploadID());
        cVarC.d("max-parts", a7.f.c(listPartsInput.getMaxParts()));
        cVarC.d("part-number-marker", a7.f.c(listPartsInput.getPartNumberMarker()));
        cVarC.d("encoding-type", listPartsInput.getEncodingType());
        ((X6.o) this.d).getClass();
        return (ListPartsOutput) ((A0.b) this.c).z(X6.o.a(cVarC, "GET", null), 200, new X6.k(this, 3));
    }

    public PutObjectOutput u(PutObjectInput putObjectInput) {
        AbstractC0307c.a(putObjectInput, "PutObjectInput");
        PutObjectBasicInput putObjectBasicInput = putObjectInput.getPutObjectBasicInput();
        InputStream content = putObjectInput.getContent();
        AbstractC0307c.a(putObjectBasicInput, "PutObjectBasicInput");
        k(putObjectBasicInput.getBucket());
        AbstractC0307c.c(putObjectBasicInput.getKey());
        if (content == null) {
            content = new ByteArrayInputStream("".getBytes());
        }
        X6.c cVarC = ((X6.o) this.d).c(putObjectBasicInput.getBucket(), putObjectBasicInput.getKey(), putObjectBasicInput.getAllSettedHeaders());
        cVarC.h = putObjectBasicInput.getContentLength();
        cVarC.c("x-tos-callback", putObjectBasicInput.getCallback());
        cVarC.c("x-tos-callback-var", putObjectBasicInput.getCallbackVar());
        b(cVarC, putObjectBasicInput.getKey());
        ((X6.o) this.d).getClass();
        X6.n nVarA = X6.o.a(cVarC, "PUT", content);
        nVarA.i = this.b;
        putObjectBasicInput.getRateLimiter();
        putObjectBasicInput.getDataTransferListener();
        nVarA.l = putObjectBasicInput.getReadLimit();
        boolean z10 = content.markSupported() || (content instanceof FileInputStream);
        nVarA.h = z10;
        nVarA.g = z10;
        return (PutObjectOutput) ((A0.b) this.c).z(nVarA, 200, new X6.k(this, 5));
    }

    public PutObjectACLOutput v(PutObjectACLInput putObjectACLInput) {
        AbstractC0307c.a(putObjectACLInput, "PutObjectACLInput");
        k(putObjectACLInput.getBucket());
        AbstractC0307c.c(putObjectACLInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(putObjectACLInput.getBucket(), putObjectACLInput.getKey(), null);
        cVarC.d("acl", "");
        cVarC.c("X-Tos-Acl", putObjectACLInput.getAcl() != null ? putObjectACLInput.getAcl().f4219a : null);
        cVarC.c("X-Tos-Grant-Full-Control", putObjectACLInput.getGrantFullControl());
        cVarC.c("X-Tos-Grant-Read", putObjectACLInput.getGrantRead());
        cVarC.c("X-Tos-Grant-Read-Acp", putObjectACLInput.getGrantReadAcp());
        cVarC.c("X-Tos-Grant-Write-Acp", putObjectACLInput.getGrantWriteAcp());
        byte[] bArr = new byte[0];
        if (putObjectACLInput.getObjectAclRules() != null) {
            F.g gVarC = AbstractC0308d.c(putObjectACLInput.getObjectAclRules());
            bArr = (byte[]) gVarC.c;
            cVarC.c("Content-MD5", (String) gVarC.b);
        }
        X6.o oVar = (X6.o) this.d;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        oVar.getClass();
        X6.n nVarA = X6.o.a(cVarC, "PUT", byteArrayInputStream);
        nVarA.f = bArr.length;
        return (PutObjectACLOutput) ((A0.b) this.c).z(nVarA, 200, new X6.h(5));
    }

    public SetObjectMetaOutput w(SetObjectMetaInput setObjectMetaInput) {
        AbstractC0307c.a(setObjectMetaInput, "SetObjectMetaInput");
        k(setObjectMetaInput.getBucket());
        AbstractC0307c.c(setObjectMetaInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(setObjectMetaInput.getBucket(), setObjectMetaInput.getKey(), setObjectMetaInput.getAllSettedHeaders());
        cVarC.d("metadata", "");
        b(cVarC, setObjectMetaInput.getKey());
        ((X6.o) this.d).getClass();
        return (SetObjectMetaOutput) ((A0.b) this.c).z(X6.o.a(cVarC, "POST", null), 200, new X6.h(8));
    }

    public void x(String... tlsVersions) {
        kotlin.jvm.internal.k.f(tlsVersions, "tlsVersions");
        if (!this.f649a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (tlsVersions.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.d = (String[]) tlsVersions.clone();
    }

    public void y(TlsVersion... tlsVersionArr) {
        if (!this.f649a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(tlsVersionArr.length);
        for (TlsVersion tlsVersion : tlsVersionArr) {
            arrayList.add(tlsVersion.f5465a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        x((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public UploadPartV2Output z(UploadPartV2Input uploadPartV2Input) {
        AbstractC0307c.a(uploadPartV2Input, "UploadPartV2Input");
        UploadPartBasicInput uploadPartBasicInput = uploadPartV2Input.getUploadPartBasicInput();
        long contentLength = uploadPartV2Input.getContentLength();
        InputStream content = uploadPartV2Input.getContent();
        AbstractC0307c.a(uploadPartBasicInput, "UploadPartBasicInput");
        AbstractC0307c.a(uploadPartBasicInput.getUploadID(), "uploadID");
        AbstractC0307c.a(content, "InputStream");
        int partNumber = uploadPartBasicInput.getPartNumber();
        boolean z10 = true;
        if (partNumber < 1 || partNumber > 10000) {
            throw new TosClientException("part number should be between [1, 10000]", null);
        }
        k(uploadPartBasicInput.getBucket());
        AbstractC0307c.c(uploadPartBasicInput.getKey());
        X6.c cVarC = ((X6.o) this.d).c(uploadPartBasicInput.getBucket(), uploadPartBasicInput.getKey(), uploadPartBasicInput.getAllSettedHeaders());
        cVarC.d("uploadId", uploadPartBasicInput.getUploadID());
        cVarC.d("partNumber", a7.f.c(uploadPartBasicInput.getPartNumber()));
        cVarC.h = contentLength;
        ((X6.o) this.d).getClass();
        X6.n nVarA = X6.o.a(cVarC, "PUT", content);
        nVarA.i = this.b;
        uploadPartBasicInput.getRateLimiter();
        uploadPartBasicInput.getDataTransferListener();
        nVarA.l = uploadPartBasicInput.getReadLimit();
        if (!content.markSupported() && !(content instanceof FileInputStream)) {
            z10 = false;
        }
        nVarA.h = z10;
        nVarA.g = z10;
        return (UploadPartV2Output) ((A0.b) this.c).z(nVarA, 200, new A6.a(2, this, uploadPartBasicInput));
    }
}
