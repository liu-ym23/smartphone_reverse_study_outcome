package com.bytedance.android.livesdkapi.depend.event;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;

/* JADX INFO: loaded from: classes12.dex */
public class FollowStateChangeEvent {
    private IFollowPair mFollowPair;

    public IFollowPair getFollowPair() {
        return this.mFollowPair;
    }

    public FollowStateChangeEvent(IFollowPair r100) {
        this.mFollowPair = r100;
    }
}
