package com.obric.autogui.agents.scripted.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("implementationsByScriptName")
    private final Map<String, List<String>> f26868a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26868a, r6.f26868a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, List<String>> r0 = this.f26868a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "PreCheckImplementationData(implementationsByScriptName=" + this.f26868a + ')';
    }

    public final Map<String, List<String>> a() {
        return this.f26868a;
    }
}
