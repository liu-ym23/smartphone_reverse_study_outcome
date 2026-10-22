package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f76869a;

    public a1(DataCenter r100) {
        this.f76869a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        z0.f77180e = null;
        z0.f77182g.f(s1.getContext(), this.f76869a, false);
    }
}
