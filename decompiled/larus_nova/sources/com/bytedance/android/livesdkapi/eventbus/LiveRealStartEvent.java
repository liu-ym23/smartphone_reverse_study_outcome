package com.bytedance.android.livesdkapi.eventbus;

/* JADX INFO: loaded from: classes12.dex */
public class LiveRealStartEvent {
    public static final int ENTER_LIVE = 1;
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    public static final int TYPE_ARTIFICIAL_SUBMIT = 0;
    public static final int TYPE_ARTIFICIAL_VERIFY = 3;
    public static final int TYPE_INFORMATION_VERIFY = 1;
    public static final int TYPE_MORE_NUMBER = 2;
    public String mEnterFrom;
    public int mEnterLive;
    public int mResult;
    public int mType;

    public boolean isArtificialSubmitVerifying() {
        if (this.mType == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mResult != 1) goto L7;
        return true;
    }

    public boolean isArtificialVerifyFail() {
        if (this.mType == 3) goto L5;
    L7:
        return false;
    L5:
        if (this.mResult != 0) goto L7;
        return true;
    }

    public boolean isArtificialVerifySuccess() {
        if (this.mType == 3) goto L5;
    L7:
        return false;
    L5:
        if (this.mResult != 1) goto L7;
        return true;
    }

    public boolean isVerified() {
        int r100 = this.mType;
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        return isArtificialVerifySuccess();
    L10:
        if (this.mResult == 1) goto L14;
        return false;
    L14:
        return true;
    }

    public LiveRealStartEvent(int r100, int r101, String r102, int r103) {
        this.mType = r100;
        this.mResult = r101;
        this.mEnterFrom = r102;
        this.mEnterLive = r103;
    }
}
