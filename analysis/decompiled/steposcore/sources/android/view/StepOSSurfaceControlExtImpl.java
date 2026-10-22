package android.view;

import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import stepos.app.StepOSWindowManager;

/* loaded from: classes.dex */
public class StepOSSurfaceControlExtImpl implements IStepOSSurfaceControlExt {
    private static final float ALPHA_INVALID = -1.0f;
    private static final String[] ANIMATABLE_CONTAINER_PREFIXES = {"Task=", "ActivityRecord{", "DefaultTaskDisplayArea"};
    private static final int CALLER_DEPTH = 10;
    private static final int CONTAINER_NO = 2;
    private static final int CONTAINER_UNKNOWN = 0;
    private static final int CONTAINER_YES = 1;
    private static final String TAG = "SurfaceControlExt";
    private SurfaceControl mHost;
    private int mContainerState = 0;
    private float mLastAlpha = -1.0f;
    private boolean mVisible = false;

    public void onAttach(SurfaceControl host) {
        this.mHost = host;
    }

    public void onSetAlpha(float alpha) {
        boolean interesting = (alpha == 0.0f || alpha == 1.0f) && this.mLastAlpha != alpha;
        this.mLastAlpha = alpha;
        if (interesting && shouldLog()) {
            Log.d(TAG, "setAlpha(" + alpha + ") sc=" + this.mHost + " caller=" + Debug.getCallers(10));
        }
    }

    public void onVisibilityChanged(boolean visible) {
        boolean changed = this.mVisible != visible;
        this.mVisible = visible;
        if (changed && shouldLog()) {
            Log.d(TAG, (visible ? "show: " : "hide: ") + "sc=" + this.mHost + " caller=" + Debug.getCallers(10));
        }
    }

    public void onReparent(SurfaceControl newParent) {
        if (shouldLog()) {
            Log.d(TAG, "reparent: sc=" + this.mHost + " newParent=" + newParent + " caller=" + Debug.getCallers(10));
        }
    }

    private boolean shouldLog() {
        return StepOSWindowManager.isMonkeyRunning() && isAnimatableContainer();
    }

    private boolean isAnimatableContainer() {
        if (this.mContainerState == 0) {
            String name = this.mHost != null ? this.mHost.getName() : null;
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            this.mContainerState = matchesAnimatableContainer(name) ? 1 : 2;
        }
        return this.mContainerState == 1;
    }

    private static boolean matchesAnimatableContainer(String name) {
        for (String prefix : ANIMATABLE_CONTAINER_PREFIXES) {
            if (name.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
