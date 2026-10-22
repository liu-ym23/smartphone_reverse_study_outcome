package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f157d;

        public a(ProducerScope r10, View r11, ViewTreeObserver.OnScrollChangedListener r12, View.OnLayoutChangeListener r13) {
            this.f154a = r10;
            this.f155b = r11;
            this.f156c = r12;
            this.f157d = r13;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            this.f154a.mo53trySendJP2dKIU(p.a(this.f155b));
            this.f155b.getViewTreeObserver().addOnScrollChangedListener(this.f156c);
            this.f155b.addOnLayoutChangeListener(this.f157d);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            r10.getViewTreeObserver().removeOnScrollChangedListener(this.f156c);
            r10.removeOnLayoutChangeListener(this.f157d);
        }
    }

    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r10, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r11) {
        this.$view = r10;
        super(2, r11);
    }

    public static /* synthetic */ void a(ProducerScope r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        invokeSuspend$lambda$0(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void b(ProducerScope r10, View r11) {
        invokeSuspend$lambda$1(r10, r11);
    }

    private static final void invokeSuspend$lambda$0(ProducerScope r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (r12 != r16) goto L6;
        if (r14 != r18) goto L6;
        if (r13 != r17) goto L6;
        if (r15 != r19) goto L6;
        return;
    L6:
        r10.mo53trySendJP2dKIU(p.a(r11));
    }

    private static final void invokeSuspend$lambda$1(ProducerScope r10, View r11) {
        r10.mo53trySendJP2dKIU(p.a(r11));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r12 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Rect> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L15:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        final ProducerScope r13 = (ProducerScope) this.L$0;
        final View.OnLayoutChangeListener r14 = new n(r13);
        final View r15 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r16 = new o(r13, r15);
        final a r17 = new a(r13, this.$view, r16, r14);
        if (androidx.activity.a.f163a.a(this.$view) == false) goto L11;
        r13.mo53trySendJP2dKIU(p.a(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r16);
        this.$view.addOnLayoutChangeListener(r14);
    L11:
        this.$view.addOnAttachStateChangeListener(r17);
        final View r18 = this.$view;
        Function0<Unit> r19 = new AnonymousClass1(r18, r16, r14, r17);
        this.label = 1;
        if (ProduceKt.a(r13, r19, this) != r11) goto L15;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Rect> r10, @Nullable Continuation<? super Unit> r11) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
