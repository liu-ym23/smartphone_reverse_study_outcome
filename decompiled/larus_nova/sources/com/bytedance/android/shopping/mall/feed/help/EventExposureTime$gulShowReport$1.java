package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$gulShowReport$1", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$gulShowReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $end;
    final /* synthetic */ long $start;
    int label;
    final /* synthetic */ EventExposureTime this$0;

    public EventExposureTime$gulShowReport$1(EventExposureTime r100, long r101, long r102, Continuation r103) {
        this.this$0 = r100;
        this.$start = r101;
        this.$end = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new EventExposureTime$gulShowReport$1(this.this$0, this.$start, this.$end, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EventExposureTime$gulShowReport$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
        r102.putOpt("page_name", this.this$0.f176927o.f176929a);     // Catch: Throwable -> L7
        r102.putOpt("btm", EventExposureTime.e(this.this$0));     // Catch: Throwable -> L7
        r102.putOpt("exposure_start", Boxing.boxLong(this.$start));     // Catch: Throwable -> L7
        r102.putOpt("exposure_end", Boxing.boxLong(this.$end));     // Catch: Throwable -> L7
        r102.putOpt("exposure_time", Boxing.boxLong(this.$end - this.$start));     // Catch: Throwable -> L7
        EventExposureTime r103 = this.this$0;     // Catch: Throwable -> L7
        int r104 = r103.f176915c + 1;     // Catch: Throwable -> L7
        r103.f176915c = r104;     // Catch: Throwable -> L7
        r102.putOpt("exposure_num", Boxing.boxInt(r104));     // Catch: Throwable -> L7
        AppLogNewUtils.onEventV3("mall_gyl_show_time", r102);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
