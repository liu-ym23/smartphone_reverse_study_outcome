package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoChorusTopBarControlContainer f144204a;

    public o(VideoChorusTopBarControlContainer r100) {
        this.f144204a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        VideoChorusTopBarControlContainer r101 = this.f144204a;
        int r102 = VideoChorusTopBarControlContainer.f144187s;
        r101.j((jd2.c) r100);
    }
}
