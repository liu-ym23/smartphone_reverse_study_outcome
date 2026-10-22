package com.stepos.core.common.log;

import com.stepos.core.common.log.LogEntry;
import gc.n;
import gc.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeLogBridge {
    public static final NativeLogBridge INSTANCE = new NativeLogBridge();
    private static final String TAG = "NativeLogBridge";
    private static volatile boolean isInitialized;
    private static volatile boolean isLibraryLoaded;

    static {
        try {
            System.loadLibrary("aiengine_log");
            isLibraryLoaded = true;
        } catch (UnsatisfiedLinkError e10) {
            a0.a.A("Failed to load native library: ", e10.getMessage(), TAG);
        }
    }

    private NativeLogBridge() {
    }

    public static final void clearNativeLogs() {
        if (isInitialized) {
            try {
                INSTANCE.nativeClearLogs();
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.NATIVE, "Failed to clear native logs", e10);
            }
        }
    }

    public static final List<LogEntry> getNativeLogs() {
        if (!isInitialized) {
            return EmptyList.f10001a;
        }
        try {
            String[] strArrNativeGetLogs = INSTANCE.nativeGetLogs();
            ArrayList arrayList = new ArrayList(strArrNativeGetLogs.length);
            for (String str : strArrNativeGetLogs) {
                arrayList.add(INSTANCE.parseNativeLogEntry(str));
            }
            return arrayList;
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.NATIVE, "Failed to get native logs", e10);
            return EmptyList.f10001a;
        }
    }

    public static final void initialize(boolean z, int i10) {
        if (isInitialized) {
            return;
        }
        if (!isLibraryLoaded) {
            AIEngineLogger.w(LogModule.NATIVE, "Native library not loaded, bridge disabled");
            return;
        }
        try {
            INSTANCE.nativeInit(z, i10);
            isInitialized = true;
            AIEngineLogger.i(LogModule.NATIVE, "Native log bridge initialized");
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.NATIVE, "Failed to initialize native log bridge", e10);
        } catch (UnsatisfiedLinkError e11) {
            AIEngineLogger.w(LogModule.NATIVE, "Native library not loaded, bridge disabled", e11);
        }
    }

    public static /* synthetic */ void initialize$default(boolean z, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z = true;
        }
        if ((i11 & 2) != 0) {
            i10 = 256;
        }
        initialize(z, i10);
    }

    private final native void nativeClearLogs();

    private final native String[] nativeGetLogs();

    private final native void nativeInit(boolean z, int i10);

    private final native void nativeSetLogLevel(int i10);

    private final native void nativeSetModuleEnabled(int i10, boolean z);

    private final native void nativeShutdown();

    public static final void onNativeLog(long j10, long j11, int i10, int i11, String tag, String message) {
        g.f(tag, "tag");
        g.f(message, "message");
        AIEngineLogger.logFromNative(j10, j11, i10, i11, tag, message);
    }

    private final LogEntry parseNativeLogEntry(String str) {
        List listD0 = q.D0(str, new String[]{"|"}, 2);
        if (listD0.size() < 6) {
            return LogEntry.Companion.createFromNative(System.currentTimeMillis(), 0L, LogLevel.DEBUG.getPriority(), LogModule.NATIVE.getNativeId(), "", str);
        }
        LogEntry.Companion companion = LogEntry.Companion;
        Long lD0 = n.d0((String) listD0.get(0));
        long jLongValue = lD0 != null ? lD0.longValue() : System.currentTimeMillis();
        Long lD02 = n.d0((String) listD0.get(1));
        long jLongValue2 = lD02 != null ? lD02.longValue() : 0L;
        Integer numC0 = n.c0((String) listD0.get(2));
        int iIntValue = numC0 != null ? numC0.intValue() : LogLevel.DEBUG.getPriority();
        Integer numC02 = n.c0((String) listD0.get(3));
        return companion.createFromNative(jLongValue, jLongValue2, iIntValue, numC02 != null ? numC02.intValue() : LogModule.NATIVE.getNativeId(), (String) listD0.get(4), (String) listD0.get(5));
    }

    public static final void setNativeLogLevel(LogLevel level) {
        g.f(level, "level");
        if (isInitialized) {
            try {
                INSTANCE.nativeSetLogLevel(level.getPriority());
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.NATIVE, "Failed to set native log level", e10);
            }
        }
    }

    public static final void setNativeModuleEnabled(LogModule module, boolean z) {
        g.f(module, "module");
        if (isInitialized) {
            try {
                INSTANCE.nativeSetModuleEnabled(module.getNativeId(), z);
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.NATIVE, "Failed to set native module enabled", e10);
            }
        }
    }

    public static final void shutdown() {
        if (isInitialized) {
            try {
                INSTANCE.nativeShutdown();
                isInitialized = false;
            } catch (Exception e10) {
                AIEngineLogger.e(LogModule.NATIVE, "Failed to shutdown native log", e10);
            }
        }
    }
}
