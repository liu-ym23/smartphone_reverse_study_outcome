package c7;

import android.R;
import android.content.res.ColorStateList;
import m.b0;
import t1.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends b0 {

    /* renamed from: k, reason: collision with root package name */
    public static final int[][] f2221k = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2222j;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.i == null) {
            int i = e.i(com.stepos.agentsafetycenter.R.attr.colorControlActivated, this);
            int i3 = e.i(com.stepos.agentsafetycenter.R.attr.colorOnSurface, this);
            int i10 = e.i(com.stepos.agentsafetycenter.R.attr.colorSurface, this);
            this.i = new ColorStateList(f2221k, new int[]{e.m(i10, 1.0f, i), e.m(i10, 0.54f, i3), e.m(i10, 0.38f, i3), e.m(i10, 0.38f, i3)});
        }
        return this.i;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2222j && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f2222j = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
