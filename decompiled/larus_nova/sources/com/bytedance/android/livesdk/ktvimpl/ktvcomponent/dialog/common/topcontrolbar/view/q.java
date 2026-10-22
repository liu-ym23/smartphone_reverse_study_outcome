package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoChorusTopBarControlContainer f144206a;

    public q(VideoChorusTopBarControlContainer r100) {
        this.f144206a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        jd2.a r101 = (jd2.a) r100;
        if (r101 == null) goto L13;
        int r102 = r101.f498218b;
        if (r102 <= 0) goto L14;
        VideoChorusTopBarControlContainer r103 = this.f144206a;
        boolean r104 = true;
        if (r102 == 1) goto L11;
        r104 = false;
    L11:
        r103.e(r104);
        return;
    L14:
        return;
    }
}
