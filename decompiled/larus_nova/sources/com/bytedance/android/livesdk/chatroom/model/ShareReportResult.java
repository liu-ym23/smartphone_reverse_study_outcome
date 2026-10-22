package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.message.Text;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ShareReportResult {

    @SerializedName("delta_intimacy")
    private long deltaIntimacy;

    @SerializedName("display_text")
    private Text displayText;

    public ShareReportResult() {
    }

    public long getDeltaIntimacy() {
        return this.deltaIntimacy;
    }

    public Text getDisplayText() {
        return this.displayText;
    }

    @SerializedName("delta_intimacy")
    public void setDeltaIntimacy(long r100) {
        this.deltaIntimacy = r100;
    }

    @SerializedName("display_text")
    public void setDisplayText(Text r100) {
        this.displayText = r100;
    }
}
