package b3;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;

/* renamed from: b3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0824a extends AppCompatRadioButton {
    public static final int[][] c = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f2014a;
    public boolean b;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2014a == null) {
            int iA = W2.a.a(androidx.appcompat.R.attr.colorControlActivated, this);
            int iA2 = W2.a.a(com.stepos.ability.R.attr.colorOnSurface, this);
            int iA3 = W2.a.a(com.stepos.ability.R.attr.colorSurface, this);
            this.f2014a = new ColorStateList(c, new int[]{W2.a.c(1.0f, iA3, iA), W2.a.c(0.54f, iA3, iA2), W2.a.c(0.38f, iA3, iA2), W2.a.c(0.38f, iA3, iA2)});
        }
        return this.f2014a;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.b = z10;
        if (z10) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }
}
