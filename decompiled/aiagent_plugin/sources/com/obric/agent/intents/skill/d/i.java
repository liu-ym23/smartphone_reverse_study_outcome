package com.obric.agent.intents.skill.d;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SystemSkillResultStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("status")
    private final j f15175a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f15175a == r6.f15175a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f15175a.hashCode();
    }

    public String toString() {
        return "SystemSkillPendingBody(status=" + this.f15175a + ')';
    }

    public i(j r2) {
        o.e(r2, "status");
        this.f15175a = r2;
    }
}
