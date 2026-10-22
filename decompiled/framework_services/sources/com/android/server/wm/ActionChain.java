package com.android.server.wm;

import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class ActionChain {
    private static final String TAG = "TransitionChain";
    static final int TYPE_DEFAULT = 1;
    static final int TYPE_FAILSAFE = 5;
    static final int TYPE_FINISH = 4;
    static final int TYPE_LEGACY = 2;
    static final int TYPE_NORMAL = 0;
    static final int TYPE_TEST = 3;
    long mCreateTimeMs;
    ActionChain mPrevious;
    final String mSource;
    ActivityTaskManagerService mTmpAtm;
    Transition mTransition;
    int mType;

    public @interface LinkType {
    }

    static class Tracker {
        private final ActivityTaskManagerService mAtm;

        Tracker(ActivityTaskManagerService atm) {
            this.mAtm = atm;
        }

        private ActionChain makeChain(String source, int type, Transition transit) {
            ActionChain out = new ActionChain(source, type, transit, null);
            out.mTmpAtm = this.mAtm;
            return out;
        }

        private ActionChain makeChain(String source, int type) {
            return makeChain(source, type, this.mAtm.getTransitionController().getCollectingTransition());
        }

        ActionChain start(String source, Transition transit) {
            return makeChain(source, 0, transit);
        }

        ActionChain startDefault(String source) {
            return makeChain(source, 1);
        }

        ActionChain startFinish(String source, Transition finishTransit) {
            return makeChain(source, 4, finishTransit);
        }

        ActionChain startLegacy(String source) {
            return makeChain(source, 2, null);
        }

        ActionChain startFailsafe(String source) {
            return makeChain(source, 5);
        }
    }

    /* synthetic */ ActionChain(String r1, int r2, Transition r3, ActionChainIA r4) {
        this(r1, r2, r3);
    }

    private ActionChain(String source, int type, Transition transit) {
        this.mPrevious = null;
        this.mType = 0;
        this.mSource = source;
        this.mCreateTimeMs = System.currentTimeMillis();
        this.mType = type;
        this.mTransition = transit;
        if (this.mTransition == null) goto L6;
        this.mTransition.recordChain(this);
        return;
    }

    private Transition getTransition() {
        return this.mTmpAtm.getTransitionController().getCollectingTransition();
    }

    boolean isFinishing() {
        if (this.mType != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean expectCollecting() {
        Transition transition = getTransition();
        if (transition != null) goto L7;
        Slog.e(TAG, "Can't collect into a chain with no transition");
        return false;
    L7:
        if (isFinishing() == false) goto L11;
        Slog.e(TAG, "Trying to collect into a finished transition");
        return false;
    L11:
        if (transition.mController.getCollectingTransition() == this.mTransition) goto L14;
        Slog.e(TAG, "Mismatch between current collecting (" + transition.mController.getCollectingTransition() + ") and chain (" + transition + ")");
        return false;
    L14:
        return true;
    }

    void collect(WindowContainer wc) {
        if (wc.mTransitionController.isShellTransitionsEnabled() == true) goto L6;
        return;
    L6:
        if (expectCollecting() == true) goto L8;
        return;
    L8:
        getTransition().collect(wc);
    }

    static ActionChain test() {
        return new ActionChain("test", 3, null);
    }

    static ActionChain testFinish(Transition toFinish) {
        return new ActionChain("test", 4, toFinish);
    }
}
