package c3;

import W2.b;
import W2.c;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import d3.C3953a;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1494a extends AppCompatTextView {
    public C1494a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public static boolean g(Context context) {
        return b.b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    public static int h(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int j(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i10 = 0; i10 < iArr.length && iC < 0; i10++) {
            iC = c.c(context, typedArray, iArr[i10], -1);
        }
        return iC;
    }

    public static boolean k(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialTextView, i10, i11);
        int iJ = j(context, typedArrayObtainStyledAttributes, R$styleable.MaterialTextView_android_lineHeight, R$styleable.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iJ != -1;
    }

    public final void f(Resources.Theme theme, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, R$styleable.MaterialTextAppearance);
        int iJ = j(getContext(), typedArrayObtainStyledAttributes, R$styleable.MaterialTextAppearance_android_lineHeight, R$styleable.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iJ >= 0) {
            setLineHeight(iJ);
        }
    }

    public final void i(AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        int iH;
        Context context = getContext();
        if (g(context)) {
            Resources.Theme theme = context.getTheme();
            if (k(context, theme, attributeSet, i10, i11) || (iH = h(theme, attributeSet, i10, i11)) == -1) {
                return;
            }
            f(theme, iH);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i10) throws Resources.NotFoundException {
        super.setTextAppearance(context, i10);
        if (g(context)) {
            f(context.getTheme(), i10);
        }
    }

    public C1494a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(C3953a.d(context, attributeSet, i10, 0), attributeSet, i10);
        i(attributeSet, i10, 0);
    }
}
