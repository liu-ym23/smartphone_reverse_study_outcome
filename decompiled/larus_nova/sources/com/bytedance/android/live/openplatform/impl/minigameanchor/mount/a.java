package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f85224a = null;

    static {
        f85224a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r102 = AnchorMiniGameDataContext.a.a();
        if (r102 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.getSupportChangeMount();
        if (r103 == null) goto L9;
        r103.setValue(Boolean.valueOf(((yq0.f) r101.data).a()));
        return;
    L9:
        return;
    }
}
