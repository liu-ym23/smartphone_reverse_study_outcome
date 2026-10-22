package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxySessionModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySessionOptions {
    private final String sessionName;

    /* JADX WARN: Multi-variable type inference failed */
    public ProxySessionOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ProxySessionOptions copy$default(ProxySessionOptions r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.sessionName;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.sessionName;
    }

    public final ProxySessionOptions copy(String r1) {
        return new ProxySessionOptions(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProxySessionOptions.class) == true) goto L8;
        return false;
    L8:
        ProxySessionOptions r6 = (ProxySessionOptions) ZeusTransformUtils.preCheckCast(r5, ProxySessionOptions.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionName, r6.sessionName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.sessionName;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ProxySessionOptions(sessionName=" + this.sessionName + ')';
    }

    public ProxySessionOptions(String r1) {
        this.sessionName = r1;
    }

    public /* synthetic */ ProxySessionOptions(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getSessionName() {
        return this.sessionName;
    }
}
