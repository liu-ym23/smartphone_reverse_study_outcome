package com.bytedance.apm.agent.v2.instrumentation;

import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowCallback;

/* JADX INFO: loaded from: classes14.dex */
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    public static void onPause(Fragment r100) {
        if (r100.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r100.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r100, false);
        return;
    }

    public static void onResume(Fragment r100) {
        if (r100.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r100.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r100, true);
        return;
    }

    public static void onHiddenChanged(Fragment r100, boolean r101) {
        PageShowCallback.onPageShowHideAction(r100, !r101);
    }

    public static void setUserVisibleHint(Fragment r100, boolean r101) {
        if (r100.isResumed() == true) goto L5;
        return;
    L5:
        if (r100.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r100, r101);
        return;
    }
}
