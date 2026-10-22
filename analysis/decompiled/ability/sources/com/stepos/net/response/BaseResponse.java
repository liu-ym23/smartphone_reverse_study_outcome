package com.stepos.net.response;

import S7.k;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.net.HttpConfig;
import com.stepos.net.HttpManager;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/net/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/net/response/IResponse;", "code", "", "message", "", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "value", "", "hasData", "getHasData", "()Z", "setHasData$net_debug", "(Z)V", "isSuccess", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseResponse<T> implements IResponse<T> {

    @SerializedName(alternate = {"errorCode"}, value = "code")
    private final int code;

    @SerializedName(alternate = {"result", "payload"}, value = SettingsConfig.KEY_DATA)
    private final T data;
    private transient boolean hasData;

    @SerializedName(alternate = {NotificationCompat.CATEGORY_MESSAGE, "errorMessage"}, value = "message")
    private final String message;

    public BaseResponse() {
        this(0, null, null, 7, null);
    }

    @Override // com.stepos.net.response.IResponse
    public int getCode() {
        return this.code;
    }

    @Override // com.stepos.net.response.IResponse
    public T getData() {
        return this.data;
    }

    public final boolean getHasData() {
        return this.hasData;
    }

    @Override // com.stepos.net.response.IResponse
    public String getMessage() {
        return this.message;
    }

    @Override // com.stepos.net.response.IResponse
    public boolean isSuccess() {
        k successCodeChecker;
        HttpConfig httpConfigConfigOrNull$net_debug = HttpManager.INSTANCE.configOrNull$net_debug();
        return (httpConfigConfigOrNull$net_debug == null || (successCodeChecker = httpConfigConfigOrNull$net_debug.getSuccessCodeChecker()) == null) ? getCode() == 200 : ((Boolean) successCodeChecker.invoke(Integer.valueOf(getCode()))).booleanValue();
    }

    public final void setHasData$net_debug(boolean z10) {
        this.hasData = z10;
    }

    public BaseResponse(int i, String message, T t9) {
        kotlin.jvm.internal.k.f(message, "message");
        this.code = i;
        this.message = message;
        this.data = t9;
    }

    public /* synthetic */ BaseResponse(int i, String str, Object obj, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? null : obj);
    }
}
