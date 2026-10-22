package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements vr1.m, com.bytedance.android.scope.o {
    public l() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.m
    public final boolean handle(Context r100, Uri r101) {
        return ((ILiveActionHandler) jc1.k.n(ILiveActionHandler.class)).handle(r100, r101);
    }
}
