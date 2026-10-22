package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f20580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f20581b;

    /* JADX WARN: Multi-variable type inference failed */
    public aw() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aw.class) == true) goto L8;
        return false;
    L8:
        aw r6 = (aw) ZeusTransformUtils.preCheckCast(r5, aw.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20580a, r6.f20580a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20581b, r6.f20581b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f20580a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f20581b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SkillFormImportPreview(descriptionLimitChars=" + this.f20580a + ", bodyLimitChars=" + this.f20581b + ')';
    }

    public aw(Integer r1, Integer r2) {
        this.f20580a = r1;
        this.f20581b = r2;
    }

    public /* synthetic */ aw(Integer r2, Integer r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Integer a() {
        return this.f20580a;
    }

    public final Integer b() {
        return this.f20581b;
    }
}
