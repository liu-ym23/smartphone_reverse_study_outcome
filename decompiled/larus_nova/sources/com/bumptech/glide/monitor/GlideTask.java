package com.bumptech.glide.monitor;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class GlideTask implements Runnable, Comparable<GlideTask> {
    private final long mEnqueueTime;
    private final ThreadPoolExecutor mExecutor;
    private final Object mLoadModel;
    private final Runnable mOrigin;

    @Override // java.lang.Runnable
    public void run() {
        com_bumptech_glide_monitor_GlideTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bumptech_glide_monitor_GlideTask__run$___twin___() {
        GlideDispatcherMonitor.onDequeue(this.mExecutor);
        long r100 = System.currentTimeMillis();
        int r101 = (int) (r100 - this.mEnqueueTime);
        this.mOrigin.run();
        int r102 = (int) (System.currentTimeMillis() - r100);
        GlideLoadCostMonitor.onEnd(this.mLoadModel, r101, r102);
    }

    public int hashCode() {
        return this.mOrigin.hashCode();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bumptech_glide_monitor_GlideTask_com_larus_apm_impl_protector_RunnableLancet_run(GlideTask r100) {
        r100.com_bumptech_glide_monitor_GlideTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(GlideTask r100) {
        Runnable r101 = this.mOrigin;
        if ((r101 instanceof Comparable) == true) goto L5;
        return -1;
    L5:
        return ((Comparable) r101).compareTo(r100.mOrigin);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GlideTask) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrigin.equals(((GlideTask) r100).mOrigin) == false) goto L7;
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(GlideTask r100) {
        return compareTo2(r100);
    }

    public GlideTask(ThreadPoolExecutor r100, Runnable r101, Object r102) {
        this.mEnqueueTime = System.currentTimeMillis();
        this.mExecutor = r100;
        this.mOrigin = r101;
        this.mLoadModel = r102;
        GlideLoadCostMonitor.onStart(r102);
        GlideDispatcherMonitor.onEnqueue(r100, r102);
    }
}
