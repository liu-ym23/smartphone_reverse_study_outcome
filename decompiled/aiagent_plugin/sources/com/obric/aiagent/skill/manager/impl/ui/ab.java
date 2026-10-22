package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDetailSigningProgressStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f20491e;
    private final int f;
    private final int g;
    private final long h;
    private final boolean i;

    /* JADX INFO: compiled from: SkillDetailSigningProgressStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f20487a = new a(null);
    }

    public ab() {
        this(0, null, 0, 0, 0, 0, 0, false, 255, null);
    }

    public static /* synthetic */ ab a(ab r11, int r12, String r13, int r14, long r15, int r17, int r18, long r19, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r2 = r11.f20488b;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.f20489c;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r4 = r11.f20490d;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r5 = r11.f20491e;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r7 = r11.f;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r8 = r11.g;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r9 = r11.h;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r1 = r11.i;
    L35:
        return r11.a(r2, r3, r4, r5, r7, r8, r9, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final ab a(int r13, String r14, int r15, long r16, int r18, int r19, long r20, boolean r22) {
        d.h.b.o.e(r14, "slug");
        return new ab(r13, r14, r15, r16, r18, r19, r20, r22);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == true) goto L8;
        return false;
    L8:
        ab r10 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin");
        if (this.f20488b == r10.f20488b) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20489c, r10.f20489c) == true) goto L15;
        return false;
    L15:
        if (this.f20490d == r10.f20490d) goto L18;
        return false;
    L18:
        if (this.f20491e == r10.f20491e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.f20488b) * 31) + this.f20489c.hashCode()) * 31) + Integer.hashCode(this.f20490d)) * 31) + Long.hashCode(this.f20491e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public String toString() {
        return "SkillDetailSigningProgress(schemaVersion=" + this.f20488b + ", slug=" + this.f20489c + ", skillVersion=" + this.f20490d + ", seed=" + this.f20491e + ", completedTicks=" + this.f + ", progress=" + this.g + ", lastHealthyRefreshAtMs=" + this.h + ", pausedByRefreshFailure=" + this.i + ')';
    }

    public ab(int r2, String r3, int r4, long r5, int r7, int r8, long r9, boolean r11) {
        d.h.b.o.e(r3, "slug");
        this.f20488b = r2;
        this.f20489c = r3;
        this.f20490d = r4;
        this.f20491e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
    }

    public /* synthetic */ ab(int r13, String r14, int r15, long r16, int r18, int r19, long r20, boolean r22, int r23, d.h.b.h r24) {
        if ((r23 & 1) == 0) goto L5;
        int r1 = 1;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r2 = "";
    L10:
        boolean r4 = false;
        if ((r23 & 4) == 0) goto L13;
        int r3 = 0;
    L14:
        long r6 = 0;
        if ((r23 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r5 = 0;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r23 & 64) != 0) goto L31;
        r6 = r20;
    L31:
        if ((r23 & 128) != 0) goto L34;
        r4 = r22;
    L34:
        this(r1, r2, r3, r8, r5, r10, r6, r4);
        return;
    L25:
        r10 = r19;
        goto L27
    L21:
        r5 = r18;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L14
    L9:
        r2 = r14;
        goto L10
    L5:
        r1 = r13;
        goto L7
    }

    public final int a() {
        return this.f20488b;
    }

    public final String b() {
        return this.f20489c;
    }

    public final int c() {
        return this.f20490d;
    }

    public final long d() {
        return this.f20491e;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final long g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }
}
