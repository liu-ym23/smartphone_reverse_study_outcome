package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.live.core.utils.s1;
import pn0.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.c f75579a;

    public a(f.c r100) {
        this.f75579a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        f.c r102 = this.f75579a;
        Rect r103 = new Rect(0, 0, r102.f529937e, r102.f529938f);
        if (r101 == null) goto L6;
        r101.setRoundRect(r103, s1.f(8.0f));
        return;
    }
}
