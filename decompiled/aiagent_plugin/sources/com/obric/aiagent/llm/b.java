package com.obric.aiagent.llm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("prompt_key")
    private final String f18699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("variables")
    private final Map<String, Object> f18700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("messages")
    private final List<f> f18701c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18699a, r6.f18699a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18700b, r6.f18700b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18701c, r6.f18701c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f18699a.hashCode() * 31) + this.f18700b.hashCode()) * 31) + this.f18701c.hashCode();
    }

    public String toString() {
        return "ChatCompletionRequest(promptKey=" + this.f18699a + ", variables=" + this.f18700b + ", messages=" + this.f18701c + ')';
    }

    public b(String r3, Map<String, ? extends Object> r4, List<f> r5) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<f> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "promptKey");
        o.e(r6, "variables");
        o.e(r7, "messages");
        this.f18699a = r3;
        this.f18700b = r6;
        this.f18701c = r7;
    }
}
