package android.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BLASTBufferQueue;
import android.os.SystemProperties;
import android.util.Log;
import android.view.SurfaceControl;
import java.util.Set;

/* loaded from: classes.dex */
public class StepOSSurfaceViewExtImpl implements IStepOSSurfaceViewExt {
    private static final Set<String> BG_LAYER_BLACKLIST = Set.of("com.tencent.mm/com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm/com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI");
    private static final int DEFAULT_FPS = 60;
    private static final String PROP_ENABLE = "sys.quantumvsync.danmaku.enable";
    private static final String PROP_FPS = "sys.quantumvsync.danmaku.fps";
    private static final int SUBLAYER_MEDIA = -2;
    private static final int SUBLAYER_MEDIA_OVERLAY = -1;
    private static final String TAG = "QuantumVsync.Danmaku";
    private SurfaceView mHost;

    public void onAttach(SurfaceView host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void onSurfaceUpdate(BLASTBufferQueue bbq, SurfaceControl blastSc, SurfaceControl sc, SurfaceControl.Transaction t) {
        if (!isDanmakuOverlay(this.mHost)) {
            if (this.mHost.mSubLayer == -1 && bbq != null) {
                bbq.setMaxFrameRate(0.0f);
                return;
            }
            return;
        }
        boolean enabled = SystemProperties.getBoolean(PROP_ENABLE, false);
        float targetFps = enabled ? SystemProperties.getInt(PROP_FPS, 60) : 0.0f;
        if (bbq != null) {
            bbq.setMaxFrameRate(targetFps);
        }
    }

    public void onBlastBufferQueueCreated(BLASTBufferQueue bbq) {
        if (isDanmakuOverlay(this.mHost) && SystemProperties.getBoolean(PROP_ENABLE, false)) {
            bbq.setMaxFrameRate(SystemProperties.getInt(PROP_FPS, 60));
        }
    }

    public boolean shouldForceShowBackground() {
        Window window;
        Activity activity = resolveActivity(this.mHost.getContext());
        if (activity == null || (window = activity.getWindow()) == null || window.isFloating() || window.getAttributes().type != 1) {
            return false;
        }
        return !isBackgroundLayerBlacklisted(activity);
    }

    private static Activity resolveActivity(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            ContextWrapper wrapper = (ContextWrapper) ctx;
            if (ctx instanceof Activity) {
                break;
            }
            ctx = wrapper.getBaseContext();
        }
        if (ctx instanceof Activity) {
            return (Activity) ctx;
        }
        return null;
    }

    private static boolean isBackgroundLayerBlacklisted(Activity activity) {
        ComponentName cn = activity.getComponentName();
        return cn != null && BG_LAYER_BLACKLIST.contains(cn.flattenToString());
    }

    private boolean isDanmakuOverlay(SurfaceView sv) {
        if (sv.mSubLayer != -1) {
            return false;
        }
        View root = sv.getRootView();
        if (!(root instanceof ViewGroup)) {
            Log.d(TAG, "isDanmakuOverlay: root not ViewGroup");
            return false;
        }
        boolean found = findMediaSurfaceView((ViewGroup) root, sv);
        if (!found) {
            Log.d(TAG, "isDanmakuOverlay: no video SurfaceView(subLayer=-2) in window, pkg=" + sv.getContext().getPackageName());
        }
        return found;
    }

    private boolean findMediaSurfaceView(ViewGroup group, SurfaceView exclude) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View child = group.getChildAt(i);
            if ((child instanceof SurfaceView) && child != exclude) {
                int subLayer = ((SurfaceView) child).mSubLayer;
                Log.d(TAG, "findMediaSurfaceView: SurfaceView subLayer=" + subLayer);
                if (subLayer == -2) {
                    return true;
                }
            } else if ((child instanceof ViewGroup) && findMediaSurfaceView((ViewGroup) child, exclude)) {
                return true;
            }
        }
        return false;
    }
}
