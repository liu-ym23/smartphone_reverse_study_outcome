package N7;

import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: classes2.dex */
public class d {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("StepOSThemeColor", "attr", context.getPackageName());
        if (identifier <= 0) {
            return 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{identifier});
        int color = typedArrayObtainStyledAttributes.getColor(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        if (color == -1) {
            return 0;
        }
        return color;
    }
}
