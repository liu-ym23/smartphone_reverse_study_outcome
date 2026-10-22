package Z7;

import android.content.Context;
import com.tencent.bugly.proguard.as;

/* renamed from: Z7.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1146s {

    /* renamed from: e, reason: collision with root package name */
    public static C1146s f7608e;

    /* renamed from: a, reason: collision with root package name */
    public C1131c f7609a;

    /* renamed from: b, reason: collision with root package name */
    public C1130b f7610b;

    /* renamed from: c, reason: collision with root package name */
    public as f7611c;

    /* renamed from: d, reason: collision with root package name */
    public Context f7612d;

    /* renamed from: Z7.s$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1146s.b(C1146s.this);
        }
    }

    public C1146s(Context context) {
        r rVarA = r.a();
        if (rVarA == null) {
            return;
        }
        this.f7609a = C1131c.a();
        this.f7610b = C1130b.h(context);
        this.f7611c = rVarA.f7598b;
        this.f7612d = context;
        C1138j.a().b(new a());
    }

    public static C1146s a(Context context) {
        if (f7608e == null) {
            f7608e = new C1146s(context);
        }
        return f7608e;
    }

    public static /* synthetic */ void b(C1146s c1146s) {
        C1139k.h("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            c1146s.f7610b.getClass();
            C1143o.s(cls, "sdkPackageName", "com.tencent.bugly");
            C1139k.h("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C1139k.d("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }
}
