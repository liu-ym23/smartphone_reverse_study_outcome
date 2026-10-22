package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailKnowledgeViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23328b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23327a, r6.f23327a) == true) goto L12;
        return false;
    L12:
        if (this.f23328b == r6.f23328b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23327a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.f23328b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailKnowledgeCellDataV2(taskId=" + this.f23327a + ", taskType=" + this.f23328b + ')';
    }

    public k(String r1, int r2) {
        this.f23327a = r1;
        this.f23328b = r2;
    }

    public /* synthetic */ k(String r1, int r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }

    public final String a() {
        return this.f23327a;
    }

    public final int b() {
        return this.f23328b;
    }
}
