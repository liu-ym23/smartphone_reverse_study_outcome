package com.bytedance.android.livesdk.revenue.external.hybrid;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/gson/JsonElement;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveRevenueHybridServiceImpl$BaseStateImpl$attachStub$1 extends Lambda implements Function1<JsonElement, Unit> {
    final /* synthetic */ LiveRevenueHybridServiceImpl.a this$0;

    public LiveRevenueHybridServiceImpl$BaseStateImpl$attachStub$1(LiveRevenueHybridServiceImpl.a r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JsonElement r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.i(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JsonElement r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
