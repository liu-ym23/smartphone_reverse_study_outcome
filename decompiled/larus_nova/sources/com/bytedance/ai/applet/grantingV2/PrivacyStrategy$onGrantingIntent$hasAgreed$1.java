package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PrivacyStrategy$onGrantingIntent$hasAgreed$1", f = "PrivacyStrategy.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class PrivacyStrategy$onGrantingIntent$hasAgreed$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ u2.c $meta;
    int label;
    final /* synthetic */ PrivacyStrategy this$0;

    public PrivacyStrategy$onGrantingIntent$hasAgreed$1(PrivacyStrategy r100, u2.c r101, Continuation<? super PrivacyStrategy$onGrantingIntent$hasAgreed$1> r102) {
        this.this$0 = r100;
        this.$meta = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new PrivacyStrategy$onGrantingIntent$hasAgreed$1(this.this$0, this.$meta, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((PrivacyStrategy$onGrantingIntent$hasAgreed$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        PrivacyStrategy r103 = this.this$0;
        u2.c r104 = this.$meta;
        String r105 = r104.f548386a;
        String r106 = r104.f548389d;
        this.label = 1;
        int r107 = PrivacyStrategy.f34656d;
        r100 = r103.k(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
