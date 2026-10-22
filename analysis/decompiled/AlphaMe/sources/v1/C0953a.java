package v1;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.K;
import androidx.core.widget.b;
import f1.AbstractC0557a;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0953a extends K {

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f15718g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f15719e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15720f;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f15719e == null) {
            int iX = AbstractC0557a.x(com.stepos.alphame.R.attr.colorControlActivated, this);
            int iX2 = AbstractC0557a.x(com.stepos.alphame.R.attr.colorOnSurface, this);
            int iX3 = AbstractC0557a.x(com.stepos.alphame.R.attr.colorSurface, this);
            this.f15719e = new ColorStateList(f15718g, new int[]{AbstractC0557a.L(1.0f, iX3, iX), AbstractC0557a.L(0.54f, iX3, iX2), AbstractC0557a.L(0.38f, iX3, iX2), AbstractC0557a.L(0.38f, iX3, iX2)});
        }
        return this.f15719e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15720f && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f15720f = z4;
        if (z4) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }
}
