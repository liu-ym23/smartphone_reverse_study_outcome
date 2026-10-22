package Cc;

import android.graphics.Color;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f1967b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f1968c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f1969d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f1970e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f1971f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f1972g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f1973h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f1974i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f1975j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f1976k;

    /* renamed from: a, reason: collision with root package name */
    public final int f1977a;

    static {
        c cVar = new c(-16777216);
        f1967b = cVar;
        f1968c = new c(-1);
        c cVar2 = new c(-65536);
        f1969d = cVar2;
        f1970e = new c(-16711936);
        f1971f = new c(-16776961);
        f1972g = new c(Color.parseColor("cyan"));
        f1973h = new c(Color.parseColor("magenta"));
        f1974i = new c(Color.parseColor("yellow"));
        f1975j = cVar;
        f1976k = cVar2;
    }

    public c(int i10) {
        this.f1977a = i10;
    }

    public static c a(String str) {
        return new c(Color.parseColor(str));
    }

    public int b() {
        return this.f1977a;
    }

    public c(int i10, int i11, int i12) {
        this(Color.rgb(i10, i11, i12));
    }

    public c(float f10, float f11, float f12) {
        this((int) ((f10 * 255.0f) + 0.5f), (int) ((f11 * 255.0f) + 0.5f), (int) ((f12 * 255.0f) + 0.5f));
    }
}
