package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static boolean a(MotionEvent r10, int r11) {
        if ((r10.getSource() & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }
}
