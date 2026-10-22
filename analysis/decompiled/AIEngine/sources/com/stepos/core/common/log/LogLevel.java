package com.stepos.core.common.log;

import gc.o;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogLevel {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    public static final Companion Companion;
    private final int priority;
    private final String tag;
    public static final LogLevel VERBOSE = new LogLevel("VERBOSE", 0, 2, "V");
    public static final LogLevel DEBUG = new LogLevel("DEBUG", 1, 3, "D");
    public static final LogLevel INFO = new LogLevel("INFO", 2, 4, "I");
    public static final LogLevel WARN = new LogLevel("WARN", 3, 5, "W");
    public static final LogLevel ERROR = new LogLevel("ERROR", 4, 6, "E");
    public static final LogLevel ASSERT = new LogLevel("ASSERT", 5, 7, "A");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final LogLevel fromName(String name) {
            g.f(name, "name");
            try {
                String upperCase = name.toUpperCase(Locale.ROOT);
                g.e(upperCase, "toUpperCase(...)");
                return LogLevel.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return LogLevel.DEBUG;
            }
        }

        public final LogLevel fromPriority(int i10) {
            LogLevel next;
            Iterator<LogLevel> it = LogLevel.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getPriority() == i10) {
                    break;
                }
            }
            LogLevel logLevel = next;
            return logLevel == null ? LogLevel.DEBUG : logLevel;
        }

        public final LogLevel fromTag(String tag) {
            LogLevel next;
            g.f(tag, "tag");
            Iterator<LogLevel> it = LogLevel.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (o.f0(next.getTag(), tag)) {
                    break;
                }
            }
            LogLevel logLevel = next;
            return logLevel == null ? LogLevel.DEBUG : logLevel;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT};
    }

    static {
        LogLevel[] logLevelArr$values = $values();
        $VALUES = logLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(logLevelArr$values);
        Companion = new Companion(null);
    }

    private LogLevel(String str, int i10, int i11, String str2) {
        this.priority = i11;
        this.tag = str2;
    }

    public static final LogLevel fromName(String str) {
        return Companion.fromName(str);
    }

    public static final LogLevel fromPriority(int i10) {
        return Companion.fromPriority(i10);
    }

    public static final LogLevel fromTag(String str) {
        return Companion.fromTag(str);
    }

    public static sb.a<LogLevel> getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getTag() {
        return this.tag;
    }
}
