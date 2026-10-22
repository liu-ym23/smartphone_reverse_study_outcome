package com.obric.autogui.session.state.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.common.e f31235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f31236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f31237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<x> f31238d;

    public static /* synthetic */ x lambda$Da3SKq2o3K46JslLJk4dr9C24Qw() {
        return e();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f31235a, r6.f31235a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f31236b, r6.f31236b) == true) goto L15;
        return false;
    L15:
        if (this.f31237c == r6.f31237c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f31238d, r6.f31238d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f31235a.hashCode() * 31;
        Integer r1 = this.f31236b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.f31237c.hashCode()) * 31) + this.f31238d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PreparedVirtualDisplay(status=" + this.f31235a + ", displayId=" + this.f31236b + ", source=" + this.f31237c + ", onActivated=" + this.f31238d + ')';
    }

    public f(com.obric.autogui.common.e r3, Integer r4, n r5, d.h.a.a<x> r6) {
        d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "status");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r7, "onActivated");
        this.f31235a = r3;
        this.f31236b = r4;
        this.f31237c = r5;
        this.f31238d = r7;
    }

    public final com.obric.autogui.common.e a() {
        return this.f31235a;
    }

    public final Integer b() {
        return this.f31236b;
    }

    public final n c() {
        return this.f31237c;
    }

    public /* synthetic */ f(com.obric.autogui.common.e r2, Integer r3, n r4, d.h.a.a r5, int r6, d.h.b.h r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r8 = $$Lambda$f$Da3SKq2o3K46JslLJk4dr9C24Qw.INSTANCE;
    L5:
        this(r2, r3, r4, r8);
    }

    private static final x e() {
        return x.f38692a;
    }

    public final d.h.a.a<x> d() {
        return this.f31238d;
    }
}
