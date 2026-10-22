package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/livecommerce/intro/manager/IntroCardAnimController$executeAnim$1$1"}, k = 3, mv = {1, 4, 3})
final class IntroCardAnimController$executeAnim$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $it;
    final /* synthetic */ IntroCardAnimController this$0;

    public IntroCardAnimController$executeAnim$$inlined$let$lambda$1(a r100, IntroCardAnimController r101) {
        this.$it = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IntroCardAnimController r100 = this.this$0;
        int r101 = IntroCardAnimController.f148347k;
        r100.getClass();
        this.$it.b();
        a r102 = this.$it;
        r102.f148379e.invoke(r102.f148377c, new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
