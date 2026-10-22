package Mb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010Jw\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u001fR'\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"LMb/h;", "", "", "isRegularFile", "isDirectory", "LMb/z;", "symlinkTarget", "", ContentDisposition.Parameters.Size, "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "", "Lw9/d;", "extras", "<init>", "(ZZLMb/z;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", Const.INTENT_KEY_APIKEY, "(ZZLMb/z;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)LMb/h;", "", "toString", "()Ljava/lang/String;", "Z", "()Z", Const.INTENT_KEY_PKGNAME, "e", "c", "LMb/z;", Const.INTENT_KEY_UMID, "()LMb/z;", "Ljava/lang/Long;", "()Ljava/lang/Long;", "getCreatedAtMillis", "f", "getLastModifiedAtMillis", Const.INTENT_KEY_BACKGROUND_COMMAND, "getLastAccessedAtMillis", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0970h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isRegularFile;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isDirectory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final z symlinkTarget;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Long size;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Long createdAtMillis;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Long lastModifiedAtMillis;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Long lastAccessedAtMillis;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<?>, Object> extras;

    public C0970h(boolean z10, boolean z11, z zVar, Long l10, Long l11, Long l12, Long l13, Map<InterfaceC5745d<?>, ? extends Object> extras) {
        kotlin.jvm.internal.p.i(extras, "extras");
        this.isRegularFile = z10;
        this.isDirectory = z11;
        this.symlinkTarget = zVar;
        this.size = l10;
        this.createdAtMillis = l11;
        this.lastModifiedAtMillis = l12;
        this.lastAccessedAtMillis = l13;
        this.extras = kotlin.collections.a.A(extras);
    }

    public static /* synthetic */ C0970h b(C0970h c0970h, boolean z10, boolean z11, z zVar, Long l10, Long l11, Long l12, Long l13, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = c0970h.isRegularFile;
        }
        if ((i10 & 2) != 0) {
            z11 = c0970h.isDirectory;
        }
        if ((i10 & 4) != 0) {
            zVar = c0970h.symlinkTarget;
        }
        if ((i10 & 8) != 0) {
            l10 = c0970h.size;
        }
        if ((i10 & 16) != 0) {
            l11 = c0970h.createdAtMillis;
        }
        if ((i10 & 32) != 0) {
            l12 = c0970h.lastModifiedAtMillis;
        }
        if ((i10 & 64) != 0) {
            l13 = c0970h.lastAccessedAtMillis;
        }
        if ((i10 & 128) != 0) {
            map = c0970h.extras;
        }
        Long l14 = l13;
        Map map2 = map;
        Long l15 = l11;
        Long l16 = l12;
        return c0970h.a(z10, z11, zVar, l10, l15, l16, l14, map2);
    }

    public final C0970h a(boolean isRegularFile, boolean isDirectory, z symlinkTarget, Long size, Long createdAtMillis, Long lastModifiedAtMillis, Long lastAccessedAtMillis, Map<InterfaceC5745d<?>, ? extends Object> extras) {
        kotlin.jvm.internal.p.i(extras, "extras");
        return new C0970h(isRegularFile, isDirectory, symlinkTarget, size, createdAtMillis, lastModifiedAtMillis, lastAccessedAtMillis, extras);
    }

    /* renamed from: c, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: d, reason: from getter */
    public final z getSymlinkTarget() {
        return this.symlinkTarget;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size.longValue());
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis.longValue());
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis.longValue());
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis.longValue());
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return Z8.F.A0(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ C0970h(boolean z10, boolean z11, z zVar, Long l10, Long l11, Long l12, Long l13, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? null : zVar, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : l11, (i10 & 32) != 0 ? null : l12, (i10 & 64) != 0 ? null : l13, (i10 & 128) != 0 ? kotlin.collections.a.i() : map);
    }
}
