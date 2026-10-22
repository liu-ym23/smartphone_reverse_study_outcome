package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("time_point")
    private final String f32943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("time_frame")
    private final p f32944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("interval")
    private final String f32945c;

    public o() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32943a, r6.f32943a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32944b, r6.f32944b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f32945c, r6.f32945c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f32943a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        p r4 = this.f32944b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f32945c;
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
        return "TimeConditionDto(timePoint=" + this.f32943a + ", timeFrame=" + this.f32944b + ", interval=" + this.f32945c + ')';
    }

    public o(String r1, p r2, String r3) {
        this.f32943a = r1;
        this.f32944b = r2;
        this.f32945c = r3;
    }

    public /* synthetic */ o(String r2, p r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f32943a;
    }

    public final p b() {
        return this.f32944b;
    }

    public final String c() {
        return this.f32945c;
    }
}
