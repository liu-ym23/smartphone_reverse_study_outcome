package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f137678a;

    public j(d r100) {
        this.f137678a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        ALogger.i("DiggHandler", "digg success, room id: " + this.f137678a.f137656d + ", target uid " + this.f137678a.f137657e + "; current diggCount: " + this.f137678a.f137654b);
    }
}
