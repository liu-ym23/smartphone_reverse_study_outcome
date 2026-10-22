package com.android.server.wm.utils;

import android.graphics.Rect;
import android.util.Size;
import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class WmDisplayCutout {
    public static final WmDisplayCutout NO_CUTOUT = null;
    private final Size mFrameSize;
    private final DisplayCutout mInner;

    static {
        NO_CUTOUT = new WmDisplayCutout(DisplayCutout.NO_CUTOUT, null);
    }

    public WmDisplayCutout(DisplayCutout inner, Size frameSize) {
        this.mInner = inner;
        this.mFrameSize = frameSize;
    }

    public static WmDisplayCutout computeSafeInsets(DisplayCutout inner, int displayWidth, int displayHeight) {
        if (inner == DisplayCutout.NO_CUTOUT) goto L5;
        Size displaySize = new Size(displayWidth, displayHeight);
        Rect safeInsets = DisplayCutout.computeSafeInsets(displayWidth, displayHeight, inner);
        return new WmDisplayCutout(inner.replaceSafeInsets(safeInsets), displaySize);
    L5:
        return NO_CUTOUT;
    }

    public WmDisplayCutout computeSafeInsets(int width, int height) {
        return computeSafeInsets(this.mInner, width, height);
    }

    public DisplayCutout getDisplayCutout() {
        return this.mInner;
    }

    public boolean equals(Object o) {
        if ((o instanceof WmDisplayCutout) == true) goto L5;
        return false;
    L5:
        WmDisplayCutout that = (WmDisplayCutout) o;
        if (Objects.equals(this.mInner, that.mInner) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mFrameSize, that.mFrameSize) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mInner, this.mFrameSize});
    }

    public String toString() {
        return "WmDisplayCutout{" + this.mInner + ", mFrameSize=" + this.mFrameSize + '}';
    }
}
