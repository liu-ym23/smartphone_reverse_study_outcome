package kotlin;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"LK6/M;", "", "", "secretKey", "Ljava/io/File;", Const.STR_FILE, "Landroid/net/Uri;", "uri", "", "useFileId", "<init>", "(Ljava/lang/String;Ljava/io/File;Landroid/net/Uri;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "()Ljava/io/File;", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", "Z", Const.INTENT_KEY_UMID, "()Z", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.M, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class UploadFileRequest {
    private final File file;
    private final String secretKey;
    private final Uri uri;
    private final boolean useFileId;

    public UploadFileRequest(String secretKey, File file, Uri uri, boolean z10) {
        p.i(secretKey, "secretKey");
        this.secretKey = secretKey;
        this.file = file;
        this.uri = uri;
        this.useFileId = z10;
    }

    /* renamed from: a, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: b, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    /* renamed from: c, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getUseFileId() {
        return this.useFileId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFileRequest)) {
            return false;
        }
        UploadFileRequest uploadFileRequest = (UploadFileRequest) other;
        return p.d(this.secretKey, uploadFileRequest.secretKey) && p.d(this.file, uploadFileRequest.file) && p.d(this.uri, uploadFileRequest.uri) && this.useFileId == uploadFileRequest.useFileId;
    }

    public int hashCode() {
        int iHashCode = this.secretKey.hashCode() * 31;
        File file = this.file;
        int iHashCode2 = (iHashCode + (file == null ? 0 : file.hashCode())) * 31;
        Uri uri = this.uri;
        return ((iHashCode2 + (uri != null ? uri.hashCode() : 0)) * 31) + Boolean.hashCode(this.useFileId);
    }

    public String toString() {
        return "UploadFileRequest(secretKey=" + this.secretKey + ", file=" + this.file + ", uri=" + this.uri + ", useFileId=" + this.useFileId + ")";
    }
}
