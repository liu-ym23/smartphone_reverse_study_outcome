package com.bytedance.android.livesdkapi.room.handler.observe;

/* JADX INFO: loaded from: classes12.dex */
public interface ConfigObserver<Config, Result> {
    Config getConfig();

    void onChanged(Result r100);
}
