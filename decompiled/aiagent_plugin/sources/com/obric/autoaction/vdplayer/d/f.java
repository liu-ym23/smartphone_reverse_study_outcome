package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Float> f25481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Float> f25482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f25483d;

    public f() {
        this(null, null, null, 0, 15, null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, f.class) == true) goto L8;
        return false;
    L8:
        f r8 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f25480a, r8.f25480a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f25481b, r8.f25481b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f25482c, r8.f25482c) == true) goto L18;
        return false;
    L18:
        if (this.f25483d == r8.f25483d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f25480a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Float> r4 = this.f25481b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Float> r7 = this.f25482c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + Long.hashCode(this.f25483d);
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CursorActionState(thought=" + this.f25480a + ", clickPos=" + this.f25481b + ", swipePos=" + this.f25482c + ", seqId=" + this.f25483d + ')';
    }

    public f(String r3, List<Float> r4, List<Float> r5, long r6) {
        List<Float> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<Float> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f25480a = r3;
        this.f25481b = r7;
        this.f25482c = r8;
        this.f25483d = r6;
    }

    public /* synthetic */ f(String r8, List r9, List r10, long r11, int r13, d.h.b.h r14) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = 0;
    L17:
        this(r2, r3, r4, r11);
        return;
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final String a() {
        return this.f25480a;
    }

    public final List<Float> b() {
        return this.f25481b;
    }

    public final List<Float> c() {
        return this.f25482c;
    }
}
