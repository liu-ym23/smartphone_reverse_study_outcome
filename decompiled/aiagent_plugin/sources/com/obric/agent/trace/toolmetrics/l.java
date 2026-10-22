package com.obric.agent.trace.toolmetrics;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15903c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15901a, r6.f15901a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15902b, r6.f15902b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15903c, r6.f15903c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f15901a.hashCode() * 31) + this.f15902b.hashCode()) * 31) + this.f15903c.hashCode();
    }

    public String toString() {
        return "OmniClientToolMeta(namespace=" + this.f15901a + ", id=" + this.f15902b + ", name=" + this.f15903c + ')';
    }

    public l(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "namespace");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r4, "name");
        this.f15901a = r2;
        this.f15902b = r3;
        this.f15903c = r4;
    }

    public final String a() {
        return this.f15901a;
    }

    public final String b() {
        return this.f15902b;
    }

    public final String c() {
        return this.f15903c;
    }
}
