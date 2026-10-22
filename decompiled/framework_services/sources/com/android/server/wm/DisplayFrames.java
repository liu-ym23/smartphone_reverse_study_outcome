package com.android.server.wm;

import android.graphics.Rect;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayCutout;
import android.view.DisplayInfo;
import android.view.DisplayShape;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.PrivacyIndicatorBounds;
import android.view.RoundedCorners;
import android.view.WindowInsets;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayFrames {
    private static final int ID_DISPLAY_CUTOUT_BOTTOM = 0;
    private static final int ID_DISPLAY_CUTOUT_LEFT = 0;
    private static final int ID_DISPLAY_CUTOUT_RIGHT = 0;
    private static final int ID_DISPLAY_CUTOUT_TOP = 0;
    public final Rect mDisplayCutoutSafe;
    public int mHeight;
    public final InsetsState mInsetsState;
    public int mRotation;
    public final Rect mUnrestricted;
    public int mWidth;

    static {
        ID_DISPLAY_CUTOUT_LEFT = InsetsSource.createId(null, 0, WindowInsets.Type.displayCutout());
        ID_DISPLAY_CUTOUT_TOP = InsetsSource.createId(null, 1, WindowInsets.Type.displayCutout());
        ID_DISPLAY_CUTOUT_RIGHT = InsetsSource.createId(null, 2, WindowInsets.Type.displayCutout());
        ID_DISPLAY_CUTOUT_BOTTOM = InsetsSource.createId(null, 3, WindowInsets.Type.displayCutout());
    }

    public DisplayFrames(InsetsState insetsState, DisplayInfo info, DisplayCutout cutout, RoundedCorners roundedCorners, PrivacyIndicatorBounds indicatorBounds, DisplayShape displayShape) {
        this.mUnrestricted = new Rect();
        this.mDisplayCutoutSafe = new Rect();
        this.mInsetsState = insetsState;
        update(info.rotation, info.logicalWidth, info.logicalHeight, cutout, roundedCorners, indicatorBounds, displayShape);
    }

    DisplayFrames() {
        this.mUnrestricted = new Rect();
        this.mDisplayCutoutSafe = new Rect();
        this.mInsetsState = new InsetsState();
    }

    public boolean update(int rotation, int w, int h, DisplayCutout displayCutout, RoundedCorners roundedCorners, PrivacyIndicatorBounds indicatorBounds, DisplayShape displayShape) {
        InsetsState state = this.mInsetsState;
        Rect safe = this.mDisplayCutoutSafe;
        if (this.mRotation == rotation) goto L5;
    L15:
        this.mRotation = rotation;
        this.mWidth = w;
        this.mHeight = h;
        Rect u = this.mUnrestricted;
        u.set(0, 0, w, h);
        state.setDisplayFrame(u);
        state.setDisplayCutout(displayCutout);
        state.setRoundedCorners(roundedCorners);
        state.setPrivacyIndicatorBounds(indicatorBounds);
        state.setDisplayShape(displayShape);
        state.getDisplayCutoutSafe(safe);
        if (safe.left <= u.left) goto L18;
        state.getOrCreateSource(ID_DISPLAY_CUTOUT_LEFT, WindowInsets.Type.displayCutout()).setFrame(u.left, u.top, safe.left, u.bottom).updateSideHint(u);
    L20:
        if (safe.top <= u.top) goto L22;
        state.getOrCreateSource(ID_DISPLAY_CUTOUT_TOP, WindowInsets.Type.displayCutout()).setFrame(u.left, u.top, u.right, safe.top).updateSideHint(u);
    L24:
        if (safe.right >= u.right) goto L26;
        state.getOrCreateSource(ID_DISPLAY_CUTOUT_RIGHT, WindowInsets.Type.displayCutout()).setFrame(safe.right, u.top, u.right, u.bottom).updateSideHint(u);
    L28:
        if (safe.bottom >= u.bottom) goto L30;
        state.getOrCreateSource(ID_DISPLAY_CUTOUT_BOTTOM, WindowInsets.Type.displayCutout()).setFrame(u.left, safe.bottom, u.right, u.bottom).updateSideHint(u);
        return true;
    L30:
        state.removeSource(ID_DISPLAY_CUTOUT_BOTTOM);
        return true;
    L26:
        state.removeSource(ID_DISPLAY_CUTOUT_RIGHT);
        goto L28
    L22:
        state.removeSource(ID_DISPLAY_CUTOUT_TOP);
        goto L24
    L18:
        state.removeSource(ID_DISPLAY_CUTOUT_LEFT);
        goto L20
    L5:
        if (this.mWidth != w) goto L15;
        if (this.mHeight != h) goto L15;
        if (this.mInsetsState.getDisplayCutout().equals(displayCutout) == false) goto L15;
        if (state.getRoundedCorners().equals(roundedCorners) == false) goto L15;
        if (state.getPrivacyIndicatorBounds().equals(indicatorBounds) == false) goto L15;
        return false;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.end(token);
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "DisplayFrames w=" + this.mWidth + " h=" + this.mHeight + " r=" + this.mRotation);
    }
}
