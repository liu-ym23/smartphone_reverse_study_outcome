package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.ECPreloadGeckoChannelUtil$startPreload$1", f = "ECPreloadGeckoChannelUtil.kt", i = {1}, l = {43, 49}, m = "invokeSuspend", n = {RXScreenCaptureService.KEY_INDEX}, s = {"I$0"})
public final class ECPreloadGeckoChannelUtil$startPreload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $channels;
    int I$0;
    int I$1;
    int label;

    public ECPreloadGeckoChannelUtil$startPreload$1(List r100, Continuation r101) {
        this.$channels = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new ECPreloadGeckoChannelUtil$startPreload$1(this.$channels, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ECPreloadGeckoChannelUtil$startPreload$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        int r102 = this.I$1;
        int r103 = this.I$0;
        ResultKt.throwOnFailure(r110);
        ECPreloadGeckoChannelUtil$startPreload$1 r111 = this;
    L20:
        boolean r104 = ECPreloadGeckoChannelUtil.f153043a;
        if (ECPreloadGeckoChannelUtil.b(r111.$channels, ECPreloadGeckoChannelUtil.f153044b) == true) goto L24;
        r103 = r103 + 1;
    L16:
        if (r103 > r102) goto L24;
        r111.I$0 = r103;
        r111.I$1 = r102;
        r111.label = 2;
        if (DelayKt.delay(60000, r111) != r100) goto L20;
        return r100;
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L13:
        boolean r112 = ECPreloadGeckoChannelUtil.f153043a;
        if (ECPreloadGeckoChannelUtil.b(this.$channels, ECPreloadGeckoChannelUtil.f153044b) == true) goto L24;
        r111 = this;
        r102 = 5;
        r103 = 1;
        goto L16
    L10:
        ResultKt.throwOnFailure(r110);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r100) goto L13;
        return r100;
    }
}
