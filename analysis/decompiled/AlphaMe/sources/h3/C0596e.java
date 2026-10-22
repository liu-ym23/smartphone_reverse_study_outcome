package h3;

import f1.AbstractC0557a;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.C0694i;
import k3.InterfaceC0680B;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;

/* renamed from: h3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0596e {

    /* renamed from: k, reason: collision with root package name */
    public static final String f12890k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f12891l;

    /* renamed from: a, reason: collision with root package name */
    public final J f12892a;

    /* renamed from: b, reason: collision with root package name */
    public final H f12893b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12894c;

    /* renamed from: d, reason: collision with root package name */
    public final T f12895d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12896e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12897f;

    /* renamed from: g, reason: collision with root package name */
    public final H f12898g;

    /* renamed from: h, reason: collision with root package name */
    public final F f12899h;

    /* renamed from: i, reason: collision with root package name */
    public final long f12900i;

    /* renamed from: j, reason: collision with root package name */
    public final long f12901j;

    static {
        Platform.Companion companion = Platform.INSTANCE;
        f12890k = Intrinsics.stringPlus(companion.get().getPrefix(), "-Sent-Millis");
        f12891l = Intrinsics.stringPlus(companion.get().getPrefix(), "-Received-Millis");
    }

    public C0596e(b0 response) {
        H hD;
        Intrinsics.checkNotNullParameter(response, "response");
        V v4 = response.f12864a;
        this.f12892a = v4.f12826a;
        Intrinsics.checkNotNullParameter(response, "<this>");
        b0 b0Var = response.f12871h;
        Intrinsics.checkNotNull(b0Var);
        H h4 = b0Var.f12864a.f12828c;
        H h5 = response.f12869f;
        Set setJ = y0.e.j(h5);
        if (setJ.isEmpty()) {
            hD = Util.EMPTY_HEADERS;
        } else {
            G g4 = new G();
            int size = h4.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                String strC = h4.c(i4);
                if (setJ.contains(strC)) {
                    g4.a(strC, h4.f(i4));
                }
                i4 = i5;
            }
            hD = g4.d();
        }
        this.f12893b = hD;
        this.f12894c = v4.f12827b;
        this.f12895d = response.f12865b;
        this.f12896e = response.f12867d;
        this.f12897f = response.f12866c;
        this.f12898g = h5;
        this.f12899h = response.f12868e;
        this.f12900i = response.f12874k;
        this.f12901j = response.f12875l;
    }

    public static List a(k3.v vVar) throws IOException, CertificateException {
        int iG = y0.e.g(vVar);
        if (iG == -1) {
            return CollectionsKt.emptyList();
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList(iG);
            int i4 = 0;
            while (i4 < iG) {
                i4++;
                String strY = vVar.y(LongCompanionObject.MAX_VALUE);
                C0694i c0694i = new C0694i();
                k3.l lVar = k3.l.f13358d;
                k3.l lVarH = C0611u.h(strY);
                Intrinsics.checkNotNull(lVarH);
                c0694i.T(lVarH);
                arrayList.add(certificateFactory.generateCertificate(c0694i.M()));
            }
            return arrayList;
        } catch (CertificateException e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public static void b(k3.u uVar, List list) throws IOException, CertificateEncodingException {
        try {
            uVar.H(list.size());
            uVar.t(10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                byte[] bytes = ((Certificate) it.next()).getEncoded();
                k3.l lVar = k3.l.f13358d;
                Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                uVar.G(C0611u.s(bytes).a());
                uVar.t(10);
            }
        } catch (CertificateEncodingException e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public final void c(DiskLruCache.Editor editor) {
        J j4 = this.f12892a;
        F f4 = this.f12899h;
        H h4 = this.f12898g;
        H h5 = this.f12893b;
        Intrinsics.checkNotNullParameter(editor, "editor");
        k3.u uVarG = AbstractC0557a.g(editor.newSink(0));
        try {
            uVarG.G(j4.f12730i);
            uVarG.t(10);
            uVarG.G(this.f12894c);
            uVarG.t(10);
            uVarG.H(h5.size());
            uVarG.t(10);
            int size = h5.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                uVarG.G(h5.c(i4));
                uVarG.G(": ");
                uVarG.G(h5.f(i4));
                uVarG.t(10);
                i4 = i5;
            }
            uVarG.G(new StatusLine(this.f12895d, this.f12896e, this.f12897f).toString());
            uVarG.t(10);
            uVarG.H(h4.size() + 2);
            uVarG.t(10);
            int size2 = h4.size();
            for (int i6 = 0; i6 < size2; i6++) {
                uVarG.G(h4.c(i6));
                uVarG.G(": ");
                uVarG.G(h4.f(i6));
                uVarG.t(10);
            }
            uVarG.G(f12890k);
            uVarG.G(": ");
            uVarG.H(this.f12900i);
            uVarG.t(10);
            uVarG.G(f12891l);
            uVarG.G(": ");
            uVarG.H(this.f12901j);
            uVarG.t(10);
            if (Intrinsics.areEqual(j4.f12722a, "https")) {
                uVarG.t(10);
                Intrinsics.checkNotNull(f4);
                uVarG.G(f4.f12708b.f12961a);
                uVarG.t(10);
                b(uVarG, f4.a());
                b(uVarG, f4.f12709c);
                uVarG.G(f4.f12707a.f12919a);
                uVarG.t(10);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(uVarG, null);
        } finally {
        }
    }

    public C0596e(InterfaceC0680B rawSource) {
        J jN;
        h0 tlsVersion;
        Intrinsics.checkNotNullParameter(rawSource, "rawSource");
        try {
            k3.v vVarH = AbstractC0557a.h(rawSource);
            String strY = vVarH.y(LongCompanionObject.MAX_VALUE);
            char[] cArr = J.f12721k;
            Intrinsics.checkNotNullParameter(strY, "<this>");
            try {
                jN = C0611u.n(strY);
            } catch (IllegalArgumentException unused) {
                jN = null;
            }
            if (jN != null) {
                this.f12892a = jN;
                this.f12894c = vVarH.y(LongCompanionObject.MAX_VALUE);
                G g4 = new G();
                int iG = y0.e.g(vVarH);
                int i4 = 0;
                while (i4 < iG) {
                    i4++;
                    g4.b(vVarH.y(LongCompanionObject.MAX_VALUE));
                }
                this.f12893b = g4.d();
                StatusLine statusLine = StatusLine.INSTANCE.parse(vVarH.y(LongCompanionObject.MAX_VALUE));
                this.f12895d = statusLine.protocol;
                this.f12896e = statusLine.code;
                this.f12897f = statusLine.message;
                G g5 = new G();
                int iG2 = y0.e.g(vVarH);
                int i5 = 0;
                while (i5 < iG2) {
                    i5++;
                    g5.b(vVarH.y(LongCompanionObject.MAX_VALUE));
                }
                String str = f12890k;
                String strE = g5.e(str);
                String str2 = f12891l;
                String strE2 = g5.e(str2);
                g5.f(str);
                g5.f(str2);
                long j4 = 0;
                this.f12900i = strE == null ? 0L : Long.parseLong(strE);
                if (strE2 != null) {
                    j4 = Long.parseLong(strE2);
                }
                this.f12901j = j4;
                this.f12898g = g5.d();
                if (Intrinsics.areEqual(this.f12892a.f12722a, "https")) {
                    String strY2 = vVarH.y(LongCompanionObject.MAX_VALUE);
                    if (strY2.length() <= 0) {
                        C0607p cipherSuite = C0607p.f12942b.b(vVarH.y(LongCompanionObject.MAX_VALUE));
                        List peerCertificates = a(vVarH);
                        List localCertificates = a(vVarH);
                        if (!vVarH.s()) {
                            tlsVersion = C0611u.l(vVarH.y(LongCompanionObject.MAX_VALUE));
                        } else {
                            tlsVersion = h0.SSL_3_0;
                        }
                        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
                        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
                        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
                        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
                        this.f12899h = new F(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new E(0, Util.toImmutableList(peerCertificates)));
                    } else {
                        throw new IOException("expected \"\" but was \"" + strY2 + '\"');
                    }
                } else {
                    this.f12899h = null;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(rawSource, null);
                return;
            }
            IOException iOException = new IOException(Intrinsics.stringPlus("Cache corruption for ", strY));
            Platform.INSTANCE.get().log("cache corruption", 5, iOException);
            throw iOException;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(rawSource, th);
                throw th2;
            }
        }
    }
}
