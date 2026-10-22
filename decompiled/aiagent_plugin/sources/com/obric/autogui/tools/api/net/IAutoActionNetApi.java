package com.obric.autogui.tools.api.net;

import android.content.Context;

/* JADX INFO: compiled from: IAutoActionNetApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionNetApi {
    void addTimeoutConfig(String r1, long r2);

    void initNet(Context r1);

    a obtainHttpClient();
}
