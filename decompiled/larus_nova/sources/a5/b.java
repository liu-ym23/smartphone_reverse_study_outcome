package a5;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f1829b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f1830c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Application f1831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f1832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f1833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0013b f1834g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a5.a f1835h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f1840e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f1836a == r101.f1836a) goto L12;
            return false;
        L12:
            if (this.f1837b == r101.f1837b) goto L15;
            return false;
        L15:
            if (this.f1838c == r101.f1838c) goto L18;
            return false;
        L18:
            if (this.f1839d == r101.f1839d) goto L21;
            return false;
        L21:
            if (Float.compare(this.f1840e, r101.f1840e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f1836a * 31) + this.f1837b) * 31) + this.f1838c) * 31) + this.f1839d) * 31) + Float.floatToIntBits(this.f1840e);
        }

        public final String toString() {
            return "DisplaySnapshot(widthPixels=" + this.f1836a + ", heightPixels=" + this.f1837b + ", densityDpi=" + this.f1838c + ", orientation=" + this.f1839d + ", fontScale=" + this.f1840e + ')';
        }

        public a(int r100, int r101, int r102, int r103, float r104) {
            this.f1836a = r100;
            this.f1837b = r101;
            this.f1838c = r102;
            this.f1839d = r103;
            this.f1840e = r104;
        }
    }

    /* JADX INFO: renamed from: a5.b$b, reason: collision with other inner class name */
    public static final class C0013b implements DisplayManager.DisplayListener {
        public C0013b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r100) {
            b r101 = b.f1828a;
            String r102 = "display_changed:" + r100;
            monitor-enter(r101);
            b.f1833f = r102;     // Catch: Throwable -> L7
            Handler r103 = b.f1830c;     // Catch: Throwable -> L7
            a5.a r104 = b.f1835h;     // Catch: Throwable -> L7
            r103.removeCallbacks(r104);     // Catch: Throwable -> L7
            r103.postDelayed(r104, 100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public b() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [a5.a] */
    static {
        f1828a = new b();
        f1829b = new AtomicBoolean(false);
        f1830c = new Handler(Looper.getMainLooper());
        f1833f = "init";
        f1834g = new C0013b();
        f1835h = new a5.a();
    }

    public static a a(Context r100) {
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        Configuration r103 = r101.getConfiguration();
        return new a(r102.widthPixels, r102.heightPixels, r103.densityDpi, r103.orientation, r103.fontScale);
    }
}
