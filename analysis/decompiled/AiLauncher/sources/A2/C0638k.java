package A2;

import com.google.android.gms.internal.mlkit_vision_common.zzah;
import com.google.firebase.encoders.EncodingException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import j3.InterfaceC4768f;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: A2.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0638k implements InterfaceC4767e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f739f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final C4765c f740g;

    /* renamed from: h, reason: collision with root package name */
    public static final C4765c f741h;

    /* renamed from: i, reason: collision with root package name */
    public static final InterfaceC4766d f742i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f743a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f744b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f745c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC4766d f746d;

    /* renamed from: e, reason: collision with root package name */
    public final C0662o f747e = new C0662o(this);

    static {
        C4765c.b bVarA = C4765c.a("key");
        C0604f c0604f = new C0604f();
        c0604f.a(1);
        f740g = bVarA.b(c0604f.b()).a();
        C4765c.b bVarA2 = C4765c.a(UxipConstants.f30680s);
        C0604f c0604f2 = new C0604f();
        c0604f2.a(2);
        f741h = bVarA2.b(c0604f2.b()).a();
        f742i = new InterfaceC4766d() { // from class: A2.j
            @Override // j3.InterfaceC4764b
            public final void a(Object obj, InterfaceC4767e interfaceC4767e) throws IOException {
                C0638k.i((Map.Entry) obj, interfaceC4767e);
            }
        };
    }

    public C0638k(OutputStream outputStream, Map map, Map map2, InterfaceC4766d interfaceC4766d) {
        this.f743a = outputStream;
        this.f744b = map;
        this.f745c = map2;
        this.f746d = interfaceC4766d;
    }

    public static /* synthetic */ void i(Map.Entry entry, InterfaceC4767e interfaceC4767e) throws IOException {
        interfaceC4767e.a(f740g, entry.getKey());
        interfaceC4767e.a(f741h, entry.getValue());
    }

    private static int j(C4765c c4765c) {
        InterfaceC0625i interfaceC0625i = (InterfaceC0625i) c4765c.c(InterfaceC0625i.class);
        if (interfaceC0625i != null) {
            return interfaceC0625i.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long k(InterfaceC4766d interfaceC4766d, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C0611g c0611g = new C0611g();
        try {
            OutputStream outputStream = this.f743a;
            this.f743a = c0611g;
            try {
                interfaceC4766d.a(obj, this);
                this.f743a = outputStream;
                long jB = c0611g.b();
                c0611g.close();
                return jB;
            } catch (Throwable th) {
                this.f743a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c0611g.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    public static InterfaceC0625i l(C4765c c4765c) {
        InterfaceC0625i interfaceC0625i = (InterfaceC0625i) c4765c.c(InterfaceC0625i.class);
        if (interfaceC0625i != null) {
            return interfaceC0625i;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static ByteBuffer o(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void p(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f743a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f743a.write(i10 & 127);
    }

    private final void q(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f743a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f743a.write(((int) j10) & 127);
    }

    @Override // j3.InterfaceC4767e
    public final InterfaceC4767e a(C4765c c4765c, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
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
        this.f743a.write(o(8).putDouble(d10).array());
        return this;
    }

    public final InterfaceC4767e d(C4765c c4765c, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        p((j(c4765c) << 3) | 5);
        this.f743a.write(o(4).putFloat(f10).array());
        return this;
    }

    public final InterfaceC4767e e(C4765c c4765c, Object obj, boolean z10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z10 || charSequence.length() != 0) {
                    p((j(c4765c) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f739f);
                    p(bytes.length);
                    this.f743a.write(bytes);
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
                    m(f742i, c4765c, (Map.Entry) it2.next(), false);
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
                    InterfaceC4766d interfaceC4766d = (InterfaceC4766d) this.f744b.get(obj.getClass());
                    if (interfaceC4766d != null) {
                        m(interfaceC4766d, c4765c, obj, z10);
                        return this;
                    }
                    InterfaceC4768f interfaceC4768f = (InterfaceC4768f) this.f745c.get(obj.getClass());
                    if (interfaceC4768f != null) {
                        n(interfaceC4768f, c4765c, obj, z10);
                        return this;
                    }
                    if (obj instanceof InterfaceC0618h) {
                        f(c4765c, ((InterfaceC0618h) obj).zza(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        f(c4765c, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    m(this.f746d, c4765c, obj, z10);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z10 || bArr.length != 0) {
                    p((j(c4765c) << 3) | 2);
                    p(bArr.length);
                    this.f743a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    public final C0638k f(C4765c c4765c, int i10, boolean z10) throws IOException {
        if (!z10 || i10 != 0) {
            InterfaceC0625i interfaceC0625iL = l(c4765c);
            zzah zzahVar = zzah.DEFAULT;
            int iOrdinal = interfaceC0625iL.zzb().ordinal();
            if (iOrdinal == 0) {
                p(interfaceC0625iL.zza() << 3);
                p(i10);
                return this;
            }
            if (iOrdinal == 1) {
                p(interfaceC0625iL.zza() << 3);
                p((i10 + i10) ^ (i10 >> 31));
                return this;
            }
            if (iOrdinal == 2) {
                p((interfaceC0625iL.zza() << 3) | 5);
                this.f743a.write(o(4).putInt(i10).array());
                return this;
            }
        }
        return this;
    }

    public final C0638k g(C4765c c4765c, long j10, boolean z10) throws IOException {
        if (!z10 || j10 != 0) {
            InterfaceC0625i interfaceC0625iL = l(c4765c);
            zzah zzahVar = zzah.DEFAULT;
            int iOrdinal = interfaceC0625iL.zzb().ordinal();
            if (iOrdinal == 0) {
                p(interfaceC0625iL.zza() << 3);
                q(j10);
                return this;
            }
            if (iOrdinal == 1) {
                p(interfaceC0625iL.zza() << 3);
                q((j10 >> 63) ^ (j10 + j10));
                return this;
            }
            if (iOrdinal == 2) {
                p((interfaceC0625iL.zza() << 3) | 1);
                this.f743a.write(o(8).putLong(j10).array());
                return this;
            }
        }
        return this;
    }

    public final C0638k h(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        InterfaceC4766d interfaceC4766d = (InterfaceC4766d) this.f744b.get(obj.getClass());
        if (interfaceC4766d == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        interfaceC4766d.a(obj, this);
        return this;
    }

    public final C0638k m(InterfaceC4766d interfaceC4766d, C4765c c4765c, Object obj, boolean z10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jK = k(interfaceC4766d, obj);
        if (z10 && jK == 0) {
            return this;
        }
        p((j(c4765c) << 3) | 2);
        q(jK);
        interfaceC4766d.a(obj, this);
        return this;
    }

    public final C0638k n(InterfaceC4768f interfaceC4768f, C4765c c4765c, Object obj, boolean z10) throws IOException {
        this.f747e.a(c4765c, z10);
        interfaceC4768f.a(obj, this.f747e);
        return this;
    }
}
