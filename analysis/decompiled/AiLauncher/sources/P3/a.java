package P3;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5372a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f5373b;

    static {
        String str = new String(Base64.decode("aHR0cHM6Ly9oNS5uZi5taWd1LmNuL2FwcC92NS9wL2Rvd25sb2FkLW11c2ljL2luZGV4Lmh0bWw=", 0));
        f5372a = str;
        f5373b = str;
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.startsWith("bridge_sdk_")) {
                    return str.substring(11);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static String b() {
        return f5373b;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f5373b = f5372a + "?cfrom=" + a(str);
    }
}
