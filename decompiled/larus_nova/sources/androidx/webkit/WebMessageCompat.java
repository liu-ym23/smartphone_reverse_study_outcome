package androidx.webkit;

/* JADX INFO: loaded from: classes17.dex */
public class WebMessageCompat {
    private String mData;
    private WebMessagePortCompat[] mPorts;

    public String getData() {
        return this.mData;
    }

    public WebMessagePortCompat[] getPorts() {
        return this.mPorts;
    }

    public WebMessageCompat(String r100) {
        this.mData = r100;
    }

    public WebMessageCompat(String r100, WebMessagePortCompat[] r101) {
        this.mData = r100;
        this.mPorts = r101;
    }
}
