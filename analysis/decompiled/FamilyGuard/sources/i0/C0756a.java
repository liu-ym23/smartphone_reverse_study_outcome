package i0;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0756a {
    public static <T extends View> T a(View view, int i5) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            T t5 = (T) viewGroup.getChildAt(i6).findViewById(i5);
            if (t5 != null) {
                return t5;
            }
        }
        return null;
    }
}
