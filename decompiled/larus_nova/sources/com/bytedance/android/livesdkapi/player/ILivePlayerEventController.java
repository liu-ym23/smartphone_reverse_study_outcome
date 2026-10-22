package com.bytedance.android.livesdkapi.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventController;", "", "addEventListener", "", "listener", "Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventListener;", "sceneIsolation", "", "removeEventListener", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerEventController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void addEventListener$default(ILivePlayerEventController r100, ILivePlayerEventListener r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.addEventListener(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEventListener");
        }
    }

    void addEventListener(ILivePlayerEventListener r100, boolean r101);

    void removeEventListener(ILivePlayerEventListener r100);
}
