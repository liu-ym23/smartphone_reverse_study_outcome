package com.android.server.wm;

import android.graphics.Rect;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class WindowFrames {
    private static final StringBuilder sTmpSB = null;
    final Rect mCompatFrame;
    private boolean mContentChanged;
    public final Rect mDisplayFrame;
    boolean mForceReportingResized;
    final Rect mFrame;
    private boolean mFrameSizeChanged;
    private boolean mInsetsChanged;
    boolean mLastForceReportingResized;
    final Rect mLastFrame;
    final Rect mLastRelFrame;
    public final Rect mParentFrame;
    private boolean mParentFrameWasClippedByDisplayCutout;
    final Rect mRelFrame;

    public WindowFrames() {
        this.mParentFrame = new Rect();
        this.mDisplayFrame = new Rect();
        this.mFrame = new Rect();
        this.mLastFrame = new Rect();
        this.mRelFrame = new Rect();
        this.mLastRelFrame = new Rect();
        this.mFrameSizeChanged = false;
        this.mCompatFrame = new Rect();
        this.mLastForceReportingResized = false;
        this.mForceReportingResized = false;
    }

    static {
        sTmpSB = new StringBuilder();
    }

    public void setFrames(Rect parentFrame, Rect displayFrame) {
        this.mParentFrame.set(parentFrame);
        this.mDisplayFrame.set(displayFrame);
    }

    public void setParentFrameWasClippedByDisplayCutout(boolean parentFrameWasClippedByDisplayCutout) {
        this.mParentFrameWasClippedByDisplayCutout = parentFrameWasClippedByDisplayCutout;
    }

    boolean parentFrameWasClippedByDisplayCutout() {
        return this.mParentFrameWasClippedByDisplayCutout;
    }

    boolean didFrameSizeChange() {
        if (this.mLastFrame.width() == this.mFrame.width()) goto L5;
    L8:
        return true;
    L5:
        if (this.mLastFrame.height() != this.mFrame.height()) goto L8;
        return false;
    }

    boolean setReportResizeHints() {
        this.mLastForceReportingResized |= this.mForceReportingResized;
        this.mFrameSizeChanged |= didFrameSizeChange();
        if (this.mLastForceReportingResized == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mFrameSizeChanged == true) goto L8;
        return false;
    }

    boolean isFrameSizeChangeReported() {
        if (this.mFrameSizeChanged == false) goto L5;
    L8:
        return true;
    L5:
        if (didFrameSizeChange() == true) goto L8;
        return false;
    }

    void clearReportResizeHints() {
        this.mLastForceReportingResized = false;
        this.mFrameSizeChanged = false;
    }

    void onResizeHandled() {
        this.mForceReportingResized = false;
    }

    void forceReportingResized() {
        this.mForceReportingResized = true;
    }

    public void setContentChanged(boolean contentChanged) {
        this.mContentChanged = contentChanged;
    }

    boolean hasContentChanged() {
        return this.mContentChanged;
    }

    void setInsetsChanged(boolean insetsChanged) {
        this.mInsetsChanged = insetsChanged;
    }

    boolean hasInsetsChanged() {
        return this.mInsetsChanged;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        this.mParentFrame.dumpDebug(proto, 1146756268040L);
        this.mDisplayFrame.dumpDebug(proto, 1146756268036L);
        this.mFrame.dumpDebug(proto, 1146756268037L);
        this.mCompatFrame.dumpDebug(proto, 1146756268048L);
        proto.end(token);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "Frames: parent=" + this.mParentFrame.toShortString(sTmpSB) + " display=" + this.mDisplayFrame.toShortString(sTmpSB) + " frame=" + this.mFrame.toShortString(sTmpSB) + " last=" + this.mLastFrame.toShortString(sTmpSB) + " insetsChanged=" + this.mInsetsChanged);
    }

    String getInsetsChangedInfo() {
        return "forceReportingResized=" + this.mLastForceReportingResized + " insetsChanged=" + this.mInsetsChanged;
    }
}
