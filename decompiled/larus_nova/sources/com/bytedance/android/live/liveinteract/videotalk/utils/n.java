package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f79814a;

    public n(o r100) {
        this.f79814a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f79814a.b();
    }
}
