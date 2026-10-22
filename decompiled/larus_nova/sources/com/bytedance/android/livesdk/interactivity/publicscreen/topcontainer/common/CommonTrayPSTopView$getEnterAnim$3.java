package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CommonTrayPSTopView$getEnterAnim$3 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ f52.b $container;
    final /* synthetic */ Function0 $onEnd;
    final /* synthetic */ CommonTrayView $trayView;

    public CommonTrayPSTopView$getEnterAnim$3(CommonTrayView r100, f52.b r101, Function0 r102) {
        this.$trayView = r100;
        this.$container = r101;
        this.$onEnd = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q4 r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.d(new AnonymousClass1(this));
        r100.f159135f = this.$onEnd;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(q4 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
