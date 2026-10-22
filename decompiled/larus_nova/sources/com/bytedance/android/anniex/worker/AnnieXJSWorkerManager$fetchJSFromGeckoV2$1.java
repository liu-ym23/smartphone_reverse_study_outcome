package com.bytedance.android.anniex.worker;

import com.bytedance.forest.model.RequestParams;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "_params", "Lcom/bytedance/forest/model/RequestParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXJSWorkerManager$fetchJSFromGeckoV2$1 extends Lambda implements Function1<RequestParams, Unit> {
    final /* synthetic */ RequestParams $params;

    public AnnieXJSWorkerManager$fetchJSFromGeckoV2$1(RequestParams r100) {
        this.$params = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RequestParams r100) {
        Intrinsics.checkNotNullParameter(r100, "_params");
        RequestParams r101 = this.$params;
        r100.f244285o = r101.f244285o;
        r100.D = r101.D;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RequestParams r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
