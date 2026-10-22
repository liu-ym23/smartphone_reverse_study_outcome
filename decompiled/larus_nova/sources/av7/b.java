package av7;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f16383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f16384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f16385c;

    public static boolean a(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (f16383a != null) goto L12;
        if (PlatformVersion.isAtLeastKitKatWatch() == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        f16383a = Boolean.valueOf(r102);
        goto L12
    L7:
        if (r101.hasSystemFeature("android.hardware.type.watch") == false) goto L9;
        r102 = true;
    L12:
        if (f16383a.booleanValue() == false) goto L16;
        if (PlatformVersion.isAtLeastN() == true) goto L16;
    L21:
        return true;
    L16:
        if (b(r100) == true) goto L18;
    L22:
        return false;
    L18:
        if (PlatformVersion.isAtLeastO() == false) goto L21;
        if (PlatformVersion.isAtLeastR() == false) goto L22;
        goto L21
    }

    public static boolean b(Context r100) {
        if (f16384b != null) goto L11;
        boolean r101 = false;
        if (PlatformVersion.isAtLeastLollipop() == true) goto L7;
    L9:
        f16384b = Boolean.valueOf(r101);
        goto L11
    L7:
        if (r100.getPackageManager().hasSystemFeature("cn.google") == false) goto L9;
        r101 = true;
    L11:
        return f16384b.booleanValue();
    }
}
