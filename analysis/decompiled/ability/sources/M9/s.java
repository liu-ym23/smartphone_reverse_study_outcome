package M9;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class s implements Closeable {
    public static final Logger d;

    /* renamed from: a, reason: collision with root package name */
    public final V9.i f995a;
    public final r b;
    public final C0248b c;

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        kotlin.jvm.internal.k.e(logger, "getLogger(Http2::class.java.name)");
        d = logger;
    }

    public s(V9.r source) {
        kotlin.jvm.internal.k.f(source, "source");
        this.f995a = source;
        r rVar = new r(source);
        this.b = rVar;
        this.c = new C0248b(rVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0244, code lost:
    
        throw new java.io.IOException(B7.a.h(r9, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(boolean r18, J4.e r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M9.s.b(boolean, J4.e):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r16 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0119, code lost:
    
        r9.i(G9.b.b, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(J4.e r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M9.s.c(J4.e, int, int, int):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f995a.close();
    }

    public final List f(int i, int i6, int i10, int i11) throws IOException {
        r rVar = this.b;
        rVar.e = i;
        rVar.b = i;
        rVar.f = i6;
        rVar.c = i10;
        rVar.d = i11;
        C0248b c0248b = this.c;
        V9.r rVar2 = (V9.r) c0248b.f;
        ArrayList arrayList = (ArrayList) c0248b.e;
        while (!rVar2.b()) {
            byte b = rVar2.readByte();
            byte[] bArr = G9.b.f704a;
            int i12 = b & 255;
            if (i12 == 128) {
                throw new IOException("index == 0");
            }
            if ((b & 128) == 128) {
                int iE = c0248b.e(i12, 127);
                int i13 = iE - 1;
                if (i13 >= 0) {
                    C0247a[] c0247aArr = d.f979a;
                    if (i13 <= c0247aArr.length - 1) {
                        arrayList.add(c0247aArr[i13]);
                    }
                }
                int length = c0248b.b + 1 + (i13 - d.f979a.length);
                if (length >= 0) {
                    C0247a[] c0247aArr2 = (C0247a[]) c0248b.g;
                    if (length < c0247aArr2.length) {
                        C0247a c0247a = c0247aArr2[length];
                        kotlin.jvm.internal.k.c(c0247a);
                        arrayList.add(c0247a);
                    }
                }
                throw new IOException(B7.a.h(iE, "Header index too large "));
            }
            if (i12 == 64) {
                C0247a[] c0247aArr3 = d.f979a;
                ByteString byteStringD = c0248b.d();
                d.a(byteStringD);
                c0248b.c(new C0247a(byteStringD, c0248b.d()));
            } else if ((b & 64) == 64) {
                c0248b.c(new C0247a(c0248b.b(c0248b.e(i12, 63) - 1), c0248b.d()));
            } else if ((b & 32) == 32) {
                int iE2 = c0248b.e(i12, 31);
                c0248b.f977a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + c0248b.f977a);
                }
                int i14 = c0248b.d;
                if (iE2 < i14) {
                    if (iE2 == 0) {
                        C0247a[] c0247aArr4 = (C0247a[]) c0248b.g;
                        D7.q.f0(null, 0, c0247aArr4, c0247aArr4.length);
                        c0248b.b = ((C0247a[]) c0248b.g).length - 1;
                        c0248b.c = 0;
                        c0248b.d = 0;
                    } else {
                        c0248b.a(i14 - iE2);
                    }
                }
            } else if (i12 == 16 || i12 == 0) {
                C0247a[] c0247aArr5 = d.f979a;
                ByteString byteStringD2 = c0248b.d();
                d.a(byteStringD2);
                arrayList.add(new C0247a(byteStringD2, c0248b.d()));
            } else {
                arrayList.add(new C0247a(c0248b.b(c0248b.e(i12, 15) - 1), c0248b.d()));
            }
        }
        List listF1 = D7.v.f1(arrayList);
        arrayList.clear();
        return listF1;
    }

    public final void g(J4.e eVar, int i, int i6, int i10) throws IOException {
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i11 = 0;
        int i12 = 1;
        boolean z10 = (i6 & 1) != 0;
        if ((i6 & 8) != 0) {
            byte b = this.f995a.readByte();
            byte[] bArr = G9.b.f704a;
            i11 = b & 255;
        }
        if ((i6 & 32) != 0) {
            V9.i iVar = this.f995a;
            iVar.readInt();
            iVar.readByte();
            byte[] bArr2 = G9.b.f704a;
            i -= 5;
        }
        List headerBlock = f(q.a(i, i6, i11), i11, i6, i10);
        kotlin.jvm.internal.k.f(headerBlock, "headerBlock");
        o oVar = (o) eVar.c;
        if (i10 != 0 && (i10 & 1) == 0) {
            oVar.i.c(new l(oVar.c + '[' + i10 + "] onHeaders", oVar, i10, headerBlock, z10), 0L);
            return;
        }
        synchronized (oVar) {
            w wVarF = oVar.f(i10);
            if (wVarF != null) {
                wVarF.i(G9.b.u(headerBlock), z10);
                return;
            }
            if (oVar.f) {
                return;
            }
            if (i10 <= oVar.d) {
                return;
            }
            if (i10 % 2 == oVar.e % 2) {
                return;
            }
            w wVar = new w(i10, oVar, false, z10, G9.b.u(headerBlock));
            oVar.d = i10;
            oVar.b.put(Integer.valueOf(i10), wVar);
            oVar.g.e().c(new i(i12, oVar.c + '[' + i10 + "] onStream", oVar, wVar), 0L);
        }
    }

    public final void i(J4.e eVar, int i, int i6, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i6 & 8) != 0) {
            byte b = this.f995a.readByte();
            byte[] bArr = G9.b.f704a;
            i11 = b & 255;
        } else {
            i11 = 0;
        }
        int i12 = this.f995a.readInt() & Integer.MAX_VALUE;
        List requestHeaders = f(q.a(i - 4, i6, i11), i11, i6, i10);
        kotlin.jvm.internal.k.f(requestHeaders, "requestHeaders");
        o oVar = (o) eVar.c;
        synchronized (oVar) {
            if (oVar.y.contains(Integer.valueOf(i12))) {
                oVar.n(i12, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            oVar.y.add(Integer.valueOf(i12));
            oVar.i.c(new l(oVar.c + '[' + i12 + "] onRequest", oVar, i12, requestHeaders, 1), 0L);
        }
    }
}
