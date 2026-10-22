package com.obric.autogui.agents.vlm.models.omni.upload.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadReactViewTreeRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.obric.autogui.agents.vlm.models.omni.a.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f28570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28574e;
    private final long f;
    private final long g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28570a, r10.f28570a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28571b, r10.f28571b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f28572c, r10.f28572c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f28573d, r10.f28573d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28574e, r10.f28574e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f28570a.hashCode() * 31) + this.f28571b.hashCode()) * 31) + this.f28572c.hashCode()) * 31) + this.f28573d.hashCode()) * 31;
        Integer r1 = this.f28574e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniUploadReactViewTreeRecord(file=" + this.f28570a + ", taskId=" + this.f28571b + ", toolId=" + this.f28572c + ", stepId=" + this.f28573d + ", stepIndex=" + this.f28574e + ", createdAtMillis=" + this.f + ", fileSizeBytes=" + this.g + ')';
    }

    public g(File r2, String r3, String r4, String r5, Integer r6, long r7, long r9) {
        o.e(r2, "file");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r4, "toolId");
        o.e(r5, "stepId");
        this.f28570a = r2;
        this.f28571b = r3;
        this.f28572c = r4;
        this.f28573d = r5;
        this.f28574e = r6;
        this.f = r7;
        this.g = r9;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public File a() {
        return this.f28570a;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public String b() {
        return this.f28571b;
    }

    public String e() {
        return this.f28572c;
    }

    public String f() {
        return this.f28573d;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public Integer c() {
        return this.f28574e;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public long d() {
        return this.f;
    }

    public long g() {
        return this.g;
    }
}
