package z2;

import com.google.firebase.encoders.EncodingException;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: z2.c0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6096c0 implements k3.b {

    /* renamed from: d, reason: collision with root package name */
    public static final InterfaceC4766d f44974d = new InterfaceC4766d() { // from class: z2.b0
        @Override // j3.InterfaceC4764b
        public final void a(Object obj, InterfaceC4767e interfaceC4767e) {
            InterfaceC4766d interfaceC4766d = C6096c0.f44974d;
            throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Map f44975a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f44976b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4766d f44977c = f44974d;

    @Override // k3.b
    public final /* bridge */ /* synthetic */ k3.b a(Class cls, InterfaceC4766d interfaceC4766d) {
        this.f44975a.put(cls, interfaceC4766d);
        this.f44976b.remove(cls);
        return this;
    }

    public final C6106d0 b() {
        return new C6106d0(new HashMap(this.f44975a), new HashMap(this.f44976b), this.f44977c);
    }
}
