package com.obric.autogui.agents.scripted.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ScriptMemorySnapshot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f26909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f26910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f26911e;
    private final Long f;
    private final Long g;
    private final Long h;
    private final Long i;
    private final Long j;

    /* JADX INFO: compiled from: ScriptMemorySnapshot.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final d a(Map<String, String> r13) {
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
            o.e(r14, "stats");
            Long r1 = a(r14, "summary.total-pss");
            if (r1 != null) goto L5;
            return null;
        L5:
            return new d(r1.longValue(), a(r14, "summary.java-heap"), a(r14, "summary.native-heap"), a(r14, "summary.code"), a(r14, "summary.stack"), a(r14, "summary.graphics"), a(r14, "summary.private-other"), a(r14, "summary.system"), a(r14, "summary.total-swap"));
        }

        private final Long a(Map<String, String> r5, String r6) {
            String r4 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin")).get(r6), String.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L13;
            Long r7 = d.o.o.e(r4);
            if (r7 != null) goto L7;
            return null;
        L7:
            if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L9;
            boolean r8 = true;
        L10:
            if (r8 == true) goto L12;
            return null;
        L12:
            return r7;
        L9:
            r8 = false;
            goto L10
        L13:
            return null;
        }
    }

    static {
        f26907a = new a(null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (this.f26908b == r10.f26908b) goto L12;
        return false;
    L12:
        if (o.a(this.f26909c, r10.f26909c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26910d, r10.f26910d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26911e, r10.f26911e) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (o.a(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (o.a(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (o.a(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (o.a(this.j, r10.j) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f26908b) * 31;
        Long r1 = this.f26909c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f26910d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.f26911e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.i;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.j;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "ScriptMemorySnapshot(totalPssKb=" + this.f26908b + ", javaHeapKb=" + this.f26909c + ", nativeHeapKb=" + this.f26910d + ", codeKb=" + this.f26911e + ", stackKb=" + this.f + ", graphicsKb=" + this.g + ", privateOtherKb=" + this.h + ", systemKb=" + this.i + ", totalSwapKb=" + this.j + ')';
    }

    public d(long r1, Long r3, Long r4, Long r5, Long r6, Long r7, Long r8, Long r9, Long r10) {
        this.f26908b = r1;
        this.f26909c = r3;
        this.f26910d = r4;
        this.f26911e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final long a() {
        return this.f26908b;
    }

    public final com.obric.autogui.agents.scripted.b.a a(d r13) {
        o.e(r13, "baseline");
        return new com.obric.autogui.agents.scripted.b.a(this.f26908b - r13.f26908b, a(this.f26909c, r13.f26909c), a(this.f26910d, r13.f26910d), a(this.f26911e, r13.f26911e), a(this.f, r13.f), a(this.g, r13.g), a(this.h, r13.h), a(this.i, r13.i), a(this.j, r13.j));
    }

    private final Long a(Long r3, Long r4) {
        if (r3 == null) goto L5;
        if (r4 == null) goto L5;
        return Long.valueOf(r3.longValue() - r4.longValue());
    L5:
        return null;
    }
}
