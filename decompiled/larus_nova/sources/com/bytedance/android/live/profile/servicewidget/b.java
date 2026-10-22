package com.bytedance.android.live.profile.servicewidget;

import android.text.TextUtils;
import com.baidu.platform.comapi.UIMsg;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f86189a = null;

    static {
        f86189a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ApiServerException) == false) goto L7;
        ApiServerException r102 = (ApiServerException) r101;
        if (TextUtils.isEmpty(r102.getPrompt()) == true) goto L7;
        f2.c(r102.getPrompt(), 0);
        return;
    L7:
        f2.c(UIMsg.UI_TIP_SERVER_ERROR, 0);
    }
}
