package com.stepos.core.common.cloudconfig;

import android.content.Context;
import android.os.SystemClock;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.cloudsdk.ICloudListener;
import com.stepos.core.common.cloudconfig.CloudConfigStore;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import jd.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigManager {
    private static final String TAG = "CloudConfigManager";
    private static volatile long lastPushMonoMs;
    private static volatile long lastPushWallMs;
    private static volatile CloudConfigProvider provider;
    private static volatile long startedAtMonoMs;
    private static volatile CloudConfigStore store;
    public static final CloudConfigManager INSTANCE = new CloudConfigManager();
    private static final ConcurrentHashMap<String, ICloudConfigListener> listeners = new ConcurrentHashMap<>();
    private static final Object pushLock = new Object();
    private static final AtomicLong pushCount = new AtomicLong(0);
    private static final AtomicLong okCount = new AtomicLong(0);
    private static final AtomicLong validateFailCount = new AtomicLong(0);
    private static final AtomicLong ioFailCount = new AtomicLong(0);
    private static volatile String lastPushResult = "";
    private static volatile int lastPushBytes = -1;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CloudConfigResult.values().length];
            try {
                iArr[CloudConfigResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CloudConfigResult.VALUE_FORMAT_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CloudConfigResult.FILE_IO_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CloudConfigResult.INNER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CloudConfigManager() {
    }

    private final String fmtDuration(long j10) {
        if (j10 < 0) {
            return "-";
        }
        long j11 = j10 / 1000;
        long j12 = 3600;
        long j13 = j11 / j12;
        long j14 = 60;
        long j15 = (j11 % j12) / j14;
        if (j13 > 0) {
            return j13 + "h" + j15 + "m";
        }
        if (j15 <= 0) {
            return j11 + "s";
        }
        return j15 + "m" + (j11 % j14) + "s";
    }

    private final String fmtWall(long j10) {
        if (j10 <= 0) {
            return "-";
        }
        String str = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.US).format(new Date(j10));
        g.e(str, "format(...)");
        return str;
    }

    private final ICloudListener.ResultCode handle(ICloudConfigListener iCloudConfigListener, InputStream inputStream) {
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        Object objA5;
        synchronized (pushLock) {
            AIEngineLogger.i(LogModule.CLOUDCONFIG, TAG, "onPush key=" + iCloudConfigListener.getKey() + " file=" + iCloudConfigListener.getFileName() + " -> 开始处理");
            pushCount.incrementAndGet();
            lastPushWallMs = System.currentTimeMillis();
            lastPushMonoMs = SystemClock.elapsedRealtime();
            lastPushResult = "PENDING";
            lastPushBytes = -1;
            try {
                try {
                    objA = b.E(inputStream);
                    inputStream.close();
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.CLOUDCONFIG, TAG, "read stream failed key=" + iCloudConfigListener.getKey() + ": " + thB.getMessage());
                    INSTANCE.recordFailure(ioFailCount, "FILE_IO_ERROR");
                    return ICloudListener.ResultCode.FILE_IO_ERROR;
                }
                byte[] bArr = (byte[]) objA;
                lastPushBytes = bArr.length;
                try {
                    objA2 = Boolean.valueOf(iCloudConfigListener.validate(bArr));
                } catch (Throwable th2) {
                    objA2 = c.a(th2);
                }
                Object obj = Boolean.FALSE;
                if (objA2 instanceof Result.Failure) {
                    objA2 = obj;
                }
                if (!((Boolean) objA2).booleanValue()) {
                    AIEngineLogger.w(LogModule.CLOUDCONFIG, TAG, "validate failed key=" + iCloudConfigListener.getKey());
                    INSTANCE.recordFailure(validateFailCount, "VALUE_FORMAT_ERROR");
                    return ICloudListener.ResultCode.VALUE_FORMAT_ERROR;
                }
                try {
                    CloudConfigStore cloudConfigStore = store;
                    g.c(cloudConfigStore);
                    cloudConfigStore.writeAtomic(iCloudConfigListener.getLocalName(), bArr);
                    objA3 = n.f10413a;
                } catch (Throwable th3) {
                    objA3 = c.a(th3);
                }
                Throwable thB2 = Result.b(objA3);
                if (thB2 != null) {
                    AIEngineLogger.w(LogModule.CLOUDCONFIG, TAG, "persist failed key=" + iCloudConfigListener.getKey() + ": " + thB2.getMessage());
                    INSTANCE.recordFailure(ioFailCount, "FILE_IO_ERROR");
                    return ICloudListener.ResultCode.FILE_IO_ERROR;
                }
                okCount.incrementAndGet();
                lastPushResult = "SUCCESS";
                try {
                    objA4 = iCloudConfigListener.onConfigReceived(iCloudConfigListener.getKey(), bArr);
                } catch (Throwable th4) {
                    objA4 = c.a(th4);
                }
                Throwable thB3 = Result.b(objA4);
                if (thB3 != null) {
                    AIEngineLogger.w(LogModule.CLOUDCONFIG, TAG, "onConfigReceived threw key=" + iCloudConfigListener.getKey() + ": " + thB3.getMessage());
                    lastPushResult = "SUCCESS(apply failed)";
                    objA4 = CloudConfigResult.INNER_ERROR;
                }
                CloudConfigResult cloudConfigResult = (CloudConfigResult) objA4;
                LogModule logModule = LogModule.CLOUDCONFIG;
                String key = iCloudConfigListener.getKey();
                int length = bArr.length;
                try {
                    CloudConfigStore cloudConfigStore2 = store;
                    g.c(cloudConfigStore2);
                    objA5 = Long.valueOf(cloudConfigStore2.version(iCloudConfigListener.getLocalName()));
                } catch (Throwable th5) {
                    objA5 = c.a(th5);
                }
                if (objA5 instanceof Result.Failure) {
                    objA5 = -1L;
                }
                AIEngineLogger.i(logModule, TAG, "下发成功 key=" + key + " bytes=" + length + " version=" + objA5 + " result=" + cloudConfigResult);
                return INSTANCE.toSdk(cloudConfigResult);
            } finally {
            }
        }
    }

    private final void recordFailure(AtomicLong atomicLong, String str) {
        atomicLong.incrementAndGet();
        lastPushResult = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ICloudListener.ResultCode start$lambda$1$lambda$0(ICloudConfigListener iCloudConfigListener, String str, InputStream stream) {
        g.f(str, "<unused var>");
        g.f(stream, "stream");
        CloudConfigManager cloudConfigManager = INSTANCE;
        g.c(iCloudConfigListener);
        return cloudConfigManager.handle(iCloudConfigListener, stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAsync$lambda$4(Context context) {
        Object objA;
        CloudConfigManager cloudConfigManager = INSTANCE;
        try {
            g.c(context);
            cloudConfigManager.start(context);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("startAsync failed (non-fatal): ", thB.getMessage(), LogModule.CLOUDCONFIG, TAG);
        }
    }

    private final ICloudListener.ResultCode toSdk(CloudConfigResult cloudConfigResult) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[cloudConfigResult.ordinal()];
        if (i10 == 1) {
            return ICloudListener.ResultCode.SUCCESS;
        }
        if (i10 == 2) {
            return ICloudListener.ResultCode.VALUE_FORMAT_ERROR;
        }
        if (i10 == 3) {
            return ICloudListener.ResultCode.FILE_IO_ERROR;
        }
        if (i10 == 4) {
            return ICloudListener.ResultCode.INNER_ERROR;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<String> dump() {
        String string;
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        String strO;
        Object objA5;
        Object objA6;
        ArrayList arrayList = new ArrayList();
        CloudConfigStore cloudConfigStore = store;
        boolean z = provider != null;
        ConcurrentHashMap<String, ICloudConfigListener> concurrentHashMap = listeners;
        arrayList.add("started=" + z + "  listeners=" + concurrentHashMap.keySet());
        if (startedAtMonoMs > 0) {
            arrayList.add("订阅建立至今=" + fmtDuration(SystemClock.elapsedRealtime() - startedAtMonoMs));
        }
        AtomicLong atomicLong = pushCount;
        long j10 = atomicLong.get();
        long j11 = okCount.get();
        long j12 = validateFailCount.get();
        long j13 = ioFailCount.get();
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "计数: push=", " ok=");
        sbQ.append(j11);
        a0.a.s(j12, " validateFail=", " ioFail=", sbQ);
        sbQ.append(j13);
        arrayList.add(sbQ.toString());
        if (atomicLong.get() == 0) {
            string = "最近推送: 本进程内无推送记录";
        } else {
            String strFmtWall = fmtWall(lastPushWallMs);
            String strFmtDuration = fmtDuration(SystemClock.elapsedRealtime() - lastPushMonoMs);
            String str = lastPushResult;
            int i10 = lastPushBytes;
            StringBuilder sbS = ai.onnxruntime.a.s("最近推送: ", strFmtWall, " (", strFmtDuration, "前)  result=");
            sbS.append(str);
            sbS.append("  bytes=");
            sbS.append(i10);
            string = sbS.toString();
        }
        arrayList.add(string);
        Collection<ICloudConfigListener> collectionValues = concurrentHashMap.values();
        g.e(collectionValues, "<get-values>(...)");
        for (ICloudConfigListener iCloudConfigListener : collectionValues) {
            arrayList.add("");
            String key = iCloudConfigListener.getKey();
            String fileName = iCloudConfigListener.getFileName();
            String localName = iCloudConfigListener.getLocalName();
            StringBuilder sbS2 = ai.onnxruntime.a.s("[", key, "] file=", fileName, " local=");
            sbS2.append(localName);
            arrayList.add(sbS2.toString());
            if (cloudConfigStore == null) {
                arrayList.add("  落盘: (store 未初始化，start 尚未完成)");
            } else {
                try {
                    objA = Long.valueOf(cloudConfigStore.fileSize(iCloudConfigListener.getLocalName()));
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = -1L;
                }
                long jLongValue = ((Number) objA).longValue();
                if (jLongValue < 0) {
                    strO = "  落盘: (无落盘文件，使用 APK assets 内置配置)";
                } else {
                    try {
                        objA2 = Long.valueOf(cloudConfigStore.version(iCloudConfigListener.getLocalName()));
                    } catch (Throwable th2) {
                        objA2 = c.a(th2);
                    }
                    if (objA2 instanceof Result.Failure) {
                        objA2 = -1L;
                    }
                    long jLongValue2 = ((Number) objA2).longValue();
                    try {
                        objA3 = cloudConfigStore.sha256(iCloudConfigListener.getLocalName());
                    } catch (Throwable th3) {
                        objA3 = c.a(th3);
                    }
                    if (objA3 instanceof Result.Failure) {
                        objA3 = null;
                    }
                    String str2 = (String) objA3;
                    if (str2 == null) {
                        str2 = "-";
                    }
                    String str3 = str2;
                    try {
                        objA4 = Long.valueOf(cloudConfigStore.mtime(iCloudConfigListener.getLocalName()));
                    } catch (Throwable th4) {
                        objA4 = c.a(th4);
                    }
                    if (objA4 instanceof Result.Failure) {
                        objA4 = -1L;
                    }
                    String strFmtWall2 = INSTANCE.fmtWall(((Number) objA4).longValue());
                    StringBuilder sbQ2 = ai.onnxruntime.a.q(jLongValue2, "  落盘: version=", " sizeBytes=");
                    ai.onnxruntime.a.u(jLongValue, " sha256=", str3, sbQ2);
                    strO = ai.onnxruntime.a.o(sbQ2, " mtime=", strFmtWall2);
                }
                arrayList.add(strO);
                try {
                    objA5 = iCloudConfigListener.dumpApplyState();
                } catch (Throwable th5) {
                    objA5 = c.a(th5);
                }
                Throwable thB = Result.b(objA5);
                if (thB != null) {
                    objA5 = b1.P("<listener dump failed: " + thB.getMessage() + ">");
                }
                List list = (List) objA5;
                if (list.isEmpty()) {
                    arrayList.add("  生效状态: (该接入方未上报)");
                } else {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add("  " + ((String) it.next()));
                    }
                }
                try {
                    objA6 = cloudConfigStore.lastSuccess(iCloudConfigListener.getLocalName());
                } catch (Throwable th6) {
                    objA6 = c.a(th6);
                }
                CloudConfigStore.SuccessMarker successMarker = (CloudConfigStore.SuccessMarker) (objA6 instanceof Result.Failure ? null : objA6);
                arrayList.add(successMarker == null ? "  上次成功下发(marker): (无记录，历史上从未成功下发)" : ai.onnxruntime.a.o(d.l("  上次成功下发(marker): ", successMarker.getVersion(), INSTANCE.fmtWall(successMarker.getWallClockMs()), " version="), " sha=", successMarker.getSha()));
            }
        }
        return arrayList;
    }

    public final void register(ICloudConfigListener listener) {
        g.f(listener, "listener");
        listeners.put(listener.getKey(), listener);
    }

    public final synchronized void start(Context context) {
        try {
            g.f(context, "context");
            if (provider != null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            store = new CloudConfigStore(new File(applicationContext.getDataDir(), "config"));
            String packageName = applicationContext.getPackageName();
            g.e(packageName, "getPackageName(...)");
            CloudConfigProvider cloudConfigProvider = new CloudConfigProvider(applicationContext, packageName);
            cloudConfigProvider.init();
            Collection<ICloudConfigListener> collectionValues = listeners.values();
            g.e(collectionValues, "<get-values>(...)");
            for (ICloudConfigListener iCloudConfigListener : collectionValues) {
                cloudConfigProvider.addListener(iCloudConfigListener.getKey(), new b6.c(iCloudConfigListener, 2));
            }
            cloudConfigProvider.registerForUpdates();
            provider = cloudConfigProvider;
            startedAtMonoMs = SystemClock.elapsedRealtime();
            AIEngineLogger.i(LogModule.CLOUDCONFIG, TAG, "started, listeners=" + listeners.keySet());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void startAsync(Context context) {
        g.f(context, "context");
        Thread thread = new Thread(new a(context.getApplicationContext(), 0), "aiengine-cloudconfig-start");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public final synchronized void stop() {
        try {
            CloudConfigProvider cloudConfigProvider = provider;
            if (cloudConfigProvider != null) {
                cloudConfigProvider.release();
            }
            provider = null;
            startedAtMonoMs = 0L;
        } catch (Throwable th) {
            throw th;
        }
    }
}
