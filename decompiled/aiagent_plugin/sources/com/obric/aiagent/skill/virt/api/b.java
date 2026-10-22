package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21557c;

    public b() {
        this(false, false, false, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f21555a == r6.f21555a) goto L12;
        return false;
    L12:
        if (this.f21556b == r6.f21556b) goto L15;
        return false;
    L15:
        if (this.f21557c == r6.f21557c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f21555a) * 31) + Boolean.hashCode(this.f21556b)) * 31) + Boolean.hashCode(this.f21557c);
    }

    public String toString() {
        return "ExportConfig(destructiveExport=" + this.f21555a + ", overwrite=" + this.f21556b + ", createParents=" + this.f21557c + ')';
    }

    public b(boolean r1, boolean r2, boolean r3) {
        this.f21555a = r1;
        this.f21556b = r2;
        this.f21557c = r3;
    }

    public /* synthetic */ b(boolean r2, boolean r3, boolean r4, int r5, d.h.b.h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }

    public final boolean a() {
        return this.f21555a;
    }

    public final boolean b() {
        return this.f21556b;
    }

    public final boolean c() {
        return this.f21557c;
    }
}
