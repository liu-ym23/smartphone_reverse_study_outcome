package com.bytedance.apm.agent.v2.instrumentation;

import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowCallback;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    public static void onResume(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r1, true);
        return;
    }

    public static void onPause(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r1, false);
        return;
    }

    public static void onHiddenChanged(Fragment r0, boolean r1) {
        PageShowCallback.onPageShowHideAction(r0, !r1);
    }

    public static void setUserVisibleHint(Fragment r1, boolean r2) {
        if (r1.isResumed() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r1, r2);
        return;
    }
}
