package com.obric.autogui.platforms.obric.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SingleCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f30082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30083d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f30080a == r6.f30080a) goto L12;
        return false;
    L12:
        if (o.a(this.f30081b, r6.f30081b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f30082c, r6.f30082c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f30083d, r6.f30083d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f30080a) * 31;
        String r1 = this.f30081b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.f30082c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f30083d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SingleCheckResult(resultCode=" + this.f30080a + ", virusType=" + this.f30081b + ", virusTypeCode=" + this.f30082c + ", errorMessage=" + this.f30083d + ')';
    }

    public a(int r1, String r2, Integer r3, String r4) {
        this.f30080a = r1;
        this.f30081b = r2;
        this.f30082c = r3;
        this.f30083d = r4;
    }

    public /* synthetic */ a(int r1, String r2, Integer r3, String r4, int r5, h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final int a() {
        return this.f30080a;
    }

    public final String b() {
        return this.f30081b;
    }

    public final Integer c() {
        return this.f30082c;
    }

    public final String d() {
        return this.f30083d;
    }
}
