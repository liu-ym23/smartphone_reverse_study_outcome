package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtualDisplayRecordSetBizTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27588d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27585a, r6.f27585a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f27586b, r6.f27586b) == true) goto L15;
        return false;
    L15:
        if (this.f27587c == r6.f27587c) goto L18;
        return false;
    L18:
        if (this.f27588d == r6.f27588d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f27585a.hashCode() * 31) + this.f27586b.hashCode()) * 31) + Integer.hashCode(this.f27587c)) * 31) + Boolean.hashCode(this.f27588d);
    }

    public String toString() {
        return "VirtualDisplayRecordSetSessionTrackingContext(sessionId=" + this.f27585a + ", sessionKey=" + this.f27586b + ", sessionOrigin=" + this.f27587c + ", isOmni=" + this.f27588d + ')';
    }

    public r(String r2, String r3, int r4, boolean r5) {
        d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r3, "sessionKey");
        this.f27585a = r2;
        this.f27586b = r3;
        this.f27587c = r4;
        this.f27588d = r5;
    }

    public final String a() {
        return this.f27585a;
    }

    public final String b() {
        return this.f27586b;
    }

    public final int c() {
        return this.f27587c;
    }

    public final boolean d() {
        return this.f27588d;
    }
}
