package i6;

import ad.n;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import kb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f5804a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f5805b;

    static {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = Bitmap.Config.RGBA_F16;
        f5804a = Bitmap.Config.HARDWARE;
        f5805b = new n((String[]) new ArrayList(20).toArray(new String[0]));
    }

    public static final void a(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final String b(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || hc.h.g0(str)) {
            return null;
        }
        int iH0 = hc.h.h0(str, '#', 0, 6);
        if (iH0 != -1) {
            str = str.substring(0, iH0);
        }
        int iH02 = hc.h.h0(str, '?', 0, 6);
        if (iH02 != -1) {
            str = str.substring(0, iH02);
        }
        return mimeTypeMap.getMimeTypeFromExtension(hc.h.r0(hc.h.r0(str, JsonPointer.SEPARATOR, str), '.', ""));
    }

    public static final boolean c(Uri uri) {
        return k.a(uri.getScheme(), "file") && k.a((String) l.x0(uri.getPathSegments()), "android_asset");
    }

    public static final int d(p5.f fVar, f6.f fVar2) {
        if (fVar instanceof f6.a) {
            return ((f6.a) fVar).f3916c;
        }
        int iOrdinal = fVar2.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Reader.READ_DONE;
        }
        g5.f.a();
        return 0;
    }
}
