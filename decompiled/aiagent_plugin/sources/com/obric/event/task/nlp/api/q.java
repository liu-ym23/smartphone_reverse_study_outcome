package com.obric.event.task.nlp.api;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventTaskEntityDto.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable")
    private final Boolean f32948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("interval")
    private final Long f32949b;

    /* JADX WARN: Multi-variable type inference failed */
    public q() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32948a, r6.f32948a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32949b, r6.f32949b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.f32948a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.f32949b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TriggerControlPolicyDto(enable=" + this.f32948a + ", interval=" + this.f32949b + ')';
    }

    public q(Boolean r1, Long r2) {
        this.f32948a = r1;
        this.f32949b = r2;
    }

    public /* synthetic */ q(Boolean r2, Long r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Boolean a() {
        return this.f32948a;
    }

    public final Long b() {
        return this.f32949b;
    }
}
