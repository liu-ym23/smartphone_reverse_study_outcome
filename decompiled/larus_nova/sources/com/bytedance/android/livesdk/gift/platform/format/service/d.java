package com.bytedance.android.livesdk.gift.platform.format.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListService f132274a;

    public d(FormatGiftListService r100) {
        this.f132274a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<com.bytedance.android.livesdk.gift.platform.core.model.i> r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f132274a.getClass();
        String r101 = (String) new com.bytedance.android.livesdk.sharedpref.e("format_gift_list_response", "").getValue();
        com.bytedance.android.livesdk.gift.platform.core.model.i r102 = (com.bytedance.android.livesdk.gift.platform.core.model.i) this.f132274a.f132259d.fromJson(r101, com.bytedance.android.livesdk.gift.platform.core.model.i.class);     // Catch: Exception -> L5
    L7:
        if (r102 == null) goto L12;
        r100.onSuccess(r102);
        return;
    L12:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
        goto L7
    }
}
