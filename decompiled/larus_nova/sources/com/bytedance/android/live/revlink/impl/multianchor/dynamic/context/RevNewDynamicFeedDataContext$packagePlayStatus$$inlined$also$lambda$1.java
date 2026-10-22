package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevNewDynamicFeedDataContext$packagePlayStatus$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 implements Observer<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f93945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f93946b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        int r101 = ((Number) r100).intValue();
        if (r101 != RevPkState.DISABLE.ordinal()) goto L6;
        r101 = RevPkState.FINISHED.ordinal();
    L6:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.d() == false) goto L8;
        com.bytedance.revenue.platform.api.core.rx.l r102 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r103 = Observable.just(Integer.valueOf(r101)).map(new s0(this));
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.observeOn(Schedulers.single()).subscribe(new t0(this), u0.f94064a), this.f93946b.f94039a);
        return;
    L8:
        this.f93945a.setValue(o0.i(this.f93946b, r101));
    }

    public RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1(MediatorLiveData r100, o0 r101) {
        this.f93945a = r100;
        this.f93946b = r101;
    }
}
