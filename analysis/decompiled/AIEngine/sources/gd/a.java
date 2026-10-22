package gd;

import bd.b;
import com.stepos.core.ota.adapter.Fetch2ModelDownloadPort;
import gc.q;
import kotlin.jvm.internal.g;
import okhttp3.f;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final h f9144a;

    /* renamed from: b, reason: collision with root package name */
    public long f9145b;

    public a(h source) {
        g.f(source, "source");
        this.f9144a = source;
        this.f9145b = Fetch2ModelDownloadPort.ORPHAN_GROWTH_THRESHOLD_BYTES;
    }

    public final f a() {
        f.a aVar = new f.a();
        while (true) {
            String strX = this.f9144a.x(this.f9145b);
            this.f9145b -= strX.length();
            if (strX.length() == 0) {
                return aVar.b();
            }
            int iQ0 = q.q0(strX, ':', 1, 4);
            if (iQ0 != -1) {
                String strSubstring = strX.substring(0, iQ0);
                g.e(strSubstring, "substring(...)");
                String strSubstring2 = strX.substring(iQ0 + 1);
                g.e(strSubstring2, "substring(...)");
                b.a(aVar, strSubstring, strSubstring2);
            } else if (strX.charAt(0) == ':') {
                String strSubstring3 = strX.substring(1);
                g.e(strSubstring3, "substring(...)");
                b.a(aVar, "", strSubstring3);
            } else {
                b.a(aVar, "", strX);
            }
        }
    }
}
