package s0;

import K.i0;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import e.EnumC0546d;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import k.RunnableC0653g;

/* loaded from: classes.dex */
public abstract class s {

    @NonNull
    private Context mAppContext;
    private volatile int mStopReason = -256;
    private boolean mUsed;

    @NonNull
    private WorkerParameters mWorkerParams;

    public s(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    @NonNull
    @RestrictTo({EnumC0546d.f12493b})
    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f4317f;
    }

    @NonNull
    public final UUID getId() {
        return this.mWorkerParams.f4312a;
    }

    @NonNull
    public final C0850h getInputData() {
        return this.mWorkerParams.f4313b;
    }

    @Nullable
    @RequiresApi(28)
    public final Network getNetwork() {
        return (Network) this.mWorkerParams.f4315d.f2366d;
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.mWorkerParams.f4316e;
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.mStopReason;
    }

    @NonNull
    public final Set<String> getTags() {
        return this.mWorkerParams.f4314c;
    }

    @NonNull
    @RestrictTo({EnumC0546d.f12493b})
    public E0.a getTaskExecutor() {
        return this.mWorkerParams.f4318g;
    }

    @NonNull
    @RequiresApi(24)
    public final List<String> getTriggeredContentAuthorities() {
        return (List) this.mWorkerParams.f4315d.f2364b;
    }

    @NonNull
    @RequiresApi(24)
    public final List<Uri> getTriggeredContentUris() {
        return (List) this.mWorkerParams.f4315d.f2365c;
    }

    @NonNull
    @RestrictTo({EnumC0546d.f12493b})
    public K getWorkerFactory() {
        return this.mWorkerParams.f4319h;
    }

    public final boolean isStopped() {
        return this.mStopReason != -256;
    }

    @RestrictTo({EnumC0546d.f12493b})
    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    @NonNull
    public final D1.a setForegroundAsync(@NonNull C0852j c0852j) {
        InterfaceC0853k interfaceC0853k = this.mWorkerParams.f4321j;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        C0.u uVar = (C0.u) interfaceC0853k;
        uVar.getClass();
        D0.j jVar = new D0.j();
        uVar.f322a.a(new i0(uVar, jVar, id, c0852j, applicationContext, 1));
        return jVar;
    }

    @NonNull
    public D1.a setProgressAsync(@NonNull C0850h c0850h) {
        F f4 = this.mWorkerParams.f4320i;
        getApplicationContext();
        UUID id = getId();
        C0.v vVar = (C0.v) f4;
        vVar.getClass();
        D0.j jVar = new D0.j();
        vVar.f327b.a(new RunnableC0653g(2, vVar, id, c0850h, jVar));
        return jVar;
    }

    @RestrictTo({EnumC0546d.f12493b})
    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract D1.a startWork();

    @RestrictTo({EnumC0546d.f12493b})
    public final void stop(int i4) {
        this.mStopReason = i4;
        onStopped();
    }
}
