package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j1 implements com.bytedance.android.scope.o, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Observer<?>> f88901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner f88902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner<Pair<RegionId, j80.d>> f88903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<Pair<RegionId, j80.d>> f88904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner f88905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner f88906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject f88907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner f88908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PublishSubject f88909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject f88910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner f88911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PublishSubject f88912l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PublishSubject f88913m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PublishSubject f88914n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PublishSubject f88915o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PublishSubject f88916p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final yz0.k f88917q;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Iterator<T> r100 = this.f88901a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Observer) r100.next()).onComplete();
        goto L4
    }

    public final <T> PublishSubject<T> y() {
        PublishSubject<T> r100 = PublishSubject.create();
        this.f88901a.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner a() {
        return this.f88905e;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject c() {
        return this.f88916p;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner d() {
        return this.f88908h;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject f() {
        return this.f88907g;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject g() {
        return this.f88915o;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject h() {
        return this.f88910j;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject i() {
        return this.f88913m;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject j() {
        return this.f88909i;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner k() {
        return this.f88911k;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner n() {
        return this.f88903c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject o() {
        return this.f88912l;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PublishSubject q() {
        return this.f88914n;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner s() {
        return this.f88906f;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner w() {
        return this.f88902b;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.l
    public final PropertyOwner x() {
        return this.f88904d;
    }

    public j1(yz0.k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f88917q = r100;
        this.f88901a = new ArrayList();
        Boolean r101 = Boolean.FALSE;
        this.f88902b = A(r101);
        RegionId r102 = RegionId.B;
        PropertyOwner<Pair<RegionId, j80.d>> r103 = A(TuplesKt.to(r102, new j80.d(0.0f, 1.0f)));
        this.f88903c = r103;
        PropertyOwner<Pair<RegionId, j80.d>> r104 = A(TuplesKt.to(r102, new j80.d(0.0f, 1.0f)));
        this.f88904d = r104;
        if (r100.isAnchor() == false) goto L5;
        r103 = r104;
    L5:
        this.f88905e = r103;
        this.f88906f = A(0);
        this.f88907g = y();
        this.f88908h = A(r101);
        this.f88909i = y();
        this.f88910j = y();
        this.f88911k = A(sh6.a.f541970a);
        this.f88912l = y();
        this.f88913m = y();
        this.f88914n = y();
        this.f88915o = y();
        this.f88916p = y();
    }

    public final <T> PropertyOwner<T> A(T r100) {
        PropertyOwner<T> r101 = new PropertyOwner(r100);
        this.f88901a.add(r101);
        return r101;
    }
}
