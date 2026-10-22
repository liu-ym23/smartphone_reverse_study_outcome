package com.bytedance.android.live.soloktv.fragment;

import android.widget.SeekBar;
import com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101231a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public w(SoloKtvEditFragment r100) {
        this.f101231a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L7;
        SoloKtvEditViewModel r103 = this.f101231a.f101160n;
        if (r103 == null) goto L8;
        r103.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.q(r101));
        return;
    L8:
        return;
    }
}
