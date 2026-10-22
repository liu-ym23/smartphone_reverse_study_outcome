package p0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import m0.InterfaceC0854b;
import o0.C0888a;
import o0.C0895h;
import o0.C0896i;
import u0.C1154d;

/* renamed from: p0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0919f extends l {

    /* renamed from: c, reason: collision with root package name */
    protected t f19295c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f19296d;

    public C0919f(C0896i c0896i, Class<?> cls, C1154d c1154d) {
        super(cls, c1154d);
        boolean z5 = false;
        this.f19296d = false;
        InterfaceC0854b interfaceC0854bG = c1154d.g();
        if (interfaceC0854bG != null) {
            Class<?> clsDeserializeUsing = interfaceC0854bG.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != Void.class) {
                z5 = true;
            }
            this.f19296d = z5;
        }
    }

    @Override // p0.l
    public int b() {
        t tVar = this.f19295c;
        if (tVar != null) {
            return tVar.d();
        }
        return 2;
    }

    @Override // p0.l
    public void d(C0888a c0888a, Object obj, Type type, Map<String, Object> map) throws IOException {
        C0888a c0888a2;
        Object objF;
        C1154d c1154d;
        int i5;
        if (this.f19295c == null) {
            k(c0888a.u());
        }
        t tVarO = this.f19295c;
        Type typeK = this.f19303a.f22735f;
        if (type instanceof ParameterizedType) {
            C0895h c0895hV = c0888a.v();
            if (c0895hV != null) {
                c0895hV.f19021e = type;
            }
            if (typeK != type) {
                typeK = C1154d.k(this.f19304b, type, typeK);
                if (tVarO instanceof p) {
                    tVarO = c0888a.u().o(typeK);
                }
            }
        }
        Type type2 = typeK;
        if (!(tVarO instanceof o) || (i5 = (c1154d = this.f19303a).f22739j) == 0) {
            C1154d c1154d2 = this.f19303a;
            String str = c1154d2.f22749t;
            if (!(str == null && c1154d2.f22739j == 0) && (tVarO instanceof AbstractC0918e)) {
                c0888a2 = c0888a;
                objF = ((AbstractC0918e) tVarO).f(c0888a2, type2, c1154d2.f22730a, str, c1154d2.f22739j);
            } else {
                c0888a2 = c0888a;
                objF = tVarO.e(c0888a2, type2, c1154d2.f22730a);
            }
        } else {
            objF = ((o) tVarO).h(c0888a, type2, c1154d.f22730a, i5);
            c0888a2 = c0888a;
        }
        if ((objF instanceof byte[]) && ("gzip".equals(this.f19303a.f22749t) || "gzip,base64".equals(this.f19303a.f22749t))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) objF));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i6 = gZIPInputStream.read(bArr);
                    if (i6 == -1) {
                        break;
                    } else if (i6 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i6);
                    }
                }
                objF = byteArrayOutputStream.toByteArray();
            } catch (IOException e6) {
                throw new l0.d("unzip bytes error.", e6);
            }
        }
        if (c0888a2.I() == 1) {
            C0888a.C0227a c0227aE = c0888a2.E();
            c0227aE.f18961c = this;
            c0227aE.f18962d = c0888a2.v();
            c0888a2.C0(0);
            return;
        }
        if (obj == null) {
            map.put(this.f19303a.f22730a, objF);
        } else {
            h(obj, objF);
        }
    }

    public t k(C0896i c0896i) {
        if (this.f19295c == null) {
            InterfaceC0854b interfaceC0854bG = this.f19303a.g();
            if (interfaceC0854bG == null || interfaceC0854bG.deserializeUsing() == Void.class) {
                C1154d c1154d = this.f19303a;
                this.f19295c = c0896i.n(c1154d.f22734e, c1154d.f22735f);
            } else {
                try {
                    this.f19295c = (t) interfaceC0854bG.deserializeUsing().newInstance();
                } catch (Exception e6) {
                    throw new l0.d("create deserializeUsing ObjectDeserializer error", e6);
                }
            }
        }
        return this.f19295c;
    }
}
