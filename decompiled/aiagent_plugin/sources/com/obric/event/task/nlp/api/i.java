package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("event_type")
    private final j f32918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("location_type")
    private final k f32919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("location")
    private final a f32920c;

    public i() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f32918a == r6.f32918a) goto L12;
        return false;
    L12:
        if (this.f32919b == r6.f32919b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f32920c, r6.f32920c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        j r0 = this.f32918a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        k r4 = this.f32919b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.f32920c;
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
        return "LocationConditionDto(eventType=" + this.f32918a + ", locationType=" + this.f32919b + ", location=" + this.f32920c + ')';
    }

    public i(j r1, k r2, a r3) {
        this.f32918a = r1;
        this.f32919b = r2;
        this.f32920c = r3;
    }

    public /* synthetic */ i(j r2, k r3, a r4, int r5, d.h.b.h r6) {
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

    public final j a() {
        return this.f32918a;
    }

    public final k b() {
        return this.f32919b;
    }

    public final a c() {
        return this.f32920c;
    }
}
