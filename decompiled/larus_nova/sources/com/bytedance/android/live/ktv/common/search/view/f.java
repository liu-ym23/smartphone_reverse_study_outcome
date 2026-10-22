package com.bytedance.android.live.ktv.common.search.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70306a;

    public f(CommonSearchContainer r100) {
        this.f70306a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CommonSearchContainer r101 = this.f70306a;
        CommonSearchContainer.e(r101, (List) r100);
    }
}
