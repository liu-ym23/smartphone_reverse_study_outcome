package com.obric.autogui.tools.api.net.push;

import android.content.Context;

/* JADX INFO: compiled from: IAutoActionPushApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionPushApi {
    void init(Context r1);

    void registerPushMessageCallback(a r1);

    void unregisterPushMessageCallback(a r1);
}
