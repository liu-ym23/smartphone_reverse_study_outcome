package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f71466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f71467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f71468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f71469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f71470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f71471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f71472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f71473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f71474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f71475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Unit> f71476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PublishSubject<Unit> f71477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PublishSubject<Unit> f71478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PublishSubject<Unit> f71479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PublishSubject<Unit> f71480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PublishSubject<Unit> f71481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PublishSubject<Unit> f71482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PublishSubject<Unit> f71483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PublishSubject<Unit> f71484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PublishSubject<Unit> f71485t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CompositeDisposable f71486u;

    public final void a() {
        this.f71486u.clear();
        this.f71466a = 0;
        PublishSubject<Unit> r100 = this.f71476k;
        Unit r101 = Unit.INSTANCE;
        r100.onNext(r101);
        this.f71467b = 0 - this.f71466a;
        this.f71477l.onNext(r101);
        this.f71468c = 0 - this.f71466a;
        this.f71478m.onNext(r101);
        this.f71469d = 0 - this.f71466a;
        this.f71479n.onNext(r101);
        this.f71470e = 0 - this.f71466a;
        this.f71480o.onNext(r101);
        this.f71471f = 0 - this.f71466a;
        this.f71481p.onNext(r101);
        this.f71472g = 0 - this.f71466a;
        this.f71482q.onNext(r101);
        this.f71473h = 0 - this.f71466a;
        this.f71483r.onNext(r101);
        this.f71474i = 0 - this.f71466a;
        this.f71484s.onNext(r101);
        this.f71475j = 0 - this.f71466a;
        this.f71485t.onNext(r101);
    }

    public final String toString() {
        return "LoadDurationMonitorData(clickTimeInMillis=" + this.f71466a + ", startGameApiRequest=" + this.f71467b + ", startGameApiSucccess=" + this.f71468c + ", receivedStartGameMsg=" + this.f71469d + ", startGameStateMachineTransition=" + this.f71470e + ", receivedSwitchSceneMsg=" + this.f71471f + ", startSwitchScene=" + this.f71472g + ", switchSceneSuccess=" + this.f71473h + ", uiRenderStart=" + this.f71474i + ", uiRenderEnd=" + this.f71475j + ')';
    }

    public e() {
        this.f71476k = PublishSubject.create();
        this.f71477l = PublishSubject.create();
        this.f71478m = PublishSubject.create();
        this.f71479n = PublishSubject.create();
        this.f71480o = PublishSubject.create();
        this.f71481p = PublishSubject.create();
        this.f71482q = PublishSubject.create();
        this.f71483r = PublishSubject.create();
        this.f71484s = PublishSubject.create();
        this.f71485t = PublishSubject.create();
        this.f71486u = new CompositeDisposable();
    }
}
