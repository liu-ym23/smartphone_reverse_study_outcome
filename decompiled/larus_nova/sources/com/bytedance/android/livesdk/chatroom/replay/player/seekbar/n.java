package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f109752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f109753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.e f109754c;

    public n(Ref.FloatRef r100, Ref.FloatRef r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102) {
        this.f109752a = r100;
        this.f109753b = r101;
        this.f109754c = r102;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "drawImageCustomMarks layout mark[" + this.f109754c.f118421e + "] on (" + this.f109752a.element + ',' + this.f109753b.element + ')';
    }
}
