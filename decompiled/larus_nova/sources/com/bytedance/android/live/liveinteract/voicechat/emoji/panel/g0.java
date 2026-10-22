package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80222a;

    public g0(s r100) {
        this.f80222a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IFollowPair r101 = (IFollowPair) r100;
        s r102 = this.f80222a;
        r102.f80239c = false;
        s.a r103 = (s.a) r102.f531633a;
        if (r103 == null) goto L8;
        if (r101 == null) goto L7;
        r103.GN(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair");
    }
}
