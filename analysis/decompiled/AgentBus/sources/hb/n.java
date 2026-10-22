package hb;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class n extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4308e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f4309f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4310g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, Object obj, long j2, int i2) {
        super(str, true);
        this.f4308e = i2;
        this.f4310g = obj;
        this.f4309f = j2;
    }

    @Override // db.a
    public final long a() throws IOException {
        p pVar;
        boolean z4;
        nb.l lVar;
        switch (this.f4308e) {
            case 0:
                synchronized (((p) this.f4310g)) {
                    pVar = (p) this.f4310g;
                    long j2 = pVar.f4326r;
                    long j4 = pVar.f4325q;
                    if (j2 < j4) {
                        z4 = true;
                    } else {
                        pVar.f4325q = j4 + 1;
                        z4 = false;
                    }
                }
                if (z4) {
                    pVar.a(2, 2, null);
                    return -1L;
                }
                try {
                    pVar.C.i(1, 0, false);
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                }
                return this.f4309f;
            default:
                nb.g gVar = (nb.g) this.f4310g;
                synchronized (gVar) {
                    try {
                        if (!gVar.f6969t && (lVar = gVar.f6959j) != null) {
                            int i2 = gVar.f6971v ? gVar.f6970u : -1;
                            gVar.f6970u++;
                            gVar.f6971v = true;
                            if (i2 != -1) {
                                gVar.c(new SocketTimeoutException("sent ping but didn't receive pong within " + gVar.f6952c + "ms (after " + (i2 - 1) + " successful ping/pongs)"), null);
                            } else {
                                try {
                                    ob.k kVar = ob.k.f7997i;
                                    q7.k.e(kVar, "payload");
                                    lVar.a(9, kVar);
                                } catch (IOException e11) {
                                    gVar.c(e11, null);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return this.f4309f;
        }
    }
}
