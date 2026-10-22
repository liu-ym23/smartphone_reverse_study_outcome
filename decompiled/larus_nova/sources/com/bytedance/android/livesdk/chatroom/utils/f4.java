package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.message.model.Cif;

/* JADX INFO: loaded from: classes8.dex */
public final class f4 implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tlc.d f114469a;

    public f4() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof Cif) == true) goto L5;
        return;
    L5:
        if (((Cif) r100).mScene != 14) goto L9;
        this.f114469a = r100;
        return;
    }
}
