package com.stepos.net.response;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.stepos.net.HttpConfig;
import com.stepos.net.HttpManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/net/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/net/response/IResponse;", "code", "", "message", "", "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", UxipConstants.f30680s, "", "hasData", "getHasData", "()Z", "setHasData$net_release", "(Z)V", "isSuccess", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public class BaseResponse<T> implements IResponse<T> {

    @SerializedName(alternate = {"errorCode"}, value = "code")
    private final int code;

    @SerializedName(alternate = {"result", "payload"}, value = "data")
    private final T data;
    private transient boolean hasData;

    @SerializedName(alternate = {"msg", "errorMessage"}, value = "message")
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
        InterfaceC5074l<Integer, Boolean> successCodeChecker;
        HttpConfig httpConfigConfigOrNull$net_release = HttpManager.INSTANCE.configOrNull$net_release();
        return (httpConfigConfigOrNull$net_release == null || (successCodeChecker = httpConfigConfigOrNull$net_release.getSuccessCodeChecker()) == null) ? getCode() == 200 : successCodeChecker.invoke(Integer.valueOf(getCode())).booleanValue();
    }

    public final void setHasData$net_release(boolean z10) {
        this.hasData = z10;
    }

    public BaseResponse(int i10, String message, T t10) {
        p.i(message, "message");
        this.code = i10;
        this.message = message;
        this.data = t10;
    }

    public /* synthetic */ BaseResponse(int i10, String str, Object obj, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : obj);
    }
}
