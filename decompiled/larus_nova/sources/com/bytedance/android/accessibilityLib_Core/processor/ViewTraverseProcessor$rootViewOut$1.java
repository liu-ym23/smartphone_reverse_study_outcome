package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.WeakHashMap;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor$rootViewOut$1", f = "ViewTraverseProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewTraverseProcessor$rootViewOut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ View $activityRootView;
    int label;

    public ViewTraverseProcessor$rootViewOut$1(View r100, Continuation r101) {
        this.$activityRootView = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ViewTraverseProcessor$rootViewOut$1(this.$activityRootView, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Object> r101) {
        return ((ViewTraverseProcessor$rootViewOut$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r100);
        WeakHashMap<View, WeakHashMap<View, Boolean>> r101 = ViewTraverseProcessor.f38302d;     // Catch: Exception -> L21
        WeakHashMap<View, Boolean> r102 = r101.get(this.$activityRootView);     // Catch: Exception -> L21
        if (r102 == null) goto L14;
        monitor-enter(r102);     // Catch: Exception -> L21
        r102.clear();     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Exception -> L21
        goto L14
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L14:
        monitor-enter(r101);     // Catch: Exception -> L21
        WeakHashMap<View, Boolean> r104 = r101.remove(this.$activityRootView);     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Exception -> L21
        return r104;
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L26;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
