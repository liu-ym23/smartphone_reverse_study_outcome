package com.bytedance.android.livesdk.quitroom;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewRoomQuitDialog f156898a;

    public e(NewRoomQuitDialog r100) {
        this.f156898a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.w(ICloseInterceptorService.TAG_QUIT_DIALOG, "fetchRoom() >>> failed", (Throwable) r100);
        NewRoomQuitDialog r101 = this.f156898a;
        int r102 = NewRoomQuitDialog.f156884e;
        r101.L0(3);
    }
}
