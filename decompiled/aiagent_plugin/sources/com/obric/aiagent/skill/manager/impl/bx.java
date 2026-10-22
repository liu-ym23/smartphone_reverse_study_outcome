package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFileReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19629e;
    private final long f;

    /* JADX INFO: compiled from: SkillFileReader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final bx a(com.obric.aiagent.skill.manager.api.al r11) {
            d.h.b.o.e(r11, "settings");
            return new bx(r11.k(), r11.l(), r11.m(), r11.n(), r11.o());
        }
    }

    static {
        f19625a = new a(null);
    }

    public bx() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bx.class) == true) goto L8;
        return false;
    L8:
        bx r10 = (bx) ZeusTransformUtils.preCheckCast(r9, bx.class, "com.obric.aiagent.plugin");
        if (this.f19626b == r10.f19626b) goto L12;
        return false;
    L12:
        if (this.f19627c == r10.f19627c) goto L15;
        return false;
    L15:
        if (this.f19628d == r10.f19628d) goto L18;
        return false;
    L18:
        if (this.f19629e == r10.f19629e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f19626b) * 31) + Integer.hashCode(this.f19627c)) * 31) + Long.hashCode(this.f19628d)) * 31) + Long.hashCode(this.f19629e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "SkillFileReadLimits(maxSourceBytes=" + this.f19626b + ", maxZipEntries=" + this.f19627c + ", maxZipEntryBytes=" + this.f19628d + ", maxZipTotalUncompressedBytes=" + this.f19629e + ", maxSkillMdBytes=" + this.f + ')';
    }

    public bx(long r1, int r3, long r4, long r6, long r8) {
        this.f19626b = r1;
        this.f19627c = r3;
        this.f19628d = r4;
        this.f19629e = r6;
        this.f = r8;
    }

    public /* synthetic */ bx(long r10, int r12, long r13, long r15, long r17, int r19, d.h.b.h r20) {
        if ((r19 & 1) == 0) goto L5;
        long r0 = bz.a().k();
    L7:
        if ((r19 & 2) == 0) goto L9;
        int r2 = bz.a().l();
    L11:
        if ((r19 & 4) == 0) goto L13;
        long r3 = bz.a().m();
    L15:
        if ((r19 & 8) == 0) goto L17;
        long r5 = bz.a().n();
    L19:
        if ((r19 & 16) == 0) goto L21;
        long r7 = bz.a().o();
    L22:
        this(r0, r2, r3, r5, r7);
        return;
    L21:
        r7 = r17;
        goto L22
    L17:
        r5 = r15;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r0 = r10;
        goto L7
    }

    public final long a() {
        return this.f19626b;
    }

    public final int b() {
        return this.f19627c;
    }

    public final long c() {
        return this.f19628d;
    }

    public final long d() {
        return this.f19629e;
    }

    public final long e() {
        return this.f;
    }
}
