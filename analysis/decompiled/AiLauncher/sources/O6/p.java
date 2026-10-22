package O6;

import La.D;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J%\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0013"}, d2 = {"LO6/p;", "", "<init>", "()V", "", "e", "()Ljava/lang/String;", "f", "key", "defaultValue", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "maskId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "osVersion$delegate", "LY8/h;", "c", "osVersion", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    public static final p INSTANCE = new p();

    /* renamed from: osVersion$delegate, reason: from kotlin metadata */
    private static final Y8.h osVersion = C4848b.b(new InterfaceC5063a() { // from class: O6.o
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return p.g();
        }
    });

    public static final String g() {
        return INSTANCE.f();
    }

    public final String b(String maskId) {
        if (!TextUtils.isEmpty(maskId)) {
            kotlin.jvm.internal.p.f(maskId);
            if (D.X(maskId, "16-", false, 2, null)) {
                String strSubstring = maskId.substring(3);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                int length = strSubstring.length() - 1;
                int i10 = 0;
                boolean z10 = false;
                while (i10 <= length) {
                    boolean z11 = kotlin.jvm.internal.p.k(strSubstring.charAt(!z10 ? i10 : length), 32) <= 0;
                    if (z10) {
                        if (!z11) {
                            break;
                        }
                        length--;
                    } else if (z11) {
                        i10++;
                    } else {
                        z10 = true;
                    }
                }
                String string = strSubstring.subSequence(i10, length + 1).toString();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                try {
                    return "16-" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(Long.parseLong(string) * 1000));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public final String c() {
        return (String) osVersion.getValue();
    }

    public final String d(String key, String defaultValue) {
        if (key != null) {
            try {
                String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, key, defaultValue);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public final String e() {
        return c();
    }

    public final String f() {
        try {
            String strD = d("ro.build.aios_version", "");
            String strB = b(strD);
            if (strB != null) {
                return strB;
            }
            if (!TextUtils.isEmpty(strD)) {
                kotlin.jvm.internal.p.f(strD);
                int length = strD.length() - 1;
                int i10 = 0;
                boolean z10 = false;
                while (i10 <= length) {
                    boolean z11 = kotlin.jvm.internal.p.k(strD.charAt(!z10 ? i10 : length), 32) <= 0;
                    if (z10) {
                        if (!z11) {
                            break;
                        }
                        length--;
                    } else if (z11) {
                        i10++;
                    } else {
                        z10 = true;
                    }
                }
                if (!kotlin.jvm.internal.p.d("16-", strD.subSequence(i10, length + 1).toString())) {
                    return strD;
                }
            }
            String DISPLAY = Build.DISPLAY;
            kotlin.jvm.internal.p.h(DISPLAY, "DISPLAY");
            return DISPLAY;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
