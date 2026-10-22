package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongTuningButtonOuterCallback f143483a;

    public c(KSongTuningButtonOuterCallback r100) {
        this.f143483a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ((Boolean) r100).booleanValue();
        KSongTuningButtonOuterCallback r101 = this.f143483a;
        bc0.c r102 = r101.f143473b;
        if (r102 == null) goto L6;
        r102.m2(new KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(r101), TuningButtonType.ORIGIN_ITEM, false);
        return;
    }
}
