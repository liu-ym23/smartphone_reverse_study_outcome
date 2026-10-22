package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/kmp/ec/yata/chain/event/b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/kmp/ec/yata/chain/event/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LynxAbilityImpl$registerLynxHandler$3$onReceiveJsEvent$1 extends Lambda implements Function1<com.bytedance.kmp.ec.yata.chain.event.b, Unit> {
    public static final LynxAbilityImpl$registerLynxHandler$3$onReceiveJsEvent$1 INSTANCE = null;

    static {
        INSTANCE = new LynxAbilityImpl$registerLynxHandler$3$onReceiveJsEvent$1();
    }

    public LynxAbilityImpl$registerLynxHandler$3$onReceiveJsEvent$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.kmp.ec.yata.chain.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.kmp.ec.yata.chain.event.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
