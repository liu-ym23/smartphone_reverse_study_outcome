package I4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001d"}, d2 = {"LI4/a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "toolCallId", "Ljava/lang/String;", "getToolCallId", "success", "Z", "c", "()Z", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "getContent", "resultRspContent", Const.INTENT_KEY_PKGNAME, "code", "getCode", "message", Const.INTENT_KEY_APIKEY, "extra", "getExtra", "mcp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: I4.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ResultBean {
    private final String code;
    private final String content;
    private final String extra;
    private final String message;
    private final String resultRspContent;
    private final boolean success;
    private final String toolCallId;

    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: b, reason: from getter */
    public final String getResultRspContent() {
        return this.resultRspContent;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultBean)) {
            return false;
        }
        ResultBean resultBean = (ResultBean) other;
        return p.d(this.toolCallId, resultBean.toolCallId) && this.success == resultBean.success && p.d(this.content, resultBean.content) && p.d(this.resultRspContent, resultBean.resultRspContent) && p.d(this.code, resultBean.code) && p.d(this.message, resultBean.message) && p.d(this.extra, resultBean.extra);
    }

    public int hashCode() {
        int iHashCode = ((this.toolCallId.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resultRspContent;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extra;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ResultBean(toolCallId=" + this.toolCallId + ", success=" + this.success + ", content=" + this.content + ", resultRspContent=" + this.resultRspContent + ", code=" + this.code + ", message=" + this.message + ", extra=" + this.extra + ")";
    }
}
