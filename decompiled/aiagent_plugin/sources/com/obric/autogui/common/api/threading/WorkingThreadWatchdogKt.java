package com.obric.autogui.common.api.threading;

import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: WorkingThreadWatchdog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkingThreadWatchdogKt {
    private static final List<String> IDLE_STACK_MARKERS = null;

    public static final /* synthetic */ List access$getIDLE_STACK_MARKERS$p() {
        return IDLE_STACK_MARKERS;
    }

    static {
        IDLE_STACK_MARKERS = p.b(new String[]{"ThreadPoolExecutor.getTask", "LinkedBlockingQueue.take"});
    }
}
