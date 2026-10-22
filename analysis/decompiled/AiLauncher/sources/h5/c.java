package h5;

import La.H;
import Y8.t;
import android.app.Application;
import com.stepos.personal.info.IPersonalInfoListener;
import com.stepos.personal.info.PersonalInfoHelper;
import com.stepos.statsapp.v3.InitConfig;
import com.stepos.statsapp.v3.PkgType;
import com.stepos.statsapp.v3.UsageStatsProxy3;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lh5/c;", "", "<init>", "()V", "Landroid/app/Application;", "app", "LY8/t;", "c", "(Landroid/app/Application;)V", "", "TAG", "Ljava/lang/String;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final c INSTANCE = new c();
    private static final String TAG = "Analytics";

    public static final Object d(c cVar, Application application, int i10) {
        Object objB;
        if (i10 != 2) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(K7.c.b(application));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public static final void e(c cVar) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            UsageStatsProxy3.getInstance().refreshDeviceInfo();
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "refreshDeviceInfo failed", thE, false, 8, null);
        }
    }

    public final void c(final Application app) {
        Object objB;
        Object objB2;
        p.i(app, "app");
        try {
            Result.Companion companion = Result.INSTANCE;
            PersonalInfoHelper.setPersonalInfoListener(new IPersonalInfoListener() { // from class: h5.a
                @Override // com.stepos.personal.info.IPersonalInfoListener
                public final Object onOutputInfo(int i10) {
                    return c.d(this.f32960a, app, i10);
                }
            });
            InitConfig printLog = new InitConfig().setPrintLog(false);
            if (H.x0("20014154")) {
                C4148a.u(TAG, "analytics APP_ID 为空占位，事件会被平台丢弃；待业务填入真实 appId 后生效", false, 4, null);
            }
            UsageStatsProxy3.init(app, PkgType.APP, printLog, "20014154", "StepOS");
            try {
                K7.c.c(app, new K7.a() { // from class: h5.b
                    @Override // K7.a
                    public final void a() {
                        c.e(this.f32962a);
                    }
                });
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                C4148a.t(TAG, "setOAIDChangeListener failed", thE, false, 8, null);
            }
            objB = Result.b(Integer.valueOf(C4148a.d(TAG, "UsageStatsProxy3 init done, channel=StepOS", false, 4, null)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            C4148a.t(TAG, "analytics init failed", thE2, false, 8, null);
        }
    }
}
