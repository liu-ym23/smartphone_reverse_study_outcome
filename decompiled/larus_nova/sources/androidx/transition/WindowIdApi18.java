package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes17.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    public int hashCode() {
        return this.mWindowId.hashCode();
    }

    public WindowIdApi18(View r100) {
        this.mWindowId = r100.getWindowId();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof WindowIdApi18) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi18) r100).mWindowId.equals(this.mWindowId) == false) goto L7;
        return true;
    }
}
