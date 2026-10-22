package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f109749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f109750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.e f109751c;

    public m(Ref.FloatRef r100, float r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102) {
        this.f109749a = r100;
        this.f109750b = r101;
        this.f109751c = r102;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "layout mark[" + this.f109751c.f118421e + "] has range conflict (" + this.f109750b + " -> " + this.f109749a.element + ')';
    }
}
