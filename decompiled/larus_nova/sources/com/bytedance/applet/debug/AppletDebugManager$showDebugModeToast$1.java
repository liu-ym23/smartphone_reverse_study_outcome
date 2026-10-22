package com.bytedance.applet.debug;

import android.widget.Toast;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.bytedance.applet.debug.AppletDebugManager$showDebugModeToast$1", f = "AppletDebugManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugManager$showDebugModeToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $message;
    int label;

    public AppletDebugManager$showDebugModeToast$1(boolean r100, String r101, Continuation<? super AppletDebugManager$showDebugModeToast$1> r102) {
        this.$isSuccess = r100;
        this.$message = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppletDebugManager$showDebugModeToast$1(this.$isSuccess, this.$message, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppletDebugManager$showDebugModeToast$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        if (this.$isSuccess == false) goto L7;
        String r101 = "鉴权成功，调试通道已开启";
    L10:
        Toast.makeText(AppHost.f326268a.getApplication(), r101, 0).show();
        return Unit.INSTANCE;
    L7:
        r101 = this.$message;
        if (r101 != null) goto L10;
        r101 = "扫码处理失败";
        goto L10
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
