package com.bytedance.android.livesdk.gift.platform.format.service;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListService f132284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.i f132285b;

    public i(FormatGiftListService r100, com.bytedance.android.livesdk.gift.platform.core.model.i r101) {
        this.f132284a = r100;
        this.f132285b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        com.bytedance.android.livesdk.gift.platform.core.model.i r101 = this.f132285b;
        if (r101 == null) goto L6;
        this.f132284a.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("format_gift_list_response", ""), GsonProtectorUtils.toJson(this.f132284a.f132259d, r101));
        return;
    }
}
