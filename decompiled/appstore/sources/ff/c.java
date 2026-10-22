package ff;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19683a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19684b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f19685c = 3;

    static {
    }

    public static boolean a() {
        int r10 = f19683a;
        if (r10 == 3) goto L7;
        if (r10 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r11 = Build.BRAND;
        if (TextUtils.isEmpty(r11) == false) goto L10;
    L12:
        int r12 = 2;
    L13:
        f19683a = r12;
        if (r12 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r11.toLowerCase().contains("oppo") == false) goto L12;
        r12 = 1;
        goto L13
    }

    public static boolean b() {
        int r10 = f19685c;
        if (r10 == 3) goto L7;
        if (r10 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r11 = Build.BRAND;
        if (TextUtils.isEmpty(r11) == false) goto L10;
    L12:
        int r12 = 2;
    L13:
        f19685c = r12;
        if (r12 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r11.toLowerCase().contains("samsung") == false) goto L12;
        r12 = 1;
        goto L13
    }

    public static boolean c() {
        int r10 = f19684b;
        if (r10 == 3) goto L7;
        if (r10 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r11 = Build.HARDWARE;
        if (TextUtils.isEmpty(r11) == false) goto L10;
    L14:
        int r12 = 2;
    L15:
        f19684b = r12;
        if (r12 == 1) goto L18;
        return false;
    L18:
        return true;
    L10:
        if (r11.toLowerCase().contains("hi") == false) goto L12;
    L13:
        r12 = 1;
        goto L15
    L12:
        if (r11.toLowerCase().contains("kirin") == false) goto L14;
        goto L13
    }
}
