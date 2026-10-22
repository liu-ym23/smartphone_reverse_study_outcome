package com.obric.autogui.agents.vlm.models.omni.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OmniGuiToolTraceSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f28212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f28213c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28211a, r6.f28211a) == true) goto L12;
        return false;
    L12:
        if (this.f28212b == r6.f28212b) goto L15;
        return false;
    L15:
        if (this.f28213c == r6.f28213c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f28211a.hashCode() * 31) + this.f28212b.hashCode()) * 31) + this.f28213c.hashCode();
    }

    public String toString() {
        return "OmniGuiToolDurationSpec(field=" + this.f28211a + ", start=" + this.f28212b + ", end=" + this.f28213c + ')';
    }

    public a(String r2, f r3, f r4) {
        o.e(r2, "field");
        o.e(r3, "start");
        o.e(r4, "end");
        this.f28211a = r2;
        this.f28212b = r3;
        this.f28213c = r4;
    }

    public final String a() {
        return this.f28211a;
    }

    public final f b() {
        return this.f28212b;
    }

    public final f c() {
        return this.f28213c;
    }
}
