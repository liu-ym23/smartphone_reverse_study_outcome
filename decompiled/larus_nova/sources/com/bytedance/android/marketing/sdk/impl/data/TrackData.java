package com.bytedance.android.marketing.sdk.impl.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001e\u0010'\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001e\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001e\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001e\u00100\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001e\u00103\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001e\u00106\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#¨\u00069"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/TrackData;", "", "()V", "enterFrom", "", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "entryRit", "getEntryRit", "setEntryRit", "hitCache", "", "getHitCache", "()I", "setHitCache", "(I)V", "loadEntryType", "getLoadEntryType", "setLoadEntryType", "logId", "getLogId", "setLogId", "pageName", "getPageName", "setPageName", "servicePageName", "getServicePageName", "setServicePageName", "tMarketingFirstScreen", "", "getTMarketingFirstScreen", "()J", "setTMarketingFirstScreen", "(J)V", "tNativeHandleTime", "getTNativeHandleTime", "setTNativeHandleTime", "tNetEnd", "getTNetEnd", "setTNetEnd", "tNetStart", "getTNetStart", "setTNetStart", "tOpenTime", "getTOpenTime", "setTOpenTime", "tRegisterAction", "getTRegisterAction", "setTRegisterAction", "tRegisterTime", "getTRegisterTime", "setTRegisterTime", "tShowAction", "getTShowAction", "setTShowAction", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrackData {

    @SerializedName("enter_from")
    private String enterFrom;
    private String entryRit;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE)
    private int hitCache;

    @SerializedName("load_entry_type")
    private String loadEntryType;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("page_name")
    private String pageName;

    @SerializedName("service_page_name")
    private String servicePageName;

    @SerializedName("t_marketing_first_screen")
    private long tMarketingFirstScreen;

    @SerializedName("omth_native_handle_time")
    private long tNativeHandleTime;

    @SerializedName("t_net_end")
    private long tNetEnd;

    @SerializedName("t_net_start")
    private long tNetStart;

    @SerializedName("t_open_time")
    private long tOpenTime;

    @SerializedName("t_register_action")
    private long tRegisterAction;

    @SerializedName("t_register_time")
    private long tRegisterTime;

    @SerializedName("t_show_action")
    private long tShowAction;

    public TrackData() {
        this.logId = "";
        this.entryRit = "";
        this.pageName = "";
        this.enterFrom = "";
        this.servicePageName = "";
        this.loadEntryType = "";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntryRit() {
        return this.entryRit;
    }

    public final int getHitCache() {
        return this.hitCache;
    }

    public final String getLoadEntryType() {
        return this.loadEntryType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getServicePageName() {
        return this.servicePageName;
    }

    public final long getTMarketingFirstScreen() {
        return this.tMarketingFirstScreen;
    }

    public final long getTNativeHandleTime() {
        return this.tNativeHandleTime;
    }

    public final long getTNetEnd() {
        return this.tNetEnd;
    }

    public final long getTNetStart() {
        return this.tNetStart;
    }

    public final long getTOpenTime() {
        return this.tOpenTime;
    }

    public final long getTRegisterAction() {
        return this.tRegisterAction;
    }

    public final long getTRegisterTime() {
        return this.tRegisterTime;
    }

    public final long getTShowAction() {
        return this.tShowAction;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEntryRit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entryRit = r100;
    }

    public final void setHitCache(int r100) {
        this.hitCache = r100;
    }

    public final void setLoadEntryType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadEntryType = r100;
    }

    public final void setLogId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logId = r100;
    }

    public final void setPageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageName = r100;
    }

    public final void setServicePageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.servicePageName = r100;
    }

    public final void setTMarketingFirstScreen(long r100) {
        this.tMarketingFirstScreen = r100;
    }

    public final void setTNativeHandleTime(long r100) {
        this.tNativeHandleTime = r100;
    }

    public final void setTNetEnd(long r100) {
        this.tNetEnd = r100;
    }

    public final void setTNetStart(long r100) {
        this.tNetStart = r100;
    }

    public final void setTOpenTime(long r100) {
        this.tOpenTime = r100;
    }

    public final void setTRegisterAction(long r100) {
        this.tRegisterAction = r100;
    }

    public final void setTRegisterTime(long r100) {
        this.tRegisterTime = r100;
    }

    public final void setTShowAction(long r100) {
        this.tShowAction = r100;
    }
}
