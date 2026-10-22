package com.bytedance.android.live.ktv.common.search.view;

import com.bytedance.android.live.ktv.common.model.api.u;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70304a;

    public d(CommonSearchContainer r100) {
        this.f70304a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List<u> r101 = (List) r100;
        CommonSearchEnterView r102 = CommonSearchContainer.c(this.f70304a);
        if (r102 == null) goto L6;
        r102.l(r101);
        return;
    }
}
