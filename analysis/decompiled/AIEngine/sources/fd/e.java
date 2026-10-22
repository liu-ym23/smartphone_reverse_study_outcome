package fd;

import bd.l;
import okhttp3.Response;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    static {
        ByteString byteString = ByteString.f11312d;
        ByteString.a.b("\"\\");
        ByteString.a.b("\t ,=");
    }

    public static final boolean a(Response response) {
        if (kotlin.jvm.internal.g.b(response.f10888a.f10993b, "HEAD")) {
            return false;
        }
        int i10 = response.f10891d;
        return (((i10 >= 100 && i10 < 200) || i10 == 204 || i10 == 304) && l.e(response) == -1 && !"chunked".equalsIgnoreCase(Response.a("Transfer-Encoding", response))) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ad.g r37, okhttp3.g r38, okhttp3.f r39) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.e.b(ad.g, okhttp3.g, okhttp3.f):void");
    }
}
