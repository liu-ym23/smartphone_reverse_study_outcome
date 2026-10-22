package com.stepos.core.common.log;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogEntry {
    public static final Companion Companion = new Companion(null);
    private static final SimpleDateFormat FULL_TIME_FORMAT;
    private static final SimpleDateFormat TIME_FORMAT;
    private final Map<String, Object> extras;
    private final boolean isFromNative;
    private final LogLevel level;
    private final String message;
    private final LogModule module;
    private final String tag;
    private final long threadId;
    private final String threadName;
    private final Throwable throwable;
    private final long timestamp;
    private final long timestampNanos;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LogEntry create$default(Companion companion, LogLevel logLevel, LogModule logModule, String str, String str2, Throwable th, Map map, int i10, Object obj) {
            if ((i10 & 16) != 0) {
                th = null;
            }
            if ((i10 & 32) != 0) {
                map = null;
            }
            return companion.create(logLevel, logModule, str, str2, th, map);
        }

        public final LogEntry create(LogLevel level, LogModule module, String tag, String message, Throwable th, Map<String, ? extends Object> map) {
            g.f(level, "level");
            g.f(module, "module");
            g.f(tag, "tag");
            g.f(message, "message");
            Thread threadCurrentThread = Thread.currentThread();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jNanoTime = System.nanoTime();
            long id2 = threadCurrentThread.getId();
            String name = threadCurrentThread.getName();
            g.e(name, "getName(...)");
            return new LogEntry(jCurrentTimeMillis, jNanoTime, id2, name, level, module, tag, message, th, false, map);
        }

        public final LogEntry createFromNative(long j10, long j11, int i10, int i11, String tag, String message) {
            g.f(tag, "tag");
            g.f(message, "message");
            String strF = com.stepos.core.ota.d.f(j11, "native-");
            LogLevel logLevelFromPriority = LogLevel.Companion.fromPriority(i10);
            LogModule logModuleFromNativeId = LogModule.Companion.fromNativeId(i11);
            if (logModuleFromNativeId == null) {
                logModuleFromNativeId = LogModule.NATIVE;
            }
            return new LogEntry(j10, 0L, j11, strF, logLevelFromPriority, logModuleFromNativeId, tag, message, null, true, null);
        }

        private Companion() {
        }
    }

    static {
        Locale locale = Locale.US;
        TIME_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS", locale);
        FULL_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale);
    }

    public LogEntry(long j10, long j11, long j12, String threadName, LogLevel level, LogModule module, String tag, String message, Throwable th, boolean z, Map<String, ? extends Object> map) {
        g.f(threadName, "threadName");
        g.f(level, "level");
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        this.timestamp = j10;
        this.timestampNanos = j11;
        this.threadId = j12;
        this.threadName = threadName;
        this.level = level;
        this.module = module;
        this.tag = tag;
        this.message = message;
        this.throwable = th;
        this.isFromNative = z;
        this.extras = map;
    }

    public static final LogEntry create(LogLevel logLevel, LogModule logModule, String str, String str2, Throwable th, Map<String, ? extends Object> map) {
        return Companion.create(logLevel, logModule, str, str2, th, map);
    }

    public static final LogEntry createFromNative(long j10, long j11, int i10, int i11, String str, String str2) {
        return Companion.createFromNative(j10, j11, i10, i11, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatFull$lambda$3$lambda$2(Map.Entry it) {
        g.f(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    public final long component1() {
        return this.timestamp;
    }

    public final boolean component10() {
        return this.isFromNative;
    }

    public final Map<String, Object> component11() {
        return this.extras;
    }

    public final long component2() {
        return this.timestampNanos;
    }

    public final long component3() {
        return this.threadId;
    }

    public final String component4() {
        return this.threadName;
    }

    public final LogLevel component5() {
        return this.level;
    }

    public final LogModule component6() {
        return this.module;
    }

    public final String component7() {
        return this.tag;
    }

    public final String component8() {
        return this.message;
    }

    public final Throwable component9() {
        return this.throwable;
    }

    public final LogEntry copy(long j10, long j11, long j12, String threadName, LogLevel level, LogModule module, String tag, String message, Throwable th, boolean z, Map<String, ? extends Object> map) {
        g.f(threadName, "threadName");
        g.f(level, "level");
        g.f(module, "module");
        g.f(tag, "tag");
        g.f(message, "message");
        return new LogEntry(j10, j11, j12, threadName, level, module, tag, message, th, z, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEntry)) {
            return false;
        }
        LogEntry logEntry = (LogEntry) obj;
        return this.timestamp == logEntry.timestamp && this.timestampNanos == logEntry.timestampNanos && this.threadId == logEntry.threadId && g.b(this.threadName, logEntry.threadName) && this.level == logEntry.level && this.module == logEntry.module && g.b(this.tag, logEntry.tag) && g.b(this.message, logEntry.message) && g.b(this.throwable, logEntry.throwable) && this.isFromNative == logEntry.isFromNative && g.b(this.extras, logEntry.extras);
    }

    public final String formatFull() {
        StringBuilder sb2 = new StringBuilder(VadSessionManager.FRAME_BYTES);
        sb2.append(formatShort());
        Throwable th = this.throwable;
        if (th != null) {
            sb2.append('\n');
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            g.e(string, "toString(...)");
            sb2.append(q.N0(string).toString());
        }
        Map<String, Object> map = this.extras;
        if (map != null) {
            if (map.isEmpty()) {
                map = null;
            }
            if (map != null) {
                sb2.append("\n    extras: ");
                sb2.append(kotlin.collections.a.z0(map.entrySet(), ", ", null, null, new b6.e(27), 30));
            }
        }
        String string2 = sb2.toString();
        g.e(string2, "toString(...)");
        return string2;
    }

    public final String formatShort() {
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append('[');
        sb2.append(TIME_FORMAT.format(new Date(this.timestamp)));
        sb2.append("] ");
        sb2.append(this.level.getTag());
        sb2.append('/');
        sb2.append(this.module.getModuleTag());
        if (!q.t0(this.tag) && !g.b(this.tag, this.module.getModuleTag())) {
            sb2.append('_');
            sb2.append(this.tag);
        }
        sb2.append(" [");
        sb2.append(this.threadName);
        sb2.append("] ");
        sb2.append(this.message);
        if (this.isFromNative) {
            sb2.append(" (native)");
        }
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final String getFormattedTime() {
        String str = TIME_FORMAT.format(new Date(this.timestamp));
        g.e(str, "format(...)");
        return str;
    }

    public final String getFullFormattedTime() {
        String str = FULL_TIME_FORMAT.format(new Date(this.timestamp));
        g.e(str, "format(...)");
        return str;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public final String getLogcatTag() {
        LogModule.Companion companion = LogModule.Companion;
        LogModule logModule = this.module;
        String str = this.tag;
        if (q.t0(str) || g.b(str, this.module.getModuleTag())) {
            str = null;
        }
        return companion.getFullTag(logModule, str);
    }

    public final String getMessage() {
        return this.message;
    }

    public final LogModule getModule() {
        return this.module;
    }

    public final String getTag() {
        return this.tag;
    }

    public final long getThreadId() {
        return this.threadId;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getTimestampNanos() {
        return this.timestampNanos;
    }

    public int hashCode() {
        int iA = v1.d.a(v1.d.a((this.module.hashCode() + ((this.level.hashCode() + v1.d.a(a0.a.c(a0.a.c(Long.hashCode(this.timestamp) * 31, this.timestampNanos, 31), this.threadId, 31), 31, this.threadName)) * 31)) * 31, 31, this.tag), 31, this.message);
        Throwable th = this.throwable;
        int iF = ai.onnxruntime.a.f((iA + (th == null ? 0 : th.hashCode())) * 31, 31, this.isFromNative);
        Map<String, Object> map = this.extras;
        return iF + (map != null ? map.hashCode() : 0);
    }

    public final boolean isFromNative() {
        return this.isFromNative;
    }

    public final String toLogcatMessage() {
        if (this.throwable == null) {
            return this.message;
        }
        StringWriter stringWriter = new StringWriter();
        this.throwable.printStackTrace(new PrintWriter(stringWriter));
        String str = this.message;
        String string = stringWriter.toString();
        g.e(string, "toString(...)");
        return com.stepos.core.ota.d.i(str, "\n", q.N0(string).toString());
    }

    public String toString() {
        long j10 = this.timestamp;
        long j11 = this.timestampNanos;
        long j12 = this.threadId;
        String str = this.threadName;
        LogLevel logLevel = this.level;
        LogModule logModule = this.module;
        String str2 = this.tag;
        String str3 = this.message;
        Throwable th = this.throwable;
        boolean z = this.isFromNative;
        Map<String, Object> map = this.extras;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "LogEntry(timestamp=", ", timestampNanos=");
        sbQ.append(j11);
        a0.a.s(j12, ", threadId=", ", threadName=", sbQ);
        sbQ.append(str);
        sbQ.append(", level=");
        sbQ.append(logLevel);
        sbQ.append(", module=");
        sbQ.append(logModule);
        sbQ.append(", tag=");
        sbQ.append(str2);
        sbQ.append(", message=");
        sbQ.append(str3);
        sbQ.append(", throwable=");
        sbQ.append(th);
        sbQ.append(", isFromNative=");
        sbQ.append(z);
        sbQ.append(", extras=");
        sbQ.append(map);
        sbQ.append(")");
        return sbQ.toString();
    }

    public /* synthetic */ LogEntry(long j10, long j11, long j12, String str, LogLevel logLevel, LogModule logModule, String str2, String str3, Throwable th, boolean z, Map map, int i10, e eVar) {
        this(j10, j11, j12, str, logLevel, logModule, str2, str3, (i10 & 256) != 0 ? null : th, (i10 & VadSessionManager.FRAME_BYTES) != 0 ? false : z, (i10 & 1024) != 0 ? null : map);
    }
}
