package com.zyql.ai.selector.tools;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.a;

/* loaded from: classes4.dex */
public class AttrsUtils {
    public static ColorStateList getColorStateList(int[] iArr) {
        try {
            return iArr.length == 2 ? new ColorStateList(new int[][]{new int[]{-16842913}, new int[]{R.attr.state_selected}}, iArr) : ColorStateList.valueOf(iArr[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean getTypeValueBoolean(Context context, int i10) throws Resources.NotFoundException {
        boolean z10 = false;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            return z10;
        } catch (Exception e10) {
            e10.printStackTrace();
            return z10;
        }
    }

    public static int getTypeValueColor(Context context, int i10) throws Resources.NotFoundException {
        int color = 0;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return color;
        } catch (Exception e10) {
            e10.printStackTrace();
            return color;
        }
    }

    public static ColorStateList getTypeValueColorStateList(Context context, int i10) throws Resources.NotFoundException {
        ColorStateList colorStateList = null;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            typedArrayObtainStyledAttributes.recycle();
            return colorStateList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return colorStateList;
        }
    }

    public static Drawable getTypeValueDrawable(Context context, int i10, int i11) throws Resources.NotFoundException {
        Drawable drawable = null;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return drawable == null ? a.e(context, i11) : drawable;
    }

    public static float getTypeValueSize(Context context, int i10) throws Resources.NotFoundException {
        float dimensionPixelSize = 0.0f;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (Exception e10) {
            e10.printStackTrace();
            return dimensionPixelSize;
        }
    }

    public static int getTypeValueSizeForInt(Context context, int i10) throws Resources.NotFoundException {
        int dimensionPixelSize = 0;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i10});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (Exception e10) {
            e10.printStackTrace();
            return dimensionPixelSize;
        }
    }
}
