package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes17.dex */
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T r100);
    }

    public int getGeneration() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mGeneration;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isRunning() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread == null) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public void onDestruction() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler.hasMessages(1) == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        this.mThread.quit();     // Catch: Throwable -> L11
        this.mThread = null;     // Catch: Throwable -> L11
        this.mHandler = null;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    private void post(Runnable r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L7;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(this.mThreadName, this.mPriority);     // Catch: Throwable -> L10
        this.mThread = r102;     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L10
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);     // Catch: Throwable -> L10
        this.mGeneration++;     // Catch: Throwable -> L10
    L7:
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L10
        Handler r103 = this.mHandler;     // Catch: Throwable -> L10
        r103.sendMessage(r103.obtainMessage(1, r100));     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    public void onInvokeRunnable(Runnable r100) {
        r100.run();
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r102 = this.mHandler;     // Catch: Throwable -> L7
        r102.sendMessageDelayed(r102.obtainMessage(0), this.mDestructAfterMillisec);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> void postAndReply(final Callable<T> r100, final ReplyCallback<T> r101) {
        final Handler r102 = CalleeHandler.create();
        post(new AnonymousClass2(this, r100, r102, r101));
    }

    public <T> T postAndWait(final Callable<T> r110, int r111) throws InterruptedException {
        final ReentrantLock r100 = new ReentrantLock();
        final Condition r101 = r100.newCondition();
        final AtomicReference r102 = new AtomicReference();
        final AtomicBoolean r112 = new AtomicBoolean(true);
        post(new AnonymousClass3(this, r102, r110, r100, r112, r101));
        r100.lock();
    L20:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (r112.get() == true) goto L8;
        T r113 = (T) r102.get();
        r100.unlock();
        return r113;
    L8:
        long r114 = TimeUnit.MILLISECONDS.toNanos(r111);     // Catch: Throwable -> L20
    L24:
        r114 = r101.awaitNanos(r114);     // Catch: InterruptedException -> L23 Throwable -> L20
    L11:
        if (r112.get() == false) goto L12;
        if (r114 > 0) goto L24;
        throw new InterruptedException("timeout");     // Catch: Throwable -> L20
    L12:
        T r115 = (T) r102.get();
        r100.unlock();
        return r115;
    }

    public SelfDestructiveThread(String r100, int r101, int r102) {
        this.mLock = new Object();
        this.mCallback = new AnonymousClass1(this);
        this.mThreadName = r100;
        this.mPriority = r101;
        this.mDestructAfterMillisec = r102;
        this.mGeneration = 0;
    }
}
