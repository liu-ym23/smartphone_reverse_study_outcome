package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class DiggTapOptimizeView$RunningAnimation$createFrameAnimator$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ AccelerateDecelerateInterpolator $accelerateDecelerateInterpolator;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $alphaStage1;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $rotateStage1;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $rotateStage2;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $rotateStage3;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $scaleStage1;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $scaleStage2;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $scaleStage3;
    final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.utils.a $scaleStage4;
    final /* synthetic */ DiggTapOptimizeView.b this$0;

    public DiggTapOptimizeView$RunningAnimation$createFrameAnimator$1(DiggTapOptimizeView.b r100, com.bytedance.android.livesdk.interactivity.like.utils.a r101, AccelerateDecelerateInterpolator r102, com.bytedance.android.livesdk.interactivity.like.utils.a r103, com.bytedance.android.livesdk.interactivity.like.utils.a r104, com.bytedance.android.livesdk.interactivity.like.utils.a r105, com.bytedance.android.livesdk.interactivity.like.utils.a r106, com.bytedance.android.livesdk.interactivity.like.utils.a r107, com.bytedance.android.livesdk.interactivity.like.utils.a r108, com.bytedance.android.livesdk.interactivity.like.utils.a r110) {
        this.this$0 = r100;
        this.$scaleStage1 = r101;
        this.$accelerateDecelerateInterpolator = r102;
        this.$scaleStage2 = r103;
        this.$scaleStage3 = r104;
        this.$scaleStage4 = r105;
        this.$rotateStage1 = r106;
        this.$rotateStage2 = r107;
        this.$rotateStage3 = r108;
        this.$alphaStage1 = r110;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q4 r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.b(new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
