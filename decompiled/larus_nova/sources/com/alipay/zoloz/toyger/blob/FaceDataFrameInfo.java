package com.alipay.zoloz.toyger.blob;

/* JADX INFO: loaded from: classes28.dex */
public class FaceDataFrameInfo {
    public static String info_cache;
    public static String info_cache_bak;
    public static boolean info_got;
    public static FaceDataFrameInfo mInstance;
    public boolean dataUpdated;

    static {
        mInstance = new FaceDataFrameInfo();
        info_got = false;
    }

    public FaceDataFrameInfo() {
        this.dataUpdated = false;
    }

    public static FaceDataFrameInfo getmInstance() {
        return mInstance;
    }
}
