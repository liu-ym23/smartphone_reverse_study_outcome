package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftFailedException;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f125921a;

    public g(Function1 r100) {
        this.f125921a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof SendGiftFailedException) == false) goto L7;
        SendGiftFailedException r102 = (SendGiftFailedException) r101;
        if ((r102.getType() instanceof y.c.a.C2080a) == false) goto L9;
        this.f125921a.invoke(Integer.valueOf(r102.getType().f130931c));
        return;
    L9:
        return;
    L7:
        this.f125921a.invoke(Integer.valueOf(r0.a(r101)));
    }
}
