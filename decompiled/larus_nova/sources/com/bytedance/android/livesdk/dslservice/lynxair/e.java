package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import io.reactivex.functions.Consumer;
import yt1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f122876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f122877b;

    public e(a r100, m r101) {
        this.f122876a = r100;
        this.f122877b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f122876a.f122818b = 2;
        m r102 = this.f122877b;
        if (r102 == null) goto L6;
        r102.b(DSLType.LynxAir, r101.toString(), r101);
        return;
    }
}
