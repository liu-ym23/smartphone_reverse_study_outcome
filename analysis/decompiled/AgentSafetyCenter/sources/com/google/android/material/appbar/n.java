package com.google.android.material.appbar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2382a = {R.attr.stateListAnimator};

    public static void a(g gVar, float f5) {
        int integer = gVar.getResources().getInteger(com.stepos.agentsafetycenter.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.stepos.agentsafetycenter.R.attr.state_liftable, -com.stepos.agentsafetycenter.R.attr.state_lifted}, ObjectAnimator.ofFloat(gVar, "elevation", 0.0f).setDuration(j10));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(gVar, "elevation", f5).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(gVar, "elevation", 0.0f).setDuration(0L));
        gVar.setStateListAnimator(stateListAnimator);
    }
}
