package cg7;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    @SerializedName("background_poll")
    private int backgroundPoll;

    @SerializedName("background_sync")
    private int backgroundSync;

    @SerializedName("channel")
    private int channel;

    @SerializedName("db_store_size_limit")
    private int dbStoreSizeLimit;

    @SerializedName("event_send_delay")
    private long eventSendDelay;

    @SerializedName("history_size_limit")
    private int historyLimit;

    @SerializedName("is_compress")
    private int isCompress;

    @SerializedName("poll")
    private int poll;

    @SerializedName("poll_interval_limit")
    private int pollIntervalLimit;

    @SerializedName("android_ws_poll_interval")
    private long pollIntervalWhenWsConnected;

    @SerializedName("poll_try")
    private int pollTry;

    @SerializedName("report_size_limit")
    private int reportSizeLimit;

    @SerializedName("submit_size_limit")
    private int submitSizeLimit;

    @SerializedName(DocumentType.DOCX_SYNC_BLOCK_NAME)
    private int sync;

    @SerializedName("version")
    private int version;

    public final boolean a() {
        if (this.isCompress <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.pollIntervalWhenWsConnected == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long j() {
        long r100 = this.pollIntervalWhenWsConnected;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return this.poll;
    }

    public final boolean n() {
        if (this.channel > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a() {
        this.sync = 60;
        this.poll = 300;
        this.backgroundSync = 300;
        this.backgroundPoll = 600;
        this.reportSizeLimit = BmLocated.HALF_LEFT_BOTTOM;
        this.submitSizeLimit = 51200;
        this.dbStoreSizeLimit = 51200;
        this.eventSendDelay = 5;
        this.pollIntervalWhenWsConnected = -1;
        this.isCompress = 1;
        this.historyLimit = 10;
        this.pollIntervalLimit = 5000;
        this.pollTry = 1;
    }

    public final int c() {
        return this.backgroundPoll;
    }

    public final int d() {
        return this.backgroundSync;
    }

    public final int e() {
        return this.dbStoreSizeLimit;
    }

    public final long f() {
        return this.eventSendDelay;
    }

    public final int g() {
        return this.historyLimit;
    }

    public final int h() {
        return this.poll;
    }

    public final int i() {
        return this.pollIntervalLimit;
    }

    public final int k() {
        return this.pollTry;
    }

    public final int l() {
        return this.reportSizeLimit;
    }

    public final int m() {
        return this.sync;
    }
}
