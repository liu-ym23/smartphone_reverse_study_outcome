package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class ExtraInfo {

    @SerializedName("enable_tap")
    boolean canClick;

    @SerializedName("click_event")
    String clickEvent;

    @SerializedName("click_event_params")
    Map<String, String> clickEventParams;

    @SerializedName("disappear_after_tap")
    boolean dismissAfterClick;

    @SerializedName("extra_message")
    String extraMessage;

    @SerializedName("global_click_event_params")
    Map<String, String> globalClickEventParams;

    @SerializedName("global_show_event_params")
    Map<String, String> globalShowEventParams;

    @SerializedName("scheme")
    String scheme;

    @SerializedName("show_event")
    String showEvent;

    @SerializedName("show_event_params")
    Map<String, String> showEventParams;

    public ExtraInfo() {
    }

    public String getClickEvent() {
        return this.clickEvent;
    }

    public Map<String, String> getClickEventParams() {
        return this.clickEventParams;
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }

    public Map<String, String> getGlobalClickEventParams() {
        return this.globalClickEventParams;
    }

    public Map<String, String> getGlobalShowEventParams() {
        return this.globalShowEventParams;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getShowEvent() {
        return this.showEvent;
    }

    public Map<String, String> getShowEventParams() {
        return this.showEventParams;
    }

    public boolean isCanClick() {
        return this.canClick;
    }

    public boolean isDismissAfterClick() {
        return this.dismissAfterClick;
    }
}
