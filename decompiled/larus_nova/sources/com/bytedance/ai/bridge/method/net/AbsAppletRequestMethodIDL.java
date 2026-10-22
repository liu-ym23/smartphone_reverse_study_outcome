package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\n\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "AppletRequestParamModel", "AppletRequestResultModel", "StreamResponseData", "StreamResponseStatus", "RequestMethodType", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAppletRequestMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35619a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$RequestMethodType;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestMethodType[] f35620a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35621b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RequestMethodType> getEntries() {
            return f35621b;
        }

        static {
            RequestMethodType r100 = new RequestMethodType("GET", 0);
            GET = r100;
            RequestMethodType r101 = new RequestMethodType("POST", 1);
            POST = r101;
            RequestMethodType r102 = new RequestMethodType("PUT", 2);
            PUT = r102;
            RequestMethodType r103 = new RequestMethodType("DELETE", 3);
            DELETE = r103;
            RequestMethodType r104 = new RequestMethodType("UNSUPPORTED", 4);
            UNSUPPORTED = r104;
            RequestMethodType[] r105 = {r100, r101, r102, r103, r104};
            f35620a = r105;
            f35621b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) f35620a.clone();
        }

        public static RequestMethodType valueOf(String r100) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r100);
        }

        public RequestMethodType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003JX\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006)"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "", "event", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "sessionId", "", "index", "", "data", "", "code", "", "message", "<init>", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getEvent", "()Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "getSessionId", "()Ljava/lang/String;", "getIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Ljava/util/List;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StreamResponseData {
        private final Integer code;
        private final List<String> data;
        private final StreamResponseStatus event;
        private final Long index;
        private final String message;
        private final String sessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamResponseData copy$default(StreamResponseData r100, StreamResponseStatus r101, String r102, Long r103, List r104, Integer r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.event;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.sessionId;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.index;
        L11:
            Long r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.data;
        L14:
            List r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.code;
        L17:
            Integer r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.message;
        L20:
            StreamResponseStatus r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final StreamResponseStatus component1() {
            return this.event;
        }

        public final String component2() {
            return this.sessionId;
        }

        public final Long component3() {
            return this.index;
        }

        public final List<String> component4() {
            return this.data;
        }

        public final Integer component5() {
            return this.code;
        }

        public final String component6() {
            return this.message;
        }

        public final StreamResponseData copy(StreamResponseStatus r100, String r110, Long r111, List<String> r112, Integer r113, String r114) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r110, "sessionId");
            return new StreamResponseData(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof StreamResponseData) == true) goto L8;
            return false;
        L8:
            StreamResponseData r101 = (StreamResponseData) r100;
            if (this.event == r101.event) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.index, r101.index) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.code, r101.code) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.event.hashCode() * 31) + this.sessionId.hashCode()) * 31;
            Long r101 = this.index;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.data;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Integer r108 = this.code;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.message;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "StreamResponseData(event=" + this.event + ", sessionId=" + this.sessionId + ", index=" + this.index + ", data=" + this.data + ", code=" + this.code + ", message=" + this.message + ')';
        }

        public final Integer getCode() {
            return this.code;
        }

        public final List<String> getData() {
            return this.data;
        }

        public final StreamResponseStatus getEvent() {
            return this.event;
        }

        public final Long getIndex() {
            return this.index;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public StreamResponseData(StreamResponseStatus r100, String r101, Long r102, List<String> r103, Integer r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            this.event = r100;
            this.sessionId = r101;
            this.index = r102;
            this.data = r103;
            this.code = r104;
            this.message = r105;
        }

        public /* synthetic */ StreamResponseData(StreamResponseStatus r110, String r111, Long r112, List r113, Integer r114, String r115, int r116, DefaultConstructorMarker r117) {
            if ((r116 & 4) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r116 & 8) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r116 & 16) == 0) goto L13;
            Integer r102 = null;
        L15:
            if ((r116 & 32) == 0) goto L17;
            String r103 = null;
        L18:
            this(r110, r111, r100, r101, r102, r103);
            return;
        L17:
            r103 = r115;
            goto L18
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DATA", "COMPLETE", "ERROR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StreamResponseStatus extends Enum<StreamResponseStatus> {

        @SerializedName(BitableAnalytic.SelectSceneClickType.COMPLETE)
        public static final StreamResponseStatus COMPLETE = null;

        @SerializedName("data")
        public static final StreamResponseStatus DATA = null;

        @SerializedName("error")
        public static final StreamResponseStatus ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StreamResponseStatus[] f35622a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35623b = null;

        public static EnumEntries<StreamResponseStatus> getEntries() {
            return f35623b;
        }

        static {
            StreamResponseStatus r100 = new StreamResponseStatus("DATA", 0);
            DATA = r100;
            StreamResponseStatus r101 = new StreamResponseStatus("COMPLETE", 1);
            COMPLETE = r101;
            StreamResponseStatus r102 = new StreamResponseStatus("ERROR", 2);
            ERROR = r102;
            StreamResponseStatus[] r103 = {r100, r101, r102};
            f35622a = r103;
            f35623b = EnumEntriesKt.enumEntries(r103);
        }

        public static StreamResponseStatus[] values() {
            return (StreamResponseStatus[]) f35622a.clone();
        }

        public static StreamResponseStatus valueOf(String r100) {
            return (StreamResponseStatus) r27.a.a(StreamResponseStatus.class, r100);
        }

        public StreamResponseStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "addCommonParams", required = true)
        boolean getAddCommonParams();

        @AIBridgeParamField(keyPath = ContainerPosition.BODY, required = false)
        Object getBody();

        @AIBridgeParamField(keyPath = "bodyType", required = false)
        String getBodyType();

        @AIBridgeParamField(keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @AIBridgeParamField(keyPath = com.alipay.sdk.m.p.e.f25671s, required = true)
        String getMethod();

        @AIBridgeParamField(keyPath = "params", required = false)
        Map<String, Object> getParams();

        @AIBridgeParamField(keyPath = "streamType", required = false)
        String getStreamType();

        @AIBridgeParamField(keyPath = "url", required = true)
        String getUrl();

        @AIBridgeParamField(keyPath = "isCustomizedCookie", required = false)
        Boolean isCustomizedCookie();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(intValue = 0, type = DefaultType.INT), keyPath = "clientCode", required = true)
        void setClientCode(Number r100);

        @AIBridgeParamField(keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r100);

        @AIBridgeParamField(keyPath = "httpCode", required = false)
        void setHttpCode(Number r100);

        @AIBridgeParamField(keyPath = "response", required = false)
        void setResponse(Object r100);

        @AIBridgeParamField(keyPath = "responseType", required = false)
        void setResponseType(String r100);

        @AIBridgeParamField(keyPath = "sessionId", required = false)
        void setSessionId(String r100);
    }

    public AbsAppletRequestMethodIDL() {
        this.f35619a = "applet.request";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35619a;
    }
}
