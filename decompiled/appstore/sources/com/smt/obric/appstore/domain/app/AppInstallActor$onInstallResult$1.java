package com.smt.obric.appstore.domain.app;

import com.obric.download.base.TaskOperateResult;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.downloader.ODownloader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$onInstallResult$1", f = "AppInstallActor.kt", i = {1, 1, 2, 2}, l = {929, 934, 936, 939}, m = "invokeSuspend", n = {"downloadId", "succ", "downloadId", "succ"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
public final class AppInstallActor$onInstallResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $newTask;
    final /* synthetic */ i $r;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$onInstallResult$1(i r10, AppInstallActor r11, com.smt.obric.appstore.domain.app.entity.a r12, Continuation<? super AppInstallActor$onInstallResult$1> r13) {
        this.$r = r10;
        this.this$0 = r11;
        this.$newTask = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstallActor$onInstallResult$1(this.$r, this.this$0, this.$newTask, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L14;
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L12;
        if (r12 == 3) goto L11;
        if (r12 != 4) goto L10;
        kotlin.c.b(r11);
    L31:
        TaskOperateResult r13 = (TaskOperateResult) r11;
    L33:
        return Unit.f21064a;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        boolean r14 = this.Z$0;
        com.smt.obric.appstore.domain.app.entity.a r15 = (com.smt.obric.appstore.domain.app.entity.a) this.L$1;
        Long r16 = (Long) this.L$0;
        kotlin.c.b(r11);
    L28:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInstallResult: install result succ=" + r14 + ", remove download task from Downloader, id = " + r16 + ", task=" + r15.P());
        ODownloader r17 = ODownloader.f18038a;
        long r18 = r16.longValue();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 4;
        r11 = r17.v(r18, this);
        if (r11 != r10) goto L31;
        return r10;
    L12:
        r14 = this.Z$0;
        r16 = (Long) this.L$0;
        kotlin.c.b(r11);
    L23:
        if (r16 == null) goto L33;
        AppInstallActor r19 = this.this$0;
        com.smt.obric.appstore.domain.app.entity.a r20 = this.$newTask;
        AppInstallTaskDAO r110 = AppInstallActor.t(r19);
        List<Long> r21 = s.e(r16);
        this.L$0 = r16;
        this.L$1 = r20;
        this.Z$0 = r14;
        this.label = 3;
        if (r110.deleteByDownloadId(r21, this) != r10) goto L27;
        return r10;
    L27:
        r15 = r20;
        goto L28
    L13:
        kotlin.c.b(r11);
        goto L33
    L14:
        kotlin.c.b(r11);
        if (this.$r.c() == false) goto L19;
        AppInstallTaskDAO r111 = AppInstallActor.t(this.this$0);
        com.smt.obric.appstore.domain.app.entity.a r22 = this.$newTask;
        this.label = 1;
        if (r111.upsert(r22, this) != r10) goto L33;
        return r10;
    L19:
        Long r112 = this.$newTask.o();
        r14 = this.$r.d();
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstallActor][InstallStage] onInstallResult: install result succ=" + r14 + ", remove install task, id=" + this.$newTask.A() + ", dlId=" + r112 + ", task=" + this.$newTask.P());
        AppInstallTaskDAO r23 = AppInstallActor.t(this.this$0);
        String r24 = this.$r.e().E();
        this.L$0 = r112;
        this.Z$0 = r14;
        this.label = 2;
        if (r23.deleteByPkg(r24, this) != r10) goto L22;
        return r10;
    L22:
        r16 = r112;
        goto L23
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$onInstallResult$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
