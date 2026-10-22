package com.stepos.core.common.log;

import com.stepos.core.ability.speech.AsrSseEvent;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import dc.h;
import gc.q;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogConfig {
    public static final LogConfig INSTANCE;
    private static final String PROP_LOG_LEVEL = "persist.aiengine.loglevel";
    private static final AtomicInteger _bufferSize;
    private static final AtomicBoolean _enableBuffer;
    private static final AtomicBoolean _enableFilePersistence;
    private static final AtomicBoolean _enableLogcat;
    private static final AtomicBoolean _enableNativeLog;
    private static final AtomicBoolean _enablePerformanceLog;
    private static final AtomicBoolean _enableSystrace;
    private static final AtomicBoolean _enableTrace;
    private static final AtomicBoolean _enableTraceLog;
    private static final AtomicBoolean _enableTraceSampling;
    private static final AtomicReference<LogLevel> _globalLogLevel;
    private static final AtomicReference<String> _logFilePath;
    private static final AtomicInteger _maxFileCount;
    private static final AtomicInteger _maxFileSize;
    private static final AtomicInteger _maxMessageLength;
    private static final AtomicInteger _slowOperationThresholdMs;
    private static final AtomicBoolean _syncNativeToJava;
    private static final AtomicInteger _traceSampleRate;
    private static final ConcurrentHashMap<LogModule, Boolean> moduleEnabledMap;
    private static final ConcurrentHashMap<LogModule, LogLevel> moduleLevelMap;

    static {
        LogConfig logConfig = new LogConfig();
        INSTANCE = logConfig;
        _globalLogLevel = new AtomicReference<>(LogLevel.DEBUG);
        _enableLogcat = new AtomicBoolean(true);
        _enableBuffer = new AtomicBoolean(true);
        _bufferSize = new AtomicInteger(1024);
        _maxMessageLength = new AtomicInteger(4096);
        _enableNativeLog = new AtomicBoolean(true);
        _syncNativeToJava = new AtomicBoolean(true);
        _enablePerformanceLog = new AtomicBoolean(true);
        _enableTrace = new AtomicBoolean(true);
        _enableTraceLog = new AtomicBoolean(true);
        _enableSystrace = new AtomicBoolean(false);
        _slowOperationThresholdMs = new AtomicInteger(1000);
        _enableTraceSampling = new AtomicBoolean(false);
        _traceSampleRate = new AtomicInteger(100);
        _enableFilePersistence = new AtomicBoolean(false);
        _logFilePath = new AtomicReference<>("/data/local/tmp/aiengine/");
        _maxFileSize = new AtomicInteger(10485760);
        _maxFileCount = new AtomicInteger(5);
        moduleEnabledMap = new ConcurrentHashMap<>();
        moduleLevelMap = new ConcurrentHashMap<>();
        try {
            logConfig.applyLogLevelProp();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private LogConfig() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void applyLogLevelProp() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String string;
        Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, PROP_LOG_LEVEL, "");
        String str = objInvoke instanceof String ? (String) objInvoke : null;
        if (str == null || (string = q.L0(str).toString()) == null) {
            return;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -902327211:
                if (!lowerCase.equals("silent")) {
                }
                setGlobalLogLevel(LogLevel.ASSERT);
                setEnableLogcat(false);
                setEnableBuffer(false);
                break;
            case 100:
                if (!lowerCase.equals("d")) {
                }
                setGlobalLogLevel(LogLevel.DEBUG);
                break;
            case 101:
                if (!lowerCase.equals("e")) {
                }
                setGlobalLogLevel(LogLevel.ERROR);
                break;
            case Content.Types.TYPE_STRING /* 105 */:
                if (!lowerCase.equals("i")) {
                }
                setGlobalLogLevel(LogLevel.INFO);
                break;
            case 118:
                if (!lowerCase.equals("v")) {
                }
                setGlobalLogLevel(LogLevel.VERBOSE);
                break;
            case 119:
                if (!lowerCase.equals("w")) {
                }
                setGlobalLogLevel(LogLevel.WARN);
                break;
            case 109935:
                if (!lowerCase.equals("off")) {
                }
                setGlobalLogLevel(LogLevel.ASSERT);
                setEnableLogcat(false);
                setEnableBuffer(false);
                break;
            case 3237038:
                if (!lowerCase.equals("info")) {
                }
                setGlobalLogLevel(LogLevel.INFO);
                break;
            case 3387192:
                if (!lowerCase.equals(ModelManifest.BACKEND_NONE)) {
                }
                setGlobalLogLevel(LogLevel.ASSERT);
                setEnableLogcat(false);
                setEnableBuffer(false);
                break;
            case 3641990:
                if (!lowerCase.equals("warn")) {
                }
                setGlobalLogLevel(LogLevel.WARN);
                break;
            case 95458899:
                if (!lowerCase.equals("debug")) {
                }
                setGlobalLogLevel(LogLevel.DEBUG);
                break;
            case 96784904:
                if (!lowerCase.equals(AsrSseEvent.TYPE_ERROR)) {
                }
                setGlobalLogLevel(LogLevel.ERROR);
                break;
            case 351107458:
                if (!lowerCase.equals("verbose")) {
                }
                setGlobalLogLevel(LogLevel.VERBOSE);
                break;
        }
    }

    public static final void dump(PrintWriter writer) {
        g.f(writer, "writer");
        writer.println("----- Log Configuration -----");
        writer.println("  Global Log Level: " + getGlobalLogLevel());
        writer.println("  Enable Logcat: " + getEnableLogcat());
        writer.println("  Enable Buffer: " + getEnableBuffer() + " (size=" + getBufferSize() + ")");
        int maxMessageLength = getMaxMessageLength();
        StringBuilder sb2 = new StringBuilder("  Max Message Length: ");
        sb2.append(maxMessageLength);
        writer.println(sb2.toString());
        writer.println();
        writer.println("----- Native Configuration -----");
        writer.println("  Enable Native Log: " + getEnableNativeLog());
        writer.println("  Sync Native to Java: " + getSyncNativeToJava());
        writer.println();
        writer.println("----- Trace Configuration -----");
        writer.println("  Enable Trace: " + getEnableTrace());
        writer.println("  Enable Trace Log: " + getEnableTraceLog());
        writer.println("  Enable Systrace: " + getEnableSystrace());
        writer.println("  Slow Operation Threshold: " + getSlowOperationThresholdMs() + "ms");
        writer.println("  Enable Sampling: " + getEnableTraceSampling() + " (rate=" + getTraceSampleRate() + "%)");
        writer.println();
        writer.println("----- Module Configuration -----");
        for (LogModule logModule : LogModule.getEntries()) {
            boolean zIsModuleEnabled = isModuleEnabled(logModule);
            LogLevel moduleLevel = getModuleLevel(logModule);
            StringBuilder sbM = com.stepos.core.ota.d.m("  ", logModule.getModuleTag(), ": enabled=", ", level=", zIsModuleEnabled);
            sbM.append(moduleLevel);
            writer.println(sbM.toString());
        }
    }

    public static final Map<String, Object> exportConfig() {
        return kotlin.collections.b.g0(new Pair("globalLogLevel", getGlobalLogLevel().name()), new Pair("enableLogcat", Boolean.valueOf(getEnableLogcat())), new Pair("enableBuffer", Boolean.valueOf(getEnableBuffer())), new Pair("bufferSize", Integer.valueOf(getBufferSize())), new Pair("maxMessageLength", Integer.valueOf(getMaxMessageLength())), new Pair("enableNativeLog", Boolean.valueOf(getEnableNativeLog())), new Pair("syncNativeToJava", Boolean.valueOf(getSyncNativeToJava())), new Pair("enablePerformanceLog", Boolean.valueOf(getEnablePerformanceLog())), new Pair("enableTrace", Boolean.valueOf(getEnableTrace())), new Pair("enableTraceLog", Boolean.valueOf(getEnableTraceLog())), new Pair("enableSystrace", Boolean.valueOf(getEnableSystrace())), new Pair("slowOperationThresholdMs", Long.valueOf(getSlowOperationThresholdMs())), new Pair("enableTraceSampling", Boolean.valueOf(getEnableTraceSampling())), new Pair("traceSampleRate", Integer.valueOf(getTraceSampleRate())), new Pair("enableFilePersistence", Boolean.valueOf(getEnableFilePersistence())));
    }

    public static final int getBufferSize() {
        return _bufferSize.get();
    }

    public static final boolean getEnableBuffer() {
        return _enableBuffer.get();
    }

    public static final boolean getEnableFilePersistence() {
        return _enableFilePersistence.get();
    }

    public static final boolean getEnableLogcat() {
        return _enableLogcat.get();
    }

    public static final boolean getEnableNativeLog() {
        return _enableNativeLog.get();
    }

    public static final boolean getEnablePerformanceLog() {
        return _enablePerformanceLog.get();
    }

    public static final boolean getEnableSystrace() {
        return _enableSystrace.get();
    }

    public static final boolean getEnableTrace() {
        return _enableTrace.get();
    }

    public static final boolean getEnableTraceLog() {
        return _enableTraceLog.get();
    }

    public static final boolean getEnableTraceSampling() {
        return _enableTraceSampling.get();
    }

    public static final LogLevel getGlobalLogLevel() {
        LogLevel logLevel = _globalLogLevel.get();
        g.e(logLevel, "get(...)");
        return logLevel;
    }

    public static final String getLogFilePath() {
        String str = _logFilePath.get();
        g.e(str, "get(...)");
        return str;
    }

    public static final int getMaxFileCount() {
        return _maxFileCount.get();
    }

    public static final long getMaxFileSize() {
        return _maxFileSize.get();
    }

    public static final int getMaxMessageLength() {
        return _maxMessageLength.get();
    }

    public static final LogLevel getModuleLevel(LogModule module) {
        g.f(module, "module");
        LogLevel orDefault = moduleLevelMap.getOrDefault(module, getGlobalLogLevel());
        g.e(orDefault, "getOrDefault(...)");
        return orDefault;
    }

    public static final long getSlowOperationThresholdMs() {
        return _slowOperationThresholdMs.get();
    }

    public static final String getSummary() {
        StringBuilder sb2 = new StringBuilder("----- Log Configuration -----\n");
        sb2.append("  Global Log Level: " + getGlobalLogLevel());
        sb2.append('\n');
        sb2.append("  Enable Logcat: " + getEnableLogcat());
        sb2.append('\n');
        sb2.append("  Enable Buffer: " + getEnableBuffer() + " (size=" + getBufferSize() + ")");
        sb2.append('\n');
        int maxMessageLength = getMaxMessageLength();
        StringBuilder sb3 = new StringBuilder("  Max Message Length: ");
        sb3.append(maxMessageLength);
        sb2.append(sb3.toString());
        sb2.append("\n\n----- Native Configuration -----\n");
        sb2.append("  Enable Native Log: " + getEnableNativeLog());
        sb2.append('\n');
        sb2.append("  Sync Native to Java: " + getSyncNativeToJava());
        sb2.append("\n\n----- Trace Configuration -----\n");
        sb2.append("  Enable Trace: " + getEnableTrace());
        sb2.append('\n');
        sb2.append("  Enable Trace Log: " + getEnableTraceLog());
        sb2.append('\n');
        sb2.append("  Enable Systrace: " + getEnableSystrace());
        sb2.append('\n');
        sb2.append("  Slow Operation Threshold: " + getSlowOperationThresholdMs() + "ms");
        sb2.append('\n');
        sb2.append("  Enable Sampling: " + getEnableTraceSampling() + " (rate=" + getTraceSampleRate() + "%)");
        sb2.append('\n');
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public static final boolean getSyncNativeToJava() {
        return _syncNativeToJava.get();
    }

    public static final int getTraceSampleRate() {
        return _traceSampleRate.get();
    }

    public static final boolean isModuleEnabled(LogModule module) {
        g.f(module, "module");
        Boolean orDefault = moduleEnabledMap.getOrDefault(module, Boolean.TRUE);
        g.e(orDefault, "getOrDefault(...)");
        return orDefault.booleanValue();
    }

    public static final void reset() {
        setGlobalLogLevel(LogLevel.DEBUG);
        setEnableLogcat(true);
        setEnableBuffer(true);
        setBufferSize(1024);
        setMaxMessageLength(4096);
        setEnableNativeLog(true);
        setSyncNativeToJava(true);
        setEnablePerformanceLog(true);
        setEnableTrace(true);
        setEnableTraceLog(true);
        setEnableSystrace(false);
        setSlowOperationThresholdMs(1000L);
        setEnableTraceSampling(false);
        setTraceSampleRate(100);
        setEnableFilePersistence(false);
        moduleEnabledMap.clear();
        moduleLevelMap.clear();
    }

    public static final void setBufferSize(int i10) {
        _bufferSize.set(h.a0(i10, TraceIdKeys.MAX_LENGTH, 4096));
    }

    public static final void setDebugMode() {
        setGlobalLogLevel(LogLevel.VERBOSE);
        setEnableLogcat(true);
        setEnableBuffer(true);
        setEnablePerformanceLog(true);
        setEnableTrace(true);
        setEnableTraceLog(true);
        setEnableTraceSampling(false);
    }

    public static final void setEnableBuffer(boolean z) {
        _enableBuffer.set(z);
    }

    public static final void setEnableFilePersistence(boolean z) {
        _enableFilePersistence.set(z);
    }

    public static final void setEnableLogcat(boolean z) {
        _enableLogcat.set(z);
    }

    public static final void setEnableNativeLog(boolean z) {
        _enableNativeLog.set(z);
    }

    public static final void setEnablePerformanceLog(boolean z) {
        _enablePerformanceLog.set(z);
    }

    public static final void setEnableSystrace(boolean z) {
        _enableSystrace.set(z);
    }

    public static final void setEnableTrace(boolean z) {
        _enableTrace.set(z);
    }

    public static final void setEnableTraceLog(boolean z) {
        _enableTraceLog.set(z);
    }

    public static final void setEnableTraceSampling(boolean z) {
        _enableTraceSampling.set(z);
    }

    public static final void setGlobalLogLevel(LogLevel value) {
        g.f(value, "value");
        _globalLogLevel.set(value);
    }

    public static final void setLogFilePath(String value) {
        g.f(value, "value");
        _logFilePath.set(value);
    }

    public static final void setMaxFileCount(int i10) {
        _maxFileCount.set(h.a0(i10, 1, 20));
    }

    public static final void setMaxFileSize(long j10) {
        _maxFileSize.set((int) h.b0(j10, PcmDumpBudget.BYTES_PER_MB, 104857600L));
    }

    public static final void setMaxMessageLength(int i10) {
        _maxMessageLength.set(h.a0(i10, 256, 16384));
    }

    public static final void setModuleEnabled(LogModule module, boolean z) {
        g.f(module, "module");
        moduleEnabledMap.put(module, Boolean.valueOf(z));
    }

    public static final void setModuleLevel(LogModule module, LogLevel level) {
        g.f(module, "module");
        g.f(level, "level");
        moduleLevelMap.put(module, level);
    }

    public static final void setPerformanceTestMode() {
        setGlobalLogLevel(LogLevel.WARN);
        setEnableLogcat(false);
        setEnableBuffer(true);
        setEnablePerformanceLog(true);
        setEnableTrace(true);
        setEnableTraceLog(false);
        setEnableSystrace(true);
    }

    public static final void setReleaseMode() {
        setGlobalLogLevel(LogLevel.INFO);
        setEnableLogcat(true);
        setEnableBuffer(true);
        setEnablePerformanceLog(true);
        setEnableTrace(true);
        setEnableTraceLog(false);
        setEnableTraceSampling(true);
        setTraceSampleRate(10);
    }

    public static final void setSlowOperationThresholdMs(long j10) {
        _slowOperationThresholdMs.set((int) h.b0(j10, 10L, HysteresisStrategy.DEFAULT_DWELL_MS));
    }

    public static final void setSyncNativeToJava(boolean z) {
        _syncNativeToJava.set(z);
    }

    public static final void setTraceSampleRate(int i10) {
        _traceSampleRate.set(h.a0(i10, 0, 100));
    }

    public static final boolean shouldLog(LogLevel level, LogModule module) {
        g.f(level, "level");
        g.f(module, "module");
        if (isModuleEnabled(module)) {
            return level.getPriority() >= getModuleLevel(module).getPriority();
        }
        return false;
    }

    public static final boolean shouldTrace() {
        int traceSampleRate;
        if (!getEnableTrace()) {
            return false;
        }
        if (getEnableTraceSampling() && (traceSampleRate = getTraceSampleRate()) < 100) {
            return traceSampleRate > 0 && System.nanoTime() % ((long) 100) < ((long) traceSampleRate);
        }
        return true;
    }

    public static /* synthetic */ void getBufferSize$annotations() {
    }

    public static /* synthetic */ void getEnableBuffer$annotations() {
    }

    public static /* synthetic */ void getEnableFilePersistence$annotations() {
    }

    public static /* synthetic */ void getEnableLogcat$annotations() {
    }

    public static /* synthetic */ void getEnableNativeLog$annotations() {
    }

    public static /* synthetic */ void getEnablePerformanceLog$annotations() {
    }

    public static /* synthetic */ void getEnableSystrace$annotations() {
    }

    public static /* synthetic */ void getEnableTrace$annotations() {
    }

    public static /* synthetic */ void getEnableTraceLog$annotations() {
    }

    public static /* synthetic */ void getEnableTraceSampling$annotations() {
    }

    public static /* synthetic */ void getGlobalLogLevel$annotations() {
    }

    public static /* synthetic */ void getLogFilePath$annotations() {
    }

    public static /* synthetic */ void getMaxFileCount$annotations() {
    }

    public static /* synthetic */ void getMaxFileSize$annotations() {
    }

    public static /* synthetic */ void getMaxMessageLength$annotations() {
    }

    public static /* synthetic */ void getSlowOperationThresholdMs$annotations() {
    }

    public static /* synthetic */ void getSyncNativeToJava$annotations() {
    }

    public static /* synthetic */ void getTraceSampleRate$annotations() {
    }
}
