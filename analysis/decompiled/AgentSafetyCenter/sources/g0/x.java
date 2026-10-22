package g0;

import android.graphics.Rect;
import android.graphics.drawable.RippleDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends RippleDrawable {

    /* renamed from: c, reason: collision with root package name */
    public boolean f4196c;

    /* renamed from: f, reason: collision with root package name */
    public d1.p f4197f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f4198g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4199h;

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        if (!this.f4196c) {
            this.f4199h = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        this.f4199h = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final boolean isProjected() {
        return this.f4199h;
    }
}
