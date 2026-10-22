package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        a mListener;

        AccessibilityStateChangeListenerWrapper(a r3) {
            this.mListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, AccessibilityStateChangeListenerWrapper.class) == true) goto L10;
            return false;
        L10:
            AccessibilityStateChangeListenerWrapper r4 = (AccessibilityStateChangeListenerWrapper) ZeusTransformUtils.preCheckCast(r3, AccessibilityStateChangeListenerWrapper.class, "com.obric.aiagent.plugin");
            return this.mListener.equals(r4.mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r1) {
            this.mListener.a(r1);
        }
    }

    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final c mListener;

        TouchExplorationStateChangeListenerWrapper(c r3) {
            this.mListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, TouchExplorationStateChangeListenerWrapper.class) == true) goto L10;
            return false;
        L10:
            TouchExplorationStateChangeListenerWrapper r4 = (TouchExplorationStateChangeListenerWrapper) ZeusTransformUtils.preCheckCast(r3, TouchExplorationStateChangeListenerWrapper.class, "com.obric.aiagent.plugin");
            return this.mListener.equals(r4.mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r1) {
            this.mListener.a(r1);
        }
    }

    @Deprecated
    public interface a {
        @Deprecated
        void a(boolean r1);
    }

    static class b {
        static boolean a(AccessibilityManager r2, c r3) {
            return r2.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin")));
        }

        static boolean b(AccessibilityManager r2, c r3) {
            return r2.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin")));
        }
    }

    public interface c {
        void a(boolean r1);
    }

    public static boolean a(AccessibilityManager r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return b.a(r2, r4);
    }

    public static boolean b(AccessibilityManager r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return b.b(r2, r4);
    }
}
