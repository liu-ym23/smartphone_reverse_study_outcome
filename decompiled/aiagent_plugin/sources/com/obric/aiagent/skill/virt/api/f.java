package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21568d;

    public f() {
        this(false, false, false, false, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f21565a == r6.f21565a) goto L12;
        return false;
    L12:
        if (this.f21566b == r6.f21566b) goto L15;
        return false;
    L15:
        if (this.f21567c == r6.f21567c) goto L18;
        return false;
    L18:
        if (this.f21568d == r6.f21568d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f21565a) * 31) + Boolean.hashCode(this.f21566b)) * 31) + Boolean.hashCode(this.f21567c)) * 31) + Boolean.hashCode(this.f21568d);
    }

    public String toString() {
        return "ImportConfig(overwrite=" + this.f21565a + ", createParents=" + this.f21566b + ", moveSource=" + this.f21567c + ", ensureExecutable=" + this.f21568d + ')';
    }

    public f(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.f21565a = r1;
        this.f21566b = r2;
        this.f21567c = r3;
        this.f21568d = r4;
    }

    public /* synthetic */ f(boolean r2, boolean r3, boolean r4, boolean r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final boolean a() {
        return this.f21565a;
    }

    public final boolean b() {
        return this.f21566b;
    }

    public final boolean c() {
        return this.f21567c;
    }

    public final boolean d() {
        return this.f21568d;
    }
}
