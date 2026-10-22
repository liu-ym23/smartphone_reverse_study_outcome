package com.obric.agent.complextask;

import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ComplexTaskStateData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComplexTaskState f14326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f14327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f14328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Long f14329d;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
        return false;
    L8:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14326a, r8.f14326a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14327b, r8.f14327b) == true) goto L15;
        return false;
    L15:
        if (this.f14328c == r8.f14328c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14326a.hashCode() * 31) + this.f14327b.hashCode()) * 31) + Long.hashCode(this.f14328c);
    }

    public String toString() {
        return "ComplexTaskStateData(state=" + this.f14326a + ", data=" + this.f14327b + ", startTime=" + this.f14328c + ')';
    }

    public b(ComplexTaskState r3, Map<String, Object> r4, long r5) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "state");
        o.e(r6, "data");
        this.f14326a = r3;
        this.f14327b = r6;
        this.f14328c = r5;
    }

    public final ComplexTaskState a() {
        return this.f14326a;
    }

    public final Map<String, Object> b() {
        return this.f14327b;
    }

    public final long c() {
        return this.f14328c;
    }

    public final void a(Long r1) {
        this.f14329d = r1;
    }

    public final Long d() {
        return this.f14329d;
    }
}
