package hb;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ob.e0;

/* loaded from: classes.dex */
public final class t implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    public static final Logger f4349i;

    /* renamed from: f, reason: collision with root package name */
    public final ob.j f4350f;

    /* renamed from: g, reason: collision with root package name */
    public final s f4351g;

    /* renamed from: h, reason: collision with root package name */
    public final c f4352h;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        q7.k.d(logger, "getLogger(Http2::class.java.name)");
        f4349i = logger;
    }

    public t(e0 e0Var) {
        q7.k.e(e0Var, "source");
        this.f4350f = e0Var;
        s sVar = new s(e0Var);
        this.f4351g = sVar;
        this.f4352h = new c(sVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0250, code lost:
    
        throw new java.io.IOException(n.f.c(r10, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r23, hb.k r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.t.a(boolean, hb.k):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0115, code lost:
    
        if (r16 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0117, code lost:
    
        r9.i(bb.b.f1660b, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(hb.k r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.t.b(hb.k, int, int, int):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4350f.close();
    }

    public final List d(int i2, int i10, int i11, int i12) throws IOException {
        s sVar = this.f4351g;
        sVar.f4347j = i2;
        sVar.f4344g = i2;
        sVar.f4348k = i10;
        sVar.f4345h = i11;
        sVar.f4346i = i12;
        c cVar = this.f4352h;
        e0 e0Var = cVar.f4269c;
        ArrayList arrayList = cVar.f4268b;
        while (!e0Var.a()) {
            byte b10 = e0Var.readByte();
            byte[] bArr = bb.b.f1659a;
            int i13 = b10 & 255;
            if (i13 == 128) {
                throw new IOException("index == 0");
            }
            if ((b10 & 128) == 128) {
                int iE = cVar.e(i13, 127);
                int i14 = iE - 1;
                if (i14 >= 0) {
                    b[] bVarArr = e.f4283a;
                    if (i14 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i14]);
                    }
                }
                int length = cVar.f4271e + 1 + (i14 - e.f4283a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.f4270d;
                    if (length < bVarArr2.length) {
                        b bVar = bVarArr2[length];
                        q7.k.b(bVar);
                        arrayList.add(bVar);
                    }
                }
                throw new IOException(n.f.c(iE, "Header index too large "));
            }
            if (i13 == 64) {
                b[] bVarArr3 = e.f4283a;
                ob.k kVarD = cVar.d();
                e.a(kVarD);
                cVar.c(new b(kVarD, cVar.d()));
            } else if ((b10 & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i13, 63) - 1), cVar.d()));
            } else if ((b10 & 32) == 32) {
                int iE2 = cVar.e(i13, 31);
                cVar.f4267a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + cVar.f4267a);
                }
                int i15 = cVar.f4273g;
                if (iE2 < i15) {
                    if (iE2 == 0) {
                        b[] bVarArr4 = cVar.f4270d;
                        d7.n.d0(bVarArr4, 0, bVarArr4.length);
                        cVar.f4271e = cVar.f4270d.length - 1;
                        cVar.f4272f = 0;
                        cVar.f4273g = 0;
                    } else {
                        cVar.a(i15 - iE2);
                    }
                }
            } else if (i13 == 16 || i13 == 0) {
                b[] bVarArr5 = e.f4283a;
                ob.k kVarD2 = cVar.d();
                e.a(kVarD2);
                arrayList.add(new b(kVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i13, 15) - 1), cVar.d()));
            }
        }
        List listM1 = d7.r.m1(arrayList);
        arrayList.clear();
        return listM1;
    }

    public final void e(k kVar, int i2, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i12 = 0;
        int i13 = 1;
        boolean z4 = (i10 & 1) != 0;
        if ((i10 & 8) != 0) {
            byte b10 = this.f4350f.readByte();
            byte[] bArr = bb.b.f1659a;
            i12 = b10 & 255;
        }
        if ((i10 & 32) != 0) {
            ob.j jVar = this.f4350f;
            jVar.readInt();
            jVar.readByte();
            byte[] bArr2 = bb.b.f1659a;
            i2 -= 5;
        }
        List listD = d(r.a(i2, i10, i12), i12, i10, i11);
        p pVar = (p) kVar.f4299h;
        if (i11 != 0 && (i11 & 1) == 0) {
            pVar.f4322n.c(new m(pVar.f4316h + '[' + i11 + "] onHeaders", pVar, i11, listD, z4), 0L);
            return;
        }
        synchronized (pVar) {
            x xVarB = pVar.b(i11);
            if (xVarB != null) {
                xVarB.i(bb.b.v(listD), z4);
                return;
            }
            if (pVar.f4319k) {
                return;
            }
            if (i11 <= pVar.f4317i) {
                return;
            }
            if (i11 % 2 == pVar.f4318j % 2) {
                return;
            }
            x xVar = new x(i11, pVar, false, z4, bb.b.v(listD));
            pVar.f4317i = i11;
            pVar.f4315g.put(Integer.valueOf(i11), xVar);
            pVar.f4320l.e().c(new i(pVar.f4316h + '[' + i11 + "] onStream", pVar, xVar, i13), 0L);
        }
    }

    public final void g(k kVar, int i2, int i10, int i11) throws IOException {
        int i12;
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i10 & 8) != 0) {
            byte b10 = this.f4350f.readByte();
            byte[] bArr = bb.b.f1659a;
            i12 = b10 & 255;
        } else {
            i12 = 0;
        }
        int i13 = this.f4350f.readInt() & Integer.MAX_VALUE;
        List listD = d(r.a(i2 - 4, i10, i12), i12, i10, i11);
        p pVar = (p) kVar.f4299h;
        synchronized (pVar) {
            if (pVar.E.contains(Integer.valueOf(i13))) {
                pVar.k(i13, 2);
                return;
            }
            pVar.E.add(Integer.valueOf(i13));
            pVar.f4322n.c(new m(pVar.f4316h + '[' + i13 + "] onRequest", pVar, i13, listD), 0L);
        }
    }
}
