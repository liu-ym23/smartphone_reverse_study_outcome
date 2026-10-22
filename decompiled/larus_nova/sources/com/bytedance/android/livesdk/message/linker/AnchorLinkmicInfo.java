package com.bytedance.android.livesdk.message.linker;

import android.text.TextUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class AnchorLinkmicInfo extends FlexModelBase<b> implements b {

    @SerializedName("use_backup_stream")
    public boolean isUseBackup;

    @SerializedName("linkmic_id_str")
    public String linkmicIdStr;

    @SerializedName("rtc_ext_info")
    public String rtcExtInfo;

    public AnchorLinkmicInfo() {
        super(b.class);
    }

    @Override // com.bytedance.android.livesdk.message.linker.b
    public String getLinkmicIdStr() {
        if (TextUtils.isEmpty(this.linkmicIdStr) == false) goto L7;
        return "";
    L7:
        return this.linkmicIdStr;
    }

    @Override // com.bytedance.android.livesdk.message.linker.b
    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.message.linker.b
    public boolean isUseBackup() {
        return this.isUseBackup;
    }

    @Override // com.bytedance.android.livesdk.message.linker.b
    public void setUseBackup(boolean r100) {
        this.isUseBackup = r100;
    }
}
