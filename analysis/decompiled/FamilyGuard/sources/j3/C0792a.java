package j3;

import android.content.Context;
import android.content.res.TypedArray;

/* renamed from: j3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0792a {
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
