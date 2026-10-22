package com.bytedance.applet.debugger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ai.api.DebuggerOpenArgs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerServiceImpl$createAndOpenSession$3$1", f = "AppletDebuggerServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebuggerServiceImpl$createAndOpenSession$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DebuggerOpenArgs $openArgs;
    int label;

    public AppletDebuggerServiceImpl$createAndOpenSession$3$1(Context r100, DebuggerOpenArgs r101, Continuation<? super AppletDebuggerServiceImpl$createAndOpenSession$3$1> r102) {
        this.$context = r100;
        this.$openArgs = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppletDebuggerServiceImpl$createAndOpenSession$3$1(this.$context, this.$openArgs, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppletDebuggerServiceImpl$createAndOpenSession$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        Intent r101 = new Intent(this.$context, AppletDebuggerActivity.class);
        DebuggerOpenArgs r102 = this.$openArgs;
        Context r103 = this.$context;
        r101.putExtra("applet_debugger_open_args", r102);
        if ((r103 instanceof Activity) == true) goto L7;
        r101.addFlags(268435456);
    L7:
        this.$context.startActivity(r101);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
