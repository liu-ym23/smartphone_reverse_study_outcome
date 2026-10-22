package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class ViewBindings {
    private ViewBindings() {
    }

    public static <T extends View> T findChildViewById(View r100, int r101) {
        if ((r100 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        T r105 = (T) r102.getChildAt(r104).findViewById(r101);
        if (r105 != null) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r105;
    L11:
        return null;
    }
}
