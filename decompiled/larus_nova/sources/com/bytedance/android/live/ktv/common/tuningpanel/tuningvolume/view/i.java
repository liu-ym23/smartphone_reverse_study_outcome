package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.widget.SeekBar;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gc0.c f70581a;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public i(gc0.c r100) {
        this.f70581a = r100;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        this.f70581a.onProgressChanged(r101);
    }
}
