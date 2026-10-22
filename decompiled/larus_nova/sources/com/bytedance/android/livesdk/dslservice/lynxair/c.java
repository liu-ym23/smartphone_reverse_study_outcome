package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f122869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f122870b;

    public c(d r100, String r101) {
        this.f122869a = r100;
        this.f122870b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        m.f123003h.i(((Long) r100).longValue(), this.f122869a.f122874d, this.f122870b);
    }
}
