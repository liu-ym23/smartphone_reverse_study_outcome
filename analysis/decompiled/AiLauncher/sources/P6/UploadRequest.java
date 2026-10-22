package P6;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001c\u0010\u0010R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"LP6/l;", "", "", "uriOrPath", "fileName", "contentType", "bizCode", "sourceType", "", "expiresSeconds", "", "LP6/k;", "bindings", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "c", Const.INTENT_KEY_PKGNAME, "f", "Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "()Ljava/lang/Integer;", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: P6.l, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class UploadRequest {
    private final List<UploadBinding> bindings;
    private final String bizCode;
    private final String contentType;
    private final Integer expiresSeconds;
    private final String fileName;
    private final String sourceType;
    private final String uriOrPath;

    public UploadRequest(String uriOrPath, String str, String str2, String str3, String str4, Integer num, List<UploadBinding> list) {
        p.i(uriOrPath, "uriOrPath");
        this.uriOrPath = uriOrPath;
        this.fileName = str;
        this.contentType = str2;
        this.bizCode = str3;
        this.sourceType = str4;
        this.expiresSeconds = num;
        this.bindings = list;
    }

    public final List<UploadBinding> a() {
        return this.bindings;
    }

    /* renamed from: b, reason: from getter */
    public final String getBizCode() {
        return this.bizCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: d, reason: from getter */
    public final Integer getExpiresSeconds() {
        return this.expiresSeconds;
    }

    /* renamed from: e, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadRequest)) {
            return false;
        }
        UploadRequest uploadRequest = (UploadRequest) other;
        return p.d(this.uriOrPath, uploadRequest.uriOrPath) && p.d(this.fileName, uploadRequest.fileName) && p.d(this.contentType, uploadRequest.contentType) && p.d(this.bizCode, uploadRequest.bizCode) && p.d(this.sourceType, uploadRequest.sourceType) && p.d(this.expiresSeconds, uploadRequest.expiresSeconds) && p.d(this.bindings, uploadRequest.bindings);
    }

    /* renamed from: f, reason: from getter */
    public final String getSourceType() {
        return this.sourceType;
    }

    /* renamed from: g, reason: from getter */
    public final String getUriOrPath() {
        return this.uriOrPath;
    }

    public int hashCode() {
        int iHashCode = this.uriOrPath.hashCode() * 31;
        String str = this.fileName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contentType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bizCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourceType;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.expiresSeconds;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        List<UploadBinding> list = this.bindings;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "UploadRequest(uriOrPath=" + this.uriOrPath + ", fileName=" + this.fileName + ", contentType=" + this.contentType + ", bizCode=" + this.bizCode + ", sourceType=" + this.sourceType + ", expiresSeconds=" + this.expiresSeconds + ", bindings=" + this.bindings + ")";
    }

    public /* synthetic */ UploadRequest(String str, String str2, String str3, String str4, String str5, Integer num, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? null : list);
    }
}
