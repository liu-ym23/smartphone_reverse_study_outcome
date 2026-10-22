package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: MotionEventCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static boolean a(MotionEvent r0, int r1) {
        if ((r0.getSource() & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
