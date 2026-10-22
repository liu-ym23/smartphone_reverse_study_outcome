package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/k;", "Landroid/graphics/Rect;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<k<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r100, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r101) {
        this.$view = r100;
        super(2, r101);
    }

    public static /* synthetic */ void a(k r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        invokeSuspend$lambda$0(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* synthetic */ void c(k r100, View r101) {
        invokeSuspend$lambda$1(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r102 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super Rect> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super Rect> r100, Continuation<? super Unit> r101) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        final k r103 = (k) this.L$0;
        final View.OnLayoutChangeListener r104 = new i(r103);
        final View r105 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r106 = new j(r103, r105);
        final ?? r107 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r103, r105, r106, r104);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        r103.mo10962trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r106);
        this.$view.addOnLayoutChangeListener(r104);
    L11:
        this.$view.addOnAttachStateChangeListener(r107);
        final View r108 = this.$view;
        Function0<Unit> r109 = new AnonymousClass1(r108, r106, r104, r107);
        this.label = 1;
        if (ProduceKt.a(r103, r109, this) != r101) goto L15;
        return r101;
    }

    private static final void invokeSuspend$lambda$1(k r100, View r101) {
        r100.mo10962trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r101));
    }

    private static final void invokeSuspend$lambda$0(k r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        if (r102 != r106) goto L6;
        if (r104 != r108) goto L6;
        if (r103 != r107) goto L6;
        if (r105 != r109) goto L6;
        return;
    L6:
        r100.mo10962trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r101));
    }
}
