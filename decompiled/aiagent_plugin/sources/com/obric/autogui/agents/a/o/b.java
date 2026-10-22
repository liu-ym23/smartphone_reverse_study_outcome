package com.obric.autogui.agents.a.o;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectWhiteScreenObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26788e;
    private final int f;
    private final int g;
    private final Integer h;
    private final Boolean i;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26784a, r6.f26784a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26785b, r6.f26785b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26786c, r6.f26786c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26787d, r6.f26787d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26788e, r6.f26788e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f26784a.hashCode() * 31) + this.f26785b.hashCode()) * 31) + this.f26786c.hashCode()) * 31;
        String r1 = this.f26787d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f26788e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31;
        Integer r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.i;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "WhiteScreenReportSnapshot(sessionId=" + this.f26784a + ", stepId=" + this.f26785b + ", actionType=" + this.f26786c + ", toolId=" + this.f26787d + ", logId=" + this.f26788e + ", multiStepIndex=" + this.f + ", multiStepCount=" + this.g + ", executionStatusCode=" + this.h + ", originalHasError=" + this.i + ')';
    }

    public b(String r2, String r3, String r4, String r5, String r6, int r7, int r8, Integer r9, Boolean r10) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "stepId");
        o.e(r4, "actionType");
        this.f26784a = r2;
        this.f26785b = r3;
        this.f26786c = r4;
        this.f26787d = r5;
        this.f26788e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final String a() {
        return this.f26784a;
    }

    public final String b() {
        return this.f26785b;
    }

    public final String c() {
        return this.f26786c;
    }

    public final String d() {
        return this.f26787d;
    }

    public final String e() {
        return this.f26788e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final Integer h() {
        return this.h;
    }

    public final Boolean i() {
        return this.i;
    }
}
