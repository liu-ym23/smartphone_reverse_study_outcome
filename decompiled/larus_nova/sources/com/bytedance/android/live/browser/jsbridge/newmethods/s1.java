package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class s1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f63634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.z7 f63635b;

    public s1(r1 r100, w20.z7 r101) {
        this.f63634a = r100;
        this.f63635b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        String r102 = this.f63635b.a();
        if (r102 == null) goto L11;
        if (r101 == null) goto L6;
        String r103 = String.valueOf(r101.longValue());
    L8:
        if (r102.equals(r103) != true) goto L12;
        this.f63634a.finishWithSuccess();
        return;
    L12:
        return;
    L6:
        r103 = null;
        goto L8
    }
}
