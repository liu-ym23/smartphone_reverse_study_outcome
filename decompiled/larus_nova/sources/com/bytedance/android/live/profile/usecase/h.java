package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f87015a;

    public h(f r100) {
        this.f87015a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f87015a.f86999a = false;
        if ((r101 instanceof ApiServerException) == true) goto L5;
        r101 = null;
    L5:
        ApiServerException r102 = (ApiServerException) r101;
        if (r102 == null) goto L8;
        f2.c(r102.getPrompt(), 0);
        return;
    L8:
        f2.b(R.string.ttlive_live_follow_failed, 0);
    }
}
