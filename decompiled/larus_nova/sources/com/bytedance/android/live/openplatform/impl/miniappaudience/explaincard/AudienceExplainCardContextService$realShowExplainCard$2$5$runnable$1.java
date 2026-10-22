package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.utils.z0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
public final class AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2.AnonymousClass5 f84827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f84828b;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 f84829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f84830b;

        @Override // com.bytedance.android.live.core.utils.s, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            AudienceExplainCardContextService r101 = this.f84829a.f84827a.this$0.this$0;
            int r102 = AudienceExplainCardContextService.f84816h;
            ((AudienceMiniAppAppLogContextService) r101.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLivePopupCardShowAnimEnd(this.f84829a.f84827a.this$0.$isFromEnter, false, ExplainCardAnimType.SELF_CARD);
            if (this.f84830b == false) goto L5;
            this.f84829a.f84827a.this$0.$widget.q(160, new AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1$1$onAnimationEnd$1(this));
            return;
        L5:
            this.f84829a.f84827a.this$0.$widget.f84843g.f();
            this.f84829a.f84828b.b();
        }

        public AnonymousClass1(AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 r100, boolean r101) {
            this.f84829a = r100;
            this.f84830b = r101;
        }
    }

    public AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1(AudienceExplainCardContextService$realShowExplainCard$2.AnonymousClass5 r100, w r101) {
        this.f84827a = r100;
        this.f84828b = r101;
    }

    public final void a() {
        AudienceExplainCardContextService$realShowExplainCard$2 r100 = this.f84827a.this$0;
        AudienceExplainCardContextService r101 = r100.this$0;
        boolean r102 = r100.$isFromEnter;
        int r103 = AudienceExplainCardContextService.f84816h;
        r101.getClass();
        float r104 = z0.b(false);
        if (r102 == true) goto L5;
    L8:
        boolean r105 = true;
    L9:
        ((AudienceMiniAppAppLogContextService) this.f84827a.this$0.this$0.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLivePopupCardShowAnimStart(this.f84827a.this$0.$isFromEnter, false, ExplainCardAnimType.SELF_CARD);
        AudienceExplainCardWidget r106 = this.f84827a.this$0.$widget;
        AnonymousClass1 r107 = new AnonymousClass1(this, r105);
        r106.getClass();
        HashMap<String, zo0.f> r108 = zo0.g.f573094a;
        zo0.f r109 = h.b(PerformanceScene.EXPLAIN_CARD);
        int r110 = zo0.f.f573090d;
        r109.l("card_anim_start", null);
        r106.g();
        if (r105 == true) goto L12;
        r106.f84843g.setScaleX(1.0f);
        r106.f84843g.setScaleY(1.0f);
        r106.f84843g.setAlpha(1.0f);
        r106.f84843g.post(new c(r106));
        r107.onAnimationEnd(new AnimatorSet());
        return;
    L12:
        Animator r111 = r106.j(250, TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(1.03f)), 140, TuplesKt.to(Float.valueOf(1.03f), Float.valueOf(1.0f)));
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r106.f84843g, "alpha", new float[]{0.0f, 1.0f});
        r112.setDuration(250);
        AnimatorSet r113 = new AnimatorSet();
        r113.play(r111).with(r112);
        r113.setInterpolator(new AccelerateInterpolator());
        Unit r114 = Unit.INSTANCE;
        r106.f84840d = r113;
        if (de0.f120026a.getValue().g() == false) goto L15;
        r106.t(r107);
        return;
    L15:
        r106.f84843g.post(new d(r106, r107));
        return;
    L5:
        if (r104 > de0.f120026a.getValue().a()) goto L8;
        r105 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
