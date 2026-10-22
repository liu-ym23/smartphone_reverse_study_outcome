package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes39.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final Handler HANDLER = null;
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
    }

    static {
        HANDLER = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public void clear() {
        this.requestManager.clear(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z r100, Transition<? super Z> r101) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }

    private PreloadTarget(RequestManager r100, int r101, int r102) {
        super(r101, r102);
        this.requestManager = r100;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager r100, int r101, int r102) {
        return new PreloadTarget(r100, r101, r102);
    }
}
