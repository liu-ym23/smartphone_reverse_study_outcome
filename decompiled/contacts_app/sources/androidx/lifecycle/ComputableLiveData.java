package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComputableLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0019\u001a\u00028\u0000H%¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/ComputableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "_liveData", "Landroidx/lifecycle/LiveData;", "computing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getComputing$lifecycle_livedata_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getExecutor$lifecycle_livedata_release", "()Ljava/util/concurrent/Executor;", "invalid", "getInvalid$lifecycle_livedata_release", "invalidationRunnable", "Ljava/lang/Runnable;", "getInvalidationRunnable$lifecycle_livedata_release$annotations", "()V", "liveData", "getLiveData", "()Landroidx/lifecycle/LiveData;", "refreshRunnable", "getRefreshRunnable$lifecycle_livedata_release$annotations", "compute", "()Ljava/lang/Object;", "invalidate", "", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    /* JADX INFO: renamed from: $r8$lambda$5eX8YRZhf-92-7ktc4Rs00cwiRw, reason: not valid java name */
    public static /* synthetic */ void m62$r8$lambda$5eX8YRZhf927ktc4Rs00cwiRw(ComputableLiveData r0) {
        refreshRunnable$lambda$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$Z8umybky1QMyXLhEFEx8n57LwT0(ComputableLiveData r0) {
        invalidationRunnable$lambda$1(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    protected abstract T compute();

    public ComputableLiveData(Executor r2) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        this.executor = r2;
        LiveData<T> r3 = new ComputableLiveData$_liveData$1(this);
        this._liveData = r3;
        this.liveData = r3;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new ComputableLiveData$$ExternalSyntheticLambda0(this);
        this.invalidationRunnable = new ComputableLiveData$$ExternalSyntheticLambda1(this);
    }

    public /* synthetic */ ComputableLiveData(Executor r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r1, "getIOThreadExecutor()");
    L5:
        this(r1);
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void refreshRunnable$lambda$0(ComputableLiveData r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
    L3:
        boolean r1 = false;
        if (r5.computing.compareAndSet(false, true) == false) goto L15;
        Object r0 = null;
        boolean r3 = false;
    L19:
        if (r5.invalid.compareAndSet(true, false) == false) goto L9;
        r0 = r5.compute();     // Catch: Throwable -> L12
        r3 = true;
        goto L19
    L9:
        if (r3 == false) goto L11;
        r5.getLiveData().postValue(r0);     // Catch: Throwable -> L12
    L11:
        r5.computing.set(false);
        r1 = r3;
    L12:
        th = move-exception;
        r5.computing.set(false);
        throw th;
    L15:
        if (r1 == false) goto L18;
        if (r5.invalid.get() == true) goto L3;
        return;
    }

    private static final void invalidationRunnable$lambda$1(ComputableLiveData r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        boolean r0 = r4.getLiveData().hasActiveObservers();
        if (r4.invalid.compareAndSet(false, true) == false) goto L7;
        if (r0 == false) goto L8;
        r4.executor.execute(r4.refreshRunnable);
        return;
    L8:
        return;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }
}
