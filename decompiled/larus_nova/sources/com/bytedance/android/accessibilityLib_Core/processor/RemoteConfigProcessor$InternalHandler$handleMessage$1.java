package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.remote.repo.ConfigFileProviderMode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor$InternalHandler$handleMessage$1", f = "RemoteConfigProcessor.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteConfigProcessor$InternalHandler$handleMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public RemoteConfigProcessor$InternalHandler$handleMessage$1(Continuation r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteConfigProcessor$InternalHandler$handleMessage$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteConfigProcessor$InternalHandler$handleMessage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L17:
        j6.b r104 = (j6.b) r100;
        CoroutineScope r105 = RemoteConfigProcessor.f38283a;
        if (r104 == null) goto L22;
        Boolean r106 = Boxing.boxBoolean(r104.f497478b);
        if (r106 == null) goto L22;
        boolean r107 = r106.booleanValue();
    L23:
        RemoteConfigProcessor.f38287e = r107;
        if (r104 != null) goto L26;
    L28:
        r103 = false;
    L29:
        RemoteConfigProcessor.a(r103);
        return Unit.INSTANCE;
    L26:
        if (r104.f497478b != true) goto L28;
    L22:
        r107 = false;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.bytedance.android.accessibilityLib_Core.config.remote.step.b r108 = RemoteConfigProcessor.f38284b;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadStep");
    L11:
        Boolean r109 = Boxing.boxBoolean(true);
        this.label = 1;
        r108.getClass();
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        j6.a r111 = r108.f38225a;
        if (r109 == null) goto L14;
        r109.booleanValue();
    L14:
        ConfigFileProviderMode r112 = ConfigFileProviderMode.LOCAL;
        r100 = r111.a();
        if (r100 != r101) goto L17;
        return r101;
    }
}
