package androidx.work.impl.workers;

import B0.r;
import D0.j;
import F0.a;
import android.content.Context;
import androidx.activity.d;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import e.EnumC0546d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import s0.s;
import s0.t;
import x0.b;
import x0.c;
import x0.e;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Ls0/s;", "Lx0/e;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo({EnumC0546d.f12493b})
@SourceDebugExtension({"SMAP\nConstraintTrackingWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstraintTrackingWorker.kt\nandroidx/work/impl/workers/ConstraintTrackingWorker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
/* loaded from: classes.dex */
public final class ConstraintTrackingWorker extends s implements e {

    /* renamed from: a, reason: collision with root package name */
    public final WorkerParameters f4346a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4347b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f4348c;

    /* renamed from: d, reason: collision with root package name */
    public final j f4349d;

    /* renamed from: e, reason: collision with root package name */
    public s f4350e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(@NotNull Context appContext, @NotNull WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.f4346a = workerParameters;
        this.f4347b = new Object();
        this.f4349d = new j();
    }

    @Override // x0.e
    public final void b(r workSpec, c state) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        Intrinsics.checkNotNullParameter(state, "state");
        t.d().a(a.f429a, "Constraints changed for " + workSpec);
        if (state instanceof b) {
            synchronized (this.f4347b) {
                this.f4348c = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // s0.s
    public final void onStopped() {
        s sVar = this.f4350e;
        if (sVar == null || sVar.isStopped()) {
            return;
        }
        sVar.stop(getStopReason());
    }

    @Override // s0.s
    public final D1.a startWork() {
        getBackgroundExecutor().execute(new d(9, this));
        j future = this.f4349d;
        Intrinsics.checkNotNullExpressionValue(future, "future");
        return future;
    }
}
