package X6;

import F9.C0234l;
import a.AbstractC0291a;
import a7.AbstractC0308d;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.object.AppendObjectOutput;
import com.volcengine.tos.model.object.CopyObjectV2Output;
import com.volcengine.tos.model.object.DeleteMultiObjectsV2Output;
import com.volcengine.tos.model.object.FetchObjectOutput;
import com.volcengine.tos.model.object.GetObjectACLV2Output;
import com.volcengine.tos.model.object.GetObjectTaggingOutput;
import com.volcengine.tos.model.object.ListMultipartUploadsV2Output;
import com.volcengine.tos.model.object.ListObjectVersionsV2Output;
import com.volcengine.tos.model.object.ListObjectsV2Output;
import com.volcengine.tos.model.object.ListPartsOutput;
import com.volcengine.tos.model.object.PutFetchTaskOutput;
import com.volcengine.tos.model.object.PutObjectOutput;
import java.io.IOException;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1515a;
    public final /* synthetic */ C0234l b;

    public /* synthetic */ k(C0234l c0234l, int i) {
        this.f1515a = i;
        this.b = c0234l;
    }

    @Override // X6.a
    public final Object c(TosResponse tosResponse) throws IOException, NumberFormatException {
        int i = this.f1515a;
        this.b.getClass();
        switch (i) {
            case 0:
                return ((ListObjectVersionsV2Output) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 1:
                String strC = tosResponse.c("X-Tos-Next-Append-Offset");
                try {
                    return new AppendObjectOutput().setRequestInfo(tosResponse.b()).setNextAppendOffset(Long.parseLong(strC)).setHashCrc64ecma(tosResponse.c("x-tos-hash-crc64ecma"));
                } catch (NumberFormatException e) {
                    throw new TosClientException(B7.a.k("tos: server return unexpected Next-Append-Offset header: ", strC), e);
                }
            case 2:
                String strI = AbstractC0291a.I(tosResponse.d, "copy result");
                try {
                    return ((CopyObjectV2Output) AbstractC0308d.b(strI, new e())).setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id")).setSourceVersionID(tosResponse.c("X-Tos-Copy-Source-Version-Id")).setHashCrc64ecma(tosResponse.c("x-tos-hash-crc64ecma"));
                } catch (TosClientException unused) {
                    if (AbstractC0308d.b(strI, new e()) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                }
            case 3:
                return ((ListPartsOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 4:
                return ((DeleteMultiObjectsV2Output) AbstractC0308d.a(tosResponse.d, new e())).requestInfo(tosResponse.b());
            case 5:
                return new PutObjectOutput().setRequestInfo(tosResponse.b()).setEtag(tosResponse.c("ETag")).setVersionID(tosResponse.c("X-Tos-Version-Id")).setHashCrc64ecma(tosResponse.c("x-tos-hash-crc64ecma")).setSseCustomerAlgorithm(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Algorithm")).setSseCustomerKeyMD5(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key-MD5")).setSseCustomerKey(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key")).setCallbackResult(AbstractC0291a.I(tosResponse.d, "callbackResult"));
            case 6:
                return ((PutFetchTaskOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 7:
                return ((GetObjectACLV2Output) AbstractC0308d.a(tosResponse.d, new l())).setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id"));
            case 8:
                return ((ListMultipartUploadsV2Output) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
            case 9:
                return ((GetObjectTaggingOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id"));
            case 10:
                return ((FetchObjectOutput) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id")).setSsecAlgorithm(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Algorithm")).setSsecKeyMD5(tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key-MD5"));
            default:
                return ((ListObjectsV2Output) AbstractC0308d.a(tosResponse.d, new e())).setRequestInfo(tosResponse.b());
        }
    }
}
