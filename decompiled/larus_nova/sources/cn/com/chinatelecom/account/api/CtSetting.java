package cn.com.chinatelecom.account.api;

/* JADX INFO: loaded from: classes28.dex */
public class CtSetting {
    private static final int DEFAULT_CONN_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 5000;
    private static final int DEFAULT_TOTAL_TIMEOUT = 10000;
    private int connTimeout;
    private int readTimeout;
    private int totalTimeout;

    public CtSetting() {
        this.totalTimeout = 0;
        this.connTimeout = 0;
        this.readTimeout = 0;
    }

    public CtSetting(int r100, int r101, int r102) {
        this.connTimeout = r100;
        this.readTimeout = r101;
        this.totalTimeout = r102;
    }

    public static int getConnTimeout(CtSetting r100) {
        if (r100 == null) goto L7;
        int r101 = r100.connTimeout;
        if (r101 <= 0) goto L9;
        return r101;
    L9:
        return 5000;
    L7:
        return 5000;
    }

    public static int getReadTimeout(CtSetting r100) {
        if (r100 == null) goto L7;
        int r101 = r100.readTimeout;
        if (r101 <= 0) goto L9;
        return r101;
    L9:
        return 5000;
    L7:
        return 5000;
    }

    public static int getTotalTimeout(CtSetting r100) {
        if (r100 == null) goto L7;
        int r101 = r100.totalTimeout;
        if (r101 <= 0) goto L9;
        return r101;
    L9:
        return 10000;
    L7:
        return 10000;
    }

    public void setConnTimeout(int r100) {
        this.connTimeout = r100;
    }

    public void setReadTimeout(int r100) {
        this.readTimeout = r100;
    }

    public void setTotalTimeout(int r100) {
        this.totalTimeout = r100;
    }
}
