package com.stepos.ability.runtime.model;

import S7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.beaninternal.ability.AbilityTask;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b!\u0010 J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\"\u0010#Jf\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010\u001dJ\u001a\u0010,\u001a\u00020+2\b\u0010\u0013\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b5\u0010\u001dR\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u00108R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\b:\u0010 R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00109\u001a\u0004\b;\u0010 R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010#¨\u0006>"}, d2 = {"Lcom/stepos/ability/runtime/model/CoroutinePriorityTask;", "", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "callTool", "Lcom/stepos/ability/api/ability/monitor/IMonitor;", "monitor", "Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "baseTask", "", "priority", "retryCount", "", "createTime", "timeoutMs", "Lkotlin/Function0;", "LC7/r;", "onFinish", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/api/ability/calltool/ICallTool;Lcom/stepos/ability/api/ability/monitor/IMonitor;Lcom/stepos/ability/beaninternal/ability/AbilityTask;IIJJLS7/a;)V", "other", "compareTo", "(Lcom/stepos/ability/runtime/model/CoroutinePriorityTask;)I", "component1", "()Lcom/stepos/ability/api/ability/calltool/ICallTool;", "component2", "()Lcom/stepos/ability/api/ability/monitor/IMonitor;", "component3", "()Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "component4", "()I", "component5", "component6", "()J", "component7", "component8", "()LS7/a;", "copy", "(Lcom/stepos/ability/api/ability/calltool/ICallTool;Lcom/stepos/ability/api/ability/monitor/IMonitor;Lcom/stepos/ability/beaninternal/ability/AbilityTask;IIJJLS7/a;)Lcom/stepos/ability/runtime/model/CoroutinePriorityTask;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "getCallTool", "Lcom/stepos/ability/api/ability/monitor/IMonitor;", "getMonitor", "Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "getBaseTask", "I", "getPriority", "getRetryCount", "setRetryCount", "(I)V", "J", "getCreateTime", "getTimeoutMs", "LS7/a;", "getOnFinish", "runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CoroutinePriorityTask implements Comparable<CoroutinePriorityTask> {
    private final AbilityTask baseTask;
    private final ICallTool callTool;
    private final long createTime;
    private final IMonitor monitor;
    private final a onFinish;
    private final int priority;
    private int retryCount;
    private final long timeoutMs;

    public CoroutinePriorityTask(ICallTool callTool, IMonitor monitor, AbilityTask baseTask, int i, int i6, long j5, long j6, a onFinish) {
        k.f(callTool, "callTool");
        k.f(monitor, "monitor");
        k.f(baseTask, "baseTask");
        k.f(onFinish, "onFinish");
        this.callTool = callTool;
        this.monitor = monitor;
        this.baseTask = baseTask;
        this.priority = i;
        this.retryCount = i6;
        this.createTime = j5;
        this.timeoutMs = j6;
        this.onFinish = onFinish;
    }

    public static /* synthetic */ CoroutinePriorityTask copy$default(CoroutinePriorityTask coroutinePriorityTask, ICallTool iCallTool, IMonitor iMonitor, AbilityTask abilityTask, int i, int i6, long j5, long j6, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iCallTool = coroutinePriorityTask.callTool;
        }
        if ((i10 & 2) != 0) {
            iMonitor = coroutinePriorityTask.monitor;
        }
        if ((i10 & 4) != 0) {
            abilityTask = coroutinePriorityTask.baseTask;
        }
        if ((i10 & 8) != 0) {
            i = coroutinePriorityTask.priority;
        }
        if ((i10 & 16) != 0) {
            i6 = coroutinePriorityTask.retryCount;
        }
        if ((i10 & 32) != 0) {
            j5 = coroutinePriorityTask.createTime;
        }
        if ((i10 & 64) != 0) {
            j6 = coroutinePriorityTask.timeoutMs;
        }
        if ((i10 & 128) != 0) {
            aVar = coroutinePriorityTask.onFinish;
        }
        a aVar2 = aVar;
        long j10 = j6;
        long j11 = j5;
        int i11 = i6;
        AbilityTask abilityTask2 = abilityTask;
        return coroutinePriorityTask.copy(iCallTool, iMonitor, abilityTask2, i, i11, j11, j10, aVar2);
    }

    /* renamed from: component1, reason: from getter */
    public final ICallTool getCallTool() {
        return this.callTool;
    }

    /* renamed from: component2, reason: from getter */
    public final IMonitor getMonitor() {
        return this.monitor;
    }

    /* renamed from: component3, reason: from getter */
    public final AbilityTask getBaseTask() {
        return this.baseTask;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRetryCount() {
        return this.retryCount;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    /* renamed from: component8, reason: from getter */
    public final a getOnFinish() {
        return this.onFinish;
    }

    public final CoroutinePriorityTask copy(ICallTool callTool, IMonitor monitor, AbilityTask baseTask, int priority, int retryCount, long createTime, long timeoutMs, a onFinish) {
        k.f(callTool, "callTool");
        k.f(monitor, "monitor");
        k.f(baseTask, "baseTask");
        k.f(onFinish, "onFinish");
        return new CoroutinePriorityTask(callTool, monitor, baseTask, priority, retryCount, createTime, timeoutMs, onFinish);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoroutinePriorityTask)) {
            return false;
        }
        CoroutinePriorityTask coroutinePriorityTask = (CoroutinePriorityTask) other;
        return k.b(this.callTool, coroutinePriorityTask.callTool) && k.b(this.monitor, coroutinePriorityTask.monitor) && k.b(this.baseTask, coroutinePriorityTask.baseTask) && this.priority == coroutinePriorityTask.priority && this.retryCount == coroutinePriorityTask.retryCount && this.createTime == coroutinePriorityTask.createTime && this.timeoutMs == coroutinePriorityTask.timeoutMs && k.b(this.onFinish, coroutinePriorityTask.onFinish);
    }

    public final AbilityTask getBaseTask() {
        return this.baseTask;
    }

    public final ICallTool getCallTool() {
        return this.callTool;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final IMonitor getMonitor() {
        return this.monitor;
    }

    public final a getOnFinish() {
        return this.onFinish;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public int hashCode() {
        return this.onFinish.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.retryCount, androidx.constraintlayout.core.dsl.a.a(this.priority, (this.baseTask.hashCode() + ((this.monitor.hashCode() + (this.callTool.hashCode() * 31)) * 31)) * 31, 31), 31), 31, this.createTime), 31, this.timeoutMs);
    }

    public final void setRetryCount(int i) {
        this.retryCount = i;
    }

    public String toString() {
        ICallTool iCallTool = this.callTool;
        IMonitor iMonitor = this.monitor;
        AbilityTask abilityTask = this.baseTask;
        int i = this.priority;
        int i6 = this.retryCount;
        long j5 = this.createTime;
        long j6 = this.timeoutMs;
        a aVar = this.onFinish;
        StringBuilder sb = new StringBuilder("CoroutinePriorityTask(callTool=");
        sb.append(iCallTool);
        sb.append(", monitor=");
        sb.append(iMonitor);
        sb.append(", baseTask=");
        sb.append(abilityTask);
        sb.append(", priority=");
        sb.append(i);
        sb.append(", retryCount=");
        sb.append(i6);
        sb.append(", createTime=");
        sb.append(j5);
        b.y(j6, ", timeoutMs=", ", onFinish=", sb);
        sb.append(aVar);
        sb.append(")");
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(CoroutinePriorityTask other) {
        k.f(other, "other");
        int i = this.priority;
        int i6 = other.priority;
        return i != i6 ? i6 - i : k.h(this.createTime, other.createTime);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ CoroutinePriorityTask(com.stepos.ability.api.ability.calltool.ICallTool r13, com.stepos.ability.api.ability.monitor.IMonitor r14, com.stepos.ability.beaninternal.ability.AbilityTask r15, int r16, int r17, long r18, long r20, S7.a r22, int r23, kotlin.jvm.internal.e r24) {
        /*
            r12 = this;
            r0 = r23 & 8
            if (r0 == 0) goto L8
            r0 = 1000(0x3e8, float:1.401E-42)
            r5 = r0
            goto La
        L8:
            r5 = r16
        La:
            r0 = r23 & 16
            if (r0 == 0) goto L11
            r0 = 0
            r6 = r0
            goto L13
        L11:
            r6 = r17
        L13:
            r0 = r23 & 32
            if (r0 == 0) goto L1d
            long r0 = java.lang.System.currentTimeMillis()
            r7 = r0
            goto L1f
        L1d:
            r7 = r18
        L1f:
            r0 = r23 & 64
            if (r0 == 0) goto L2e
            r0 = 300000(0x493e0, double:1.482197E-318)
            r9 = r0
            r2 = r13
            r3 = r14
            r4 = r15
            r11 = r22
            r1 = r12
            goto L36
        L2e:
            r9 = r20
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r11 = r22
        L36:
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.runtime.model.CoroutinePriorityTask.<init>(com.stepos.ability.api.ability.calltool.ICallTool, com.stepos.ability.api.ability.monitor.IMonitor, com.stepos.ability.beaninternal.ability.AbilityTask, int, int, long, long, S7.a, int, kotlin.jvm.internal.e):void");
    }
}
