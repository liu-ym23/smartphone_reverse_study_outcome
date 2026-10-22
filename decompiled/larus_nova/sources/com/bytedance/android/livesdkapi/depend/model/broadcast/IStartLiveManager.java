package com.bytedance.android.livesdkapi.depend.model.broadcast;

/* JADX INFO: loaded from: classes12.dex */
public interface IStartLiveManager {

    public interface IOnStartClickListener {
        void onStartClicked();
    }

    public interface IStartLiveListener {
        void onStartLive();
    }

    void onStartClick();

    void onStarted();

    void registerPreStartLiveListener(IOnStartClickListener r100);

    void registerStartLiveListener(IStartLiveListener r100);

    void removePreStartLiveListener(IOnStartClickListener r100);

    void removeStartLiveListener(IStartLiveListener r100);
}
