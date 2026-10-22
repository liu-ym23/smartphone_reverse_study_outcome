package n4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ln4/a;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "Ln4/a$a;", "Ln4/a$b;", "Ln4/a$c;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: n4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4939a {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ln4/a$a;", "Ln4/a;", "", "code", "", "message", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Ljava/lang/Throwable;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Throwable;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: n4.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Failed extends AbstractC4939a {
        private final Throwable cause;
        private final int code;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(int i10, String message, Throwable th) {
            super(null);
            p.i(message, "message");
            this.code = i10;
            this.message = message;
            this.cause = th;
        }

        /* renamed from: a, reason: from getter */
        public final Throwable getCause() {
            return this.cause;
        }

        /* renamed from: b, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: c, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) other;
            return this.code == failed.code && p.d(this.message, failed.message) && p.d(this.cause, failed.cause);
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Failed(code=" + this.code + ", message=" + this.message + ", cause=" + this.cause + ")";
        }

        public /* synthetic */ Failed(int i10, String str, Throwable th, int i11, i iVar) {
            this(i10, str, (i11 & 4) != 0 ? null : th);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ln4/a$b;", "Ln4/a;", "", "percent", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: n4.a$b, reason: from toString */
    public static final /* data */ class Progress extends AbstractC4939a {
        private final int percent;

        public Progress(int i10) {
            super(null);
            this.percent = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Progress) && this.percent == ((Progress) other).percent;
        }

        public int hashCode() {
            return Integer.hashCode(this.percent);
        }

        public String toString() {
            return "Progress(percent=" + this.percent + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ln4/a$c;", "Ln4/a;", "", "fileId", "fileUrl", "", "fileSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "Ljava/lang/Long;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Long;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: n4.a$c, reason: from toString */
    public static final /* data */ class Success extends AbstractC4939a {
        private final String fileId;
        private final Long fileSize;
        private final String fileUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String fileId, String str, Long l10) {
            super(null);
            p.i(fileId, "fileId");
            this.fileId = fileId;
            this.fileUrl = str;
            this.fileSize = l10;
        }

        /* renamed from: a, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: b, reason: from getter */
        public final Long getFileSize() {
            return this.fileSize;
        }

        /* renamed from: c, reason: from getter */
        public final String getFileUrl() {
            return this.fileUrl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return p.d(this.fileId, success.fileId) && p.d(this.fileUrl, success.fileUrl) && p.d(this.fileSize, success.fileSize);
        }

        public int hashCode() {
            int iHashCode = this.fileId.hashCode() * 31;
            String str = this.fileUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l10 = this.fileSize;
            return iHashCode2 + (l10 != null ? l10.hashCode() : 0);
        }

        public String toString() {
            return "Success(fileId=" + this.fileId + ", fileUrl=" + this.fileUrl + ", fileSize=" + this.fileSize + ")";
        }
    }

    public /* synthetic */ AbstractC4939a(i iVar) {
        this();
    }

    public AbstractC4939a() {
    }
}
