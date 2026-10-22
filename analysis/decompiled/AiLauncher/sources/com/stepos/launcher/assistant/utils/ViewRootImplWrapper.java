package com.stepos.launcher.assistant.utils;

import android.graphics.HardwareRenderer;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewRootImpl;

/* loaded from: classes.dex */
public class ViewRootImplWrapper {
    private final ViewRootImpl mViewRoot;

    public interface FrameDrawingCallbackWrapper {
        void onFrameDraw(long j10);
    }

    public ViewRootImplWrapper(View view) {
        this.mViewRoot = view.getViewRootImpl();
    }

    public void mergeWithNextTransaction(SurfaceControl.Transaction transaction, long j10) {
        this.mViewRoot.mergeWithNextTransaction(transaction, j10);
    }

    public void registerRtFrameCallback(final FrameDrawingCallbackWrapper frameDrawingCallbackWrapper) {
        this.mViewRoot.registerRtFrameCallback(new HardwareRenderer.FrameDrawingCallback() { // from class: com.stepos.launcher.assistant.utils.ViewRootImplWrapper.1
            public void onFrameDraw(long j10) {
                frameDrawingCallbackWrapper.onFrameDraw(j10);
            }
        });
    }
}
