package P2;

import W2.b;
import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import t0.C5502d;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f5366f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5367a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5368b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5369c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5370d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5371e;

    public a(Context context) {
        this(b.b(context, R$attr.elevationOverlayEnabled, false), M2.a.b(context, R$attr.elevationOverlayColor, 0), M2.a.b(context, R$attr.elevationOverlayAccentColor, 0), M2.a.b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public float a(float f10) {
        if (this.f5371e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float fA = a(f10);
        int iAlpha = Color.alpha(i10);
        int iJ = M2.a.j(C5502d.k(i10, 255), this.f5368b, fA);
        if (fA > 0.0f && (i11 = this.f5369c) != 0) {
            iJ = M2.a.i(iJ, C5502d.k(i11, f5366f));
        }
        return C5502d.k(iJ, iAlpha);
    }

    public int c(int i10, float f10) {
        return (this.f5367a && e(i10)) ? b(i10, f10) : i10;
    }

    public boolean d() {
        return this.f5367a;
    }

    public final boolean e(int i10) {
        return C5502d.k(i10, 255) == this.f5370d;
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f5367a = z10;
        this.f5368b = i10;
        this.f5369c = i11;
        this.f5370d = i12;
        this.f5371e = f10;
    }
}
