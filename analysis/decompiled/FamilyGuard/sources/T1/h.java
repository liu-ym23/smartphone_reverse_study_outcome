package T1;

import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes.dex */
public class h {
    public static int a(Context context, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i5});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
