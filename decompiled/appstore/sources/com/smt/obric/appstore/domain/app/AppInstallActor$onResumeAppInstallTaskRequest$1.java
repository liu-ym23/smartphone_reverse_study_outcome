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
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onResumeAppInstallTaskRequest$1", f = "AppInstallActor.kt", i = {0, 1, 1, 1, 2, 2, 3, 5, 6, 6}, l = {704, 712, 728, 729, 732, 735, 746, 749, 751}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "task", "wifiOnly", "task", "dlTask", "task", "task", "task", "downloadId"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$0", "L$0", "L$0", "J$0"})
public final class AppInstallActor$onResumeAppInstallTaskRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$BooleanRef $accepted;
    final /* synthetic */ AppInstallActor.b.u $msg;
    final /* synthetic */ String $pkg;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$onResumeAppInstallTaskRequest$1(AppInstallActor r10, String r11, AppInstallActor.b.u r12, Ref$BooleanRef r13, Continuation<? super AppInstallActor$onResumeAppInstallTaskRequest$1> r14) {
        this.this$0 = r10;
        this.$pkg = r11;
        this.$msg = r12;
        this.$accepted = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$onResumeAppInstallTaskRequest$1 r12 = new AppInstallActor$onResumeAppInstallTaskRequest$1(this.this$0, this.$pkg, this.$msg, this.$accepted, r11);
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
        switch(this.label) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        kotlin.c.b(r54);
    L73:
        this.$accepted.element = true;
        return Unit.f21064a;
    L7:
        long r11 = this.J$0;
        com.smt.obric.appstore.domain.app.entity.a r12 = (com.smt.obric.appstore.domain.app.entity.a) this.L$0;
        kotlin.c.b(r54);
    L63:
        Long r13 = r12.s();
        if (r13 != null) goto L66;
    L70:
        ODownloader r14 = ODownloader.f18038a;
        this.L$0 = null;
        this.label = 9;
        if (r14.x(r11, this) != r10) goto L73;
        return r10;
    L66:
        if (((int) r13.longValue()) != (-1)) goto L70;
        ODownloader r15 = ODownloader.f18038a;
        this.L$0 = null;
        this.label = 8;
        if (r15.w(r11, this) != r10) goto L73;
        return r10;
    L8:
        com.smt.obric.appstore.domain.app.entity.a r16 = (com.smt.obric.appstore.domain.app.entity.a) this.L$0;
        kotlin.c.b(r54);
    L55:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: expedite task waiting for WiFi using cellular data. success, pkg=" + this.$pkg + ", task=" + r16.P());
        this.$accepted.element = true;
        return Unit.f21064a;
    L9:
        kotlin.c.b(r54);
    L50:
        return Unit.f21064a;
    L10:
        com.smt.obric.appstore.domain.app.entity.a r17 = (com.smt.obric.appstore.domain.app.entity.a) this.L$0;
        kotlin.c.b(r54);
        com.smt.obric.appstore.domain.app.entity.a r18 = r17;
        Object r19 = r54;
    L44:
        TaskOperateResult r20 = (TaskOperateResult) r19;
        if (com.smt.obric.appstore.domain.downloader.d.b(tf.a.d(r20.getId())) == true) goto L51;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: submit wait wifi task failed, res=" + com.smt.obric.appstore.domain.downloader.c.b(r20) + ", pkg=" + this.$pkg);
        AppInstallTaskDAO r21 = AppInstallActor.t(this.this$0);
        String r22 = this.$pkg;
        AppStatus.a r23 = AppStatus.a.f17968a;
        this.L$0 = null;
        this.label = 5;
        if (r21.updateAppStatus(r22, r23, this) != r10) goto L50;
        return r10;
    L51:
        AppInstallTaskDAO r24 = AppInstallActor.t(this.this$0);
        long r25 = r18.A();
        long r26 = r20.getId();
        this.L$0 = r18;
        this.label = 6;
        if (r24.updateDownloadId(r25, r26, this) != r10) goto L54;
        return r10;
    L54:
        r16 = r18;
        goto L55
    L11:
        DownloadTask r27 = (DownloadTask) this.L$1;
        com.smt.obric.appstore.domain.app.entity.a r28 = (com.smt.obric.appstore.domain.app.entity.a) this.L$0;
        kotlin.c.b(r54);
    L40:
        ODownloader r29 = ODownloader.f18038a;
        this.L$0 = r28;
        this.L$1 = null;
        this.label = 4;
        r19 = r29.A(r27, this);
        if (r19 != r10) goto L43;
        return r10;
    L43:
        r18 = r28;
        goto L44
    L12:
        boolean r30 = this.Z$0;
        r28 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        CoroutineScope r31 = (CoroutineScope) this.L$0;
        kotlin.c.b(r54);
    L25:
        if (r30 == false) goto L31;
        if (ConnectivityManagerNetworkMonitorKt.f(AppInstallActor.l(this.this$0)) == true) goto L31;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: taskId=" + r28.A() + ", download wait wifi, req=" + r28.P());
        this.$accepted.element = true;
        return Unit.f21064a;
    L31:
        if (q.b(r28.G(), AppStatus.f.f17978a) == false) goto L57;
        if (r30 == true) goto L57;
        r27 = n.a(r28);
        if (r27 != null) goto L37;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: expedite task waiting for WiFi using cellular data. FAILED: buildDownloadTask Failed. pkg=" + this.$pkg + ", task=" + r28.P());
        return Unit.f21064a;
    L37:
        AppInstallTaskDAO r32 = AppInstallActor.t(this.this$0);
        String r33 = this.$pkg;
        AppStatus.l r34 = AppStatus.l.f17990a;
        this.L$0 = r28;
        this.L$1 = r27;
        this.label = 3;
        if (r32.updateAppStatus(r33, r34, this) != r10) goto L40;
        return r10;
    L57:
        Long r35 = r28.o();
        if (r35 == null) goto L75;
        long r36 = r35.longValue();
        ODownloader r37 = ODownloader.f18038a;
        this.L$0 = r28;
        this.L$1 = null;
        this.J$0 = r36;
        this.label = 7;
        if (r37.z(r36, r30, this) != r10) goto L62;
        return r10;
    L62:
        r12 = r28;
        r11 = r36;
        goto L63
    L75:
        com.bytedanceos.common.toolbox.j.s("[AppStatus][ResumeAppDownloadUseCase] invoke: no downloadId found, task=" + r28);
        return Unit.f21064a;
    L13:
        CoroutineScope r38 = (CoroutineScope) this.L$0;
        kotlin.c.b(r54);
        Object r39 = r54;
    L17:
        com.smt.obric.appstore.domain.app.entity.a r110 = (com.smt.obric.appstore.domain.app.entity.a) r39;
        if (r110 == null) goto L77;
        r28 = com.smt.obric.appstore.domain.app.entity.a.b(r110, 0, null, 0, null, null, null, null, null, false, false, this.$msg.c(), false, null, null, null, null, null, null, 0.0f, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, false, null, -1025, 3, null);
        if (r28 == null) goto L77;
        boolean r40 = this.$msg.c();
        AppInstallTaskDAO r41 = AppInstallActor.t(this.this$0);
        String r42 = this.$pkg;
        this.L$0 = r38;
        this.L$1 = r28;
        this.Z$0 = r40;
        this.label = 2;
        if (r41.updateDownloadWiFiRequired(r42, r40, this) != r10) goto L24;
        return r10;
    L24:
        r30 = r40;
    L77:
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstallActor] onResumeAppInstallTaskRequest: task not found, pkg=" + this.$pkg);
        return Unit.f21064a;
    L14:
        kotlin.c.b(r54);
        r38 = (CoroutineScope) this.L$0;
        Flow<com.smt.obric.appstore.domain.app.entity.a> r43 = AppInstallActor.t(this.this$0).getByPkg(this.$pkg);
        this.L$0 = r38;
        this.label = 1;
        r39 = kotlinx.coroutines.flow.c.w(r43, this);
        if (r39 != r10) goto L17;
        return r10;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onResumeAppInstallTaskRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
