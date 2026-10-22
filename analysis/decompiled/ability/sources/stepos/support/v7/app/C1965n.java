package stepos.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.TintTypedArray;

/* renamed from: stepos.support.v7.app.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1965n implements ActionBarDrawerToggle.Delegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1966o f6315a;

    public C1965n(AbstractC1966o abstractC1966o) {
        this.f6315a = abstractC1966o;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Context getActionBarThemedContext() {
        return this.f6315a.l();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Drawable getThemeUpIndicator() {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f6315a.l(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
        Drawable drawable = tintTypedArrayObtainStyledAttributes.getDrawable(0);
        tintTypedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final boolean isNavigationVisible() {
        AbstractC1966o abstractC1966o = this.f6315a;
        abstractC1966o.m();
        AbstractC1955d abstractC1955d = abstractC1966o.f;
        return (abstractC1955d == null || (abstractC1955d.c() & 4) == 0) ? false : true;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarDescription(int i) {
        AbstractC1966o abstractC1966o = this.f6315a;
        abstractC1966o.m();
        AbstractC1955d abstractC1955d = abstractC1966o.f;
        if (abstractC1955d != null) {
            abstractC1955d.m(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarUpIndicator(Drawable drawable, int i) {
        AbstractC1966o abstractC1966o = this.f6315a;
        abstractC1966o.m();
        AbstractC1955d abstractC1955d = abstractC1966o.f;
        if (abstractC1955d != null) {
            abstractC1955d.n(drawable);
            abstractC1955d.m(i);
        }
    }
}
