package g0;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import s.AbstractC0840j;
import s.C0841k;

/* renamed from: g0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0571k {

    /* renamed from: a, reason: collision with root package name */
    public static final C0841k f12651a = new C0841k();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f12652b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static y1.f f12653c = null;

    public static void a(Context context, boolean z4) {
        C0570j c0570jA;
        int i4;
        if (z4 || f12653c == null) {
            synchronized (f12652b) {
                if (!z4) {
                    try {
                        if (f12653c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z5 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z6 = file2.exists() && length2 > 0;
                try {
                    long j4 = AbstractC0569i.a(context.getApplicationContext().getPackageManager(), context).lastUpdateTime;
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            c0570jA = C0570j.a(file3);
                        } catch (IOException unused) {
                            y1.f fVar = new y1.f();
                            f12653c = fVar;
                            C0841k c0841k = f12651a;
                            c0841k.getClass();
                            if (AbstractC0840j.f14143f.g(c0841k, null, fVar)) {
                                AbstractC0840j.c(c0841k);
                            }
                            return;
                        }
                    } else {
                        c0570jA = null;
                    }
                    int i5 = (c0570jA == null || c0570jA.f12649c != j4 || (i4 = c0570jA.f12648b) == 2) ? z5 ? 1 : z6 ? 2 : 0 : i4;
                    if (z4 && z6 && i5 != 1) {
                        i5 = 2;
                    }
                    C0570j c0570j = new C0570j(j4, 1, length2, (c0570jA == null || c0570jA.f12648b != 2 || i5 != 1 || length >= c0570jA.f12650d) ? i5 : 3);
                    if (c0570jA == null || !c0570jA.equals(c0570j)) {
                        try {
                            c0570j.b(file3);
                        } catch (IOException unused2) {
                        }
                    }
                    y1.f fVar2 = new y1.f();
                    f12653c = fVar2;
                    C0841k c0841k2 = f12651a;
                    c0841k2.getClass();
                    if (AbstractC0840j.f14143f.g(c0841k2, null, fVar2)) {
                        AbstractC0840j.c(c0841k2);
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    y1.f fVar3 = new y1.f();
                    f12653c = fVar3;
                    C0841k c0841k3 = f12651a;
                    c0841k3.getClass();
                    if (AbstractC0840j.f14143f.g(c0841k3, null, fVar3)) {
                        AbstractC0840j.c(c0841k3);
                    }
                }
            }
        }
    }
}
