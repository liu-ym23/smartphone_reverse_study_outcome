package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StartSidecarSessionRequest {
    private final String cliName;
    private final Long ttlSeconds;

    public static /* synthetic */ StartSidecarSessionRequest copy$default(StartSidecarSessionRequest r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.cliName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.ttlSeconds;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.cliName;
    }

    public final Long component2() {
        return this.ttlSeconds;
    }

    public final StartSidecarSessionRequest copy(String r1, Long r2) {
        o.e(r1, "cliName");
        return new StartSidecarSessionRequest(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StartSidecarSessionRequest.class) == true) goto L8;
        return false;
    L8:
        StartSidecarSessionRequest r6 = (StartSidecarSessionRequest) ZeusTransformUtils.preCheckCast(r5, StartSidecarSessionRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.cliName, r6.cliName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.ttlSeconds, r6.ttlSeconds) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.cliName.hashCode() * 31;
        Long r1 = this.ttlSeconds;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "StartSidecarSessionRequest(cliName=" + this.cliName + ", ttlSeconds=" + this.ttlSeconds + ')';
    }

    public StartSidecarSessionRequest(String r2, Long r3) {
        o.e(r2, "cliName");
        this.cliName = r2;
        this.ttlSeconds = r3;
    }

    public /* synthetic */ StartSidecarSessionRequest(String r1, Long r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final String getCliName() {
        return this.cliName;
    }

    public final Long getTtlSeconds() {
        return this.ttlSeconds;
    }
}
