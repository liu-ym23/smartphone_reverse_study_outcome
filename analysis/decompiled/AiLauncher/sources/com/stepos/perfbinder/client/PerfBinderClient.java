package com.stepos.perfbinder.client;

import android.annotation.SuppressLint;
import android.app.ActivityThread;
import android.content.ContentProviderClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.perfbinder.client.PerfBinderClient;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\bJ\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0003J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0003J_\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000422\u0010\u001c\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00010\u001b0\u001a\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJU\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001822\u0010\u001c\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00010\u001b0\u001a\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/perfbinder/client/PerfBinderClient;", "", "<init>", "()V", "", "authority", "LY8/t;", "scheduleAutoRelease", "(Ljava/lang/String;)V", "cancelAutoRelease", "Landroid/content/ContentProviderClient;", "getOrCreateProviderClient", "(Ljava/lang/String;)Landroid/content/ContentProviderClient;", "serviceName", "methodName", "Landroid/os/Bundle;", "paramsBundle", "safeIpcRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "longLinkIpcRequest", "release", "releaseAll", "shutdown", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "serviceInterface", "", "Landroid/util/Pair;", "params", "createService", "(Ljava/lang/Class;Ljava/lang/String;[Landroid/util/Pair;)Ljava/lang/Object;", "(Ljava/lang/Class;[Landroid/util/Pair;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "", "AUTO_RELEASE_DELAY_MINUTES", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "providerClientMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ScheduledFuture;", "releaseTaskMap", "Ljava/util/concurrent/ScheduledExecutorService;", "scheduler", "Ljava/util/concurrent/ScheduledExecutorService;", "perfbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        p.h(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        scheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private PerfBinderClient() {
    }

    private final void cancelAutoRelease(String authority) {
        ScheduledFuture<?> scheduledFutureRemove = releaseTaskMap.remove(authority);
        if (scheduledFutureRemove != null) {
            scheduledFutureRemove.cancel(false);
        }
    }

    private final void scheduleAutoRelease(final String authority) {
        cancelAutoRelease(authority);
        releaseTaskMap.put(authority, scheduler.schedule(new Runnable() { // from class: L7.a
            @Override // java.lang.Runnable
            public final void run() {
                PerfBinderClient.scheduleAutoRelease$lambda$3(authority);
            }
        }, 5L, TimeUnit.MINUTES));
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
    public final <T> T createService(Class<T> serviceInterface, String serviceName, Pair<Class<?>, Object>... params) throws ClassNotFoundException {
        p.i(serviceInterface, "serviceInterface");
        p.i(params, "params");
        if (serviceName == null || serviceName.length() == 0) {
            serviceName = null;
        }
        if (serviceName == null) {
            ServiceName serviceName2 = (ServiceName) serviceInterface.getAnnotation(ServiceName.class);
            String strValue = serviceName2 != null ? serviceName2.value() : null;
            if (strValue == null) {
                throw new IllegalArgumentException("Service name not provided and no @ServiceName annotation found");
            }
            serviceName = strValue;
        }
        try {
            Class<?> cls = Class.forName(serviceName);
            ArrayList arrayList = new ArrayList(params.length);
            for (Pair<Class<?>, Object> pair : params) {
                arrayList.add((Class) pair.first);
            }
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
            ArrayList arrayList2 = new ArrayList(params.length);
            for (Pair<Class<?>, Object> pair2 : params) {
                arrayList2.add(pair2.second);
            }
            Object[] array = arrayList2.toArray(new Object[0]);
            return (T) cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)).newInstance(Arrays.copyOf(array, array.length));
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    @SuppressLint({"UseKtx"})
    public final ContentProviderClient getOrCreateProviderClient(String authority) {
        p.i(authority, "authority");
        ConcurrentHashMap<String, ContentProviderClient> concurrentHashMap = providerClientMap;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = concurrentHashMap.get(authority);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            contentProviderClientAcquireUnstableContentProviderClient = ActivityThread.currentApplication().getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://" + authority + ".PERF_BINDER_IPC_CALL"));
            ContentProviderClient contentProviderClientPutIfAbsent = concurrentHashMap.putIfAbsent(authority, contentProviderClientAcquireUnstableContentProviderClient);
            if (contentProviderClientPutIfAbsent != null) {
                contentProviderClientAcquireUnstableContentProviderClient = contentProviderClientPutIfAbsent;
            }
        }
        return contentProviderClientAcquireUnstableContentProviderClient;
    }

    @SuppressLint({"UseKtx"})
    public final Bundle longLinkIpcRequest(String authority, String serviceName, String methodName, Bundle paramsBundle) throws RemoteException {
        Bundle bundleCall;
        p.i(authority, "authority");
        p.i(serviceName, "serviceName");
        p.i(methodName, "methodName");
        p.i(paramsBundle, "paramsBundle");
        scheduleAutoRelease(authority);
        ContentProviderClient orCreateProviderClient = getOrCreateProviderClient(authority);
        Bundle bundle = new Bundle();
        bundle.putString("serviceName", serviceName);
        bundle.putString("methodName", methodName);
        bundle.putBundle("params", paramsBundle);
        if (orCreateProviderClient != null) {
            try {
                bundleCall = orCreateProviderClient.call(BaseConstantsKt.KEY_PERF_BINDER, "", bundle);
            } catch (DeadObjectException unused) {
                providerClientMap.remove(authority);
                cancelAutoRelease(authority);
                return longLinkIpcRequest(authority, serviceName, methodName, paramsBundle);
            }
        } else {
            bundleCall = null;
        }
        p.f(bundleCall);
        return bundleCall;
    }

    public final void release(String authority) {
        p.i(authority, "authority");
        cancelAutoRelease(authority);
        ContentProviderClient contentProviderClientRemove = providerClientMap.remove(authority);
        if (contentProviderClientRemove != null) {
            try {
                contentProviderClientRemove.close();
                Log.d(TAG, "成功释放 ContentProviderClient for authority: " + authority);
            } catch (Exception e10) {
                Log.e(TAG, "释放 ContentProviderClient 失败 for authority: " + authority, e10);
            }
        }
    }

    public final void releaseAll() {
        Set<String> setKeySet = providerClientMap.keySet();
        p.h(setKeySet, "<get-keys>(...)");
        for (String str : setKeySet) {
            PerfBinderClient perfBinderClient = INSTANCE;
            p.f(str);
            perfBinderClient.release(str);
        }
        Log.d(TAG, "已释放所有 ContentProviderClient");
    }

    public final Bundle safeIpcRequest(String authority, String serviceName, String methodName, Bundle paramsBundle) {
        p.i(authority, "authority");
        p.i(serviceName, "serviceName");
        p.i(methodName, "methodName");
        p.i(paramsBundle, "paramsBundle");
        Uri uri = Uri.parse("content://" + authority + ".PERF_BINDER_IPC_CALL");
        Bundle bundle = new Bundle();
        bundle.putString("serviceName", serviceName);
        bundle.putString("methodName", methodName);
        bundle.putBundle("params", paramsBundle);
        Bundle bundleCall = ActivityThread.currentApplication().getContentResolver().call(uri, BaseConstantsKt.KEY_PERF_BINDER, "", bundle);
        p.f(bundleCall);
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

    public final <T> T createService(Class<T> serviceInterface, Pair<Class<?>, Object>... params) {
        p.i(serviceInterface, "serviceInterface");
        p.i(params, "params");
        return (T) createService(serviceInterface, null, (Pair[]) Arrays.copyOf(params, params.length));
    }
}
