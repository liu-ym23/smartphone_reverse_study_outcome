package Nb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"LNb/i;", "", "", "entryCount", "centralDirectoryOffset", "", "commentByteCount", "<init>", "(JJI)V", Const.INTENT_KEY_APIKEY, "J", "c", "()J", Const.INTENT_KEY_PKGNAME, "I", "()I", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long entryCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long centralDirectoryOffset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int commentByteCount;

    public i(long j10, long j11, int i10) {
        this.entryCount = j10;
        this.centralDirectoryOffset = j11;
        this.commentByteCount = i10;
    }

    /* renamed from: a, reason: from getter */
    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    /* renamed from: b, reason: from getter */
    public final int getCommentByteCount() {
        return this.commentByteCount;
    }

    /* renamed from: c, reason: from getter */
    public final long getEntryCount() {
        return this.entryCount;
    }
}
