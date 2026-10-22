package q;

import La.D;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0006J\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006J\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0006J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0006J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0006J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0006J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0006J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0006J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u0004*\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lq/d;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "m", "n", "o", "p", "q", "t", "s", "l", "r", "", "vendor", "c", "(Ljava/lang/String;)Z", "other", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f38469a = new d();

    public final boolean a(String str, String str2) {
        return D.L(str, str2, true);
    }

    public final boolean b() {
        return c("Blu");
    }

    public final boolean c(String vendor) {
        String MANUFACTURER = Build.MANUFACTURER;
        p.h(MANUFACTURER, "MANUFACTURER");
        if (a(MANUFACTURER, vendor)) {
            return true;
        }
        String BRAND = Build.BRAND;
        p.h(BRAND, "BRAND");
        return a(BRAND, vendor);
    }

    public final boolean d() {
        return c("Google");
    }

    public final boolean e() {
        return c("Huawei");
    }

    public final boolean f() {
        return c("Itel");
    }

    public final boolean g() {
        return c("Jio");
    }

    public final boolean h() {
        return c("Motorola");
    }

    public final boolean i() {
        return c("Nokia");
    }

    public final boolean j() {
        return c("OnePlus");
    }

    public final boolean k() {
        return c("Oppo");
    }

    public final boolean l() {
        return c("Poco");
    }

    public final boolean m() {
        return c("Positivo");
    }

    public final boolean n() {
        return c("Redmi");
    }

    public final boolean o() {
        return c("Samsung");
    }

    public final boolean p() {
        return c("Sony");
    }

    public final boolean q() {
        return c("Tecno") || c("Tecno-mobile");
    }

    public final boolean r() {
        if (!D.L("Spreadtrum", Build.SOC_MANUFACTURER, true)) {
            String HARDWARE = Build.HARDWARE;
            p.h(HARDWARE, "HARDWARE");
            Locale locale = Locale.ROOT;
            String lowerCase = HARDWARE.toLowerCase(locale);
            p.h(lowerCase, "toLowerCase(...)");
            if (!D.X(lowerCase, "ums", false, 2, null)) {
                if (f()) {
                    p.h(HARDWARE, "HARDWARE");
                    String lowerCase2 = HARDWARE.toLowerCase(locale);
                    p.h(lowerCase2, "toLowerCase(...)");
                    if (D.X(lowerCase2, "sp", false, 2, null)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean s() {
        return c("Vivo");
    }

    public final boolean t() {
        return c("Xiaomi");
    }
}
