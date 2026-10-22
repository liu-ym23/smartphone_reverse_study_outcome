package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.interactivity.interactive.j0;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements com.bytedance.android.live.platformplayer.utils.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f118305a;

    public o(j0 r100) {
        this.f118305a = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.utils.h
    public final void a(ILivePlayerClient r100) {
        this.f118305a.invoke(r100.getEventHub());
    }
}
