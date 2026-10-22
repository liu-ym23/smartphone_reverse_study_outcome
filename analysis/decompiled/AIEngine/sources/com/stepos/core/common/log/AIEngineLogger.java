package com.stepos.core.common.log;

import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.log.LogEntry;
import com.stepos.core.common.log.PerfettoTrace;
import com.stepos.core.common.log.TraceContext;
import fc.f;
import fc.i;
import fc.p;
import gc.n;
import gc.o;
import gc.q;
import gc.r;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import mb.l;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineLogger {
    private static final int DEFAULT_TAIL_LINES = 80;
    public static final AIEngineLogger INSTANCE;
    private static final int MAX_TAIL_LINE_CHARS = 200;
    private static final String TAG = "AIEngineLogger";
    private static final int TAIL_SCAN_WINDOW = 400;
    private static volatile boolean isNativeInitialized;
    private static final lb.d logBuffer$delegate;
    private static final ConcurrentHashMap<String, PerfStatistic> perfStats;
    private static final ConcurrentHashMap<String, Long> perfTracker;
    private static final TraceContext traceContext;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogLevel.ASSERT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        AIEngineLogger aIEngineLogger = new AIEngineLogger();
        INSTANCE = aIEngineLogger;
        logBuffer$delegate = kotlin.b.b(new a9.b(10));
        perfTracker = new ConcurrentHashMap<>();
        perfStats = new ConcurrentHashMap<>();
        traceContext = TraceContext.INSTANCE;
        aIEngineLogger.initNativeLogBridge();
    }

    private AIEngineLogger() {
    }

    public static final void clear() {
        INSTANCE.getLogBuffer().clear();
        perfTracker.clear();
        perfStats.clear();
        TraceContext.clearStats();
    }

    public static final TraceContext.TraceInfo currentTrace() {
        return TraceContext.current();
    }

    public static final String currentTraceId() {
        return TraceContext.currentTraceId();
    }

    public static final void dumpAllLogs(PrintWriter writer, String[] args) {
        g.f(writer, "writer");
        g.f(args, "args");
        AIEngineLogger aIEngineLogger = INSTANCE;
        List<LogEntry> listFilterLogs = aIEngineLogger.getLogBuffer().filterLogs(aIEngineLogger.parseModules(args), aIEngineLogger.parseLevel(args), l.a0("--native-only", args) ? Boolean.TRUE : l.a0("--java-only", args) ? Boolean.FALSE : null, aIEngineLogger.parseLimit(args));
        if (listFilterLogs.isEmpty()) {
            writer.println("(No log entries)");
            return;
        }
        Iterator<T> it = listFilterLogs.iterator();
        while (it.hasNext()) {
            writer.println(((LogEntry) it.next()).formatFull());
        }
    }

    public static final void dumpModuleLogs(PrintWriter writer, LogModule module, String[] args) {
        g.f(writer, "writer");
        g.f(module, "module");
        g.f(args, "args");
        AIEngineLogger aIEngineLogger = INSTANCE;
        List<LogEntry> listFilterByModule = aIEngineLogger.getLogBuffer().filterByModule(module);
        Integer limit = aIEngineLogger.parseLimit(args);
        LogLevel level = aIEngineLogger.parseLevel(args);
        i iVarL0 = kotlin.collections.a.l0(listFilterByModule);
        if (level != null) {
            iVarL0 = new f(iVarL0, new androidx.compose.runtime.g(level, 8));
        }
        List listA = p.A(iVarL0);
        if (limit != null) {
            listA = kotlin.collections.a.K0(limit.intValue(), listA);
        }
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            writer.println(((LogEntry) it.next()).formatFull());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dumpModuleLogs$lambda$15$lambda$14(LogLevel logLevel, LogEntry it) {
        g.f(it, "it");
        return it.getLevel().getPriority() >= logLevel.getPriority();
    }

    public static final void dumpTrace(PrintWriter writer) {
        g.f(writer, "writer");
        TraceContext.dump(writer);
    }

    public static final void e(LogModule module, String message) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.ERROR, module, "", message, null);
    }

    private final String formatExceptionTailLine(LogEntry logEntry) {
        String message = logEntry.getMessage();
        if (message.length() > 200) {
            message = r.R0(200, message);
        }
        long timestamp = logEntry.getTimestamp();
        String tag = logEntry.getLevel().getTag();
        String strName = logEntry.getModule().name();
        String tag2 = logEntry.getTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(timestamp);
        sb2.append("|");
        sb2.append(tag);
        sb2.append("|");
        ai.onnxruntime.a.z(sb2, strName, "|", tag2, "|");
        sb2.append(message);
        return sb2.toString();
    }

    public static final List<TraceContext.TraceInfo> getActiveTraces() {
        return TraceContext.getActiveTraces();
    }

    public static final List<LogEntry> getAllLogs() {
        return INSTANCE.getLogBuffer().getAll();
    }

    private final LogRingBuffer getLogBuffer() {
        return (LogRingBuffer) logBuffer$delegate.getValue();
    }

    public static final int getModuleStats(LogModule module) {
        g.f(module, "module");
        return INSTANCE.getLogBuffer().filterByModule(module).size();
    }

    public static final Map<String, PerfStatistic> getPerfStats() {
        return kotlin.collections.b.n0(perfStats);
    }

    public static final List<LogEntry> getRecentLogs(int i10) {
        return INSTANCE.getLogBuffer().getRecent(i10);
    }

    public static final LogStatistics getStatistics() {
        return INSTANCE.getLogBuffer().getStatistics();
    }

    public static final Map<String, TraceStatistic> getTraceStats() {
        return TraceContext.getStats();
    }

    public static final void i(LogModule module, String message) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.INFO, module, "", message, null);
    }

    private final void initNativeLogBridge() {
        if (isNativeInitialized) {
            return;
        }
        try {
            NativeLogBridge.initialize(LogConfig.getSyncNativeToJava(), 256);
            isNativeInitialized = true;
        } catch (Exception e10) {
            Log.w(TAG, "Native log bridge init failed, native logging disabled", e10);
        }
    }

    public static final void log(LogLevel level, LogModule module, String tag, String message, Throwable th) {
        g.f(level, "level");
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        if (LogConfig.shouldLog(level, module)) {
            if (message.length() > LogConfig.getMaxMessageLength()) {
                String strSubstring = message.substring(0, LogConfig.getMaxMessageLength());
                g.e(strSubstring, "substring(...)");
                message = strSubstring.concat("...(truncated)");
            }
            LogEntry logEntryCreate$default = LogEntry.Companion.create$default(LogEntry.Companion, level, module, tag, message, th, null, 32, null);
            if (LogConfig.getEnableBuffer()) {
                INSTANCE.getLogBuffer().put(logEntryCreate$default);
            }
            if (LogConfig.getEnableLogcat()) {
                INSTANCE.outputToLogcat(logEntryCreate$default);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LogRingBuffer logBuffer_delegate$lambda$0() {
        return new LogRingBuffer(LogConfig.getBufferSize());
    }

    public static final void logFromNative(long j10, long j11, int i10, int i11, String tag, String message) {
        g.f(tag, "tag");
        g.f(message, "message");
        if (LogConfig.getEnableNativeLog()) {
            LogEntry logEntryCreateFromNative = LogEntry.Companion.createFromNative(j10, j11, i10, i11, tag, message);
            if (LogConfig.getEnableBuffer() && LogConfig.getSyncNativeToJava()) {
                INSTANCE.getLogBuffer().put(logEntryCreateFromNative);
            }
            if (LogConfig.getEnableLogcat()) {
                INSTANCE.outputToLogcat(logEntryCreateFromNative);
            }
        }
    }

    private final boolean matchesExceptionTail(LogEntry logEntry, List<String> list) {
        String message;
        if (!list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(logEntry.getMessage());
            Throwable throwable = logEntry.getThrowable();
            if (throwable != null && (message = throwable.getMessage()) != null) {
                sb2.append((char) 0);
                sb2.append(message);
            }
            String string = sb2.toString();
            g.e(string, "toString(...)");
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (q.l0(string, (String) it.next(), false)) {
                        return true;
                    }
                }
            }
        } else if (logEntry.getLevel().getPriority() >= LogLevel.WARN.getPriority()) {
            return true;
        }
        return false;
    }

    private final void outputToLogcat(LogEntry logEntry) {
        String logcatTag = logEntry.getLogcatTag();
        String logcatMessage = logEntry.toLogcatMessage();
        switch (WhenMappings.$EnumSwitchMapping$0[logEntry.getLevel().ordinal()]) {
            case 1:
                Log.v(logcatTag, logcatMessage);
                return;
            case 2:
                Log.d(logcatTag, logcatMessage);
                return;
            case 3:
                Log.i(logcatTag, logcatMessage);
                return;
            case 4:
                Log.w(logcatTag, logcatMessage);
                return;
            case 5:
                Log.e(logcatTag, logcatMessage);
                return;
            case 6:
                Log.wtf(logcatTag, logcatMessage);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final LogLevel parseLevel(String[] strArr) {
        String str;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = null;
                break;
            }
            str = strArr[i10];
            if (o.k0(str, "--level=", false)) {
                break;
            }
            i10++;
        }
        if (str == null) {
            return null;
        }
        return LogLevel.Companion.fromName(q.G0(str, "="));
    }

    private final Integer parseLimit(String[] strArr) {
        String str;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = null;
                break;
            }
            str = strArr[i10];
            if (o.k0(str, "--last=", false)) {
                break;
            }
            i10++;
        }
        if (str != null) {
            return n.c0(q.G0(str, "="));
        }
        return null;
    }

    private final List<LogModule> parseModules(String[] strArr) {
        String str;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str = null;
                break;
            }
            str = strArr[i10];
            if (o.k0(str, "--module=", false)) {
                break;
            }
            i10++;
        }
        if (str != null) {
            List<LogModule> modules = LogModule.Companion.parseModules(q.G0(str, "="));
            if (modules != null && !modules.isEmpty()) {
                return modules;
            }
        }
        return null;
    }

    public static final <T> T perf(LogModule module, String operation, zb.a<? extends T> block) {
        g.f(module, "module");
        g.f(operation, "operation");
        g.f(block, "block");
        perfStart(module, operation);
        try {
            return block.invoke();
        } finally {
            perfEnd(module, operation);
        }
    }

    public static final void perfEnd(LogModule module, final String operation) {
        String strI;
        Long lRemove;
        g.f(module, "module");
        g.f(operation, "operation");
        if (LogConfig.getEnablePerformanceLog() && (lRemove = perfTracker.remove((strI = com.stepos.core.ota.d.i(module.getModuleTag(), "_", operation)))) != null) {
            final double dNanoTime = (System.nanoTime() - lRemove.longValue()) / 1000000.0d;
            perfStats.compute(strI, new c7.a(new zb.p() { // from class: com.stepos.core.common.log.a
                @Override // zb.p
                public final Object invoke(Object obj, Object obj2) {
                    return AIEngineLogger.perfEnd$lambda$2(operation, dNanoTime, (String) obj, (PerfStatistic) obj2);
                }
            }, 1));
            d(LogModule.PERFORMANCE, a0.a.k("[", operation, "] took %.2f ms"), Double.valueOf(dNanoTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PerfStatistic perfEnd$lambda$2(String str, double d8, String str2, PerfStatistic perfStatistic) {
        g.f(str2, "<unused var>");
        if (perfStatistic == null) {
            perfStatistic = new PerfStatistic(str);
        }
        perfStatistic.add(d8);
        return perfStatistic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PerfStatistic perfEnd$lambda$3(zb.p pVar, Object obj, Object obj2) {
        return (PerfStatistic) pVar.invoke(obj, obj2);
    }

    public static final void perfStart(LogModule module, String operation) {
        g.f(module, "module");
        g.f(operation, "operation");
        if (LogConfig.getEnablePerformanceLog()) {
            perfTracker.put(com.stepos.core.ota.d.i(module.getModuleTag(), "_", operation), Long.valueOf(System.nanoTime()));
        }
    }

    public static final void shutdown() {
        try {
            NativeLogBridge.shutdown();
            isNativeInitialized = false;
        } catch (Exception e10) {
            Log.w(TAG, "Native log bridge shutdown failed", e10);
        }
    }

    public static final List<String> tailForException(String str) {
        return tailForException$default(str, 0, 2, (Object) null);
    }

    public static /* synthetic */ List tailForException$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = DEFAULT_TAIL_LINES;
        }
        return tailForException(str, i10);
    }

    public static final <T> T trace(String operationName, LogModule module, zb.l<? super TraceContext.TraceInfo, ? extends T> block) throws Exception {
        g.f(operationName, "operationName");
        g.f(module, "module");
        g.f(block, "block");
        if (LogConfig.shouldTrace()) {
            TraceContext.TraceInfo traceInfoStartSpan = TraceContext.startSpan(operationName, module);
            try {
                T tInvoke = block.invoke(traceInfoStartSpan);
                TraceContext.endSpan$default(traceInfoStartSpan, TraceContext.TraceStatus.SUCCESS, null, 4, null);
                return tInvoke;
            } catch (Exception e10) {
                TraceContext traceContext2 = TraceContext.INSTANCE;
                String message = e10.getMessage();
                if (message == null) {
                    message = e10.getClass().getSimpleName();
                }
                TraceContext.failSpan(traceInfoStartSpan, message);
                throw e10;
            }
        }
        return block.invoke(new TraceContext.TraceInfo("", "", null, operationName, module, 0L, 0L, 0L, "", null, 0L, null, null, 7680, null));
    }

    public static final void traceAddAttribute(String key, Object value) {
        g.f(key, "key");
        g.f(value, "value");
        TraceContext.addAttribute(key, value);
    }

    public static final void traceAsyncEnd(PerfettoTrace.AsyncTraceToken token) {
        g.f(token, "token");
        PerfettoTrace.endAsync(token);
    }

    public static final void traceAsyncEndWithSpan(AsyncTraceInfo info, boolean z, String str) {
        g.f(info, "info");
        traceEnd(info.getTraceInfo(), z, str);
        PerfettoTrace.AsyncTraceToken asyncToken = info.getAsyncToken();
        if (asyncToken != null) {
            PerfettoTrace.endAsync(asyncToken);
        }
    }

    public static /* synthetic */ void traceAsyncEndWithSpan$default(AsyncTraceInfo asyncTraceInfo, boolean z, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        traceAsyncEndWithSpan(asyncTraceInfo, z, str);
    }

    public static final PerfettoTrace.AsyncTraceToken traceAsyncStart(String operationName) {
        g.f(operationName, "operationName");
        return PerfettoTrace.startAsync(operationName);
    }

    public static final AsyncTraceInfo traceAsyncStartWithSpan(String operationName, LogModule module) {
        PerfettoTrace.AsyncTraceToken asyncTraceTokenStartAsync;
        g.f(operationName, "operationName");
        g.f(module, "module");
        TraceContext.TraceInfo traceInfoStartSpan = TraceContext.startSpan(operationName, module);
        if (LogConfig.getEnableSystrace()) {
            asyncTraceTokenStartAsync = PerfettoTrace.startAsync(module.getModuleTag() + ":" + operationName);
        } else {
            asyncTraceTokenStartAsync = null;
        }
        return new AsyncTraceInfo(traceInfoStartSpan, asyncTraceTokenStartAsync);
    }

    public static final void traceCancel(TraceContext.TraceInfo traceInfo) {
        g.f(traceInfo, "traceInfo");
        TraceContext.cancelSpan(traceInfo);
    }

    public static final void traceCounter(String name, long j10) {
        g.f(name, "name");
        PerfettoTrace.setCounter(name, j10);
    }

    public static final void traceCounterDecrement(String name) {
        g.f(name, "name");
        PerfettoTrace.decrementCounter(name);
    }

    public static final void traceCounterIncrement(String name) {
        g.f(name, "name");
        PerfettoTrace.incrementCounter(name);
    }

    public static final void traceEnd(TraceContext.TraceInfo traceInfo, boolean z, String str) {
        g.f(traceInfo, "traceInfo");
        TraceContext.endSpan(traceInfo, z ? TraceContext.TraceStatus.SUCCESS : TraceContext.TraceStatus.FAILED, str);
        if (traceInfo.getDurationMs() > LogConfig.getSlowOperationThresholdMs()) {
            LogModule module = traceInfo.getModule();
            StringBuilder sbL = com.stepos.core.ota.d.l("[", LogConfig.getSlowOperationThresholdMs(), traceInfo.getOperationName(), "] took %.2fms (threshold: ");
            sbL.append("ms)");
            w(module, "SLOW_OP", String.format(sbL.toString(), Arrays.copyOf(new Object[]{Double.valueOf(traceInfo.getDurationMs())}, 1)));
        }
    }

    public static /* synthetic */ void traceEnd$default(TraceContext.TraceInfo traceInfo, boolean z, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        traceEnd(traceInfo, z, str);
    }

    public static final void traceEvent(String name, Map<String, ? extends Object> map) {
        g.f(name, "name");
        TraceContext.addEvent(name, map);
    }

    public static /* synthetic */ void traceEvent$default(String str, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            map = null;
        }
        traceEvent(str, map);
    }

    public static final void traceFail(TraceContext.TraceInfo traceInfo, String errorMessage) {
        g.f(traceInfo, "traceInfo");
        g.f(errorMessage, "errorMessage");
        TraceContext.failSpan(traceInfo, errorMessage);
    }

    public static final TraceContext.TraceInfo traceStart(String operationName, LogModule module) {
        g.f(operationName, "operationName");
        g.f(module, "module");
        return TraceContext.startSpan(operationName, module);
    }

    public static final void v(LogModule module, String message) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.VERBOSE, module, "", message, null);
    }

    public static final void w(LogModule module, String message) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.WARN, module, "", message, null);
    }

    public static final Runnable wrapWithTraceContext(Runnable runnable) {
        g.f(runnable, "runnable");
        return TraceContext.wrapRunnable(runnable);
    }

    public static final void d(LogModule module, String message) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.DEBUG, module, "", message, null);
    }

    public static final void e(LogModule module, String tag, String message) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.ERROR, module, tag, message, null);
    }

    public static final void i(LogModule module, String tag, String message) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.INFO, module, tag, message, null);
    }

    public static final List<String> tailForException(Collection<String> correlationIds) {
        g.f(correlationIds, "correlationIds");
        return tailForException$default(correlationIds, 0, 2, (Object) null);
    }

    public static /* synthetic */ List tailForException$default(Collection collection, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = DEFAULT_TAIL_LINES;
        }
        return tailForException((Collection<String>) collection, i10);
    }

    public static final void v(LogModule module, String tag, String message) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.VERBOSE, module, tag, message, null);
    }

    public static final void w(LogModule module, String tag, String message) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.WARN, module, tag, message, null);
    }

    public static final void d(LogModule module, String tag, String message) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.DEBUG, module, tag, message, null);
    }

    public static final void e(LogModule module, String message, Throwable th) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.ERROR, module, "", message, th);
    }

    public static final void i(LogModule module, String format, Object... args) {
        g.f(module, "module");
        g.f(format, "format");
        g.f(args, "args");
        LogLevel logLevel = LogLevel.INFO;
        if (LogConfig.shouldLog(logLevel, module)) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            log(logLevel, module, "", String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)), null);
        }
    }

    public static final List<String> tailForException(String str, int i10) {
        Collection collectionP;
        if (str == null || str.length() <= 0) {
            str = null;
        }
        if (str != null) {
            collectionP = b1.P(str);
        } else {
            collectionP = EmptyList.f10001a;
        }
        return tailForException((Collection<String>) collectionP, i10);
    }

    public static final void w(LogModule module, String message, Throwable th) {
        g.f(module, "module");
        g.f(message, "message");
        log(LogLevel.WARN, module, "", message, th);
    }

    public static final void d(LogModule module, String format, Object... args) {
        g.f(module, "module");
        g.f(format, "format");
        g.f(args, "args");
        LogLevel logLevel = LogLevel.DEBUG;
        if (LogConfig.shouldLog(logLevel, module)) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            log(logLevel, module, "", String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)), null);
        }
    }

    public static final void e(LogModule module, String tag, String message, Throwable th) {
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        log(LogLevel.ERROR, module, tag, message, th);
    }

    public static final void w(LogModule module, String format, Object... args) {
        g.f(module, "module");
        g.f(format, "format");
        g.f(args, "args");
        LogLevel logLevel = LogLevel.WARN;
        if (LogConfig.shouldLog(logLevel, module)) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            log(logLevel, module, "", String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)), null);
        }
    }

    public static final void e(LogModule module, String format, Object... args) {
        g.f(module, "module");
        g.f(format, "format");
        g.f(args, "args");
        LogLevel logLevel = LogLevel.ERROR;
        if (LogConfig.shouldLog(logLevel, module)) {
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            log(logLevel, module, "", String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.ArrayList] */
    public static final List<String> tailForException(Collection<String> correlationIds, int i10) {
        ?? A;
        g.f(correlationIds, "correlationIds");
        AIEngineLogger aIEngineLogger = INSTANCE;
        try {
            Collection<String> collection = correlationIds;
            ArrayList arrayList = new ArrayList(m.Z(collection, 10));
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(q.L0((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            List<String> listO0 = kotlin.collections.a.o0(arrayList2);
            List<LogEntry> recent = aIEngineLogger.getLogBuffer().getRecent(400);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : recent) {
                if (aIEngineLogger.matchesExceptionTail((LogEntry) obj2, listO0)) {
                    arrayList3.add(obj2);
                }
            }
            List listK0 = kotlin.collections.a.K0(i10, arrayList3);
            A = new ArrayList(m.Z(listK0, 10));
            Iterator it2 = listK0.iterator();
            while (it2.hasNext()) {
                A.add(aIEngineLogger.formatExceptionTailLine((LogEntry) it2.next()));
            }
        } catch (Throwable th) {
            A = kotlin.c.a(th);
        }
        EmptyList emptyList = EmptyList.f10001a;
        boolean z = A instanceof Result.Failure;
        EmptyList emptyList2 = A;
        if (z) {
            emptyList2 = emptyList;
        }
        return emptyList2;
    }
}
