package com.bytedance.android.live.soloktv.fragment;

import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101204a;

    public c0(SoloKtvEditFragment r100) {
        this.f101204a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SoloKtvEditFragment r101 = this.f101204a;
        int r102 = ((Integer) r100).intValue();
        SeekBarWithProgress r103 = r101.f101154h;
        if (r103 == null) goto L6;
        r103.c(r102);
        return;
    }
}
