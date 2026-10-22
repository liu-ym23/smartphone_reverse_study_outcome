package com.smt.obric.appstore.domain.app;

import com.obric.download.base.TaskOperateResult;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onCancelInstallTaskRequest$1", f = "AppInstallActor.kt", i = {0, 2}, l = {787, 790, 794, 797, 798}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nAppInstallActor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallActor.kt\ncom/smt/obric/appstore/domain/app/AppInstallActor$onCancelInstallTaskRequest$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1261:1\n1#2:1262\n*E\n"})
public final class AppInstallActor$onCancelInstallTaskRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<String> $cancelledCh;
    final /* synthetic */ String $pkg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$onCancelInstallTaskRequest$1(AppInstallActor r10, String r11, SendChannel<? super String> r12, Continuation<? super AppInstallActor$onCancelInstallTaskRequest$1> r13) {
        this.this$0 = r10;
        this.$pkg = r11;
        this.$cancelledCh = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$onCancelInstallTaskRequest$1 r12 = new AppInstallActor$onCancelInstallTaskRequest$1(this.this$0, this.$pkg, this.$cancelledCh, r11);
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
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L13;
        if (r12 == 4) goto L12;
        if (r12 != 5) goto L11;
        kotlin.c.b(r10);
    L44:
        return Unit.f21064a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
    L39:
        SendChannel<String> r13 = this.$cancelledCh;
        String r14 = this.$pkg;
        this.label = 5;
        if (r13.send(r14, this) != r11) goto L44;
        return r11;
    L13:
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        kotlin.c.b(r10);
    L34:
        if (((TaskOperateResult) r10) != null) goto L36;
    L35:
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstallActor][InstallStage] onCancelInstallTaskReq: task downloadId is null, remove local task anyway . pkg=" + this.$pkg + '.');
        Unit r16 = Unit.f21064a;
    L36:
        AppInstallTaskDAO r17 = AppInstallActor.t(this.this$0);
        String r18 = this.$pkg;
        this.L$0 = null;
        this.label = 4;
        if (r17.deleteByPkg(r18, this) != r11) goto L39;
        return r11;
    L14:
        kotlin.c.b(r10);
    L25:
        return Unit.f21064a;
    L15:
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        kotlin.c.b(r10);
    L19:
        com.smt.obric.appstore.domain.app.entity.a r110 = (com.smt.obric.appstore.domain.app.entity.a) r10;
        if (r110 != null) goto L27;
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstallActor][InstallStage] onCancelInstallTaskReq: task not found, pkg=" + this.$pkg);
        SendChannel<String> r111 = this.$cancelledCh;
        String r20 = this.$pkg;
        this.L$0 = null;
        this.label = 2;
        if (r111.send(r20, this) != r11) goto L25;
        return r11;
    L27:
        if (a.a(r110.G()) == false) goto L42;
        Long r112 = r110.o();
        if (r112 == null) goto L35;
        long r21 = r112.longValue();
        ODownloader r113 = ODownloader.f18038a;
        this.L$0 = r19;
        this.label = 3;
        r10 = r113.v(r21, this);
        if (r10 != r11) goto L34;
        return r11;
    L42:
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstallActor][InstallStage] onCancelInstallTaskReq: task not allow cancel, pkg=" + this.$pkg);
        goto L44
    L16:
        kotlin.c.b(r10);
        r19 = (CoroutineScope) this.L$0;
        Flow<com.smt.obric.appstore.domain.app.entity.a> r114 = AppInstallActor.t(this.this$0).getByPkg(this.$pkg);
        this.L$0 = r19;
        this.label = 1;
        r10 = kotlinx.coroutines.flow.c.w(r114, this);
        if (r10 != r11) goto L19;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onCancelInstallTaskRequest$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
