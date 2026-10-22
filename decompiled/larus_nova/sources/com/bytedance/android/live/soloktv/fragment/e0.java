package com.bytedance.android.live.soloktv.fragment;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class e0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101208a;

    public e0(SoloKtvEditFragment r100) {
        this.f101208a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        SoloKtvEditFragment r102 = this.f101208a;
        if (r101 == null) goto L8;
        com.bytedance.android.live.ktv.common.model.bean.h r103 = r102.f101161o;
        if (r103 == null) goto L7;
        r103.f69999a = false;
    L7:
        r102.U90(r103, (Boolean) r101.getSecond());
        r102.U90((com.bytedance.android.live.ktv.common.model.bean.h) r101.getFirst(), (Boolean) r101.getSecond());
        r102.f101161o = (com.bytedance.android.live.ktv.common.model.bean.h) r101.getFirst();
        return;
    L8:
        int r104 = SoloKtvEditFragment.f101149u;
        r102.getClass();
    }
}
