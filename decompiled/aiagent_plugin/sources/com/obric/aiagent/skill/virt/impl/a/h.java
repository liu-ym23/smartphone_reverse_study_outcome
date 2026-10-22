package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellCalling.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f22049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22050c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f22048a == r6.f22048a) goto L12;
        return false;
    L12:
        if (o.a(this.f22049b, r6.f22049b) == true) goto L15;
        return false;
    L15:
        if (this.f22050c == r6.f22050c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f22048a) * 31;
        Integer r1 = this.f22049b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.f22050c);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShellCallingResult(exitCode=" + this.f22048a + ", signal=" + this.f22049b + ", killed=" + this.f22050c + ')';
    }

    public h(int r1, Integer r2, boolean r3) {
        this.f22048a = r1;
        this.f22049b = r2;
        this.f22050c = r3;
    }

    public final int a() {
        return this.f22048a;
    }

    public final boolean b() {
        return this.f22050c;
    }
}
