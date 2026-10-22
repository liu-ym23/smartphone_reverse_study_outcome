package com.bytedance.android.live.profit.livepet.container;

import android.view.ViewGroup;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f87845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f87846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f87847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f87848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<com.bytedance.android.live.profit.livepet.container.a> f87849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject f87850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.k f87851g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f87845a.dispose();
        this.f87846b = null;
    }

    public e(yz0.k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f87851g = r100;
        this.f87845a = new CompositeDisposable();
        n r101 = new n();
        this.f87847c = r101;
        this.f87848d = new k(r101);
        PublishSubject<com.bytedance.android.live.profit.livepet.container.a> r102 = PublishSubject.create();
        this.f87849e = r102;
        this.f87850f = r102;
    }

    public static final void a(e r100, com.bytedance.android.live.profit.livepet.container.a r101) {
        if (Intrinsics.areEqual(r101, r100.f87847c) == false) goto L6;
        jy0.b.a("LivePet/LayoutManager", "petContainerRegion: " + m.a(r101));
    L8:
        r100.f87849e.onNext(r101);
        return;
    L6:
        if (Intrinsics.areEqual(r101, r100.f87848d) == false) goto L8;
        jy0.b.a("LivePet/LayoutManager", "interactAreaRegion: " + m.a(r100.f87848d));
        goto L8
    }
}
