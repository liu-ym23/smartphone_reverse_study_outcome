package com.bytedance.android.debug;

import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f42632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f42633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f42634c;

    public m(l r100, String r101) {
        this.f42632a = r100;
        this.f42633b = r101;
        this.f42634c = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ITextureViewPlayerController r100 = this.f42632a.f42628b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        ITextureViewPlayerController.DefaultImpls.start$default(r100, this.f42633b, this.f42634c, false, false, null, 28, null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
