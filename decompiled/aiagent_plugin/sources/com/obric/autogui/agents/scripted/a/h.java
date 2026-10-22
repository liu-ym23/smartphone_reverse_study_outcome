package com.obric.autogui.agents.scripted.a;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PreCheckParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("packageName")
    private final String f26869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("activity")
    private final String f26870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("commonContext")
    private final JsonObject f26871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("appList")
    private final List<String> f26872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("abParams")
    private final JsonObject f26873e;

    @SerializedName(ObricMemoryConstants.KEY_SESSION_ID)
    private final String f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26869a, r6.f26869a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26870b, r6.f26870b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26871c, r6.f26871c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26872d, r6.f26872d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26873e, r6.f26873e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26869a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f26870b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonObject r7 = this.f26871c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.f26872d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        JsonObject r13 = this.f26873e;
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
        return "PreCheckParams(packageName=" + this.f26869a + ", activity=" + this.f26870b + ", commonContext=" + this.f26871c + ", appList=" + this.f26872d + ", abParams=" + this.f26873e + ", sessionId=" + this.f + ')';
    }

    public h(String r3, String r4, JsonObject r5, List<String> r6, JsonObject r7, String r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f26869a = r3;
        this.f26870b = r4;
        this.f26871c = r5;
        this.f26872d = r9;
        this.f26873e = r7;
        this.f = r8;
    }

    public final String getActivity() {
        return this.f26870b;
    }
}
