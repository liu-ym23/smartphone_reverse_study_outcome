package com.stepos.ability.task.scheduler;

import P3.c;
import com.stepos.ability.api.task.executor.ITaskExecutor;
import com.stepos.ability.api.task.schduler.ITaskScheduler;
import g1.AbstractC1451a;
import kotlin.jvm.internal.k;
import w9.f;
import w9.g;

/* loaded from: classes3.dex */
public final class a implements ITaskScheduler {

    /* renamed from: a, reason: collision with root package name */
    public final ITaskExecutor f3319a;
    public final f b;

    public a(ITaskExecutor taskExecutor) {
        k.f(taskExecutor, "taskExecutor");
        int iU = AbstractC1451a.u(Runtime.getRuntime().availableProcessors() * 4, 8, 32);
        this.f3319a = taskExecutor;
        int i = g.f6856a;
        this.b = new f(iU);
        String msg = "execute concurrency limit=" + iU;
        k.f(msg, "msg");
        c.f1086a.invoke(3, "Ability_".concat("TaskScheduler"), msg, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.stepos.ability.api.task.schduler.ITaskScheduler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object schedule(com.stepos.ability.bean.InternalTask r14, int r15, int r16, H7.c r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.scheduler.a.schedule(com.stepos.ability.bean.InternalTask, int, int, H7.c):java.lang.Object");
    }
}
