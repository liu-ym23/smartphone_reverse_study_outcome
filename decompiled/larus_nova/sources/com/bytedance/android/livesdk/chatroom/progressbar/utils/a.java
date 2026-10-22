package com.bytedance.android.livesdk.chatroom.progressbar.utils;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlaybackContext.c f107894a;

    public a(LivePlaybackContext.c r100) {
        this.f107894a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        IPlayerProgressService r102 = this.f107894a.f107891b;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isAtLatest() == true) goto L11;
        IPlayerProgressService r103 = this.f107894a.f107891b;
        if (r103 == null) goto L12;
        r103.setAtLatest(true);
        return;
    L12:
        return;
    }
}
