package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f81944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f81945c;

    public e(d r100, int r101, long r102) {
        this.f81943a = r100;
        this.f81944b = r101;
        this.f81945c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        int r102 = nd0.g.f518750a;
        nd0.g.c(8, 1, this.f81944b, this.f81945c, r101);
        d.a r103 = (d.a) this.f81943a.f531633a;
        if (r103 == null) goto L9;
        DATA r104 = r101.data;
        if (r104 == 0) goto L8;
        r103.vM((TalkRoomEmojiListResponse) r104);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse");
    }
}
