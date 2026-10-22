package com.bytedance.ai.applet.domain;

import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager$prefetch$1$1", f = "AppletDomainPolicyManager.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class AppletDomainPolicyManager$prefetch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $normalizedAppKey;
    final /* synthetic */ String $source;
    final /* synthetic */ AppletDomainPolicyManager $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AppletDomainPolicyManager$prefetch$1$1(AppletDomainPolicyManager r100, String r101, String r102, Continuation<? super AppletDomainPolicyManager$prefetch$1$1> r103) {
        this.$this_runCatching = r100;
        this.$normalizedAppKey = r101;
        this.$source = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AppletDomainPolicyManager$prefetch$1$1 r102 = new AppletDomainPolicyManager$prefetch$1$1(this.$this_runCatching, this.$normalizedAppKey, this.$source, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppletDomainPolicyManager$prefetch$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L9;
        String r102 = (String) this.L$1;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L20
        Object r111 = ((Result) r110).m9458unboximpl();     // Catch: Throwable -> L20
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L20
        if (r104 == null) goto L18;
        g.f37637a.e("AppletDomainPolicyManager", "prefetch failed, appKey:" + r103 + ", source:" + r102 + ", error:" + r104.getMessage());     // Catch: Throwable -> L20
    L18:
        Object r112 = Result.m9449constructorimpl(Result.m9448boximpl(r111));     // Catch: Throwable -> L20
    L22:
        String r105 = this.$normalizedAppKey;
        String r106 = this.$source;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L26;
        g.f37637a.e("AppletDomainPolicyManager", "prefetch crashed, appKey:" + r105 + ", source:" + r106 + ", error:" + r113.getMessage());
    L26:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        AppletDomainPolicyManager r115 = this.$this_runCatching;
        r103 = this.$normalizedAppKey;
        String r107 = this.$source;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        this.L$0 = r103;     // Catch: Throwable -> L20
        this.L$1 = r107;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        AppletDomainPolicyManager r109 = AppletDomainPolicyManager.f34590a;     // Catch: Throwable -> L20
        r111 = r115.g(r103, r107, this);     // Catch: Throwable -> L20
        if (r111 != r100) goto L14;
        return r100;
    L14:
        r102 = r107;
    L20:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
