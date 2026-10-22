package com.obric.aiagent.skill.virt.impl.a.b;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21900d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21897a, r6.f21897a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21898b, r6.f21898b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f21899c, r6.f21899c) == true) goto L18;
        return false;
    L18:
        if (this.f21900d == r6.f21900d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f21897a.hashCode() * 31) + this.f21898b.hashCode()) * 31) + this.f21899c.hashCode()) * 31) + Boolean.hashCode(this.f21900d);
    }

    public String toString() {
        return "HostMoveEvent(what=" + this.f21897a + ", source=" + this.f21898b + ", destination=" + this.f21899c + ", usedFallback=" + this.f21900d + ')';
    }

    public a(String r2, String r3, String r4, boolean r5) {
        o.e(r2, "what");
        o.e(r3, DBHelper.BATTERY_COL_SOURCE);
        o.e(r4, "destination");
        this.f21897a = r2;
        this.f21898b = r3;
        this.f21899c = r4;
        this.f21900d = r5;
    }

    public final String a() {
        return this.f21897a;
    }

    public final String b() {
        return this.f21898b;
    }

    public final String c() {
        return this.f21899c;
    }

    public final boolean d() {
        return this.f21900d;
    }
}
