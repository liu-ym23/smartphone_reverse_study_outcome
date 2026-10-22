package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionCountResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f152808a;

    public e(d r100) {
        this.f152808a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECPromotionCountResponse r101 = (ECPromotionCountResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        if (r101.statusCode != 0) goto L7;
        v0 r102 = this.f152808a;
        if (r102 == null) goto L11;
        r102.onSuccess(r101);
        return;
    L11:
        return;
    L7:
        v0 r103 = this.f152808a;
        if (r103 == null) goto L13;
        r103.onError(null);
        return;
    }
}
