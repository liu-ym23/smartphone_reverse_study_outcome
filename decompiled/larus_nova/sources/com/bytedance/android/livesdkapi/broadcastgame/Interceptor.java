package com.bytedance.android.livesdkapi.broadcastgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/broadcastgame/Interceptor;", "", "intercept", "", "code", "", "category", "errorCode", "onStreamEnd", "", "onStreamStart", "setScreenState", "action", "Lcom/bytedance/android/livesdkapi/broadcastgame/AnchorAction;", "state", "Lcom/bytedance/android/livesdkapi/broadcastgame/ScreenState;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface Interceptor {
    boolean intercept(int r100, int r101, int r102);

    void onStreamEnd(int r100);

    void onStreamStart();

    void setScreenState(AnchorAction r100, ScreenState r101);
}
