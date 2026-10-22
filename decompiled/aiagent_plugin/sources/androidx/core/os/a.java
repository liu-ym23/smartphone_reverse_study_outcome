package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import d.h.b.o;
import java.util.Locale;

/* JADX INFO: compiled from: BuildCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1253b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1254c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1255d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1256e = 0;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuildCompat.kt */
    private static final class C0031a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0031a f1257a = null;

        static {
            f1257a = new C0031a();
        }

        private C0031a() {
        }

        public final int a(int r1) {
            return SdkExtensions.getExtensionVersion(r1);
        }
    }

    private a() {
    }

    public static final boolean a(String r3, String r4) {
        o.e(r3, "codename");
        o.e(r4, "buildCodename");
        if (o.a("REL", r4) == false) goto L5;
        return false;
    L5:
        String r5 = r4.toUpperCase(Locale.ROOT);
        o.c(r5, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String r6 = r3.toUpperCase(Locale.ROOT);
        o.c(r6, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (r5.compareTo(r6) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean a() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 32) goto L9;
        String r0 = Build.VERSION.CODENAME;
        o.c(r0, "CODENAME");
        if (a("Tiramisu", r0) == true) goto L10;
    L9:
        return false;
    }

    public static final boolean b() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        String r0 = Build.VERSION.CODENAME;
        o.c(r0, "CODENAME");
        if (a("VanillaIceCream", r0) == false) goto L7;
        return true;
    L7:
        return false;
    }

    static {
        f1252a = new a();
        int r1 = 0;
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r0 = C0031a.f1257a.a(30);
    L6:
        f1253b = r0;
        if (Build.VERSION.SDK_INT < 30) goto L9;
        int r2 = C0031a.f1257a.a(31);
    L10:
        f1254c = r2;
        if (Build.VERSION.SDK_INT < 30) goto L13;
        int r3 = C0031a.f1257a.a(33);
    L14:
        f1255d = r3;
        if (Build.VERSION.SDK_INT < 30) goto L17;
        r1 = C0031a.f1257a.a(1000000);
    L17:
        f1256e = r1;
        return;
    L13:
        r3 = 0;
        goto L14
    L9:
        r2 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }
}
