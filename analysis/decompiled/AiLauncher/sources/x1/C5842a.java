package x1;

import A1.k;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lx1/a;", "Lx1/b;", "Ljava/io/File;", "", "addLastModifiedToFileCacheKey", "<init>", "(Z)V", "data", "LA1/k;", "options", "", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;LA1/k;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5842a implements InterfaceC5843b<File> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean addLastModifiedToFileCacheKey;

    public C5842a(boolean z10) {
        this.addLastModifiedToFileCacheKey = z10;
    }

    @Override // x1.InterfaceC5843b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(File data, k options) {
        if (!this.addLastModifiedToFileCacheKey) {
            return data.getPath();
        }
        return data.getPath() + ':' + data.lastModified();
    }
}
