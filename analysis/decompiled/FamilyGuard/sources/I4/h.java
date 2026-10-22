package I4;

import I4.d;
import L4.y;
import L4.z;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class h implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    static final Logger f3099e = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final L4.g f3100a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3101b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3102c;

    /* renamed from: d, reason: collision with root package name */
    final d.a f3103d;

    static final class a implements y {

        /* renamed from: a, reason: collision with root package name */
        private final L4.g f3104a;

        /* renamed from: b, reason: collision with root package name */
        int f3105b;

        /* renamed from: c, reason: collision with root package name */
        byte f3106c;

        /* renamed from: d, reason: collision with root package name */
        int f3107d;

        /* renamed from: e, reason: collision with root package name */
        int f3108e;

        /* renamed from: f, reason: collision with root package name */
        short f3109f;

        a(L4.g gVar) {
            this.f3104a = gVar;
        }

        private void a() throws IOException {
            int i5 = this.f3107d;
            int iV = h.v(this.f3104a);
            this.f3108e = iV;
            this.f3105b = iV;
            byte b6 = (byte) (this.f3104a.readByte() & 255);
            this.f3106c = (byte) (this.f3104a.readByte() & 255);
            Logger logger = h.f3099e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, this.f3107d, this.f3105b, b6, this.f3106c));
            }
            int i6 = this.f3104a.readInt() & Integer.MAX_VALUE;
            this.f3107d = i6;
            if (b6 != 9) {
                throw e.d("%s != TYPE_CONTINUATION", Byte.valueOf(b6));
            }
            if (i6 != i5) {
                throw e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // L4.y
        public z b() {
            return this.f3104a.b();
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            while (true) {
                int i5 = this.f3108e;
                if (i5 != 0) {
                    long jE = this.f3104a.e(eVar, Math.min(j5, i5));
                    if (jE == -1) {
                        return -1L;
                    }
                    this.f3108e = (int) (this.f3108e - jE);
                    return jE;
                }
                this.f3104a.skip(this.f3109f);
                this.f3109f = (short) 0;
                if ((this.f3106c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }
    }

    interface b {
        void a(int i5, I4.b bVar);

        void b();

        void c(boolean z5, int i5, L4.g gVar, int i6);

        void d(int i5, I4.b bVar, L4.h hVar);

        void e(boolean z5, int i5, int i6, List<c> list);

        void f(int i5, long j5);

        void g(boolean z5, m mVar);

        void h(boolean z5, int i5, int i6);

        void i(int i5, int i6, int i7, boolean z5);

        void j(int i5, int i6, List<c> list);
    }

    h(L4.g gVar, boolean z5) {
        this.f3100a = gVar;
        this.f3102c = z5;
        a aVar = new a(gVar);
        this.f3101b = aVar;
        this.f3103d = new d.a(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT, aVar);
    }

    private void A(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i5 != 5) {
            throw e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i5));
        }
        if (i6 == 0) {
            throw e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        x(bVar, i6);
    }

    private void C(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i6 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s5 = (b6 & 8) != 0 ? (short) (this.f3100a.readByte() & 255) : (short) 0;
        bVar.j(i6, this.f3100a.readInt() & Integer.MAX_VALUE, r(a(i5 - 4, b6, s5), s5, b6, i6));
    }

    private void D(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i5 != 4) {
            throw e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i5));
        }
        if (i6 == 0) {
            throw e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i7 = this.f3100a.readInt();
        I4.b bVarB = I4.b.b(i7);
        if (bVarB == null) {
            throw e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i7));
        }
        bVar.a(i6, bVarB);
    }

    private void E(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i6 != 0) {
            throw e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b6 & 1) != 0) {
            if (i5 != 0) {
                throw e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.b();
            return;
        }
        if (i5 % 6 != 0) {
            throw e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i5));
        }
        m mVar = new m();
        for (int i7 = 0; i7 < i5; i7 += 6) {
            int i8 = this.f3100a.readShort() & 65535;
            int i9 = this.f3100a.readInt();
            if (i8 == 2) {
                if (i9 != 0 && i9 != 1) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i8 == 3) {
                i8 = 4;
            } else if (i8 != 4) {
                if (i8 == 5 && (i9 < 16384 || i9 > 16777215)) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i9));
                }
            } else {
                if (i9 < 0) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i8 = 7;
            }
            mVar.i(i8, i9);
        }
        bVar.g(false, mVar);
    }

    private void G(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i5 != 4) {
            throw e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i5));
        }
        long j5 = this.f3100a.readInt() & 2147483647L;
        if (j5 == 0) {
            throw e.d("windowSizeIncrement was 0", Long.valueOf(j5));
        }
        bVar.f(i6, j5);
    }

    static int a(int i5, byte b6, short s5) throws IOException {
        if ((b6 & 8) != 0) {
            i5--;
        }
        if (s5 <= i5) {
            return (short) (i5 - s5);
        }
        throw e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s5), Integer.valueOf(i5));
    }

    private void m(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i6 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z5 = (b6 & 1) != 0;
        if ((b6 & 32) != 0) {
            throw e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s5 = (b6 & 8) != 0 ? (short) (this.f3100a.readByte() & 255) : (short) 0;
        bVar.c(z5, i6, this.f3100a, a(i5, b6, s5));
        this.f3100a.skip(s5);
    }

    private void o(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i5 < 8) {
            throw e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i5));
        }
        if (i6 != 0) {
            throw e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i7 = this.f3100a.readInt();
        int i8 = this.f3100a.readInt();
        int i9 = i5 - 8;
        I4.b bVarB = I4.b.b(i8);
        if (bVarB == null) {
            throw e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i8));
        }
        L4.h hVarJ = L4.h.f3942d;
        if (i9 > 0) {
            hVarJ = this.f3100a.j(i9);
        }
        bVar.d(i7, bVarB, hVarJ);
    }

    private List<c> r(int i5, short s5, byte b6, int i6) throws IOException {
        a aVar = this.f3101b;
        aVar.f3108e = i5;
        aVar.f3105b = i5;
        aVar.f3109f = s5;
        aVar.f3106c = b6;
        aVar.f3107d = i6;
        this.f3103d.k();
        return this.f3103d.e();
    }

    private void u(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i6 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z5 = (b6 & 1) != 0;
        short s5 = (b6 & 8) != 0 ? (short) (this.f3100a.readByte() & 255) : (short) 0;
        if ((b6 & 32) != 0) {
            x(bVar, i6);
            i5 -= 5;
        }
        bVar.e(z5, i6, -1, r(a(i5, b6, s5), s5, b6, i6));
    }

    static int v(L4.g gVar) {
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    private void w(b bVar, int i5, byte b6, int i6) throws IOException {
        if (i5 != 8) {
            throw e.d("TYPE_PING length != 8: %s", Integer.valueOf(i5));
        }
        if (i6 != 0) {
            throw e.d("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.h((b6 & 1) != 0, this.f3100a.readInt(), this.f3100a.readInt());
    }

    private void x(b bVar, int i5) {
        int i6 = this.f3100a.readInt();
        bVar.i(i5, i6 & Integer.MAX_VALUE, (this.f3100a.readByte() & 255) + 1, (Integer.MIN_VALUE & i6) != 0);
    }

    public boolean c(boolean z5, b bVar) throws IOException {
        try {
            this.f3100a.q0(9L);
            int iV = v(this.f3100a);
            if (iV < 0 || iV > 16384) {
                throw e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iV));
            }
            byte b6 = (byte) (this.f3100a.readByte() & 255);
            if (z5 && b6 != 4) {
                throw e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(b6));
            }
            byte b7 = (byte) (this.f3100a.readByte() & 255);
            int i5 = this.f3100a.readInt() & Integer.MAX_VALUE;
            Logger logger = f3099e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, i5, iV, b6, b7));
            }
            switch (b6) {
                case 0:
                    m(bVar, iV, b7, i5);
                    return true;
                case 1:
                    u(bVar, iV, b7, i5);
                    return true;
                case 2:
                    A(bVar, iV, b7, i5);
                    return true;
                case 3:
                    D(bVar, iV, b7, i5);
                    return true;
                case 4:
                    E(bVar, iV, b7, i5);
                    return true;
                case 5:
                    C(bVar, iV, b7, i5);
                    return true;
                case 6:
                    w(bVar, iV, b7, i5);
                    return true;
                case 7:
                    o(bVar, iV, b7, i5);
                    return true;
                case 8:
                    G(bVar, iV, b7, i5);
                    return true;
                default:
                    this.f3100a.skip(iV);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3100a.close();
    }

    public void f(b bVar) throws IOException {
        if (this.f3102c) {
            if (!c(true, bVar)) {
                throw e.d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        L4.g gVar = this.f3100a;
        L4.h hVar = e.f3017a;
        L4.h hVarJ = gVar.j(hVar.w());
        Logger logger = f3099e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(D4.e.q("<< CONNECTION %s", hVarJ.n()));
        }
        if (!hVar.equals(hVarJ)) {
            throw e.d("Expected a connection header but was %s", hVarJ.C());
        }
    }
}
