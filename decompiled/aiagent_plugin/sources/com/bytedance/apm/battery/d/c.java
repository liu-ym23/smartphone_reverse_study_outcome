package com.bytedance.apm.battery.d;

import android.content.Context;
import com.bytedance.apm.battery.d.a.b;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AbsHookStatsTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends com.bytedance.apm.battery.d.a.b> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile long f4304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f4305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f4306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ConcurrentHashMap<Integer, T> f4307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4308e;

    public abstract void a(T r1, long r2, long r4);

    c(String r3) {
        this.f4307d = new ConcurrentHashMap();
        this.f4308e = r3;
        this.f4305b = ActivityLifeObserver.getInstance().isForeground();
        this.f4304a = System.currentTimeMillis();
        this.f4306c = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public String getType() {
        return this.f4308e;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void b(boolean r1) {
        this.f4305b = true;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r1) {
        this.f4305b = false;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void c(boolean r9) {
        long r6 = System.currentTimeMillis();
        if (this.f4307d.size() == 0) goto L5;
        a(this.f4304a, r6, r9);
    L5:
        this.f4304a = r6;
    }

    public void a(long r8, long r10, boolean r12) {
        Iterator<Map.Entry<Integer, T>> r13 = this.f4307d.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        com.bytedance.apm.battery.d.a.b r2 = (com.bytedance.apm.battery.d.a.b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.bytedance.apm.battery.d.a.b.class, "com.obric.aiagent.plugin");
        if (0 >= r2.f4296e) goto L11;
        if (r2.f4296e >= r2.f4295d) goto L11;
        r13.remove();
    L11:
        if (0 >= r2.f4296e) goto L16;
        if (r2.f4296e >= r8) goto L16;
        r13.remove();
    L16:
        if (r10 < r2.f4295d) goto L4;
        a(r2, r8, r10);
        goto L4
    }
}
