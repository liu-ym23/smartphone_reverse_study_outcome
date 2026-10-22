package com.obric.aiagent.skill.manager.impl;

/* JADX INFO: compiled from: SkillVersionPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hj f20114a = null;

    static {
        f20114a = new hj();
    }

    public final int a() {
        return 1;
    }

    public final boolean a(int r1) {
        if (r1 >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private hj() {
    }

    public final int b(int r1) {
        boolean r0 = true;
        if (r1 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L9;
        return r1;
    L9:
        throw new IllegalArgumentException("Skill version must be positive.".toString());
    }

    public final int a(Integer r2) {
        boolean r1 = true;
        if (r2 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L12;
        return r2.intValue();
    L12:
        throw new IllegalArgumentException("Shop Skill must contain a positive server version.".toString());
    L5:
        if (r2.intValue() < 1) goto L7;
        goto L7
    }

    public final int c(int r1) {
        return Math.addExact(b(r1), 1);
    }

    public final ec a(int r2, int r3) {
        int r4 = b(r2);
        int r1 = b(r3);
        if (r1 < r4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L12;
        if (r1 != r4) goto L10;
        return ec.f19804a;
    L10:
        return ec.f19805b;
    L12:
        throw new IllegalArgumentException(("Skill downgrade is not supported: " + r4 + " -> " + r1).toString());
    L5:
        r5 = false;
        goto L6
    }

    public final void a(String r2, int r3, int r4) {
        d.h.b.o.e(r2, "slug");
        int r5 = b(r3);
        int r1 = b(r4);
        if (r1 == r5) goto L12;
        if (r1 <= r5) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException(("Skill downgrade is not supported: " + r2 + ' ' + r5 + " -> " + r1).toString());
    L6:
        r6 = false;
        goto L7
    L12:
        throw new IllegalStateException("Skill version is already installed: " + r2 + " version=" + r5);
    }

    public final int a(int r1, Integer r2) {
        int r3 = b(r1);
        int r0 = a(r2);
        if (r0 != r3) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        return r0;
    L9:
        throw new IllegalArgumentException("Downloaded Skill version does not match the requested version.".toString());
    L5:
        r4 = false;
        goto L6
    }
}
