package j4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u000eR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lj4/c;", "", "", "code", "message", "", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getCode", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "getMessage", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: j4.c, reason: from toString */
/* loaded from: classes2.dex */
public class ErrorResult {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private Integer status;

    public ErrorResult() {
        this(null, null, null, 7, null);
    }

    public final void a(String str) {
        this.code = str;
    }

    public final void b(String str) {
        this.message = str;
    }

    public final void c(Integer num) {
        this.status = num;
    }

    public String toString() {
        return "ErrorResult(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public ErrorResult(String str, String str2, Integer num) {
        this.code = str;
        this.message = str2;
        this.status = num;
    }

    public /* synthetic */ ErrorResult(String str, String str2, Integer num, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num);
    }
}
