package com.stepos.alphame.engine;

import T1.a;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.alphame.listener.Future;
import com.stepos.alphame.listener.FutureListener;
import com.stepos.alphame.utils.AuthorizationUtils;
import com.stepos.alphame.utils.ThreadPool;
import com.stepos.common.alphame.Args;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class EngineBase {
    private static final EngineFuncMap FUNC_MAP = new EngineFuncMap();
    protected static final String TAG = "AlphaMe";
    private final String mName = getClass().getSimpleName();

    public static class ExecuteFutureListener implements FutureListener<ExecuteResult> {
        private ExecuteFutureListener() {
        }

        public /* synthetic */ ExecuteFutureListener(int i4) {
            this();
        }

        @Override // com.stepos.alphame.listener.FutureListener
        public void onFutureDone(Future<ExecuteResult> future) {
            EngineBase.returnResult(future.get());
        }
    }

    public static class ExecuteJob implements ThreadPool.Job<ExecuteResult> {
        ExecuteItem mItem;

        public ExecuteJob(ExecuteItem executeItem) {
            this.mItem = executeItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public ExecuteResult run() {
            return EngineBase.run(this.mItem);
        }
    }

    public static class ExecuteResult {
        ExecuteItem executeItem;
        Object val;

        public ExecuteResult(ExecuteItem executeItem) {
            this.executeItem = executeItem;
        }
    }

    public static boolean addFunc(EngineFunc engineFunc) {
        return FUNC_MAP.add(engineFunc);
    }

    public static void dump(PrintWriter printWriter) {
        printWriter.println("Function:");
        printWriter.println("");
        EngineFuncMap engineFuncMap = FUNC_MAP;
        synchronized (engineFuncMap) {
            try {
                Iterator<ArrayList<EngineFunc>> it = engineFuncMap.getAll().iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    Iterator<EngineFunc> it2 = it.next().iterator();
                    while (it2.hasNext()) {
                        EngineFunc next = it2.next();
                        if (!next.local) {
                            printWriter.println("#" + i4);
                            next.dump(printWriter);
                            printWriter.println("");
                            i4++;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void exec(ExecuteItem executeItem) {
        ThreadPool.getInstance().submit(new ExecuteJob(executeItem), new ExecuteFutureListener(0), executeItem.sync);
    }

    public static EngineFunc getFunc(String str, Args args) {
        return FUNC_MAP.get(str, args);
    }

    public static boolean removeFunc(EngineFunc engineFunc) {
        return FUNC_MAP.remove(engineFunc);
    }

    public static void returnErrorResult(AppClient appClient, int i4) {
        if (appClient.active) {
            try {
                appClient.client.onResult(new Args(null, Integer.valueOf(i4)));
            } catch (RemoteException e4) {
                Log.e(TAG, "onResult error: " + e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void returnResult(ExecuteResult executeResult) {
        ExecuteItem executeItem = executeResult.executeItem;
        AppClient appClient = executeItem.appClient;
        if (!Args.f(executeItem.func.returnType, Args.h(executeResult.val))) {
            Log.e(TAG, executeItem.func.getFullName() + " return wrong type");
            executeResult.val = null;
        }
        if (a.f1854a.get()) {
            Log.i(TAG, String.format("Send result %s to pid(%d) active = %s", executeResult.val, Integer.valueOf(appClient.pid), String.valueOf(appClient.active)));
        }
        if (appClient.active) {
            try {
                appClient.client.onResult(new Args(executeResult.val, Integer.valueOf(executeItem.receiver)));
            } catch (RemoteException e4) {
                Log.e(TAG, "onResult error: " + e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecuteResult run(ExecuteItem executeItem) {
        ExecuteResult executeResult = new ExecuteResult(executeItem);
        AtomicBoolean atomicBoolean = a.f1854a;
        long jCurrentTimeMillis = atomicBoolean.get() ? System.currentTimeMillis() : 0L;
        if (AuthorizationUtils.INSTANCE.isAuthorized(executeItem)) {
            executeResult.val = executeItem.func.invoke(executeItem.args);
            if (atomicBoolean.get()) {
                Log.i(TAG, String.format("Invoke %s cost time %d", executeItem.func.getFullName(), Integer.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis))));
            }
            return executeResult;
        }
        executeResult.val = null;
        Log.e(TAG, "fun" + executeItem.func.name + "not in authorized when get personal info");
        return executeResult;
    }

    public String getName() {
        return this.mName;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void start() {
        onStart();
    }

    public final void stop() {
        onStop();
        removeFunc(this);
    }

    public String toString() {
        return this.mName;
    }

    public void trimMemory() {
    }

    public static EngineFunc getFunc(String str) {
        return FUNC_MAP.get(str);
    }

    public static boolean removeFunc(EngineBase engineBase) {
        return FUNC_MAP.remove(engineBase);
    }
}
