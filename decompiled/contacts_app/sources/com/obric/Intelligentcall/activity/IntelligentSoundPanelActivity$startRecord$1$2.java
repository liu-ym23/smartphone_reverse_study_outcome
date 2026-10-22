package com.obric.Intelligentcall.activity;

import com.GlobalProxyLancet;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntelligentSoundPanelActivity$startRecord$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IntelligentSoundPanelActivity this$0;

    public static /* synthetic */ void $r8$lambda$k0NB8CcxXhTp48wnhrNdzJtrdEw(IntelligentSoundPanelActivity r0) {
        invoke$lambda$0(r0);
    }

    IntelligentSoundPanelActivity$startRecord$1$2(IntelligentSoundPanelActivity r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IntelligentSoundPanelActivity.access$isRecording$p(this.this$0).set(false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("IntelligentSoundPanelActivity", "startRecord 停止检测");
        final IntelligentSoundPanelActivity r2 = this.this$0;
        r2.runOnUiThread(new IntelligentSoundPanelActivity$startRecord$1$2$$ExternalSyntheticLambda0(r2));
    }

    private static final void invoke$lambda$0(IntelligentSoundPanelActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        LottieAnimationView r2 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(r1);
        if (r2 == null) goto L6;
        r2.pauseAnimation();
        return;
    }
}
