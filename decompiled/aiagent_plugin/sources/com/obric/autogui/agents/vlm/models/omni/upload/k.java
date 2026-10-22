package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniInferenceImageUploadBusyTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28808b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28807a, r6.f28807a) == true) goto L12;
        return false;
    L12:
        if (this.f28808b == r6.f28808b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f28807a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.f28808b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniInferenceImageTokenCleanup(taskId=" + this.f28807a + ", activeTokenCount=" + this.f28808b + ')';
    }

    public k(String r1, int r2) {
        this.f28807a = r1;
        this.f28808b = r2;
    }

    public final String a() {
        return this.f28807a;
    }

    public final int b() {
        return this.f28808b;
    }
}
