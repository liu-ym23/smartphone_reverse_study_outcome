package com.bytedance.applet.aibridge;

import android.app.Activity;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.PreviewImageMethod$previewImages$1", f = "PreviewImageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewImageMethod$previewImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $footInfos;
    final /* synthetic */ List<String> $imageUrls;
    final /* synthetic */ int $index;
    final /* synthetic */ List<String> $templateURLs;
    final /* synthetic */ List<String> $trackerInfo;
    int label;

    public PreviewImageMethod$previewImages$1(List<String> r100, int r101, List<String> r102, List<String> r103, List<String> r104, Continuation<? super PreviewImageMethod$previewImages$1> r105) {
        this.$imageUrls = r100;
        this.$index = r101;
        this.$templateURLs = r102;
        this.$footInfos = r103;
        this.$trackerInfo = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PreviewImageMethod$previewImages$1(this.$imageUrls, this.$index, this.$templateURLs, this.$footInfos, this.$trackerInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PreviewImageMethod$previewImages$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.content.Context");
        com.larus.bmhome.bigimg.k.b(r100, this.$imageUrls, this.$index, new uo8.k(MapsKt.mapOf(new Pair[]{TuplesKt.to("user_type", PrefetchTiming.JSB), TuplesKt.to("enter_picture_method", PrefetchTiming.JSB), TuplesKt.to("enter_from", "chat")}), null), true, this.$templateURLs, this.$footInfos, this.$trackerInfo, 2144);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
