package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/a;", "event", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/vm/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class KIntroCardPresenter$bind$5 extends Lambda implements Function1<com.bytedance.android.livesdk.livecommerce.intro.card.vm.a, Unit> {
    final /* synthetic */ j this$0;

    public KIntroCardPresenter$bind$5(j r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.livesdk.livecommerce.intro.card.vm.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        j.E(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.livecommerce.intro.card.vm.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
