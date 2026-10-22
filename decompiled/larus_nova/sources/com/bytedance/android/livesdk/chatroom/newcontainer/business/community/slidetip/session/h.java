package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.c4;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.chatroom.widget.j;
import com.bytedance.android.livesdk.config.wr;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.slideuptip.LiveSlideUpTipsGuideStrategy;
import com.bytedance.android.livesdk.slideuptip.SlideUpTipsTriggerSource;
import com.bytedance.android.livesdk.slideuptip.StrengthSlideGuideView;
import com.bytedance.android.livesdk.slideuptip.k;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f107469a;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ls2.d f107470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik1.h f107471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f107472c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            h.b(this.f107470a, this.f107471b, this.f107472c);
        }

        public a(ls2.d r100, ik1.h r101, FrameLayout r102) {
            this.f107470a = r100;
            this.f107471b = r101;
            this.f107472c = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ls2.d f107473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik1.h f107474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f107475c;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (((ck1.d) this.f107473a.a(ck1.d.class)).Um() == false) goto L12;
            SlideGuideView r100 = this.f107474b.f490259c;     // Catch: Throwable -> L9
            if (r100 == null) goto L16;
            this.f107475c.removeView(r100);     // Catch: Throwable -> L9
            this.f107474b.f490259c.b();     // Catch: Throwable -> L9
            this.f107474b.f490259c = null;     // Catch: Throwable -> L9
            return;
        L16:
            return;
        }

        public b(ls2.d r100, ik1.h r101, FrameLayout r102) {
            this.f107473a = r100;
            this.f107474b = r101;
            this.f107475c = r102;
        }
    }

    public static void a(final ls2.d r100, final ik1.h r101, final FrameLayout r102) {
        j r103 = r101.f490260d;
        if (r103 == null) goto L6;
        r103.getClass();
        AlphaAnimation r104 = new AlphaAnimation(1.0f, 0.0f);
        r104.setDuration(500);
        r103.startAnimation(r104);
        r102.postDelayed(new f(r100, r101, r102), 500);
        return;
    }

    public static void b(ls2.d r100, ik1.h r101, FrameLayout r102) {
        SlideGuideView r103 = r101.f490259c;
        if (r103 == null) goto L5;
        r103.f();
        r102.postDelayed(new b(r100, r101, r102), 320);
    L5:
        com.bytedance.android.livesdk.e.b().d();
        c4.f114424b = 0;
        if (k.f158429f == 0) goto L8;
        k.f158429f = 0;
        SharedPrefHelper r104 = SharedPrefHelper.b(s1.getContext());
        String r105 = k.f158426c + "_time";
        r104.l(r105, Integer.valueOf(r104.h(r105, 0) + 1));
        r104.a();
    L8:
        pg1.b.f529142c = false;
        pg1.b.f529143d = null;
        ((ck1.e) r100.a(ck1.e.class)).Uk(false);
    }

    public static void c(final ls2.d r100, final ik1.h r101, LiveVerticalViewPager r102, final FrameLayout r103, SlideUpTipsTriggerSource r104) {
        if (wr.f121547a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        SlideGuideView r105 = r101.f490259c;
        if (r105 == null) goto L11;
        r103.removeView(r105);
    L11:
        if (r100.f510523l != null) goto L13;
        return;
    L13:
        if (k.d() == false) goto L15;
        StrengthSlideGuideView r106 = new StrengthSlideGuideView(r100.f510523l, r102);
        r106.g((int) UIUtils.dip2Px(s1.getContext(), 14.0f));
        r106.setRepeatCount(-1);
        r106.setAnimatorListener(new a(r100, r101, r103));
        r101.f490259c = r106;
    L17:
        if (k.d() == false) goto L19;
        r101.f490259c.d("Gesture_SlideUp_Op_No_Fade_Out.json", "images/");
    L20:
        r101.f490259c.setDestText(s1.B(R.string.ttlive_slide_up_and_down_to_switch_video));
        LiveSlideUpTipsGuideStrategy r107 = ((ik1.b) r100.b("RoomSessionTaskConst_live_room_inner_feed_data")).A.a();
        SlideUpTipsTriggerSource r108 = SlideUpTipsTriggerSource.STRATEGY_TRIGGER;
        if (r104 != r108) goto L29;
        if (TextUtils.isEmpty(r107.a()) == true) goto L29;
        Handler r109 = k.f158431h;
        if (r109 == null) goto L27;
        r109.removeCallbacksAndMessages(null);
        k.f158431h = null;
    L27:
        r101.f490259c.setDestText(r107.a());
    L31:
        r101.f490259c.e();
        r101.f490259c.setClickListener(new e(r100, r101, r103));
        r103.addView(r101.f490259c);
        com.bytedance.android.livesdk.e.b().a();
        final String r110 = r100.f510516e;
        final String r111 = r100.f510517f;
        if (tb1.c.f545229a == true) goto L34;
    L41:
        f107469a = true;
        IEnterGuideService r112 = (IEnterGuideService) jc1.k.f(IEnterGuideService.class);
        if (r112 == null) goto L44;
        r112.setHasShownSlideUpGuideInSingleContainer(true);
    L44:
        ((ck1.e) r100.a(ck1.e.class)).Uk(true);
        return;
    L34:
        if (k.f158431h != null) goto L36;
        k.f158431h = new Handler(Looper.getMainLooper());
    L36:
        final HashMap r113 = new HashMap();
        if (r104 != r108) goto L39;
        r113.put("from_stategy", "no_slide_user");
    L40:
        k.f158431h.post(new com.bytedance.android.livesdk.slideuptip.j(r110, r111, r113));
        goto L41
    L39:
        r113.put("from_stategy", "");
    L29:
        if (k.d() == false) goto L31;
        r101.f490259c.setDestText(s1.B(R.string.ttlive_slide_up_and_down_to_switch_video_op));
        goto L31
    L19:
        r101.f490259c.d("Gesture_SlideUp.json", "images/");
        goto L20
    L15:
        r101.f490259c = new SlideGuideView(r100.f510523l);
        goto L17
    }
}
