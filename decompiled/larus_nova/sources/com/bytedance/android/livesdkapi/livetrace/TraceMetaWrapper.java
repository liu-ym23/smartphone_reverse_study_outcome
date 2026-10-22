package com.bytedance.android.livesdkapi.livetrace;

import com.bytedance.android.ec.core.event.a;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 H2\u00020\u0001:\u0002GHB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u009f\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J¨\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0010HÖ\u0001J\t\u0010F\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "", "builder", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Builder;", "(Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Builder;)V", "eventType", "", "businessType", "traceId", "logId", "productId", "step", "roomId", "anchorId", "userId", "statusCode", "", a.KEY_STATUS_MSG, "index", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "getBusinessType", "setBusinessType", "getEventType", "setEventType", "getIndex", "()Ljava/util/Map;", "setIndex", "(Ljava/util/Map;)V", "getLogId", "setLogId", "getProductId", "setProductId", "getRoomId", "setRoomId", "getStatusCode", "()Ljava/lang/Integer;", "setStatusCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatusMsg", "setStatusMsg", "getStep", "setStep", "getTraceId", "setTraceId", "getUserId", "setUserId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "equals", "", "other", "hashCode", "toString", "Builder", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TraceMetaWrapper {
    public static final Companion Companion = null;
    private String anchorId;
    private String businessType;
    private String eventType;
    private Map<String, Object> index;
    private String logId;
    private String productId;
    private String roomId;
    private Integer statusCode;
    private String statusMsg;
    private String step;
    private String traceId;
    private String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0006\u0010'\u001a\u00020(J\u001c\u0010\u0010\u001a\u00020\u00002\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010)J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0003J\u0010\u0010\"\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u0010\u0010$\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0003R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR>\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\"\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\"\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\"\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\t¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Builder;", "", "eventType", "", "businessType", "(Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "anchorId", "getAnchorId", "()Ljava/lang/String;", "getBusinessType", "setBusinessType", "(Ljava/lang/String;)V", "getEventType", "setEventType", "", "index", "getIndex", "()Ljava/util/Map;", "logId", "getLogId", "productId", "getProductId", "roomId", "getRoomId", "", "statusCode", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", a.KEY_STATUS_MSG, "getStatusMsg", "step", "getStep", "traceId", "getTraceId", "userId", "getUserId", "id", "build", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "(Ljava/lang/Integer;)Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Builder;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private String anchorId;
        private String businessType;
        private String eventType;
        private Map<String, Object> index;
        private String logId;
        private String productId;
        private String roomId;
        private Integer statusCode;
        private String statusMsg;
        private String step;
        private String traceId;
        private String userId;

        public final TraceMetaWrapper build() {
            return new TraceMetaWrapper(this, null);
        }

        public final String getAnchorId() {
            return this.anchorId;
        }

        public final String getBusinessType() {
            return this.businessType;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final Map<String, Object> getIndex() {
            return this.index;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final Integer getStatusCode() {
            return this.statusCode;
        }

        public final String getStatusMsg() {
            return this.statusMsg;
        }

        public final String getStep() {
            return this.step;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final Builder anchorId(String r100) {
            this.anchorId = r100;
            return this;
        }

        public final Builder index(Map<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "index");
            this.index = r100;
            return this;
        }

        public final Builder logId(String r100) {
            this.logId = r100;
            return this;
        }

        public final Builder productId(String r100) {
            this.productId = r100;
            return this;
        }

        public final Builder roomId(String r100) {
            this.roomId = r100;
            return this;
        }

        public final void setBusinessType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.businessType = r100;
        }

        public final void setEventType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.eventType = r100;
        }

        public final Builder statusCode(Integer r100) {
            this.statusCode = r100;
            return this;
        }

        public final Builder statusMsg(String r100) {
            this.statusMsg = r100;
            return this;
        }

        public final Builder step(String r100) {
            this.step = r100;
            return this;
        }

        public final Builder traceId(String r100) {
            this.traceId = r100;
            return this;
        }

        public final Builder userId(String r100) {
            this.userId = r100;
            return this;
        }

        public Builder(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            Intrinsics.checkNotNullParameter(r101, "businessType");
            this.eventType = r100;
            this.businessType = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Companion;", "", "()V", "builder", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper$Builder;", "eventType", "", "businessType", "gen", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final Builder builder(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            Intrinsics.checkNotNullParameter(r101, "businessType");
            return new Builder(r100, r101);
        }

        @JvmStatic
        public final TraceMetaWrapper gen(String r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "eventType");
            Intrinsics.checkNotNullParameter(r111, "businessType");
            return new TraceMetaWrapper(r110, r111, null, null, null, null, null, null, null, null, null, null, 4092, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TraceMetaWrapper() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    @JvmStatic
    public static final Builder builder(String r100, String r101) {
        return Companion.builder(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TraceMetaWrapper copy$default(TraceMetaWrapper r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, Integer r213, String r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.eventType;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.businessType;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.traceId;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.logId;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.productId;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.step;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.roomId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.anchorId;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.userId;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Integer r118 = r110.statusCode;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.statusMsg;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r108 = r110.index;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @JvmStatic
    public static final TraceMetaWrapper gen(String r100, String r101) {
        return Companion.gen(r100, r101);
    }

    public final String component1() {
        return this.eventType;
    }

    public final Integer component10() {
        return this.statusCode;
    }

    public final String component11() {
        return this.statusMsg;
    }

    public final Map<String, Object> component12() {
        return this.index;
    }

    public final String component2() {
        return this.businessType;
    }

    public final String component3() {
        return this.traceId;
    }

    public final String component4() {
        return this.logId;
    }

    public final String component5() {
        return this.productId;
    }

    public final String component6() {
        return this.step;
    }

    public final String component7() {
        return this.roomId;
    }

    public final String component8() {
        return this.anchorId;
    }

    public final String component9() {
        return this.userId;
    }

    public final TraceMetaWrapper copy(String r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, Integer r214, String r215, Map<String, Object> r216) {
        Intrinsics.checkNotNullParameter(r110, "eventType");
        Intrinsics.checkNotNullParameter(r111, "businessType");
        return new TraceMetaWrapper(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TraceMetaWrapper) == false) goto L30;
        TraceMetaWrapper r101 = (TraceMetaWrapper) r100;
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessType, r101.businessType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.step, r101.step) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.eventType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.businessType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.traceId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.logId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.productId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.step;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.roomId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.anchorId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.userId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.statusCode;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.statusMsg;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, Object> r134 = this.index;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TraceMetaWrapper(eventType=" + this.eventType + ", businessType=" + this.businessType + ", traceId=" + this.traceId + ", logId=" + this.logId + ", productId=" + this.productId + ", step=" + this.step + ", roomId=" + this.roomId + ", anchorId=" + this.anchorId + ", userId=" + this.userId + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", index=" + this.index + ")";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> getIndex() {
        return this.index;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final String getStep() {
        return this.step;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    private TraceMetaWrapper(Builder r110) {
        this(r110.getEventType(), r110.getBusinessType(), r110.getTraceId(), r110.getLogId(), r110.getProductId(), r110.getStep(), r110.getRoomId(), r110.getAnchorId(), r110.getUserId(), r110.getStatusCode(), r110.getStatusMsg(), r110.getIndex());
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setBusinessType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.businessType = r100;
    }

    public final void setEventType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventType = r100;
    }

    public final void setIndex(Map<String, Object> r100) {
        this.index = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setStatusCode(Integer r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setStep(String r100) {
        this.step = r100;
    }

    public final void setTraceId(String r100) {
        this.traceId = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public /* synthetic */ TraceMetaWrapper(Builder r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public TraceMetaWrapper(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Integer r111, String r112, Map<String, Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        this.eventType = r100;
        this.businessType = r101;
        this.traceId = r102;
        this.logId = r103;
        this.productId = r104;
        this.step = r105;
        this.roomId = r106;
        this.anchorId = r107;
        this.userId = r110;
        this.statusCode = r111;
        this.statusMsg = r112;
        this.index = r113;
    }

    public /* synthetic */ TraceMetaWrapper(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, Integer r213, String r214, Map r215, int r216, DefaultConstructorMarker r217) {
        String r100 = "";
        if ((r216 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r216 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        Map r102 = null;
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Integer r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r102 = r215;
    L50:
        this(r101, r100, r103, r104, r105, r106, r107, r108, r116, r117, r118, r102);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
