package androidx.appcompat.widget;

import android.graphics.Canvas;
import h.AbstractC0586d;

/* renamed from: androidx.appcompat.widget.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0227t0 extends AbstractC0586d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3164b;

    @Override // h.AbstractC0586d, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f3164b) {
            super.draw(canvas);
        }
    }

    @Override // h.AbstractC0586d, android.graphics.drawable.Drawable
    public final void setHotspot(float f4, float f5) {
        if (this.f3164b) {
            super.setHotspot(f4, f5);
        }
    }

    @Override // h.AbstractC0586d, android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i4, int i5, int i6, int i7) {
        if (this.f3164b) {
            super.setHotspotBounds(i4, i5, i6, i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.f3164b) {
            return this.f12689a.setState(iArr);
        }
        return false;
    }

    @Override // h.AbstractC0586d, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        if (this.f3164b) {
            return super.setVisible(z4, z5);
        }
        return false;
    }
}
