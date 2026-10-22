package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class l0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StoreSearchSugListPresenter f186097a;

    public l0(StoreSearchSugListPresenter r100) {
        this.f186097a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        int r102 = r101.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L12;
        if (((ArrayList) this.f186097a.E().getSugRequestParam().f469278e).size() >= 3) goto L17;
        List<JSONObject> r103 = this.f186097a.E().getSugRequestParam().f469278e;
        JSONObject r104 = new JSONObject();
        r104.put("query", String.valueOf(((sj3.h) ListProtector.get(r101, r102)).f542282d));
        Date r105 = ((sj3.h) ListProtector.get(r101, r102)).f542283e;
        if (r105 == null) goto L10;
        Long r106 = Long.valueOf(r105.getTime());
    L11:
        r104.put("time", String.valueOf(r106));
        Unit r107 = Unit.INSTANCE;
        ((ArrayList) r103).add(r104);
        goto L3
    L10:
        r106 = null;
        goto L11
    L17:
        return;
    }
}
