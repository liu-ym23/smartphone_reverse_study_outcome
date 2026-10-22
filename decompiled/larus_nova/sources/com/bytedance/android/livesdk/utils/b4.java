package com.bytedance.android.livesdk.utils;

import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class b4 extends dmc.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ vlc.l f158890d;

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        vlc.l r101 = this.f158890d;
        if (r101 == null) goto L6;
        r101.onMessage(r100);
        return;
    }

    public b4(vlc.l r100, Set r101) {
        this.f158890d = r100;
        super(r101, null, 6);
    }
}
