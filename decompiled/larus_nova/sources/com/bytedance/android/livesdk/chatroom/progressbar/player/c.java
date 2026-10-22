package com.bytedance.android.livesdk.chatroom.progressbar.player;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerProgressBridge f107815a;

    public c(PlayerProgressBridge r100) {
        this.f107815a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PlayerProgressBridge r101 = this.f107815a;
        r101.h((String) r100);
    }
}
