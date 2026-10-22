package o;

import android.content.Context;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class f0 extends EdgeEffect {

    /* renamed from: a, reason: collision with root package name */
    public final float f7046a;

    /* renamed from: b, reason: collision with root package name */
    public float f7047b;

    public f0(Context context) {
        super(context);
        this.f7046a = s7.a.a(context).f2781f * 1;
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int i2) {
        this.f7047b = 0.0f;
        super.onAbsorb(i2);
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f10, float f11) {
        this.f7047b = 0.0f;
        super.onPull(f10, f11);
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        this.f7047b = 0.0f;
        super.onRelease();
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f10) {
        this.f7047b = 0.0f;
        super.onPull(f10);
    }
}
