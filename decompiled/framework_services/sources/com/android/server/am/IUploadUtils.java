package com.android.server.am;

import android.content.Context;
import android.os.DebugSmtEx;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface IUploadUtils {
    default void readCustomFileConfig() throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void handleUpload(Context context, String packageName, String errorType) throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uploadError(Context context, String errorType, String filePath, String packageName, String appType, boolean isdelete, boolean catchlog) throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uploadSysdata(Context context, String errorType, String filePath, String packageName, boolean isdelete) throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void uploadEncryptEvent(Context context, String errorType, String filePath, String packageName, boolean isdelete) throws IOException {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
