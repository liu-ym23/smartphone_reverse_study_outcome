package com.bytedance.android.live.ktv.common.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends com.bytedance.android.live.ktv.common.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f70809a = 0;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f70810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HSImageView f70811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f70812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f70813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f70814e;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            onAnimationEnd(r100);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f70810a.removeView(this.f70811b);
            this.f70814e.invoke();
        }

        public a(ViewGroup r100, HSImageView r101, View r102, View r103, Function0 r104) {
            this.f70810a = r100;
            this.f70811b = r101;
            this.f70812c = r102;
            this.f70813d = r103;
            this.f70814e = r104;
        }
    }

    static {
    }

    public static void a(MusicPanel r110, View r111, View r112, Context r113, Function0 r210) {
        Intrinsics.checkNotNullParameter(r110, "panel");
        Intrinsics.checkNotNullParameter(r111, "endView");
        Intrinsics.checkNotNullParameter(r112, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "endAction");
        ALogger.i("cartAnimView", "startAnim:" + r110.f153598v);
        Rect r100 = r110.f153598v;
        if (r100.left <= 0) goto L12;
        Rect r101 = new Rect(r100);
        HSImageView r102 = new HSImageView(r113);
        r102.setLayoutParams(new ViewGroup.LayoutParams(r111.getHeight(), r111.getHeight()));
        if ((r112 instanceof ViewGroup) == true) goto L7;
        View r103 = null;
    L8:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L11;
        r104.addView(r102);
        FrescoLoader.with(r113).roundAsCircle().load(r110.f153577a.getCoverUrl()).actualScaleType(ImageView.ScaleType.FIT_XY).into(r102);
        Rect r105 = new Rect();
        r111.getGlobalVisibleRect(r105);
        int[] r106 = new int[2];
        r112.getLocationInWindow(r106);
        int r107 = r101.left;
        int r114 = r106[0];
        r101.left = r107 - r114;
        r101.right -= r114;
        int r108 = r101.top;
        int r109 = r106[1];
        r101.top = r108 - r109;
        r101.bottom -= r109;
        r105.left -= r114;
        r105.right -= r114;
        r105.top -= r109;
        r105.bottom -= r109;
        a r115 = new a(r104, r102, r111, r112, r210);
        Intrinsics.checkNotNullParameter(r101, "startViewRect");
        Intrinsics.checkNotNullParameter(r105, "endViewRect");
        Intrinsics.checkNotNullParameter(r102, "targetView");
        Intrinsics.checkNotNullParameter(r115, "l");
        PointF r116 = new PointF(r101.left, r101.top);
        int r117 = r105.bottom;
        int r118 = r105.top;
        int r119 = r117 - r118;
        PointF r120 = new PointF(((r105.left + r105.right) / 2) - (r119 / 2), (float) ((((double) (r118 + r117)) / 1.8d) - (((double) r119) / 1.8d)));
        float r121 = 2;
        ValueAnimator r122 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.view.a.C1144a(new PointF(r116.x, (r120.y + r116.y) / r121), new PointF((r116.x + r120.x) / r121, r120.y)), new Object[]{r116, r120});
        r122.addUpdateListener(new b(r102));
        r122.addListener(r115);
        r122.setDuration(375);
        r122.start();
    L11:
        Rect r123 = new Rect(-1, -1, -1, -1);
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r110.f153598v = r123;
        return;
    L7:
        r103 = r112;
        goto L8
    L12:
        r210.invoke();
    }
}
