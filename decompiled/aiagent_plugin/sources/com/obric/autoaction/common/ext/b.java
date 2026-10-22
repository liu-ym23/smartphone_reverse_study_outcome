package com.obric.autoaction.common.ext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PageReportExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autoaction.common.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24640b;

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24639a, r6.f24639a) == true) goto L12;
        return false;
    L12:
        if (this.f24640b == r6.f24640b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f24639a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Boolean.hashCode(this.f24640b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "PageReportConfig(pageName=" + this.f24639a + ", enable=" + this.f24640b + ')';
    }

    public b(String r1, boolean r2) {
        this.f24639a = r1;
        this.f24640b = r2;
    }

    public /* synthetic */ b(String r1, boolean r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L10;
        if (r1 == null) goto L9;
        r2 = true;
        goto L10
    L9:
        r2 = false;
    L10:
        this(r1, r2);
    }

    public final String b() {
        return this.f24639a;
    }

    @Override // com.obric.autoaction.common.base.b
    public boolean a() {
        return this.f24640b;
    }
}
