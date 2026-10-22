package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import w20.be;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SendDataToTargetLynxParamModelSerializableObjectImpl;", "Lw20/be;", "", "from", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "", RemoteMessageConst.TO, "Ljava/util/List;", "getTo", "()Ljava/util/List;", "setTo", "(Ljava/util/List;)V", "data", "getData", "setData", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendDataToTargetLynxParamModelSerializableObjectImpl implements be {

    @SerializedName("data")
    private String data;

    @SerializedName("from")
    private String from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @SerializedName(RemoteMessageConst.TO)
    private List<String> f63149to;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SendDataToTargetLynxParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SendDataToTargetLynxParamModelSerializableObjectImpl.class);
        }
    }

    public SendDataToTargetLynxParamModelSerializableObjectImpl() {
        this.from = "";
        this.f63149to = d.a();
        this.data = "";
    }

    @Override // w20.be
    public final String getData() {
        return this.data;
    }

    @Override // w20.be
    public final String getFrom() {
        return this.from;
    }

    @Override // w20.be
    public final List<String> getTo() {
        return this.f63149to;
    }
}
