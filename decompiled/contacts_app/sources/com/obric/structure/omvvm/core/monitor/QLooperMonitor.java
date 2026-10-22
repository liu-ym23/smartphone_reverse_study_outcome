package com.obric.structure.omvvm.core.monitor;

import android.os.Looper;
import android.util.Printer;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.config.QMonitorConfig;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QLooperMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u0013\u001a\u00020\u0001J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001c\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/structure/omvvm/core/monitor/QLooperMonitor;", "", "()V", "MESSAGE_END", "", "MESSAGE_START", "PRINTER", "com/obric/structure/omvvm/core/monitor/QLooperMonitor$PRINTER$1", "Lcom/obric/structure/omvvm/core/monitor/QLooperMonitor$PRINTER$1;", "TAG", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "currentPrinter", "Landroid/util/Printer;", "getCurrentPrinter", "()Landroid/util/Printer;", "incresingtKey", "", "lock", "getLock$omvvm_core_release", "()Ljava/lang/Object;", "myLooper", "Landroid/os/Looper;", "sOriginalPrinter", "started", "", "stopped", "getInterval", "", "start", "", "looper", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QLooperMonitor {
    public static final QLooperMonitor INSTANCE = null;
    private static final String MESSAGE_END = null;
    private static final String MESSAGE_START = null;
    private static final QLooperMonitor$PRINTER$1 PRINTER = null;
    private static final String TAG = null;
    private static long incresingtKey;
    private static final Object lock = null;
    private static Looper myLooper;
    private static Printer sOriginalPrinter;
    private static boolean started;
    private static boolean stopped;

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    private QLooperMonitor() {
    }

    public static final /* synthetic */ long access$getIncresingtKey$p() {
        return incresingtKey;
    }

    public static final /* synthetic */ String access$getMESSAGE_END$p() {
        return MESSAGE_END;
    }

    public static final /* synthetic */ String access$getMESSAGE_START$p() {
        return MESSAGE_START;
    }

    public static final /* synthetic */ Printer access$getSOriginalPrinter$p() {
        return sOriginalPrinter;
    }

    public static final /* synthetic */ boolean access$getStarted$p() {
        return started;
    }

    public static final /* synthetic */ void access$setIncresingtKey$p(long r0) {
        incresingtKey = r0;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.structure.omvvm.core.monitor.QLooperMonitor$PRINTER$1] */
    static {
        INSTANCE = new QLooperMonitor();
        lock = new Object();
        TAG = "QLooperMonitor";
        MESSAGE_START = ">>>>> Dispatching";
        MESSAGE_END = "<<<<< Finished";
        PRINTER = new QLooperMonitor$PRINTER$1();
    }

    public final Object getLock$omvvm_core_release() {
        return lock;
    }

    public final Object lock() {
        return lock;
    }

    public static final String getTAG() {
        return TAG;
    }

    public final Looper myLooper() {
        return myLooper;
    }

    public final Printer getCurrentPrinter() {
        Field r1 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        Object r2 = r1.get(myLooper);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L4
        return (Printer) r2;
    L4:
        return null;
    }

    public final void start(Looper r3) {
        Intrinsics.checkNotNullParameter(r3, "looper");
        QMonitorConfig r0 = Q.INSTANCE.getMonitorCig$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        if (r0.openMonitor() == true) goto L6;
        return;
    L6:
        if (started == false) goto L8;
        return;
    L8:
        if (stopped == true) goto L28;
        started = true;
        if (Intrinsics.areEqual(sOriginalPrinter, getCurrentPrinter()) == true) goto L13;
        sOriginalPrinter = getCurrentPrinter();
    L13:
        Object r2 = lock;
        monitor-enter(r2);
        myLooper = r3;     // Catch: Throwable -> L21
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r2);
        Looper r5 = myLooper;
        if (r5 == null) goto L27;
        r5.setMessageLogging(PRINTER);
        return;
    L27:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final int getInterval() {
        QMonitorConfig r0 = Q.INSTANCE.getMonitorCig$omvvm_core_release();
        Intrinsics.checkNotNull(r0);
        return r0.monitorInterval();
    }
}
