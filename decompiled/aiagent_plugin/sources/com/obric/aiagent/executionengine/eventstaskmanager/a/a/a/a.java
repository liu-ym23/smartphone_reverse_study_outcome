package com.obric.aiagent.executionengine.eventstaskmanager.a.a.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: KnowledgeResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("session_id")
    private final String f16634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("knowledge_status")
    private final int f16635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("knowledges")
    private final List<String> f16636c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16634a, r6.f16634a) == true) goto L12;
        return false;
    L12:
        if (this.f16635b == r6.f16635b) goto L15;
        return false;
    L15:
        if (o.a(this.f16636c, r6.f16636c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f16634a.hashCode() * 31) + Integer.hashCode(this.f16635b)) * 31) + this.f16636c.hashCode();
    }

    public String toString() {
        return "KnowledgeItem(sessionId=" + this.f16634a + ", knowledgeStatus=" + this.f16635b + ", knowledges=" + this.f16636c + ')';
    }

    public final String a() {
        return this.f16634a;
    }

    public final int b() {
        return this.f16635b;
    }

    public final List<String> c() {
        return this.f16636c;
    }
}
