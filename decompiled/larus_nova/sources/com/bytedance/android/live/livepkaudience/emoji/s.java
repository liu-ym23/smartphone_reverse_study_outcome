package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f81992a;

    public s(p r100) {
        this.f81992a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        FollowPair r101 = (FollowPair) r100;
        p r102 = this.f81992a;
        r102.f81968c = false;
        p.a r103 = (p.a) r102.f531633a;
        if (r103 == null) goto L6;
        r103.M40(r101);
        return;
    }
}
