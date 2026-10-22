package android.view;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import o9.C1785k;
import o9.InterfaceC1786l;

@c(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {86}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo9/l;", "Landroid/graphics/Rect;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements n {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, H7.c<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> cVar) {
        super(2, cVar);
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(InterfaceC1786l interfaceC1786l, View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i == i12 && i10 == i14 && i6 == i13 && i11 == i15) {
            return;
        }
        k.c(view);
        ((C1785k) interfaceC1786l).a(Activity.trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(InterfaceC1786l interfaceC1786l, View view) {
        ((C1785k) interfaceC1786l).a(Activity.trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$2(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
        view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        view.removeOnLayoutChangeListener(onLayoutChangeListener);
        view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
        return r.f317a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, cVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View$OnLayoutChangeListener, androidx.activity.m] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewTreeObserver$OnScrollChangedListener, androidx.activity.n] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            final InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.L$0;
            final ?? r1 = new View.OnLayoutChangeListener() { // from class: androidx.activity.m
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(interfaceC1786l, view, i6, i10, i11, i12, i13, i14, i15, i16);
                }
            };
            final View view = this.$view;
            final ?? r42 = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.n
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(interfaceC1786l, view);
                }
            };
            final ?? r5 = new View.OnAttachStateChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v10) {
                    k.f(v10, "v");
                    ((C1785k) interfaceC1786l).a(Activity.trackPipAnimationHintView$positionInWindow(view));
                    view.getViewTreeObserver().addOnScrollChangedListener(r42);
                    view.addOnLayoutChangeListener(r1);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v10) {
                    k.f(v10, "v");
                    v10.getViewTreeObserver().removeOnScrollChangedListener(r42);
                    v10.removeOnLayoutChangeListener(r1);
                }
            };
            if (this.$view.isAttachedToWindow()) {
                ((C1785k) interfaceC1786l).a(Activity.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(r42);
                this.$view.addOnLayoutChangeListener(r1);
            }
            this.$view.addOnAttachStateChangeListener(r5);
            final View view2 = this.$view;
            a aVar = new a() { // from class: androidx.activity.o
                @Override // S7.a
                public final Object invoke() {
                    return PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$2(view2, r42, r1, r5);
                }
            };
            this.label = 1;
            if (kotlinx.coroutines.channels.b.a(interfaceC1786l, aVar, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
    }
}
