package K0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import z0.EnumC1336b;

/* loaded from: classes.dex */
final class l {

    /* renamed from: c, reason: collision with root package name */
    private static final File f3548c = new File("/proc/self/fd");

    /* renamed from: d, reason: collision with root package name */
    private static volatile l f3549d;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f3550a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f3551b = true;

    private l() {
    }

    static l a() {
        if (f3549d == null) {
            synchronized (l.class) {
                try {
                    if (f3549d == null) {
                        f3549d = new l();
                    }
                } finally {
                }
            }
        }
        return f3549d;
    }

    private synchronized boolean b() {
        try {
            boolean z5 = true;
            int i5 = this.f3550a + 1;
            this.f3550a = i5;
            if (i5 >= 50) {
                this.f3550a = 0;
                int length = f3548c.list().length;
                if (length >= 700) {
                    z5 = false;
                }
                this.f3551b = z5;
                if (!this.f3551b && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3551b;
    }

    boolean c(int i5, int i6, BitmapFactory.Options options, EnumC1336b enumC1336b, boolean z5, boolean z6) {
        if (!z5 || z6) {
            return false;
        }
        boolean z7 = i5 >= 128 && i6 >= 128 && b();
        if (z7) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z7;
    }
}
