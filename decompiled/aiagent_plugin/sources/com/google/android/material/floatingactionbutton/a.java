package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: compiled from: AnimatorTracker.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f13400a;

    a() {
    }

    public void a(Animator r1) {
        a();
        this.f13400a = r1;
    }

    public void a() {
        Animator r0 = this.f13400a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void b() {
        this.f13400a = null;
    }
}
