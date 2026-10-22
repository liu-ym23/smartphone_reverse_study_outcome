package com.obric.agent.trace.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DetailInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15423b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f15422a, r6.f15422a) == true) goto L12;
        return false;
    L12:
        if (this.f15423b == r6.f15423b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f15422a.hashCode() * 31) + Boolean.hashCode(this.f15423b);
    }

    public String toString() {
        return "DetailInfo(info=" + this.f15422a + ", normal=" + this.f15423b + ')';
    }

    public c(String r2, boolean r3) {
        o.e(r2, DBDefinition.SEGMENT_INFO);
        this.f15422a = r2;
        this.f15423b = r3;
    }

    public /* synthetic */ c(String r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }
}
