package L5;

import La.H;
import O6.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0013\u0010\rR(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"LL5/b;", "", "<init>", "()V", "", "pkg", "activity", "LY8/t;", "e", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "f", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "trackId", "Ljava/lang/String;", UxipConstants.f30680s, "currentPackage", "c", "currentActivity", Const.INTENT_KEY_PKGNAME, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static volatile String currentActivity;
    private static volatile String currentPackage;
    private static volatile String trackId;

    public final void a() {
        trackId = null;
        currentPackage = null;
        currentActivity = null;
    }

    public final String b() {
        return currentActivity;
    }

    public final String c() {
        return currentPackage;
    }

    public final void d(String activity) {
        if (activity == null || H.x0(activity)) {
            return;
        }
        currentActivity = activity;
    }

    public final void e(String pkg, String activity) {
        p.i(pkg, "pkg");
        if (trackId == null || !p.d(currentPackage, pkg)) {
            trackId = x.INSTANCE.a();
            currentPackage = pkg;
        }
        d(activity);
    }

    public final String f() {
        return trackId;
    }
}
