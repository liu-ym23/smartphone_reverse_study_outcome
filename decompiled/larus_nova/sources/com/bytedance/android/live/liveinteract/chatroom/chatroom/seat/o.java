package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f72335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f72336c;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void c(d r100) {
    }

    public o() {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final d a() {
        return this.f72335b;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d r101 = this.f72335b;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f72335b != null) goto L5;
        this.f72335b = r100;
        this.f72336c = r100;
        return;
    L5:
        d r101 = this.f72336c;
        if (r101 == null) goto L8;
        r101.c(r100);
    L8:
        this.f72336c = r100;
    }
}
