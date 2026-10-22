package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntentExecutionRecord f18557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AOAgentRobotsTools.TargetAppGrant f18559c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18557a, r6.f18557a) == true) goto L12;
        return false;
    L12:
        if (this.f18558b == r6.f18558b) goto L15;
        return false;
    L15:
        if (o.a(this.f18559c, r6.f18559c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f18557a.hashCode() * 31) + Integer.hashCode(this.f18558b)) * 31;
        AOAgentRobotsTools.TargetAppGrant r2 = this.f18559c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ToolAuditRecord(record=" + this.f18557a + ", metaIndex=" + this.f18558b + ", targetAppGrant=" + this.f18559c + ')';
    }

    public h(IntentExecutionRecord r2, int r3, AOAgentRobotsTools.TargetAppGrant r4) {
        o.e(r2, "record");
        this.f18557a = r2;
        this.f18558b = r3;
        this.f18559c = r4;
    }

    public /* synthetic */ h(IntentExecutionRecord r1, int r2, AOAgentRobotsTools.TargetAppGrant r3, int r4, d.h.b.h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final IntentExecutionRecord a() {
        return this.f18557a;
    }

    public final int b() {
        return this.f18558b;
    }

    public final AOAgentRobotsTools.TargetAppGrant c() {
        return this.f18559c;
    }
}
