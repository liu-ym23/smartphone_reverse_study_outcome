package com.bytedance.android.livesdk.room.util;

import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IExternalMessageListener f157833a;

    public f(IExternalMessageListener r100) {
        this.f157833a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        this.f157833a.onMessage(r100);
    }
}
