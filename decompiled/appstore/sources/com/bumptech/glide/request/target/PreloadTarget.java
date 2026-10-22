package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private static final Handler HANDLER = null;
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    static {
        HANDLER = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    private PreloadTarget(RequestManager r10, int r11, int r12) {
        super(r11, r12);
        this.requestManager = r10;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager r10, int r11, int r12) {
        return new PreloadTarget(r10, r11, r12);
    }

    public void clear() {
        this.requestManager.clear(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z r10, @Nullable Transition<? super Z> r11) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}
