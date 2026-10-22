package E0;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final int f1293a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1294b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f1295c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1296d;

    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        static final int f1297i = 1;

        /* renamed from: a, reason: collision with root package name */
        final Context f1298a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f1299b;

        /* renamed from: c, reason: collision with root package name */
        c f1300c;

        /* renamed from: e, reason: collision with root package name */
        float f1302e;

        /* renamed from: d, reason: collision with root package name */
        float f1301d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        float f1303f = 0.4f;

        /* renamed from: g, reason: collision with root package name */
        float f1304g = 0.33f;

        /* renamed from: h, reason: collision with root package name */
        int f1305h = 4194304;

        public a(Context context) {
            this.f1302e = f1297i;
            this.f1298a = context;
            this.f1299b = (ActivityManager) context.getSystemService("activity");
            this.f1300c = new b(context.getResources().getDisplayMetrics());
            if (i.e(this.f1299b)) {
                this.f1302e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f1306a;

        b(DisplayMetrics displayMetrics) {
            this.f1306a = displayMetrics;
        }

        @Override // E0.i.c
        public int a() {
            return this.f1306a.heightPixels;
        }

        @Override // E0.i.c
        public int b() {
            return this.f1306a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f1295c = aVar.f1298a;
        int i5 = e(aVar.f1299b) ? aVar.f1305h / 2 : aVar.f1305h;
        this.f1296d = i5;
        int iC = c(aVar.f1299b, aVar.f1303f, aVar.f1304g);
        float fB = aVar.f1300c.b() * aVar.f1300c.a() * 4;
        int iRound = Math.round(aVar.f1302e * fB);
        int iRound2 = Math.round(fB * aVar.f1301d);
        int i6 = iC - i5;
        int i7 = iRound2 + iRound;
        if (i7 <= i6) {
            this.f1294b = iRound2;
            this.f1293a = iRound;
        } else {
            float f5 = i6;
            float f6 = aVar.f1302e;
            float f7 = aVar.f1301d;
            float f8 = f5 / (f6 + f7);
            this.f1294b = Math.round(f7 * f8);
            this.f1293a = Math.round(f8 * aVar.f1302e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f1294b));
            sb.append(", pool size: ");
            sb.append(f(this.f1293a));
            sb.append(", byte array size: ");
            sb.append(f(i5));
            sb.append(", memory class limited? ");
            sb.append(i7 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.f1299b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f1299b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f5, float f6) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f5 = f6;
        }
        return Math.round(memoryClass * f5);
    }

    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i5) {
        return Formatter.formatFileSize(this.f1295c, i5);
    }

    public int a() {
        return this.f1296d;
    }

    public int b() {
        return this.f1293a;
    }

    public int d() {
        return this.f1294b;
    }
}
