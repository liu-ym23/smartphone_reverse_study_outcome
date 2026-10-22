package com.smt.obric.appstore.domain.app;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$cancelTaskOnPackageChange$1", f = "AppInstallActor.kt", i = {0, 1, 1, 1, 2, 3}, l = {371, 379, 383, 391}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "event", "addedPackageVersionCode", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$0"})
public final class AppInstallActor$cancelTaskOnPackageChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ Context $context;
    final /* synthetic */ ReceiveChannel<le.b.a> $packageChanges;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$cancelTaskOnPackageChange$1(ReceiveChannel<le.b.a> r10, AppInstallActor r11, SendChannel<? super AppInstallActor.b> r12, Context r13, Continuation<? super AppInstallActor$cancelTaskOnPackageChange$1> r14) {
        this.$packageChanges = r10;
        this.this$0 = r11;
        this.$actorMailbox = r12;
        this.$context = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$cancelTaskOnPackageChange$1 r12 = new AppInstallActor$cancelTaskOnPackageChange$1(this.$packageChanges, this.this$0, this.$actorMailbox, this.$context, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x016a -> B:51:0x0167). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r21) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        int r12 = 0;
        if (r11 == 0) goto L14;
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L11;
        if (r11 == 4) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ChannelIterator<le.b.a> r13 = (ChannelIterator) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        kotlin.c.b(r21);
        ChannelIterator<le.b.a> r15 = r13;
        CoroutineScope r16 = r14;
    L51:
        r12 = 0;
    L15:
        this.L$0 = r16;
        this.L$1 = r15;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 1;
        Object r17 = r15.hasNext(this);
        if (r17 != r10) goto L18;
        return r10;
    L18:
        ChannelIterator<le.b.a> r18 = r15;
        CoroutineScope r19 = r16;
    L20:
        if (((Boolean) r17).booleanValue() == false) goto L59;
        le.b.a r110 = r18.next();
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor] packageChanges, event=" + r110);
        if (r110.b() == false) goto L53;
        Context r20 = this.$context;
        Result.a r111 = Result.Companion;     // Catch: Throwable -> L26
        Object r22 = Result.m35constructorimpl(tf.a.d(r20.getPackageManager().getPackageInfo(r110.a(), r12).getLongVersionCode()));     // Catch: Throwable -> L26
    L29:
        if (Result.m41isFailureimpl(r22) == false) goto L31;
        r22 = null;
    L31:
        Long r23 = (Long) r22;
        if (r23 == null) goto L52;
        Flow<com.smt.obric.appstore.domain.app.entity.a> r112 = AppInstallActor.t(this.this$0).getByPkg(r110.a());
        this.L$0 = r19;
        this.L$1 = r18;
        this.L$2 = r110;
        this.L$3 = r23;
        this.label = 2;
        Object r113 = kotlinx.coroutines.flow.c.w(r112, this);
        if (r113 != r10) goto L36;
        return r10;
    L36:
        com.smt.obric.appstore.domain.app.entity.a r114 = (com.smt.obric.appstore.domain.app.entity.a) r113;
        if (r114 != null) goto L39;
    L41:
        boolean r115 = r12;
    L42:
        StringBuilder r116 = new StringBuilder();
        r116.append("[AppStatus][AppInstallActor] packageChanges added, pkg=");
        r116.append(r110.a());
        r116.append(", toCancel=");
        r116.append(r115);
        r116.append(", ver=");
        r116.append(r23);
        r116.append('/');
        if (r114 == null) goto L45;
        Object r24 = tf.a.d(r114.J());
    L46:
        r116.append(r24);
        com.bytedanceos.common.toolbox.j.o(r116.toString());
        if (r115 == 0) goto L52;
        SendChannel<AppInstallActor.b> r25 = this.$actorMailbox;
        AppInstallActor.b.a r26 = new AppInstallActor.b.a(r110.a(), null);
        this.L$0 = r19;
        this.L$1 = r18;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        if (r25.send(r26, this) != r10) goto L52;
        return r10;
    L45:
        r24 = null;
        goto L46
    L39:
        if (r23.longValue() < r114.J()) goto L41;
        r115 = 1;
    L52:
        r16 = r19;
        r15 = r18;
    L26:
        th = move-exception;
        Result.a r117 = Result.Companion;
        r22 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L29
    L53:
        boolean r27 = r110.c();
        StringBuilder r118 = new StringBuilder();
        r118.append("[AppStatus][AppInstallActor] packageChanges removed, pkg=");
        r118.append(r110.a());
        r118.append(", toCancel=");
        r118.append(!r27);
        com.bytedanceos.common.toolbox.j.o(r118.toString());
        if (r27 == true) goto L52;
        SendChannel<AppInstallActor.b> r28 = this.$actorMailbox;
        AppInstallActor.b.a r29 = new AppInstallActor.b.a(r110.a(), null);
        this.L$0 = r19;
        this.L$1 = r18;
        this.label = 4;
        if (r28.send(r29, this) != r10) goto L52;
        return r10;
    L59:
        return Unit.f21064a;
    L12:
        r23 = (Long) this.L$3;
        le.b.a r119 = (le.b.a) this.L$2;
        ChannelIterator<le.b.a> r120 = (ChannelIterator) this.L$1;
        CoroutineScope r121 = (CoroutineScope) this.L$0;
        kotlin.c.b(r21);
        r113 = r21;
        r110 = r119;
        r19 = r121;
        r18 = r120;
        goto L36
    L13:
        ChannelIterator<le.b.a> r30 = (ChannelIterator) this.L$1;
        r19 = (CoroutineScope) this.L$0;
        kotlin.c.b(r21);
        r17 = r21;
        r18 = r30;
        goto L20
    L14:
        kotlin.c.b(r21);
        r16 = (CoroutineScope) this.L$0;
        r15 = this.$packageChanges.iterator();
        goto L15
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$cancelTaskOnPackageChange$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
