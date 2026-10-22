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
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.help.EventExposureTime$reportRepeat$1", f = "EventExposureTime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventExposureTime$reportRepeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ String $logId1;
    final /* synthetic */ String $logId2;
    final /* synthetic */ int $repeatNum;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ EventExposureTime this$0;

    public EventExposureTime$reportRepeat$1(EventExposureTime r100, int r101, int r102, String r103, String r104, String r105, Continuation r106) {
        this.this$0 = r100;
        this.$repeatNum = r101;
        this.$index = r102;
        this.$logId1 = r103;
        this.$logId2 = r104;
        this.$type = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "completion");
        return new EventExposureTime$reportRepeat$1(this.this$0, this.$repeatNum, this.$index, this.$logId1, this.$logId2, this.$type, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EventExposureTime$reportRepeat$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        r102.putOpt("repeat_num", Boxing.boxInt(this.$repeatNum));     // Catch: Throwable -> L7
        r102.putOpt("index", Boxing.boxInt(this.$index));     // Catch: Throwable -> L7
        r102.putOpt("log1", this.$logId1);     // Catch: Throwable -> L7
        r102.putOpt("log2", this.$logId2);     // Catch: Throwable -> L7
        r102.putOpt("business_type", this.$type);     // Catch: Throwable -> L7
        AppLogNewUtils.onEventV3("mall_card_type_repeat", r102);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
