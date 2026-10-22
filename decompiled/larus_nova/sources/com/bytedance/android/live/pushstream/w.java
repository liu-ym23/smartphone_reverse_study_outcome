package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f89529a;

    public w(y r100) {
        this.f89529a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("LiveStream", "VideoAntiShakeChangedEvent:" + ((pv0.i) r100).f530786a);
        this.f89529a.getClass();
    }
}
