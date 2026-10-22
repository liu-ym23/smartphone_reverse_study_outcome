package zb;

import La.D;
import Mb.C0966d;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okio.ByteString;
import tb.C5530C;
import tb.C5542i;
import tb.C5545l;
import tb.InterfaceC5546m;
import tb.u;
import tb.v;
import ub.q;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010#\"\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#¨\u0006&"}, d2 = {"Ltb/u;", "", "headerName", "", "Ltb/i;", Const.INTENT_KEY_PKGNAME, "(Ltb/u;Ljava/lang/String;)Ljava/util/List;", "LMb/d;", "", "result", "LY8/t;", Const.INTENT_KEY_UMID, "(LMb/d;Ljava/util/List;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LMb/d;)Z", "", "prefix", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/d;B)Z", "e", "(LMb/d;)Ljava/lang/String;", "f", "Ltb/m;", "Ltb/v;", "url", "headers", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/m;Ltb/v;Ltb/u;)V", "Ltb/C;", "c", "(Ltb/C;)Z", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "Lokio/ByteString;", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: zb.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6481e {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f45435a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f45436b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f45435a = companion.d("\"\\");
        f45436b = companion.d("\t ,=");
    }

    public static final boolean a(C5530C response) {
        p.i(response, "response");
        return c(response);
    }

    public static final List<C5542i> b(u uVar, String headerName) {
        p.i(uVar, "<this>");
        p.i(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (D.L(headerName, uVar.f(i10), true)) {
                try {
                    d(new C0966d().L(uVar.k(i10)), arrayList);
                } catch (EOFException e10) {
                    okhttp3.internal.platform.c.INSTANCE.e().log("Unable to parse challenge", 5, e10);
                }
            }
        }
        return arrayList;
    }

    public static final boolean c(C5530C c5530c) {
        p.i(c5530c, "<this>");
        if (p.d(c5530c.getRequest().getMethod(), "HEAD")) {
            return false;
        }
        int code = c5530c.getCode();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && q.k(c5530c) == -1 && !D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r, C5530C.J(c5530c, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e, null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bc, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(Mb.C0966d r7, java.util.List<tb.C5542i> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Lf
            h(r7)
            java.lang.String r1 = f(r7)
            if (r1 != 0) goto Lf
            goto Lb9
        Lf:
            boolean r2 = h(r7)
            java.lang.String r3 = f(r7)
            if (r3 != 0) goto L2e
            boolean r7 = r7.k()
            if (r7 != 0) goto L21
            goto Lb9
        L21:
            tb.i r7 = new tb.i
            java.util.Map r0 = kotlin.collections.a.i()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2e:
            r4 = 61
            int r5 = ub.n.y(r7, r4)
            boolean r6 = h(r7)
            if (r2 != 0) goto L69
            if (r6 != 0) goto L42
            boolean r2 = r7.k()
            if (r2 == 0) goto L69
        L42:
            tb.i r2 = new tb.i
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = La.D.P(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap(...)"
            kotlin.jvm.internal.p.h(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L69:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = ub.n.y(r7, r4)
            int r5 = r5 + r6
        L73:
            if (r3 != 0) goto L83
            java.lang.String r3 = f(r7)
            boolean r5 = h(r7)
            if (r5 != 0) goto Lbc
            int r5 = ub.n.y(r7, r4)
        L83:
            if (r5 == 0) goto Lbc
            r6 = 1
            if (r5 <= r6) goto L89
            goto Lb9
        L89:
            boolean r6 = h(r7)
            if (r6 == 0) goto L90
            goto Lb9
        L90:
            r6 = 34
            boolean r6 = i(r7, r6)
            if (r6 == 0) goto L9d
            java.lang.String r6 = e(r7)
            goto La1
        L9d:
            java.lang.String r6 = f(r7)
        La1:
            if (r6 != 0) goto La4
            goto Lb9
        La4:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lad
            goto Lb9
        Lad:
            boolean r3 = h(r7)
            if (r3 != 0) goto Lba
            boolean r3 = r7.k()
            if (r3 != 0) goto Lba
        Lb9:
            return
        Lba:
            r3 = r0
            goto L73
        Lbc:
            tb.i r4 = new tb.i
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.C6481e.d(Mb.d, java.util.List):void");
    }

    public static final String e(C0966d c0966d) throws EOFException {
        if (c0966d.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        C0966d c0966d2 = new C0966d();
        while (true) {
            long jF = c0966d.F(f45435a);
            if (jF == -1) {
                return null;
            }
            if (c0966d.Y(jF) == 34) {
                c0966d2.K(c0966d, jF);
                c0966d.readByte();
                return c0966d2.Y0();
            }
            if (c0966d.getSize() == jF + 1) {
                return null;
            }
            c0966d2.K(c0966d, jF);
            c0966d.readByte();
            c0966d2.K(c0966d, 1L);
        }
    }

    public static final String f(C0966d c0966d) {
        long jF = c0966d.F(f45436b);
        if (jF == -1) {
            jF = c0966d.getSize();
        }
        if (jF != 0) {
            return c0966d.x0(jF);
        }
        return null;
    }

    public static final void g(InterfaceC5546m interfaceC5546m, v url, u headers) {
        p.i(interfaceC5546m, "<this>");
        p.i(url, "url");
        p.i(headers, "headers");
        if (interfaceC5546m == InterfaceC5546m.f42216b) {
            return;
        }
        List<C5545l> listE = C5545l.INSTANCE.e(url, headers);
        if (listE.isEmpty()) {
            return;
        }
        interfaceC5546m.b(url, listE);
    }

    public static final boolean h(C0966d c0966d) throws EOFException {
        boolean z10 = false;
        while (!c0966d.k()) {
            byte bY = c0966d.Y(0L);
            if (bY != 44) {
                if (bY != 32 && bY != 9) {
                    break;
                }
                c0966d.readByte();
            } else {
                c0966d.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    public static final boolean i(C0966d c0966d, byte b10) {
        return !c0966d.k() && c0966d.Y(0L) == b10;
    }
}
