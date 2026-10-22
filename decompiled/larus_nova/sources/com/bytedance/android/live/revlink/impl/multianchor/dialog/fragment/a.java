package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f93473a = null;

    static {
        f93473a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        ToastUtil.a(R.string.ttlive_anchor_link_setting_cleared_ext_score_toast, 0);
        jy0.b.d("ttlive_anchor_link", "clear ext score success");
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r102 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r102 == null) goto L6;
        int r103 = com.bytedance.android.live.revlink.impl.multianchor.profit.a.f94618e;
        r102.m(null);
        return;
    }
}
