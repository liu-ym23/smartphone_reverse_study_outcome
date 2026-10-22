package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.ds;
import com.obric.aiagent.skill.manager.impl.du;

/* JADX INFO: compiled from: SkillPageTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final br f20662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final du f20663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final du f20664c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final du f20665d = null;

    private br() {
    }

    static {
        f20662a = new br();
        f20663b = new du(dr.f19761b, ds.f19768d);
        f20664c = new du(dr.f19761b, ds.f19767c);
        f20665d = new du(dr.f19760a, ds.f19769e);
    }

    public final du a() {
        return f20663b;
    }

    public final du b() {
        return f20664c;
    }

    public final du c() {
        return f20665d;
    }

    public final du a(dr r2) {
        d.h.b.o.e(r2, "previousPage");
        if (r2 != dr.f19761b) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return new du(r2, ds.f);
    L13:
        throw new IllegalArgumentException("Create/import detail navigation must originate from a Skill list page.".toString());
    L5:
        if (r2 == dr.f19760a) goto L8;
        r1 = false;
        goto L9
    }
}
