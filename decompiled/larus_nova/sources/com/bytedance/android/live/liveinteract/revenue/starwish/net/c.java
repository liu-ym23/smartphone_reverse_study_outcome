package com.bytedance.android.live.liveinteract.revenue.starwish.net;

import am3.g;
import com.bytedance.android.livesdk.chatroom.model.interact.n0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/starwish/net/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/n0;", "starWishInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/n0;", "getStarWishInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/n0;", "setStarWishInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/n0;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements h {

    @SerializedName("playmode_info")
    protected n0 starWishInfo;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.interact.n0, java.lang.Object] */
    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.starWishInfo = f.a(r100, n0.class);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
