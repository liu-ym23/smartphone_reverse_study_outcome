package okhttp3.internal.http2;

import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.b;
import okio.ByteString;
import sd.e0;
import sd.f0;
import sd.h;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f11216d;

    /* renamed from: a, reason: collision with root package name */
    public final h f11217a;

    /* renamed from: b, reason: collision with root package name */
    public final b f11218b;

    /* renamed from: c, reason: collision with root package name */
    public final b.a f11219c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static int a(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException(a0.a.f("PROTOCOL_ERROR padding ", i12, i10, " > remaining length "));
        }
    }

    static {
        Logger logger = Logger.getLogger(hd.b.class.getName());
        g.e(logger, "getLogger(...)");
        f11216d = logger;
    }

    public d(h source) {
        g.f(source, "source");
        this.f11217a = source;
        b bVar = new b(source);
        this.f11218b = bVar;
        this.f11219c = new b.a(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x0277, code lost:
    
        throw new java.io.IOException(ai.onnxruntime.providers.a.a(r8, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r19, final okhttp3.internal.http2.Http2Connection.c r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1014
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.d.a(boolean, okhttp3.internal.http2.Http2Connection$c):boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11217a.close();
    }

    public final List<hd.a> o(int i10, int i11, int i12, int i13) throws IOException {
        b bVar = this.f11218b;
        bVar.f11224e = i10;
        bVar.f11221b = i10;
        bVar.h = i11;
        bVar.f11222c = i12;
        bVar.f11223d = i13;
        b.a aVar = this.f11219c;
        z zVar = aVar.f11197c;
        ArrayList arrayList = aVar.f11196b;
        while (!zVar.f0()) {
            byte b10 = zVar.readByte();
            byte[] bArr = i.f3230a;
            int i14 = b10 & 255;
            if (i14 == 128) {
                throw new IOException("index == 0");
            }
            if ((b10 & 128) == 128) {
                int iE = aVar.e(i14, 127);
                int i15 = iE - 1;
                if (i15 >= 0) {
                    hd.a[] aVarArr = okhttp3.internal.http2.b.f11193a;
                    if (i15 <= aVarArr.length - 1) {
                        arrayList.add(aVarArr[i15]);
                    }
                }
                int length = aVar.f11199e + 1 + (i15 - okhttp3.internal.http2.b.f11193a.length);
                if (length >= 0) {
                    hd.a[] aVarArr2 = aVar.f11198d;
                    if (length < aVarArr2.length) {
                        hd.a aVar2 = aVarArr2[length];
                        g.c(aVar2);
                        arrayList.add(aVar2);
                    }
                }
                throw new IOException(ai.onnxruntime.providers.a.a(iE, "Header index too large "));
            }
            if (i14 == 64) {
                hd.a[] aVarArr3 = okhttp3.internal.http2.b.f11193a;
                ByteString byteStringD = aVar.d();
                okhttp3.internal.http2.b.a(byteStringD);
                aVar.c(new hd.a(byteStringD, aVar.d()));
            } else if ((b10 & 64) == 64) {
                aVar.c(new hd.a(aVar.b(aVar.e(i14, 63) - 1), aVar.d()));
            } else if ((b10 & 32) == 32) {
                int iE2 = aVar.e(i14, 31);
                aVar.f11195a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + aVar.f11195a);
                }
                int i16 = aVar.f11201g;
                if (iE2 < i16) {
                    if (iE2 == 0) {
                        hd.a[] aVarArr4 = aVar.f11198d;
                        b1.G(null, aVarArr4, 0, aVarArr4.length);
                        aVar.f11199e = aVar.f11198d.length - 1;
                        aVar.f11200f = 0;
                        aVar.f11201g = 0;
                    } else {
                        aVar.a(i16 - iE2);
                    }
                }
            } else if (i14 == 16 || i14 == 0) {
                hd.a[] aVarArr5 = okhttp3.internal.http2.b.f11193a;
                ByteString byteStringD2 = aVar.d();
                okhttp3.internal.http2.b.a(byteStringD2);
                arrayList.add(new hd.a(byteStringD2, aVar.d()));
            } else {
                arrayList.add(new hd.a(aVar.b(aVar.e(i14, 15) - 1), aVar.d()));
            }
        }
        List<hd.a> listO0 = kotlin.collections.a.O0(arrayList);
        arrayList.clear();
        return listO0;
    }

    public final void w(Http2Connection.c cVar, int i10) {
        h hVar = this.f11217a;
        hVar.readInt();
        hVar.readByte();
        byte[] bArr = i.f3230a;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final h f11220a;

        /* renamed from: b, reason: collision with root package name */
        public int f11221b;

        /* renamed from: c, reason: collision with root package name */
        public int f11222c;

        /* renamed from: d, reason: collision with root package name */
        public int f11223d;

        /* renamed from: e, reason: collision with root package name */
        public int f11224e;
        public int h;

        public b(h source) {
            g.f(source, "source");
            this.f11220a = source;
        }

        @Override // sd.e0
        public final long read(sd.e sink, long j10) throws IOException {
            int i10;
            int i11;
            g.f(sink, "sink");
            do {
                int i12 = this.f11224e;
                h hVar = this.f11220a;
                if (i12 == 0) {
                    hVar.skip(this.h);
                    this.h = 0;
                    if ((this.f11222c & 4) == 0) {
                        i10 = this.f11223d;
                        int iM = i.m(hVar);
                        this.f11224e = iM;
                        this.f11221b = iM;
                        int i13 = hVar.readByte() & 255;
                        this.f11222c = hVar.readByte() & 255;
                        Logger logger = d.f11216d;
                        if (logger.isLoggable(Level.FINE)) {
                            hd.b bVar = hd.b.f9414a;
                            int i14 = this.f11223d;
                            int i15 = this.f11221b;
                            int i16 = this.f11222c;
                            bVar.getClass();
                            logger.fine(hd.b.b(i14, i15, i13, i16, true));
                        }
                        i11 = hVar.readInt() & Integer.MAX_VALUE;
                        this.f11223d = i11;
                        if (i13 != 9) {
                            throw new IOException(i13 + " != TYPE_CONTINUATION");
                        }
                    }
                } else {
                    long j11 = hVar.read(sink, Math.min(j10, i12));
                    if (j11 != -1) {
                        this.f11224e -= (int) j11;
                        return j11;
                    }
                }
                return -1L;
            } while (i11 == i10);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // sd.e0
        public final f0 timeout() {
            return this.f11220a.timeout();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    }
}
