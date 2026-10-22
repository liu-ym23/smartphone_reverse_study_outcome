package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuningVolumeContentArea f70575a;

    public d(TuningVolumeContentArea r100) {
        this.f70575a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        View r102 = this.f70575a.b(TuningVolumeType.EAR_BACK_VOLUME);
        if (r102 == null) goto L6;
        this.f70575a.f70564a.i();
        r102.setVisibility(8);
        return;
    }
}
