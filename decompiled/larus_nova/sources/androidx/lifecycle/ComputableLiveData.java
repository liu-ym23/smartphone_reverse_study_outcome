package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\r\u0010\u001c\u001a\u00028\u0000H%¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00158\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/ComputableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "getExecutor$lifecycle_livedata_release", "()Ljava/util/concurrent/Executor;", "_liveData", "Landroidx/lifecycle/LiveData;", "liveData", "getLiveData", "()Landroidx/lifecycle/LiveData;", "invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInvalid$lifecycle_livedata_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "getComputing$lifecycle_livedata_release", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$lifecycle_livedata_release$annotations", "()V", "invalidationRunnable", "getInvalidationRunnable$lifecycle_livedata_release$annotations", "invalidate", "", "compute", "()Ljava/lang/Object;", "lifecycle-livedata_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void a(ComputableLiveData r100) {
        refreshRunnable$lambda$0(r100);
    }

    public static /* synthetic */ void b(ComputableLiveData r100) {
        invalidationRunnable$lambda$1(r100);
    }

    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    public abstract T compute();

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public ComputableLiveData(Executor r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.executor = r100;
        LiveData<T> r101 = new ComputableLiveData$_liveData$1(this);
        this._liveData = r101;
        this.liveData = r101;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new a(this);
        this.invalidationRunnable = new b(this);
    }

    private static final void invalidationRunnable$lambda$1(ComputableLiveData r100) {
        boolean r101 = r100.getLiveData().hasActiveObservers();
        if (r100.invalid.compareAndSet(false, true) == false) goto L7;
        if (r101 == false) goto L8;
        r100.executor.execute(r100.refreshRunnable);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void refreshRunnable$lambda$0(ComputableLiveData r100) {
    L2:
        boolean r101 = false;
        if (r100.computing.compareAndSet(false, true) == false) goto L14;
        Object r102 = null;
        boolean r103 = false;
    L18:
        if (r100.invalid.compareAndSet(true, false) == false) goto L8;
        r102 = r100.compute();     // Catch: Throwable -> L11
        r103 = true;
        goto L18
    L8:
        if (r103 == false) goto L10;
        r100.getLiveData().postValue(r102);     // Catch: Throwable -> L11
    L10:
        r100.computing.set(false);
        r101 = r103;
    L11:
        th = move-exception;
        r100.computing.set(false);
        throw th;
    L14:
        if (r101 == false) goto L17;
        if (r100.invalid.get() == true) goto L2;
        return;
    }

    public /* synthetic */ ComputableLiveData(Executor r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = ArchTaskExecutor.getIOThreadExecutor();
    L5:
        this(r100);
    }
}
