package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.format.GiftPlayerView;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f132149a = null;

    static {
        f132149a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        h1 r101 = ((p2) r100).getGift();
        if (r101 == null) goto L10;
        com.bytedance.android.livesdk.gift.format.a r102 = (com.bytedance.android.livesdk.gift.format.a) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.format.a.class);
        Intrinsics.checkNotNullParameter(r101, PbRequest.SwitchType.GIFT);
        WeakReference<GiftPlayerView> r103 = r102.f126219a;
        if (r103 == null) goto L11;
        GiftPlayerView r104 = r103.get();
        if (r104 == null) goto L12;
        r104.a(r101);
        return;
    L12:
        return;
    L11:
        return;
    }
}
