package w1;

import a1.C0409b;
import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.D;
import q1.C0980b;
import q1.C0981c;
import x1.C1282a;

/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1202a extends D {
    public C1202a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void t(Resources.Theme theme, int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i5, C0418k.f7220u3);
        int iX = x(getContext(), typedArrayObtainStyledAttributes, C0418k.f7238x3, C0418k.f7250z3);
        typedArrayObtainStyledAttributes.recycle();
        if (iX >= 0) {
            setLineHeight(iX);
        }
    }

    private static boolean u(Context context) {
        return C0980b.b(context, C0409b.f6711U, true);
    }

    private static int v(Resources.Theme theme, AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C0418k.f6939A3, i5, i6);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C0418k.f6945B3, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void w(AttributeSet attributeSet, int i5, int i6) throws Resources.NotFoundException {
        int iV;
        Context context = getContext();
        if (u(context)) {
            Resources.Theme theme = context.getTheme();
            if (y(context, theme, attributeSet, i5, i6) || (iV = v(theme, attributeSet, i5, i6)) == -1) {
                return;
            }
            t(theme, iV);
        }
    }

    private static int x(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i5 = 0; i5 < iArr.length && iC < 0; i5++) {
            iC = C0981c.c(context, typedArray, iArr[i5], -1);
        }
        return iC;
    }

    private static boolean y(Context context, Resources.Theme theme, AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C0418k.f6939A3, i5, i6);
        int iX = x(context, typedArrayObtainStyledAttributes, C0418k.f6951C3, C0418k.f6957D3);
        typedArrayObtainStyledAttributes.recycle();
        return iX != -1;
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView
    public void setTextAppearance(Context context, int i5) throws Resources.NotFoundException {
        super.setTextAppearance(context, i5);
        if (u(context)) {
            t(context.getTheme(), i5);
        }
    }

    public C1202a(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(C1282a.d(context, attributeSet, i5, 0), attributeSet, i5);
        w(attributeSet, i5, 0);
    }
}
