package com.obric.autogui.operator.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MatchingParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f29279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f29280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f29281c;

    public e() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f29279a, r6.f29279a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f29280b, r6.f29280b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f29281c, r6.f29281c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        a r0 = this.f29279a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b r4 = this.f29280b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        f r7 = this.f29281c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MatchingParams(paramAndroid=" + this.f29279a + ", paramComponentsMatching=" + this.f29280b + ", paramPositional=" + this.f29281c + ')';
    }

    public e(a r1, b r2, f r3) {
        this.f29279a = r1;
        this.f29280b = r2;
        this.f29281c = r3;
    }

    public /* synthetic */ e(a r2, b r3, f r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final void a(b r1) {
        this.f29280b = r1;
    }

    public final f a() {
        return this.f29281c;
    }

    public final void a(f r1) {
        this.f29281c = r1;
    }
}
