package g5;

import android.content.Context;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.C2410v;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lg5/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4104a {
    private static final String TAG = "AmapSdkInit";
    public static final C4104a INSTANCE = new C4104a();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    public final boolean a(Context context) {
        Object objB;
        p.i(context, "context");
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.get()) {
            return true;
        }
        synchronized (this) {
            if (atomicBoolean.get()) {
                return true;
            }
            Context applicationContext = context.getApplicationContext();
            try {
                Result.Companion companion = Result.INSTANCE;
                C2410v c2410v = C2410v.INSTANCE;
                p.f(applicationContext);
                c2410v.L(applicationContext);
                ServiceSettings.updatePrivacyShow(applicationContext, true, true);
                ServiceSettings.updatePrivacyAgree(applicationContext, true);
                atomicBoolean.set(true);
                C4148a.k(TAG, "Amap SDK privacy compliance initialized", false, 4, null);
                objB = Result.b(Boolean.TRUE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "Amap SDK init failed", thE, false, 8, null);
                objB = Boolean.FALSE;
            }
            return ((Boolean) objB).booleanValue();
        }
    }
}
