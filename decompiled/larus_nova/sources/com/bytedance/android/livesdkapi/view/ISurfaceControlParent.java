package com.bytedance.android.livesdkapi.view;

import android.view.SurfaceControl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/ISurfaceControlParent;", "", "hasSurfaceControlAttached", "", "onSurfaceControlAttached", "", "surfaceControl", "Landroid/view/SurfaceControl;", "onSurfaceControlDetach", "replace", "Listener", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISurfaceControlParent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/ISurfaceControlParent$Listener;", "", "onSurfaceControlAttached", "", "surfaceControl", "Landroid/view/SurfaceControl;", "onSurfaceControlDetach", "replace", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Listener {
        void onSurfaceControlAttached(SurfaceControl r100);

        void onSurfaceControlDetach(boolean r100);
    }

    boolean hasSurfaceControlAttached();

    void onSurfaceControlAttached(SurfaceControl r100);

    void onSurfaceControlDetach(boolean r100);
}
