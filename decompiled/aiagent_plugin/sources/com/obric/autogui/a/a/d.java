package com.obric.autogui.a.a;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskQueryResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IAutoActionRemoteAgentApi.ErrorType f26112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26116e;

    public d() {
        this(null, 0, null, 0, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f26112a == r6.f26112a) goto L12;
        return false;
    L12:
        if (this.f26113b == r6.f26113b) goto L15;
        return false;
    L15:
        if (o.a(this.f26114c, r6.f26114c) == true) goto L18;
        return false;
    L18:
        if (this.f26115d == r6.f26115d) goto L21;
        return false;
    L21:
        if (o.a(this.f26116e, r6.f26116e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f26112a.hashCode() * 31) + Integer.hashCode(this.f26113b)) * 31) + this.f26114c.hashCode()) * 31) + Integer.hashCode(this.f26115d)) * 31) + this.f26116e.hashCode();
    }

    public String toString() {
        return "TaskQueryResponse(errorType=" + this.f26112a + ", taskStatus=" + this.f26113b + ", sessionId=" + this.f26114c + ", queueNum=" + this.f26115d + ", modelName=" + this.f26116e + ')';
    }

    public d(IAutoActionRemoteAgentApi.ErrorType r2, int r3, String r4, int r5, String r6) {
        o.e(r2, "errorType");
        o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r6, "modelName");
        this.f26112a = r2;
        this.f26113b = r3;
        this.f26114c = r4;
        this.f26115d = r5;
        this.f26116e = r6;
    }

    public /* synthetic */ d(IAutoActionRemoteAgentApi.ErrorType r4, int r5, String r6, int r7, String r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = IAutoActionRemoteAgentApi.ErrorType.Succeeded;
    L5:
        int r0 = 0;
        if ((r9 & 2) == 0) goto L8;
        int r11 = 0;
    L9:
        String r1 = "";
        if ((r9 & 4) == 0) goto L12;
        String r2 = "";
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r1 = r8;
    L21:
        this(r4, r11, r2, r0, r1);
        return;
    L12:
        r2 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L9
    }

    public final IAutoActionRemoteAgentApi.ErrorType a() {
        return this.f26112a;
    }

    public final int b() {
        return this.f26113b;
    }

    public final String c() {
        return this.f26114c;
    }

    public final int d() {
        return this.f26115d;
    }
}
