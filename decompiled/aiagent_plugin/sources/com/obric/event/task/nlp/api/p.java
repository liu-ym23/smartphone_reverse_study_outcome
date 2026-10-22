package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("start")
    private final String f32946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("end")
    private final String f32947b;

    /* JADX WARN: Multi-variable type inference failed */
    public p() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32946a, r6.f32946a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32947b, r6.f32947b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f32946a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f32947b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TimeFrameDto(start=" + this.f32946a + ", end=" + this.f32947b + ')';
    }

    public p(String r1, String r2) {
        this.f32946a = r1;
        this.f32947b = r2;
    }

    public /* synthetic */ p(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String a() {
        return this.f32946a;
    }

    public final String b() {
        return this.f32947b;
    }
}
