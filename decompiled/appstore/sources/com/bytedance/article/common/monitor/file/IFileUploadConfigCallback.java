package com.bytedance.article.common.monitor.file;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface IFileUploadConfigCallback extends IFileUploadCallBack {
    boolean isCompress();

    boolean isDelSourceFile();

    boolean isSkipUploadInternal();
}
