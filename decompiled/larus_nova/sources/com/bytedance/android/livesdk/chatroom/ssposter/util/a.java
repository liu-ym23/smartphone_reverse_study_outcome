package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f111573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseQrCodeShareHelper.d f111574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f111575c;

    public a(m r100, BaseQrCodeShareHelper.d r101, Bitmap r102) {
        this.f111573a = r100;
        this.f111574b = r101;
        this.f111575c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f111574b.f111547a.f111577b.invoke(this.f111573a.f111619b, this.f111575c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
