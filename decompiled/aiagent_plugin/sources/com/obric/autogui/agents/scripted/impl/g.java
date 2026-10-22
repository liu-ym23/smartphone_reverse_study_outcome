package com.obric.autogui.agents.scripted.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: PreCheckMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f26995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("data")
    private final List<String> f26996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("implementationData")
    private final com.obric.autogui.agents.scripted.a.g f26997c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26995a, r6.f26995a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26996b, r6.f26996b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26997c, r6.f26997c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26995a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.f26996b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.obric.autogui.agents.scripted.a.g r7 = this.f26997c;
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
        return "PreCheckMessage(type=" + this.f26995a + ", data=" + this.f26996b + ", implementationData=" + this.f26997c + ')';
    }

    public final String getType() {
        return this.f26995a;
    }

    public final List<String> a() {
        return this.f26996b;
    }

    public final com.obric.autogui.agents.scripted.a.g b() {
        return this.f26997c;
    }
}
