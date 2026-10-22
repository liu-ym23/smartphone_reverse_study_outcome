package t0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l.h f5439a = new l.h();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5440b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static p0.b f5441c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? j.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static p0.b b() {
        p0.b bVar = new p0.b(5);
        f5441c = bVar;
        l.h hVar = f5439a;
        hVar.getClass();
        if (l.g.f3721f.i(hVar, null, bVar)) {
            l.g.b(hVar);
        }
        return f5441c;
    }

    public static void c(Context context, boolean z) {
        k kVarA;
        int i8;
        if (z || f5441c == null) {
            synchronized (f5440b) {
                if (!z) {
                    try {
                        if (f5441c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                int i9 = 0;
                boolean z2 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z8 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            kVarA = k.a(file3);
                        } catch (IOException unused) {
                            b();
                            return;
                        }
                    } else {
                        kVarA = null;
                    }
                    if (kVarA != null && kVarA.f5438c == jA && (i8 = kVarA.f5437b) != 2) {
                        i9 = i8;
                    } else if (z2) {
                        i9 = 1;
                    } else if (z8) {
                        i9 = 2;
                    }
                    if (z && z8 && i9 != 1) {
                        i9 = 2;
                    }
                    if (kVarA != null && kVarA.f5437b == 2 && i9 == 1 && length < kVarA.d) {
                        i9 = 3;
                    }
                    k kVar = new k(1, i9, jA, length2);
                    if (kVarA == null || !kVarA.equals(kVar)) {
                        try {
                            kVar.b(file3);
                        } catch (IOException unused2) {
                        }
                    }
                    b();
                } catch (PackageManager.NameNotFoundException unused3) {
                    b();
                }
            }
        }
    }
}
