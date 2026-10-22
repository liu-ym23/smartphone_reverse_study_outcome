package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ca0.w f128391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f128392b;

    public o(ca0.w r100, List r101) {
        this.f128391a = r100;
        this.f128392b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        this.f128391a.b(this.f128392b);
    }
}
