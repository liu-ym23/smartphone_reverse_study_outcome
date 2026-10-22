package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f82146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f82147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f82148c;

    public e(b r100, int r101, Function1 r102) {
        this.f82146a = r100;
        this.f82147b = r101;
        this.f82148c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        ALogger.i(this.f82146a.f82122e, "update sort setting success");
        this.f82148c.invoke(Integer.valueOf(this.f82147b));
    }
}
