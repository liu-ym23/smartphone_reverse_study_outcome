package com.bytedance.android.livesdk.utils;

import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class c4 extends dmc.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ vlc.l f158905d;

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        vlc.l r101 = this.f158905d;
        if (r101 == null) goto L6;
        r101.onMessage(r100);
        return;
    }

    public c4(vlc.l r100, Set r101, Set r102) {
        this.f158905d = r100;
        super(r101, r102, 4);
    }
}
