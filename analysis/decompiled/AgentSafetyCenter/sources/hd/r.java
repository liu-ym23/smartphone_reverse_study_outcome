package hd;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import od.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f5552h;

    /* renamed from: c, reason: collision with root package name */
    public c0 f5553c;

    /* renamed from: f, reason: collision with root package name */
    public q f5554f;

    /* renamed from: g, reason: collision with root package name */
    public c f5555g;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        logger.getClass();
        f5552h = logger;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f5553c.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x0239, code lost:
    
        od.f.l(k0.a.j(r13, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0242, code lost:
    
        return r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(boolean r23, hd.k r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.r.d(boolean, hd.k):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x010f, code lost:
    
        if (r7 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0111, code lost:
    
        r9.i(bd.b.f2075b, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(hd.k r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.r.e(hd.k, int, int, int):void");
    }

    public final List g(int i, int i3, int i10, int i11) throws IOException {
        q qVar = this.f5554f;
        qVar.i = i;
        qVar.f5548f = i;
        qVar.f5551j = i3;
        qVar.f5549g = i10;
        qVar.f5550h = i11;
        c cVar = this.f5555g;
        c0 c0Var = cVar.f5478c;
        ArrayList arrayList = cVar.f5477b;
        while (!c0Var.d()) {
            byte bG = c0Var.g();
            byte[] bArr = bd.b.f2074a;
            int i12 = bG & 255;
            if (i12 == 128) {
                od.f.l("index == 0");
                return null;
            }
            if ((bG & 128) == 128) {
                int iE = cVar.e(i12, 127);
                int i13 = iE - 1;
                if (i13 >= 0) {
                    b[] bVarArr = e.f5491a;
                    if (i13 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i13]);
                    }
                }
                int length = cVar.f5480e + 1 + (i13 - e.f5491a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.f5479d;
                    if (length < bVarArr2.length) {
                        b bVar = bVarArr2[length];
                        bVar.getClass();
                        arrayList.add(bVar);
                    }
                }
                od.f.l(k0.a.j(iE, "Header index too large "));
                return null;
            }
            if (i12 == 64) {
                b[] bVarArr3 = e.f5491a;
                od.l lVarD = cVar.d();
                e.a(lVarD);
                cVar.c(new b(lVarD, cVar.d()));
            } else if ((bG & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i12, 63) - 1), cVar.d()));
            } else if ((bG & 32) == 32) {
                int iE2 = cVar.e(i12, 31);
                cVar.f5476a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    g5.f.e(cVar.f5476a, "Invalid dynamic table size update ");
                    return null;
                }
                int i14 = cVar.f5482g;
                if (iE2 < i14) {
                    if (iE2 == 0) {
                        b[] bVarArr4 = cVar.f5479d;
                        kb.k.m0(null, 0, bVarArr4, bVarArr4.length);
                        cVar.f5480e = cVar.f5479d.length - 1;
                        cVar.f5481f = 0;
                        cVar.f5482g = 0;
                    } else {
                        cVar.a(i14 - iE2);
                    }
                }
            } else if (i12 == 16 || i12 == 0) {
                b[] bVarArr5 = e.f5491a;
                od.l lVarD2 = cVar.d();
                e.a(lVarD2);
                arrayList.add(new b(lVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i12, 15) - 1), cVar.d()));
            }
        }
        List listL0 = kb.l.L0(arrayList);
        arrayList.clear();
        return listL0;
    }

    public final void i(k kVar, int i, int i3, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            od.f.l("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z10 = false;
        int i12 = 1;
        boolean z11 = (i3 & 1) != 0;
        if ((i3 & 8) != 0) {
            byte bG = this.f5553c.g();
            byte[] bArr = bd.b.f2074a;
            i11 = bG & 255;
        } else {
            i11 = 0;
        }
        if ((i3 & 32) != 0) {
            c0 c0Var = this.f5553c;
            c0Var.n();
            c0Var.g();
            byte[] bArr2 = bd.b.f2074a;
            i -= 5;
        }
        List listG = g(h.a(i, i3, i11), i11, i3, i10);
        o oVar = (o) kVar.f5506g;
        if (i10 != 0 && (i10 & 1) == 0) {
            z10 = true;
        }
        if (z10) {
            oVar.f5525m.c(new m(oVar.f5520g + '[' + i10 + "] onHeaders", oVar, i10, listG, z11), 0L);
            return;
        }
        synchronized (oVar) {
            v vVarE = oVar.e(i10);
            if (vVarE != null) {
                vVarE.i(bd.b.v(listG), z11);
                return;
            }
            if (oVar.f5522j) {
                return;
            }
            if (i10 <= oVar.f5521h) {
                return;
            }
            if (i10 % 2 == oVar.i % 2) {
                return;
            }
            v vVar = new v(i10, oVar, false, z11, bd.b.v(listG));
            oVar.f5521h = i10;
            oVar.f5519f.put(Integer.valueOf(i10), vVar);
            oVar.f5523k.e().c(new i(i12, oVar, vVar, oVar.f5520g + '[' + i10 + "] onStream"), 0L);
        }
    }

    public final void n(k kVar, int i, int i3, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            od.f.l("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        }
        if ((i3 & 8) != 0) {
            byte bG = this.f5553c.g();
            byte[] bArr = bd.b.f2074a;
            i11 = bG & 255;
        } else {
            i11 = 0;
        }
        int iN = this.f5553c.n() & Reader.READ_DONE;
        List listG = g(h.a(i - 4, i3, i11), i11, i3, i10);
        o oVar = (o) kVar.f5506g;
        synchronized (oVar) {
            if (oVar.C.contains(Integer.valueOf(iN))) {
                oVar.r(iN, 2);
                return;
            }
            oVar.C.add(Integer.valueOf(iN));
            oVar.f5525m.c(new m(oVar.f5520g + '[' + iN + "] onRequest", oVar, iN, listG), 0L);
        }
    }
}
