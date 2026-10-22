package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f87017a;

    public j(f r100) {
        this.f87017a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IFollowPair r101 = (IFollowPair) r100;
        if (r101 == null) goto L6;
        this.f87017a.a(r101.getFollowStatus());
        return;
    }
}
