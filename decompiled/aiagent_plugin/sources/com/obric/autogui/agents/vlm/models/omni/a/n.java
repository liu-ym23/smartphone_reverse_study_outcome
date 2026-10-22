package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f28196b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28195a, r6.f28195a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28196b, r6.f28196b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f28195a.hashCode() * 31;
        e r1 = this.f28196b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "VersionedFeedbackTask(version=" + this.f28195a + ", feedbackInfo=" + this.f28196b + ')';
    }

    public n(String r2, e r3) {
        o.e(r2, "version");
        this.f28195a = r2;
        this.f28196b = r3;
    }

    public final String a() {
        return this.f28195a;
    }

    public final e b() {
        return this.f28196b;
    }
}
