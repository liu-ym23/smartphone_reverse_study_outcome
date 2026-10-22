package com.obric.autogui.agents.scripted.a;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StartScriptParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("scriptName")
    private final String f26886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("scriptParams")
    private final JsonObject f26887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("scriptCode")
    private final String f26888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("blockedImplementNameList")
    private final JsonArray f26889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("abParams")
    private final JsonObject f26890e;

    @SerializedName(ObricMemoryConstants.KEY_SESSION_ID)
    private final String f;

    public m() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26886a, r6.f26886a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26887b, r6.f26887b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26888c, r6.f26888c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26889d, r6.f26889d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26890e, r6.f26890e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26886a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JsonObject r4 = this.f26887b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26888c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        JsonArray r10 = this.f26889d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        JsonObject r13 = this.f26890e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "StartScriptParams(scriptName=" + this.f26886a + ", scriptParams=" + this.f26887b + ", scriptCode=" + this.f26888c + ", blockedImplementNameList=" + this.f26889d + ", abParams=" + this.f26890e + ", sessionId=" + this.f + ')';
    }

    public m(String r1, JsonObject r2, String r3, JsonArray r4, JsonObject r5, String r6) {
        this.f26886a = r1;
        this.f26887b = r2;
        this.f26888c = r3;
        this.f26889d = r4;
        this.f26890e = r5;
        this.f = r6;
    }

    public /* synthetic */ m(String r2, JsonObject r3, String r4, JsonArray r5, JsonObject r6, String r7, int r8, d.h.b.h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }
}
