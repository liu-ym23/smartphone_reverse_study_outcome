package com.bytedance.android.livesdk.dislike.sharefans.widget;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f122230a = null;

    static {
        f122230a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof ApiServerException) == false) goto L10;
        ApiServerException r102 = (ApiServerException) r101;
        if (TextUtils.isEmpty(r102.getPrompt()) == true) goto L10;
        f2.c(r102.getPrompt(), 0);
    L10:
        f2.b(R.string.ttlive_share_fans_failed, 0);
        ALogger.e("ShareFansWidget", "share failed, error: " + r101.getMessage());
    }
}
