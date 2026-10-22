package u5;

import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
import m.x;
import org.json.JSONObject;
import w7.e0;

/* loaded from: classes.dex */
public final class m extends NanoHTTPD {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f10148a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(s sVar, int i2) {
        super("127.0.0.1", i2);
        this.f10148a = sVar;
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public final NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) throws UnsupportedEncodingException {
        String strName;
        Object objN;
        q7.k.e(iHTTPSession, "session");
        s sVar = this.f10148a;
        i5.f fVar = sVar.f10170b.f10453s;
        NanoHTTPD.Method method = iHTTPSession.getMethod();
        if (method == null || (strName = method.name()) == null) {
            strName = "GET";
        }
        String uri = iHTTPSession.getUri();
        if (uri == null) {
            uri = "/";
        }
        try {
            if (strName.equals("GET") && uri.equals("/v1/health")) {
                objN = s.j(((a3.b) fVar.f4656j).m());
            } else if (strName.equals("GET") && uri.equals("/v1/diag/connections")) {
                objN = s.j(((a3.b) fVar.f4656j).f());
            } else if (strName.equals("GET") && uri.equals("/v1/diag/metrics")) {
                objN = s.j(((a3.b) fVar.f4656j).o());
            } else if (strName.equals("GET") && uri.equals("/v1/diag/inflight")) {
                a3.b bVar = (a3.b) fVar.f4656j;
                bVar.getClass();
                String string = new JSONObject().put("size", ((h5.g) bVar.f163g).f4206f.size()).toString();
                q7.k.d(string, "toString(...)");
                objN = s.j(string);
            } else if (strName.equals("POST") && uri.equals("/v1/channels/register")) {
                objN = sVar.m(iHTTPSession);
            } else if (strName.equals("POST") && s.f10164j.c(uri)) {
                objN = sVar.d(iHTTPSession, uri);
            } else if (strName.equals("POST") && s.f10166l.c(uri)) {
                objN = sVar.c(iHTTPSession, uri);
            } else if (strName.equals("GET") && s.f10165k.c(uri)) {
                objN = sVar.e(uri);
            } else if (strName.equals("POST") && uri.equals("/v1/nodes/register")) {
                objN = sVar.n(iHTTPSession);
            } else if (strName.equals("GET") && s.f10167m.c(uri)) {
                objN = sVar.h(uri);
            } else if (strName.equals("POST") && s.f10168n.c(uri)) {
                objN = sVar.i(iHTTPSession, uri);
            } else if (strName.equals("POST") && uri.equals("/v1/admin/config/push")) {
                objN = s.g(NanoHTTPD.Response.Status.NOT_FOUND, "{\"error\":\"admin disabled (no coordinator)\"}");
            } else if (strName.equals("GET") && uri.equals("/v1/admin/state")) {
                objN = s.g(NanoHTTPD.Response.Status.NOT_FOUND, "{\"error\":\"admin disabled (no coordinator)\"}");
            } else if (strName.equals("GET") && uri.equals("/v1/admin/debug/gateway-status")) {
                objN = sVar.f();
            } else if (strName.equals("POST") && uri.equals("/v1/admin/debug/system-run")) {
                objN = sVar.b(iHTTPSession);
            } else if (strName.equals("POST") && uri.equals("/v1/admin/debug/agent-call")) {
                objN = sVar.a(iHTTPSession);
            } else {
                if (!strName.equals("POST") || !uri.equals("/v1/privacy/check")) {
                    throw new IllegalStateException(("not found: " + strName + " " + uri).toString());
                }
                objN = sVar.k(iHTTPSession);
            }
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            k5.s.warn$default(sVar.f10172d, "RestApiServer", x.l(strName, " ", uri, " failed: ", thA.getMessage()), null, 4, null);
            NanoHTTPD.Response.Status status = NanoHTTPD.Response.Status.BAD_REQUEST;
            JSONObject jSONObject = new JSONObject();
            String message = thA.getMessage();
            if (message == null) {
                message = "bad request";
            }
            String string2 = jSONObject.put("error", message).toString();
            q7.k.d(string2, "toString(...)");
            objN = s.g(status, string2);
        }
        return (NanoHTTPD.Response) objN;
    }
}
