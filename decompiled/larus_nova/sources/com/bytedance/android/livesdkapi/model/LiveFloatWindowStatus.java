package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveFloatWindowStatus;", "", "()V", "isShow", "", "()Z", "setShow", "(Z)V", "scene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "getScene", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "setScene", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFloatWindowStatus {
    private boolean isShow;
    private ILivePlayerScene scene;

    public LiveFloatWindowStatus() {
    }

    public final ILivePlayerScene getScene() {
        return this.scene;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setScene(ILivePlayerScene r100) {
        this.scene = r100;
    }

    public final void setShow(boolean r100) {
        this.isShow = r100;
    }
}
