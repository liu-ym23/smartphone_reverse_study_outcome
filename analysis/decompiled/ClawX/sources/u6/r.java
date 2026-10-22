package u6;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.hpke.HPKE;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements Closeable {
    public static final Logger d;

    /* renamed from: a, reason: collision with root package name */
    public final c7.h f5748a;

    /* renamed from: b, reason: collision with root package name */
    public final q f5749b;

    /* renamed from: c, reason: collision with root package name */
    public final e f5750c;

    static {
        Logger logger = Logger.getLogger(h.class.getName());
        kotlin.jvm.internal.p.d(logger, "getLogger(...)");
        d = logger;
    }

    public r(c7.p source) {
        kotlin.jvm.internal.p.e(source, "source");
        this.f5748a = source;
        q qVar = new q(source);
        this.f5749b = qVar;
        this.f5750c = new e(qVar);
    }

    public final boolean a(boolean z, m mVar) throws Exception {
        int i8;
        Object[] array;
        try {
            this.f5748a.f(9L);
            int iL = o6.d.l(this.f5748a);
            if (iL > 16384) {
                throw new IOException(a8.b.j(iL, "FRAME_SIZE_ERROR: "));
            }
            int i9 = this.f5748a.readByte() & 255;
            byte b9 = this.f5748a.readByte();
            int i10 = b9 & 255;
            int i11 = this.f5748a.readInt();
            int i12 = Integer.MAX_VALUE & i11;
            int i13 = 1;
            if (i9 != 8) {
                Logger logger = d;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(h.b(true, i12, iL, i9, i10));
                }
            }
            if (z && i9 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + h.a(i9));
            }
            b bVar = null;
            switch (i9) {
                case 0:
                    b(mVar, iL, i10, i12);
                    return true;
                case 1:
                    g(mVar, iL, i10, i12);
                    return true;
                case 2:
                    if (iL != 5) {
                        throw new IOException(a8.b.k(iL, "TYPE_PRIORITY length: ", " != 5"));
                    }
                    if (i12 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    c7.h hVar = this.f5748a;
                    hVar.readInt();
                    hVar.readByte();
                    return true;
                case 3:
                    if (iL != 4) {
                        throw new IOException(a8.b.k(iL, "TYPE_RST_STREAM length: ", " != 4"));
                    }
                    if (i12 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i14 = this.f5748a.readInt();
                    b.f5670b.getClass();
                    b[] bVarArrValues = b.values();
                    int length = bVarArrValues.length;
                    while (true) {
                        if (i < length) {
                            b bVar2 = bVarArrValues[i];
                            if (bVar2.f5677a == i14) {
                                bVar = bVar2;
                            } else {
                                i++;
                            }
                        }
                    }
                    if (bVar == null) {
                        throw new IOException(a8.b.j(i14, "TYPE_RST_STREAM unexpected error code: "));
                    }
                    n nVar = mVar.f5713b;
                    if (i12 == 0 || (i11 & 1) != 0) {
                        v vVarE = nVar.e(i12);
                        if (vVarE != null) {
                            synchronized (vVarE) {
                                if (vVarE.h() == null) {
                                    vVarE.f5770l = bVar;
                                    vVarE.notifyAll();
                                }
                            }
                            return true;
                        }
                        return true;
                    }
                    q6.c.b(nVar.f5721j, nVar.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i12 + "] onReset", 0L, new j(nVar, i12, bVar, i13), 6);
                    return true;
                case 4:
                    c7.h hVar2 = this.f5748a;
                    if (i12 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((b9 & 1) != 0) {
                        if (iL != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        return true;
                    }
                    if (iL % 6 != 0) {
                        throw new IOException(a8.b.j(iL, "TYPE_SETTINGS length % 6 != 0: "));
                    }
                    z zVar = new z();
                    u5.d dVarN0 = k4.v.n0(k4.v.r0(0, iL), 6);
                    int i15 = dVarN0.f5663a;
                    int i16 = dVarN0.f5664b;
                    int i17 = dVarN0.f5665c;
                    if ((i17 > 0 && i15 <= i16) || (i17 < 0 && i16 <= i15)) {
                        while (true) {
                            short s8 = hVar2.readShort();
                            byte[] bArr = o6.d.f4327a;
                            int i18 = s8 & HPKE.aead_EXPORT_ONLY;
                            i8 = hVar2.readInt();
                            if (i18 != 2) {
                                if (i18 != 4) {
                                    if (i18 == 5 && (i8 < 16384 || i8 > 16777215)) {
                                    }
                                } else if (i8 < 0) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                }
                            } else if (i8 != 0 && i8 != 1) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                            }
                            zVar.c(i18, i8);
                            if (i15 != i16) {
                                i15 += i17;
                            }
                        }
                        throw new IOException(a8.b.j(i8, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                    }
                    n nVar2 = mVar.f5713b;
                    q6.c.b(nVar2.f5720h, m0.f.f(new StringBuilder(), nVar2.f5716c, " applyAndAckSettings"), 0L, new com.stepos.stepclaw.memory.lightmem.f(mVar, 12, zVar), 6);
                    return true;
                case 5:
                    j(mVar, iL, i10, i12);
                    return true;
                case 6:
                    if (iL != 8) {
                        throw new IOException(a8.b.j(iL, "TYPE_PING length != 8: "));
                    }
                    if (i12 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    int i19 = this.f5748a.readInt();
                    int i20 = this.f5748a.readInt();
                    if (((b9 & 1) != 0 ? 1 : 0) == 0) {
                        q6.c.b(mVar.f5713b.f5720h, m0.f.f(new StringBuilder(), mVar.f5713b.f5716c, " ping"), 0L, new com.stepos.stepclaw.memory.lightmem.e(mVar.f5713b, i19, i20), 6);
                        return true;
                    }
                    n nVar3 = mVar.f5713b;
                    synchronized (nVar3) {
                        try {
                            if (i19 == 1) {
                                nVar3.f5725n++;
                            } else if (i19 == 2) {
                                nVar3.f5727p++;
                            } else if (i19 == 3) {
                                nVar3.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return true;
                case 7:
                    if (iL < 8) {
                        throw new IOException(a8.b.j(iL, "TYPE_GOAWAY length < 8: "));
                    }
                    if (i12 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i21 = this.f5748a.readInt();
                    int i22 = this.f5748a.readInt();
                    int i23 = iL - 8;
                    b.f5670b.getClass();
                    b[] bVarArrValues2 = b.values();
                    int length2 = bVarArrValues2.length;
                    int i24 = 0;
                    while (true) {
                        if (i24 < length2) {
                            b bVar3 = bVarArrValues2[i24];
                            if (bVar3.f5677a == i22) {
                                bVar = bVar3;
                            } else {
                                i24++;
                            }
                        }
                    }
                    if (bVar == null) {
                        throw new IOException(a8.b.j(i22, "TYPE_GOAWAY unexpected error code: "));
                    }
                    c7.i debugData = c7.i.d;
                    if (i23 > 0) {
                        debugData = this.f5748a.i(i23);
                    }
                    kotlin.jvm.internal.p.e(debugData, "debugData");
                    debugData.c();
                    n nVar4 = mVar.f5713b;
                    synchronized (nVar4) {
                        array = nVar4.f5715b.values().toArray(new v[0]);
                        nVar4.f5718f = true;
                    }
                    v[] vVarArr = (v[]) array;
                    int length3 = vVarArr.length;
                    while (i < length3) {
                        v vVar = vVarArr[i];
                        if (vVar.f5760a > i21 && vVar.i()) {
                            b bVar4 = b.f5674g;
                            synchronized (vVar) {
                                if (vVar.h() == null) {
                                    vVar.f5770l = bVar4;
                                    vVar.notifyAll();
                                }
                            }
                            mVar.f5713b.e(vVar.f5760a);
                        }
                        i++;
                    }
                    return true;
                case 8:
                    try {
                        if (iL != 4) {
                            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + iL);
                        }
                        long j4 = this.f5748a.readInt() & 2147483647L;
                        if (j4 == 0) {
                            throw new IOException("windowSizeIncrement was 0");
                        }
                        Logger logger2 = d;
                        if (logger2.isLoggable(Level.FINE)) {
                            logger2.fine(h.c(true, i12, iL, j4));
                        }
                        if (i12 == 0) {
                            n nVar5 = mVar.f5713b;
                            synchronized (nVar5) {
                                nVar5.f5734w += j4;
                                nVar5.notifyAll();
                            }
                            return true;
                        }
                        v vVarB = mVar.f5713b.b(i12);
                        if (vVarB != null) {
                            synchronized (vVarB) {
                                vVarB.f5763e += j4;
                                if (j4 > 0) {
                                    vVarB.notifyAll();
                                }
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e9) {
                        d.fine(h.b(true, i12, iL, 8, i10));
                        throw e9;
                    }
                default:
                    this.f5748a.skip(iL);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x011b, code lost:
    
        if (r6 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011d, code lost:
    
        r9.k(n6.k.f4053b, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(u6.m r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.r.b(u6.m, int, int, int):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f5748a.close();
    }

    public final List e(int i8, int i9, int i10, int i11) throws IOException {
        q qVar = this.f5749b;
        qVar.f5746e = i8;
        qVar.f5744b = i8;
        qVar.f5747f = i9;
        qVar.f5745c = i10;
        qVar.d = i11;
        e eVar = this.f5750c;
        c7.p pVar = eVar.f5689c;
        ArrayList arrayList = eVar.f5688b;
        while (!pVar.q()) {
            byte b9 = pVar.readByte();
            byte[] bArr = o6.d.f4327a;
            int i12 = b9 & 255;
            if (i12 == 128) {
                throw new IOException("index == 0");
            }
            if ((b9 & 128) == 128) {
                int iE = eVar.e(i12, 127);
                int i13 = iE - 1;
                if (i13 >= 0) {
                    d[] dVarArr = g.f5700a;
                    if (i13 <= dVarArr.length - 1) {
                        arrayList.add(dVarArr[i13]);
                    }
                }
                int length = eVar.f5690e + 1 + (i13 - g.f5700a.length);
                if (length >= 0) {
                    d[] dVarArr2 = eVar.d;
                    if (length < dVarArr2.length) {
                        d dVar = dVarArr2[length];
                        kotlin.jvm.internal.p.b(dVar);
                        arrayList.add(dVar);
                    }
                }
                throw new IOException(a8.b.j(iE, "Header index too large "));
            }
            if (i12 == 64) {
                d[] dVarArr3 = g.f5700a;
                c7.i iVarD = eVar.d();
                g.a(iVarD);
                eVar.c(new d(iVarD, eVar.d()));
            } else if ((b9 & 64) == 64) {
                eVar.c(new d(eVar.b(eVar.e(i12, 63) - 1), eVar.d()));
            } else if ((b9 & 32) == 32) {
                int iE2 = eVar.e(i12, 31);
                eVar.f5687a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + eVar.f5687a);
                }
                int i14 = eVar.f5692g;
                if (iE2 < i14) {
                    if (iE2 == 0) {
                        d[] dVarArr4 = eVar.d;
                        c5.l.c0(dVarArr4, 0, dVarArr4.length);
                        eVar.f5690e = eVar.d.length - 1;
                        eVar.f5691f = 0;
                        eVar.f5692g = 0;
                    } else {
                        eVar.a(i14 - iE2);
                    }
                }
            } else if (i12 == 16 || i12 == 0) {
                d[] dVarArr5 = g.f5700a;
                c7.i iVarD2 = eVar.d();
                g.a(iVarD2);
                arrayList.add(new d(iVarD2, eVar.d()));
            } else {
                arrayList.add(new d(eVar.b(eVar.e(i12, 15) - 1), eVar.d()));
            }
        }
        List listN0 = c5.m.N0(arrayList);
        arrayList.clear();
        return listN0;
    }

    public final void g(m mVar, int i8, int i9, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i12 = 0;
        boolean z = (i9 & 1) != 0;
        if ((i9 & 8) != 0) {
            byte b9 = this.f5748a.readByte();
            byte[] bArr = o6.d.f4327a;
            i12 = b9 & 255;
        }
        if ((i9 & 32) != 0) {
            c7.h hVar = this.f5748a;
            hVar.readInt();
            hVar.readByte();
            byte[] bArr2 = o6.d.f4327a;
            i11 = i8 - 5;
        } else {
            i11 = i8;
        }
        List listE = e(p.a(i11, i9, i12), i12, i9, i10);
        n nVar = mVar.f5713b;
        if (i10 != 0 && (i10 & 1) == 0) {
            q6.c.b(nVar.f5721j, nVar.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i10 + "] onHeaders", 0L, new j(nVar, i10, listE, z), 6);
            return;
        }
        synchronized (nVar) {
            v vVarB = nVar.b(i10);
            if (vVarB != null) {
                vVarB.k(o6.f.h(listE), z);
                return;
            }
            if (nVar.f5718f) {
                return;
            }
            if (i10 <= nVar.d) {
                return;
            }
            if (i10 % 2 == nVar.f5717e % 2) {
                return;
            }
            v vVar = new v(i10, nVar, false, z, o6.f.h(listE));
            nVar.d = i10;
            nVar.f5715b.put(Integer.valueOf(i10), vVar);
            q6.c.b(nVar.f5719g.d(), nVar.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i10 + "] onStream", 0L, new com.stepos.stepclaw.memory.lightmem.f(nVar, 11, vVar), 6);
        }
    }

    public final void j(m mVar, int i8, int i9, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int i12 = 0;
        if ((i9 & 8) != 0) {
            byte b9 = this.f5748a.readByte();
            byte[] bArr = o6.d.f4327a;
            i11 = b9 & 255;
        } else {
            i11 = 0;
        }
        int i13 = this.f5748a.readInt() & Integer.MAX_VALUE;
        List listE = e(p.a(i8 - 4, i9, i11), i11, i9, i10);
        n nVar = mVar.f5713b;
        synchronized (nVar) {
            if (nVar.A.contains(Integer.valueOf(i13))) {
                nVar.n(i13, b.d);
                return;
            }
            nVar.A.add(Integer.valueOf(i13));
            q6.c.b(nVar.f5721j, nVar.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i13 + "] onRequest", 0L, new j(nVar, i13, listE, i12), 6);
        }
    }
}
