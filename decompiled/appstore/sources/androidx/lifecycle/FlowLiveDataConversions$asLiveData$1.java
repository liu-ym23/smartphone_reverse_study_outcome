package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/lifecycle/LiveDataScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
final class FlowLiveDataConversions$asLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDataScope f3426a;

        public a(LiveDataScope r10) {
            this.f3426a = r10;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            Object r12 = this.f3426a.emit(r10, r11);
            if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r12;
        L6:
            return Unit.f21064a;
        }
    }

    public FlowLiveDataConversions$asLiveData$1(Flow<Object> r10, Continuation<? super FlowLiveDataConversions$asLiveData$1> r11) {
        this.$this_asLiveData = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowLiveDataConversions$asLiveData$1 r12 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull LiveDataScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowLiveDataConversions$asLiveData$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        LiveDataScope r13 = (LiveDataScope) this.L$0;
        Flow<Object> r14 = this.$this_asLiveData;
        a r15 = new a(r13);
        this.label = 1;
        if (r14.collect(r15, this) != r11) goto L12;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(LiveDataScope<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }
}
