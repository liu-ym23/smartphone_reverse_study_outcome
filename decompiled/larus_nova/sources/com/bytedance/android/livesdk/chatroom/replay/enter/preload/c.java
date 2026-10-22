package com.bytedance.android.livesdk.chatroom.replay.enter.preload;

import android.os.Message;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f108604a;

    public c(a r100) {
        this.f108604a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.enter.preload.j.a
    public final void a(long r100) {
        b r101 = this.f108604a.f108588b;
        if (r101 == null) goto L5;
        Message r102 = r101.obtainMessage(4, Long.valueOf(r100));
    L6:
        if (r102 == null) goto L11;
        b r103 = this.f108604a.f108588b;
        if (r103 == null) goto L12;
        r103.sendMessage(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.enter.preload.j.a
    public final void b(long r100) {
        b r101 = this.f108604a.f108588b;
        if (r101 == null) goto L5;
        Message r102 = r101.obtainMessage(2, Long.valueOf(r100));
    L6:
        if (r102 == null) goto L11;
        b r103 = this.f108604a.f108588b;
        if (r103 == null) goto L12;
        r103.sendMessage(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.enter.preload.j.a
    public final void c(long r100) {
        b r101 = this.f108604a.f108588b;
        if (r101 == null) goto L5;
        Message r102 = r101.obtainMessage(3, Long.valueOf(r100));
    L6:
        if (r102 == null) goto L11;
        b r103 = this.f108604a.f108588b;
        if (r103 == null) goto L12;
        r103.sendMessage(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
