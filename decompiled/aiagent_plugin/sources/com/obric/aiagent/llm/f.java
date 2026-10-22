package com.obric.aiagent.llm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("role")
    private final String f18712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("content")
    private final String f18713b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18712a, r6.f18712a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18713b, r6.f18713b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f18712a.hashCode() * 31) + this.f18713b.hashCode();
    }

    public String toString() {
        return "Message(role=" + this.f18712a + ", content=" + this.f18713b + ')';
    }

    public f(String r2, String r3) {
        o.e(r2, "role");
        o.e(r3, "content");
        this.f18712a = r2;
        this.f18713b = r3;
    }
}
