package android.view;

import android.content.ClipData;
import android.content.IntentExt;
import android.graphics.BLASTBufferQueue;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Pair;
import android.view.SurfaceControl;

/* loaded from: classes.dex */
public class StepOSViewStartDragExtImpl implements IStepOSViewStartDragExt {
    private static final String CALLSITE_DRAG_AND_DROP = "View.startDragAndDrop";
    private static final String CALLSITE_HIDE_SURFACE = "View.startDragAndDrop for hideSurface.";
    private static final String KEY_DRAG_SURFACE = "key_drag_surface";
    private static final String KEY_DRAG_SURFACE_BBQ_WRAPPER = "key_drag_surface_bbq_wrapper";
    private static final String MIME_LAUNCHER_GLOBAL_DRAG = "com.stepos.launcher.drag_and_drop/global";
    private static final String NAME_BBQ_SURFACE = "drag surface bbq wrapper";
    private static final String NAME_DRAG_SURFACE = "drag surface";
    private SurfaceControl mPendingBbqSurfaceControl;
    private boolean mPendingLauncherBlastPath;

    public Surface openDragShadowSurface(View view, SurfaceControl surfaceControl, Point shadowSize, ClipData data, Object myLocalState) {
        this.mPendingLauncherBlastPath = false;
        this.mPendingBbqSurfaceControl = null;
        Pair<SurfaceControl, Surface> launcherPair = tryCreateLauncherBlastPair(view, surfaceControl, shadowSize, data, myLocalState);
        if (launcherPair != null) {
            this.mPendingLauncherBlastPath = true;
            this.mPendingBbqSurfaceControl = (SurfaceControl) launcherPair.first;
            return (Surface) launcherPair.second;
        }
        Surface s = new Surface();
        s.copyFrom(surfaceControl);
        return s;
    }

    public void onDragPerformDragSucceeded(Object myLocalState, SurfaceControl surfaceControl) {
        if (!this.mPendingLauncherBlastPath || this.mPendingBbqSurfaceControl == null) {
            return;
        }
        if (myLocalState instanceof Bundle) {
            SurfaceControl dragSurfaceControl = new SurfaceControl();
            dragSurfaceControl.copyFrom(surfaceControl, CALLSITE_HIDE_SURFACE);
            ((Bundle) myLocalState).putParcelable(KEY_DRAG_SURFACE, dragSurfaceControl);
            ((Bundle) myLocalState).putParcelable(KEY_DRAG_SURFACE_BBQ_WRAPPER, this.mPendingBbqSurfaceControl);
        }
        this.mPendingBbqSurfaceControl = null;
        this.mPendingLauncherBlastPath = false;
    }

    private static Pair<SurfaceControl, Surface> tryCreateLauncherBlastPair(View view, SurfaceControl surfaceControl, Point shadowSize, ClipData data, Object myLocalState) {
        if (view == null || view.getViewRootImpl() == null) {
            return null;
        }
        boolean interceptGlobal = (view.getViewRootImpl().mWindowAttributes.privateFlags & IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT) != 0;
        boolean isLauncherDrag = (data == null || data.getDescription() == null || !data.getDescription().hasMimeType(MIME_LAUNCHER_GLOBAL_DRAG)) ? false : true;
        if (!interceptGlobal || !isLauncherDrag || !(myLocalState instanceof Bundle)) {
            return null;
        }
        SurfaceControl bbqSurfaceControl = new SurfaceControl.Builder().setName(NAME_BBQ_SURFACE).setBLASTLayer().setParent(surfaceControl).setBufferSize(shadowSize.x, shadowSize.y).setFormat(-3).setCallsite(CALLSITE_DRAG_AND_DROP).setHidden(false).build();
        BLASTBufferQueue blastBufferQueue = new BLASTBufferQueue(NAME_DRAG_SURFACE, true);
        blastBufferQueue.update(bbqSurfaceControl, shadowSize.x, shadowSize.y, -3);
        Surface surface = blastBufferQueue.createSurface();
        return Pair.create(bbqSurfaceControl, surface);
    }
}
