package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class v4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f159191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f159192b;

    public v4(Context r100, String r101) {
        this.f159191a = r100;
        this.f159192b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.i("MdnsServiceManager", "timeout start stopDiscovery");
        MdnsServiceManager.f158767c.c(this.f159191a, this.f159192b);
    }
}
