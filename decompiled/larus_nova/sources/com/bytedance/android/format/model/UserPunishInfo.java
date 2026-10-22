package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/format/model/UserPunishInfo;", "Ljava/io/Serializable;", "", "status", "I", "getStatus", "()I", "", "punishEndTime", "J", "getPunishEndTime", "()J", "", "needPopToast", "Z", "getNeedPopToast", "()Z", "", "toast", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "canShowMessage", "getCanShowMessage", "canEnterLive", "getCanEnterLive", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserPunishInfo implements Serializable {
    public static final a Companion = null;
    public static final int PUNISH_STATUS_BAN = 2;
    public static final int PUNISH_STATUS_NORMAL = 0;
    public static final int PUNISH_STATUS_WARNING = 1;

    @SerializedName("can_enter_live")
    private final boolean canEnterLive;

    @SerializedName("can_show_message")
    private final boolean canShowMessage;

    @SerializedName("need_pop_toast")
    private final boolean needPopToast;

    @SerializedName("punish_end_time")
    private final long punishEndTime;

    @SerializedName("status")
    private final int status;

    @SerializedName("toast")
    private final String toast;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UserPunishInfo() {
        this.punishEndTime = -1;
        this.canShowMessage = true;
    }

    public final boolean getCanEnterLive() {
        return this.canEnterLive;
    }

    public final boolean getCanShowMessage() {
        return this.canShowMessage;
    }

    public final boolean getNeedPopToast() {
        return this.needPopToast;
    }

    public final long getPunishEndTime() {
        return this.punishEndTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getToast() {
        return this.toast;
    }
}
