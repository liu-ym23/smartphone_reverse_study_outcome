package com.monitor.cloudmessage.upload.callback;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IFileUploadCallback {
    List<String> getUploadFileList();

    void notifyUploadBegin(String r10);

    void notifyUploadEnd(String r10, boolean r11);
}
