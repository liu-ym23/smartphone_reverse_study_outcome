package y5;

import ad.n;
import ad.s;
import ad.y;
import ad.z;
import android.webkit.MimeTypeMap;
import hc.o;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Map;
import od.c0;
import od.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements g {

    /* renamed from: e, reason: collision with root package name */
    public static final ad.c f15919e = new ad.c(true, true, -1, -1, false, false, false, -1, -1, false, false, false, null);

    /* renamed from: f, reason: collision with root package name */
    public static final ad.c f15920f = new ad.c(true, false, -1, -1, false, false, false, -1, -1, true, false, false, null);

    /* renamed from: a, reason: collision with root package name */
    public String f15921a;

    /* renamed from: b, reason: collision with root package name */
    public e6.m f15922b;

    /* renamed from: c, reason: collision with root package name */
    public jb.k f15923c;

    /* renamed from: d, reason: collision with root package name */
    public jb.k f15924d;

    public static String d(String str, s sVar) {
        String strB;
        String str2 = sVar != null ? sVar.f570a : null;
        if ((str2 == null || o.U(str2, "text/plain", false)) && (strB = i6.d.b(MimeTypeMap.getSingleton(), str)) != null) {
            return strB;
        }
        if (str2 != null) {
            return hc.h.s0(str2, ';');
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01fb A[Catch: Exception -> 0x01f6, TryCatch #4 {Exception -> 0x01f6, blocks: (B:93:0x01bd, B:95:0x01c3, B:97:0x01ed, B:99:0x01f2, B:98:0x01f0, B:103:0x01fb, B:104:0x0200), top: B:118:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[Catch: Exception -> 0x0056, TRY_ENTER, TryCatch #3 {Exception -> 0x0056, blocks: (B:105:0x0201, B:106:0x0204, B:20:0x004d, B:56:0x0127, B:107:0x0205, B:108:0x020a, B:36:0x0092, B:38:0x009c, B:45:0x00cc, B:48:0x00e5, B:53:0x0112, B:41:0x00b2, B:43:0x00bc, B:50:0x00fd, B:51:0x0104, B:52:0x0105), top: B:117:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105 A[Catch: Exception -> 0x0056, TryCatch #3 {Exception -> 0x0056, blocks: (B:105:0x0201, B:106:0x0204, B:20:0x004d, B:56:0x0127, B:107:0x0205, B:108:0x020a, B:36:0x0092, B:38:0x009c, B:45:0x00cc, B:48:0x00e5, B:53:0x0112, B:41:0x00b2, B:43:0x00bc, B:50:0x00fd, B:51:0x0104, B:52:0x0105), top: B:117:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c3 A[Catch: Exception -> 0x01f6, TryCatch #4 {Exception -> 0x01f6, blocks: (B:93:0x01bd, B:95:0x01c3, B:97:0x01ed, B:99:0x01f2, B:98:0x01f0, B:103:0x01fb, B:104:0x0200), top: B:118:0x01bd }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [e6.m, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.lang.Object, jb.d] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, jb.d] */
    @Override // y5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(nb.c r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.l.a(nb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ad.z r6, pb.c r7) throws java.io.IOException {
        /*
            r5 = this;
            jb.k r0 = r5.f15923c
            boolean r1 = r7 instanceof y5.j
            if (r1 == 0) goto L15
            r1 = r7
            y5.j r1 = (y5.j) r1
            int r2 = r1.f15913g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f15913g = r2
            goto L1a
        L15:
            y5.j r1 = new y5.j
            r1.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r1.f15911c
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f15913g
            r4 = 1
            if (r3 == 0) goto L30
            if (r3 != r4) goto L29
            id.c.I(r7)
            goto L9f
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L30:
            id.c.I(r7)
            android.graphics.Bitmap$Config r7 = i6.d.f5804a
            android.os.Looper r7 = android.os.Looper.myLooper()
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            boolean r7 = yb.k.a(r7, r3)
            if (r7 == 0) goto L67
            e6.m r5 = r5.f15922b
            e6.b r5 = r5.f3586o
            boolean r5 = r5.f3510c
            if (r5 != 0) goto L61
            java.lang.Object r5 = r0.getValue()
            ad.w r5 = (ad.w) r5
            r5.getClass()
            r6.getClass()
            ed.j r7 = new ed.j
            r7.<init>(r5, r6)
            ad.e0 r5 = r7.e()
            goto La2
        L61:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L67:
            java.lang.Object r5 = r0.getValue()
            ad.w r5 = (ad.w) r5
            r5.getClass()
            r6.getClass()
            ed.j r7 = new ed.j
            r7.<init>(r5, r6)
            r1.f15913g = r4
            kc.g r5 = new kc.g
            nb.c r6 = td.h.y(r1)
            r5.<init>(r4, r6)
            r5.s()
            e9.w r6 = new e9.w
            r6.<init>(r4)
            r6.f3732f = r7
            r6.f3733g = r5
            java.lang.invoke.VarHandle.storeStoreFence()
            r7.d(r6)
            r5.u(r6)
            java.lang.Object r7 = r5.r()
            if (r7 != r2) goto L9f
            return r2
        L9f:
            r5 = r7
            ad.e0 r5 = (ad.e0) r5
        La2:
            boolean r6 = r5.e()
            int r7 = r5.f471h
            if (r6 != 0) goto Lcc
            r6 = 304(0x130, float:4.26E-43)
            if (r7 == r6) goto Lcc
            ad.h0 r6 = r5.f473k
            if (r6 == 0) goto Lb5
            i6.d.a(r6)
        Lb5:
            androidx.fragment.app.d r6 = new androidx.fragment.app.d
            java.lang.String r0 = "HTTP "
            java.lang.String r1 = ": "
            java.lang.StringBuilder r7 = k0.a.t(r7, r0, r1)
            java.lang.String r5 = r5.f470g
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        Lcc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.l.b(ad.z, pb.c):java.lang.Object");
    }

    public final od.o c() {
        Object value = this.f15924d.getValue();
        value.getClass();
        return ((w5.h) value).f15265a;
    }

    public final z e() {
        y yVar = new y();
        yVar.o(this.f15921a);
        e6.m mVar = this.f15922b;
        n nVar = mVar.f3581j;
        nVar.getClass();
        yVar.f633c = nVar.c();
        for (Map.Entry entry : mVar.f3582k.f3600a.entrySet()) {
            Object key = entry.getKey();
            key.getClass();
            yVar.n((Class) key, entry.getValue());
        }
        e6.b bVar = mVar.f3585n;
        boolean z10 = bVar.f3510c;
        boolean z11 = mVar.f3586o.f3510c;
        if (!z11 && z10) {
            yVar.g(ad.c.f440o);
        } else if (!z11 || z10) {
            if (!z11 && !z10) {
                yVar.g(f15920f);
            }
        } else if (bVar.f3511f) {
            yVar.g(ad.c.f439n);
        } else {
            yVar.g(f15919e);
        }
        return yVar.e();
    }

    public final d6.b f(w5.g gVar) throws Throwable {
        Throwable th;
        d6.b bVar;
        try {
            od.o oVarC = c();
            w5.c cVar = gVar.f15264c;
            if (cVar.f15243f) {
                throw new IllegalStateException("snapshot is closed");
            }
            i0 i0VarL = oVarC.l((od.z) cVar.f15242c.f15236c.get(0));
            i0VarL.getClass();
            c0 c0Var = new c0(i0VarL);
            try {
                bVar = new d6.b(c0Var);
                try {
                    c0Var.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    c0Var.close();
                } catch (Throwable th4) {
                    com.stepos.statsrpk.h.b(th3, th4);
                }
                th = th3;
                bVar = null;
            }
            if (th == null) {
                return bVar;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public final v5.o g(w5.g gVar) {
        w5.c cVar = gVar.f15264c;
        if (cVar.f15243f) {
            od.f.e("snapshot is closed");
            return null;
        }
        od.z zVar = (od.z) cVar.f15242c.f15236c.get(1);
        od.o oVarC = c();
        String str = this.f15922b.i;
        if (str == null) {
            str = this.f15921a;
        }
        v5.o oVar = new v5.o();
        oVar.f14799c = zVar;
        oVar.f14800f = oVarC;
        oVar.f14801g = str;
        oVar.f14802h = gVar;
        VarHandle.storeStoreFence();
        return oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w5.g h(w5.g r4, ad.z r5, ad.e0 r6, d6.b r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.l.h(w5.g, ad.z, ad.e0, d6.b):w5.g");
    }
}
