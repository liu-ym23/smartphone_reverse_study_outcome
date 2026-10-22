package com.android.server.wm;

import android.graphics.Point;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface AnimationAdapter {
    public static final long STATUS_BAR_TRANSITION_DURATION = 120;

    void dump(PrintWriter r1, String r2);

    void dumpDebug(ProtoOutputStream r1);

    long getDurationHint();

    boolean getShowWallpaper();

    long getStatusBarTransitionsStartTime();

    void onAnimationCancelled(SurfaceControl r1);

    void startAnimation(SurfaceControl r1, SurfaceControl.Transaction r2, int r3, SurfaceAnimator.OnAnimationFinishedCallback r4);

    default boolean getShowBackground() {
        return false;
    }

    default int getBackgroundColor() {
        return 0;
    }

    default void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        dumpDebug(proto);
        proto.end(token);
    }

    default Point getLeashPosition() {
        return new Point(0, 0);
    }

    default boolean shouldDeferAnimationFinish(Runnable endDeferFinishCallback) {
        return false;
    }
}
