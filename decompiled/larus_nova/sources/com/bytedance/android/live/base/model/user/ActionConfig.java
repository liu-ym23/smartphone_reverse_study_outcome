package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ActionConfig {
    public static long TYPE_ANCHOR_RELATION = 6;
    public static long TYPE_CHECK_ADVENTURE = 8;
    public static long TYPE_DIGG = 5;
    public static long TYPE_FLASH_SHOP = 4;
    public static long TYPE_GUEST_LINK_INVITE = 9;
    public static long TYPE_HEART = 12;
    public static long TYPE_INVITE_ADVENTURE = 7;
    public static long TYPE_LINK = 3;
    public static long TYPE_SECRET_CHAT = 11;
    public static long TYPE_SEND_GIFT = 2;
    public static long TYPE_WGAME = 1;

    @SerializedName("action")
    public py.k action;

    @SerializedName("action_name")
    public String actionName;

    @SerializedName("action_type")
    public long actionType;

    @SerializedName("clicked_info")
    public ClickedInfo clickedInfo;

    @SerializedName("enable")
    public boolean enable;

    @IgnoreProtoFieldCheck
    @SerializedName("extra_info")
    public String extraInfo;

    @SerializedName("hide_arrow")
    public boolean hideArrow;
    private boolean isUpdateButtonClickedInMore;

    @SerializedName("scheme")
    public String scheme;

    @SerializedName("click_text")
    public String tips;

    @SerializedName("title")
    public String title;

    public String getClickSchema() {
        py.k r100 = this.action;
        if (r100 == null) goto L9;
        if (TextUtils.isEmpty(r100.getSchema()) == true) goto L9;
        return this.action.getSchema();
    L9:
        return this.scheme;
    }

    public String getTextInMore() {
        if (this.isUpdateButtonClickedInMore == false) goto L14;
        ClickedInfo r100 = this.clickedInfo;
        if (r100 == null) goto L14;
        if (r100.getAction() == null) goto L14;
        if (this.clickedInfo.getAction().getImageContent() == null) goto L14;
        if (TextUtils.isEmpty(this.clickedInfo.getAction().getImageContent().getName()) == true) goto L14;
        return this.clickedInfo.getAction().getImageContent().getName();
    L14:
        py.k r101 = this.action;
        if (r101 != null) goto L17;
        return null;
    L17:
        if (r101.getImageContent() != null) goto L19;
        return null;
    L19:
        if (TextUtils.isEmpty(this.action.getImageContent().getName()) == false) goto L21;
        return null;
    L21:
        return this.action.getImageContent().getName();
    }

    public boolean isLeftIconValid() {
        py.k r100 = this.action;
        if (r100 != null) goto L7;
        return false;
    L7:
        return !r100.getUrls().isEmpty();
    }

    public boolean isUpdateButtonInMore() {
        ClickedInfo r100 = this.clickedInfo;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getAction() == null) goto L11;
        if (this.clickedInfo.getAction().getImageContent() == null) goto L11;
        if (TextUtils.isEmpty(this.clickedInfo.getAction().getImageContent().getName()) == true) goto L11;
        return true;
    }

    public ActionConfig() {
        this.enable = true;
        this.tips = "";
        this.title = "";
        this.scheme = "";
        this.extraInfo = "";
        this.hideArrow = false;
        this.isUpdateButtonClickedInMore = false;
    }

    public py.k getLeftIcon() {
        return this.action;
    }

    public String getRightText() {
        return this.title;
    }

    public boolean isUpdateButtonClickedInMore() {
        return this.isUpdateButtonClickedInMore;
    }

    public void setUpdateButtonClickedInMore(boolean r100) {
        this.isUpdateButtonClickedInMore = r100;
    }
}
