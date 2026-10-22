package com.bytedance.android.live.browser.jsbridge.upload;

import com.bytedance.android.livesdkapi.listener.UploadProgressListener;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements UploadProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f64090a;

    public t(q r100) {
        this.f64090a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.listener.UploadProgressListener
    public final void onProgress(long r100, long r101) {
        int r102 = (((int) ((r100 / r101) * 100.0d)) / 2) + 50;
        q r103 = this.f64090a;
        if (r102 == r103.N) goto L6;
        r103.E(r102);
        this.f64090a.N = r102;
        return;
    }
}
