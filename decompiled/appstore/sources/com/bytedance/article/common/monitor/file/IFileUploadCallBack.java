package com.bytedance.article.common.monitor.file;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface IFileUploadCallBack {
    List<String> getUploadFileList();

    void notifyUploadBegin(String r10);

    void notifyUploadEnd(String r10, boolean r11);
}
