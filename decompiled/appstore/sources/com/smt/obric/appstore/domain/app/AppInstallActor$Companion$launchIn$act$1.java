package com.smt.obric.appstore.domain.app;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lle/b$a;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$Companion$launchIn$act$1", f = "AppInstallActor.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$Companion$launchIn$act$1 extends SuspendLambda implements Function2<ProducerScope<? super le.b.a>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f17907a;

        public a(ProducerScope r10) {
            this.f17907a = r10;
        }

        public final Object a(le.b.a r10, Continuation r11) {
            Object r12 = this.f17907a.send(r10, r11);
            if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
            return r12;
        L6:
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a((le.b.a) r10, r11);
        }
    }

    public AppInstallActor$Companion$launchIn$act$1(Continuation<? super AppInstallActor$Companion$launchIn$act$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$Companion$launchIn$act$1 r12 = new AppInstallActor$Companion$launchIn$act$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super le.b.a> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L6;
        kotlin.c.b(r10);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ProducerScope r13 = (ProducerScope) this.L$0;
        SharedFlow r14 = le.b.f21950a.a();
        a r15 = new a(r13);
        this.label = 1;
        if (r14.collect(r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super le.b.a> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$Companion$launchIn$act$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
