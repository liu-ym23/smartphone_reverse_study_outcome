package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/format/model/d0;", "", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "", "userId", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/Long;", "appId", "getAppId", "devicePlatFrom", "getDevicePlatFrom", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "deviceId", "getDeviceId", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("app_id")
    private final Long appId;

    @SerializedName("device_id")
    private final Long deviceId;

    @SerializedName("device_platform")
    private final String devicePlatFrom;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("user_id")
    private final Long userId;

    @SerializedName("version_code")
    private final String versionCode;

    public d0() {
    }
}
