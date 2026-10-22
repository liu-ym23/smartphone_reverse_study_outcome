package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEgressModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AttemptedOutboundTarget {
    private final long count;
    private final OutboundTarget target;

    public static /* synthetic */ AttemptedOutboundTarget copy$default(AttemptedOutboundTarget r0, OutboundTarget r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.count;
    L9:
        return r0.copy(r1, r2);
    }

    public final OutboundTarget component1() {
        return this.target;
    }

    public final long component2() {
        return this.count;
    }

    public final AttemptedOutboundTarget copy(OutboundTarget r1, long r2) {
        o.e(r1, "target");
        return new AttemptedOutboundTarget(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, AttemptedOutboundTarget.class) == true) goto L8;
        return false;
    L8:
        AttemptedOutboundTarget r8 = (AttemptedOutboundTarget) ZeusTransformUtils.preCheckCast(r7, AttemptedOutboundTarget.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r8.target) == true) goto L12;
        return false;
    L12:
        if (this.count == r8.count) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.target.hashCode() * 31) + Long.hashCode(this.count);
    }

    public String toString() {
        return "AttemptedOutboundTarget(target=" + this.target + ", count=" + this.count + ')';
    }

    public AttemptedOutboundTarget(OutboundTarget r2, long r3) {
        o.e(r2, "target");
        this.target = r2;
        this.count = r3;
        if (r3 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Attempt count must be positive".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final OutboundTarget getTarget() {
        return this.target;
    }

    public final long getCount() {
        return this.count;
    }
}
