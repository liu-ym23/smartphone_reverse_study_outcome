package com.obric.aiagent.skill.manager.impl.ui;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f20843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f20844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20845c;

    public w() {
    }

    public final long a() {
        long r0 = this.f20843a + 1;
        this.f20843a = r0;
        this.f20844b = Long.valueOf(r0);
        this.f20845c = false;
        return r0;
    }

    public final Long b() {
        Long r0 = this.f20844b;
        if (r0 == null) goto L9;
        long r2 = r0.longValue();
        if (this.f20845c == false) goto L7;
        return null;
    L7:
        this.f20845c = true;
        return Long.valueOf(r2);
    L9:
        return null;
    }

    public final void c() {
        this.f20844b = null;
        this.f20845c = false;
    }

    public final void d() {
        c();
    }
}
