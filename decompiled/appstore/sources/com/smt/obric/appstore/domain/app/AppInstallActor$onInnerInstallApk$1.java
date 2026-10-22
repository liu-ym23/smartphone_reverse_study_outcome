package com.smt.obric.appstore.domain.app;

import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onInnerInstallApk$1", f = "AppInstallActor.kt", i = {}, l = {835, 837}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$onInnerInstallApk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ AppInstallActor.b.q $msg;
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $task;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$onInnerInstallApk$1(AppInstallActor r10, com.smt.obric.appstore.domain.app.entity.a r11, AppInstallActor.b.q r12, SendChannel<? super AppInstallActor.b> r13, Continuation<? super AppInstallActor$onInnerInstallApk$1> r14) {
        this.this$0 = r10;
        this.$task = r11;
        this.$msg = r12;
        this.$actorMailbox = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstallActor$onInnerInstallApk$1(this.this$0, this.$task, this.$msg, this.$actorMailbox, r11);
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
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        kotlin.c.b(r10);
    L20:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
    L13:
        CompletableDeferred r13 = this.$msg.a();
        if (r13 == null) goto L16;
        tf.a.a(r13.complete(Unit.f21064a));
    L16:
        SendChannel<AppInstallActor.b> r14 = this.$actorMailbox;
        AppInstallActor.b.p r15 = new AppInstallActor.b.p(this.$task);
        this.label = 2;
        if (r14.send(r15, this) != r11) goto L20;
        return r11;
    L10:
        kotlin.c.b(r10);
        AppInstallTaskDAO r16 = AppInstallActor.t(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r17 = this.$task;
        this.label = 1;
        if (r16.upsert(r17, this) != r11) goto L13;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onInnerInstallApk$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
