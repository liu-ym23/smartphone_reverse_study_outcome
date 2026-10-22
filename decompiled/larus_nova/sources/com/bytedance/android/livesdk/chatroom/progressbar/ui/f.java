package com.bytedance.android.livesdk.chatroom.progressbar.ui;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f107883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f107884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vsplayer.model.e f107885c;

    public f(Ref.FloatRef r100, Ref.FloatRef r101, com.bytedance.android.livesdk.chatroom.vsplayer.model.e r102) {
        this.f107883a = r100;
        this.f107884b = r101;
        this.f107885c = r102;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "drawImageCustomMarks layout mark[" + this.f107885c.f118421e + "] on (" + this.f107883a.element + ',' + this.f107884b.element + ')';
    }
}
