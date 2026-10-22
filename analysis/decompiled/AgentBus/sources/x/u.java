package x;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;

/* loaded from: classes.dex */
public final class u extends RippleDrawable {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11058f;

    /* renamed from: g, reason: collision with root package name */
    public u0.m f11059g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f11060h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11061i;

    public u(boolean z4) {
        super(ColorStateList.valueOf(-16777216), null, z4 ? new ColorDrawable(-1) : null);
        this.f11058f = z4;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        if (!this.f11058f) {
            this.f11061i = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        this.f11061i = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final boolean isProjected() {
        return this.f11061i;
    }
}
