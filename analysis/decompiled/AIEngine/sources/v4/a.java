package v4;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.t;
import jd.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends t {

    /* renamed from: j, reason: collision with root package name */
    public static final int[][] f13379j = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f13380e;
    public boolean h;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13380e == null) {
            int iS = b.s(com.stepos.aiengine.R.attr.colorControlActivated, this);
            int iS2 = b.s(com.stepos.aiengine.R.attr.colorOnSurface, this);
            int iS3 = b.s(com.stepos.aiengine.R.attr.colorSurface, this);
            this.f13380e = new ColorStateList(f13379j, new int[]{b.C(1.0f, iS3, iS), b.C(0.54f, iS3, iS2), b.C(0.38f, iS3, iS2), b.C(0.38f, iS3, iS2)});
        }
        return this.f13380e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.h = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
