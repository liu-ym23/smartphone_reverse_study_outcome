package com.obric.appintents.phone;

import android.content.Context;
import android.content.Intent;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PhoneCallIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appintents.phone.PhoneCallIntent$openInCallWithNumber$2$2", f = "PhoneCallIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PhoneCallIntent$openInCallWithNumber$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    int label;

    PhoneCallIntent$openInCallWithNumber$2$2(Intent r1, Context r2, Continuation<? super PhoneCallIntent$openInCallWithNumber$2$2> r3) {
        this.$intent = r1;
        this.$context = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PhoneCallIntent$openInCallWithNumber$2$2(this.$intent, this.$context, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((PhoneCallIntent$openInCallWithNumber$2$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        this.$intent.addFlags(268435456);
        this.$intent.addFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        this.$context.startActivity(this.$intent);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent(null, 1, null));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
