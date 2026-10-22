package androidx.lifecycle;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/AtomicReference;", "V", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "base", "Ljava/util/concurrent/atomic/AtomicReference;", MonitorConstants.CONNECT_TYPE_GET, "()Ljava/lang/Object;", "compareAndSet", "", "expectedValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public final V get() {
        return this.base.get();
    }

    public AtomicReference(V r100) {
        this.base = new java.util.concurrent.atomic.AtomicReference(r100);
    }

    public final boolean compareAndSet(V r100, V r101) {
        java.util.concurrent.atomic.AtomicReference<V> r102 = this.base;
    L4:
        if (r102.compareAndSet(r100, r101) == true) goto L5;
        if (r102.get() == r100) goto L4;
        return false;
    L5:
        return true;
    }
}
