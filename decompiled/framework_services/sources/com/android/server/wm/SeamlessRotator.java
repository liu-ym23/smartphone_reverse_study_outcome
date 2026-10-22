package com.android.server.wm;

import android.graphics.Matrix;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import com.android.server.wm.utils.CoordinateTransforms;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public class SeamlessRotator {
    private final boolean mApplyFixedTransformHint;
    private final int mFixedTransformHint;
    private final float[] mFloat9;
    private final int mNewRotation;
    private final int mOldRotation;
    private final Matrix mTransform;

    public SeamlessRotator(int oldRotation, int newRotation, DisplayInfo info, boolean applyFixedTransformationHint) {
        this.mTransform = new Matrix();
        this.mFloat9 = new float[9];
        this.mOldRotation = oldRotation;
        this.mNewRotation = newRotation;
        this.mApplyFixedTransformHint = applyFixedTransformationHint;
        this.mFixedTransformHint = (info.installOrientation + oldRotation) % 4;
        boolean flipped = true;
        if (info.rotation != 1) goto L5;
    L8:
        if (flipped == false) goto L10;
        int pH = info.logicalWidth;
    L11:
        if (flipped == false) goto L13;
        int pW = info.logicalHeight;
    L14:
        Matrix tmp = new Matrix();
        CoordinateTransforms.transformLogicalToPhysicalCoordinates(oldRotation, pW, pH, this.mTransform);
        CoordinateTransforms.transformPhysicalToLogicalCoordinates(newRotation, pW, pH, tmp);
        this.mTransform.postConcat(tmp);
        return;
    L13:
        pW = info.logicalWidth;
        goto L14
    L10:
        pH = info.logicalHeight;
        goto L11
    L5:
        if (info.rotation == 3) goto L8;
        flipped = false;
        goto L8
    }

    public void unrotate(SurfaceControl.Transaction transaction, WindowContainer win) {
        applyTransform(transaction, win.getSurfaceControl());
        float[] winSurfacePos = {win.mLastSurfacePosition.x, win.mLastSurfacePosition.y};
        this.mTransform.mapPoints(winSurfacePos);
        transaction.setPosition(win.getSurfaceControl(), winSurfacePos[0], winSurfacePos[1]);
        if (this.mApplyFixedTransformHint == false) goto L6;
        transaction.setFixedTransformHint(win.mSurfaceControl, this.mFixedTransformHint);
        return;
    }

    void applyTransform(SurfaceControl.Transaction t, SurfaceControl sc) {
        t.setMatrix(sc, this.mTransform, this.mFloat9);
    }

    public int getOldRotation() {
        return this.mOldRotation;
    }

    void finish(SurfaceControl.Transaction t, WindowContainer win) {
        if (win.mSurfaceControl != null) goto L5;
        return;
    L5:
        if (win.mSurfaceControl.isValid() == false) goto L13;
        setIdentityMatrix(t, win.mSurfaceControl);
        t.setPosition(win.mSurfaceControl, win.mLastSurfacePosition.x, win.mLastSurfacePosition.y);
        if (this.mApplyFixedTransformHint == false) goto L12;
        t.unsetFixedTransformHint(win.mSurfaceControl);
        return;
    L12:
        return;
    }

    void setIdentityMatrix(SurfaceControl.Transaction t, SurfaceControl sc) {
        t.setMatrix(sc, Matrix.IDENTITY_MATRIX, this.mFloat9);
    }

    public void dump(PrintWriter pw) {
        pw.print("{old=");
        pw.print(this.mOldRotation);
        pw.print(", new=");
        pw.print(this.mNewRotation);
        pw.print("}");
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        dump(new PrintWriter(sw));
        return "ForcedSeamlessRotator" + sw.toString();
    }
}
