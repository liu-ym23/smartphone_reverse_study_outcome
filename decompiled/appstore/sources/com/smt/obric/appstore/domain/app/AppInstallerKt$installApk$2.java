package com.smt.obric.appstore.domain.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.os.Build;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.utils.PerformanceMonitor;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallerKt$installApk$2", f = "AppInstaller.kt", i = {0, 0}, l = {429}, m = "invokeSuspend", n = {"installer", "sessionId"}, s = {"L$0", "I$0"})
public final class AppInstallerKt$installApk$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ String $apkFilePath;
    final /* synthetic */ Context $ctx;
    final /* synthetic */ int $installFlag;
    final /* synthetic */ String $pkg;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AppInstallerKt$installApk$2(String r10, String r11, Context r12, int r13, Continuation<? super AppInstallerKt$installApk$2> r14) {
        this.$pkg = r10;
        this.$apkFilePath = r11;
        this.$ctx = r12;
        this.$installFlag = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallerKt$installApk$2 r12 = new AppInstallerKt$installApk$2(this.$pkg, this.$apkFilePath, this.$ctx, this.$installFlag, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Integer> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r17) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        ?? r12 = 1;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        int r13 = this.I$0;
        Closeable r14 = (Closeable) this.L$1;
        PackageInstaller r15 = (PackageInstaller) this.L$0;
        kotlin.c.b(r17);     // Catch: Throwable -> L8 TimeoutCancellationException -> L10
        int r16 = r13;
        Object r18 = r17;
        Closeable r19 = r14;
    L88:
        Pair r20 = (Pair) r18;     // Catch: Throwable -> L43 TimeoutCancellationException -> L45
        kotlin.io.b.a(r19, null);     // Catch: Throwable -> L41
        r15.abandonSession(r16);     // Catch: Throwable -> L18 Exception -> L67
    L39:
        Object r21 = Result.m35constructorimpl(r20);     // Catch: Throwable -> L18
    L62:
        String r22 = this.$pkg;
        String r23 = this.$apkFilePath;
        Throwable r24 = Result.m38exceptionOrNullimpl(r21);
        if (r24 != null) goto L65;
        Pair r25 = (Pair) r21;
        boolean r26 = ((Boolean) r25.component1()).booleanValue();
        int r27 = ((Number) r25.component2()).intValue();
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp result, succ=" + r26 + ", code=" + r27 + ", packageName=" + r22 + ", path=" + r23);
        PerformanceMonitor.a(r22);
        return tf.a.c(r27);
    L65:
        com.bytedanceos.common.toolbox.j.q("[AppStatus][AppInstaller][InstallStage] installApp result, installing fail packageName=" + r22 + ", path=" + r23 + TokenParser.SP, r24);
        PerformanceMonitor.a(r22);
        return tf.a.c(-99);
    L41:
        th = th;
    L42:
        PackageInstaller r110 = r15;
    L74:
        r110.abandonSession(r16);     // Catch: Throwable -> L18 Exception -> L68
    L60:
        throw th;     // Catch: Throwable -> L18
    L45:
        e = e;
    L50:
        throw new IllegalStateException("app install fail timeout", e);     // Catch: Throwable -> L8
    L43:
        th = move-exception;
        Throwable r28 = th;
        r11 = r16;
        r12 = r19;
    L84:
        throw r28;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        kotlin.io.b.a(r12, r28);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L56:
        th = th;
        r16 = r11;
    L10:
        e = e;
        goto L50
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r17);
        CoroutineScope r29 = (CoroutineScope) this.L$0;
        String r30 = this.$pkg;
        String r31 = this.$apkFilePath;
        final Context r32 = this.$ctx;
        int r33 = this.$installFlag;
        Result.a r111 = Result.Companion;     // Catch: Throwable -> L18
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp, installing begin packageName=" + r30 + ", path=" + r31);     // Catch: Throwable -> L18
        r110 = r32.getPackageManager().getPackageInstaller();     // Catch: Throwable -> L18
        q.f(r110, "getPackageInstaller(...)");     // Catch: Throwable -> L18
        PackageInstaller.SessionParams r112 = new PackageInstaller.SessionParams(1);     // Catch: Throwable -> L18
        r112.installFlags = r33 | r112.installFlags;     // Catch: Throwable -> L18
        int r34 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L18
        PackageInfo r113 = com.bytedanceos.common.toolbox.e.V(BaseApplication.c(), r31, 8192);     // Catch: Throwable -> L18
        if (r113 == null) goto L20;
        r112.setInstallLocation(r113.installLocation);     // Catch: Throwable -> L18
    L20:
        r112.setInstallReason(4);     // Catch: Throwable -> L18
        r112.setAppPackageName(r30);     // Catch: Throwable -> L18
        r16 = r110.createSession(r112);     // Catch: Throwable -> L18
        PackageInstaller.Session r114 = r110.openSession(r16);     // Catch: Throwable -> L58
        q.d(r114);     // Catch: Throwable -> L25
        AppInstallerKt.b(r114, r31, r30 + ".apk");     // Catch: Throwable -> L25
        String r35 = "com.bytedance.common.ACTION_INSTALL_STATUS@" + r16;     // Catch: Throwable -> L25
        Intent r115 = new Intent(r35);     // Catch: Throwable -> L25
        r115.setPackage(BaseApplication.c().getPackageName());     // Catch: Throwable -> L25
        PendingIntent r36 = PendingIntent.getBroadcast(BaseApplication.c(), 0, r115, 1107296256);     // Catch: Throwable -> L25
        Channel r116 = kotlinx.coroutines.channels.e.b(1, null, null, 6, null);     // Catch: Throwable -> L25
        final k r117 = new k(r30, r35, r116);     // Catch: Throwable -> L25
        if (r34 < 33) goto L27;
        r32.registerReceiver(r117, new IntentFilter(r35), 2);     // Catch: Throwable -> L25
    L28:
        Job r37 = (Job) r29.getCoroutineContext().get(Job.Key);     // Catch: Throwable -> L25
        if (r37 == null) goto L31;
        r37.invokeOnCompletion(new AppInstallerKt$installApk$2$1$ret$1$1(r32, r117));     // Catch: Throwable -> L25
    L31:
        r114.commit(r36.getIntentSender());     // Catch: Throwable -> L25
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] installApp, waiting for installing " + r30 + " sessionId " + r16);     // Catch: Throwable -> L25
        AppInstallerKt$installApk$2$1$ret$1$r$1 r38 = new AppInstallerKt$installApk$2$1$ret$1$r$1(r116, null);     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        this.L$0 = r110;     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        this.L$1 = r114;     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        this.I$0 = r16;     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        this.label = 1;     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        r18 = TimeoutKt.c(180000, r38, this);     // Catch: Throwable -> L25 TimeoutCancellationException -> L47
        if (r18 != r10) goto L35;
        return r10;
    L35:
        r15 = r110;
        r19 = r114;
        goto L88
    L47:
        e = e;
        goto L50
    L27:
        r32.registerReceiver(r117, new IntentFilter(r35));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r28 = th;
        r15 = r110;
        r11 = r16;
        r12 = r114;
    L58:
        th = th;
    L18:
        th = move-exception;
        Result.a r39 = Result.Companion;
        r21 = Result.m35constructorimpl(kotlin.c.a(th));
    L8:
        th = move-exception;
        r28 = th;
        goto L84
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Integer> r11) {
        return ((AppInstallerKt$installApk$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
