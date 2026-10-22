package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import ju1.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PublicScreenSpeedStrategyV2$traceResult$1 extends Lambda implements Function0<String> {
    final /* synthetic */ n $result;

    public PublicScreenSpeedStrategyV2$traceResult$1(n r100) {
        this.$result = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "current state is " + this.$result.c() + ", factor state is: " + ((ju1.g) this.$result).f500408c + ", factors value is: " + GsonProtectorUtils.toJson(GsonHelper.get(), ((ju1.g) this.$result).f500409d);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
