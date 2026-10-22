package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.h;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPanelViewPreloadService f128185a;

    public c(GiftPanelViewPreloadService r100) {
        this.f128185a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f128185a.a(GiftPanelViewPreloadService.PreloadSource.CLOSE_PANEL);
        HashMap<GiftPreloadResType, k<?>> r102 = GiftPreloadManager.f128195a;
        GiftPreloadManager.b(h.c.f128233a);
    }
}
