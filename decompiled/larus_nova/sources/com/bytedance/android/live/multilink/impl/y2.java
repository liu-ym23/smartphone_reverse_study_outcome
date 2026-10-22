package com.bytedance.android.live.multilink.impl;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;

/* JADX INFO: loaded from: classes46.dex */
public final class y2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkSeiIndicator f83559a;

    public y2(MultiLinkSeiIndicator r100) {
        this.f83559a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((SwitchResolutionResult) r100).isSuccess() == false) goto L8;
        MultiLinkSeiIndicator r101 = this.f83559a;
        int r102 = r101.f83318g;
        if (r102 <= 0) goto L9;
        r101.b(r102, MultiLinkSeiIndicator.Source.SWITCH_RESOLUTION);
        MultiLinkSeiIndicator r103 = this.f83559a;
        r103.f83314c = -1;
        r103.f83315d = -1;
        r103.f83316e = 0;
        r103.f83317f = 0;
        return;
    L9:
        return;
    }
}
