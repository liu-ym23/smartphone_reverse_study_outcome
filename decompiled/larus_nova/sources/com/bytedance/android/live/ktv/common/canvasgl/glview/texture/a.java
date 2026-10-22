package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGLTextureView.a f69476a;

    @Override // java.lang.Runnable
    public final void run() {
        BaseGLTextureView r100 = this.f69476a.f69474a;     // Catch: Throwable -> L4
        int r101 = BaseGLTextureView.f69467g;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BaseGLTextureView.a r100, hb0.a r101) {
        this.f69476a = r100;
    }
}
