package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ FoldingFeatureObserver this$0;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FoldingFeatureObserver f4741a;

        public a(FoldingFeatureObserver r10) {
            this.f4741a = r10;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Object r10, Continuation r11) {
            FoldingFeature r12 = (FoldingFeature) r10;
            FoldingFeatureObserver.OnFoldingFeatureChangeListener r13 = FoldingFeatureObserver.b(this.f4741a);
            if (r13 != null) goto L5;
            Unit r14 = null;
        L7:
            if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L10;
            return r14;
        L10:
            return Unit.f21064a;
        L5:
            r13.onFoldingFeatureChange(r12);
            r14 = Unit.f21064a;
            goto L7
        }
    }

    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver r10, Activity r11, Continuation<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1> r12) {
        this.this$0 = r10;
        this.$activity = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.this$0, this.$activity, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        final Flow<i> r13 = FoldingFeatureObserver.c(this.this$0).windowLayoutInfo(this.$activity);
        final FoldingFeatureObserver r14 = this.this$0;
        Flow r15 = kotlinx.coroutines.flow.c.n(new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(r13, r14));
        a r16 = new a(this.this$0);
        this.label = 1;
        if (r15.collect(r16, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
