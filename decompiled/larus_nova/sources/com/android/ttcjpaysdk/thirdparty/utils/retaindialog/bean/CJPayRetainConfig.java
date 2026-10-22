package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "retain_alert_left_button_text", "", "getRetain_alert_left_button_text", "()Ljava/lang/String;", "setRetain_alert_left_button_text", "(Ljava/lang/String;)V", "retain_alert_right_button_text", "getRetain_alert_right_button_text", "setRetain_alert_right_button_text", "retain_alert_title", "getRetain_alert_title", "setRetain_alert_title", "retain_request_time_out", "", "getRetain_request_time_out", "()J", "setRetain_request_time_out", "(J)V", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainConfig implements CJPayObject {
    private String retain_alert_left_button_text;
    private String retain_alert_right_button_text;
    private String retain_alert_title;
    private long retain_request_time_out;

    public CJPayRetainConfig() {
        this.retain_request_time_out = 500;
    }

    public final String getRetain_alert_left_button_text() {
        return this.retain_alert_left_button_text;
    }

    public final String getRetain_alert_right_button_text() {
        return this.retain_alert_right_button_text;
    }

    public final String getRetain_alert_title() {
        return this.retain_alert_title;
    }

    public final long getRetain_request_time_out() {
        return this.retain_request_time_out;
    }

    public final void setRetain_alert_left_button_text(String r100) {
        this.retain_alert_left_button_text = r100;
    }

    public final void setRetain_alert_right_button_text(String r100) {
        this.retain_alert_right_button_text = r100;
    }

    public final void setRetain_alert_title(String r100) {
        this.retain_alert_title = r100;
    }

    public final void setRetain_request_time_out(long r100) {
        this.retain_request_time_out = r100;
    }
}
