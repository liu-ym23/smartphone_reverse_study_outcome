package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f93479a;

    public d(boolean r100) {
        this.f93479a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        jy0.b.c("ttlive_anchor_link", "updateSetting showScore=" + this.f93479a + " failed " + r101, null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r102 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r102 == null) goto L6;
        r102.n(this.f93479a, r101);
    L6:
        if ((r101 instanceof ApiServerException) == false) goto L9;
        int r103 = ToastUtil.f90810a;
        ToastUtil.b(((ApiServerException) r101).getPrompt(), 0);
        return;
    }
}
