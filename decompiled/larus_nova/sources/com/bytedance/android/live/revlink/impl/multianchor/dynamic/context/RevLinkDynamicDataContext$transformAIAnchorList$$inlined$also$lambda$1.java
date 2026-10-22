package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevLinkDynamicDataContext$transformAIAnchorList$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/link/model/e;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 implements Observer<List<? extends com.bytedance.android.livesdk.link.model.e>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f93933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f93934b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L6;
        com.bytedance.revenue.platform.api.core.rx.l r102 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r103 = Observable.just(r101).map(y.f94071a);
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.observeOn(Schedulers.single()).subscribe(new x(this), z.f94073a), this.f93934b.f93971d);
        return;
    }

    public RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1(MediatorLiveData r100, e0 r101) {
        this.f93933a = r100;
        this.f93934b = r101;
    }
}
