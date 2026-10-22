package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.TopNavigationComponentV2$processShareButton$1$run$1", f = "TopNavigationComponentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopNavigationComponentV2$processShareButton$1$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TopNavigationComponentV2$processShareButton$1 this$0;

    public TopNavigationComponentV2$processShareButton$1$run$1(TopNavigationComponentV2$processShareButton$1 r100, Continuation r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        TopNavigationComponentV2$processShareButton$1$run$1 r102 = new TopNavigationComponentV2$processShareButton$1$run$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TopNavigationComponentV2$processShareButton$1$run$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L26
        Object r103 = Result.m9449constructorimpl(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis())));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        String r104 = (String) r103;     // Catch: Throwable -> L26
        if (r104 == null) goto L16;
        q r105 = q.f48131a;     // Catch: Throwable -> L26
        if ((!Intrinsics.areEqual(r105.getString("share_button_bubble_date", r104), r104)) == false) goto L22;
        r105.d(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, 0);     // Catch: Throwable -> L26
    L22:
        if (Intrinsics.areEqual(this.this$0.f181226d.isDisplayShareTouchPoint(), Boxing.boxBoolean(true)) == false) goto L24;
        r105.d(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, r105.getInt(ECShareFission.SHARE_BUTTON_BUBBLE_TIMES, 0) + 1);     // Catch: Throwable -> L26
    L24:
        r105.putString("share_button_bubble_date", r104);     // Catch: Throwable -> L26
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L32;
        ECExceptionMonitor.e(r107);
    L32:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L26
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
