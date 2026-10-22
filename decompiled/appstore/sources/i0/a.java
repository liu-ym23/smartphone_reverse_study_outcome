package i0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static View a(View r10, int r11) {
        if ((r10 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        View r15 = r12.getChildAt(r14).findViewById(r11);
        if (r15 != null) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return r15;
    L11:
        return null;
    }
}
