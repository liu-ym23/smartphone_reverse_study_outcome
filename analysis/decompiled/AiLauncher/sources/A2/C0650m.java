package A2;

import com.google.firebase.encoders.EncodingException;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: A2.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0650m implements k3.b {

    /* renamed from: d, reason: collision with root package name */
    public static final InterfaceC4766d f774d = new InterfaceC4766d() { // from class: A2.l
        @Override // j3.InterfaceC4764b
        public final void a(Object obj, InterfaceC4767e interfaceC4767e) {
            InterfaceC4766d interfaceC4766d = C0650m.f774d;
            throw new EncodingException("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Map f775a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f776b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4766d f777c = f774d;

    @Override // k3.b
    public final /* bridge */ /* synthetic */ k3.b a(Class cls, InterfaceC4766d interfaceC4766d) {
        this.f775a.put(cls, interfaceC4766d);
        this.f776b.remove(cls);
        return this;
    }

    public final C0656n b() {
        return new C0656n(new HashMap(this.f775a), new HashMap(this.f776b), this.f777c);
    }
}
