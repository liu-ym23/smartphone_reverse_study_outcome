package com.smt.obric.appstore.domain.app;

import com.obric.download.base.DownloadTask;
import com.obric.download.base.TaskOperateResult;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import com.smt.obric.appstore.ktx.ConnectivityManagerNetworkMonitorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.o;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onEnqueueAppInstallTaskRequest$1", f = "AppInstallActor.kt", i = {0, 1, 1, 3, 3, 4, 5, 6, 7, 9, 9, 11, 11, 12, 13, 13, 14}, l = {587, 600, 602, 630, 635, 637, 638, 656, 657, 660, 665, 669, 677, 681, 685}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "currentTask", "newTask", "downloadTask", "newTask", "newTask", "newTask", "ack", "newTask", "taskId", "newTask", "res", "newTask", "newTask", "ack", "newTask"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0", "L$0", "L$0", "J$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0"})
public final class AppInstallActor$onEnqueueAppInstallTaskRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$BooleanRef $accepted;
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    final /* synthetic */ AppInstallActor.b.o $msg;
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $req;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$onEnqueueAppInstallTaskRequest$1(AppInstallActor r10, com.smt.obric.appstore.domain.app.entity.a r11, SendChannel<? super AppInstallActor.b> r12, AppInstallActor.b.o r13, Ref$BooleanRef r14, Continuation<? super AppInstallActor$onEnqueueAppInstallTaskRequest$1> r15) {
        this.this$0 = r10;
        this.$req = r11;
        this.$actorMailbox = r12;
        this.$msg = r13;
        this.$accepted = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$onEnqueueAppInstallTaskRequest$1 r12 = new AppInstallActor$onEnqueueAppInstallTaskRequest$1(this.this$0, this.$req, this.$actorMailbox, this.$msg, this.$accepted, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v87, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r4v57, types: [T, com.smt.obric.appstore.domain.app.entity.a] */
    /* JADX WARN: Type inference failed for: r6v6, types: [T, com.smt.obric.appstore.domain.app.entity.a] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r55) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        Ref$ObjectRef r11 = this.label;
        switch(r11) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L6;
            default: goto L5;
        };
    L6:
        Ref$ObjectRef r12 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);     // Catch: Throwable -> L9
        r11 = r12;
    L134:
        this.$accepted.element = true;     // Catch: Throwable -> L9
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: complete: " + ((com.smt.obric.appstore.domain.app.entity.a) r11.element).P());
    L137:
        return Unit.f21064a;
    L11:
        CompletableDeferred r13 = (CompletableDeferred) this.L$1;
        Ref$ObjectRef r14 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        CompletableDeferred r15 = r13;
        Ref$ObjectRef r16 = r14;
    L131:
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: wait ack: " + ((com.smt.obric.appstore.domain.app.entity.a) r16.element).P());     // Catch: Throwable -> L9
        this.L$0 = r16;     // Catch: Throwable -> L9
        this.L$1 = null;     // Catch: Throwable -> L9
        this.label = 15;     // Catch: Throwable -> L9
        r11 = r16;
        if (r15.await(this) != r10) goto L134;
        return r10;
    L12:
        Ref$ObjectRef r17 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Object r18 = r55;
        Ref$ObjectRef r19 = r17;
    L128:
        r19.element = com.smt.obric.appstore.domain.app.entity.a.b((com.smt.obric.appstore.domain.app.entity.a) r19.element, ((Number) r18).longValue(), null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -2, 3, null);
        r15 = u.b(null, 1, null);
        SendChannel<AppInstallActor.b> r20 = this.$actorMailbox;
        AppInstallActor.b.q r21 = new AppInstallActor.b.q((com.smt.obric.appstore.domain.app.entity.a) r19.element, r15);
        this.L$0 = r19;
        this.L$1 = r15;
        this.label = 14;
        r16 = r19;
        if (r20.send(r21, this) != r10) goto L131;
        return r10;
    L13:
        TaskOperateResult r22 = (TaskOperateResult) this.L$1;
        Ref$ObjectRef r23 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Ref$ObjectRef r24 = r23;
    L124:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: task=" + ((com.smt.obric.appstore.domain.app.entity.a) r24.element).K() + ", download submit res=" + com.smt.obric.appstore.domain.downloader.c.b(r22));
        this.$accepted.element = true;
        goto L137
    L14:
        kotlin.c.b(r55);
    L119:
        return Unit.f21064a;
    L15:
        long r25 = this.J$0;
        Ref$ObjectRef r26 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Ref$ObjectRef r110 = r26;
        long r27 = r25;
        Object r28 = r55;
    L113:
        TaskOperateResult r111 = (TaskOperateResult) r28;
        if (com.smt.obric.appstore.domain.downloader.d.b(tf.a.d(r111.getId())) == true) goto L120;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: download submitTask err: invalid downloadId, res=" + com.smt.obric.appstore.domain.downloader.c.b(r111));
        AppInstallTaskDAO r29 = AppInstallActor.t(this.this$0);
        String r30 = ((com.smt.obric.appstore.domain.app.entity.a) r110.element).E();
        AppStatus.a r31 = AppStatus.a.f17968a;
        this.L$0 = null;
        this.label = 11;
        if (r29.updateAppStatus(r30, r31, this) != r10) goto L119;
        return r10;
    L120:
        AppInstallTaskDAO r32 = AppInstallActor.t(this.this$0);
        long r112 = r111.getId();
        this.L$0 = r110;
        this.L$1 = r111;
        this.label = 12;
        if (r32.updateDownloadId(r27, r112, this) != r10) goto L123;
        return r10;
    L123:
        r24 = r110;
        r22 = r111;
        goto L124
    L16:
        Ref$BooleanRef r33 = (Ref$BooleanRef) this.L$0;
        kotlin.c.b(r55);
        Ref$BooleanRef r34 = r33;
        Object r35 = r55;
    L108:
        r34.element = ((Boolean) r35).booleanValue();
        goto L137
    L17:
        CompletableDeferred r36 = (CompletableDeferred) this.L$0;
        kotlin.c.b(r55);
    L105:
        r34 = this.$accepted;
        this.L$0 = r34;
        this.label = 9;
        r35 = r36.await(this);
        if (r35 != r10) goto L108;
        return r10;
    L18:
        Ref$ObjectRef r37 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Object r38 = r55;
        Ref$ObjectRef r39 = r37;
    L97:
        int r40 = ((Number) r38).intValue();
        com.smt.obric.appstore.domain.app.jobs.a.f18032a.e(AppInstallActor.l(this.this$0));
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: download wait wifi, enqueued=" + r40 + ", req=" + ((com.smt.obric.appstore.domain.app.entity.a) r39.element).P());
        this.$accepted.element = true;
        return Unit.f21064a;
    L19:
        Ref$ObjectRef r41 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Ref$ObjectRef r42 = r41;
    L94:
        AppInstallTaskDAO r43 = AppInstallActor.t(this.this$0);
        String r44 = ((com.smt.obric.appstore.domain.app.entity.a) r42.element).E();
        AppStatus.f r45 = AppStatus.f.f17978a;
        this.L$0 = r42;
        this.label = 7;
        r38 = r43.updateAppStatus(r44, r45, this);
        r39 = r42;
        if (r38 != r10) goto L97;
        return r10;
    L20:
        Ref$ObjectRef r46 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Object r47 = r55;
        Ref$ObjectRef r48 = r46;
    L90:
        TaskOperateResult r49 = (TaskOperateResult) r47;
        Ref$ObjectRef r50 = r48;
    L91:
        AppInstallTaskDAO r51 = AppInstallActor.t(this.this$0);
        String r52 = ((com.smt.obric.appstore.domain.app.entity.a) r50.element).E();
        this.L$0 = r50;
        this.L$1 = null;
        this.label = 6;
        r42 = r50;
        if (r51.updateDownloadWiFiRequired(r52, true, this) != r10) goto L94;
        return r10;
    L21:
        DownloadTask r53 = (DownloadTask) this.L$1;
        Ref$ObjectRef r54 = (Ref$ObjectRef) this.L$0;
        kotlin.c.b(r55);
        Object r56 = r55;
        DownloadTask r57 = r53;
        Ref$ObjectRef r58 = r54;
    L81:
        r27 = ((Number) r56).longValue();
        r58.element = com.smt.obric.appstore.domain.app.entity.a.b((com.smt.obric.appstore.domain.app.entity.a) r58.element, r27, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -2, 3, null);
        if (this.$req.w() == false) goto L100;
        if (ConnectivityManagerNetworkMonitorKt.f(AppInstallActor.l(this.this$0)) == true) goto L100;
        Long r59 = this.$req.o();
        r50 = r58;
        if (r59 == null) goto L91;
        long r60 = r59.longValue();
        ODownloader r61 = ODownloader.f18038a;
        this.L$0 = r58;
        this.L$1 = null;
        this.label = 5;
        r47 = r61.z(r60, true, this);
        r48 = r58;
        if (r47 != r10) goto L90;
        return r10;
    L100:
        if (je.a.f20999a.b(((com.smt.obric.appstore.domain.app.entity.a) r58.element).o(), ((com.smt.obric.appstore.domain.app.entity.a) r58.element).s(), ((com.smt.obric.appstore.domain.app.entity.a) r58.element).l()) == false) goto L109;
        CompletableDeferred r62 = u.b(null, 1, null);
        SendChannel<AppInstallActor.b> r63 = this.$actorMailbox;
        AppInstallActor.b.u r64 = new AppInstallActor.b.u(((com.smt.obric.appstore.domain.app.entity.a) r58.element).E(), ((com.smt.obric.appstore.domain.app.entity.a) r58.element).w(), r62);
        this.L$0 = r62;
        this.L$1 = null;
        this.label = 8;
        if (r63.send(r64, this) != r10) goto L104;
        return r10;
    L104:
        r36 = r62;
        goto L105
    L109:
        ODownloader r65 = ODownloader.f18038a;
        this.L$0 = r58;
        this.L$1 = null;
        this.J$0 = r27;
        this.label = 10;
        r28 = r65.A(r57, this);
        if (r28 != r10) goto L112;
        return r10;
    L112:
        r110 = r58;
        goto L113
    L22:
        kotlin.c.b(r55);
    L53:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][AutoUpdate] onEnqueueAppInstallTaskRequest: skip. sysapp wifi auto update disabled, cancel existing task, req=" + this.$req.P());
        return Unit.f21064a;
    L23:
        com.smt.obric.appstore.domain.app.entity.a r66 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        CoroutineScope r67 = (CoroutineScope) this.L$0;
        kotlin.c.b(r55);
        com.smt.obric.appstore.domain.app.entity.a r68 = r66;
        Object r69 = r55;
    L45:
        Boolean r70 = (Boolean) r69;
        if (r70 == null) goto L48;
        boolean r71 = r70.booleanValue();
    L49:
        if (r71 == true) goto L55;
        SendChannel<AppInstallActor.b> r72 = this.$actorMailbox;
        AppInstallActor.b.a r73 = new AppInstallActor.b.a(this.$req.E(), null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r72.send(r73, this) != r10) goto L53;
        return r10;
    L55:
        com.smt.obric.appstore.domain.app.entity.a r113 = r68;
        if (this.$req.L() == false) goto L61;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][AutoUpdate] onEnqueueAppInstallTaskRequest: on auto update req, req=" + this.$req.P());
        if (AppInstallActor.h(this.this$0, this.$msg) == true) goto L61;
        return Unit.f21064a;
    L61:
        Ref$ObjectRef r74 = new Ref$ObjectRef();
        if (r113 == null) goto L65;
        com.smt.obric.appstore.domain.app.entity.a r75 = com.smt.obric.appstore.domain.app.entity.a.b(r113, 0, null, 0, null, null, AppStatus.l.f17990a, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -33, 3, null);
        T r76 = r75;
        if (r75 == null) goto L65;
    L66:
        r74.element = r76;
        String r77 = this.$req.e();
        if (r77 != null) goto L69;
    L72:
        boolean r78 = true;
    L73:
        if (r78 == false) goto L125;
        r57 = n.a((com.smt.obric.appstore.domain.app.entity.a) r74.element);
        if (r57 != null) goto L78;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: download submitTask err: convert failed, task=" + ((com.smt.obric.appstore.domain.app.entity.a) r74.element).P());
        return Unit.f21064a;
    L78:
        AppInstallTaskDAO r79 = AppInstallActor.t(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r80 = (com.smt.obric.appstore.domain.app.entity.a) r74.element;
        this.L$0 = r74;
        this.L$1 = r57;
        this.label = 4;
        r56 = r79.upsert(r80, this);
        r58 = r74;
        if (r56 != r10) goto L81;
        return r10;
    L125:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: task=" + ((com.smt.obric.appstore.domain.app.entity.a) r74.element).K() + ", apk ready no need download, enqueue install directly.");
        AppInstallTaskDAO r81 = AppInstallActor.t(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r82 = (com.smt.obric.appstore.domain.app.entity.a) r74.element;
        this.L$0 = r74;
        this.L$1 = null;
        this.label = 13;
        r18 = r81.upsert(r82, this);
        r19 = r74;
        if (r18 != r10) goto L128;
        return r10;
    L69:
        if (o.r(r77) == true) goto L72;
        r78 = false;
    L65:
        r76 = com.smt.obric.appstore.domain.app.entity.a.b(this.$req, 0, null, 0, null, null, AppStatus.l.f17990a, null, null, false, false, false, false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -33, 3, null);
        goto L66
    L48:
        r71 = true;
        goto L49
    L24:
        CoroutineScope r83 = (CoroutineScope) this.L$0;
        kotlin.c.b(r55);
        Object r84 = r55;
    L28:
        r68 = (com.smt.obric.appstore.domain.app.entity.a) r84;
        if (r68 == null) goto L31;
        AppStatus r85 = r68.G();
    L32:
        if (r85 == null) goto L34;
        boolean r86 = a.b(r85);
    L35:
        if (r86 == true) goto L39;
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: task not allow to enqueue, pkg=" + this.$req.E() + " name=" + this.$req.f() + ", status=" + r85);
        return Unit.f21064a;
    L39:
        if (h.a() == false) goto L55;
        if (this.$req.N() == false) goto L55;
        Flow r87 = kotlinx.coroutines.flow.c.t(AppInstallActor.s(this.this$0));
        this.L$0 = r83;
        this.L$1 = r68;
        this.label = 2;
        r69 = kotlinx.coroutines.flow.c.w(r87, this);
        if (r69 != r10) goto L45;
        return r10;
    L34:
        r86 = true;
        goto L35
    L31:
        r85 = null;
        goto L32
    L25:
        kotlin.c.b(r55);
        r83 = (CoroutineScope) this.L$0;
        Flow<com.smt.obric.appstore.domain.app.entity.a> r88 = AppInstallActor.t(this.this$0).getByPkg(this.$req.E());
        this.L$0 = r83;
        this.label = 1;
        r84 = kotlinx.coroutines.flow.c.w(r88, this);
        if (r84 != r10) goto L28;
        return r10;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        th = move-exception;
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstallActor] onEnqueueAppInstallTaskRequest: complete: " + ((com.smt.obric.appstore.domain.app.entity.a) r11.element).P());
        throw th;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onEnqueueAppInstallTaskRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
