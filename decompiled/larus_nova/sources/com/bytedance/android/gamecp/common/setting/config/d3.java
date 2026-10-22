package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/d3;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "btn_show_limit", "getBtn_show_limit", "setBtn_show_limit", "requireDeviceStorage", "getRequireDeviceStorage", "setRequireDeviceStorage", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d3 {

    @SerializedName("btn_show_limit")
    private Integer btn_show_limit;

    @SerializedName("requireDeviceStorage")
    private Integer requireDeviceStorage;

    @SerializedName("type")
    private Integer type;

    public d3() {
    }

    public final Integer getType() {
        return this.type;
    }
}
