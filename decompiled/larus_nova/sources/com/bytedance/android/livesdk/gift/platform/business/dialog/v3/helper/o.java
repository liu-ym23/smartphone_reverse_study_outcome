package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f127470a;

    public o(r r100) {
        this.f127470a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        n r102 = this.f127470a.f127480a;
        int r103 = n.f127460f;
        r102.b(true);
    }
}
