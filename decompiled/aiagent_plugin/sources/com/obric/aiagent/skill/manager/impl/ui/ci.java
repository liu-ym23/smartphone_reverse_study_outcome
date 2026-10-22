package com.obric.aiagent.skill.manager.impl.ui;

/* JADX INFO: compiled from: SkillSourceIconBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ci f20750a = null;

    static {
        f20750a = new ci();
    }

    private ci() {
    }

    public final String a(String r1) {
        d.h.b.o.e(r1, "url");
        return bi.f20643a.a(r1);
    }

    public final int a(float r1, float r2) {
        return d.l.n.c((int) Math.ceil((r1 * 2.0f) * r2), 1);
    }

    public final boolean a(cj r1, String r2, int r3, boolean r4) {
        d.h.b.o.e(r2, "nextCanonicalUrl");
        if (r1 == null) goto L13;
        if (r4 == true) goto L7;
        return true;
    L7:
        if (d.h.b.o.a(r1.a(), r2) == true) goto L9;
        return true;
    L9:
        if (r1.b() != r3) goto L16;
        return false;
    L16:
        return true;
    L13:
        return true;
    }
}
