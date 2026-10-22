package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ActorScope;", "Lcom/smt/obric/appstore/domain/app/AppInstallActor$b;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/ActorScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$Companion$launchIn$sendCh$1", f = "AppInstallActor.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$Companion$launchIn$sendCh$1 extends SuspendLambda implements Function2<ActorScope<AppInstallActor.b>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppInstallActor $act;
    private /* synthetic */ Object L$0;
    int label;

    public AppInstallActor$Companion$launchIn$sendCh$1(AppInstallActor r10, Continuation<? super AppInstallActor$Companion$launchIn$sendCh$1> r11) {
        this.$act = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$Companion$launchIn$sendCh$1 r12 = new AppInstallActor$Companion$launchIn$sendCh$1(this.$act, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ActorScope<AppInstallActor.b> r10, Continuation<? super Unit> r11) {
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
        ActorScope r13 = (ActorScope) this.L$0;
        AppInstallActor r14 = this.$act;
        Channel r15 = r13.getChannel();
        this.label = 1;
        if (AppInstallActor.x(r14, r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ActorScope<AppInstallActor.b> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$Companion$launchIn$sendCh$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
