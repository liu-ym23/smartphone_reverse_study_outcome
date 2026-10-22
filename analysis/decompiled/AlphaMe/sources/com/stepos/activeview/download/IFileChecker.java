package com.stepos.activeview.download;

/* loaded from: classes.dex */
public interface IFileChecker {
    FileCheckResult checkFileDataInfo(String str);

    FileCheckResult checkHttpContentLength(long j4, long j5);

    void enableCheck(boolean z4);

    long getCheckFileSize();

    String getCheckMd5();

    String getCheckPartialMd5();

    String getLogVersion();

    @Deprecated
    boolean isFileDataMatch(String str);

    @Deprecated
    boolean isFileLengthMatch(long j4);
}
