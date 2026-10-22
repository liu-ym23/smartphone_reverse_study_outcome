package d5;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f3204a;

    public e(Drawable.ConstantState constantState) {
        this.f3204a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f3204a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f3204a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        f fVar = new f(null);
        Drawable drawableNewDrawable = this.f3204a.newDrawable();
        fVar.f3209c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.f3208j);
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        f fVar = new f(null);
        Drawable drawableNewDrawable = this.f3204a.newDrawable(resources);
        fVar.f3209c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.f3208j);
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        f fVar = new f(null);
        Drawable drawableNewDrawable = this.f3204a.newDrawable(resources, theme);
        fVar.f3209c = drawableNewDrawable;
        drawableNewDrawable.setCallback(fVar.f3208j);
        return fVar;
    }
}
