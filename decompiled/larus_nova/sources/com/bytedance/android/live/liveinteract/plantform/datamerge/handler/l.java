package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f76459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f76460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f76461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final eg6.b f76462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f76463f;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        eg6.b r100 = this.f76462e;
        if (r100 == null) goto L6;
        r100.h0(this.f76459b);
    L6:
        if (this.f76463f == false) goto L9;
        this.f76460c = Observable.timer(vm2.d.T(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        eg6.b r100 = this.f76462e;
        if (r100 == null) goto L5;
        r100.s(this.f76459b);
    L5:
        Disposable r101 = this.f76460c;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "oldMergeDataList");
        boolean r101 = this.f76461d;
        if (r101 == false) goto L6;
        this.f76461d = false;
    L6:
        return new h.a(r101, r100, null);
    }

    public l(hg6.g r100, boolean r101) {
        this.f76462e = r100;
        this.f76463f = r101;
        this.f76459b = new j(this);
    }
}
