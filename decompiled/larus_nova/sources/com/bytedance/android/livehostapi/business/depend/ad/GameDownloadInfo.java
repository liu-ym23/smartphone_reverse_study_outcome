package com.bytedance.android.livehostapi.business.depend.ad;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ad/GameDownloadInfo;", "", "status", "", DBDefinition.TOTAL_BYTES, "", "currentBytes", "fileName", "", "failStatus", DBDefinition.ONLY_WIFI, "", "reserveInfo", "Lorg/json/JSONObject;", "enableFeature", "(IJJLjava/lang/String;IZLorg/json/JSONObject;Lorg/json/JSONObject;)V", "getCurrentBytes", "()J", "setCurrentBytes", "(J)V", "getEnableFeature", "()Lorg/json/JSONObject;", "setEnableFeature", "(Lorg/json/JSONObject;)V", "getFailStatus", "()I", "setFailStatus", "(I)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getOnlyWifi", "()Z", "setOnlyWifi", "(Z)V", "getReserveInfo", "setReserveInfo", "getStatus", "setStatus", "getTotalBytes", "setTotalBytes", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDownloadInfo {
    private long currentBytes;
    private JSONObject enableFeature;
    private int failStatus;
    private String fileName;
    private boolean onlyWifi;
    private JSONObject reserveInfo;
    private int status;
    private long totalBytes;

    public GameDownloadInfo() {
        this(0, 0, 0, null, 0, false, null, null, 255, null);
    }

    public final long getCurrentBytes() {
        return this.currentBytes;
    }

    public final JSONObject getEnableFeature() {
        return this.enableFeature;
    }

    public final int getFailStatus() {
        return this.failStatus;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean getOnlyWifi() {
        return this.onlyWifi;
    }

    public final JSONObject getReserveInfo() {
        return this.reserveInfo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void setCurrentBytes(long r100) {
        this.currentBytes = r100;
    }

    public final void setEnableFeature(JSONObject r100) {
        this.enableFeature = r100;
    }

    public final void setFailStatus(int r100) {
        this.failStatus = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setOnlyWifi(boolean r100) {
        this.onlyWifi = r100;
    }

    public final void setReserveInfo(JSONObject r100) {
        this.reserveInfo = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTotalBytes(long r100) {
        this.totalBytes = r100;
    }

    public GameDownloadInfo(int r100, long r101, long r102, String r103, int r104, boolean r105, JSONObject r106, JSONObject r110) {
        this.status = r100;
        this.totalBytes = r101;
        this.currentBytes = r102;
        this.fileName = r103;
        this.failStatus = r104;
        this.onlyWifi = r105;
        this.reserveInfo = r106;
        this.enableFeature = r110;
    }

    public /* synthetic */ GameDownloadInfo(int r110, long r111, long r112, String r113, int r114, boolean r115, JSONObject r210, JSONObject r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = false;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        long r102 = -1;
        if ((r212 & 2) == 0) goto L9;
        long r103 = -1;
    L11:
        if ((r212 & 4) != 0) goto L14;
        r102 = r112;
    L14:
        JSONObject r104 = null;
        if ((r212 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r212 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r212 & 64) == 0) goto L29;
        JSONObject r116 = null;
    L31:
        if ((r212 & 128) != 0) goto L34;
        r104 = r211;
    L34:
        this(r101, r103, r102, r105, r106, r100, r116, r104);
        return;
    L29:
        r116 = r210;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
