package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class BottomRightAnim {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f151951a = 0;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f151952a;

        public a(Function0 r100) {
            this.f151952a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f151952a.invoke();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f151953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f151954b;

        public b(View r100, Function1 r101) {
            this.f151953a = r100;
            this.f151954b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f151953a.removeOnLayoutChangeListener(this);
            Function1 r109 = this.f151954b;
            if (r100 == null) goto L5;
            int r110 = r100.getMeasuredHeight();
        L6:
            r109.invoke(Integer.valueOf(r110));
            return;
        L5:
            r110 = 0;
            goto L6
        }
    }

    static {
    }

    public static void b(View r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onAnimEnd");
        r100.animate().alpha(0.0f).setDuration(300).setInterpolator(new LinearInterpolator()).setListener(new a(r101)).start();
    }

    public static void e(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Integer r102 = Integer.valueOf(r100.getMeasuredHeight());
        boolean r103 = false;
        if (r102.intValue() <= 0) goto L10;
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        if (r104[0] <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r103 = true;
        goto L10
    L7:
        r105 = false;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        r101.invoke(Integer.valueOf(r102.intValue()));
        return;
    L15:
        r100.addOnLayoutChangeListener(new b(r100, r101));
        r100.requestLayout();
    }

    public static void a(final RoomContextController r100, final View r101, final Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "onAnimEnd");
        e(r101, new BottomRightAnim$hideLinkedAnimation$1(r101, r100, r102));
    }

    public static void d(final boolean r100, final View r101, final Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "onAnimEnd");
        e(r101, new BottomRightAnim$showSwitchAnimation$1(r101, r100, r102));
    }

    public static void c(RoomContextController r100, View r101, Function0 r102, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "contextController");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "onAnimEnd");
        Intrinsics.checkNotNullParameter(r110, "onAnimStart");
        e(r101, new BottomRightAnim$showLinkedAnimation$1(r101, r100, r102, r110, false));
    }
}
