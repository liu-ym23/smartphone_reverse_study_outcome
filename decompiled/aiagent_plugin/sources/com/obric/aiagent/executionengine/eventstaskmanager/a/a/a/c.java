package com.obric.aiagent.executionengine.eventstaskmanager.a.a.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: KnowledgeResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("knowledges")
    private final List<a> f16638a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16638a, r6.f16638a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f16638a.hashCode();
    }

    public String toString() {
        return "KnowledgeResponseData(knowledges=" + this.f16638a + ')';
    }

    public final List<a> a() {
        return this.f16638a;
    }
}
