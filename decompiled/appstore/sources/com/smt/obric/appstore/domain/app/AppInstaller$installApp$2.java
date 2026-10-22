package com.smt.obric.appstore.domain.app;

import android.content.Context;
import com.smt.obric.appstore.domain.sysapp.ObricPreloadApks;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/smt/obric/appstore/domain/app/i;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/smt/obric/appstore/domain/app/i;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstaller$installApp$2", f = "AppInstaller.kt", i = {0, 1}, l = {171, 181}, m = "invokeSuspend", n = {"tempFilePath", "tempFilePath"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nAppInstaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstaller.kt\ncom/smt/obric/appstore/domain/app/AppInstaller$installApp$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,575:1\n1#2:576\n*E\n"})
public final class AppInstaller$installApp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {
    final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a $task;
    Object L$0;
    int label;
    final /* synthetic */ AppInstaller this$0;

    public AppInstaller$installApp$2(com.smt.obric.appstore.domain.app.entity.a r10, AppInstaller r11, Continuation<? super AppInstaller$installApp$2> r12) {
        this.$task = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new AppInstaller$installApp$2(this.$task, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super i> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r17) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        ?? r11 = this.label;
        int r12 = -99;
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L14;
        String r13 = (String) this.L$0;
        kotlin.c.b(r17);     // Catch: Throwable -> L9 Exception -> L11
        Object r14 = r17;
    L82:
        i r15 = new i(this.$task, ((Number) r14).intValue(), null, 4, null);     // Catch: Throwable -> L9 Exception -> L11
        new File(r13).delete();     // Catch: Exception -> L93
    L84:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (String) this.L$0;
        kotlin.c.b(r17);     // Catch: Throwable -> L9 Exception -> L11
        Object r16 = r17;
    L74:
        int r18 = ((Number) r16).intValue();     // Catch: Throwable -> L9 Exception -> L11
        if (r18 != 1) goto L77;
        com.bytedanceos.common.toolbox.j.o("[AppStatus][AppInstaller][InstallStage]: signNotMatch, uninstall success, taskId=" + this.$task.A());     // Catch: Throwable -> L9 Exception -> L11
    L79:
        Context r19 = AppInstaller.b(this.this$0);     // Catch: Throwable -> L9 Exception -> L11
        String r20 = this.$task.E();     // Catch: Throwable -> L9 Exception -> L11
        int r21 = this.$task.B();     // Catch: Throwable -> L9 Exception -> L11
        this.L$0 = r13;     // Catch: Throwable -> L9 Exception -> L11
        this.label = 2;     // Catch: Throwable -> L9 Exception -> L11
        r14 = AppInstallerKt.f(r19, r20, r13, r21, this);     // Catch: Throwable -> L9 Exception -> L11
        if (r14 != r10) goto L82;
        return r10;
    L77:
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstaller][InstallStage]: signNotMatch, uninstall failed, taskId=" + this.$task.A() + ", code: " + r18);     // Catch: Throwable -> L9 Exception -> L11
        goto L79
    L18:
        kotlin.c.b(r17);
        String r22 = this.$task.E();
        ObricPreloadApks.a r23 = ObricPreloadApks.f18094a.a(AppInstaller.b(this.this$0), this.$task);
        String r24 = null;
        if (r23.c() == false) goto L29;
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] ObricPreloadApks.handlePreloadApkInstall, pkg=" + this.$task.E() + ", code=" + r23.d() + ", err=" + r23.b() + ", task=" + this.$task.P());
        if (r23.d() == null) goto L24;
        r12 = r23.d().intValue();
    L28:
        return new i(this.$task, r12, r24);
    L24:
        if (r23.b() == null) goto L26;
        r24 = "AppInstaller err: " + r23.b().getMessage();
        goto L28
    L26:
        r12 = 1;
        goto L28
    L29:
        String r25 = this.$task.e();
        boolean r26 = false;
        if (r25 != null) goto L32;
    L35:
        boolean r110 = true;
    L36:
        if (r110 == false) goto L39;
        r25 = null;
    L39:
        if (r25 != null) goto L53;
        String r27 = this.$task.n();
        if (r27 != null) goto L43;
    L46:
        boolean r111 = true;
    L47:
        if (r111 == true) goto L49;
        r24 = r27;
    L49:
        if (r24 == null) goto L51;
        r25 = r24;
        goto L53
    L51:
        return i.f18022d.b(this.$task);
    L43:
        if (o.r(r27) == true) goto L46;
        r111 = false;
    L53:
        String r28 = this.$task.x();
        r13 = AppInstaller.a.a(AppInstaller.f17948b, AppInstaller.b(this.this$0), r22);
        String r29 = com.bytedanceos.common.toolbox.k.e(kotlin.io.g.b(new File(r25), new File(r13), true, 0, 4, null));     // Catch: Throwable -> L9 Exception -> L11
        if (r28 != null) goto L57;
    L58:
        r26 = true;
    L59:
        if (r26 == false) goto L61;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][AppInstaller][InstallStage] installApp: skip md5 check, taskId=" + this.$task.A());     // Catch: Throwable -> L9 Exception -> L11
    L61:
        if (r26 == true) goto L68;
        if (o.p(r29, r28, true) == true) goto L68;
        i.a r30 = i.f18022d;     // Catch: Throwable -> L9 Exception -> L11
        com.smt.obric.appstore.domain.app.entity.a r31 = this.$task;     // Catch: Throwable -> L9 Exception -> L11
        q.d(r29);     // Catch: Throwable -> L9 Exception -> L11
        i r32 = r30.a(r31, r29);     // Catch: Throwable -> L9 Exception -> L11
        new File(r13).delete();     // Catch: Exception -> L96
    L66:
        return r32;
    L68:
        if (PackageInfoKTxKt.d(AppInstaller.b(this.this$0), this.$task.E(), this.$task.F()) == false) goto L79;
        if (this.$task.y() == false) goto L78;
        AppInstaller r33 = this.this$0;     // Catch: Throwable -> L9 Exception -> L11
        Context r34 = AppInstaller.b(r33);     // Catch: Throwable -> L9 Exception -> L11
        String r35 = this.$task.E();     // Catch: Throwable -> L9 Exception -> L11
        this.L$0 = r13;     // Catch: Throwable -> L9 Exception -> L11
        this.label = 1;     // Catch: Throwable -> L9 Exception -> L11
        r16 = AppInstaller.a(r33, r34, r35, this);     // Catch: Throwable -> L9 Exception -> L11
        if (r16 != r10) goto L74;
        return r10;
    L78:
        com.bytedanceos.common.toolbox.j.s("[AppStatus][AppInstaller][InstallStage]: signNotMatch, not force install task, taskId=" + this.$task.A());     // Catch: Throwable -> L9 Exception -> L11
        goto L79
    L57:
        if (o.r(r28) == false) goto L59;
    L32:
        if (o.r(r25) == true) goto L35;
        r110 = false;
    L9:
        th = move-exception;
        new File(r11).delete();     // Catch: Exception -> L94
    L92:
        throw th;
    L11:
        e = move-exception;
        if ((e instanceof CancellationException) == true) goto L90;
        i r36 = new i(this.$task, -99, "AppInstaller err: " + e.getMessage());     // Catch: Throwable -> L9
        new File(r11).delete();     // Catch: Exception -> L95
    L89:
        return r36;
    L90:
        throw e;     // Catch: Throwable -> L9
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super i> r11) {
        return ((AppInstaller$installApp$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
