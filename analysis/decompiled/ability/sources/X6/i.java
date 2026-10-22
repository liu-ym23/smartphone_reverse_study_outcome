package X6;

import F9.C0234l;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosServerException;
import com.volcengine.tos.UnexpectedStatusCodeException;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.object.CopyObjectOutput;
import com.volcengine.tos.model.object.CopyObjectV2Input;
import com.volcengine.tos.model.object.CopyObjectV2Output;
import com.volcengine.tos.model.object.ObjectMetaRequestOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import k2.C1621a;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final C1621a f1513a;
    public final C0234l b;
    public final j c;
    public final M0.k d;

    public i(C1621a c1621a, C0234l c0234l, j jVar, M0.k kVar) {
        AbstractC0307c.a(c1621a, "TosBucketRequestHandler");
        AbstractC0307c.a(c0234l, "TosObjectRequestHandler");
        AbstractC0307c.a(jVar, "TosFileRequestHandler");
        AbstractC0307c.a(kVar, "TosPreSignedRequestHandler");
        A0.b bVar = (A0.b) c0234l.c;
        AbstractC0307c.a(bVar != null ? (B1.b) bVar.b : null, "Transport");
        AbstractC0307c.a((o) c0234l.d, "TosFactory");
        this.f1513a = c1621a;
        this.b = c0234l;
        this.c = jVar;
        this.d = kVar;
    }

    public final CopyObjectOutput a(CopyObjectV2Input copyObjectV2Input, f... fVarArr) {
        AbstractC0307c.a(copyObjectV2Input, "CopyObjectV2Input");
        if (fVarArr != null && fVarArr.length > 0) {
            HashMap map = new HashMap(1);
            if (fVarArr.length > 0) {
                f fVar = fVarArr[0];
                throw null;
            }
            if (map.size() > 0) {
                copyObjectV2Input.setOptions(new ObjectMetaRequestOptions().setHeaders(map));
            }
        }
        CopyObjectV2Output copyObjectV2OutputG = this.b.g(copyObjectV2Input);
        return new CopyObjectOutput().setRequestInfo(copyObjectV2OutputG.getRequestInfo()).setEtag(copyObjectV2OutputG.getEtag()).setCrc64(copyObjectV2OutputG.getHashCrc64ecma()).setVersionID(copyObjectV2OutputG.getVersionID()).setLastModified(copyObjectV2OutputG.getLastModified()).setSourceVersionID(copyObjectV2OutputG.getSourceVersionID());
    }

    public final TosResponse b(n nVar) throws IOException {
        try {
            try {
                A0.b bVar = (A0.b) this.b.c;
                TosResponse tosResponseK = (bVar != null ? (B1.b) bVar.b : null).k(nVar);
                InputStream inputStream = nVar.k;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        a7.f.e.j(e.toString(), "tos: close request body failed, {}");
                    }
                }
                int i = tosResponseK.f4236a;
                if (i == 200) {
                    return tosResponseK;
                }
                if (i >= 400) {
                    String strI = AbstractC0291a.I(tosResponseK.d, "response body");
                    if (strI.length() > 0) {
                        try {
                            if (a7.f.b.readValue(strI, new e()) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (JsonProcessingException e6) {
                            if (tosResponseK.f4236a == 400) {
                                throw new TosClientException("bad request, ".concat(strI), null);
                            }
                            throw new TosClientException("parse server exception failed", e6);
                        }
                    }
                    int i6 = tosResponseK.f4236a;
                    if (i6 == 404) {
                        throw new TosServerException(tosResponseK.f4236a, "NotFound", "", tosResponseK.f(), "");
                    }
                    if (i6 == 403) {
                        throw new TosServerException(tosResponseK.f4236a, "Forbidden", "", tosResponseK.f(), "");
                    }
                }
                throw new UnexpectedStatusCodeException(tosResponseK.f4236a, 200, tosResponseK.f());
            } catch (Throwable th) {
                InputStream inputStream2 = nVar.k;
                if (inputStream2 == null) {
                    throw th;
                }
                try {
                    inputStream2.close();
                    throw th;
                } catch (IOException e9) {
                    a7.f.e.j(e9.toString(), "tos: close request body failed, {}");
                    throw th;
                }
            }
        } catch (IOException e10) {
            throw new TosClientException("request exception", e10);
        }
    }
}
