package com.bytedance.android.live.liveinteract;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.review.GetLatestBanRecordResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010&\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/liveinteract/LatestBanRecord;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lbf2/a;", "", "banTime", "J", "getBanTime", "()J", "setBanTime", "(J)V", "banDuration", "getBanDuration", "setBanDuration", "", "isBannedForever", "Z", "()Z", "setBannedForever", "(Z)V", "", "banReason", "Ljava/lang/String;", "getBanReason", "()Ljava/lang/String;", "setBanReason", "(Ljava/lang/String;)V", "detailUrl", "getDetailUrl", "setDetailUrl", "appealUrl", "getAppealUrl", "setAppealUrl", "banDetailSchema", "getBanDetailSchema", "setBanDetailSchema", "banDetailText", "getBanDetailText", "setBanDetailText", "popupWindowUrl", "getPopupWindowUrl", "setPopupWindowUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LatestBanRecord extends FlexModelBase<bf2.a> implements bf2.a, h {

    @SerializedName("appeal_url")
    protected String appealUrl;

    @SerializedName("ban_detail_schema")
    protected String banDetailSchema;

    @SerializedName("ban_detail_text")
    protected String banDetailText;

    @SerializedName("ban_duration")
    protected long banDuration;

    @SerializedName("ban_reason")
    protected String banReason;

    @SerializedName("ban_time")
    protected long banTime;

    @SerializedName("detail_url")
    protected String detailUrl;

    @SerializedName("is_banned_forever")
    protected boolean isBannedForever;

    @SerializedName("popup_window_url")
    protected String popupWindowUrl;

    public LatestBanRecord() {
        super(bf2.a.class);
    }

    @Override // bf2.a
    public String getAppealUrl() {
        return this.appealUrl;
    }

    @Override // bf2.a
    public String getBanDetailSchema() {
        return this.banDetailSchema;
    }

    @Override // bf2.a
    public String getBanDetailText() {
        return this.banDetailText;
    }

    @Override // bf2.a
    public long getBanDuration() {
        return this.banDuration;
    }

    @Override // bf2.a
    public String getBanReason() {
        return this.banReason;
    }

    @Override // bf2.a
    public long getBanTime() {
        return this.banTime;
    }

    @Override // bf2.a
    public String getDetailUrl() {
        return this.detailUrl;
    }

    @Override // bf2.a
    public String getPopupWindowUrl() {
        return this.popupWindowUrl;
    }

    @Override // bf2.a
    public boolean isBannedForever() {
        return this.isBannedForever;
    }

    public LatestBanRecord(g r100) {
        super(bf2.a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L26;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.banTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.banDuration = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.isBannedForever = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.banReason = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 12) goto L15;
        this.detailUrl = am3.h.c(r100);
        goto L3
    L15:
        switch(r102) {
            case 17: goto L20;
            case 18: goto L19;
            case 19: goto L18;
            case 20: goto L17;
            default: goto L16;
        };
    L17:
        this.popupWindowUrl = am3.h.c(r100);
        goto L3
    L18:
        this.banDetailText = am3.h.c(r100);
        goto L3
    L19:
        this.banDetailSchema = am3.h.c(r100);
        goto L3
    L20:
        this.appealUrl = am3.h.c(r100);
        goto L3
    L16:
        am3.h.d(r103, r100);
        goto L3
    L26:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setAppealUrl(String r100) {
        this.appealUrl = r100;
    }

    public void setBanDetailSchema(String r100) {
        this.banDetailSchema = r100;
    }

    public void setBanDetailText(String r100) {
        this.banDetailText = r100;
    }

    public void setBanDuration(long r100) {
        this.banDuration = r100;
    }

    public void setBanReason(String r100) {
        this.banReason = r100;
    }

    public void setBanTime(long r100) {
        this.banTime = r100;
    }

    public void setBannedForever(boolean r100) {
        this.isBannedForever = r100;
    }

    public void setDetailUrl(String r100) {
        this.detailUrl = r100;
    }

    public void setPopupWindowUrl(String r100) {
        this.popupWindowUrl = r100;
    }
}
