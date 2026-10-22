package com.obric.autogui.agents.a.f;

import com.obric.autogui.agents.a.m.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f26432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f26433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f26434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<b> f26436e;
    private final int f;
    private final String g;
    private final e h;
    private final s i;

    public static /* synthetic */ i a(i r10, k r11, k r12, c r13, String r14, List r15, int r16, String r17, e r18, s r19, int r20, Object r21) {
        List<b> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        k r3 = r10.f26432a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        k r4 = r10.f26433b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        c r5 = r10.f26434c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = r10.f26435d;
    L19:
        if ((r20 & 16) == 0) goto L22;
        r2 = r10.f26436e;
    L22:
        if ((r20 & 32) == 0) goto L24;
        int r7 = r10.f;
    L26:
        if ((r20 & 64) == 0) goto L28;
        String r8 = r10.g;
    L30:
        if ((r20 & 128) == 0) goto L32;
        e r9 = r10.h;
    L34:
        if ((r20 & 256) == 0) goto L36;
        s r1 = r10.i;
    L38:
        return r10.a(r3, r4, r5, r6, r2, r7, r8, r9, r1);
    L36:
        r1 = r19;
        goto L38
    L32:
        r9 = r18;
        goto L34
    L28:
        r8 = r17;
        goto L30
    L24:
        r7 = r16;
        goto L26
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final i a(k r12, k r13, c r14, String r15, List<b> r16, int r17, String r18, e r19, s r20) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        o.e(r12, "startStatus");
        o.e(r13, "status");
        o.e(r15, "servedEvidence");
        o.e(r6, "evidence");
        o.e(r20, "finishReason");
        return new i(r12, r13, r14, r15, r6, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f26432a == r6.f26432a) goto L12;
        return false;
    L12:
        if (this.f26433b == r6.f26433b) goto L15;
        return false;
    L15:
        if (this.f26434c == r6.f26434c) goto L18;
        return false;
    L18:
        if (o.a(this.f26435d, r6.f26435d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26436e, r6.f26436e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f26432a.hashCode() * 31) + this.f26433b.hashCode()) * 31;
        c r1 = this.f26434c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.f26435d.hashCode()) * 31) + this.f26436e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        e r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.i.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectOutcome(startStatus=" + this.f26432a + ", status=" + this.f26433b + ", servedDetector=" + this.f26434c + ", servedEvidence=" + this.f26435d + ", evidence=" + this.f26436e + ", detectCount=" + this.f + ", systemHint=" + this.g + ", errorReason=" + this.h + ", finishReason=" + this.i + ')';
    }

    public i(k r3, k r4, c r5, String r6, List<b> r7, int r8, String r9, e r10, s r11) {
        List<b> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "startStatus");
        o.e(r4, "status");
        o.e(r6, "servedEvidence");
        o.e(r12, "evidence");
        o.e(r11, "finishReason");
        this.f26432a = r3;
        this.f26433b = r4;
        this.f26434c = r5;
        this.f26435d = r6;
        this.f26436e = r12;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }

    public final k a() {
        return this.f26432a;
    }

    public final k b() {
        return this.f26433b;
    }

    public final c c() {
        return this.f26434c;
    }

    public final String d() {
        return this.f26435d;
    }

    public final List<b> e() {
        return this.f26436e;
    }

    public final int f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final e h() {
        return this.h;
    }

    public final s i() {
        return this.i;
    }

    public /* synthetic */ i(k r13, k r14, c r15, String r16, List r17, int r18, String r19, e r20, s r21, int r22, d.h.b.h r23) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        if ((r22 & 64) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r22 & 128) == 0) goto L9;
        e r10 = null;
    L11:
        if ((r22 & 256) == 0) goto L13;
        s r11 = s.f26710a;
    L14:
        this(r13, r14, r15, r16, r7, r18, r9, r10, r11);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }
}
