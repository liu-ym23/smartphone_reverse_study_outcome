package com.stepos.core.common.log;

import android.os.Trace;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.telemetry.FailStage;
import gc.o;
import gc.r;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TraceContext {
    private static final String TAG = "TraceContext";
    public static final TraceContext INSTANCE = new TraceContext();
    private static final ThreadLocal<TraceInfo> currentContext = new ThreadLocal<>();
    private static final ConcurrentHashMap<String, TraceInfo> activeTraces = new ConcurrentHashMap<>();
    private static final AtomicLong spanCounter = new AtomicLong(0);
    private static final ConcurrentHashMap<String, TraceStatistic> traceStats = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SpanBuilder {
        private Map<String, Object> attributes;
        private final LogModule module;
        private final String operationName;
        private String parentSpanId;
        private String traceId;

        public SpanBuilder(String operationName, LogModule module) {
            g.f(operationName, "operationName");
            g.f(module, "module");
            this.operationName = operationName;
            this.module = module;
            this.attributes = new LinkedHashMap();
        }

        public final SpanBuilder asChildOf(TraceInfo traceInfo) {
            if (traceInfo != null) {
                this.traceId = traceInfo.getTraceId();
                this.parentSpanId = traceInfo.getSpanId();
            }
            return this;
        }

        public final TraceInfo start() {
            String spanId;
            Thread threadCurrentThread = Thread.currentThread();
            TraceInfo traceInfo = (TraceInfo) TraceContext.currentContext.get();
            String traceId = this.traceId;
            if (traceId == null) {
                traceId = traceInfo != null ? traceInfo.getTraceId() : null;
                if (traceId == null) {
                    traceId = TraceContext.INSTANCE.generateTraceId();
                }
            }
            String str = traceId;
            String str2 = this.parentSpanId;
            if (str2 == null) {
                spanId = traceInfo != null ? traceInfo.getSpanId() : null;
            } else {
                spanId = str2;
            }
            String strGenerateSpanId = TraceContext.INSTANCE.generateSpanId();
            String str3 = this.operationName;
            LogModule logModule = this.module;
            long jNanoTime = System.nanoTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long id2 = threadCurrentThread.getId();
            String name = threadCurrentThread.getName();
            g.e(name, "getName(...)");
            TraceInfo traceInfo2 = new TraceInfo(str, strGenerateSpanId, spanId, str3, logModule, jNanoTime, jCurrentTimeMillis, id2, name, this.attributes, 0L, null, null, 7168, null);
            TraceContext.currentContext.set(traceInfo2);
            TraceContext.activeTraces.put(traceInfo2.getTraceId() + "_" + traceInfo2.getSpanId(), traceInfo2);
            if (LogConfig.getEnableSystrace()) {
                Trace.beginSection(this.module.getModuleTag() + ":" + this.operationName);
            }
            if (LogConfig.getEnableTraceLog()) {
                LogModule logModule2 = this.module;
                String traceId2 = traceInfo2.getTraceId();
                if (spanId == null) {
                    spanId = "null";
                }
                AIEngineLogger.d(logModule2, "TRACE", ai.onnxruntime.a.p(ai.onnxruntime.a.s("[START] traceId=", traceId2, ", spanId=", strGenerateSpanId, ", parent="), spanId, ", op=", this.operationName));
            }
            return traceInfo2;
        }

        public final SpanBuilder withAttribute(String key, Object value) {
            g.f(key, "key");
            g.f(value, "value");
            this.attributes.put(key, value);
            return this;
        }

        public final SpanBuilder withAttributes(Map<String, ? extends Object> attrs) {
            g.f(attrs, "attrs");
            this.attributes.putAll(attrs);
            return this;
        }

        public final SpanBuilder withParent(String parentSpanId) {
            g.f(parentSpanId, "parentSpanId");
            this.parentSpanId = parentSpanId;
            return this;
        }

        public final SpanBuilder withTraceId(String traceId) {
            g.f(traceId, "traceId");
            this.traceId = traceId;
            return this;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TraceStatus {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ TraceStatus[] $VALUES;
        public static final TraceStatus RUNNING = new TraceStatus("RUNNING", 0);
        public static final TraceStatus SUCCESS = new TraceStatus("SUCCESS", 1);
        public static final TraceStatus FAILED = new TraceStatus("FAILED", 2);
        public static final TraceStatus CANCELLED = new TraceStatus("CANCELLED", 3);

        private static final /* synthetic */ TraceStatus[] $values() {
            return new TraceStatus[]{RUNNING, SUCCESS, FAILED, CANCELLED};
        }

        static {
            TraceStatus[] traceStatusArr$values = $values();
            $VALUES = traceStatusArr$values;
            $ENTRIES = kotlin.enums.a.a(traceStatusArr$values);
        }

        private TraceStatus(String str, int i10) {
        }

        public static sb.a<TraceStatus> getEntries() {
            return $ENTRIES;
        }

        public static TraceStatus valueOf(String str) {
            return (TraceStatus) Enum.valueOf(TraceStatus.class, str);
        }

        public static TraceStatus[] values() {
            return (TraceStatus[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TraceStatus.values().length];
            try {
                iArr[TraceStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TraceStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TraceStatus.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TraceContext() {
    }

    public static final void addAttribute(String key, Object value) {
        Map<String, Object> attributes;
        g.f(key, "key");
        g.f(value, "value");
        TraceInfo traceInfo = currentContext.get();
        if (traceInfo == null || (attributes = traceInfo.getAttributes()) == null) {
            return;
        }
        attributes.put(key, value);
    }

    public static final void addEvent(String name, Map<String, ? extends Object> map) {
        String strZ0;
        Set<Map.Entry<String, ? extends Object>> setEntrySet;
        g.f(name, "name");
        TraceInfo traceInfo = currentContext.get();
        if (traceInfo != null && LogConfig.getEnableTraceLog()) {
            if (map == null || (setEntrySet = map.entrySet()) == null || (strZ0 = kotlin.collections.a.z0(setEntrySet, ", ", null, null, new com.stepos.core.common.cloud.d(3), 30)) == null) {
                strZ0 = "";
            }
            LogModule module = traceInfo.getModule();
            String traceId = traceInfo.getTraceId();
            String spanId = traceInfo.getSpanId();
            String strConcat = strZ0.length() > 0 ? ", ".concat(strZ0) : "";
            StringBuilder sbS = ai.onnxruntime.a.s("[EVENT] traceId=", traceId, ", spanId=", spanId, ", event=");
            sbS.append(name);
            sbS.append(strConcat);
            AIEngineLogger.d(module, "TRACE", sbS.toString());
        }
    }

    public static /* synthetic */ void addEvent$default(String str, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = null;
        }
        addEvent(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence addEvent$lambda$2(Map.Entry it) {
        g.f(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    public static final void cancelSpan(TraceInfo traceInfo) {
        g.f(traceInfo, "traceInfo");
        endSpan(traceInfo, TraceStatus.CANCELLED, null);
    }

    public static final void clearCurrent() {
        currentContext.remove();
    }

    public static final void clearStats() {
        traceStats.clear();
    }

    public static final TraceInfo current() {
        return currentContext.get();
    }

    public static final String currentSpanId() {
        TraceInfo traceInfo = currentContext.get();
        if (traceInfo != null) {
            return traceInfo.getSpanId();
        }
        return null;
    }

    public static final String currentTraceId() {
        TraceInfo traceInfo = currentContext.get();
        if (traceInfo != null) {
            return traceInfo.getTraceId();
        }
        return null;
    }

    public static final void dump(PrintWriter writer) {
        String str;
        g.f(writer, "writer");
        writer.println("----- Trace Statistics -----");
        Collection<TraceStatistic> collectionValues = traceStats.values();
        g.e(collectionValues, "<get-values>(...)");
        List<TraceStatistic> listI0 = kotlin.collections.a.I0(collectionValues, new Comparator() { // from class: com.stepos.core.common.log.TraceContext$dump$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                return ob.b.a(Long.valueOf(((TraceStatistic) t10).getTotalCount()), Long.valueOf(((TraceStatistic) t8).getTotalCount()));
            }
        });
        if (listI0.isEmpty()) {
            writer.println("  No trace statistics available");
        } else {
            writer.println(String.format("  %-30s %8s %10s %10s %10s %10s", Arrays.copyOf(new Object[]{"Operation", "Count", "Avg(ms)", "Min(ms)", "Max(ms)", "Fail%"}, 6)));
            int i10 = 1;
            int length = "-".length();
            if (length == 0) {
                str = "";
            } else if (length != 1) {
                StringBuilder sb2 = new StringBuilder("-".length() * 80);
                while (true) {
                    sb2.append((CharSequence) "-");
                    if (i10 == 80) {
                        break;
                    } else {
                        i10++;
                    }
                }
                str = sb2.toString();
                g.c(str);
            } else {
                char cCharAt = "-".charAt(0);
                char[] cArr = new char[80];
                for (int i11 = 0; i11 < 80; i11++) {
                    cArr[i11] = cCharAt;
                }
                str = new String(cArr);
            }
            writer.println("  " + str);
            for (TraceStatistic traceStatistic : listI0) {
                double failCount = traceStatistic.getTotalCount() > 0 ? (traceStatistic.getFailCount() / traceStatistic.getTotalCount()) * 100 : 0.0d;
                writer.println(String.format("  %-30s %8d %10.2f %10.2f %10.2f %9.1f%%", Arrays.copyOf(new Object[]{r.R0(30, traceStatistic.getModule() + ":" + traceStatistic.getOperation()), Long.valueOf(traceStatistic.getTotalCount()), Double.valueOf(traceStatistic.getAvgDurationMs()), Double.valueOf(traceStatistic.getMinDurationMs()), Double.valueOf(traceStatistic.getMaxDurationMs()), Double.valueOf(failCount)}, 6)));
            }
        }
        writer.println();
        writer.println("----- Active Traces -----");
        Collection<TraceInfo> collectionValues2 = activeTraces.values();
        g.e(collectionValues2, "<get-values>(...)");
        List<TraceInfo> listO0 = kotlin.collections.a.O0(collectionValues2);
        if (listO0.isEmpty()) {
            writer.println("  No active traces");
            return;
        }
        for (TraceInfo traceInfo : listO0) {
            String traceId = traceInfo.getTraceId();
            String moduleTag = traceInfo.getModule().getModuleTag();
            String operationName = traceInfo.getOperationName();
            StringBuilder sbS = ai.onnxruntime.a.s("  [", traceId, "] ", moduleTag, ":");
            sbS.append(operationName);
            writer.println(sbS.toString());
            String spanId = traceInfo.getSpanId();
            String parentSpanId = traceInfo.getParentSpanId();
            if (parentSpanId == null) {
                parentSpanId = "null";
            }
            writer.println("    spanId=" + spanId + ", parent=" + parentSpanId);
            writer.println("    thread=" + traceInfo.getThreadName() + ", running=" + traceInfo.getDurationMs() + "ms");
        }
    }

    public static final void endSpan(TraceInfo traceInfo, TraceStatus status, String str) {
        g.f(traceInfo, "traceInfo");
        g.f(status, "status");
        traceInfo.setEndTime(System.nanoTime());
        traceInfo.setStatus(status);
        traceInfo.setErrorMessage(str);
        if (LogConfig.getEnableSystrace()) {
            Trace.endSection();
        }
        INSTANCE.updateStats(traceInfo);
        if (LogConfig.getEnableTraceLog()) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            String str2 = i10 != 1 ? i10 != 2 ? i10 != 3 ? FailStage.UNKNOWN : "CANCELLED" : "FAILED" : "SUCCESS";
            String strConcat = str != null ? ", error=".concat(str) : "";
            LogModule module = traceInfo.getModule();
            String traceId = traceInfo.getTraceId();
            String spanId = traceInfo.getSpanId();
            String operationName = traceInfo.getOperationName();
            String str3 = String.format(ai.onnxruntime.a.k("duration=%.2fms", strConcat), Arrays.copyOf(new Object[]{Double.valueOf(traceInfo.getDurationMs())}, 1));
            StringBuilder sbS = ai.onnxruntime.a.s("[END] traceId=", traceId, ", spanId=", spanId, ", op=");
            ai.onnxruntime.a.z(sbS, operationName, ", status=", str2, ", ");
            sbS.append(str3);
            AIEngineLogger.d(module, "TRACE", sbS.toString());
        }
        ConcurrentHashMap<String, TraceInfo> concurrentHashMap = activeTraces;
        concurrentHashMap.remove(traceInfo.getTraceId() + "_" + traceInfo.getSpanId());
        String parentSpanId = traceInfo.getParentSpanId();
        String strI = parentSpanId != null ? com.stepos.core.ota.d.i(traceInfo.getTraceId(), "_", parentSpanId) : null;
        currentContext.set(strI != null ? concurrentHashMap.get(strI) : null);
    }

    public static /* synthetic */ void endSpan$default(TraceInfo traceInfo, TraceStatus traceStatus, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            traceStatus = TraceStatus.SUCCESS;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        endSpan(traceInfo, traceStatus, str);
    }

    public static final void failSpan(TraceInfo traceInfo, String errorMessage) {
        g.f(traceInfo, "traceInfo");
        g.f(errorMessage, "errorMessage");
        endSpan(traceInfo, TraceStatus.FAILED, errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateSpanId() {
        return String.format("%016x", Arrays.copyOf(new Object[]{Long.valueOf(spanCounter.incrementAndGet())}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateTraceId() {
        String string = UUID.randomUUID().toString();
        g.e(string, "toString(...)");
        return r.R0(16, o.i0(string, "-", ""));
    }

    public static final List<TraceInfo> getActiveTraces() {
        Collection<TraceInfo> collectionValues = activeTraces.values();
        g.e(collectionValues, "<get-values>(...)");
        return kotlin.collections.a.O0(collectionValues);
    }

    public static final Map<String, TraceStatistic> getStats() {
        return kotlin.collections.b.n0(traceStats);
    }

    public static final SpanBuilder newSpan(String operationName, LogModule module) {
        g.f(operationName, "operationName");
        g.f(module, "module");
        return new SpanBuilder(operationName, module);
    }

    public static final void setCurrent(TraceInfo traceInfo) {
        currentContext.set(traceInfo);
    }

    public static final TraceInfo startSpan(String operationName, LogModule module) {
        g.f(operationName, "operationName");
        g.f(module, "module");
        return new SpanBuilder(operationName, module).start();
    }

    public static final <T> T trace(String operationName, LogModule module, l<? super TraceInfo, ? extends T> block) throws Exception {
        g.f(operationName, "operationName");
        g.f(module, "module");
        g.f(block, "block");
        TraceInfo traceInfoStartSpan = startSpan(operationName, module);
        try {
            T tInvoke = block.invoke(traceInfoStartSpan);
            endSpan$default(traceInfoStartSpan, TraceStatus.SUCCESS, null, 4, null);
            return tInvoke;
        } catch (Exception e10) {
            String message = e10.getMessage();
            if (message == null) {
                message = e10.getClass().getSimpleName();
            }
            failSpan(traceInfoStartSpan, message);
            throw e10;
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    public static final <T> T traceWithResult(String operationName, LogModule module, l<? super T, Boolean> isSuccess, l<? super TraceInfo, ? extends T> block) throws Exception {
        g.f(operationName, "operationName");
        g.f(module, "module");
        g.f(isSuccess, "isSuccess");
        g.f(block, "block");
        TraceInfo traceInfoStartSpan = startSpan(operationName, module);
        try {
            T tInvoke = block.invoke(traceInfoStartSpan);
            if (isSuccess.invoke(tInvoke).booleanValue()) {
                endSpan$default(traceInfoStartSpan, TraceStatus.SUCCESS, null, 4, null);
                return tInvoke;
            }
            endSpan(traceInfoStartSpan, TraceStatus.FAILED, "Result indicates failure");
            return tInvoke;
        } catch (Exception e10) {
            String message = e10.getMessage();
            if (message == null) {
                message = e10.getClass().getSimpleName();
            }
            failSpan(traceInfoStartSpan, message);
            throw e10;
        }
    }

    public static /* synthetic */ Object traceWithResult$default(String operationName, LogModule module, l isSuccess, l block, int i10, Object obj) throws Exception {
        if ((i10 & 4) != 0) {
            isSuccess = new l() { // from class: com.stepos.core.common.log.TraceContext.traceWithResult.1
                @Override // zb.l
                public final Boolean invoke(Object obj2) {
                    return Boolean.TRUE;
                }
            };
        }
        g.f(operationName, "operationName");
        g.f(module, "module");
        g.f(isSuccess, "isSuccess");
        g.f(block, "block");
        TraceInfo traceInfoStartSpan = startSpan(operationName, module);
        try {
            Object objInvoke = block.invoke(traceInfoStartSpan);
            if (((Boolean) isSuccess.invoke(objInvoke)).booleanValue()) {
                endSpan$default(traceInfoStartSpan, TraceStatus.SUCCESS, null, 4, null);
                return objInvoke;
            }
            endSpan(traceInfoStartSpan, TraceStatus.FAILED, "Result indicates failure");
            return objInvoke;
        } catch (Exception e10) {
            String message = e10.getMessage();
            if (message == null) {
                message = e10.getClass().getSimpleName();
            }
            failSpan(traceInfoStartSpan, message);
            throw e10;
        }
    }

    private final void updateStats(TraceInfo traceInfo) {
        traceStats.compute(com.stepos.core.ota.d.i(traceInfo.getModule().getModuleTag(), ":", traceInfo.getOperationName()), new c7.a(new b6.c(traceInfo, 3), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraceStatistic updateStats$lambda$10(p pVar, Object obj, Object obj2) {
        return (TraceStatistic) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraceStatistic updateStats$lambda$9(TraceInfo traceInfo, String str, TraceStatistic traceStatistic) {
        g.f(str, "<unused var>");
        if (traceStatistic == null) {
            traceStatistic = new TraceStatistic(traceInfo.getModule().getModuleTag(), traceInfo.getOperationName());
        }
        traceStatistic.add(traceInfo.getDurationMs(), traceInfo.getStatus() == TraceStatus.SUCCESS);
        return traceStatistic;
    }

    public static final Runnable wrapRunnable(Runnable runnable) {
        g.f(runnable, "runnable");
        return new androidx.appcompat.app.l(8, currentContext.get(), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wrapRunnable$lambda$4(TraceInfo traceInfo, Runnable runnable) {
        ThreadLocal<TraceInfo> threadLocal = currentContext;
        TraceInfo traceInfo2 = threadLocal.get();
        try {
            threadLocal.set(traceInfo);
            runnable.run();
            threadLocal.set(traceInfo2);
        } catch (Throwable th) {
            currentContext.set(traceInfo2);
            throw th;
        }
    }

    public static final <T> zb.a<T> wrapWithContext(zb.a<? extends T> block) {
        g.f(block, "block");
        return new cb.d(6, currentContext.get(), block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object wrapWithContext$lambda$3(TraceInfo traceInfo, zb.a aVar) {
        ThreadLocal<TraceInfo> threadLocal = currentContext;
        TraceInfo traceInfo2 = threadLocal.get();
        try {
            threadLocal.set(traceInfo);
            Object objInvoke = aVar.invoke();
            threadLocal.set(traceInfo2);
            return objInvoke;
        } catch (Throwable th) {
            currentContext.set(traceInfo2);
            throw th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TraceInfo {
        private final Map<String, Object> attributes;
        private long endTime;
        private String errorMessage;
        private final LogModule module;
        private final String operationName;
        private final String parentSpanId;
        private final String spanId;
        private final long startTime;
        private final long startTimeMillis;
        private TraceStatus status;
        private final long threadId;
        private final String threadName;
        private final String traceId;

        public TraceInfo(String traceId, String spanId, String str, String operationName, LogModule module, long j10, long j11, long j12, String threadName, Map<String, Object> attributes, long j13, TraceStatus status, String str2) {
            g.f(traceId, "traceId");
            g.f(spanId, "spanId");
            g.f(operationName, "operationName");
            g.f(module, "module");
            g.f(threadName, "threadName");
            g.f(attributes, "attributes");
            g.f(status, "status");
            this.traceId = traceId;
            this.spanId = spanId;
            this.parentSpanId = str;
            this.operationName = operationName;
            this.module = module;
            this.startTime = j10;
            this.startTimeMillis = j11;
            this.threadId = j12;
            this.threadName = threadName;
            this.attributes = attributes;
            this.endTime = j13;
            this.status = status;
            this.errorMessage = str2;
        }

        public final String component1() {
            return this.traceId;
        }

        public final Map<String, Object> component10() {
            return this.attributes;
        }

        public final long component11() {
            return this.endTime;
        }

        public final TraceStatus component12() {
            return this.status;
        }

        public final String component13() {
            return this.errorMessage;
        }

        public final String component2() {
            return this.spanId;
        }

        public final String component3() {
            return this.parentSpanId;
        }

        public final String component4() {
            return this.operationName;
        }

        public final LogModule component5() {
            return this.module;
        }

        public final long component6() {
            return this.startTime;
        }

        public final long component7() {
            return this.startTimeMillis;
        }

        public final long component8() {
            return this.threadId;
        }

        public final String component9() {
            return this.threadName;
        }

        public final TraceInfo copy(String traceId, String spanId, String str, String operationName, LogModule module, long j10, long j11, long j12, String threadName, Map<String, Object> attributes, long j13, TraceStatus status, String str2) {
            g.f(traceId, "traceId");
            g.f(spanId, "spanId");
            g.f(operationName, "operationName");
            g.f(module, "module");
            g.f(threadName, "threadName");
            g.f(attributes, "attributes");
            g.f(status, "status");
            return new TraceInfo(traceId, spanId, str, operationName, module, j10, j11, j12, threadName, attributes, j13, status, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TraceInfo)) {
                return false;
            }
            TraceInfo traceInfo = (TraceInfo) obj;
            return g.b(this.traceId, traceInfo.traceId) && g.b(this.spanId, traceInfo.spanId) && g.b(this.parentSpanId, traceInfo.parentSpanId) && g.b(this.operationName, traceInfo.operationName) && this.module == traceInfo.module && this.startTime == traceInfo.startTime && this.startTimeMillis == traceInfo.startTimeMillis && this.threadId == traceInfo.threadId && g.b(this.threadName, traceInfo.threadName) && g.b(this.attributes, traceInfo.attributes) && this.endTime == traceInfo.endTime && this.status == traceInfo.status && g.b(this.errorMessage, traceInfo.errorMessage);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final double getDurationMs() {
            return getDurationNanos() / 1000000.0d;
        }

        public final long getDurationNanos() {
            long jNanoTime = this.endTime;
            if (jNanoTime <= 0) {
                jNanoTime = System.nanoTime();
            }
            return jNanoTime - this.startTime;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final LogModule getModule() {
            return this.module;
        }

        public final String getOperationName() {
            return this.operationName;
        }

        public final String getParentSpanId() {
            return this.parentSpanId;
        }

        public final String getSpanId() {
            return this.spanId;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final long getStartTimeMillis() {
            return this.startTimeMillis;
        }

        public final TraceStatus getStatus() {
            return this.status;
        }

        public final long getThreadId() {
            return this.threadId;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public int hashCode() {
            int iA = v1.d.a(this.traceId.hashCode() * 31, 31, this.spanId);
            String str = this.parentSpanId;
            int iHashCode = (this.status.hashCode() + a0.a.c((this.attributes.hashCode() + v1.d.a(a0.a.c(a0.a.c(a0.a.c((this.module.hashCode() + v1.d.a((iA + (str == null ? 0 : str.hashCode())) * 31, 31, this.operationName)) * 31, this.startTime, 31), this.startTimeMillis, 31), this.threadId, 31), 31, this.threadName)) * 31, this.endTime, 31)) * 31;
            String str2 = this.errorMessage;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final void setEndTime(long j10) {
            this.endTime = j10;
        }

        public final void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public final void setStatus(TraceStatus traceStatus) {
            g.f(traceStatus, "<set-?>");
            this.status = traceStatus;
        }

        public String toString() {
            String str = this.traceId;
            String str2 = this.spanId;
            String str3 = this.parentSpanId;
            String str4 = this.operationName;
            LogModule logModule = this.module;
            long j10 = this.startTime;
            long j11 = this.startTimeMillis;
            long j12 = this.threadId;
            String str5 = this.threadName;
            Map<String, Object> map = this.attributes;
            long j13 = this.endTime;
            TraceStatus traceStatus = this.status;
            String str6 = this.errorMessage;
            StringBuilder sbS = ai.onnxruntime.a.s("TraceInfo(traceId=", str, ", spanId=", str2, ", parentSpanId=");
            ai.onnxruntime.a.z(sbS, str3, ", operationName=", str4, ", module=");
            sbS.append(logModule);
            sbS.append(", startTime=");
            sbS.append(j10);
            a0.a.s(j11, ", startTimeMillis=", ", threadId=", sbS);
            ai.onnxruntime.a.u(j12, ", threadName=", str5, sbS);
            sbS.append(", attributes=");
            sbS.append(map);
            sbS.append(", endTime=");
            sbS.append(j13);
            sbS.append(", status=");
            sbS.append(traceStatus);
            return ai.onnxruntime.a.p(sbS, ", errorMessage=", str6, ")");
        }

        public /* synthetic */ TraceInfo(String str, String str2, String str3, String str4, LogModule logModule, long j10, long j11, long j12, String str5, Map map, long j13, TraceStatus traceStatus, String str6, int i10, e eVar) {
            this(str, str2, str3, str4, logModule, j10, j11, j12, str5, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? new LinkedHashMap() : map, (i10 & 1024) != 0 ? 0L : j13, (i10 & 2048) != 0 ? TraceStatus.RUNNING : traceStatus, (i10 & 4096) != 0 ? null : str6);
        }
    }
}
