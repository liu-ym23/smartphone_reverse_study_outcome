package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/accessibilityLib_Core/processor/ViewTraverseProcessor$traverseView$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor$traverseView$1$1", f = "ViewTraverseProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $activityRootView$inlined;
    final /* synthetic */ int $resource$inlined;
    final /* synthetic */ TraverseFromType $traverseFromType$inlined;
    final /* synthetic */ WeakReference $weakRefRoot;
    int label;

    public ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(WeakReference r100, Continuation r101, View r102, TraverseFromType r103, int r104) {
        this.$weakRefRoot = r100;
        this.$activityRootView$inlined = r102;
        this.$traverseFromType$inlined = r103;
        this.$resource$inlined = r104;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(this.$weakRefRoot, r101, this.$activityRootView$inlined, this.$traverseFromType$inlined, this.$resource$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r100);
        View r101 = (View) this.$weakRefRoot.get();
        if (r101 == null) goto L55;
        if (r101.isAttachedToWindow() == false) goto L9;
        WeakHashMap<View, WeakHashMap<View, Boolean>> r102 = ViewTraverseProcessor.f38302d;
        final WeakHashMap<View, Boolean> r103 = r102.get(r101);
        if (r103 != null) goto L17;
        r103 = new WeakHashMap();
    L17:
        monitor-enter(r103);
        final int r104 = this.$resource$inlined;     // Catch: Throwable -> L51
        final TraverseFromType r105 = this.$traverseFromType$inlined;     // Catch: Throwable -> L51
        AccessibilityCommonToolExtKt.b(r101, new ViewTraverseProcessor$bfsVisitWithDiffTreeNode$1(r105, r103), new ViewTraverseProcessor$bfsVisitWithDiffTreeNode$2(r103, r105, r104));     // Catch: Throwable -> L51
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r103);
        monitor-enter(r102);
        r102.put(r101, r103);     // Catch: Throwable -> L48
        monitor-exit(r102);
        WeakReference r107 = this.$weakRefRoot;
    L41:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L45;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L45:
        Context r109 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        Unit r110 = Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L25:
        if (e.a(this.$traverseFromType$inlined) == false) goto L47;
        if (com.bytedance.android.accessibilityLib_Core.engine.b.f38251c == false) goto L47;
        View r111 = (View) r107.get();     // Catch: Exception -> L41
        if (r111 == null) goto L33;
        ViewTreeObserver r112 = r111.getViewTreeObserver();     // Catch: Exception -> L41
    L34:
        if (r112 != null) goto L36;
    L38:
        if (r112 == null) goto L47;
        r112.addOnGlobalLayoutListener(new d(r107));     // Catch: Exception -> L41
        goto L47
    L36:
        if (r112.isAlive() == true) goto L38;
    L33:
        r112 = null;
    L48:
        th = move-exception;
        throw th;
    L51:
        th = move-exception;
        throw th;
    L9:
        if ((r101 + " don't attached window again ,return ") == null) goto L12;
        Context r113 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L12:
        return Unit.INSTANCE;
    L55:
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
