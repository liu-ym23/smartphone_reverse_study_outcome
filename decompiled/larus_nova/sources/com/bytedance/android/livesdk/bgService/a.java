package com.bytedance.android.livesdk.bgService;

import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends MediaSessionCompat.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f104308a;

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPause() {
        this.f104308a.f104313e.onPause();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public final void onPlay() {
        this.f104308a.f104313e.onPlay();
    }

    public a(b r100) {
        this.f104308a = r100;
    }
}
