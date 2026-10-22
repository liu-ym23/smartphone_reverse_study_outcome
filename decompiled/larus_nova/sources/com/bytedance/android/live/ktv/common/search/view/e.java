package com.bytedance.android.live.ktv.common.search.view;

import com.bytedance.android.live.ktv.common.model.api.s;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70305a;

    public e(CommonSearchContainer r100) {
        this.f70305a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List<s> r101 = (List) r100;
        CommonSearchEnterView r102 = CommonSearchContainer.c(this.f70305a);
        if (r102 == null) goto L6;
        r102.j(r101);
        return;
    }
}
