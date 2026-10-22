package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ValueAnimator f13460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<a> f13461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f13462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f13463d;

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f13464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f13465b;

        a(int[] r1, ValueAnimator r2) {
            this.f13464a = r1;
            this.f13465b = r2;
        }
    }

    public h() {
        this.f13461b = new ArrayList();
        this.f13462c = null;
        this.f13460a = null;
        this.f13463d = new StateListAnimator$1(this);
    }

    public void a(int[] r2, ValueAnimator r3) {
        a r0 = new a(r2, r3);
        r3.addListener(this.f13463d);
        this.f13461b.add(r0);
    }

    public void a(int[] r6) {
        int r0 = this.f13461b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f13461b.get(r1), a.class, "com.obric.aiagent.plugin");
        if (StateSet.stateSetMatches(r2.f13464a, r6) == true) goto L9;
        r1 = r1 + 1;
    L9:
        a r7 = this.f13462c;
        if (r2 != r7) goto L12;
        return;
    L12:
        if (r7 == null) goto L14;
        b();
    L14:
        this.f13462c = r2;
        if (r2 == null) goto L20;
        a(r2);
        return;
    L20:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private void a(a r1) {
        ValueAnimator r2 = r1.f13465b;
        this.f13460a = r2;
        r2.start();
    }

    private void b() {
        ValueAnimator r0 = this.f13460a;
        if (r0 == null) goto L6;
        r0.cancel();
        this.f13460a = null;
        return;
    }

    public void a() {
        ValueAnimator r0 = this.f13460a;
        if (r0 == null) goto L6;
        r0.end();
        this.f13460a = null;
        return;
    }
}
