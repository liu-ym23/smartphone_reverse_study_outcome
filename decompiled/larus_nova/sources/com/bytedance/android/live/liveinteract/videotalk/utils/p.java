package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.liveinteract.utils.e0;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes46.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f79825a;

    public p(o r100) {
        this.f79825a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        if (r101 == null) goto L6;
        SimpleDateFormat r102 = e0.f78759a;
        e0.c(this.f79825a.f79819e, r101, "video_live_link");
        return;
    }
}
