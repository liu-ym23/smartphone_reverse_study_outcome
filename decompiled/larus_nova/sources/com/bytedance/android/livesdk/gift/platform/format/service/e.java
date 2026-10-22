package com.bytedance.android.livesdk.gift.platform.format.service;

import ca0.w;
import com.bytedance.android.livesdk.gift.model.w1;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftListService f132275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f132276b;

    public e(FormatGiftListService r100, w r101) {
        this.f132275a = r100;
        this.f132276b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((ArrayList) this.f132275a.f132257b).clear();
        List<w1> r101 = this.f132275a.f132257b;
        ArrayList r102 = (ArrayList) r101;
        r102.addAll(((com.bytedance.android.livesdk.gift.platform.core.model.i) r100).giftPages);
        w r103 = this.f132276b;
        if (r103 == null) goto L6;
        r103.b(this.f132275a.f132257b);
        return;
    }
}
