package C1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import j.e;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f335a = {R.attr.theme, com.stepos.alphame.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f336b = {com.stepos.alphame.R.attr.materialThemeOverlay};

    public static Context a(int i4, int i5, Context context, AttributeSet attributeSet, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f336b, i4, i5);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i6 = iArr2[0];
        boolean z4 = (context instanceof e) && ((e) context).f13049a == i6;
        if (i6 == 0 || z4) {
            return context;
        }
        e eVar = new e(context, i6);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i4, i5);
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr3[i7] = typedArrayObtainStyledAttributes2.getResourceId(i7, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr3[i8];
            if (i9 != 0) {
                eVar.getTheme().applyStyle(i9, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f335a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            eVar.getTheme().applyStyle(resourceId, true);
        }
        return eVar;
    }

    public static Context b(Context context, AttributeSet attributeSet, int i4, int i5) {
        return a(i4, i5, context, attributeSet, new int[0]);
    }
}
