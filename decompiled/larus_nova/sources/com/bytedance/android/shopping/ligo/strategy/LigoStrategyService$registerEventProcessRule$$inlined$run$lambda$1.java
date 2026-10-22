package com.bytedance.android.shopping.ligo.strategy;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import d93.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/ligo/strategy/LigoStrategyService$registerEventProcessRule$2$1"}, k = 3, mv = {1, 4, 3})
final class LigoStrategyService$registerEventProcessRule$$inlined$run$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ f $rule$inlined;

    public LigoStrategyService$registerEventProcessRule$$inlined$run$lambda$1(f r100) {
        this.$rule$inlined = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "register rule error: create processor null! rule=" + this.$rule$inlined;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
