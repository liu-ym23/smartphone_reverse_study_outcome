package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import org.json.JSONException;

/* JADX INFO: loaded from: classes45.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkRequestMethod f60454a;

    public e0(NetworkRequestMethod r100) {
        this.f60454a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof JSONException) == false) goto L5;
        this.f60454a.n(OpenApiErrorInfo.NET_REQUEST_RESPONSE_INCOMPATIBLE, null);
        return;
    L5:
        this.f60454a.n(OpenApiErrorInfo.INTERNAL_ERROR, null);
        ALogger.d("NetworkRequestMethod", r101.toString());
    }
}
