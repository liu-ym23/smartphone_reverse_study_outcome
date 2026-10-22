package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback f143509a;

    public o(KSongViceSingerTuningButtonOuterCallback r100) {
        this.f143509a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        KSongViceSingerTuningButtonOuterCallback r102 = this.f143509a;
        if (r102.g() == false) goto L8;
        bc0.c r103 = r102.f143481b;
        if (r103 == null) goto L9;
        r103.m2(new KSongViceSingerTuningButtonOuterCallback$checkEchoMode$1(r102, r101), TuningButtonType.ECHO_ITEM, false);
        return;
    L9:
        return;
    }
}
