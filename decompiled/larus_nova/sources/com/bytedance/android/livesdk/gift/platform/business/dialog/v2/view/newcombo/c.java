package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final void a(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$cancelRunning");
        if (r100.isRunning() == false) goto L6;
        r100.cancel();
        r100.removeAllListeners();
        return;
    }

    public static final void b(AnimatorSet r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$clearAllListener");
        r100.removeAllListeners();
        ArrayList<Animator> r101 = r100.getChildAnimations();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Animator r103 = (Animator) r102.next();
        if ((r103 instanceof AnimatorSet) == true) goto L9;
        if (r103 == null) goto L6;
        r103.removeAllListeners();
        goto L6
    L9:
        b((AnimatorSet) r103);
        goto L6
    L21:
        return;
    }

    public static final void c(Animator r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r101, "action");
        r100.addListener(new a(r101));
    }
}
