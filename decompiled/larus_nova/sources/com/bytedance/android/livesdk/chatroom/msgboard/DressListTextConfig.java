package com.bytedance.android.livesdk.chatroom.msgboard;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/msgboard/DressListTextConfig;", "", "()V", "badgeTitle", "", "getBadgeTitle", "()Ljava/lang/String;", "setBadgeTitle", "(Ljava/lang/String;)V", "dressTitle", "getDressTitle", "setDressTitle", "inputBoxBadgeText", "getInputBoxBadgeText", "setInputBoxBadgeText", "inputBoxCbText", "getInputBoxCbText", "setInputBoxCbText", "inputBoxCoverText", "getInputBoxCoverText", "setInputBoxCoverText", "purchaseText", "getPurchaseText", "setPurchaseText", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DressListTextConfig implements h {

    @SerializedName("badge_title")
    protected String badgeTitle;

    @SerializedName("dress_title")
    protected String dressTitle;

    @SerializedName("input_box_badge_text")
    protected String inputBoxBadgeText;

    @SerializedName("input_box_cb_text")
    protected String inputBoxCbText;

    @SerializedName("input_box_cover_text")
    protected String inputBoxCoverText;

    @SerializedName("purchase_text")
    protected String purchaseText;

    public DressListTextConfig() {
    }

    public DressListTextConfig(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.purchaseText = am3.h.c(r100);
        goto L3
    L8:
        this.badgeTitle = am3.h.c(r100);
        goto L3
    L9:
        this.dressTitle = am3.h.c(r100);
        goto L3
    L10:
        this.inputBoxCbText = am3.h.c(r100);
        goto L3
    L11:
        this.inputBoxBadgeText = am3.h.c(r100);
        goto L3
    L12:
        this.inputBoxCoverText = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public final String getBadgeTitle() {
        return this.badgeTitle;
    }

    public final String getDressTitle() {
        return this.dressTitle;
    }

    public final String getInputBoxBadgeText() {
        return this.inputBoxBadgeText;
    }

    public final String getInputBoxCbText() {
        return this.inputBoxCbText;
    }

    public final String getInputBoxCoverText() {
        return this.inputBoxCoverText;
    }

    public final String getPurchaseText() {
        return this.purchaseText;
    }

    public final void setBadgeTitle(String r100) {
        this.badgeTitle = r100;
    }

    public final void setDressTitle(String r100) {
        this.dressTitle = r100;
    }

    public final void setInputBoxBadgeText(String r100) {
        this.inputBoxBadgeText = r100;
    }

    public final void setInputBoxCbText(String r100) {
        this.inputBoxCbText = r100;
    }

    public final void setInputBoxCoverText(String r100) {
        this.inputBoxCoverText = r100;
    }

    public final void setPurchaseText(String r100) {
        this.purchaseText = r100;
    }
}
