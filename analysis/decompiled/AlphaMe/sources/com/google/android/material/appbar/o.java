package com.google.android.material.appbar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.Resources;
import android.view.View;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10340a = {R.attr.stateListAnimator};

    public static void a(View view, float f4) throws Resources.NotFoundException {
        int integer = view.getResources().getInteger(com.stepos.alphame.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j4 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.stepos.alphame.R.attr.state_liftable, -2130970283}, ObjectAnimator.ofFloat(view, "elevation", Property.DEFAULT_FLOAT_VALUE).setDuration(j4));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(view, "elevation", f4).setDuration(j4));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", Property.DEFAULT_FLOAT_VALUE).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
