package com.bytedance.android.shopping.deepfeed.ui.view;

import android.animation.Animator;
import com.bytedance.android.ec.core.utils.u0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f173947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f173948b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f173947a.f173943d = 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        if (this.f173947a.f173943d != 1) goto L10;
        Map<String, List<Long>> r101 = g.f173937h;
        String r102 = this.f173948b;
        List r103 = (List) ((LinkedHashMap) g.f173937h).get(r102);
        if (r103 != null) goto L7;
        r103 = new ArrayList();
    L7:
        r103.add(Long.valueOf(System.currentTimeMillis()));
        ed3.c r104 = g.f173938i;
        String r105 = u0.d(new g.a.C2601a(r103));
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        com.bytedance.android.shopping.deepfeed.action.h r106 = this.f173947a.f173946g;
        if (r106 == null) goto L10;
        r106.w();
    L10:
        this.f173947a.f173943d = 2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f173947a.f173943d = 1;
    }

    public h(g r100, String r101) {
        this.f173947a = r100;
        this.f173948b = r101;
    }
}
