package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: classes39.dex */
public class ResourceCallback {
    private long instance;

    private static native void nativeCallCancel();

    private static native void nativeCallFailed(long r100, String r101);

    private static native void nativeCallSuccess(long r100, AMapAppResourceItem r101);

    public ResourceCallback() {
        this.instance = 0;
    }

    public void callCancel() {
        nativeCallCancel();
    }

    public long getInstance() {
        return this.instance;
    }

    public ResourceCallback(long r100) {
        this.instance = r100;
    }

    public void callFailed(String r100) {
        nativeCallFailed(this.instance, r100);
    }

    public void callSuccess(AMapAppResourceItem r100) {
        nativeCallSuccess(this.instance, r100);
    }

    public void setInstance(long r100) {
        this.instance = r100;
    }
}
