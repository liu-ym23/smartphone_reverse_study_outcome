package com.bytedance.android.live.liveinteract.interact.audience;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f73607a = null;

    static {
        f73607a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
