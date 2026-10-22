package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: FileTransferResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20953c;

    public c() {
        this(false, false, false, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f20951a == r6.f20951a) goto L12;
        return false;
    L12:
        if (this.f20952b == r6.f20952b) goto L15;
        return false;
    L15:
        if (this.f20953c == r6.f20953c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f20951a) * 31) + Boolean.hashCode(this.f20952b)) * 31) + Boolean.hashCode(this.f20953c);
    }

    public String toString() {
        return "FileExportConfig(destructiveExport=" + this.f20951a + ", overwrite=" + this.f20952b + ", createParents=" + this.f20953c + ')';
    }

    public c(boolean r1, boolean r2, boolean r3) {
        this.f20951a = r1;
        this.f20952b = r2;
        this.f20953c = r3;
    }

    public /* synthetic */ c(boolean r2, boolean r3, boolean r4, int r5, h r6) {
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
        return this.f20951a;
    }

    public final boolean b() {
        return this.f20952b;
    }

    public final boolean c() {
        return this.f20953c;
    }
}
