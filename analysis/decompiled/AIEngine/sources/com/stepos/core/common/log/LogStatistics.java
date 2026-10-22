package com.stepos.core.common.log;

import b6.e;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogStatistics {
    private final AtomicLong javaCount;
    private final Map<LogLevel, AtomicInteger> levelCounts;
    private final Map<LogModule, AtomicInteger> moduleCounts;
    private final AtomicLong nativeCount;
    private final AtomicLong totalCount;

    public LogStatistics() {
        this(null, null, null, null, null, 31, null);
    }

    private final Map<LogLevel, AtomicInteger> component2() {
        return this.levelCounts;
    }

    private final Map<LogModule, AtomicInteger> component3() {
        return this.moduleCounts;
    }

    public static /* synthetic */ LogStatistics copy$default(LogStatistics logStatistics, AtomicLong atomicLong, Map map, Map map2, AtomicLong atomicLong2, AtomicLong atomicLong3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            atomicLong = logStatistics.totalCount;
        }
        if ((i10 & 2) != 0) {
            map = logStatistics.levelCounts;
        }
        if ((i10 & 4) != 0) {
            map2 = logStatistics.moduleCounts;
        }
        if ((i10 & 8) != 0) {
            atomicLong2 = logStatistics.javaCount;
        }
        if ((i10 & 16) != 0) {
            atomicLong3 = logStatistics.nativeCount;
        }
        AtomicLong atomicLong4 = atomicLong3;
        Map map3 = map2;
        return logStatistics.copy(atomicLong, map, map3, atomicLong2, atomicLong4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$11(Map.Entry it) {
        g.f(it, "it");
        return ((LogModule) it.getKey()).getModuleTag() + "=" + ((AtomicInteger) it.getValue()).get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$9(Map.Entry it) {
        g.f(it, "it");
        return ((LogLevel) it.getKey()).name() + "=" + ((AtomicInteger) it.getValue()).get();
    }

    public final AtomicLong component1() {
        return this.totalCount;
    }

    public final AtomicLong component4() {
        return this.javaCount;
    }

    public final AtomicLong component5() {
        return this.nativeCount;
    }

    public final LogStatistics copy(AtomicLong totalCount, Map<LogLevel, AtomicInteger> levelCounts, Map<LogModule, AtomicInteger> moduleCounts, AtomicLong javaCount, AtomicLong nativeCount) {
        g.f(totalCount, "totalCount");
        g.f(levelCounts, "levelCounts");
        g.f(moduleCounts, "moduleCounts");
        g.f(javaCount, "javaCount");
        g.f(nativeCount, "nativeCount");
        return new LogStatistics(totalCount, levelCounts, moduleCounts, javaCount, nativeCount);
    }

    public final void dump(PrintWriter writer) {
        g.f(writer, "writer");
        writer.println("----- Log Statistics -----");
        writer.println("  Total Entries: " + this.totalCount.get());
        writer.println("  By Level:");
        for (LogLevel logLevel : LogLevel.getEntries()) {
            int levelCount = getLevelCount(logLevel);
            if (levelCount > 0) {
                writer.println("    " + logLevel.name() + ": " + levelCount);
            }
        }
        writer.println("  By Module:");
        for (LogModule logModule : LogModule.getEntries()) {
            int moduleCount = getModuleCount(logModule);
            if (moduleCount > 0) {
                writer.println("    " + logModule.getModuleTag() + ": " + moduleCount);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogStatistics)) {
            return false;
        }
        LogStatistics logStatistics = (LogStatistics) obj;
        return g.b(this.totalCount, logStatistics.totalCount) && g.b(this.levelCounts, logStatistics.levelCounts) && g.b(this.moduleCounts, logStatistics.moduleCounts) && g.b(this.javaCount, logStatistics.javaCount) && g.b(this.nativeCount, logStatistics.nativeCount);
    }

    public final String format() {
        StringBuilder sb2 = new StringBuilder("----- Log Statistics -----\n");
        sb2.append("  Total Entries: " + this.totalCount.get());
        sb2.append('\n');
        long j10 = this.javaCount.get();
        long j11 = this.nativeCount.get();
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "  Java: ", ", Native: ");
        sbQ.append(j11);
        sb2.append(sbQ.toString());
        sb2.append("\n\n  By Level:\n");
        for (LogLevel logLevel : LogLevel.getEntries()) {
            int levelCount = getLevelCount(logLevel);
            if (levelCount > 0) {
                sb2.append("    " + logLevel.name() + ": " + levelCount);
                sb2.append('\n');
            }
        }
        sb2.append("\n  By Module:\n");
        for (LogModule logModule : LogModule.getEntries()) {
            int moduleCount = getModuleCount(logModule);
            if (moduleCount > 0) {
                sb2.append("    " + logModule.getModuleTag() + ": " + moduleCount);
                sb2.append('\n');
            }
        }
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final int getErrorCount() {
        return getLevelCount(LogLevel.ERROR);
    }

    public final AtomicLong getJavaCount() {
        return this.javaCount;
    }

    public final int getLevelCount(LogLevel level) {
        g.f(level, "level");
        AtomicInteger atomicInteger = this.levelCounts.get(level);
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public final int getModuleCount(LogModule module) {
        g.f(module, "module");
        AtomicInteger atomicInteger = this.moduleCounts.get(module);
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public final AtomicLong getNativeCount() {
        return this.nativeCount;
    }

    public final AtomicLong getTotalCount() {
        return this.totalCount;
    }

    public final int getWarnCount() {
        return getLevelCount(LogLevel.WARN);
    }

    public int hashCode() {
        return this.nativeCount.hashCode() + ((this.javaCount.hashCode() + ((this.moduleCounts.hashCode() + ((this.levelCounts.hashCode() + (this.totalCount.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final void reset() {
        this.totalCount.set(0L);
        Iterator<T> it = this.levelCounts.values().iterator();
        while (it.hasNext()) {
            ((AtomicInteger) it.next()).set(0);
        }
        Iterator<T> it2 = this.moduleCounts.values().iterator();
        while (it2.hasNext()) {
            ((AtomicInteger) it2.next()).set(0);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LogStatistics(total=" + this.totalCount);
        sb2.append(", levels={");
        Set<Map.Entry<LogLevel, AtomicInteger>> setEntrySet = this.levelCounts.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((AtomicInteger) ((Map.Entry) obj).getValue()).get() > 0) {
                arrayList.add(obj);
            }
        }
        kotlin.collections.a.y0(arrayList, sb2, null, new e(28), 62);
        sb2.append("}");
        sb2.append(", modules={");
        Set<Map.Entry<LogModule, AtomicInteger>> setEntrySet2 = this.moduleCounts.entrySet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setEntrySet2) {
            if (((AtomicInteger) ((Map.Entry) obj2).getValue()).get() > 0) {
                arrayList2.add(obj2);
            }
        }
        kotlin.collections.a.y0(arrayList2, sb2, null, new com.stepos.core.common.cloud.d(2), 62);
        sb2.append("})");
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final void updateLevelCount(LogLevel level) {
        g.f(level, "level");
        AtomicInteger atomicInteger = this.levelCounts.get(level);
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
        }
    }

    public final void updateModuleCount(LogModule module) {
        g.f(module, "module");
        AtomicInteger atomicInteger = this.moduleCounts.get(module);
        if (atomicInteger != null) {
            atomicInteger.incrementAndGet();
        }
    }

    public LogStatistics(AtomicLong totalCount, Map<LogLevel, AtomicInteger> levelCounts, Map<LogModule, AtomicInteger> moduleCounts, AtomicLong javaCount, AtomicLong nativeCount) {
        g.f(totalCount, "totalCount");
        g.f(levelCounts, "levelCounts");
        g.f(moduleCounts, "moduleCounts");
        g.f(javaCount, "javaCount");
        g.f(nativeCount, "nativeCount");
        this.totalCount = totalCount;
        this.levelCounts = levelCounts;
        this.moduleCounts = moduleCounts;
        this.javaCount = javaCount;
        this.nativeCount = nativeCount;
        Iterator<LogLevel> it = LogLevel.getEntries().iterator();
        while (it.hasNext()) {
            this.levelCounts.put(it.next(), new AtomicInteger(0));
        }
        Iterator<LogModule> it2 = LogModule.getEntries().iterator();
        while (it2.hasNext()) {
            this.moduleCounts.put(it2.next(), new AtomicInteger(0));
        }
    }

    public final LogStatistics copy() {
        LogStatistics logStatistics = new LogStatistics(null, null, null, null, null, 31, null);
        logStatistics.totalCount.set(this.totalCount.get());
        for (Map.Entry<LogLevel, AtomicInteger> entry : this.levelCounts.entrySet()) {
            LogLevel key = entry.getKey();
            AtomicInteger value = entry.getValue();
            AtomicInteger atomicInteger = logStatistics.levelCounts.get(key);
            if (atomicInteger != null) {
                atomicInteger.set(value.get());
            }
        }
        for (Map.Entry<LogModule, AtomicInteger> entry2 : this.moduleCounts.entrySet()) {
            LogModule key2 = entry2.getKey();
            AtomicInteger value2 = entry2.getValue();
            AtomicInteger atomicInteger2 = logStatistics.moduleCounts.get(key2);
            if (atomicInteger2 != null) {
                atomicInteger2.set(value2.get());
            }
        }
        return logStatistics;
    }

    public /* synthetic */ LogStatistics(AtomicLong atomicLong, Map map, Map map2, AtomicLong atomicLong2, AtomicLong atomicLong3, int i10, kotlin.jvm.internal.e eVar) {
        this((i10 & 1) != 0 ? new AtomicLong(0L) : atomicLong, (i10 & 2) != 0 ? new LinkedHashMap() : map, (i10 & 4) != 0 ? new LinkedHashMap() : map2, (i10 & 8) != 0 ? new AtomicLong(0L) : atomicLong2, (i10 & 16) != 0 ? new AtomicLong(0L) : atomicLong3);
    }
}
