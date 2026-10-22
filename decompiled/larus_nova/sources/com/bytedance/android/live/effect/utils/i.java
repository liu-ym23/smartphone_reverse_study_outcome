package com.bytedance.android.live.effect.utils;

import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f68873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f68874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f68875c;

    public i(String r100, String r101, String r102) {
        this.f68873a = r100;
        this.f68874b = r101;
        this.f68875c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        HashMap r102 = new HashMap();
        r102.put("live_type", "video_live");
        r102.put("model_name", this.f68873a);
        r102.put("model_id", this.f68874b);
        c.a("livesdk_beauty_model_effective_use", r102, this.f68875c);
    }
}
