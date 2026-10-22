package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: StreamingResponsePackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28114c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f28112a == r6.f28112a) goto L12;
        return false;
    L12:
        if (o.a(this.f28113b, r6.f28113b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f28114c, r6.f28114c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f28112a) * 31) + this.f28113b.hashCode()) * 31) + this.f28114c.hashCode();
    }

    public String toString() {
        return "StreamingResponseBizError(code=" + this.f28112a + ", msg=" + this.f28113b + ", logId=" + this.f28114c + ')';
    }

    public e(int r2, String r3, String r4) {
        o.e(r3, "msg");
        o.e(r4, "logId");
        this.f28112a = r2;
        this.f28113b = r3;
        this.f28114c = r4;
    }

    public final int a() {
        return this.f28112a;
    }

    public final String b() {
        return this.f28113b;
    }

    public final String c() {
        return this.f28114c;
    }
}
