package com.bytedance.android.live.soloktv.view;

import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustControlTabWrapper f101828a;

    public e(AdjustControlTabWrapper r100) {
        this.f101828a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AdjustControlTabWrapper r101 = this.f101828a;
        int r102 = ((Integer) r100).intValue();
        SeekBarWithProgress r103 = r101.f101652i;
        if (r103 == null) goto L6;
        r103.c(r102);
        return;
    }
}
