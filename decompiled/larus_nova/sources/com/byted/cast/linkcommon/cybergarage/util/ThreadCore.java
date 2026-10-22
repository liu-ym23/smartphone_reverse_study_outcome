package com.byted.cast.linkcommon.cybergarage.util;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class ThreadCore implements Runnable {
    private Thread mThreadObject;

    public void com_byted_cast_linkcommon_cybergarage_util_ThreadCore__run$___twin___() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_util_ThreadCore_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public ThreadCore() {
        this.mThreadObject = null;
    }

    public boolean isRunnable() {
        if (ThreadMethodProxy.currentThread() != getThreadObject()) goto L5;
        return true;
    L5:
        return false;
    }

    public void restart() {
        stop();
        start();
    }

    public void start() {
        if (getThreadObject() != null) goto L6;
        PthreadThreadV2 r100 = new PthreadThreadV2(this, "Cyber.ThreadCore");
        setThreadObject(r100);
        ThreadMethodProxy.start(r100);
        return;
    }

    public void stop() {
        Thread r100 = getThreadObject();
        if (r100 == null) goto L6;
        r100.interrupt();
        setThreadObject(null);
        return;
    }

    public Thread getThreadObject() {
        return this.mThreadObject;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_util_ThreadCore_com_larus_apm_impl_protector_RunnableLancet_run(ThreadCore r100) {
        r100.com_byted_cast_linkcommon_cybergarage_util_ThreadCore__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setThreadObject(Thread r100) {
        this.mThreadObject = r100;
    }
}
