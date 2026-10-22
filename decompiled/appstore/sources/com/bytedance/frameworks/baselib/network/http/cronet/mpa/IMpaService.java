package com.bytedance.frameworks.baselib.network.http.cronet.mpa;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IMpaService {

    public interface ICallback {
        void onFinish(boolean r10, String r11);
    }

    void command(String r10, String r11);

    void init(ICallback r10);

    void setAccAddress(List<String> r10, ICallback r11);

    void start();

    void stop();
}
