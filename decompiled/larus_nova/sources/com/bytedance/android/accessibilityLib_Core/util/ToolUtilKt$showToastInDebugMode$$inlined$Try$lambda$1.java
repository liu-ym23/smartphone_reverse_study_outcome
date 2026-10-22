package com.bytedance.android.accessibilityLib_Core.util;

import android.widget.Toast;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/accessibilityLib_Core/util/ToolUtilKt$showToastInDebugMode$2$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.util.ToolUtilKt$showToastInDebugMode$2$1", f = "ToolUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ToolUtilKt$showToastInDebugMode$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation $continuation$inlined;
    final /* synthetic */ String $message$inlined;
    int label;

    public ToolUtilKt$showToastInDebugMode$$inlined$Try$lambda$1(Continuation r100, Continuation r101, String r102) {
        this.$continuation$inlined = r101;
        this.$message$inlined = r102;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ToolUtilKt$showToastInDebugMode$$inlined$Try$lambda$1(r101, this.$continuation$inlined, this.$message$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ToolUtilKt$showToastInDebugMode$$inlined$Try$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Toast.makeText(com.bytedance.android.accessibilityLib_Core.helper.a.a(), this.$message$inlined, 0).show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
