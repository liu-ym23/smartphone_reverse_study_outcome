package x2;

import java.io.CharConversionException;
import java.io.Reader;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public final b f13731a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f13732b;

    /* renamed from: c, reason: collision with root package name */
    public int f13733c;

    /* renamed from: d, reason: collision with root package name */
    public int f13734d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13735e;

    /* renamed from: j, reason: collision with root package name */
    public int f13736j;

    /* renamed from: k, reason: collision with root package name */
    public int f13737k;

    /* renamed from: m, reason: collision with root package name */
    public char[] f13739m;
    public char h = 0;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f13738l = false;

    public g(b bVar, byte[] bArr, int i10, int i11, boolean z) {
        this.f13731a = bVar;
        this.f13732b = bArr;
        this.f13733c = i10;
        this.f13734d = i11;
        this.f13735e = z;
    }

    public final void a(int i10) throws CharConversionException {
        throw new CharConversionException(ai.onnxruntime.a.j(")", this.f13737k + i10, h0.e.d(i10, "Unexpected EOF in the middle of a 4-byte UTF-32 char: got ", this.f13736j, ", needed 4, at char #", ", byte #")));
    }

    @Override // java.io.Reader
    public final int read() {
        if (this.f13739m == null) {
            this.f13739m = new char[1];
        }
        if (read(this.f13739m, 0, 1) < 1) {
            return -1;
        }
        return this.f13739m[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0130 A[LOOP:0: B:39:0x006c->B:58:0x0130, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d8 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(char[] r11, int r12, int r13) throws java.io.CharConversionException {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.g.read(char[], int, int):int");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
