package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/DynamicUtilsKt$packagePlayStatus$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 implements Observer<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f93848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b f93849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f93850c;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L8;
        int r102 = RevPkState.DISABLE.ordinal();
        if (r101.intValue() == r102) goto L8;
        int r103 = r101.intValue();
    L10:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.c() == false) goto L12;
        com.bytedance.revenue.platform.api.core.rx.l r104 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r105 = Observable.just(Integer.valueOf(r103)).map(new a(this));
        int r106 = p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r105.observeOn(Schedulers.single()).subscribe(new b(this), c.f93897a), this.f93850c);
        return;
    L12:
        this.f93848a.setValue(e.a(r103, this.f93849b));
        return;
    L8:
        r103 = RevPkState.FINISHED.ordinal();
        goto L10
    }

    public DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1(MediatorLiveData r100, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b r101, CompositeDisposable r102) {
        this.f93848a = r100;
        this.f93849b = r101;
        this.f93850c = r102;
    }
}
