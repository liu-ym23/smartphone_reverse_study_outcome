package com.stepos.ability.monitor;

import android.content.Context;
import android.util.Log;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.beaninternal.ability.AbilityCallerContext;
import com.stepos.ability.monitor.model.MonitorRecordItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.q0;
import s9.C1923c;
import u9.c;
import u9.d;

/* loaded from: classes3.dex */
public final class a implements IMonitor {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3207a = new ConcurrentLinkedQueue();
    public q0 b;
    public final C1923c c;

    public a() {
        d dVar = AbstractC1691I.f5315a;
        this.c = AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
    }

    public static void a(ArrayList arrayList) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Log.i("MonitorImpl", "Upload log: " + ((MonitorRecordItem) it.next()));
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        Log.i("MonitorImpl", "Upload " + arrayList.size() + " logs, cost " + jCurrentTimeMillis2 + " ms.");
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void destroy() {
        Log.i("MonitorImpl", "Monitor destroy.");
        q0 q0Var = this.b;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        AbstractC1683A.e(this.c, null);
        ArrayList arrayList = new ArrayList();
        while (true) {
            MonitorRecordItem monitorRecordItem = (MonitorRecordItem) this.f3207a.poll();
            if (monitorRecordItem == null) {
                break;
            }
            arrayList.add(monitorRecordItem);
            if (arrayList.size() >= 100) {
                a(arrayList);
                arrayList.clear();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        a(arrayList);
    }

    @Override // com.stepos.ability.api.ability.monitor.IMonitor
    public final void onTaskResult(Long l, String pkgName, String method, String taskCode, AbilityCallerContext abilityCallerContext, long j5, long j6, String taskStatus, String str) {
        String toSign;
        String toPkg;
        String fromSign;
        String fromPkg;
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(taskCode, "taskCode");
        k.f(taskStatus, "taskStatus");
        this.f3207a.offer(new MonitorRecordItem(l, pkgName, method, taskCode, (abilityCallerContext == null || (fromPkg = abilityCallerContext.getFromPkg()) == null) ? "" : fromPkg, (abilityCallerContext == null || (fromSign = abilityCallerContext.getFromSign()) == null) ? "" : fromSign, (abilityCallerContext == null || (toPkg = abilityCallerContext.getToPkg()) == null) ? "" : toPkg, (abilityCallerContext == null || (toSign = abilityCallerContext.getToSign()) == null) ? "" : toSign, abilityCallerContext != null ? abilityCallerContext.getTaskStartTime() : 0L, j5, j6, taskStatus, str));
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void setup(Context context) {
        k.f(context, "context");
        Log.i("MonitorImpl", "Monitor setup.");
        if (this.b != null) {
            return;
        }
        this.b = AbstractC1683A.n(this.c, null, new MonitorImpl$startUploadLoop$1(this, null), 3);
    }
}
