package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ca0.w f130812a;

    public o(ca0.w r100) {
        this.f130812a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        this.f130812a.b(new ArrayList());
    }
}
