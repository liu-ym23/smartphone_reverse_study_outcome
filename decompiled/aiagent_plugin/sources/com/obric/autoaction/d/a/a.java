package com.obric.autoaction.d.a;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Entities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f24644d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24641a, r6.f24641a) == true) goto L12;
        return false;
    L12:
        if (this.f24642b == r6.f24642b) goto L15;
        return false;
    L15:
        if (this.f24643c == r6.f24643c) goto L18;
        return false;
    L18:
        if (o.a(this.f24644d, r6.f24644d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f24641a.hashCode() * 31) + Boolean.hashCode(this.f24642b)) * 31) + Integer.hashCode(this.f24643c)) * 31;
        Bundle r2 = this.f24644d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AIAgentParam(userPrompt=" + this.f24641a + ", followingLastQuery=" + this.f24642b + ", launchOrigin=" + this.f24643c + ", taskExtras=" + this.f24644d + ')';
    }

    public a(String r2, boolean r3, int r4, Bundle r5) {
        o.e(r2, "userPrompt");
        this.f24641a = r2;
        this.f24642b = r3;
        this.f24643c = r4;
        this.f24644d = r5;
    }

    public final String a() {
        return this.f24641a;
    }

    public final boolean b() {
        return this.f24642b;
    }

    public final int c() {
        return this.f24643c;
    }

    public final Bundle d() {
        return this.f24644d;
    }
}
