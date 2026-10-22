package com.stepos.aiengine.service;

import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.u;
import b7.j;
import b7.s;
import com.stepos.backend.qnn.ComputeBucket;
import com.stepos.backend.qnn.QnnNative;
import com.stepos.backend.qnn.dump.QnnDumpProvider;
import com.stepos.base.concurrency.data.PoolType;
import com.stepos.base.health.EngineMetrics;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.dump.AbilityDumpProvider;
import com.stepos.core.ability.speech.debug.AsrStreamDebugInjector;
import com.stepos.core.common.cloud.CloudConfigBootstrap;
import com.stepos.core.common.cloud.CloudTransportConfig;
import com.stepos.core.common.cloudconfig.CloudConfigDumpProvider;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogDumpHelper;
import com.stepos.core.common.log.LogDumpHelperKt;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.model.dump.ExceptionDumpProvider;
import com.stepos.core.model.dump.ModelCacheDumpProvider;
import com.stepos.core.model.dump.TelemetryDumpProvider;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import com.stepos.core.ota.dump.KeyAttestDumpCommand;
import com.stepos.core.ota.dump.OtaDumpProvider;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.performance.data.GlobalVerdict;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import dc.h;
import f6.c;
import gc.n;
import gc.o;
import gc.q;
import h0.e;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.d;
import mb.l;
import ob.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineManagerService extends u {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5926c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final String f5927b = "AIEngineService";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t8, T t10) {
            return b.a(Long.valueOf(((AtomicLong) ((Map.Entry) t10).getValue()).get()), Long.valueOf(((AtomicLong) ((Map.Entry) t8).getValue()).get()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(PrintWriter printWriter) {
        Object objA;
        Object objA2;
        String str;
        printWriter.println("=== AIEngine Scoring & Release Metrics ===");
        printWriter.println();
        printWriter.println("[Pools]");
        ThreadPoolManagerImpl threadPoolManagerImplLatestInstanceOrNull = ThreadPoolManagerImpl.Companion.latestInstanceOrNull();
        if (threadPoolManagerImplLatestInstanceOrNull == null) {
            printWriter.println("  <threadPoolManager unavailable>");
        } else {
            for (PoolType poolType : PoolType.values()) {
                int queueSize = threadPoolManagerImplLatestInstanceOrNull.getQueueSize(poolType);
                int maxQueueSize = threadPoolManagerImplLatestInstanceOrNull.getMaxQueueSize(poolType);
                int inflightCount = threadPoolManagerImplLatestInstanceOrNull.getInflightCount(poolType);
                StringBuilder sbF = e.f("  ", poolType.name(), ": queue=", queueSize, "/");
                sbF.append(maxQueueSize);
                sbF.append(" inflight=");
                sbF.append(inflightCount);
                printWriter.println(sbF.toString());
            }
        }
        printWriter.println();
        printWriter.println("[QueueFull]");
        e.j("  total = ", EngineMetrics.f6229d.get(), printWriter);
        for (Map.Entry entry : EngineMetrics.f6230e.entrySet()) {
            printWriter.println("  by-pool " + ((PoolType) entry.getKey()).name() + " = " + ((AtomicLong) entry.getValue()).get());
        }
        Set<Map.Entry<Integer, AtomicLong>> setEntrySet = EngineMetrics.f6231f.entrySet();
        g.e(setEntrySet, "<get-entries>(...)");
        List<Map.Entry> listJ0 = kotlin.collections.a.J0(3, kotlin.collections.a.I0(setEntrySet, new a()));
        if (!listJ0.isEmpty()) {
            printWriter.println("  by-uid top-3:");
            for (Map.Entry entry2 : listJ0) {
                g.c(entry2);
                Object key = entry2.getKey();
                g.e(key, "component1(...)");
                Object value = entry2.getValue();
                g.e(value, "component2(...)");
                printWriter.println("    uid=" + ((Integer) key) + " count=" + ((AtomicLong) value).get());
            }
        }
        printWriter.println();
        printWriter.println("[Declared Downgrade]");
        printWriter.println("  count = " + EngineMetrics.f6232g.get());
        printWriter.println();
        printWriter.println("[Release Notify]");
        e.j("  notified       = ", EngineMetrics.f6234j.get(), printWriter);
        e.j("  debounced      = ", EngineMetrics.f6235k.get(), printWriter);
        e.j("  failed         = ", EngineMetrics.f6236l.get(), printWriter);
        e.j("  unknownReason  = ", EngineMetrics.f6237m.get(), printWriter);
        printWriter.println("  rssGateSkipped = " + EngineMetrics.h.get());
        printWriter.println();
        printWriter.println("[Tier Recording]");
        e.j("  recordAcquireTierFailed       = ", EngineMetrics.f6238n.get(), printWriter);
        printWriter.println("  recordAcquireTierDowncastMiss = " + EngineMetrics.f6239o.get());
        printWriter.println();
        printWriter.println("[Process RSS]");
        try {
            objA = Integer.valueOf(c.a(true));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = -1;
        }
        int iIntValue = ((Number) objA).intValue();
        if (iIntValue >= 0) {
            EngineMetrics.f6243t.set(iIntValue);
        }
        printWriter.println("  current          = " + iIntValue + "MB");
        EngineRuntimeConfig engineRuntimeConfig = EngineRuntimeConfig.INSTANCE;
        printWriter.println("  targetBgOnly     = " + engineRuntimeConfig.getSnapshot().getRssTargetBgOnlyMb() + "MB");
        printWriter.println("  targetWithFg     = " + engineRuntimeConfig.getSnapshot().getRssTargetWithFgMb() + "MB");
        printWriter.println("  targetLow        = " + engineRuntimeConfig.getSnapshot().getAbsoluteTargetLowMb() + "MB");
        printWriter.println("  targetUltraLow   = " + engineRuntimeConfig.getSnapshot().getAbsoluteTargetUltraLowMb() + "MB");
        e.j("  overshootNormal  = ", EngineMetrics.f6245v.get(), printWriter);
        e.j("  overshootLow     = ", EngineMetrics.f6246w.get(), printWriter);
        printWriter.println("  overshootUltra   = " + EngineMetrics.f6247x.get());
        printWriter.println();
        printWriter.println("[Evict]");
        e.j("  rssGateSkipped     = ", EngineMetrics.h.get(), printWriter);
        e.j("  skippedByTier      = ", EngineMetrics.f6233i.get(), printWriter);
        printWriter.println("  lastReleaseFreedMb = " + EngineMetrics.f6248y.get());
        printWriter.println();
        printWriter.println("[NPU]");
        androidx.preference.c cVar = EngineMetrics.f6242s;
        long jK = cVar.k();
        if (jK >= 0) {
            EngineMetrics.r.set(jK);
        }
        StringBuilder sbR = ai.onnxruntime.a.r(jK, "  waitMsP95 = ", " (n=", cVar.o());
        sbR.append(")");
        printWriter.println(sbR.toString());
        try {
            objA2 = QnnNative.INSTANCE.bucketPermits();
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        if (!(objA2 instanceof Result.Failure)) {
            for (Map.Entry entry3 : ((Map) objA2).entrySet()) {
                ComputeBucket computeBucket = (ComputeBucket) entry3.getKey();
                Pair pair = (Pair) entry3.getValue();
                int iIntValue2 = ((Number) pair.f9985a).intValue();
                int iIntValue3 = ((Number) pair.f9986b).intValue();
                StringBuilder sbF2 = e.f("  inflight ", computeBucket.name(), " = ", iIntValue3 - iIntValue2, "/");
                sbF2.append(iIntValue3);
                printWriter.println(sbF2.toString());
            }
        }
        Throwable thB = Result.b(objA2);
        if (thB != null) {
            printWriter.println("  inflight = <unavailable: " + thB.getMessage() + ">");
        }
        printWriter.println();
        printWriter.println("[Thermal]");
        androidx.preference.c cVar2 = EngineMetrics.F;
        long jK2 = cVar2.k();
        if (jK2 >= 0) {
            EngineMetrics.E.set(jK2);
        }
        printWriter.println("  pauseCount        = " + EngineMetrics.D.get());
        StringBuilder sbR2 = ai.onnxruntime.a.r(jK2, "  pauseDurationP95  = ", "ms (n=", cVar2.o());
        sbR2.append(")");
        printWriter.println(sbR2.toString());
        printWriter.println("  pausePending      = " + EngineMetrics.G.get());
        printWriter.println();
        printWriter.println("[ASR Uplink Flush]");
        androidx.preference.c cVar3 = EngineMetrics.O;
        long jK3 = cVar3.k();
        if (jK3 >= 0) {
            EngineMetrics.N.set(jK3);
        }
        long j10 = EngineMetrics.H.get();
        long j11 = EngineMetrics.I.get();
        e.j("  flushes          = ", j10, printWriter);
        printWriter.println("  frames           = " + j11 + (j10 > 0 ? ai.onnxruntime.a.h(j11 / j10, " (avg=", "/flush)") : ""));
        e.j("  pcmBytes         = ", EngineMetrics.J.get(), printWriter);
        e.j("  droppedFrames    = ", EngineMetrics.K.get(), printWriter);
        e.j("  enqueueDropped   = ", EngineMetrics.L.get(), printWriter);
        printWriter.println("  sendDropped      = " + EngineMetrics.M.get());
        StringBuilder sbR3 = ai.onnxruntime.a.r(jK3, "  durationP95      = ", "ms (n=", cVar3.o());
        sbR3.append(")");
        printWriter.println(sbR3.toString());
        printWriter.println();
        printWriter.println("[ASR Reconnect Link Park]");
        androidx.preference.c cVar4 = EngineMetrics.R;
        long jK4 = cVar4.k();
        if (jK4 >= 0) {
            EngineMetrics.Q.set(jK4);
        }
        printWriter.println("  parks            = " + EngineMetrics.P.get());
        StringBuilder sbR4 = ai.onnxruntime.a.r(jK4, "  durationP95      = ", "ms (n=", cVar4.o());
        sbR4.append(")");
        printWriter.println(sbR4.toString());
        printWriter.println();
        printWriter.println("[Camera Launch]");
        e.j("  released        = ", EngineMetrics.z.get(), printWriter);
        e.j("  cooldownSkipped = ", EngineMetrics.A.get(), printWriter);
        e.j("  rssGateSkipped  = ", EngineMetrics.B.get(), printWriter);
        printWriter.println("  freedMbP50      = " + EngineMetrics.C.get());
        printWriter.println();
        printWriter.println("[MaxTierByModel]");
        ModelCacheImpl modelCacheImpl = j.f3087b;
        if (modelCacheImpl == null) {
            modelCacheImpl = null;
        }
        if (modelCacheImpl == null) {
            printWriter.println("  <modelCache unavailable>");
        } else {
            List<Pair<String, TaskPriority>> listSnapshotMaxTierByModel = modelCacheImpl.snapshotMaxTierByModel();
            if (listSnapshotMaxTierByModel.isEmpty()) {
                printWriter.println("  <empty>");
            } else {
                Iterator<T> it = listSnapshotMaxTierByModel.iterator();
                while (it.hasNext()) {
                    Pair pair2 = (Pair) it.next();
                    String str2 = (String) pair2.f9985a;
                    TaskPriority taskPriority = (TaskPriority) pair2.f9986b;
                    g.f(taskPriority, "<this>");
                    int iOrdinal = taskPriority.ordinal();
                    if (iOrdinal == 0) {
                        str = "REALTIME";
                    } else if (iOrdinal == 1) {
                        str = "IMPORTANT";
                    } else if (iOrdinal == 2) {
                        str = "NORMAL";
                    } else {
                        if (iOrdinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str = "BACKGROUND";
                    }
                    String strName = taskPriority.name();
                    StringBuilder sbS = ai.onnxruntime.a.s("  ", str2, " -> ", str, " (");
                    sbS.append(strName);
                    sbS.append(")");
                    printWriter.println(sbS.toString());
                }
            }
        }
        printWriter.println();
        printWriter.println("=== end ===");
    }

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) throws InterruptedException {
        String[] strArr2;
        EngineMetrics.HealthStatus healthStatus;
        String str;
        String str2;
        String str3;
        StringBuilder sb2;
        String strG;
        int iE;
        int i10;
        PrintWriter printWriter2 = printWriter;
        String[] strArr3 = strArr;
        super.dump(fileDescriptor, printWriter, strArr);
        if (printWriter2 != null) {
            TelemetryDumpProvider telemetryDumpProvider = new TelemetryDumpProvider();
            if (strArr3 == null || (strArr2 = (String[]) l.d0(strArr3).toArray(new String[0])) == null) {
                strArr2 = new String[0];
            }
            for (String str4 : strArr2) {
                if (telemetryDumpProvider.supportsArg(str4)) {
                    telemetryDumpProvider.dump(printWriter2, strArr2);
                    return;
                }
            }
            numC0 = null;
            Integer numC0 = null;
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "rollback")) {
                ArrayList arrayListR0 = kotlin.collections.a.r0(l.c0(strArr3, 1));
                String str5 = (String) kotlin.collections.a.v0(arrayListR0);
                if (str5 == null || q.t0(str5)) {
                    printWriter2.println("usage: rollback <modelId> [--to <version>]");
                    return;
                }
                ModelCacheImpl modelCacheImpl = s.f3120b;
                if (modelCacheImpl == null) {
                    printWriter2.println("ERROR: VersionedModelCache not registered");
                    return;
                }
                int iIndexOf = arrayListR0.indexOf("--to");
                if (iIndexOf >= 0 && (i10 = iIndexOf + 1) < arrayListR0.size()) {
                    numC0 = n.c0((String) arrayListR0.get(i10));
                }
                if (numC0 != null) {
                    iE = numC0.intValue();
                } else {
                    d dVar = g7.a.f9073a;
                    iE = g7.a.a().e(0, "prev_".concat(str5));
                }
                if (iE <= 0) {
                    printWriter2.println("ERROR: no previous version recorded for ".concat(str5));
                    return;
                }
                StringBuilder sbF = e.f("Rolling back ", str5, ": v", modelCacheImpl.getCurrentVersion(str5), " -> v");
                sbF.append(iE);
                sbF.append(" ...");
                printWriter2.println(sbF.toString());
                if (!modelCacheImpl.rollback(str5, iE, "manual_cli")) {
                    printWriter2.println("ERROR: rollback failed (see logcat for details)");
                    AIEngineLogger.w(LogModule.MODEL, this.f5927b, com.stepos.core.ota.d.h("Manual rollback failed: modelId=", iE, str5, " toVersion="));
                    return;
                }
                printWriter2.println("OK: rolled back " + str5 + " to v" + iE);
                AIEngineLogger.i(LogModule.MODEL, this.f5927b, com.stepos.core.ota.d.h("Manual rollback succeeded: modelId=", iE, str5, " toVersion="));
                return;
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "forceVersion")) {
                ArrayList arrayListR02 = kotlin.collections.a.r0(l.c0(strArr3, 1));
                String str6 = (String) kotlin.collections.a.w0(0, arrayListR02);
                String str7 = (String) kotlin.collections.a.w0(1, arrayListR02);
                String str8 = (String) kotlin.collections.a.w0(2, arrayListR02);
                if (str6 == null || q.t0(str6) || str7 == null || q.t0(str7) || str8 == null || q.t0(str8)) {
                    printWriter2.println("usage: forceVersion <modelId> <newVersion> <newPath>");
                    printWriter2.println("  e.g. forceVersion bge-embedding 2 /data/data/com.stepos.aiengine/files/models/bge-embedding/bge-embedding-2");
                    return;
                }
                Integer numC02 = n.c0(str7);
                if (numC02 == null || numC02.intValue() <= 0) {
                    printWriter2.println("ERROR: invalid version '" + str7 + "' (must be positive int)");
                    return;
                }
                if (!new File(str8).isDirectory()) {
                    printWriter2.println("ERROR: newPath not a directory: ".concat(str8));
                    return;
                }
                ModelCacheImpl modelCacheImpl2 = s.f3120b;
                if (modelCacheImpl2 == null) {
                    printWriter2.println("ERROR: VersionedModelCache not registered");
                    return;
                }
                int currentVersion = modelCacheImpl2.getCurrentVersion(str6);
                StringBuilder sbF2 = e.f("Triggering switchVersion: ", str6, " v", currentVersion, " -> v");
                sbF2.append(numC02);
                printWriter2.println(sbF2.toString());
                printWriter2.println("  newPath = ".concat(str8));
                try {
                    modelCacheImpl2.switchVersion(str6, numC02.intValue(), str8, "manual_cli");
                    printWriter2.println("OK: switchVersion done");
                    printWriter2.println("  check .backup/<oldVer>/ for N-1 retention");
                    printWriter2.println("  ModelPathStore now points to: " + str8);
                    AIEngineLogger.i(LogModule.MODEL, this.f5927b, "Manual forceVersion: " + str6 + " v" + currentVersion + " -> v" + numC02 + " path=" + str8);
                    return;
                } catch (Exception e10) {
                    com.stepos.core.ota.d.r("ERROR: switchVersion failed: ", e10.getMessage(), printWriter2);
                    AIEngineLogger.e(LogModule.MODEL, this.f5927b, "Manual forceVersion failed", e10);
                    return;
                }
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "check")) {
                String str9 = (String) kotlin.collections.a.v0(kotlin.collections.a.r0(l.c0(strArr3, 1)));
                if (str9 == null || q.t0(str9)) {
                    printWriter2.println("usage: check <abilityId>");
                    printWriter2.println("  e.g. check stepos-privacy-guard");
                    return;
                }
                int iLocalCheckState = OtaDeepBinderServiceImpl.Companion.localCheckState(str9);
                switch (iLocalCheckState) {
                    case -2:
                        strG = "NO_ALGORITHM (-2)";
                        break;
                    case -1:
                        strG = "NO_PERMISSION (-1)";
                        break;
                    case 0:
                        strG = "NONE (0)";
                        break;
                    case 1:
                        strG = "OK (1)";
                        break;
                    case 2:
                        strG = "UPGRADING (2)";
                        break;
                    case 3:
                        strG = "DOWNLOADING (3)";
                        break;
                    case 4:
                        strG = "CHECKING (4)";
                        break;
                    case 5:
                        strG = "NEED_UPDATE (5)";
                        break;
                    case 6:
                        strG = "PREINSTALLING (6)";
                        break;
                    default:
                        strG = ai.onnxruntime.a.g(iLocalCheckState, "OTHER (", ")");
                        break;
                }
                String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str9);
                boolean zIsExtracting = PreInstallModels.INSTANCE.isExtracting(strResolveAnyToOta);
                String path = ModelPathStore.INSTANCE.getPath(str9);
                int versionCode = ModelsVersionStore.INSTANCE.getVersionCode(strResolveAnyToOta);
                printWriter2.println("checkResources(" + str9 + ") → " + strG);
                StringBuilder sb3 = new StringBuilder("  otaId         = ");
                sb3.append(strResolveAnyToOta);
                printWriter2.println(sb3.toString());
                printWriter2.println("  isExtracting  = " + zIsExtracting);
                printWriter2.println("  versionCode   = " + versionCode);
                printWriter2.println("  storedPath    = '" + path + "'");
                if (path.length() > 0) {
                    printWriter2.println("  pathExists    = " + new File(path).exists());
                    return;
                }
                return;
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "--scoring")) {
                a(printWriter2);
                return;
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "--preheat")) {
                com.stepos.aiengine.preheat.a.f5910o.getClass();
                com.stepos.aiengine.preheat.a aVar = com.stepos.aiengine.preheat.a.f5912q;
                if (aVar != null) {
                    aVar.a(printWriter2);
                    return;
                } else {
                    printWriter2.println("(preheat gate not assembled)");
                    return;
                }
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "keyattest")) {
                KeyAttestDumpCommand.INSTANCE.handle(kotlin.collections.a.r0(l.c0(strArr3, 1)), printWriter2);
                return;
            }
            if (g.b(strArr3 != null ? (String) l.e0(strArr3) : null, "inject")) {
                AsrStreamDebugInjector.INSTANCE.handleDumpArgs(kotlin.collections.a.r0(l.c0(strArr3, 1)), printWriter2);
                return;
            }
            LogDumpHelperKt.dumpAIEngineLogs(printWriter2, strArr3 == null ? new String[0] : strArr3);
            if (strArr3 == null) {
                strArr3 = new String[0];
            }
            ArrayList arrayListD0 = l.d0(strArr3);
            if (!arrayListD0.isEmpty()) {
                int size = arrayListD0.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayListD0.get(i11);
                    i11++;
                    String str10 = (String) obj;
                    if (g.b(str10, "--providers") || o.k0(str10, "--provider=", false) || str10.equals("--stats") || str10.equals("--perf") || str10.equals("--config") || str10.equals("--log") || str10.equals("--clear")) {
                        return;
                    }
                }
            }
            printWriter2.println();
            AtomicLong atomicLong = EngineMetrics.f6227b;
            StringBuilder sb4 = new StringBuilder();
            AtomicLong atomicLong2 = EngineMetrics.f6226a;
            long j10 = atomicLong2.get();
            if (j10 < 100) {
                healthStatus = EngineMetrics.HealthStatus.f6249a;
            } else {
                double d8 = atomicLong.get() / j10;
                healthStatus = d8 > 0.2d ? EngineMetrics.HealthStatus.f6251c : d8 > 0.05d ? EngineMetrics.HealthStatus.f6250b : EngineMetrics.HealthStatus.f6249a;
            }
            long j11 = atomicLong2.get();
            int iA0 = j11 != 0 ? h.a0((int) (100.0d - ((atomicLong.get() / j11) * 100)), 0, 100) : 100;
            sb4.append("===== EngineMetrics =====\n");
            sb4.append("  Status : " + healthStatus + "  (score=" + iA0 + ")");
            sb4.append('\n');
            long j12 = atomicLong2.get();
            StringBuilder sb5 = new StringBuilder("  total  : ");
            sb5.append(j12);
            sb4.append(sb5.toString());
            sb4.append('\n');
            sb4.append("  failed : " + atomicLong.get());
            sb4.append('\n');
            sb4.append("  active : " + EngineMetrics.f6228c.get());
            sb4.append('\n');
            sb4.append("  watchdogCancelled : " + EngineMetrics.f6240p.get());
            sb4.append('\n');
            sb4.append("  dropAfterCancelChars : " + EngineMetrics.f6241q.get());
            sb4.append('\n');
            Set<String> setKeySet = EngineMetrics.S.keySet();
            g.e(setKeySet, "<get-keys>(...)");
            TreeSet treeSet = new TreeSet();
            kotlin.collections.a.L0(setKeySet, treeSet);
            if (treeSet.isEmpty()) {
                sb4.append("  latency: (no data)\n");
            } else {
                Iterator it = treeSet.iterator();
                while (it.hasNext()) {
                    String str11 = (String) it.next();
                    AtomicLong atomicLong3 = EngineMetrics.f6226a;
                    g.c(str11);
                    long jB = EngineMetrics.b(50, str11);
                    long jB2 = EngineMetrics.b(90, str11);
                    Integer orDefault = EngineMetrics.U.getOrDefault(str11, 0);
                    g.e(orDefault, "getOrDefault(...)");
                    int iIntValue = orDefault.intValue();
                    StringBuilder sbL = com.stepos.core.ota.d.l("  [", jB, str11, "]  P50=");
                    a0.a.s(jB2, "ms  P90=", "ms  n=", sbL);
                    sbL.append(iIntValue);
                    sb4.append(sbL.toString());
                    sb4.append('\n');
                }
                lb.n nVar = lb.n.f10413a;
            }
            sb4.append("=========================");
            String string = sb4.toString();
            g.e(string, "toString(...)");
            printWriter2.println(string);
            printWriter2.println();
            printWriter2.println("----- Cloud Transport Config -----");
            try {
                CloudTransportConfig cloudTransportConfig = CloudConfigBootstrap.INSTANCE.get();
                printWriter2.println("  timeout      : connect=" + cloudTransportConfig.getTimeout().getConnectMs() + "ms read=" + cloudTransportConfig.getTimeout().getReadMs() + "ms write=" + cloudTransportConfig.getTimeout().getWriteMs() + "ms");
                try {
                    str2 = ")";
                    try {
                        printWriter2 = printWriter;
                        try {
                            printWriter2.println("  resilience   : reconnect base=" + cloudTransportConfig.getResilience().getReconnectBaseMs() + "ms rateLimited=" + cloudTransportConfig.getResilience().getReconnectRateLimitedBaseMs() + "ms cap=" + cloudTransportConfig.getResilience().getReconnectCapMs() + "ms maxAttempts=" + cloudTransportConfig.getResilience().getReconnectMaxAttempts() + " stable=" + cloudTransportConfig.getResilience().getReconnectStableSessionMs() + "ms | poll backoff=x" + cloudTransportConfig.getResilience().getPollBackoffFactor() + " cap=" + cloudTransportConfig.getResilience().getPollBackoffCapMs() + "ms netDownGrace=" + cloudTransportConfig.getResilience().getPollNetworkDownGraceMs() + "ms maxConsecFail=" + cloudTransportConfig.getResilience().getPollMaxConsecutiveFailures());
                            printWriter2.println("  backpressure : uplinkLimit=" + cloudTransportConfig.getBackpressure().getUplinkQueueLimitBytes() + "B downBuf=" + cloudTransportConfig.getBackpressure().getDownstreamBufferSize());
                            long idleTimeoutMs = cloudTransportConfig.getWatchdog().getIdleTimeoutMs();
                            long idleCheckMs = cloudTransportConfig.getWatchdog().getIdleCheckMs();
                            long finishGraceMs = cloudTransportConfig.getWatchdog().getFinishGraceMs();
                            long sessionOpenTimeoutMs = cloudTransportConfig.getWatchdog().getSessionOpenTimeoutMs();
                            long wsHandshakeTimeoutMs = cloudTransportConfig.getWatchdog().getWsHandshakeTimeoutMs();
                            long closeWaitOpenMs = cloudTransportConfig.getWatchdog().getCloseWaitOpenMs();
                            sb2 = new StringBuilder();
                            sb2.append("  watchdog     : idleTimeout=");
                            sb2.append(idleTimeoutMs);
                            sb2.append("ms check=");
                            sb2.append(idleCheckMs);
                            sb2.append("ms grace=");
                            sb2.append(finishGraceMs);
                            sb2.append("ms openTimeout=");
                            sb2.append(sessionOpenTimeoutMs);
                            sb2.append("ms handshakeTimeout=");
                            sb2.append(wsHandshakeTimeoutMs);
                            sb2.append("ms closeWaitOpen=");
                            sb2.append(closeWaitOpenMs);
                            str = "ms";
                        } catch (Exception e11) {
                            e = e11;
                            str = "ms";
                            String message = e.getMessage();
                            StringBuilder sb6 = new StringBuilder("  (cloud config unavailable: ");
                            sb6.append(message);
                            str3 = str2;
                            sb6.append(str3);
                            printWriter2.println(sb6.toString());
                            printWriter2.println();
                            printWriter2.println("----- Performance GlobalVerdict -----");
                            PerformanceOrchestratorImpl companion = PerformanceOrchestratorImpl.Companion.getInstance(this);
                            GlobalVerdict globalVerdictCachedVerdict = companion.cachedVerdict();
                            printWriter2.println("  backend      : " + globalVerdictCachedVerdict.getRecommendedBackend());
                            printWriter2.println("  constraint   : " + globalVerdictCachedVerdict.getBackendConstraint());
                            printWriter2.println("  maxConcurrent: " + globalVerdictCachedVerdict.getMaxConcurrent() + "  dspMax: " + globalVerdictCachedVerdict.getDspMaxConcurrent());
                            printWriter2.println("  idleTimeout  : " + globalVerdictCachedVerdict.getIdleTimeoutMs() + "ms  deferredRelease: " + globalVerdictCachedVerdict.getDeferredReleaseDelayMs() + str);
                            printWriter2.println("  thermal      : " + globalVerdictCachedVerdict.getThermalState() + "  battery: " + globalVerdictCachedVerdict.getBatteryLevel() + "%  charging: " + globalVerdictCachedVerdict.isCharging());
                            printWriter2.println("  isForeground : " + globalVerdictCachedVerdict.isForeground() + "  bgDuration: " + globalVerdictCachedVerdict.getBackgroundDurationMs() + str);
                            printWriter2.println("  cbThreshold  : " + globalVerdictCachedVerdict.getCbFailureThreshold() + "  cbReset: " + globalVerdictCachedVerdict.getCbResetTimeoutMs() + str);
                            Set<String> sealedFields = globalVerdictCachedVerdict.getSealedFields();
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("  sealedFields : ");
                            sb7.append(sealedFields);
                            printWriter2.println(sb7.toString());
                            printWriter2.println();
                            printWriter2.println("----- Performance Audit Log -----");
                            printWriter2.println(companion.dumpAuditLog());
                        }
                        try {
                            sb2.append(str);
                            printWriter2.println(sb2.toString());
                            str3 = str2;
                        } catch (Exception e12) {
                            e = e12;
                            String message2 = e.getMessage();
                            StringBuilder sb62 = new StringBuilder("  (cloud config unavailable: ");
                            sb62.append(message2);
                            str3 = str2;
                            sb62.append(str3);
                            printWriter2.println(sb62.toString());
                            printWriter2.println();
                            printWriter2.println("----- Performance GlobalVerdict -----");
                            PerformanceOrchestratorImpl companion2 = PerformanceOrchestratorImpl.Companion.getInstance(this);
                            GlobalVerdict globalVerdictCachedVerdict2 = companion2.cachedVerdict();
                            printWriter2.println("  backend      : " + globalVerdictCachedVerdict2.getRecommendedBackend());
                            printWriter2.println("  constraint   : " + globalVerdictCachedVerdict2.getBackendConstraint());
                            printWriter2.println("  maxConcurrent: " + globalVerdictCachedVerdict2.getMaxConcurrent() + "  dspMax: " + globalVerdictCachedVerdict2.getDspMaxConcurrent());
                            printWriter2.println("  idleTimeout  : " + globalVerdictCachedVerdict2.getIdleTimeoutMs() + "ms  deferredRelease: " + globalVerdictCachedVerdict2.getDeferredReleaseDelayMs() + str);
                            printWriter2.println("  thermal      : " + globalVerdictCachedVerdict2.getThermalState() + "  battery: " + globalVerdictCachedVerdict2.getBatteryLevel() + "%  charging: " + globalVerdictCachedVerdict2.isCharging());
                            printWriter2.println("  isForeground : " + globalVerdictCachedVerdict2.isForeground() + "  bgDuration: " + globalVerdictCachedVerdict2.getBackgroundDurationMs() + str);
                            printWriter2.println("  cbThreshold  : " + globalVerdictCachedVerdict2.getCbFailureThreshold() + "  cbReset: " + globalVerdictCachedVerdict2.getCbResetTimeoutMs() + str);
                            Set<String> sealedFields2 = globalVerdictCachedVerdict2.getSealedFields();
                            StringBuilder sb72 = new StringBuilder();
                            sb72.append("  sealedFields : ");
                            sb72.append(sealedFields2);
                            printWriter2.println(sb72.toString());
                            printWriter2.println();
                            printWriter2.println("----- Performance Audit Log -----");
                            printWriter2.println(companion2.dumpAuditLog());
                        }
                    } catch (Exception e13) {
                        e = e13;
                        printWriter2 = printWriter;
                    }
                } catch (Exception e14) {
                    e = e14;
                    printWriter2 = printWriter;
                    str2 = ")";
                }
            } catch (Exception e15) {
                e = e15;
                str = "ms";
                str2 = ")";
            }
            printWriter2.println();
            printWriter2.println("----- Performance GlobalVerdict -----");
            try {
                PerformanceOrchestratorImpl companion22 = PerformanceOrchestratorImpl.Companion.getInstance(this);
                GlobalVerdict globalVerdictCachedVerdict22 = companion22.cachedVerdict();
                printWriter2.println("  backend      : " + globalVerdictCachedVerdict22.getRecommendedBackend());
                printWriter2.println("  constraint   : " + globalVerdictCachedVerdict22.getBackendConstraint());
                printWriter2.println("  maxConcurrent: " + globalVerdictCachedVerdict22.getMaxConcurrent() + "  dspMax: " + globalVerdictCachedVerdict22.getDspMaxConcurrent());
                printWriter2.println("  idleTimeout  : " + globalVerdictCachedVerdict22.getIdleTimeoutMs() + "ms  deferredRelease: " + globalVerdictCachedVerdict22.getDeferredReleaseDelayMs() + str);
                printWriter2.println("  thermal      : " + globalVerdictCachedVerdict22.getThermalState() + "  battery: " + globalVerdictCachedVerdict22.getBatteryLevel() + "%  charging: " + globalVerdictCachedVerdict22.isCharging());
                printWriter2.println("  isForeground : " + globalVerdictCachedVerdict22.isForeground() + "  bgDuration: " + globalVerdictCachedVerdict22.getBackgroundDurationMs() + str);
                printWriter2.println("  cbThreshold  : " + globalVerdictCachedVerdict22.getCbFailureThreshold() + "  cbReset: " + globalVerdictCachedVerdict22.getCbResetTimeoutMs() + str);
                Set<String> sealedFields22 = globalVerdictCachedVerdict22.getSealedFields();
                StringBuilder sb722 = new StringBuilder();
                sb722.append("  sealedFields : ");
                sb722.append(sealedFields22);
                printWriter2.println(sb722.toString());
                printWriter2.println();
                printWriter2.println("----- Performance Audit Log -----");
                printWriter2.println(companion22.dumpAuditLog());
            } catch (Exception e16) {
                printWriter2.println("  (performance orchestrator not initialized: " + e16.getMessage() + str3);
            }
        }
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final IBinder onBind(Intent intent) {
        g.f(intent, "intent");
        super.onBind(intent);
        return null;
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onCreate() {
        super.onCreate();
        AIEngineLogger.i(LogModule.SERVICE, this.f5927b, "AIEngineManagerService onCreate");
        LogDumpHelper.registerProvider(new AbilityDumpProvider());
        LogDumpHelper.registerProvider(new ModelCacheDumpProvider());
        LogDumpHelper.registerProvider(new TelemetryDumpProvider());
        LogDumpHelper.registerProvider(new ExceptionDumpProvider());
        LogDumpHelper.registerProvider(new OtaDumpProvider());
        LogDumpHelper.registerProvider(new QnnDumpProvider());
        LogDumpHelper.registerProvider(new CloudConfigDumpProvider());
        AiPowerEventBus.INSTANCE.registerConsumer(new com.stepos.core.common.telemetry.b(29));
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        AIEngineLogger.i(LogModule.SERVICE, this.f5927b, "AIEngineManagerService onDestroy");
        AIEngineLogger.shutdown();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (i10 >= 15) {
            int iForceRecycleAll = AbilityManager.INSTANCE.forceRecycleAll();
            AIEngineLogger.w(LogModule.SERVICE, this.f5927b, "CRITICAL memory: recycled " + iForceRecycleAll + " DeepBinder instances");
        }
    }
}
