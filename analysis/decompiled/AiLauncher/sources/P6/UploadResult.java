package P6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"LP6/m;", "", "", "sourcePath", "fileId", "", "fileSize", "downloadUrl", "", "success", "LP6/a;", "audit", "LP6/h;", "sensitive", "detectPassed", "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLP6/a;LP6/h;Ljava/lang/Boolean;Ljava/lang/Throwable;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSourcePath", Const.INTENT_KEY_UMID, "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", Const.INTENT_KEY_PKGNAME, "Z", "f", "()Z", "LP6/a;", Const.INTENT_KEY_APIKEY, "()LP6/a;", "LP6/h;", "getSensitive", "()LP6/h;", "Ljava/lang/Boolean;", "getDetectPassed", "()Ljava/lang/Boolean;", "Ljava/lang/Throwable;", "c", "()Ljava/lang/Throwable;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: P6.m, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class UploadResult {
    private final AuditResult audit;
    private final Boolean detectPassed;
    private final String downloadUrl;
    private final Throwable error;
    private final String fileId;
    private final Long fileSize;
    private final SensitiveResult sensitive;
    private final String sourcePath;
    private final boolean success;

    public UploadResult(String sourcePath, String str, Long l10, String str2, boolean z10, AuditResult auditResult, SensitiveResult sensitiveResult, Boolean bool, Throwable th) {
        p.i(sourcePath, "sourcePath");
        this.sourcePath = sourcePath;
        this.fileId = str;
        this.fileSize = l10;
        this.downloadUrl = str2;
        this.success = z10;
        this.audit = auditResult;
        this.sensitive = sensitiveResult;
        this.detectPassed = bool;
        this.error = th;
    }

    /* renamed from: a, reason: from getter */
    public final AuditResult getAudit() {
        return this.audit;
    }

    /* renamed from: b, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: c, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    /* renamed from: d, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: e, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadResult)) {
            return false;
        }
        UploadResult uploadResult = (UploadResult) other;
        return p.d(this.sourcePath, uploadResult.sourcePath) && p.d(this.fileId, uploadResult.fileId) && p.d(this.fileSize, uploadResult.fileSize) && p.d(this.downloadUrl, uploadResult.downloadUrl) && this.success == uploadResult.success && p.d(this.audit, uploadResult.audit) && p.d(this.sensitive, uploadResult.sensitive) && p.d(this.detectPassed, uploadResult.detectPassed) && p.d(this.error, uploadResult.error);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = this.sourcePath.hashCode() * 31;
        String str = this.fileId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.fileSize;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.downloadUrl;
        int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.success)) * 31;
        AuditResult auditResult = this.audit;
        int iHashCode5 = (iHashCode4 + (auditResult == null ? 0 : auditResult.hashCode())) * 31;
        SensitiveResult sensitiveResult = this.sensitive;
        int iHashCode6 = (iHashCode5 + (sensitiveResult == null ? 0 : sensitiveResult.hashCode())) * 31;
        Boolean bool = this.detectPassed;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Throwable th = this.error;
        return iHashCode7 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "UploadResult(sourcePath=" + this.sourcePath + ", fileId=" + this.fileId + ", fileSize=" + this.fileSize + ", downloadUrl=" + this.downloadUrl + ", success=" + this.success + ", audit=" + this.audit + ", sensitive=" + this.sensitive + ", detectPassed=" + this.detectPassed + ", error=" + this.error + ")";
    }
}
