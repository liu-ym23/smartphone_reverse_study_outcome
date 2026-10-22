package com.stepos.ability.net.biz.model;

import B7.a;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/stepos/ability/net/biz/model/ApiResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "()Z", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/stepos/ability/net/biz/model/ApiResult;", "equals", "other", "hashCode", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApiResult<T> {

    @SerializedName("code")
    private final int code;

    @SerializedName(SettingsConfig.KEY_DATA)
    private final T data;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private final String msg;

    public ApiResult(int i, String msg, T t9) {
        k.f(msg, "msg");
        this.code = i;
        this.msg = msg;
        this.data = t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResult copy$default(ApiResult apiResult, int i, String str, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            i = apiResult.code;
        }
        if ((i6 & 2) != 0) {
            str = apiResult.msg;
        }
        if ((i6 & 4) != 0) {
            obj = apiResult.data;
        }
        return apiResult.copy(i, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final ApiResult<T> copy(int code, String msg, T data) {
        k.f(msg, "msg");
        return new ApiResult<>(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResult)) {
            return false;
        }
        ApiResult apiResult = (ApiResult) other;
        return this.code == apiResult.code && k.b(this.msg, apiResult.msg) && k.b(this.data, apiResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int iC = a.c(Integer.hashCode(this.code) * 31, 31, this.msg);
        T t9 = this.data;
        return iC + (t9 == null ? 0 : t9.hashCode());
    }

    public final boolean isSuccess() {
        return this.code == 200;
    }

    public String toString() {
        int i = this.code;
        String str = this.msg;
        T t9 = this.data;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "ApiResult(code=", ", msg=", str, ", data=");
        sbK.append(t9);
        sbK.append(")");
        return sbK.toString();
    }
}
