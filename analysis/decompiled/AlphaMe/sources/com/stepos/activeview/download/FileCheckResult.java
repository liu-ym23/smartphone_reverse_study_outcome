package com.stepos.activeview.download;

/* loaded from: classes.dex */
public class FileCheckResult {
    private final String mErrorMsg;
    private final boolean mIsMatch;

    private FileCheckResult(boolean z4, String str) {
        this.mIsMatch = z4;
        this.mErrorMsg = str;
    }

    public static FileCheckResult instanceErrorResult(String str) {
        return new FileCheckResult(false, str);
    }

    public static FileCheckResult instanceSuccessResult() {
        return new FileCheckResult(true, null);
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public boolean isMatch() {
        return this.mIsMatch;
    }
}
