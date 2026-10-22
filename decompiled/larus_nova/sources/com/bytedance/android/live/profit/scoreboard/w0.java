package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class w0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0.e f89007a;

    public w0(r0.e r100) {
        this.f89007a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r0 r102 = this.f89007a.f88964a;
        int r103 = r0.f88954g;
        r102.getClass();
        String r104 = null;
        if ((r101 instanceof ApiServerException) == true) goto L5;
        r101 = null;
    L5:
        ApiServerException r105 = (ApiServerException) r101;
        if (r105 == null) goto L15;
        String r106 = r105.getPrompt();
        if (r106 == null) goto L15;
        if (r106.length() <= 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        r104 = r106;
        goto L15
    L12:
        r107 = false;
    L15:
        if (r104 == null) goto L17;
        ToastUtil.b(r104, 0);
        return;
    L17:
        ToastUtil.a(R.string.ttlive_scoreboard_toast_server_error, 0);
    }
}
