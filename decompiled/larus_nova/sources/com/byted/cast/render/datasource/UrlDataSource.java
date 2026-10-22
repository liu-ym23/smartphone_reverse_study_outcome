package com.byted.cast.render.datasource;

/* JADX INFO: loaded from: classes43.dex */
public class UrlDataSource {
    static String TAG = "UrlDataSource";
    private long dataSourceId;
    private IDataSourceListener listener;

    private native long native_setUrl(String r100);

    private native boolean native_start(long r100);

    private native void native_stop(long r100);

    public boolean start() {
        return native_start(this.dataSourceId);
    }

    public void stop() {
        native_stop(this.dataSourceId);
    }

    public UrlDataSource() {
        this.dataSourceId = 0;
    }

    public void setDataListener(IDataSourceListener r100) {
        this.listener = r100;
    }

    public void setUrl(String r100) {
        this.dataSourceId = native_setUrl(r100);
    }

    private void onAudioDataCallback(byte[] r100, long r101) {
        if (r100.length <= 0) goto L6;
        this.listener.onAudioPacketAvailable(r100, r101);
        return;
    }

    private void onVideoDataCallback(byte[] r100, long r101) {
        if (r100.length <= 0) goto L6;
        this.listener.onVideoPacketAvailable(r100, r101);
        return;
    }
}
