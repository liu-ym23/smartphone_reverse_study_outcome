package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class TooltipCompat {
    private TooltipCompat() {
    }

    public static void setTooltipText(View r100, CharSequence r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r100.setTooltipText(r101);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r100, r101);
    }
}
