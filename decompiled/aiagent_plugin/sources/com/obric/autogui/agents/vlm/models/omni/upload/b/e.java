package com.obric.autogui.agents.vlm.models.omni.upload.b;

import com.obric.autogui.agents.vlm.models.omni.a.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadViewTreeRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f28631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28635e;
    private final long f;
    private final long g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
        return false;
    L8:
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28631a, r10.f28631a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28632b, r10.f28632b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f28633c, r10.f28633c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f28634d, r10.f28634d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28635e, r10.f28635e) == true) goto L24;
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
        int r0 = ((((((this.f28631a.hashCode() * 31) + this.f28632b.hashCode()) * 31) + this.f28633c.hashCode()) * 31) + this.f28634d.hashCode()) * 31;
        Integer r1 = this.f28635e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniUploadViewTreeRecord(file=" + this.f28631a + ", taskId=" + this.f28632b + ", toolId=" + this.f28633c + ", stepId=" + this.f28634d + ", stepIndex=" + this.f28635e + ", createdAtMillis=" + this.f + ", fileSizeBytes=" + this.g + ')';
    }

    public e(File r2, String r3, String r4, String r5, Integer r6, long r7, long r9) {
        o.e(r2, "file");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r4, "toolId");
        o.e(r5, "stepId");
        this.f28631a = r2;
        this.f28632b = r3;
        this.f28633c = r4;
        this.f28634d = r5;
        this.f28635e = r6;
        this.f = r7;
        this.g = r9;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public File a() {
        return this.f28631a;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public String b() {
        return this.f28632b;
    }

    public String e() {
        return this.f28633c;
    }

    public String f() {
        return this.f28634d;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public Integer c() {
        return this.f28635e;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public long d() {
        return this.f;
    }

    public long g() {
        return this.g;
    }
}
