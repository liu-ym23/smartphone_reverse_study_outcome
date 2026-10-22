package com.obric.agent.intents.skill.c;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("execution_id")
    private final String f14933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("stdout_char_offset")
    private final Long f14934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("stderr_char_offset")
    private final Long f14935c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14933a, r6.f14933a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14934b, r6.f14934b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14935c, r6.f14935c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f14933a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.f14934b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.f14935c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ShellExecutionRefRequest(executionId=" + this.f14933a + ", stdoutCharOffset=" + this.f14934b + ", stderrCharOffset=" + this.f14935c + ')';
    }

    public final String a() {
        return this.f14933a;
    }

    public final Long b() {
        return this.f14934b;
    }

    public final Long c() {
        return this.f14935c;
    }
}
