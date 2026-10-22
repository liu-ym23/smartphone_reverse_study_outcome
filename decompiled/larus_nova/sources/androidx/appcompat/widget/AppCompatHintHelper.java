package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes2.dex */
class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    public static InputConnection onCreateInputConnection(InputConnection r100, EditorInfo r101, View r102) {
        if (r100 != null) goto L4;
    L12:
        return r100;
    L4:
        if (r101.hintText != null) goto L12;
        ViewParent r103 = r102.getParent();
    L7:
        if ((r103 instanceof View) == false) goto L12;
        if ((r103 instanceof WithHint) == true) goto L10;
        r103 = r103.getParent();
        goto L7
    L10:
        r101.hintText = ((WithHint) r103).getHint();
        goto L12
    }
}
