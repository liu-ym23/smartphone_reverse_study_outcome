package com.obric.aiagent.skill.manager.impl.ui;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SkillDetailSigningRefreshGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f20495a;

    public ad() {
        this.f20495a = new AtomicBoolean(false);
    }

    public final boolean a() {
        return this.f20495a.compareAndSet(false, true);
    }

    public final void b() {
        this.f20495a.set(false);
    }
}
