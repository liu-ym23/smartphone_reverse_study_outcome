package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class r implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f80875a = null;

    static {
        f80875a = new r();
    }

    public r() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r102 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r102 == null) goto L6;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r102);
        return;
    }
}
