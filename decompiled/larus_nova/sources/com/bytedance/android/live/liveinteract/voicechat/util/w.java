package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class w implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f80883a;

    public w(VoiceInteractSceneUtil.a r100) {
        this.f80883a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        u r102 = this.f80883a;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        r100.dismiss();
    }
}
