package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes46.dex */
public final class k extends AnimationBackendDelegate<AnimationBackend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f72234a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f72234a;
    }

    public k(AnimationBackend r100) {
        super(r100);
        this.f72234a = 1;
    }
}
