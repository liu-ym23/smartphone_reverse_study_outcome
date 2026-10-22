package com.stepos.taskrobot.dictionary;

import androidx.constraintlayout.core.dsl.a;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/dictionary/ApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "getDataOrThrow", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/stepos/taskrobot/dictionary/ApiResponse;", "equals", "other", "hashCode", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApiResponse<T> {
    private final int code;
    private final T data;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private final String msg;

    public ApiResponse(int i, String str, T t9) {
        this.code = i;
        this.msg = str;
        this.data = t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, int i, String str, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            i = apiResponse.code;
        }
        if ((i6 & 2) != 0) {
            str = apiResponse.msg;
        }
        if ((i6 & 4) != 0) {
            obj = apiResponse.data;
        }
        return apiResponse.copy(i, str, obj);
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

    public final ApiResponse<T> copy(int code, String msg, T data) {
        return new ApiResponse<>(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) other;
        return this.code == apiResponse.code && k.b(this.msg, apiResponse.msg) && k.b(this.data, apiResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final T getDataOrThrow() {
        if (isSuccess()) {
            T t9 = this.data;
            if (t9 != null) {
                return t9;
            }
            throw new IllegalStateException("Data is null");
        }
        int i = this.code;
        String str = this.msg;
        if (str == null) {
            str = "Request failed";
        }
        throw new ApiException(i, str);
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t9 = this.data;
        return iHashCode2 + (t9 != null ? t9.hashCode() : 0);
    }

    public final boolean isSuccess() {
        int i = this.code;
        return i == 0 || i == 200;
    }

    public String toString() {
        int i = this.code;
        String str = this.msg;
        T t9 = this.data;
        StringBuilder sbK = a.k(i, "ApiResponse(code=", ", msg=", str, ", data=");
        sbK.append(t9);
        sbK.append(")");
        return sbK.toString();
    }

    public /* synthetic */ ApiResponse(int i, String str, Object obj, int i6, e eVar) {
        this(i, (i6 & 2) != 0 ? null : str, (i6 & 4) != 0 ? null : obj);
    }
}
