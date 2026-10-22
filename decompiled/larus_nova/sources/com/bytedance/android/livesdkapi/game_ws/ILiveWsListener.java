package com.bytedance.android.livesdkapi.game_ws;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "", "onClosed", "", "manualClose", "", "onConnect", "onFailure", "onMessage", "msg", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWsListener {
    void onClosed(boolean r100);

    void onConnect();

    void onFailure();

    void onMessage(String r100);
}
