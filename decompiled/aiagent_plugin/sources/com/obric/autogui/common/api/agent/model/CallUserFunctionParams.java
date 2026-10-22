package com.obric.autogui.common.api.agent.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FunctionParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CallUserFunctionParams {
    private final String action;
    private final String content;
    private final String reason;
    private final String securityLevel;
    private final boolean supportsUserAddition;

    public static /* synthetic */ CallUserFunctionParams copy$default(CallUserFunctionParams r3, boolean r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.supportsUserAddition;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.action;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.content;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.reason;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.securityLevel;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.supportsUserAddition;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.reason;
    }

    public final String component5() {
        return this.securityLevel;
    }

    public final CallUserFunctionParams copy(boolean r7, String r8, String r9, String r10, String r11) {
        return new CallUserFunctionParams(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CallUserFunctionParams.class) == true) goto L8;
        return false;
    L8:
        CallUserFunctionParams r6 = (CallUserFunctionParams) ZeusTransformUtils.preCheckCast(r5, CallUserFunctionParams.class, "com.obric.aiagent.plugin");
        if (this.supportsUserAddition == r6.supportsUserAddition) goto L12;
        return false;
    L12:
        if (o.a(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (o.a(this.reason, r6.reason) == true) goto L21;
        return false;
    L21:
        if (o.a(this.securityLevel, r6.securityLevel) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.supportsUserAddition) * 31;
        String r1 = this.action;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.content;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.reason;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.securityLevel;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CallUserFunctionParams(supportsUserAddition=" + this.supportsUserAddition + ", action=" + this.action + ", content=" + this.content + ", reason=" + this.reason + ", securityLevel=" + this.securityLevel + ')';
    }

    public CallUserFunctionParams(boolean r1, String r2, String r3, String r4, String r5) {
        this.supportsUserAddition = r1;
        this.action = r2;
        this.content = r3;
        this.reason = r4;
        this.securityLevel = r5;
    }

    public /* synthetic */ CallUserFunctionParams(boolean r7, String r8, String r9, String r10, String r11, int r12, h r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final boolean getSupportsUserAddition() {
        return this.supportsUserAddition;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSecurityLevel() {
        return this.securityLevel;
    }
}
