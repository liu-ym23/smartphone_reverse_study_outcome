package com.bytedance.android.live.soloktv.view;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustControlTabWrapper f101825a;

    public b(AdjustControlTabWrapper r100) {
        this.f101825a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        AdjustControlTabWrapper r102 = this.f101825a;
        if (r101 == null) goto L8;
        com.bytedance.android.live.ktv.common.model.bean.h r103 = r102.f101659p;
        if (r103 == null) goto L7;
        r103.f69999a = false;
    L7:
        r102.e(r103, (Boolean) r101.getSecond());
        r102.e((com.bytedance.android.live.ktv.common.model.bean.h) r101.getFirst(), (Boolean) r101.getSecond());
        r102.f101659p = (com.bytedance.android.live.ktv.common.model.bean.h) r101.getFirst();
        return;
    L8:
        r102.getClass();
    }
}
