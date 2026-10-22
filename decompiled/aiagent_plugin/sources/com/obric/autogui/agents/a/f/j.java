package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectPolicyModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f26437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f26438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f26441e;
    private final int f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    public static /* synthetic */ j a(j r15, a r16, List r17, long r18, int r20, long r21, int r23, boolean r24, int r25, int r26, int r27, int r28, int r29, int r30, Object r31) {
        List<c> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        if ((r30 & 1) == 0) goto L5;
        a r3 = r15.f26437a;
    L7:
        if ((r30 & 2) == 0) goto L10;
        r2 = r15.f26438b;
    L10:
        if ((r30 & 4) == 0) goto L12;
        long r4 = r15.f26439c;
    L14:
        if ((r30 & 8) == 0) goto L16;
        int r6 = r15.f26440d;
    L18:
        if ((r30 & 16) == 0) goto L20;
        long r7 = r15.f26441e;
    L22:
        if ((r30 & 32) == 0) goto L24;
        int r9 = r15.f;
    L26:
        if ((r30 & 64) == 0) goto L28;
        boolean r10 = r15.g;
    L30:
        if ((r30 & 128) == 0) goto L32;
        int r11 = r15.h;
    L34:
        if ((r30 & 256) == 0) goto L36;
        int r12 = r15.i;
    L38:
        if ((r30 & 512) == 0) goto L40;
        int r13 = r15.j;
    L42:
        if ((r30 & 1024) == 0) goto L44;
        int r14 = r15.k;
    L46:
        if ((r30 & 2048) == 0) goto L48;
        int r1 = r15.l;
    L50:
        return r15.a(r3, r2, r4, r6, r7, r9, r10, r11, r12, r13, r14, r1);
    L48:
        r1 = r29;
        goto L50
    L44:
        r14 = r28;
        goto L46
    L40:
        r13 = r27;
        goto L42
    L36:
        r12 = r26;
        goto L38
    L32:
        r11 = r25;
        goto L34
    L28:
        r10 = r24;
        goto L30
    L24:
        r9 = r23;
        goto L26
    L20:
        r7 = r21;
        goto L22
    L16:
        r6 = r20;
        goto L18
    L12:
        r4 = r18;
        goto L14
    L5:
        r3 = r16;
        goto L7
    }

    public final j a(a r17, List<? extends c> r18, long r19, int r21, long r22, int r24, boolean r25, int r26, int r27, int r28, int r29, int r30) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        o.e(r17, "action");
        o.e(r3, "detectors");
        return new j(r17, r3, r19, r21, r22, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (this.f26437a == r10.f26437a) goto L12;
        return false;
    L12:
        if (o.a(this.f26438b, r10.f26438b) == true) goto L15;
        return false;
    L15:
        if (this.f26439c == r10.f26439c) goto L18;
        return false;
    L18:
        if (this.f26440d == r10.f26440d) goto L21;
        return false;
    L21:
        if (this.f26441e == r10.f26441e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f26437a.hashCode() * 31) + this.f26438b.hashCode()) * 31) + Long.hashCode(this.f26439c)) * 31) + Integer.hashCode(this.f26440d)) * 31) + Long.hashCode(this.f26441e)) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ActionEffectPolicy(action=").append(this.f26437a).append(", detectors=").append(this.f26438b).append(", detectIntervalMs=").append(this.f26439c).append(", maxDetectCount=").append(this.f26440d).append(", timeoutMs=").append(this.f26441e).append(", tolerancePermille=").append(this.f).append(", imagePixelCompareEnabled=").append(this.g).append(", imagePixelDeltaThreshold=").append(this.h).append(", imageGlobalChangedPermille=").append(this.i).append(", imageBlockChangedPermille=").append(this.j).append(", imageClickRegionRadiusPermille=").append(this.k).append(", imageClickRegionChangedPermille=");
        r0.append(this.l).append(')');
        return r0.toString();
    }

    public j(a r6, List<? extends c> r7, long r8, int r10, long r11, int r13, boolean r14, int r15, int r16, int r17, int r18, int r19) {
        List<c> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "action");
        o.e(r2, "detectors");
        this.f26437a = r6;
        this.f26438b = r2;
        this.f26439c = r8;
        this.f26440d = r10;
        this.f26441e = r11;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
    }

    public /* synthetic */ j(a r18, List r19, long r20, int r22, long r23, int r25, boolean r26, int r27, int r28, int r29, int r30, int r31, int r32, d.h.b.h r33) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if ((r32 & 64) == 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r32 & 128) == 0) goto L9;
        int r12 = 16;
    L11:
        if ((r32 & 256) == 0) goto L13;
        int r13 = 50;
    L15:
        if ((r32 & 512) == 0) goto L17;
        int r14 = 150;
    L19:
        if ((r32 & 1024) == 0) goto L21;
        int r15 = 80;
    L23:
        if ((r32 & 2048) == 0) goto L25;
        int r16 = 200;
    L26:
        this(r18, r4, r20, r22, r23, r25, r11, r12, r13, r14, r15, r16);
        return;
    L25:
        r16 = r31;
        goto L26
    L21:
        r15 = r30;
        goto L23
    L17:
        r14 = r29;
        goto L19
    L13:
        r13 = r28;
        goto L15
    L9:
        r12 = r27;
        goto L11
    L5:
        r11 = r26;
        goto L7
    }

    public final a a() {
        return this.f26437a;
    }

    public final List<c> b() {
        return this.f26438b;
    }

    public final long c() {
        return this.f26439c;
    }

    public final int d() {
        return this.f26440d;
    }

    public final long e() {
        return this.f26441e;
    }

    public final int f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final int i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final int l() {
        return this.l;
    }
}
