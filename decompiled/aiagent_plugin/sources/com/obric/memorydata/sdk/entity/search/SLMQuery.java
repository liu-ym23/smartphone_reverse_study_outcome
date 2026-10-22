package com.obric.memorydata.sdk.entity.search;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SLMQuery.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SLMQuery {

    @SerializedName("content")
    private final String content;

    @SerializedName("rewriteContent")
    private final String rewriteContent;

    @SerializedName("role")
    private final String role;

    public static /* synthetic */ SLMQuery copy$default(SLMQuery r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.role;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.rewriteContent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.role;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.rewriteContent;
    }

    public final SLMQuery copy(String r1, String r2, String r3) {
        o.e(r1, "role");
        o.e(r2, "content");
        return new SLMQuery(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SLMQuery.class) == true) goto L8;
        return false;
    L8:
        SLMQuery r6 = (SLMQuery) ZeusTransformUtils.preCheckCast(r5, SLMQuery.class, "com.obric.aiagent.plugin");
        if (o.a(this.role, r6.role) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.rewriteContent, r6.rewriteContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.role.hashCode() * 31) + this.content.hashCode()) * 31;
        String r2 = this.rewriteContent;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SLMQuery(role=" + this.role + ", content=" + this.content + ", rewriteContent=" + this.rewriteContent + ')';
    }

    public SLMQuery(String r2, String r3, String r4) {
        o.e(r2, "role");
        o.e(r3, "content");
        this.role = r2;
        this.content = r3;
        this.rewriteContent = r4;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRewriteContent() {
        return this.rewriteContent;
    }
}
