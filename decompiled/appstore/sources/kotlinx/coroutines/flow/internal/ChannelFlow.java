package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChannelFlow implements FusibleFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f21519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f21521c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlow$collect$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Object> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChannelFlow this$0;

        public AnonymousClass2(FlowCollector<Object> r10, ChannelFlow r11, Continuation<? super AnonymousClass2> r12) {
            this.$collector = r10;
            this.this$0 = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.$collector, this.this$0, r11);
            r12.L$0 = r10;
            return r12;
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
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            FlowCollector<Object> r14 = this.$collector;
            ReceiveChannel r15 = this.this$0.h(r13);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.q(r14, r15, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public ChannelFlow(CoroutineContext r10, int r11, BufferOverflow r12) {
        this.f21519a = r10;
        this.f21520b = r11;
        this.f21521c = r12;
    }

    public static /* synthetic */ Object b(ChannelFlow r10, FlowCollector r11, Continuation r12) {
        Object r13 = d0.e(new AnonymousClass2(r11, r10, null), r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    public String a() {
        return null;
    }

    public abstract Object c(ProducerScope r10, Continuation r11);

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        return b(this, r10, r11);
    }

    public abstract ChannelFlow d(CoroutineContext r10, int r11, BufferOverflow r12);

    public Flow e() {
        return null;
    }

    public final Function2 f() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow fuse(CoroutineContext r10, int r11, BufferOverflow r12) {
        CoroutineContext r13 = r10.plus(this.f21519a);
        if (r12 != BufferOverflow.SUSPEND) goto L21;
        int r14 = this.f21520b;
        if (r14 == (-3)) goto L19;
        if (r11 != (-3)) goto L11;
    L9:
        r11 = r14;
        goto L19
    L11:
        if (r14 == (-2)) goto L19;
        if (r11 == (-2)) goto L9;
        r11 = r11 + r14;
        if (r11 >= 0) goto L19;
        r11 = Channel.UNLIMITED;
    L19:
        r12 = this.f21521c;
    L21:
        if (kotlin.jvm.internal.q.b(r13, this.f21519a) == false) goto L28;
        if (r11 != this.f21520b) goto L28;
        if (r12 != this.f21521c) goto L28;
        return this;
    L28:
        return d(r13, r11, r12);
    }

    public final int g() {
        int r10 = this.f21520b;
        if (r10 != (-3)) goto L6;
        return -2;
    L6:
        return r10;
    }

    public ReceiveChannel h(CoroutineScope r10) {
        return ProduceKt.e(r10, this.f21519a, g(), this.f21521c, CoroutineStart.ATOMIC, null, f(), 16, null);
    }

    public String toString() {
        ArrayList r10 = new ArrayList(4);
        String r11 = a();
        if (r11 == null) goto L6;
        r10.add(r11);
    L6:
        if (this.f21519a == EmptyCoroutineContext.INSTANCE) goto L9;
        r10.add("context=" + this.f21519a);
    L9:
        if (this.f21520b == (-3)) goto L12;
        r10.add("capacity=" + this.f21520b);
    L12:
        if (this.f21521c == BufferOverflow.SUSPEND) goto L15;
        r10.add("onBufferOverflow=" + this.f21521c);
    L15:
        return e0.a(this) + '[' + b0.h0(r10, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
