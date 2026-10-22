package M0;

import C0.v;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static v<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // C0.v
    public void b() {
    }

    @Override // C0.v
    public int c() {
        return Math.max(1, this.f3994a.getIntrinsicWidth() * this.f3994a.getIntrinsicHeight() * 4);
    }

    @Override // C0.v
    public Class<Drawable> d() {
        return this.f3994a.getClass();
    }
}
