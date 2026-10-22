package com.bytedanceos.appstore.utils;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public interface LoadUtil$LoadCallback<T> {
    void loadFinished(T r10, Bundle r11);

    T loadInBackground(Bundle r10);

    void loadReset();
}
