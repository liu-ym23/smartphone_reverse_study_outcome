package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    @Override // androidx.camera.core.impl.DeferrableSurface
    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }

    public ImmediateSurface(Surface r100) {
        this.mSurface = r100;
    }

    public ImmediateSurface(Surface r100, Size r101, int r102) {
        super(r101, r102);
        this.mSurface = r100;
    }
}
