package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevNewDynamicFeedDataContext$transformLinkAnchorInfo$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1 implements Observer<List<? extends com.bytedance.android.livesdk.link.model.p>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f93947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f93948b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.d() == false) goto L5;
        com.bytedance.revenue.platform.api.core.rx.l r102 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r103 = Observable.just(r101).map(w0.f94068a);
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.observeOn(Schedulers.single()).subscribe(new v0(this), x0.f94070a), this.f93948b.f94039a);
        return;
    L5:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r105.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r106.next())));
        goto L7
    L9:
        MediatorLiveData r107 = this.f93947a;
        int r108 = com.bytedance.revenue.platform.api.core.b.f267506a;
        Object r109 = JSONObject.wrap(r105);
        if (r109 == null) goto L14;
        r107.setValue((JSONArray) r109);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(MediatorLiveData r100, o0 r101) {
        this.f93947a = r100;
        this.f93948b = r101;
    }
}
