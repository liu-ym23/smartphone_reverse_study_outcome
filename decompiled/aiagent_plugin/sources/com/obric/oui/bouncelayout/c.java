package com.obric.oui.bouncelayout;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BounceDebugLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f34145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f34146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f34147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f34148e;
    private final long f;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
        return false;
    L8:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f34144a, r8.f34144a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f34145b, r8.f34145b) == true) goto L15;
        return false;
    L15:
        if (o.a(Float.valueOf(this.f34146c), Float.valueOf(r8.f34146c)) == true) goto L18;
        return false;
    L18:
        if (o.a(Float.valueOf(this.f34147d), Float.valueOf(r8.f34147d)) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f34148e, r8.f34148e) == true) goto L24;
        return false;
    L24:
        if (this.f == r8.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f34144a.hashCode() * 31) + this.f34145b.hashCode()) * 31) + Float.hashCode(this.f34146c)) * 31) + Float.hashCode(this.f34147d)) * 31) + this.f34148e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "BounceDebugEvent(viewName=" + this.f34144a + ", operation=" + this.f34145b + ", x=" + this.f34146c + ", y=" + this.f34147d + ", message=" + this.f34148e + ", timeMillis=" + this.f + ')';
    }

    public c(String r2, String r3, float r4, float r5, String r6, long r7) {
        o.e(r2, "viewName");
        o.e(r3, "operation");
        o.e(r6, "message");
        this.f34144a = r2;
        this.f34145b = r3;
        this.f34146c = r4;
        this.f34147d = r5;
        this.f34148e = r6;
        this.f = r7;
    }

    public /* synthetic */ c(String r11, String r12, float r13, float r14, String r15, long r16, int r18, h r19) {
        if ((r18 & 32) == 0) goto L5;
        long r8 = SystemClock.uptimeMillis();
    L6:
        this(r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final String a() {
        return "view=" + this.f34144a + " operation=" + this.f34145b + " x=" + this.f34146c + " y=" + this.f34147d + " time=" + this.f + ' ' + this.f34148e;
    }
}
