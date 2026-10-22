package com.obric.structure.omvvm.core.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.extension.QConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/obric/structure/omvvm/core/util/QExecutor;", "", "()V", "mainHandler", "Landroid/os/Handler;", "workHandler", "getWorkHandler", "()Landroid/os/Handler;", "main", "setWork", "", "handler", "work", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QExecutor {
    public static final QExecutor INSTANCE = null;
    private static Handler mainHandler;
    private static volatile Handler workHandler;

    private QExecutor() {
    }

    private final Handler getWorkHandler() {
        if (workHandler != null) goto L10;
        QConfig r0 = Q.INSTANCE.getCig$omvvm_core_release();
        if (r0 == null) goto L7;
        Handler r1 = r0.handler();
    L8:
        workHandler = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return workHandler;
    }

    static {
        INSTANCE = new QExecutor();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public final Handler work() {
        if (getWorkHandler() != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (INSTANCE.getWorkHandler() != null) goto L8;
        HandlerThread r0 = new HandlerThread("QWorkThread");     // Catch: Throwable -> L11
        r0.start();     // Catch: Throwable -> L11
        workHandler = new Handler(r0.getLooper());     // Catch: Throwable -> L11
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        Handler r2 = getWorkHandler();
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final Handler main() {
        return mainHandler;
    }

    public final void setWork(Handler r1) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        workHandler = r1;
    }
}
