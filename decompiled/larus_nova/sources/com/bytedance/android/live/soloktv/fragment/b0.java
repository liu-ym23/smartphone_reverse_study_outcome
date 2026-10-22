package com.bytedance.android.live.soloktv.fragment;

import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101202a;

    public b0(SoloKtvEditFragment r100) {
        this.f101202a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SoloKtvEditFragment r101 = this.f101202a;
        int r102 = ((Integer) r100).intValue();
        SeekBarWithProgress r103 = r101.f101153g;
        if (r103 == null) goto L6;
        r103.c(r102);
        return;
    }
}
