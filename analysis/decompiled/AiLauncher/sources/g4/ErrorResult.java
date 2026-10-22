package g4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u000fR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lg4/f;", "", "", "code", "message", "", "status", "tempCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getCode", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "c", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "(Ljava/lang/Integer;)V", "I", "getTempCode", "()I", "e", "(I)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public class ErrorResult {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private Integer status;
    private int tempCode;

    public ErrorResult() {
        this(null, null, null, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final void b(String str) {
        this.code = str;
    }

    public final void c(String str) {
        this.message = str;
    }

    public final void d(Integer num) {
        this.status = num;
    }

    public final void e(int i10) {
        this.tempCode = i10;
    }

    public String toString() {
        return "ErrorResult(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public ErrorResult(String str, String str2, Integer num, int i10) {
        this.code = str;
        this.message = str2;
        this.status = num;
        this.tempCode = i10;
    }

    public /* synthetic */ ErrorResult(String str, String str2, Integer num, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : num, (i11 & 8) != 0 ? 0 : i10);
    }
}
