package com.obric.common.oea.foundation.animation.manager;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnimatableStateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f32457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f32458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.common.oea.foundation.animation.d.b f32459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.common.oea.foundation.animation.d.a f32460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<? extends com.obric.common.oea.foundation.animation.a<?>> f32461e;
    private WeakReference<View> f;
    private long g;
    private int h;
    private float i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    public c() {
        this.f32458b = 60.0f;
        this.f32459c = com.obric.common.oea.foundation.animation.d.b.f32344a;
        this.f32460d = com.obric.common.oea.foundation.animation.d.a.f32340a;
        this.f32461e = p.b();
        this.h = -1;
        this.i = 1.0f;
        this.m = true;
    }

    public final boolean a() {
        return this.m;
    }

    public final void a(float r1) {
        this.f32458b = r1;
    }

    public final float b() {
        return this.f32458b;
    }

    public final void a(com.obric.common.oea.foundation.animation.d.b r2) {
        o.e(r2, "runMode");
        this.f32459c = r2;
    }

    public final void a(com.obric.common.oea.foundation.animation.d.a r2) {
        o.e(r2, "repeatMode");
        this.f32460d = r2;
    }

    public final void a(List<? extends com.obric.common.oea.foundation.animation.a<?>> r3) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "animationInfos");
        this.f32461e = r4;
    }

    public final void a(View r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.m = r0;
        this.f = new WeakReference(r2);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public final void b(float r1) {
        this.i = r1;
    }

    public final boolean c() {
        return this.j;
    }

    public final void d() {
        this.j = true;
    }

    public final void e() {
        if (this.j == false) goto L6;
        this.j = false;
        return;
    }

    public final void a(boolean r6) {
        WeakReference<View> r0 = this.f;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f32461e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin")).a(false, false, r6);
        goto L7
    L9:
        this.g = 0;
        this.h = -1;
        this.i = 1.0f;
        this.j = false;
        this.k = 0;
        this.l = 0;
    }

    public final boolean f() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f32461e, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin")).c() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final View g() {
        WeakReference<View> r2 = this.f;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.common.oea.foundation.animation.d.b h() {
        return this.f32459c;
    }

    public final com.obric.common.oea.foundation.animation.d.a i() {
        return this.f32460d;
    }

    public final List<com.obric.common.oea.foundation.animation.a<?>> j() {
        return this.f32461e;
    }

    public final float k() {
        return this.i;
    }

    public final long l() {
        return this.g;
    }

    public final void a(long r1) {
        this.g = r1;
    }

    public final long m() {
        return this.f32457a;
    }

    public final void b(long r1) {
        this.f32457a = r1;
    }

    public final long n() {
        return this.k;
    }

    public final void c(long r1) {
        this.k = r1;
    }

    public final long o() {
        return this.l;
    }

    public final void d(long r1) {
        this.l = r1;
    }

    public final int p() {
        return this.h;
    }

    public final void a(int r1) {
        this.h = r1;
    }

    public final boolean q() {
        return this.n;
    }

    public final void b(boolean r1) {
        this.n = r1;
    }
}
