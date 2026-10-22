package com.bytedance.apm.agent.v2.instrumentation;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowCallback;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public FragmentShowAgent() {
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        PageShowCallback.onPageShowHideAction(r10, !r11);
    }

    @Keep
    public static void onPause(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r10, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r10, true);
        return;
    }

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r10.isResumed() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L9;
        PageShowCallback.onPageShowHideAction(r10, r11);
        return;
    }
}
