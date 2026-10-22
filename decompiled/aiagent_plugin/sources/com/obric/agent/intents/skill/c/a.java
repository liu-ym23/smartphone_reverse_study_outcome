package com.obric.agent.intents.skill.c;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.virt.api.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IOVirtService f14899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14900b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14899a, r6.f14899a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14900b, r6.f14900b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f14899a.hashCode() * 31) + this.f14900b.hashCode();
    }

    public String toString() {
        return "OVirtActionContext(service=" + this.f14899a + ", uniqueId=" + this.f14900b + ')';
    }

    public a(IOVirtService r3, String r4) {
        IOVirtService r5 = (IOVirtService) ZeusTransformUtils.wrapperContextForParams(r3, IOVirtService.class, "com.obric.aiagent.plugin");
        o.e(r5, WsConstants.KEY_SERVICE);
        o.e(r4, "uniqueId");
        this.f14899a = r5;
        this.f14900b = r4;
    }

    public final IOVirtService a() {
        return this.f14899a;
    }

    public final String b() {
        return this.f14900b;
    }

    public final y c() {
        y r1 = this.f14899a.getTask().paths(this.f14900b);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("OVirt changed".toString());
    }
}
