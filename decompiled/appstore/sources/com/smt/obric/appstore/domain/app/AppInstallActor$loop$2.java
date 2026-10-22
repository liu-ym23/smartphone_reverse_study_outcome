package com.smt.obric.appstore.domain.app;

import android.os.PowerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.y;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$loop$2", f = "AppInstallActor.kt", i = {0, 1, 1, 1, 1, 1}, l = {271, 1269}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "dlCbActor", "triggerWiFiDownload", "taskCancelledCh", "installWakeLock"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
@SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$loop$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,1261:1\n55#2,8:1262\n*S KotlinDebug\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$loop$2\n*L\n309#1:1262,8\n*E\n"})
public final class AppInstallActor$loop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<AppInstallActor.b> $actorMailbox;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$loop$2(AppInstallActor r10, Channel<AppInstallActor.b> r11, Continuation<? super AppInstallActor$loop$2> r12) {
        this.this$0 = r10;
        this.$actorMailbox = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$loop$2 r12 = new AppInstallActor$loop$2(this.this$0, this.$actorMailbox, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0191 -> B:45:0x0192). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r20) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        Continuation r12 = null;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        PowerManager.WakeLock r13 = (PowerManager.WakeLock) this.L$4;
        Channel r14 = (Channel) this.L$3;
        SendChannel r15 = (SendChannel) this.L$2;
        SendChannel r16 = (SendChannel) this.L$1;
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        kotlin.c.b(r20);
        SendChannel r18 = r15;
        SendChannel r19 = r16;
        CoroutineScope r110 = r17;
        Object r21 = r10;
        Continuation r22 = null;
    L45:
        r10 = r21;
        r12 = r22;
    L18:
        if (d0.f(r110) == false) goto L47;
        if (AppInstallActor.p(this.this$0) != null) goto L30;
        com.smt.obric.appstore.domain.app.entity.a r23 = (com.smt.obric.appstore.domain.app.entity.a) y.C(AppInstallActor.o(this.this$0));
        if (r23 != null) goto L24;
        r23 = (com.smt.obric.appstore.domain.app.entity.a) y.C(AppInstallActor.n(this.this$0));
    L24:
        com.smt.obric.appstore.domain.app.entity.a r111 = r23;
        if (r111 == null) goto L30;
        AppInstallActor.C(this.this$0, new AppInstallActor.a(r111, kotlinx.coroutines.h.b(r110, null, null, new AppInstallActor$loop$2$deferredResult$1(this.this$0, r111, r12), 3, null)));
        if (r111.M() == false) goto L30;
        AppInstallActor.r(this.this$0).onInstallStart(r111.E());
    L30:
        if (AppInstallActor.p(this.this$0) == null) goto L32;
        AppInstallActor.g(this.this$0, r13);
    L33:
        Channel<AppInstallActor.b> r24 = this.$actorMailbox;
        AppInstallActor r112 = this.this$0;
        SelectImplementation r113 = new SelectImplementation(getContext());
        Object r114 = r10;
        CoroutineScope r25 = r110;
        r113.invoke(r24.getOnReceiveCatching(), new AppInstallActor$loop$2$2$1(r112, r110, r24, r14, r18, r19, null));
        AppInstallActor.a r26 = AppInstallActor.p(r112);
        if (r26 == null) goto L40;
        Deferred r27 = r26.a();
        if (r27 == null) goto L40;
        SelectClause1 r28 = r27.getOnAwait();
        if (r28 == null) goto L40;
        AppInstallActor r29 = r112;
        r22 = null;
        r113.invoke(r28, new AppInstallActor$loop$2$2$2(r29, r25, null));
    L41:
        r113.invoke(r14.getOnReceiveCatching(), new AppInstallActor$loop$2$2$3(r29, r22));
        this.L$0 = r25;
        this.L$1 = r19;
        this.L$2 = r18;
        this.L$3 = r14;
        this.L$4 = r13;
        this.label = 2;
        r21 = r114;
        if (r113.j(this) != r21) goto L44;
        return r21;
    L44:
        r110 = r25;
    L40:
        r29 = r112;
        r22 = null;
        goto L41
    L32:
        AppInstallActor.A(this.this$0, r13);
        goto L33
    L47:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        kotlin.c.b(r20);
    L13:
        SendChannel r31 = AppInstallActor.k(this.this$0, r30);
        AppInstallActor.w(this.this$0, r30, this.$actorMailbox);
        AppInstallActor r32 = this.this$0;
        AppInstallActor.i(r32, r30, AppInstallActor.l(r32), AppInstallActor.q(this.this$0), this.$actorMailbox);
        AppInstallActor r33 = this.this$0;
        AppInstallActor.j(r33, r30, AppInstallActor.s(r33), this.$actorMailbox);
        SendChannel r34 = AppInstallActor.H(this.this$0, r30);
        Channel r35 = kotlinx.coroutines.channels.e.b(Channel.UNLIMITED, null, null, 6, null);
        final PowerManager.WakeLock r36 = com.smt.obric.appstore.ktx.a.e(AppInstallActor.l(this.this$0), "AppInstallActor::wakeLock::installApp");
        Job r37 = (Job) r30.getCoroutineContext().get(Job.Key);
        if (r37 == null) goto L16;
        final AppInstallActor r115 = this.this$0;
        r37.invokeOnCompletion(new AnonymousClass1(r115, r36));
    L16:
        r110 = r30;
        r19 = r31;
        r18 = r34;
        r14 = r35;
        r13 = r36;
        goto L18
    L10:
        kotlin.c.b(r20);
        r30 = (CoroutineScope) this.L$0;
        AppInstallActor r38 = this.this$0;
        Channel<AppInstallActor.b> r39 = this.$actorMailbox;
        this.L$0 = r30;
        this.label = 1;
        if (AppInstallActor.v(r38, r39, this) != r10) goto L13;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$loop$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
