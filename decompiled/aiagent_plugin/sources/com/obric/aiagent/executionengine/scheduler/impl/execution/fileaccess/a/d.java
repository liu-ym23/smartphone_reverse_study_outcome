package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IPermissionChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18419c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18417a, r6.f18417a) == true) goto L12;
        return false;
    L12:
        if (this.f18418b == r6.f18418b) goto L15;
        return false;
    L15:
        if (this.f18419c == r6.f18419c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f18417a.hashCode() * 31) + Integer.hashCode(this.f18418b)) * 31) + Integer.hashCode(this.f18419c);
    }

    public String toString() {
        return "UriAccessRequester(packageName=" + this.f18417a + ", uid=" + this.f18418b + ", pid=" + this.f18419c + ')';
    }

    public d(String r2, int r3, int r4) {
        o.e(r2, "packageName");
        this.f18417a = r2;
        this.f18418b = r3;
        this.f18419c = r4;
    }

    public final String a() {
        return this.f18417a;
    }

    public final int b() {
        return this.f18418b;
    }
}
