package com.bytedance.android.live.room.discovery;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes47.dex */
public final class j0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSceneWidget f99565a;

    public j0(LiveSceneWidget r100) {
        this.f99565a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f99565a.wq("cancel");
        r100.dismiss();
    }
}
