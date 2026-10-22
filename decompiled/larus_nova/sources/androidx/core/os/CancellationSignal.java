package androidx.core.os;

/* JADX INFO: loaded from: classes17.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    public void cancel() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCanceled == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L7:
        this.mIsCanceled = true;     // Catch: Throwable -> L31
        this.mCancelInProgress = true;     // Catch: Throwable -> L31
        OnCancelListener r100 = this.mOnCancelListener;     // Catch: Throwable -> L31
        Object r101 = this.mCancellationSignalObj;     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        if (r100 != null) goto L36;
    L14:
        if (r101 == null) goto L24;
        ((android.os.CancellationSignal) r101).cancel();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L21
        notifyAll();     // Catch: Throwable -> L21
        throw th;
    L21:
        th = move-exception;
        throw th;
    L24:
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L28
        notifyAll();     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L36:
        r100.onCancel();     // Catch: Throwable -> L12
        goto L14
    }

    public Object getCancellationSignalObject() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mCancellationSignalObj != null) goto L8;
        android.os.CancellationSignal r100 = new android.os.CancellationSignal();     // Catch: Throwable -> L11
        this.mCancellationSignalObj = r100;     // Catch: Throwable -> L11
        if (this.mIsCanceled == false) goto L8;
        android.os.CancellationSignal r101 = r100;     // Catch: Throwable -> L11
        r100.cancel();     // Catch: Throwable -> L11
    L8:
        Object r102 = this.mCancellationSignalObj;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r102;
    }

    public boolean isCanceled() {
        monitor-enter(this);
        boolean r100 = this.mIsCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private void waitForCancelFinishedLocked() {
    L3:
        if (this.mCancelInProgress == false) goto L7;
        wait();     // Catch: InterruptedException -> L6
        goto L3
    }

    public void throwIfCanceled() {
        if (isCanceled() == true) goto L6;
        return;
    L6:
        throw new OperationCanceledException();
    }

    public CancellationSignal() {
    }

    public void setOnCancelListener(OnCancelListener r100) {
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L16
        if (this.mOnCancelListener != r100) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mOnCancelListener = r100;     // Catch: Throwable -> L16
        if (this.mIsCanceled == false) goto L14;
        if (r100 == null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L16
        r100.onCancel();
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
