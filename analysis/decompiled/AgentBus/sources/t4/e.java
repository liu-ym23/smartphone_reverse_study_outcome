package t4;

import c7.j;
import com.stepos.zeroclaw.ipc.IZeroClawCallback;
import com.stepos.zeroclaw.ipc.Message;
import com.stepos.zeroclaw.ipc.Reply;
import d7.a0;
import d7.e0;
import ia.r;
import ia.s;
import java.util.concurrent.ConcurrentHashMap;
import la.j0;
import org.json.JSONObject;
import q7.k;

/* loaded from: classes.dex */
public final class e extends IZeroClawCallback.Stub {

    /* renamed from: c, reason: collision with root package name */
    public final j0 f9734c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f9735d = new ConcurrentHashMap();

    public e(j0 j0Var) {
        this.f9734c = j0Var;
    }

    @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
    public final void onAsyncReply(int i2, Reply reply) {
        k.e(reply, "reply");
        r rVar = (r) this.f9735d.remove(Integer.valueOf(i2));
        if (rVar != null) {
            String strC = n.f.c(i2, "async-");
            k.e(strC, "id");
            ((s) rVar).X(n7.a.C(new c5.b("req", e0.U(new j("type", "req"), new j("id", strC), new j("method", "chat.send"), new j("params", a0.f2944f))), reply));
        }
    }

    @Override // com.stepos.zeroclaw.ipc.IZeroClawCallback
    public final void onEvent(Message message) {
        k.e(message, "event");
        JSONObject jSONObject = new JSONObject(message.getFrameJson());
        String strOptString = jSONObject.optString("type", "event");
        k.d(strOptString, "optString(...)");
        this.f9734c.M(new c5.b(strOptString, n7.a.p(jSONObject)));
    }
}
