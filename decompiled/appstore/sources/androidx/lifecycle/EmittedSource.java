package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements DisposableHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData f3422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f3423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3424c;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EmittedSource this$0;

        public AnonymousClass1(EmittedSource r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L7;
            kotlin.c.b(r10);
            EmittedSource.a(this.this$0);
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public EmittedSource(LiveData r10, u r11) {
        kotlin.jvm.internal.q.g(r10, "source");
        kotlin.jvm.internal.q.g(r11, "mediator");
        this.f3422a = r10;
        this.f3423b = r11;
    }

    public static final /* synthetic */ void a(EmittedSource r10) {
        r10.c();
    }

    public final Object b(Continuation r10) {
        Object r11 = kotlinx.coroutines.h.g(kotlinx.coroutines.l0.c().e(), new EmittedSource$disposeNow$2(this, null), r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final void c() {
        if (this.f3424c == true) goto L6;
        this.f3423b.r(this.f3422a);
        this.f3424c = true;
        return;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        kotlinx.coroutines.h.d(kotlinx.coroutines.d0.a(kotlinx.coroutines.l0.c().e()), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
