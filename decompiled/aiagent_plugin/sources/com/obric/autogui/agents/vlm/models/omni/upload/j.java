package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniInferenceImageUploadBusyTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f28805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f28806b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (this.f28805a == r6.f28805a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28806b, r6.f28806b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f28805a) * 31;
        k r1 = this.f28806b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniInferenceImageStartResult(started=" + this.f28805a + ", cleanup=" + this.f28806b + ')';
    }

    public j(boolean r1, k r2) {
        this.f28805a = r1;
        this.f28806b = r2;
    }

    public /* synthetic */ j(boolean r1, k r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final k a() {
        return this.f28806b;
    }
}
