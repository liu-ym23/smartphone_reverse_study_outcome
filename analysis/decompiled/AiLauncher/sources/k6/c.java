package k6;

import Y8.h;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import java.util.Collection;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lk6/c;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "", "Lk6/d;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "", "e", "()Z", "", "timeMs", "f", "(J)Z", "TAG", "Ljava/lang/String;", "SP_NAME", "KEY_SCHEDULES", "KEY_ENABLED", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "sp$delegate", "LY8/h;", Const.INTENT_KEY_UMID, "()Landroid/content/SharedPreferences;", "sp", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final String KEY_ENABLED = "sleep_enabled";
    private static final String KEY_SCHEDULES = "sleep_schedules_json";
    private static final String SP_NAME = "sleep_mode";
    private static final String TAG = "SleepModeStore";
    public static final c INSTANCE = new c();

    /* renamed from: sp$delegate, reason: from kotlin metadata */
    private static final h sp = C4848b.b(new InterfaceC5063a() { // from class: k6.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return c.h();
        }
    });

    public static /* synthetic */ boolean g(c cVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = System.currentTimeMillis();
        }
        return cVar.f(j10);
    }

    public static final SharedPreferences h() {
        return C3197a.INSTANCE.a().getSharedPreferences(SP_NAME, 0);
    }

    public final List<SleepSchedule> b() {
        return SleepSchedule.INSTANCE.a(c());
    }

    public final String c() {
        String string = d().getString(KEY_SCHEDULES, "[]");
        return string == null ? "[]" : string;
    }

    public final SharedPreferences d() {
        return (SharedPreferences) sp.getValue();
    }

    public final boolean e() {
        return d().getBoolean(KEY_ENABLED, false);
    }

    public final boolean f(long timeMs) {
        List<SleepSchedule> listB = b();
        if ((listB instanceof Collection) && listB.isEmpty()) {
            return false;
        }
        for (SleepSchedule sleepSchedule : listB) {
            if (sleepSchedule.getEnabled() && sleepSchedule.b(timeMs)) {
                return true;
            }
        }
        return false;
    }
}
