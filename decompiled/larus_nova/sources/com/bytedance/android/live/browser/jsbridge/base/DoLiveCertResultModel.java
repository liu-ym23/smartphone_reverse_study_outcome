package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import org.json.JSONObject;
import r27.a;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel$Code;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "", "cert_status", "Ljava/lang/Integer;", "getCert_status", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "manual_status", "getManual_status", ce.f26391f, "age_range", "getAge_range", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "error_code", "getError_code", "d", "error_msg", "getError_msg", "e", "ticket", "getTicket", RXScreenCaptureService.KEY_INDEX, "Lorg/json/JSONObject;", "ext_data", "Lorg/json/JSONObject;", "getExt_data", "()Lorg/json/JSONObject;", "f", "(Lorg/json/JSONObject;)V", "<init>", "()V", "Code", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoLiveCertResultModel implements aa {

    @SerializedName("age_range")
    private Integer age_range;

    @SerializedName("cert_status")
    private Integer cert_status;

    @SerializedName("code")
    private Code code;

    @SerializedName("error_code")
    private Integer error_code;

    @SerializedName("error_msg")
    private String error_msg;

    @SerializedName("ext_data")
    private JSONObject ext_data;

    @SerializedName("manual_status")
    private Integer manual_status;

    @SerializedName("msg")
    private String msg;

    @SerializedName("ticket")
    private String ticket;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/DoLiveCertResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f62993a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f62993a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f62993a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public DoLiveCertResultModel() {
    }

    public final void a(Integer r100) {
        this.age_range = r100;
    }

    public final void b(Integer r100) {
        this.cert_status = r100;
    }

    public final void c(Code r100) {
        this.code = r100;
    }

    public final void d(Integer r100) {
        this.error_code = r100;
    }

    public final void e(String r100) {
        this.error_msg = r100;
    }

    public final void f(JSONObject r100) {
        this.ext_data = r100;
    }

    public final void g(Integer r100) {
        this.manual_status = r100;
    }

    public final void h(String r100) {
        this.msg = r100;
    }

    public final void i(String r100) {
        this.ticket = r100;
    }
}
