package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.adjust.view.ToneProcessView;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f70567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gc0.a f70568b;

    public a(c r100, gc0.a r101) {
        this.f70567a = r100;
        this.f70568b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f70568b.d(TuningVolumeType.TONE_VOLUME) == true) goto L5;
        return;
    L5:
        ToneProcessView r101 = this.f70567a.getToneProcess();
        if (r101 == null) goto L14;
        int r102 = r101.f69454j;
        if (r102 <= 1) goto L10;
        r101.f69454j = r102 - 1;
        r101.invalidate();
        boolean r103 = true;
    L11:
        if (r103 != true) goto L15;
        this.f70568b.c();
        return;
    L15:
        return;
    L10:
        r103 = false;
        goto L11
    }
}
