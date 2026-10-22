package com.obric.oui.texteffects.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f36391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f36392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<d> f36393d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f36390a, r10.f36390a) == true) goto L12;
        return false;
    L12:
        if (this.f36391b == r10.f36391b) goto L15;
        return false;
    L15:
        if (this.f36392c == r10.f36392c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f36393d, r10.f36393d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f36390a.hashCode() * 31) + Long.hashCode(this.f36391b)) * 31) + Long.hashCode(this.f36392c)) * 31) + this.f36393d.hashCode();
    }

    public String toString() {
        return "EffectStage(id=" + this.f36390a + ", startMs=" + this.f36391b + ", durationMs=" + this.f36392c + ", layers=" + this.f36393d + ')';
    }

    public f(String r3, long r4, long r6, List<? extends d> r8) {
        List<d> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r9, "layers");
        this.f36390a = r3;
        this.f36391b = r4;
        this.f36392c = r6;
        this.f36393d = r9;
    }

    public final String a() {
        return this.f36390a;
    }

    public final long b() {
        return this.f36391b;
    }

    public final long c() {
        return this.f36392c;
    }

    public final List<d> d() {
        return this.f36393d;
    }
}
