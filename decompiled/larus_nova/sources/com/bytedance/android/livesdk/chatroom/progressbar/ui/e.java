package com.bytedance.android.livesdk.chatroom.progressbar.ui;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f107880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f107881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.e f107882c;

    public e(Ref.FloatRef r100, float r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102) {
        this.f107880a = r100;
        this.f107881b = r101;
        this.f107882c = r102;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "layout mark[" + this.f107882c.f118421e + "] has range conflict (" + this.f107881b + " -> " + this.f107880a.element + ')';
    }
}
