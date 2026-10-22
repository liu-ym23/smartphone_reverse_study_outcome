package com.obric.autogui.agents.scripted.a;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: NextScriptParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("execResult")
    private final b f26865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("blockedImplementNameList")
    private final JsonArray f26866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(ObricMemoryConstants.KEY_SESSION_ID)
    private final String f26867c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26865a, r6.f26865a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26866b, r6.f26866b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26867c, r6.f26867c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        b r0 = this.f26865a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JsonArray r4 = this.f26866b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26867c;
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
        return "NextScriptParams(execResult=" + this.f26865a + ", blockedImplementNameList=" + this.f26866b + ", sessionId=" + this.f26867c + ')';
    }

    public f(b r1, JsonArray r2, String r3) {
        this.f26865a = r1;
        this.f26866b = r2;
        this.f26867c = r3;
    }
}
