package y1;

import A1.k;
import F1.j;
import La.H;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ly1/b;", "Ly1/d;", "Landroid/net/Uri;", "Ljava/io/File;", "<init>", "()V", "data", "LA1/k;", "options", "c", "(Landroid/net/Uri;LA1/k;)Ljava/io/File;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/net/Uri;)Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: y1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5917b implements d<Uri, File> {
    public final boolean b(Uri data) {
        String scheme;
        if (!j.q(data) && ((scheme = data.getScheme()) == null || p.d(scheme, Const.STR_FILE))) {
            String path = data.getPath();
            if (path == null) {
                path = "";
            }
            if (H.i1(path, JsonPointer.SEPARATOR, false, 2, null) && j.h(data) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // y1.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public File a(Uri data, k options) {
        if (!b(data)) {
            return null;
        }
        if (!p.d(data.getScheme(), Const.STR_FILE)) {
            return new File(data.toString());
        }
        String path = data.getPath();
        if (path != null) {
            return new File(path);
        }
        return null;
    }
}
