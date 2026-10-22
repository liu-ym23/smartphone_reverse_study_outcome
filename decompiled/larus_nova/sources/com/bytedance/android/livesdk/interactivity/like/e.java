package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f137661a;

    public e(d r100) {
        this.f137661a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        ALogger.i("DiggHandler", "post remaining digg success, room id: " + this.f137661a.f137656d + ", target uid " + this.f137661a.f137657e);
    }
}
