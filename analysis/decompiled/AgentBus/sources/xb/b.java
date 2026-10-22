package xb;

import java.security.AccessControlException;
import java.security.AccessController;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f11348a = new ThreadLocal();

    public static boolean a(String str) {
        Map map;
        try {
            String str2 = (String) AccessController.doPrivileged(new a(str, 0));
            if (str2 == null && ((map = (Map) f11348a.get()) == null || (str2 = (String) map.get(str)) == null)) {
                str2 = (String) AccessController.doPrivileged(new a(str, 1));
            }
            if (str2 != null && str2.length() == 4 && ((str2.charAt(0) == 't' || str2.charAt(0) == 'T') && ((str2.charAt(1) == 'r' || str2.charAt(1) == 'R') && (str2.charAt(2) == 'u' || str2.charAt(2) == 'U')))) {
                if (str2.charAt(3) != 'e') {
                    if (str2.charAt(3) == 'E') {
                    }
                }
                return true;
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }
}
