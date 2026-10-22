package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniDataFeedbackUploadRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28779b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28778a, r6.f28778a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28779b, r6.f28779b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28778a.hashCode() * 31) + this.f28779b.hashCode();
    }

    public String toString() {
        return "OmniDataFeedbackUploadKey(taskId=" + this.f28778a + ", toolId=" + this.f28779b + ')';
    }

    public g(String r2, String r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "toolId");
        this.f28778a = r2;
        this.f28779b = r3;
    }
}
