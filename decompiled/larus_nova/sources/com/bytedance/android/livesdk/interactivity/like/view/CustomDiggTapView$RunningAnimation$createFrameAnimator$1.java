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
final class CustomDiggTapView$RunningAnimation$createFrameAnimator$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ AccelerateDecelerateInterpolator $accelerateDecelerateInterpolator;
    final /* synthetic */ CustomDiggTapView.a $alphaStage1;
    final /* synthetic */ CustomDiggTapView.a $rotateStage1;
    final /* synthetic */ CustomDiggTapView.a $rotateStage2;
    final /* synthetic */ CustomDiggTapView.a $rotateStage3;
    final /* synthetic */ CustomDiggTapView.a $scaleStage1;
    final /* synthetic */ CustomDiggTapView.a $scaleStage2;
    final /* synthetic */ CustomDiggTapView.a $scaleStage3;
    final /* synthetic */ CustomDiggTapView.a $scaleStage4;
    final /* synthetic */ CustomDiggTapView.c this$0;

    public CustomDiggTapView$RunningAnimation$createFrameAnimator$1(CustomDiggTapView.c r100, CustomDiggTapView.a r101, AccelerateDecelerateInterpolator r102, CustomDiggTapView.a r103, CustomDiggTapView.a r104, CustomDiggTapView.a r105, CustomDiggTapView.a r106, CustomDiggTapView.a r107, CustomDiggTapView.a r108, CustomDiggTapView.a r110) {
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
