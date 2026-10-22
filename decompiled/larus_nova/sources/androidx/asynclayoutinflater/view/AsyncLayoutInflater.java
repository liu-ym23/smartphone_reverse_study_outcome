package androidx.asynclayoutinflater.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    private static volatile boolean ignoreInflateAfterContextDestroy;
    private static LifecycleCallbacks lifecycleCallbacks;
    Handler mHandler;
    private Handler.Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    public static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public BasicInflater(Context r100) {
            super(r100);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r100) {
            return new BasicInflater(r100);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r100, AttributeSet r101) throws ClassNotFoundException {
            String[] r102 = sClassPrefixList;
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L10;
            View r105 = createView(r100, r102[r104], r101);     // Catch: ClassNotFoundException -> L11
            if (r105 == null) goto L8;
            return r105;
        L8:
            r104 = r104 + 1;
            goto L3
        L10:
            return super.onCreateView(r100, r101);
        }
    }

    public static class InflateRequest {
        OnInflateFinishedListener callback;
        volatile AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        public InflateRequest() {
        }
    }

    public static class InflateThread extends PthreadThreadV2 {
        private static final InflateThread sInstance = null;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private Pools.SynchronizedPool<InflateRequest> mRequestPool;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        static {
            InflateThread r100 = new InflateThread();
            sInstance = r100;
            ThreadMethodProxy.start(r100);
        }

        private InflateThread() {
            super("AsyncLayoutInflater$InflateThread");
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new Pools.SynchronizedPool(10);
        }

        public InflateRequest obtainRequest() {
            InflateRequest r100 = this.mRequestPool.acquire();
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new InflateRequest();
        }

        public void runInner() {
            InflateRequest r100 = this.mQueue.take();     // Catch: InterruptedException -> L18
            if (shouldInterceptInflateRequest(r100) == false) goto L8;
            OnInflateFinishedListener r101 = r100.callback;
            int r102 = r100.resid;
            releaseRequest(r100);
            AsyncLayoutInflater.access$300(r101, r102);
            return;
        L8:
            if (r100.inflater != null) goto L21;
            return;
        L21:
            r100.view = r100.inflater.mInflater.inflate(r100.resid, r100.parent, false);     // Catch: RuntimeException -> L13
        L16:
            Message.obtain(r100.inflater.mHandler, 0, r100).sendToTarget();
            return;
        L14:
            if (r100.inflater != null) goto L16;
            return;
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread__run$___twin___() {
        L2:
            runInner();
            goto L2
        }

        public static /* synthetic */ ArrayBlockingQueue access$100(InflateThread r100) {
            return r100.mQueue;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread_com_larus_apm_impl_protector_RunnableLancet_run(InflateThread r100) {
            r100.androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean shouldInterceptInflateRequest(InflateRequest r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (AsyncLayoutInflater.access$400() == true) goto L8;
            return false;
        L8:
            AsyncLayoutInflater r101 = r100.inflater;
            if (r101 != null) goto L11;
            return false;
        L11:
            LayoutInflater r102 = r101.mInflater;
            if (r102 != null) goto L14;
            return false;
        L14:
            Context r103 = r102.getContext();
            Activity r104 = AsyncLayoutInflater.access$200(r103);
            if (r104 == null) goto L23;
            if (r104.isDestroyed() == false) goto L19;
        L20:
            r104.toString();
            return true;
        L19:
            if (r104.isFinishing() == true) goto L20;
        L23:
            if ((r103 instanceof LifecycleOwner) == false) goto L30;
            Lifecycle r105 = ((LifecycleOwner) r103).getLifecycle();
            if (r105 == null) goto L30;
            if (r105.getCurrentState() != Lifecycle.State.DESTROYED) goto L30;
            Objects.toString(r103);
            return true;
        L30:
            return false;
        }

        public void enqueue(InflateRequest r100) {
            this.mQueue.put(r100);     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }

        public void releaseRequest(InflateRequest r100) {
            r100.callback = null;
            r100.inflater = null;
            r100.parent = null;
            r100.resid = 0;
            r100.view = null;
            this.mRequestPool.release(r100);     // Catch: IllegalStateException -> L5
            return;
        }
    }

    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        public /* synthetic */ LifecycleCallbacks(AnonymousClass1 r100) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            SystemClock.uptimeMillis();     // Catch: Throwable -> L16
            InflateThread r101 = InflateThread.getInstance();     // Catch: Throwable -> L16
            Iterator r102 = InflateThread.access$100(r101).iterator();     // Catch: Throwable -> L16
        L4:
            if (r102.hasNext() == false) goto L14;
            InflateRequest r103 = (InflateRequest) r102.next();     // Catch: Throwable -> L16
            AsyncLayoutInflater r104 = r103.inflater;     // Catch: Throwable -> L16
            if (r104 == null) goto L4;
            LayoutInflater r105 = r104.mInflater;     // Catch: Throwable -> L16
            if (r105 == null) goto L4;
            if (AsyncLayoutInflater.access$200(r105.getContext()) != r100) goto L4;
            r102.remove();     // Catch: Throwable -> L16
            r103.inflater = null;     // Catch: Throwable -> L16
            OnInflateFinishedListener r106 = r103.callback;     // Catch: Throwable -> L16
            int r107 = r103.resid;     // Catch: Throwable -> L16
            r101.releaseRequest(r103);     // Catch: Throwable -> L16
            AsyncLayoutInflater.access$300(r106, r107);     // Catch: Throwable -> L16
            Objects.toString(r100);     // Catch: Throwable -> L16
            goto L4
        L14:
            SystemClock.uptimeMillis();     // Catch: Throwable -> L16
            return;
        }
    }

    public interface OnInflateFinishedListener {

        /* JADX INFO: renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCancel(OnInflateFinishedListener r100, int r101) {
            }
        }

        void onCancel(int r100);

        void onInflateFinished(View r100, int r101, ViewGroup r102);
    }

    public static /* synthetic */ boolean access$400() {
        return ignoreInflateAfterContextDestroy;
    }

    public AsyncLayoutInflater(Context r100) {
        this.mHandlerCallback = new AnonymousClass1(this);
        this.mInflater = new BasicInflater(r100);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    public static /* synthetic */ Activity access$200(Context r100) {
        return asActivity(r100);
    }

    private static Activity asActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return asActivity(((ContextWrapper) r100).getBaseContext());
    }

    public static void setIgnoreInflateAfterContextDestroy(boolean r100) {
        ignoreInflateAfterContextDestroy = r100;
    }

    public static /* synthetic */ void access$300(OnInflateFinishedListener r100, int r101) {
        notifyCancel(r100, r101);
    }

    private static void notifyCancel(OnInflateFinishedListener r100, int r101) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.onCancel(r101);     // Catch: Throwable -> L6
        return;
    }

    public static void setClearRelatedInflateRequestAfterActivityDestroy(Application r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        monitor-enter(AsyncLayoutInflater.class);
        AnonymousClass1 r102 = null;
        if (r101 == true) goto L9;
        Application.ActivityLifecycleCallbacks r103 = lifecycleCallbacks;     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        r100.unregisterActivityLifecycleCallbacks(r103);     // Catch: Throwable -> L16
        lifecycleCallbacks = null;     // Catch: Throwable -> L16
    L14:
        monitor-exit(AsyncLayoutInflater.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (lifecycleCallbacks != null) goto L14;
        LifecycleCallbacks r104 = new LifecycleCallbacks(r102);     // Catch: Throwable -> L16
        lifecycleCallbacks = r104;     // Catch: Throwable -> L16
        r100.registerActivityLifecycleCallbacks(r104);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void inflate(int r100, ViewGroup r101, OnInflateFinishedListener r102) {
        if (r102 == null) goto L6;
        InflateRequest r103 = this.mInflateThread.obtainRequest();
        r103.inflater = this;
        r103.resid = r100;
        r103.parent = r101;
        r103.callback = r102;
        this.mInflateThread.enqueue(r103);
        return;
    L6:
        throw new NullPointerException("callback argument may not be null!");
    }
}
