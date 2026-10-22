package l1;

import a1.C0409b;
import android.content.Context;
import android.graphics.Color;
import j1.C0777a;
import q1.C0980b;

/* renamed from: l1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0831a {

    /* renamed from: f, reason: collision with root package name */
    private static final int f18150f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f18151a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18152b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18153c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18154d;

    /* renamed from: e, reason: collision with root package name */
    private final float f18155e;

    public C0831a(Context context) {
        this(C0980b.b(context, C0409b.f6724k, false), C0777a.b(context, C0409b.f6723j, 0), C0777a.b(context, C0409b.f6722i, 0), C0777a.b(context, C0409b.f6720g, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(int i5) {
        return androidx.core.graphics.a.k(i5, 255) == this.f18154d;
    }

    public float a(float f5) {
        if (this.f18155e <= 0.0f || f5 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f5 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i5, float f5) {
        int i6;
        float fA = a(f5);
        int iAlpha = Color.alpha(i5);
        int iJ = C0777a.j(androidx.core.graphics.a.k(i5, 255), this.f18152b, fA);
        if (fA > 0.0f && (i6 = this.f18153c) != 0) {
            iJ = C0777a.i(iJ, androidx.core.graphics.a.k(i6, f18150f));
        }
        return androidx.core.graphics.a.k(iJ, iAlpha);
    }

    public int c(int i5, float f5) {
        return (this.f18151a && e(i5)) ? b(i5, f5) : i5;
    }

    public boolean d() {
        return this.f18151a;
    }

    public C0831a(boolean z5, int i5, int i6, int i7, float f5) {
        this.f18151a = z5;
        this.f18152b = i5;
        this.f18153c = i6;
        this.f18154d = i7;
        this.f18155e = f5;
    }
}
