package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.api.mall.feed.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
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
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent$tryInitGulSdkComponent$1", f = "GULSDKComponent.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class GULSDKComponent$tryInitGulSdkComponent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GULSDKComponent this$0;

    public GULSDKComponent$tryInitGulSdkComponent$1(GULSDKComponent r100, Continuation r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new GULSDKComponent$tryInitGulSdkComponent$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GULSDKComponent$tryInitGulSdkComponent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        d r103 = (d) r100;
        if (r103 != null) goto L17;
        r103 = GULSDKComponent.h2(this.this$0);
    L17:
        GULSDKComponent r104 = this.this$0;
        if (r103 == null) goto L20;
        int r105 = GULSDKComponent.f181734t;
        r104.j2(r103);
        Unit r106 = Unit.INSTANCE;
    L21:
        r104.f181736n = r103;
        return Unit.INSTANCE;
    L20:
        r103 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Deferred<? extends d> r107 = this.this$0.f181737o;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("componentLoadJob");
    L11:
        this.label = 1;
        r100 = r107.await(this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
