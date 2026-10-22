package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import com.amap.api.services.core.AMapException;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0003 !\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult;", "", "type", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$Type;", "detailCode", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$DetailCode;", "message", "", "ext", "", "(Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$Type;Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$DetailCode;Ljava/lang/String;Ljava/util/Map;)V", "getDetailCode", "()Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$DetailCode;", "getExt", "()Ljava/util/Map;", "isTerminal", "", "()Z", "getMessage", "()Ljava/lang/String;", "getType", "()Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$Type;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "DetailCode", "Type", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintResult {
    public static final Companion Companion = null;
    private final DetailCode detailCode;
    private final Map<String, Object> ext;
    private final String message;
    private final Type type;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006J0\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006J(\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006J\u001e\u0010\r\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$Companion;", "", "()V", "cancelled", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult;", "ext", "", "", "failed", "detailCode", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$DetailCode;", "message", "invalidParams", "success", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VoicePrintResult cancelled(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "ext");
            Type r101 = Type.USER_CANCELLED;
            DetailCode r102 = DetailCode.USER_CANCELLED;
            return new VoicePrintResult(r101, r102, r102.getDesc(), r100);
        }

        public final VoicePrintResult success(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "ext");
            Type r101 = Type.SUCCESS;
            DetailCode r102 = DetailCode.SUCCESS;
            return new VoicePrintResult(r101, r102, r102.getDesc(), r100);
        }

        public final VoicePrintResult invalidParams(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "ext");
            return new VoicePrintResult(Type.INVALID_PARAMS, DetailCode.INVALID_PARAMS, r100, r101);
        }

        public final VoicePrintResult failed(DetailCode r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "detailCode");
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "ext");
            return new VoicePrintResult(Type.FAILED, r100, r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoicePrintResult cancelled$default(Companion r100, Map r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = MapsKt.emptyMap();
        L6:
            return r100.cancelled(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoicePrintResult success$default(Companion r100, Map r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = MapsKt.emptyMap();
        L6:
            return r100.success(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoicePrintResult invalidParams$default(Companion r100, String r101, Map r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = DetailCode.INVALID_PARAMS.getDesc();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = MapsKt.emptyMap();
        L9:
            return r100.invalidParams(r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoicePrintResult failed$default(Companion r100, DetailCode r101, String r102, Map r103, int r104, Object r105) {
            if ((r104 & 2) == 0) goto L6;
            r102 = r101.getDesc();
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = MapsKt.emptyMap();
        L9:
            return r100.failed(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$DetailCode;", "", "value", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getValue", "()I", "SUCCESS", "INVALID_PARAMS", "USER_CANCELLED", "PERMISSION_DENIED", "PERMISSION_PREVIOUSLY_DENIED", "VERIFY_FAILED_DISABLE_RETRY", "VERIFY_FAILED_ENABLE_RETRY", "UNKNOWN_ERROR", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DetailCode extends Enum<DetailCode> {
        private static final /* synthetic */ DetailCode[] $VALUES = null;
        public static final DetailCode INVALID_PARAMS = null;
        public static final DetailCode PERMISSION_DENIED = null;
        public static final DetailCode PERMISSION_PREVIOUSLY_DENIED = null;
        public static final DetailCode SUCCESS = null;
        public static final DetailCode UNKNOWN_ERROR = null;
        public static final DetailCode USER_CANCELLED = null;
        public static final DetailCode VERIFY_FAILED_DISABLE_RETRY = null;
        public static final DetailCode VERIFY_FAILED_ENABLE_RETRY = null;
        private final String desc;
        private final int value;

        private static final /* synthetic */ DetailCode[] $values() {
            return new DetailCode[]{SUCCESS, INVALID_PARAMS, USER_CANCELLED, PERMISSION_DENIED, PERMISSION_PREVIOUSLY_DENIED, VERIFY_FAILED_DISABLE_RETRY, VERIFY_FAILED_ENABLE_RETRY, UNKNOWN_ERROR};
        }

        public static DetailCode valueOf(String r100) {
            return (DetailCode) a.a(DetailCode.class, r100);
        }

        public static DetailCode[] values() {
            return (DetailCode[]) $VALUES.clone();
        }

        static {
            SUCCESS = new DetailCode("SUCCESS", 0, 0, "成功");
            INVALID_PARAMS = new DetailCode("INVALID_PARAMS", 1, 100, "参数不合法");
            USER_CANCELLED = new DetailCode("USER_CANCELLED", 2, 200, "用户取消");
            PERMISSION_DENIED = new DetailCode("PERMISSION_DENIED", 3, 300, "权限被拒绝");
            PERMISSION_PREVIOUSLY_DENIED = new DetailCode("PERMISSION_PREVIOUSLY_DENIED", 4, 301, "权限之前已被拒绝");
            VERIFY_FAILED_DISABLE_RETRY = new DetailCode("VERIFY_FAILED_DISABLE_RETRY", 5, 302, "验证失败流程结束");
            VERIFY_FAILED_ENABLE_RETRY = new DetailCode("VERIFY_FAILED_ENABLE_RETRY", 6, 303, "验证失败可重试");
            UNKNOWN_ERROR = new DetailCode("UNKNOWN_ERROR", 7, 304, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getValue() {
            return this.value;
        }

        private DetailCode(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.desc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult$Type;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "USER_CANCELLED", "INVALID_PARAMS", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FAILED = null;
        public static final Type INVALID_PARAMS = null;
        public static final Type SUCCESS = null;
        public static final Type USER_CANCELLED = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SUCCESS, FAILED, USER_CANCELLED, INVALID_PARAMS};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            SUCCESS = new Type("SUCCESS", 0);
            FAILED = new Type("FAILED", 1);
            USER_CANCELLED = new Type("USER_CANCELLED", 2);
            INVALID_PARAMS = new Type("INVALID_PARAMS", 3);
            $VALUES = $values();
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoicePrintResult copy$default(VoicePrintResult r100, Type r101, DetailCode r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.detailCode;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.message;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Type component1() {
        return this.type;
    }

    public final DetailCode component2() {
        return this.detailCode;
    }

    public final String component3() {
        return this.message;
    }

    public final Map<String, Object> component4() {
        return this.ext;
    }

    public final VoicePrintResult copy(Type r100, DetailCode r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "detailCode");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "ext");
        return new VoicePrintResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoicePrintResult) == true) goto L8;
        return false;
    L8:
        VoicePrintResult r101 = (VoicePrintResult) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.detailCode == r101.detailCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.detailCode.hashCode()) * 31) + this.message.hashCode()) * 31) + this.ext.hashCode();
    }

    public String toString() {
        return "VoicePrintResult(type=" + this.type + ", detailCode=" + this.detailCode + ", message=" + this.message + ", ext=" + this.ext + ')';
    }

    public final boolean isTerminal() {
        Type r100 = this.type;
        if (r100 != Type.SUCCESS) goto L5;
    L20:
        return true;
    L5:
        if (r100 == Type.USER_CANCELLED) goto L20;
        if (r100 == Type.INVALID_PARAMS) goto L20;
        Type r101 = Type.FAILED;
        if (r100 == r101) goto L11;
    L12:
        if (r100 == r101) goto L14;
    L15:
        if (r100 == r101) goto L17;
    L19:
        return false;
    L17:
        if (this.detailCode != DetailCode.UNKNOWN_ERROR) goto L19;
    L14:
        if (this.detailCode == DetailCode.VERIFY_FAILED_DISABLE_RETRY) goto L20;
    L11:
        if (this.detailCode == DetailCode.PERMISSION_DENIED) goto L20;
        goto L12
    }

    public final DetailCode getDetailCode() {
        return this.detailCode;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Type getType() {
        return this.type;
    }

    public VoicePrintResult(Type r100, DetailCode r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "detailCode");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "ext");
        this.type = r100;
        this.detailCode = r101;
        this.message = r102;
        this.ext = r103;
    }

    public /* synthetic */ VoicePrintResult(Type r100, DetailCode r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = MapsKt.emptyMap();
    L8:
        this(r100, r101, r102, r103);
    }
}
