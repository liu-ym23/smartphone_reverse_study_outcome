package com.obric.oui.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class DisplayCutoutCompat {
    private final Object mDisplayCutout;

    public DisplayCutoutCompat(Rect r2, List<Rect> r3) {
        this(new DisplayCutout(r2, r3));
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets r1, Rect r2, Rect r3, Rect r4, Rect r5, androidx.core.graphics.Insets r6) {
        this(constructDisplayCutout(r1, r2, r3, r4, r5, r6));
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets r14, Rect r15, Rect r16, Rect r17, Rect r18, androidx.core.graphics.Insets r19) {
        if (BuildCompat.isAtLeastR() == false) goto L7;
        return new DisplayCutout(r14.toPlatformInsets(), r15, r16, r17, r18, r19.toPlatformInsets());
    L7:
        return new DisplayCutout(r14.toPlatformInsets(), r15, r16, r17, r18);
    }

    private DisplayCutoutCompat(Object r1) {
        this.mDisplayCutout = r1;
    }

    public int getSafeInsetTop() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
    }

    public int getSafeInsetBottom() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
    }

    public int getSafeInsetLeft() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
    }

    public int getSafeInsetRight() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
    }

    public List<Rect> getBoundingRects() {
        return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (BuildCompat.isAtLeastR() == false) goto L7;
        return androidx.core.graphics.Insets.toCompatInsets(((DisplayCutout) this.mDisplayCutout).getWaterfallInsets());
    L7:
        return androidx.core.graphics.Insets.NONE;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r3).mDisplayCutout);
    }

    public int hashCode() {
        Object r0 = this.mDisplayCutout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    static DisplayCutoutCompat wrap(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r1);
    }

    DisplayCutout unwrap() {
        return (DisplayCutout) this.mDisplayCutout;
    }
}
