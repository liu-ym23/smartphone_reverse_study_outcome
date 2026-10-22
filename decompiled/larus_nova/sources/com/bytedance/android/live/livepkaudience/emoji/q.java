package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f81984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f81985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f81986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f81987d;

    public q(p r100, int r101, long r102) {
        this.f81984a = r100;
        this.f81985b = 8;
        this.f81986c = r101;
        this.f81987d = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        int r102 = nd0.g.f518750a;
        nd0.g.c(this.f81985b, 2, this.f81986c, this.f81987d, r101);
        p.a r103 = (p.a) this.f81984a.f531633a;
        if (r103 == null) goto L9;
        DATA r104 = r101.data;
        if (r104 == 0) goto L8;
        r103.kH((TalkRoomEmojiListResponse) r104);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse");
    }
}
