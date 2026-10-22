package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailOperateTaskViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23341b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23340a, r6.f23340a) == true) goto L12;
        return false;
    L12:
        if (this.f23341b == r6.f23341b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23340a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.f23341b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailOperateTaskCellDataV2(taskId=" + this.f23340a + ", taskType=" + this.f23341b + ')';
    }

    public p(String r1, int r2) {
        this.f23340a = r1;
        this.f23341b = r2;
    }

    public final String a() {
        return this.f23340a;
    }

    public final int b() {
        return this.f23341b;
    }
}
