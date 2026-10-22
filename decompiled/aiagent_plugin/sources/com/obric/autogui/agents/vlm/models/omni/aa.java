package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PreActionPageChangeBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f28197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f28198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Boolean f28199c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28197a, r6.f28197a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28198b, r6.f28198b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f28199c, r6.f28199c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.f28197a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.f28198b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.f28199c;
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
        return "PreActionPageChangeEntry(activityChanged=" + this.f28197a + ", viewTreeChanged=" + this.f28198b + ", imageChanged=" + this.f28199c + ')';
    }

    public aa(Boolean r1, Boolean r2, Boolean r3) {
        this.f28197a = r1;
        this.f28198b = r2;
        this.f28199c = r3;
    }

    public final Boolean a() {
        return this.f28197a;
    }

    public final Boolean b() {
        return this.f28198b;
    }

    public final Boolean c() {
        return this.f28199c;
    }
}
