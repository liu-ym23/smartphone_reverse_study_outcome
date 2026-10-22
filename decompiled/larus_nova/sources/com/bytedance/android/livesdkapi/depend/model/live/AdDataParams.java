package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AdDataParams;", "", "aid", "", "cid", "log_extra", "", "liveSDKInfoExtra", "(JJLjava/lang/String;Ljava/lang/String;)V", "getAid", "()J", "setAid", "(J)V", "getCid", "setCid", "getLiveSDKInfoExtra", "()Ljava/lang/String;", "getLog_extra", "setLog_extra", "(Ljava/lang/String;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdDataParams {

    @SerializedName(alternate = {"ad_id"}, value = "aid")
    private long aid;

    @SerializedName(alternate = {"creative_id"}, value = "cid")
    private long cid;

    @SerializedName("live_sdk_info_extra")
    private final String liveSDKInfoExtra;

    @SerializedName("log_extra")
    private String log_extra;

    public final long getAid() {
        return this.aid;
    }

    public final long getCid() {
        return this.cid;
    }

    public final String getLiveSDKInfoExtra() {
        return this.liveSDKInfoExtra;
    }

    public final String getLog_extra() {
        return this.log_extra;
    }

    public final void setAid(long r100) {
        this.aid = r100;
    }

    public final void setCid(long r100) {
        this.cid = r100;
    }

    public final void setLog_extra(String r100) {
        this.log_extra = r100;
    }

    public AdDataParams(long r100, long r101, String r102, String r103) {
        this.aid = r100;
        this.cid = r101;
        this.log_extra = r102;
        this.liveSDKInfoExtra = r103;
    }

    public /* synthetic */ AdDataParams(long r110, long r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = null;
    L14:
        this(r100, r101, r102, r113);
        return;
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
