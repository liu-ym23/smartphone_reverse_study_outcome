package B1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0200f0;
import com.stepos.alphame.R;
import f1.AbstractC0557a;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public final class a extends C0200f0 {
    public static int s(Context context, TypedArray typedArray, int... iArr) {
        int dimensionPixelSize = -1;
        for (int i4 = 0; i4 < iArr.length && dimensionPixelSize < 0; i4++) {
            int i5 = iArr[i4];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i5, typedValue) && typedValue.type == 2) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                typedArrayObtainStyledAttributes.recycle();
                dimensionPixelSize = dimensionPixelSize2;
            } else {
                dimensionPixelSize = typedArray.getDimensionPixelSize(i5, -1);
            }
        }
        return dimensionPixelSize;
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView
    public final void setTextAppearance(Context context, int i4) throws Resources.NotFoundException {
        super.setTextAppearance(context, i4);
        if (AbstractC0557a.W(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i4, AbstractC0769a.f13558x);
            int iS = s(getContext(), typedArrayObtainStyledAttributes, 2, 4);
            typedArrayObtainStyledAttributes.recycle();
            if (iS >= 0) {
                setLineHeight(iS);
            }
        }
    }
}
