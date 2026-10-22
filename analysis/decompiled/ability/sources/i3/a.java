package i3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4606a = {R.attr.theme, androidx.appcompat.R.attr.theme};
    public static final int[] b = {com.stepos.ability.R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i, int i6) {
        return b(context, attributeSet, new int[0], i, i6);
    }

    public static Context b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i6);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i10 = iArr2[0];
        boolean z10 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == i10;
        if (i10 == 0 || z10) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i6);
            for (int i11 = 0; i11 < iArr.length; i11++) {
                iArr3[i11] = typedArrayObtainStyledAttributes2.getResourceId(i11, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr3[i12];
            if (i13 != 0) {
                contextThemeWrapper.getTheme().applyStyle(i13, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f4606a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            contextThemeWrapper.getTheme().applyStyle(resourceId, true);
        }
        return contextThemeWrapper;
    }
}
