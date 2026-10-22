package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"LK6/h;", "", "", "type", "blob", "mime", "", ContentDisposition.Parameters.Size, "fileName", "fileStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "I", "e", Const.INTENT_KEY_PKGNAME, "c", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.h, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ChatAttachment {
    private final String blob;
    private final String fileName;
    private final String fileStatus;
    private final String mime;
    private final int size;
    private final String type;

    public ChatAttachment(String type, String blob, String str, int i10, String str2, String fileStatus) {
        p.i(type, "type");
        p.i(blob, "blob");
        p.i(fileStatus, "fileStatus");
        this.type = type;
        this.blob = blob;
        this.mime = str;
        this.size = i10;
        this.fileName = str2;
        this.fileStatus = fileStatus;
    }

    /* renamed from: a, reason: from getter */
    public final String getBlob() {
        return this.blob;
    }

    /* renamed from: b, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileStatus() {
        return this.fileStatus;
    }

    /* renamed from: d, reason: from getter */
    public final String getMime() {
        return this.mime;
    }

    /* renamed from: e, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatAttachment)) {
            return false;
        }
        ChatAttachment chatAttachment = (ChatAttachment) other;
        return p.d(this.type, chatAttachment.type) && p.d(this.blob, chatAttachment.blob) && p.d(this.mime, chatAttachment.mime) && this.size == chatAttachment.size && p.d(this.fileName, chatAttachment.fileName) && p.d(this.fileStatus, chatAttachment.fileStatus);
    }

    /* renamed from: f, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.blob.hashCode()) * 31;
        String str = this.mime;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.size)) * 31;
        String str2 = this.fileName;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.fileStatus.hashCode();
    }

    public String toString() {
        return "ChatAttachment(type=" + this.type + ", blob=" + this.blob + ", mime=" + this.mime + ", size=" + this.size + ", fileName=" + this.fileName + ", fileStatus=" + this.fileStatus + ")";
    }
}
