package V2;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.C1304q;
import androidx.core.widget.c;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import d3.C3953a;

/* loaded from: classes2.dex */
public class a extends C1304q {

    /* renamed from: g, reason: collision with root package name */
    public static final int f6470g = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f6471h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f6472e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6473f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6472e == null) {
            int iD = M2.a.d(this, R$attr.colorControlActivated);
            int iD2 = M2.a.d(this, com.google.android.material.R$attr.colorOnSurface);
            int iD3 = M2.a.d(this, com.google.android.material.R$attr.colorSurface);
            int[][] iArr = f6471h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = M2.a.j(iD3, iD, 1.0f);
            iArr2[1] = M2.a.j(iD3, iD2, 0.54f);
            iArr2[2] = M2.a.j(iD3, iD2, 0.38f);
            iArr2[3] = M2.a.j(iD3, iD2, 0.38f);
            this.f6472e = new ColorStateList(iArr, iArr2);
        }
        return this.f6472e;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6473f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f6473f = z10;
        if (z10) {
            c.d(this, getMaterialThemeColorsTintList());
        } else {
            c.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f6470g;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.MaterialRadioButton, i10, i11, new int[0]);
        int i12 = R$styleable.MaterialRadioButton_buttonTint;
        if (typedArrayI.hasValue(i12)) {
            c.d(this, W2.c.a(context2, typedArrayI, i12));
        }
        this.f6473f = typedArrayI.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayI.recycle();
    }
}
