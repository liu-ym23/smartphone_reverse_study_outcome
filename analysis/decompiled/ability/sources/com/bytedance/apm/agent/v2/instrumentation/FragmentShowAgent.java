package com.bytedance.apm.agent.v2.instrumentation;

import S0.b;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;

@Keep
/* loaded from: classes2.dex */
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    @Keep
    public static void onHiddenChanged(Fragment fragment, boolean z10) {
        b.M(fragment, !z10);
    }

    @Keep
    public static void onPause(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        b.M(fragment, false);
    }

    @Keep
    public static void onResume(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        b.M(fragment, true);
    }

    @Keep
    public static void setUserVisibleHint(Fragment fragment, boolean z10) {
        if (!fragment.isResumed() || fragment.isHidden()) {
            return;
        }
        b.M(fragment, z10);
    }
}
