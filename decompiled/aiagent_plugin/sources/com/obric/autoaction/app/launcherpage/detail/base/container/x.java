package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailTopTipViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23369a;

    /* JADX WARN: Multi-variable type inference failed */
    public x() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == true) goto L8;
        return false;
    L8:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23369a, r6.f23369a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f23369a.hashCode();
    }

    public String toString() {
        return "DetailTopTipDataV2(desc=" + this.f23369a + ')';
    }

    public x(String r2) {
        d.h.b.o.e(r2, "desc");
        this.f23369a = r2;
    }

    public /* synthetic */ x(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final String a() {
        return this.f23369a;
    }
}
