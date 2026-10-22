package com.media.cache;

/* JADX INFO: loaded from: classes3.dex */
public class VideoCacheException extends Exception {
    private String mMsg;

    public VideoCacheException(String r10) {
        this.mMsg = r10;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
