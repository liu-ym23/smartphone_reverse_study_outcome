package androidx.transition;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Canvas r10, boolean r11) {
        if (r11 == false) goto L4;
        r10.enableZ();
        return;
    L4:
        r10.disableZ();
    }
}
