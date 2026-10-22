package com.obric.agent.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: StateData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f15857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f15858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15860d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.aiagent.plugin");
        if (this.f15857a == r10.f15857a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15858b, r10.f15858b) == true) goto L15;
        return false;
    L15:
        if (this.f15859c == r10.f15859c) goto L18;
        return false;
    L18:
        if (this.f15860d == r10.f15860d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f15857a.hashCode() * 31) + this.f15858b.hashCode()) * 31) + Long.hashCode(this.f15859c)) * 31) + Boolean.hashCode(this.f15860d);
    }

    public String toString() {
        return "StateData(state=" + this.f15857a + ", data=" + this.f15858b + ", startTime=" + this.f15859c + ", isAsync=" + this.f15860d + ')';
    }

    public t(o r3, Map<String, Object> r4, long r5, boolean r7) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "state");
        d.h.b.o.e(r6, "data");
        this.f15857a = r3;
        this.f15858b = r6;
        this.f15859c = r5;
        this.f15860d = r7;
    }

    public final o a() {
        return this.f15857a;
    }

    public final Map<String, Object> b() {
        return this.f15858b;
    }

    public final long c() {
        return this.f15859c;
    }

    public final boolean d() {
        return this.f15860d;
    }
}
