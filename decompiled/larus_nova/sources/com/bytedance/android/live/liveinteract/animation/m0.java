package com.bytedance.android.live.liveinteract.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f71077a = 0;

    static {
    }

    public static AnimatorSet a(ArrayList r100, float r101, float r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "views");
        AnimatorSet r102 = new AnimatorSet();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        View r105 = (View) r104.next();
        if (r105 == null) goto L4;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, LiveDegradeFpsAnimator.SCALE_X, new float[]{r101, r110});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r105, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r101, r110});
        r106.setRepeatCount(0);
        r107.setRepeatCount(0);
        r103.add(r106);
        r103.add(r107);
        goto L4
    L8:
        r102.setDuration(r111);
        r102.playTogether(r103);
        return r102;
    }
}
