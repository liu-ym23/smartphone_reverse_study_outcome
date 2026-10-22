package os.teatracker;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: TeaAgent.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: compiled from: TeaAgent.java */
    public interface a {
        void a(os.teatracker.a r1);
    }

    /* JADX INFO: compiled from: TeaAgent.java */
    public interface b {
        void a(String r1);

        void b(String r1);
    }

    public static void a(Context r2, e r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        TeaHandler.d().a(r4, r3);
    }

    public static void a(String r2, JSONObject r3) {
        a();
        TeaHandler.d().a(new g(r2, h.a(r3)));
    }

    private static void a() {
        e r0 = TeaHandler.d().e();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.a()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("You must first call method init to provide an appId via TeaConfig param.");
    }
}
