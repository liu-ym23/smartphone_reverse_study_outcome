package okhttp3.internal.http2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ErrorCode {

    /* renamed from: b, reason: collision with root package name */
    public static final a f11121b;

    /* renamed from: c, reason: collision with root package name */
    public static final ErrorCode f11122c;

    /* renamed from: d, reason: collision with root package name */
    public static final ErrorCode f11123d;

    /* renamed from: e, reason: collision with root package name */
    public static final ErrorCode f11124e;
    public static final ErrorCode h;

    /* renamed from: j, reason: collision with root package name */
    public static final ErrorCode f11125j;

    /* renamed from: k, reason: collision with root package name */
    public static final ErrorCode f11126k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f11127l;

    /* renamed from: a, reason: collision with root package name */
    public final int f11128a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    static {
        ErrorCode errorCode = new ErrorCode("NO_ERROR", 0, 0);
        f11122c = errorCode;
        ErrorCode errorCode2 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        f11123d = errorCode2;
        ErrorCode errorCode3 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        f11124e = errorCode3;
        ErrorCode errorCode4 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        h = errorCode4;
        ErrorCode errorCode5 = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
        ErrorCode errorCode6 = new ErrorCode("STREAM_CLOSED", 5, 5);
        ErrorCode errorCode7 = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
        ErrorCode errorCode8 = new ErrorCode("REFUSED_STREAM", 7, 7);
        f11125j = errorCode8;
        ErrorCode errorCode9 = new ErrorCode("CANCEL", 8, 8);
        f11126k = errorCode9;
        ErrorCode[] errorCodeArr = {errorCode, errorCode2, errorCode3, errorCode4, errorCode5, errorCode6, errorCode7, errorCode8, errorCode9, new ErrorCode("COMPRESSION_ERROR", 9, 9), new ErrorCode("CONNECT_ERROR", 10, 10), new ErrorCode("ENHANCE_YOUR_CALM", 11, 11), new ErrorCode("INADEQUATE_SECURITY", 12, 12), new ErrorCode("HTTP_1_1_REQUIRED", 13, 13)};
        f11127l = errorCodeArr;
        kotlin.enums.a.a(errorCodeArr);
        f11121b = new a();
    }

    public ErrorCode(String str, int i10, int i11) {
        this.f11128a = i11;
    }

    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f11127l.clone();
    }
}
