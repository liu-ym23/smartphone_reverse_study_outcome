package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f122867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f122868b;

    public b(d r100, String r101) {
        this.f122867a = r100;
        this.f122868b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        m.f123003h.i(((Long) r100).longValue(), this.f122867a.f122874d, this.f122868b);
    }
}
