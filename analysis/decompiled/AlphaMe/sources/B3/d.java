package B3;

import java.security.AccessController;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f223a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f224b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION", true, System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new c())).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        f223a = iIntValue;
        f224b = iIntValue != 0;
    }
}
