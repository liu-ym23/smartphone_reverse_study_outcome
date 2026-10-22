package com.bytedance.android.livesdk.gift.platform.core.preview;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestTimer f130998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function4 f130999b;

    public h(RequestTimer r100, Function4 r101) {
        this.f130998a = r100;
        this.f130999b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Function4 r102 = this.f130999b;
        RequestTimer r103 = this.f130998a;
        r102.invoke(r103.f130967c, r103.f130968d, Integer.valueOf(r103.f130969e), this.f130998a.f130970f);
        RequestTimer r104 = this.f130998a;
        Disposable r105 = r104.f130965a;
        if (r105 == null) goto L5;
        r105.dispose();
    L5:
        r104.f130965a = null;
    }
}
