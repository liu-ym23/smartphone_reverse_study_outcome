package z2;

import com.google.firebase.encoders.EncodingException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import j3.InterfaceC4768f;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: z2.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6076a0 implements InterfaceC4767e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f44951f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f44952g;

    /* renamed from: h, reason: collision with root package name */
    public static final C4765c f44953h;

    /* renamed from: i, reason: collision with root package name */
    public static final InterfaceC4766d f44954i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f44955a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f44956b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f44957c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC4766d f44958d;

    /* renamed from: e, reason: collision with root package name */
    public final C6116e0 f44959e = new C6116e0(this);

    static {
        C4765c.b bVarA = C4765c.a("key");
        V v10 = new V();
        v10.a(1);
        f44952g = bVarA.b(v10.b()).a();
        C4765c.b bVarA2 = C4765c.a(UxipConstants.f30680s);
        V v11 = new V();
        v11.a(2);
        f44953h = bVarA2.b(v11.b()).a();
        f44954i = new InterfaceC4766d() { // from class: z2.Z
            @Override // j3.InterfaceC4764b
            public final void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
                C6076a0.i((Map.Entry) obj, interfaceC4767e);
            }
        };
    }

    public C6076a0(OutputStream outputStream, Map map, Map map2, InterfaceC4766d interfaceC4766d) {
        this.f44955a = outputStream;
        this.f44956b = map;
        this.f44957c = map2;
        this.f44958d = interfaceC4766d;
    }

    public static /* synthetic */ void i(Map.Entry entry, InterfaceC4767e interfaceC4767e) throws IOException {
        interfaceC4767e.a(f44952g, entry.getKey());
        interfaceC4767e.a(f44953h, entry.getValue());
    }

    public static int j(C4765c c4765c) {
        Y y10 = (Y) c4765c.c(Y.class);
        if (y10 != null) {
            return y10.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static Y l(C4765c c4765c) {
        Y y10 = (Y) c4765c.c(Y.class);
        if (y10 != null) {
            return y10;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static ByteBuffer o(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // j3.InterfaceC4767e
    public final InterfaceC4767e a(C4765c c4765c, Object obj) throws IOException {
        e(c4765c, obj, true);
        return this;
    }

    @Override // j3.InterfaceC4767e
    public final /* synthetic */ InterfaceC4767e b(C4765c c4765c, long j10) throws IOException {
        g(c4765c, j10, true);
        return this;
    }

    public final InterfaceC4767e c(C4765c c4765c, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        p((j(c4765c) << 3) | 1);
        this.f44955a.write(o(8).putDouble(d10).array());
        return this;
    }

    public final InterfaceC4767e d(C4765c c4765c, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        p((j(c4765c) << 3) | 5);
        this.f44955a.write(o(4).putFloat(f10).array());
        return this;
    }

    public final InterfaceC4767e e(C4765c c4765c, Object obj, boolean z10) throws IOException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z10 || charSequence.length() != 0) {
                    p((j(c4765c) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f44951f);
                    p(bytes.length);
                    this.f44955a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(c4765c, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    m(f44954i, c4765c, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    c(c4765c, ((Double) obj).doubleValue(), z10);
                    return this;
                }
                if (obj instanceof Float) {
                    d(c4765c, ((Float) obj).floatValue(), z10);
                    return this;
                }
                if (obj instanceof Number) {
                    g(c4765c, ((Number) obj).longValue(), z10);
                    return this;
                }
                if (obj instanceof Boolean) {
                    f(c4765c, ((Boolean) obj).booleanValue() ? 1 : 0, z10);
                    return this;
                }
                if (!(obj instanceof byte[])) {
                    InterfaceC4766d interfaceC4766d = (InterfaceC4766d) this.f44956b.get(obj.getClass());
                    if (interfaceC4766d != null) {
                        m(interfaceC4766d, c4765c, obj, z10);
                        return this;
                    }
                    InterfaceC4768f interfaceC4768f = (InterfaceC4768f) this.f44957c.get(obj.getClass());
                    if (interfaceC4768f != null) {
                        n(interfaceC4768f, c4765c, obj, z10);
                        return this;
                    }
                    if (obj instanceof X) {
                        f(c4765c, ((X) obj).zza(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        f(c4765c, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    m(this.f44958d, c4765c, obj, z10);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z10 || bArr.length != 0) {
                    p((j(c4765c) << 3) | 2);
                    p(bArr.length);
                    this.f44955a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    public final C6076a0 f(C4765c c4765c, int i10, boolean z10) throws IOException {
        if (!z10 || i10 != 0) {
            Y yL = l(c4765c);
            int iOrdinal = yL.zzb().ordinal();
            if (iOrdinal == 0) {
                p(yL.zza() << 3);
                p(i10);
                return this;
            }
            if (iOrdinal == 1) {
                p(yL.zza() << 3);
                p((i10 + i10) ^ (i10 >> 31));
                return this;
            }
            if (iOrdinal == 2) {
                p((yL.zza() << 3) | 5);
                this.f44955a.write(o(4).putInt(i10).array());
                return this;
            }
        }
        return this;
    }

    public final C6076a0 g(C4765c c4765c, long j10, boolean z10) throws IOException {
        if (!z10 || j10 != 0) {
            Y yL = l(c4765c);
            int iOrdinal = yL.zzb().ordinal();
            if (iOrdinal == 0) {
                p(yL.zza() << 3);
                q(j10);
                return this;
            }
            if (iOrdinal == 1) {
                p(yL.zza() << 3);
                q((j10 >> 63) ^ (j10 + j10));
                return this;
            }
            if (iOrdinal == 2) {
                p((yL.zza() << 3) | 1);
                this.f44955a.write(o(8).putLong(j10).array());
                return this;
            }
        }
        return this;
    }

    public final C6076a0 h(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        InterfaceC4766d interfaceC4766d = (InterfaceC4766d) this.f44956b.get(obj.getClass());
        if (interfaceC4766d == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        interfaceC4766d.a(obj, this);
        return this;
    }

    public final long k(InterfaceC4766d interfaceC4766d, Object obj) throws IOException {
        W w10 = new W();
        try {
            OutputStream outputStream = this.f44955a;
            this.f44955a = w10;
            try {
                interfaceC4766d.a(obj, this);
                this.f44955a = outputStream;
                long jB = w10.b();
                w10.close();
                return jB;
            } catch (Throwable th) {
                this.f44955a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                w10.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final C6076a0 m(InterfaceC4766d interfaceC4766d, C4765c c4765c, Object obj, boolean z10) throws IOException {
        long jK = k(interfaceC4766d, obj);
        if (z10 && jK == 0) {
            return this;
        }
        p((j(c4765c) << 3) | 2);
        q(jK);
        interfaceC4766d.a(obj, this);
        return this;
    }

    public final C6076a0 n(InterfaceC4768f interfaceC4768f, C4765c c4765c, Object obj, boolean z10) throws IOException {
        this.f44959e.a(c4765c, z10);
        interfaceC4768f.a(obj, this.f44959e);
        return this;
    }

    public final void p(int i10) throws IOException {
        while (true) {
            int i11 = i10 & 127;
            if ((i10 & (-128)) == 0) {
                this.f44955a.write(i11);
                return;
            } else {
                this.f44955a.write(i11 | 128);
                i10 >>>= 7;
            }
        }
    }

    public final void q(long j10) throws IOException {
        while (true) {
            int i10 = ((int) j10) & 127;
            if (((-128) & j10) == 0) {
                this.f44955a.write(i10);
                return;
            } else {
                this.f44955a.write(i10 | 128);
                j10 >>>= 7;
            }
        }
    }
}
