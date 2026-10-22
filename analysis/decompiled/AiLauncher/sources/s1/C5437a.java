package s1;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5437a {
    public static <T extends View> T a(View view, int i10) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            T t10 = (T) viewGroup.getChildAt(i11).findViewById(i10);
            if (t10 != null) {
                return t10;
            }
        }
        return null;
    }
}
