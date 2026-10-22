package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/context/RevLinkDynamicDataContext$transformLinkAnchorInfo$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkDynamicDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1 implements Observer<List<? extends com.bytedance.android.livesdk.link.model.p>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f93935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f93936b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.c() == false) goto L7;
        com.bytedance.revenue.platform.api.core.rx.l r102 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        Observable r103 = Observable.just(r101).map(b0.f93964a);
        int r104 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.observeOn(Schedulers.single()).subscribe(new a0(this), c0.f93965a), this.f93936b.f93971d);
        return;
    L7:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        r105.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r106.next())));
        goto L9
    L11:
        MediatorLiveData r107 = this.f93935a;
        int r108 = com.bytedance.revenue.platform.api.core.b.f267506a;
        Object r109 = JSONObject.wrap(r105);
        if (r109 == null) goto L15;
        r107.setValue((JSONArray) r109);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONArray /* = org.json.JSONArray */");
    }

    public RevLinkDynamicDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(MediatorLiveData r100, e0 r101) {
        this.f93935a = r100;
        this.f93936b = r101;
    }
}
