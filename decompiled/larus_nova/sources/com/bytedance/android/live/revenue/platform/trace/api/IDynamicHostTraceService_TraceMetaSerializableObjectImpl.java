package com.bytedance.android.live.revenue.platform.trace.api;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import j01.a;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR.\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/trace/api/IDynamicHostTraceService_TraceMetaSerializableObjectImpl;", "Lj01/a$a;", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "businessType", "getBusinessType", "setBusinessType", "traceId", "getTraceId", "setTraceId", "logId", "getLogId", "setLogId", "productId", "getProductId", "setProductId", "step", "getStep", "setStep", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "userId", "getUserId", "setUserId", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "statusMessage", "k6", "setStatusMessage", "", "index", "Ljava/util/Map;", "getIndex", "()Ljava/util/Map;", "setIndex", "(Ljava/util/Map;)V", "<init>", "()V", "Adapter", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDynamicHostTraceService_TraceMetaSerializableObjectImpl implements a.InterfaceC6375a {

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("business_type")
    private String businessType;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String eventName;

    @SerializedName("index")
    private Map<String, String> index;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_message")
    private String statusMessage;

    @SerializedName("step")
    private String step;

    @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
    private String traceId;

    @SerializedName("user_id")
    private String userId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/trace/api/IDynamicHostTraceService_TraceMetaSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IDynamicHostTraceService_TraceMetaSerializableObjectImpl.class);
        }
    }

    public IDynamicHostTraceService_TraceMetaSerializableObjectImpl() {
        this.eventName = "";
        this.businessType = "";
        this.traceId = "";
        this.logId = "";
        this.productId = "";
        this.step = "";
        this.roomId = "";
        this.anchorId = "";
        this.userId = "";
        this.statusMessage = "";
        this.index = d.b();
    }

    @Override // j01.a.InterfaceC6375a
    public final String getAnchorId() {
        return this.anchorId;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getBusinessType() {
        return this.businessType;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getEventName() {
        return this.eventName;
    }

    @Override // j01.a.InterfaceC6375a
    public final Map<String, String> getIndex() {
        return this.index;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getLogId() {
        return this.logId;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getProductId() {
        return this.productId;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getRoomId() {
        return this.roomId;
    }

    @Override // j01.a.InterfaceC6375a
    public final int getStatusCode() {
        return this.statusCode;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getStep() {
        return this.step;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getTraceId() {
        return this.traceId;
    }

    @Override // j01.a.InterfaceC6375a
    public final String getUserId() {
        return this.userId;
    }

    @Override // j01.a.InterfaceC6375a
    public final String k6() {
        return this.statusMessage;
    }
}
