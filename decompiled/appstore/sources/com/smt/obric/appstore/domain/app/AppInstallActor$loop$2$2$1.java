package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/f;", "Lcom/smt/obric/appstore/domain/app/AppInstallActor$b;", "r", "", "<anonymous>", "(Lkotlinx/coroutines/channels/f;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$loop$2$2$1", f = "AppInstallActor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$loop$2$2$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.f, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ Channel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ SendChannel<AppInstallActor.b.AbstractC0215b> $dlCbActor;
    final /* synthetic */ Channel<String> $taskCancelledCh;
    final /* synthetic */ SendChannel<CompletableDeferred<Boolean>> $triggerWiFiDownload;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$loop$2$2$1(AppInstallActor r10, CoroutineScope r11, Channel<AppInstallActor.b> r12, Channel<String> r13, SendChannel<? super CompletableDeferred<Boolean>> r14, SendChannel<? super AppInstallActor.b.AbstractC0215b> r15, Continuation<? super AppInstallActor$loop$2$2$1> r16) {
        this.this$0 = r10;
        this.$$this$coroutineScope = r11;
        this.$actorMailbox = r12;
        this.$taskCancelledCh = r13;
        this.$triggerWiFiDownload = r14;
        this.$dlCbActor = r15;
        super(2, r16);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$loop$2$2$1 r12 = new AppInstallActor$loop$2$2$1(this.this$0, this.$$this$coroutineScope, this.$actorMailbox, this.$taskCancelledCh, this.$triggerWiFiDownload, this.$dlCbActor, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlinx.coroutines.channels.f r10, Continuation<? super Unit> r11) {
        return m30invokeWpGqRn0(r10.l(), r11);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m30invokeWpGqRn0(@NotNull Object r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$loop$2$2$1) create(kotlinx.coroutines.channels.f.b(r10), r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L11;
        kotlin.c.b(r10);
        Object r11 = ((kotlinx.coroutines.channels.f) this.L$0).l();
        if (kotlinx.coroutines.channels.f.j(r11) == false) goto L7;
        AppInstallActor.b r12 = (AppInstallActor.b) kotlinx.coroutines.channels.f.g(r11);
        AppInstallActor.u(this.this$0, this.$$this$coroutineScope, r12, this.$actorMailbox, this.$taskCancelledCh, this.$triggerWiFiDownload, this.$dlCbActor);
        return Unit.f21064a;
    L7:
        return Unit.f21064a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
