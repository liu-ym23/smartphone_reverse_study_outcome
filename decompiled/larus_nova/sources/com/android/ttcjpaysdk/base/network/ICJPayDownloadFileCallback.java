package com.android.ttcjpaysdk.base.network;

import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayDownloadFileCallback {
    void onFailure();

    void onResponse(InputStream r100);
}
