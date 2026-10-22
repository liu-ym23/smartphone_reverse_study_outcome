package com.bytedance.android.live.ktv.common.search.view;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f70311b;

    public i(CommonSearchContainer r100, List r101) {
        this.f70310a = r100;
        this.f70311b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r102 = CommonSearchContainer.a(this.f70310a);
        if (r102 == null) goto L6;
        r102.updateCurSearchKeyword(null);
        return;
    }
}
