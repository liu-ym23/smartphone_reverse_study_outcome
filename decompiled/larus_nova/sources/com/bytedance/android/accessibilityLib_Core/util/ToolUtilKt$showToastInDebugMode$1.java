package com.bytedance.android.accessibilityLib_Core.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"", "message", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "showToastInDebugMode"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.util.ToolUtilKt", f = "ToolUtil.kt", i = {}, l = {13}, m = "showToastInDebugMode", n = {}, s = {})
final class ToolUtilKt$showToastInDebugMode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ToolUtilKt$showToastInDebugMode$1(Continuation r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ToolUtilKt$showToastInDebugMode$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L17
        return Unit.INSTANCE;
    L9:
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L17
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L17
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L21;
        Context r107 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L21:
        Unit r108 = Unit.INSTANCE;
        goto L23
    L5:
        r102 = new ToolUtilKt$showToastInDebugMode$1(this);
        goto L6
    }
}
