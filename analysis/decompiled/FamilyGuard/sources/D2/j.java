package D2;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    private static j f1189c;

    /* renamed from: a, reason: collision with root package name */
    private final i<String, Drawable> f1190a = new w();

    /* renamed from: b, reason: collision with root package name */
    private final i<String, Drawable> f1191b = new w();

    private j() {
    }

    public static synchronized j a() {
        try {
            if (f1189c == null) {
                f1189c = new j();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1189c;
    }

    public i<String, Drawable> b() {
        return this.f1190a;
    }

    public i<String, Drawable> c() {
        return this.f1191b;
    }

    public void d() {
        R1.a.a("CacheManager", "onLowMemory");
        this.f1190a.a();
        this.f1191b.a();
    }

    public void e(int i5) {
        R1.a.a("CacheManager", "onTrimMemory level = " + i5);
        this.f1190a.a();
        this.f1191b.a();
    }
}
