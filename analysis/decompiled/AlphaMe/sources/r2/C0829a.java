package r2;

import android.graphics.drawable.Drawable;

/* renamed from: r2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0829a extends d {

    /* renamed from: e, reason: collision with root package name */
    public final float f14073e;

    /* renamed from: f, reason: collision with root package name */
    public final float f14074f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14075g;

    /* renamed from: h, reason: collision with root package name */
    public final s2.c f14076h;

    public C0829a(int i4, float f4, float f5) {
        this.f14073e = f4;
        this.f14074f = f5;
        this.f14075g = i4;
        this.f14076h = new s2.c(i4, f4, f5);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new C0830b(this.f14075g, this.f14073e, this.f14074f);
    }
}
