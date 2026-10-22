package com.stepos.core.common.log;

import gc.k;
import gc.o;
import gc.q;
import gc.r;
import h0.e;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogDumpHelper {
    public static final LogDumpHelper INSTANCE = new LogDumpHelper();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
    private static final ConcurrentHashMap<String, IDumpProvider> providers = new ConcurrentHashMap<>();

    private LogDumpHelper() {
    }

    private final String buildFilterInfo(String[] strArr) {
        String str;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            str = null;
            if (i10 >= length) {
                str2 = null;
                break;
            }
            str2 = strArr[i10];
            if (o.k0(str2, "--module=", false)) {
                break;
            }
            i10++;
        }
        if (str2 != null) {
            arrayList.add("module=".concat(q.G0(str2, "=")));
        }
        int length2 = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length2) {
                str3 = null;
                break;
            }
            str3 = strArr[i11];
            if (o.k0(str3, "--level=", false)) {
                break;
            }
            i11++;
        }
        if (str3 != null) {
            arrayList.add("level>=".concat(q.G0(str3, "=")));
        }
        int length3 = strArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length3) {
                break;
            }
            String str4 = strArr[i12];
            if (o.k0(str4, "--last=", false)) {
                str = str4;
                break;
            }
            i12++;
        }
        if (str != null) {
            arrayList.add("last " + q.G0(str, "=") + " entries");
        }
        if (l.a0("--native-only", strArr)) {
            arrayList.add("native only");
        } else if (l.a0("--java-only", strArr)) {
            arrayList.add("java only");
        }
        return kotlin.collections.a.z0(arrayList, ", ", null, null, null, 62);
    }

    private final void clearLogs(PrintWriter printWriter) {
        AIEngineLogger.clear();
        printWriter.println("Log buffer cleared.");
    }

    public static final void dump(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        LogcatTeeWriter logcatTeeWriter = l.a0("--tolog", args) ? new LogcatTeeWriter(writer, null, 2, null) : null;
        if (logcatTeeWriter != null) {
            writer = logcatTeeWriter;
        }
        if (l.a0("--help", args) || l.a0("-h", args)) {
            INSTANCE.dumpHelp(writer);
        } else if (l.a0("--log", args)) {
            INSTANCE.dumpLogs(writer, args);
        } else if (l.a0("--stats", args)) {
            INSTANCE.dumpStats(writer);
        } else if (l.a0("--perf", args)) {
            INSTANCE.dumpPerformance(writer);
        } else if (l.a0("--config", args)) {
            INSTANCE.dumpConfig(writer);
        } else if (!l.a0("--clear", args)) {
            if (l.a0("--providers", args)) {
                INSTANCE.dumpProviders(writer, args);
                break;
            }
            for (String str : args) {
                if (o.k0(str, "--provider=", false)) {
                    INSTANCE.dumpProviders(writer, args);
                    break;
                }
            }
            INSTANCE.dumpDefault(writer, args);
        } else {
            INSTANCE.clearLogs(writer);
        }
        if (logcatTeeWriter != null) {
            logcatTeeWriter.flushRemaining();
        }
    }

    private final void dumpConfig(PrintWriter printWriter) {
        printWriter.println("================= AIEngine Log Config =================");
        printWriter.println(LogConfig.getSummary());
        printWriter.println("========================================================");
    }

    private final void dumpDefault(PrintWriter printWriter, String[] strArr) {
        printWriter.println("================= AIEngine Manager Service =================");
        printWriter.println("Time: " + dateFormat.format(new Date()));
        printWriter.println();
        LogStatistics statistics = AIEngineLogger.getStatistics();
        printWriter.println("Log Buffer: " + statistics.getTotalCount() + " entries");
        printWriter.println("  Errors: " + statistics.getErrorCount() + ", Warnings: " + statistics.getWarnCount());
        printWriter.println();
        ConcurrentHashMap<String, IDumpProvider> concurrentHashMap = providers;
        if (!concurrentHashMap.isEmpty()) {
            printWriter.println("----- Registered Modules -----");
            Iterator<Map.Entry<String, IDumpProvider>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                IDumpProvider value = it.next().getValue();
                try {
                    value.dump(printWriter, strArr);
                } catch (Exception e10) {
                    printWriter.println("Error dumping " + value.getModuleName() + ": " + e10.getMessage());
                }
            }
        }
        printWriter.println();
        printWriter.println("Use --help for more options.");
        printWriter.println("=============================================================");
    }

    private final void dumpHelp(PrintWriter printWriter) {
        printWriter.println(k.a0("\n            |================= AIEngine Log System Help =================\n            |\n            |Usage: dumpsys activity service com.stepos.aiengine/.service.AIEngineManagerService [options]\n            |\n            |Options:\n            |  --help, -h              显示帮助信息\n            |  --log                   打印缓存的日志 (默认显示所有日志)\n            |    --module=<modules>    按模块过滤 (如: Service,Model,Inference)\n            |    --level=<level>       按级别过滤 (VERBOSE/DEBUG/INFO/WARN/ERROR)\n            |    --last=<count>        只显示最近 N 条\n            |    --java-only           仅显示 Java 层日志\n            |    --native-only         仅显示 Native 层日志\n            |  --stats                 显示日志统计信息\n            |  --perf                  显示性能统计数据\n            |  --config                显示当前配置\n            |  --clear                 清除日志缓存\n            |  --providers             显示注册的 Dump 提供者\n            |    --provider=<name>     指定提供者进行 dump\n            |\n            |Available Modules:\n            |  " + kotlin.collections.a.z0(LogModule.getEntries(), ", ", null, null, new com.stepos.core.common.cloud.d(1), 30) + "\n            |\n            |Examples:\n            |  dumpsys activity service com.stepos.aiengine/.service.AIEngineManagerService --log\n            |  dumpsys activity service com.stepos.aiengine/.service.AIEngineManagerService --log --module=Inference --last=50\n            |  dumpsys activity service com.stepos.aiengine/.service.AIEngineManagerService --log --level=ERROR\n            |  dumpsys activity service com.stepos.aiengine/.service.AIEngineManagerService --stats\n            |\n            |=============================================================\n        "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpHelp$lambda$1(LogModule it) {
        g.f(it, "it");
        return it.getModuleTag();
    }

    private final void dumpLogs(PrintWriter printWriter, String[] strArr) {
        LogStatistics statistics = AIEngineLogger.getStatistics();
        printWriter.println("================= AIEngine Log Dump =================");
        printWriter.println("Time: " + dateFormat.format(new Date()));
        printWriter.println("Total Entries: " + statistics.getTotalCount() + " (Java: " + statistics.getJavaCount() + ", Native: " + statistics.getNativeCount() + ")");
        String strBuildFilterInfo = buildFilterInfo(strArr);
        if (!q.t0(strBuildFilterInfo)) {
            com.stepos.core.ota.d.r("Filter: ", strBuildFilterInfo, printWriter);
        }
        printWriter.println();
        printWriter.println("----- Log Entries -----");
        AIEngineLogger.dumpAllLogs(printWriter, strArr);
        printWriter.println();
        printWriter.println("=======================================================");
    }

    private final void dumpPerformance(PrintWriter printWriter) {
        printWriter.println("================= AIEngine Performance Stats =================");
        printWriter.println("Time: " + dateFormat.format(new Date()));
        printWriter.println();
        Map<String, PerfStatistic> perfStats = AIEngineLogger.getPerfStats();
        if (perfStats.isEmpty()) {
            printWriter.println("No performance data available.");
        } else {
            printWriter.println("Operation               | Count  | Avg (ms) | Min (ms) | Max (ms)");
            printWriter.println("------------------------|--------|----------|----------|----------");
            for (Map.Entry<String, PerfStatistic> entry : perfStats.entrySet()) {
                printWriter.println(String.format("%-23s | %6d | %8.2f | %8.2f | %8.2f", Arrays.copyOf(new Object[]{r.R0(23, entry.getKey()), entry.getValue().toString()}, 2)));
            }
        }
        printWriter.println();
        printWriter.println("================================================================");
    }

    private final void dumpProviders(PrintWriter printWriter, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (String str : strArr) {
            if (o.k0(str, "--provider=", false)) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            mb.q.g0(arrayList2, q.D0(q.G0((String) obj, "="), new String[]{","}, 6));
        }
        ArrayList arrayList3 = new ArrayList(m.Z(arrayList2, 10));
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            arrayList3.add(q.L0((String) obj2).toString());
        }
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        int i13 = 0;
        while (i13 < size3) {
            Object obj3 = arrayList3.get(i13);
            i13++;
            if (((String) obj3).length() > 0) {
                arrayList4.add(obj3);
            }
        }
        if (arrayList4.isEmpty()) {
            printWriter.println("================= Registered Dump Providers =================");
            ConcurrentHashMap<String, IDumpProvider> concurrentHashMap = providers;
            if (concurrentHashMap.isEmpty()) {
                printWriter.println("No providers registered.");
            } else {
                for (Map.Entry<String, IDumpProvider> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    IDumpProvider value = entry.getValue();
                    printWriter.println(e.c("- ", key, " (", value.getLogModule().getModuleTag(), ")"));
                    com.stepos.core.ota.d.r("  ", value.getHelp(), printWriter);
                }
            }
            printWriter.println("==============================================================");
            return;
        }
        int size4 = arrayList4.size();
        while (i10 < size4) {
            Object obj4 = arrayList4.get(i10);
            i10++;
            String str2 = (String) obj4;
            ConcurrentHashMap<String, IDumpProvider> concurrentHashMap2 = providers;
            IDumpProvider iDumpProvider = concurrentHashMap2.get(str2);
            if (iDumpProvider != null) {
                iDumpProvider.dump(printWriter, strArr);
                printWriter.println();
            } else {
                printWriter.println("Provider not found: " + str2);
                Set<String> setKeySet = concurrentHashMap2.keySet();
                g.e(setKeySet, "<get-keys>(...)");
                com.stepos.core.ota.d.r("Available providers: ", kotlin.collections.a.z0(setKeySet, null, null, null, null, 63), printWriter);
            }
        }
    }

    private final void dumpStats(PrintWriter printWriter) {
        printWriter.println("================= AIEngine Log Statistics =================");
        printWriter.println("Time: " + dateFormat.format(new Date()));
        printWriter.println();
        printWriter.println(AIEngineLogger.getStatistics().format());
        printWriter.println();
        printWriter.println("=============================================================");
    }

    public static final Map<String, IDumpProvider> getProviders() {
        return kotlin.collections.b.n0(providers);
    }

    public static final void registerProvider(IDumpProvider provider) {
        g.f(provider, "provider");
        providers.put(provider.getModuleName(), provider);
    }

    public static final void unregisterProvider(String moduleName) {
        g.f(moduleName, "moduleName");
        providers.remove(moduleName);
    }
}
