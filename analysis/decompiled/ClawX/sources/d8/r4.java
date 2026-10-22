package d8;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r4 {

    /* renamed from: l, reason: collision with root package name */
    public static final z7.b f2143l = z7.d.b(r4.class);

    /* renamed from: a, reason: collision with root package name */
    public final x1 f2144a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2145b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2146c;
    public androidx.emoji2.text.p d;

    /* renamed from: e, reason: collision with root package name */
    public final SocketAddress f2147e;

    /* renamed from: f, reason: collision with root package name */
    public v3 f2148f;

    /* renamed from: g, reason: collision with root package name */
    public Duration f2149g = Duration.ofMinutes(15);

    /* renamed from: h, reason: collision with root package name */
    public int f2150h;

    /* renamed from: i, reason: collision with root package name */
    public long f2151i;

    /* renamed from: j, reason: collision with root package name */
    public long f2152j;

    /* renamed from: k, reason: collision with root package name */
    public w2 f2153k;

    public r4(x1 x1Var, SocketAddress socketAddress) {
        this.f2147e = socketAddress;
        if (x1Var.isAbsolute()) {
            this.f2144a = x1Var;
        } else {
            try {
                x1 x1Var2 = x1.f2208g;
                if (!x1Var.isAbsolute()) {
                    x1 x1Var3 = new x1();
                    x1Var3.a(x1Var.f2211a, x1Var.d);
                    x1Var3.a(x1Var2.f2211a, x1Var2.d);
                    x1Var = x1Var3;
                }
                this.f2144a = x1Var;
            } catch (y1 unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.f2145b = 252;
        this.f2146c = 1;
        this.f2150h = 0;
    }

    public static void b(String str) throws p4 {
        throw new p4(str);
    }

    public final void a() throws p4, l4 {
        int i8;
        int i9;
        int i10;
        x1 x1Var = this.f2144a;
        int i11 = this.f2145b;
        int i12 = this.f2146c;
        long j4 = 0;
        w2 w2VarH = w2.h(x1Var, i11, i12, 0L);
        j1 j1Var = new j1();
        j1Var.f2031a.e();
        j1Var.a(w2VarH, 0);
        if (i11 == 251) {
            x1 x1Var2 = x1.f2208g;
            c3 c3Var = new c3(x1Var, 6, i12);
            w2.b("host", x1Var2);
            c3Var.f1966f = x1Var2;
            w2.b("admin", x1Var2);
            c3Var.f1967g = x1Var2;
            c3Var.f1968h = 0L;
            c3Var.f1969j = 0L;
            c3Var.f1970k = 0L;
            c3Var.f1971l = 0L;
            c3Var.f1972m = 0L;
            j1Var.a(c3Var, 2);
        }
        b0.j jVar = new b0.j(2);
        j1Var.e(jVar);
        j1Var.f2033c = jVar.f832a;
        byte[] bArrF = jVar.f();
        v3 v3Var = this.f2148f;
        SelectionKey selectionKey = v3Var.f2188c;
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        socketChannel.socket().getLocalSocketAddress();
        socketChannel.socket().getRemoteSocketAddress();
        b2.c("TCP write", bArrF);
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArrF.length >>> 8), (byte) (bArrF.length & 255)}), ByteBuffer.wrap(bArrF)};
        int i13 = 4;
        selectionKey.interestOps(4);
        int i14 = 0;
        while (i14 < bArrF.length + 2) {
            try {
                if (selectionKey.isWritable()) {
                    long j8 = j4;
                    long jWrite = socketChannel.write(byteBufferArr);
                    if (jWrite < j8) {
                        throw new EOFException();
                    }
                    int i15 = i14 + ((int) jWrite);
                    if (i15 < bArrF.length + 2) {
                        i9 = i13;
                        i10 = i15;
                        if (System.nanoTime() - v3Var.f2186a >= v3Var.f2187b.toNanos()) {
                            throw new SocketTimeoutException();
                        }
                    } else {
                        i9 = i13;
                        i10 = i15;
                    }
                    j4 = j8;
                    i13 = i9;
                    i14 = i10;
                } else {
                    long j9 = j4;
                    int i16 = i13;
                    v3Var.a(selectionKey);
                    j4 = j9;
                    i13 = i16;
                }
            } catch (Throwable th) {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
                throw th;
            }
        }
        int i17 = i13;
        if (selectionKey.isValid()) {
            selectionKey.interestOps(0);
        }
        while (this.f2150h != 7) {
            v3 v3Var2 = this.f2148f;
            byte[] bArrB = v3Var2.b(2);
            byte[] bArrB2 = v3Var2.b(((bArrB[0] & 255) << 8) + (bArrB[1] & 255));
            SocketChannel socketChannel2 = (SocketChannel) v3Var2.f2188c.channel();
            socketChannel2.socket().getLocalSocketAddress();
            socketChannel2.socket().getRemoteSocketAddress();
            b2.c("TCP read", bArrB2);
            try {
                j1 j1Var2 = new j1(bArrB2);
                q3.f2122a.c(1);
                List list = j1Var2.f2032b[1];
                List listUnmodifiableList = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
                j1Var2.f2031a.getClass();
                if (this.f2150h == 0) {
                    int i18 = j1Var2.f2031a.f2176b & 15;
                    n2 n2VarC = j1Var2.c();
                    if (n2VarC != null) {
                        i18 += ((int) (n2VarC.d >>> 24)) << 4;
                    }
                    if (i18 != 0) {
                        if (i11 == 251 && i18 == i17) {
                            b("server doesn't support IXFR");
                            throw null;
                        }
                        b(v2.f2185a.d(i18));
                        throw null;
                    }
                    i8 = i17;
                    w2 w2VarD = j1Var2.d();
                    if (w2VarD != null && w2VarD.f2196b != i11) {
                        b("invalid question section");
                        throw null;
                    }
                    if (listUnmodifiableList.isEmpty() && i11 == 251) {
                        b("server doesn't support IXFR");
                        throw null;
                    }
                } else {
                    i8 = i17;
                }
                Iterator it = listUnmodifiableList.iterator();
                while (it.hasNext()) {
                    d((w2) it.next());
                }
                i17 = i8;
            } catch (IOException e9) {
                if (!(e9 instanceof l4)) {
                    throw new l4("Error parsing message", e9);
                }
                throw ((l4) e9);
            }
        }
    }

    public final void c() {
        v3 v3Var = new v3(this.f2149g);
        this.f2148f = v3Var;
        SelectionKey selectionKey = v3Var.f2188c;
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel.connect(this.f2147e)) {
            return;
        }
        selectionKey.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!selectionKey.isConnectable()) {
                    v3Var.a(selectionKey);
                }
            } finally {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
            }
        }
    }

    public final void d(w2 w2Var) throws p4 {
        int i8 = w2Var.f2196b;
        int i9 = this.f2150h;
        x1 x1Var = this.f2144a;
        z7.b bVar = f2143l;
        switch (i9) {
            case 0:
                if (i8 != 6) {
                    b("missing initial SOA");
                    throw null;
                }
                this.f2153k = w2Var;
                long j4 = ((c3) w2Var).f1968h;
                this.f2151i = j4;
                if (this.f2145b == 251) {
                    if (j4 < 0 || j4 > 4294967295L) {
                        throw new IllegalArgumentException(j4 + " out of range");
                    }
                    if (j4 >= 4294967295L) {
                        j4 -= 4294967296L;
                    }
                    if (((int) j4) <= 0) {
                        bVar.c("{}: {}", x1Var, "up to date");
                        this.f2150h = 7;
                        return;
                    }
                }
                this.f2150h = 1;
                return;
            case 1:
                if (this.f2145b == 251 && i8 == 6 && ((c3) w2Var).f1968h == 0) {
                    androidx.emoji2.text.p pVar = this.d;
                    pVar.getClass();
                    pVar.f624c = new ArrayList();
                    bVar.c("{}: {}", x1Var, "got incremental response");
                    this.f2150h = 2;
                } else {
                    androidx.emoji2.text.p pVar2 = this.d;
                    pVar2.getClass();
                    pVar2.f623b = new ArrayList();
                    this.d.m(this.f2153k);
                    bVar.c("{}: {}", x1Var, "got nonincremental response");
                    this.f2150h = 6;
                }
                d(w2Var);
                return;
            case 2:
                androidx.emoji2.text.p pVar3 = this.d;
                pVar3.getClass();
                q4 q4Var = new q4();
                q4Var.f2125a = new ArrayList();
                ArrayList arrayList = new ArrayList();
                q4Var.f2126b = arrayList;
                arrayList.add(w2Var);
                ((ArrayList) pVar3.f624c).add(q4Var);
                this.f2150h = 3;
                return;
            case 3:
                if (i8 != 6) {
                    this.d.m(w2Var);
                    return;
                }
                this.f2152j = ((c3) w2Var).f1968h;
                this.f2150h = 4;
                d(w2Var);
                return;
            case 4:
                ArrayList arrayList2 = (ArrayList) this.d.f624c;
                ((q4) arrayList2.get(arrayList2.size() - 1)).f2125a.add(w2Var);
                this.f2150h = 5;
                return;
            case 5:
                if (i8 != 6) {
                    this.d.m(w2Var);
                    return;
                }
                long j8 = ((c3) w2Var).f1968h;
                if (j8 == this.f2151i) {
                    this.f2150h = 7;
                    return;
                }
                if (j8 == this.f2152j) {
                    this.f2150h = 2;
                    d(w2Var);
                    return;
                }
                b("IXFR out of sync: expected serial " + this.f2152j + " , got " + j8);
                throw null;
            case 6:
                if (i8 != 1 || w2Var.f2197c == this.f2146c) {
                    this.d.m(w2Var);
                    if (i8 == 6) {
                        this.f2150h = 7;
                        return;
                    }
                    return;
                }
                return;
            case 7:
                b("extra data");
                throw null;
            default:
                b("invalid state");
                throw null;
        }
    }
}
