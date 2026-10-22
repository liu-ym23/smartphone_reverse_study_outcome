package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.stepos.core.ota.d;
import h2.f;
import h2.t;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g;
import r2.k;
import r2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c {
    private Context mAppContext;
    private final AtomicInteger mStopReason = new AtomicInteger(-256);
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.work.c$a$a, reason: collision with other inner class name */
        public static final class C0022a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final Data f2829a = Data.f2768b;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0022a.class != obj.getClass()) {
                    return false;
                }
                return this.f2829a.equals(((C0022a) obj).f2829a);
            }

            public final int hashCode() {
                return this.f2829a.hashCode() + (C0022a.class.getName().hashCode() * 31);
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.f2829a + '}';
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class b extends a {
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.work.c$a$c, reason: collision with other inner class name */
        public static final class C0023c extends a {

            /* renamed from: a, reason: collision with root package name */
            public final Data f2830a = Data.f2768b;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0023c.class != obj.getClass()) {
                    return false;
                }
                return this.f2830a.equals(((C0023c) obj).f2830a);
            }

            public final int hashCode() {
                return this.f2830a.hashCode() + (C0023c.class.getName().hashCode() * 31);
            }

            public final String toString() {
                return "Success {mOutputData=" + this.f2830a + '}';
            }
        }
    }

    public c(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getForegroundInfoAsync$0(CallbackToFutureAdapter.a aVar) {
        aVar.b(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for`getForegroundInfoAsync()`"));
        return "default failing getForegroundInfoAsync";
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f2806f;
    }

    public c5.a<f> getForegroundInfoAsync() {
        return CallbackToFutureAdapter.a(new d(13));
    }

    public final UUID getId() {
        return this.mWorkerParams.f2801a;
    }

    public final Data getInputData() {
        return this.mWorkerParams.f2802b;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f2804d.f2813c;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.f2805e;
    }

    public final int getStopReason() {
        return this.mStopReason.get();
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f2803c;
    }

    public s2.b getTaskExecutor() {
        return this.mWorkerParams.h;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f2804d.f2811a;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f2804d.f2812b;
    }

    public t getWorkerFactory() {
        return this.mWorkerParams.f2808i;
    }

    public final boolean isStopped() {
        return this.mStopReason.get() != -256;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final c5.a<Void> setForegroundAsync(f fVar) {
        return this.mWorkerParams.f2810k.a(getApplicationContext(), getId(), fVar);
    }

    public c5.a<Void> setProgressAsync(Data data) {
        q qVar = this.mWorkerParams.f2809j;
        getApplicationContext();
        UUID id2 = getId();
        k kVar = qVar.f11718b.f11878a;
        com.stepos.core.model.inference.a aVar = new com.stepos.core.model.inference.a(qVar, id2, data, 2);
        g.f(kVar, "<this>");
        return CallbackToFutureAdapter.a(new com.stepos.core.ota.downloader.a(kVar, "updateProgress", aVar));
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract c5.a<a> startWork();

    public final void stop(int i10) {
        if (this.mStopReason.compareAndSet(-256, i10)) {
            onStopped();
        }
    }

    public void onStopped() {
    }
}
