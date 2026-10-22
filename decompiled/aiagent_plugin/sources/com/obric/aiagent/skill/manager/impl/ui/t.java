package com.obric.aiagent.skill.manager.impl.ui;

/* JADX INFO: compiled from: SkillCoverBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f20819a = null;

    static {
        f20819a = new t();
    }

    private t() {
    }

    public final String a(String r1) {
        d.h.b.o.e(r1, "url");
        return bi.f20643a.a(r1);
    }

    public final boolean a(u r1, String r2, float r3, boolean r4, boolean r5) {
        d.h.b.o.e(r2, "nextCanonicalUrl");
        if (r1 == null) goto L18;
        if (r5 == true) goto L7;
        return true;
    L7:
        if (d.h.b.o.a(r1.a(), r2) == true) goto L9;
        return true;
    L9:
        if (r1.b() != r3) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
        return true;
    L14:
        if (r1.c() == r4) goto L17;
        return true;
    L17:
        return false;
    L11:
        r6 = false;
        goto L12
    L18:
        return true;
    }
}
