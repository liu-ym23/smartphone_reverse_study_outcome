package p0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class d extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f13851a;

    public d(Drawable.ConstantState constantState) {
        this.f13851a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f13851a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f13851a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        e eVar = new e(null);
        Drawable drawableNewDrawable = this.f13851a.newDrawable();
        eVar.f13857a = drawableNewDrawable;
        drawableNewDrawable.setCallback(eVar.f13856f);
        return eVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        e eVar = new e(null);
        Drawable drawableNewDrawable = this.f13851a.newDrawable(resources);
        eVar.f13857a = drawableNewDrawable;
        drawableNewDrawable.setCallback(eVar.f13856f);
        return eVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        e eVar = new e(null);
        Drawable drawableNewDrawable = this.f13851a.newDrawable(resources, theme);
        eVar.f13857a = drawableNewDrawable;
        drawableNewDrawable.setCallback(eVar.f13856f);
        return eVar;
    }
}
