package com.stepos.perfbinder.client;

import a4.t;
import ad.o;
import android.annotation.SuppressLint;
import android.app.ActivityThread;
import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import g5.f;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v9.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PerfBinderClient {
    private static final long AUTO_RELEASE_DELAY_MINUTES = 5;
    private static final String TAG = "PerfBinderClient";
    private static final ScheduledExecutorService scheduler;
    public static final PerfBinderClient INSTANCE = new PerfBinderClient();
    private static final ConcurrentHashMap<String, ContentProviderClient> providerClientMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ScheduledFuture<?>> releaseTaskMap = new ConcurrentHashMap<>();

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.getClass();
        scheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private PerfBinderClient() {
    }

    private final void cancelAutoRelease(String str) {
        ScheduledFuture<?> scheduledFutureRemove = releaseTaskMap.remove(str);
        if (scheduledFutureRemove != null) {
            scheduledFutureRemove.cancel(false);
        }
    }

    private final void scheduleAutoRelease(String str) {
        cancelAutoRelease(str);
        ScheduledExecutorService scheduledExecutorService = scheduler;
        t tVar = new t(8);
        tVar.f200f = str;
        VarHandle.storeStoreFence();
        releaseTaskMap.put(str, scheduledExecutorService.schedule(tVar, AUTO_RELEASE_DELAY_MINUTES, TimeUnit.MINUTES));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleAutoRelease$lambda$3(String str) {
        try {
            Log.d(TAG, "自动释放 ContentProviderClient for authority: " + str + " (5分钟未使用)");
            INSTANCE.release(str);
        } catch (Exception e10) {
            Log.e(TAG, "自动释放任务执行失败 for authority: " + str, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T createService(Class<T> cls, String str, Pair<Class<?>, Object>... pairArr) throws ClassNotFoundException {
        cls.getClass();
        pairArr.getClass();
        if (str == null || str.length() == 0) {
            str = null;
        }
        if (str == null) {
            a aVar = (a) cls.getAnnotation(a.class);
            String strValue = aVar != null ? aVar.value() : null;
            if (strValue == null) {
                f.s("Service name not provided and no @ServiceName annotation found");
                return null;
            }
            str = strValue;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<Class<?>, Object> pair : pairArr) {
                arrayList.add((Class) pair.first);
            }
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair<Class<?>, Object> pair2 : pairArr) {
                arrayList2.add(pair2.second);
            }
            Object[] array = arrayList2.toArray(new Object[0]);
            return (T) cls2.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(Arrays.copyOf(array, array.length));
        } catch (ClassNotFoundException e10) {
            o.h(e10);
            return null;
        } catch (NoSuchMethodException e11) {
            o.h(e11);
            return null;
        } catch (InvocationTargetException e12) {
            o.h(e12);
            return null;
        }
    }

    @SuppressLint({"UseKtx"})
    public final ContentProviderClient getOrCreateProviderClient(String str) {
        str.getClass();
        ConcurrentHashMap<String, ContentProviderClient> concurrentHashMap = providerClientMap;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = concurrentHashMap.get(str);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            contentProviderClientAcquireUnstableContentProviderClient = ActivityThread.currentApplication().getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://" + str + ".PERF_BINDER_IPC_CALL"));
            ContentProviderClient contentProviderClientPutIfAbsent = concurrentHashMap.putIfAbsent(str, contentProviderClientAcquireUnstableContentProviderClient);
            if (contentProviderClientPutIfAbsent != null) {
                contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientPutIfAbsent;
            }
        }
        return contentProviderClientAcquireUnstableContentProviderClient;
    }

    @SuppressLint({"UseKtx"})
    public final Bundle longLinkIpcRequest(String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Bundle bundleCall;
        str.getClass();
        str2.getClass();
        str3.getClass();
        bundle.getClass();
        scheduleAutoRelease(str);
        ContentProviderClient orCreateProviderClient = getOrCreateProviderClient(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("serviceName", str2);
        bundle2.putString("methodName", str3);
        bundle2.putBundle("params", bundle);
        if (orCreateProviderClient != null) {
            try {
                bundleCall = orCreateProviderClient.call("perfbinder", "", bundle2);
            } catch (DeadObjectException unused) {
                providerClientMap.remove(str);
                cancelAutoRelease(str);
                return longLinkIpcRequest(str, str2, str3, bundle);
            }
        } else {
            bundleCall = null;
        }
        bundleCall.getClass();
        return bundleCall;
    }

    public final void release(String str) {
        str.getClass();
        cancelAutoRelease(str);
        ContentProviderClient contentProviderClientRemove = providerClientMap.remove(str);
        if (contentProviderClientRemove != null) {
            try {
                contentProviderClientRemove.close();
                Log.d(TAG, "成功释放 ContentProviderClient for authority: ".concat(str));
            } catch (Exception e10) {
                Log.e(TAG, "释放 ContentProviderClient 失败 for authority: ".concat(str), e10);
            }
        }
    }

    public final void releaseAll() {
        Set<String> setKeySet = providerClientMap.keySet();
        setKeySet.getClass();
        for (String str : setKeySet) {
            PerfBinderClient perfBinderClient = INSTANCE;
            str.getClass();
            perfBinderClient.release(str);
        }
        Log.d(TAG, "已释放所有 ContentProviderClient");
    }

    public final Bundle safeIpcRequest(String str, String str2, String str3, Bundle bundle) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        bundle.getClass();
        Uri uri = Uri.parse("content://" + str + ".PERF_BINDER_IPC_CALL");
        Bundle bundle2 = new Bundle();
        bundle2.putString("serviceName", str2);
        bundle2.putString("methodName", str3);
        bundle2.putBundle("params", bundle);
        Bundle bundleCall = ActivityThread.currentApplication().getContentResolver().call(uri, "perfbinder", "", bundle2);
        bundleCall.getClass();
        return bundleCall;
    }

    public final void shutdown() {
        try {
            ScheduledExecutorService scheduledExecutorService = scheduler;
            scheduledExecutorService.shutdown();
            if (!scheduledExecutorService.awaitTermination(1L, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
            Log.d(TAG, "定时任务执行器已关闭");
        } catch (Exception e10) {
            Log.e(TAG, "关闭定时任务执行器失败", e10);
            scheduler.shutdownNow();
        }
    }

    public final <T> T createService(Class<T> cls, Pair<Class<?>, Object>... pairArr) {
        cls.getClass();
        pairArr.getClass();
        return (T) createService(cls, null, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
