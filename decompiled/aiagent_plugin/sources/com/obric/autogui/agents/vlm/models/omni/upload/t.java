package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: OmniUploadImageRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.obric.autogui.agents.vlm.models.omni.a.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f28849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f28853e;
    private final long f;
    private final long g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28849a, r10.f28849a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28850b, r10.f28850b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f28851c, r10.f28851c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28852d, r10.f28852d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f28853e, r10.f28853e) == true) goto L24;
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
        int r0 = ((((((this.f28849a.hashCode() * 31) + this.f28850b.hashCode()) * 31) + this.f28851c.hashCode()) * 31) + this.f28852d.hashCode()) * 31;
        Integer r1 = this.f28853e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniUploadImageRecord(file=" + this.f28849a + ", taskId=" + this.f28850b + ", toolId=" + this.f28851c + ", stepId=" + this.f28852d + ", stepIndex=" + this.f28853e + ", createdAtMillis=" + this.f + ", fileSizeBytes=" + this.g + ')';
    }

    public t(File r2, String r3, String r4, String r5, Integer r6, long r7, long r9) {
        d.h.b.o.e(r2, "file");
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        d.h.b.o.e(r4, "toolId");
        d.h.b.o.e(r5, "stepId");
        this.f28849a = r2;
        this.f28850b = r3;
        this.f28851c = r4;
        this.f28852d = r5;
        this.f28853e = r6;
        this.f = r7;
        this.g = r9;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public File a() {
        return this.f28849a;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public String b() {
        return this.f28850b;
    }

    public String e() {
        return this.f28851c;
    }

    public String f() {
        return this.f28852d;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public Integer c() {
        return this.f28853e;
    }

    @Override // com.obric.autogui.agents.vlm.models.omni.a.h
    public long d() {
        return this.f;
    }

    public long g() {
        return this.g;
    }
}
