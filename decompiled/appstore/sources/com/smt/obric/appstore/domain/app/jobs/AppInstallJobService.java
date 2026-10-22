package com.smt.obric.appstore.domain.app.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/smt/obric/appstore/domain/app/jobs/AppInstallJobService;", "Landroid/app/job/JobService;", "<init>", "()V", "Landroid/app/job/JobParameters;", "params", "", "onStartJob", "(Landroid/app/job/JobParameters;)Z", "onStopJob", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/smt/obric/appstore/domain/app/AppInstallActor;", "b", "Lcom/smt/obric/appstore/domain/app/AppInstallActor;", "appInstallActor", "Lkotlinx/coroutines/Job;", "c", "Lkotlinx/coroutines/Job;", "jobRetryInstall", "d", "jobWifiDownload", "e", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInstallJobService extends JobService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f18027e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f18028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppInstallActor f18029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f18030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f18031d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10, JobParameters r11) {
            return r10.c(r11);
        }

        public final ComponentName b(Context r10) {
            q.g(r10, "context");
            return new ComponentName(r10.getPackageName(), AppInstallJobService.class.getName());
        }

        public final String c(JobParameters r10) {
            return "[id=" + r10.getJobId() + ", name=" + r10.getExtras().getString("job_name") + ']';
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.smt.obric.appstore.domain.app.jobs.AppInstallJobService$onStartJob$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.domain.app.jobs.AppInstallJobService$onStartJob$1", f = "AppInstallJobService.kt", i = {0, 0, 1}, l = {39, 40}, m = "invokeSuspend", n = {"$this$launch", "result", "$this$launch"}, s = {"L$0", "L$1", "L$0"})
    @SourceDebugExtension({"SMAP\nAppInstallJobService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInstallJobService.kt\ncom/smt/obric/appstore/domain/app/jobs/AppInstallJobService$onStartJob$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobParameters $localParams;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AppInstallJobService this$0;

        public AnonymousClass1(AppInstallJobService r10, JobParameters r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$localParams = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$localParams, r11);
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
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            c.b(r10);
        L16:
            boolean r14 = ((Boolean) r10).booleanValue();
            AppInstallJobService r15 = this.this$0;
            JobParameters r16 = this.$localParams;
            Result.a r17 = Result.Companion;     // Catch: Throwable -> L19
            r15.jobFinished(r16, !r14);     // Catch: Throwable -> L19
            Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L19
        L22:
            return Unit.f21064a;
        L19:
            th = move-exception;
            Result.a r18 = Result.Companion;
            Result.m35constructorimpl(c.a(th));
            goto L22
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CompletableDeferred r19 = (CompletableDeferred) this.L$1;
            CoroutineScope r20 = (CoroutineScope) this.L$0;
            c.b(r10);
        L13:
            this.L$0 = r20;
            this.L$1 = null;
            this.label = 2;
            r10 = r19.await(this);
            if (r10 != r11) goto L16;
            return r11;
        L10:
            c.b(r10);
            r20 = (CoroutineScope) this.L$0;
            r19 = u.b(null, 1, null);
            SendChannel r21 = AppInstallJobService.a(this.this$0).T();
            AppInstallActor.b.r r22 = new AppInstallActor.b.r(r19);
            this.L$0 = r20;
            this.L$1 = r19;
            this.label = 1;
            if (r21.send(r22, this) != r11) goto L13;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    static {
        f18027e = new a(null);
    }

    public AppInstallJobService() {
        this.f18028a = d0.b();
        this.f18029b = AppInstallActor.f17891n.b();
    }

    public static final /* synthetic */ AppInstallActor a(AppInstallJobService r10) {
        return r10.f18029b;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r11) {
        q.g(r11, "params");
        j.n("[AppStatus][Job] AppInstallJobService onStartJob, " + a.a(f18027e, r11));
        switch(r11.getJobId()) {
            case 200001: goto L11;
            case 200002: goto L6;
            default: goto L4;
        };
    L4:
        j.p("[AppStatus][Job] AppInstallJobService onStartJob: unknown jobId: " + r11.getJobId());
        return false;
    L6:
        Job r10 = this.f18031d;
        if (r10 == null) goto L9;
        Job.a.b(r10, null, 1, null);
    L9:
        this.f18031d = h.d(this.f18028a, null, null, new AnonymousClass1(this, r11, null), 3, null);
        return true;
    L11:
        Job r12 = this.f18030c;
        if (r12 == null) goto L14;
        Job.a.b(r12, null, 1, null);
    L14:
        this.f18029b.T().mo53trySendJP2dKIU(AppInstallActor.b.s.f17937a);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r10) {
        q.g(r10, "params");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        Integer r11 = Integer.valueOf(r10.getStopReason());
    L6:
        j.n("[AppStatus][Job] AppInstallJobService onStopJob, " + a.a(f18027e, r10) + ", stopReason: " + r11);
        switch(r10.getJobId()) {
            case 200001: goto L14;
            case 200002: goto L10;
            default: goto L8;
        };
    L8:
        j.p("[AppStatus][Job] AppInstallJobService onStopJob: unknown jobId: " + r10.getJobId());
        return false;
    L10:
        Job r12 = this.f18031d;
        if (r12 == null) goto L13;
        Job.a.b(r12, null, 1, null);
    L13:
        return true;
    L14:
        Job r13 = this.f18030c;
        if (r13 == null) goto L17;
        Job.a.b(r13, null, 1, null);
    L17:
        return true;
    L5:
        r11 = null;
        goto L6
    }
}
