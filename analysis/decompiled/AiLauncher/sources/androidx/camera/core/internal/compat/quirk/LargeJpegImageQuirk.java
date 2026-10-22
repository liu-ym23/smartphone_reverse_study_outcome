package androidx.camera.core.internal.compat.quirk;

import K.s0;
import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class LargeJpegImageQuirk implements s0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f11598b = new HashSet(Arrays.asList("SM-A520F", "SM-A520L", "SM-A520K", "SM-A520S", "SM-A520X", "SM-A520W", "SM-A525F", "SM-A525M", "SM-A705F", "SM-A705FN", "SM-A705GM", "SM-A705MN", "SM-A7050", "SM-A705W", "SM-A705YN", "SM-A705U", "SM-A715F", "SM-A715F/DS", "SM-A715F/DSM", "SM-A715F/DSN", "SM-A715W", "SM-A715X", "SM-A725F", "SM-A725M", "SM-M515F", "SM-M515F/DSN", "SM-G930T", "SM-G930V", "SM-S901B", "SM-S901B/DS", "SM-S906B"));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f11599c = new HashSet(Arrays.asList("V2244A", "V2045", "V2046"));

    public static boolean c() {
        return "Samsung".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean d() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && f11598b.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public static boolean e() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && f11599c.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public static boolean f() {
        return c() || e();
    }

    public boolean g(byte[] bArr) {
        return d() || e() || bArr.length > 10000000;
    }
}
