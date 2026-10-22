package com.android.internal.policy;

import android.R;

/* loaded from: classes.dex */
public class StepOSTransitionAnimExtImpl implements IStepOSTransitionAnimExt {
    private TransitionAnimation mHost;

    public void onAttach(TransitionAnimation host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public int updateToTranslucentAnimWithTransit(int anim, int transit) {
        if (transit == 24 && anim == 17432769) {
            return R.anim.wallpaper_intra_close_enter;
        }
        if (transit == 25 && anim == 17432768) {
            return R.anim.wallpaper_enter;
        }
        return 0;
    }

    public int updateToTranslucentAnim(int anim) {
        if (anim == 17432769) {
            return R.anim.wallpaper_intra_close_enter;
        }
        if (anim == 17432768) {
            return R.anim.wallpaper_enter;
        }
        return 0;
    }
}
