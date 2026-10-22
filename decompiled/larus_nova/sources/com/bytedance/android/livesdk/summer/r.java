package com.bytedance.android.livesdk.summer;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.summer.ISummerTask;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, ISummerTask> f158489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashSet<Integer> f158490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<Integer> f158491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<Integer> f158492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f158493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile PThreadPoolExecutor f158494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f158495g;

    public final void b() {
        ALogger.i("BDLog", "summer triggerHighPriorityTasks");
        Iterator<Integer> r100 = this.f158491c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a(r100.next().intValue());
        goto L4
    }

    public r() {
        this.f158489a = new ConcurrentHashMap();
        this.f158490b = new ConcurrentHashSet();
        this.f158491c = new CopyOnWriteArrayList();
        this.f158492d = new CopyOnWriteArrayList();
        this.f158493e = new Handler(Looper.getMainLooper());
        this.f158494f = null;
    }

    public final void a(int r110) {
        ISummerTask r100 = this.f158489a.get(Integer.valueOf(r110));
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getTaskType() != 0) goto L9;
        this.f158493e.post(new q(this, r100, r110));
        return;
    L9:
        if (this.f158494f != null) goto L11;
        this.f158494f = new PThreadPoolExecutor(1, 5, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(50), new DefaultThreadFactory("/SummerWorker"));
        this.f158494f.allowCoreThreadTimeOut(true);
    L11:
        this.f158494f.submit(new q(this, r100, r110));
    }
}
