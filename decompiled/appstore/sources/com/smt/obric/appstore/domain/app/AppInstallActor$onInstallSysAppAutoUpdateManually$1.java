package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onInstallSysAppAutoUpdateManually$1", f = "AppInstallActor.kt", i = {0, 1, 1, 1, 2, 2}, l = {873, 878, 882}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "task", "ack", "$this$launch", "task"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class AppInstallActor$onInstallSysAppAutoUpdateManually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ AppInstallActor.b.t $msg;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$onInstallSysAppAutoUpdateManually$1(AppInstallActor r10, AppInstallActor.b.t r11, SendChannel<? super AppInstallActor.b> r12, Continuation<? super AppInstallActor$onInstallSysAppAutoUpdateManually$1> r13) {
        this.this$0 = r10;
        this.$msg = r11;
        this.$actorMailbox = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$onInstallSysAppAutoUpdateManually$1 r12 = new AppInstallActor$onInstallSysAppAutoUpdateManually$1(this.this$0, this.$msg, this.$actorMailbox, r11);
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
    public final Object invokeSuspend(@NotNull Object r54) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        Unit r12 = null;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L13;
        com.smt.obric.appstore.domain.app.entity.a r13 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        kotlin.c.b(r54);     // Catch: Throwable -> L10
    L33:
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor][InstallStage] onInstallSysAppAutoUpdateManually: complete, task=" + r13.P());
        r12 = Unit.f21064a;
    L38:
        if (r12 != null) goto L41;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor][InstallStage] onInstallSysAppAutoUpdateManually: task not found, pkg=" + this.$msg.c());
    L41:
        return Unit.f21064a;
    L10:
        th = th;
    L36:
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor][InstallStage] onInstallSysAppAutoUpdateManually: complete, task=" + r13.P());
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        CompletableDeferred r15 = (CompletableDeferred) this.L$2;
        com.smt.obric.appstore.domain.app.entity.a r16 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        kotlin.c.b(r54);
    L44:
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor][InstallStage] onInstallSysAppAutoUpdateManually: wait ack, task=" + r16.P());     // Catch: Throwable -> L34
        this.L$0 = r17;     // Catch: Throwable -> L34
        this.L$1 = r16;     // Catch: Throwable -> L34
        this.L$2 = null;     // Catch: Throwable -> L34
        this.label = 3;     // Catch: Throwable -> L34
        if (r15.await(this) != r10) goto L32;
        return r10;
    L32:
        r13 = r16;
    L34:
        th = th;
        r13 = r16;
        goto L36
    L15:
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        kotlin.c.b(r54);
        Object r19 = r54;
    L19:
        com.smt.obric.appstore.domain.app.entity.a r20 = (com.smt.obric.appstore.domain.app.entity.a) r19;
        if (r20 == null) goto L38;
        AppInstallActor.b.t r21 = this.$msg;
        SendChannel<AppInstallActor.b> r110 = this.$actorMailbox;
        CompletableDeferred r22 = u.b(null, 1, null);
        if (r21.b() == null) goto L24;
        com.smt.obric.appstore.domain.app.entity.a r23 = com.smt.obric.appstore.domain.app.entity.a.b(r20, 0, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, r21.b(), null, null, null, 0, false, null, -134217729, 3, null);
    L25:
        AppInstallActor.b.q r111 = new AppInstallActor.b.q(r23, r22);
        this.L$0 = r18;
        this.L$1 = r20;
        this.L$2 = r22;
        this.label = 2;
        if (r110.send(r111, this) != r10) goto L28;
        return r10;
    L28:
        r16 = r20;
        r17 = r18;
        r15 = r22;
        goto L44
    L24:
        r23 = r20;
        goto L25
    L16:
        kotlin.c.b(r54);
        r18 = (CoroutineScope) this.L$0;
        Flow<com.smt.obric.appstore.domain.app.entity.a> r24 = AppInstallActor.t(this.this$0).getByPkg(this.$msg.c());
        this.L$0 = r18;
        this.label = 1;
        r19 = kotlinx.coroutines.flow.c.w(r24, this);
        if (r19 != r10) goto L19;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onInstallSysAppAutoUpdateManually$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
