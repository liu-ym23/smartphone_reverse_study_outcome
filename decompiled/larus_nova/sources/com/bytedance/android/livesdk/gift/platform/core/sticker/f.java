package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerMessageService f131919a;

    public f(StickerMessageService r100) {
        this.f131919a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f131919a.J(StickerMessageService.StickerType.Normal);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
