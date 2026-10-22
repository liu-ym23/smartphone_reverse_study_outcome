package com.bytedance.android.live.revenue.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.core.util.g;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class SharedRevenueInstanceService implements o, m, com.bytedance.android.live.revenue.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f91019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f91020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f91021c;

    public static final class a extends DataContext implements j {
        private final b inst;

        public final void shareAsCurrent() {
            j.a r100 = j.C0;
            int r101 = com.bytedance.live.datacontext.d.f255080a;
            Intrinsics.checkNotNullParameter(this, "self");
            com.bytedance.live.datacontext.b.a(this, r100);
        }

        @Override // com.bytedance.android.live.revenue.core.util.j
        public b getInst() {
            return this.inst;
        }

        public a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "inst");
            this.inst = r100;
        }

        public final void shareToLiveRoom(IAbilityCenter r100) {
            int r101 = g.f91035a;
            b r102 = getInst();
            Intrinsics.checkNotNullParameter(r102, "instance");
            g.a r103 = new g.a((com.bytedance.android.live.revenue.core.a) r102);
            if (r100 == null) goto L6;
            r100.registerAbility(g.a.class, r103);
            return;
        }
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r100 = this.f91021c;
        r100.b(com.bytedance.android.live.revenue.b.class, r100.getScope());
        Pair r101 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(this));
        a r102 = (a) r101.component1();
        this.f91019a = (Disposable) r101.component2();
        this.f91020b = r102;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f91019a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f91019a = null;
    }

    @Override // com.bytedance.android.live.revenue.b
    public final void shareAsCurrent() {
        a r100 = this.f91020b;
        if (r100 == null) goto L5;
        r100.shareAsCurrent();
    L5:
        StringBuilder r101 = new StringBuilder("shareAsCurrent");
        a r102 = this.f91020b;
        if (r102 == null) goto L8;
        int r103 = r102.hashCode();
    L9:
        r101.append(r103);
        ALogger.d("SharedRevenueInstanceService", r101.toString());
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // yz0.m
    public final void i() {
        shareAsCurrent();
    }

    public SharedRevenueInstanceService(com.bytedance.android.live.revenue.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f91021c = r100;
    }

    @Override // com.bytedance.android.live.revenue.b
    public final void shareToLiveRoom(IAbilityCenter r100) {
        a r101 = this.f91020b;
        if (r101 == null) goto L6;
        r101.shareToLiveRoom(r100);
        return;
    }
}
