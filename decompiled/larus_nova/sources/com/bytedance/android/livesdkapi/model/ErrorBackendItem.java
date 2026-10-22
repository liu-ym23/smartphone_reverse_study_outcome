package com.bytedance.android.livesdkapi.model;

/* JADX INFO: loaded from: classes12.dex */
public class ErrorBackendItem extends BackendItem {
    public long errorCode;
    public String errorMsg;

    public ErrorBackendItem() {
        super("", "", 0, 0, 0, 0, 0, null);
        this.errorCode = 0;
        this.errorMsg = "";
    }

    public ErrorBackendItem(String r110, String r111, int r112) {
        super(r110, r111, r112, 0, 0, 0, 0, null);
        this.errorCode = 0;
        this.errorMsg = "";
    }

    public ErrorBackendItem(String r110, String r111, int r112, long r113, String r210) {
        super(r110, r111, r112, 0, 0, 0, 0, null);
        this.errorCode = r113;
        this.errorMsg = r210;
    }
}
