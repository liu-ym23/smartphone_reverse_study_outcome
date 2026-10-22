package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f17150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f17151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f17152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f17153e;
    private final String f;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, n.class) == true) goto L8;
        return false;
    L8:
        n r10 = (n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin");
        if (this.f17149a == r10.f17149a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f17150b, r10.f17150b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f17151c, r10.f17151c) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.f17152d, r10.f17152d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.f17153e, r10.f17153e) == 0) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f17149a) * 31) + Float.hashCode(this.f17150b)) * 31) + Float.hashCode(this.f17151c)) * 31) + Double.hashCode(this.f17152d)) * 31) + Double.hashCode(this.f17153e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "LocationMonitorRawFrame(time=" + this.f17149a + ", speed=" + this.f17150b + ", accuracy=" + this.f17151c + ", longitude=" + this.f17152d + ", latitude=" + this.f17153e + ", provider=" + this.f + ')';
    }

    public n(long r2, float r4, float r5, double r6, double r8, String r10) {
        d.h.b.o.e(r10, "provider");
        this.f17149a = r2;
        this.f17150b = r4;
        this.f17151c = r5;
        this.f17152d = r6;
        this.f17153e = r8;
        this.f = r10;
    }

    public final long a() {
        return this.f17149a;
    }

    public final float b() {
        return this.f17150b;
    }

    public final float c() {
        return this.f17151c;
    }

    public final double d() {
        return this.f17152d;
    }

    public final double e() {
        return this.f17153e;
    }

    public final String f() {
        return this.f;
    }
}
