package J5;

import L5.b;
import Y8.j;
import Y8.t;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LJ5/a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "textLength", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "c", Const.INTENT_KEY_UMID, "", "filled", "e", "(Z)V", "", "event", "", "extra", "f", "(Ljava/lang/String;Ljava/util/Map;)V", "PAGE", "Ljava/lang/String;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String PAGE = "amoo_express";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(a aVar, String str, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = kotlin.collections.a.i();
        }
        aVar.f(str, map);
    }

    public final void a() {
        g(this, "amoo_express_entry_click", null, 2, null);
    }

    public final void b() {
        g(this, "amoo_express_entry_expose", null, 2, null);
    }

    public final void c() {
        g(this, "amoo_express_generate_start", null, 2, null);
    }

    public final void d() {
        g(this, "amoo_express_generate_success", null, 2, null);
    }

    public final void e(boolean filled) {
        f("amoo_express_output_done", Q.f(j.a("target", filled ? "input_box" : "clipboard")));
    }

    public final void f(String event, Map<String, String> extra) {
        HashMap map = new HashMap();
        b bVar = b.INSTANCE;
        String strF = bVar.f();
        if (strF != null) {
            map.put("amoo_express_id", strF);
        }
        String strC = bVar.c();
        if (strC != null) {
            map.put("pkg", strC);
        }
        map.putAll(extra);
        C4148a.d("Track", event + " page=amoo_express " + map, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            N.a(event, PAGE, map);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void h() {
        g(this, "amoo_express_voice_start", null, 2, null);
    }

    public final void i(int textLength) {
        f("amoo_express_voice_submit", Q.f(j.a("text_length", String.valueOf(textLength))));
    }
}
