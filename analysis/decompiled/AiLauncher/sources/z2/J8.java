package z2;

import android.content.Context;
import c2.C1489a;
import h3.C4142r;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public final class J8 implements InterfaceC6254r8 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC4938b f44709a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4938b f44710b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC6274t8 f44711c;

    public J8(Context context, AbstractC6274t8 abstractC6274t8) {
        this.f44711c = abstractC6274t8;
        C1489a c1489a = C1489a.f15422g;
        e2.r.f(context);
        final b2.f fVarG = e2.r.c().g(c1489a);
        if (c1489a.a().contains(b2.b.b("json"))) {
            this.f44709a = new C4142r(new InterfaceC4938b() { // from class: z2.G8
                @Override // n3.InterfaceC4938b
                public final Object get() {
                    return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("json"), new b2.d() { // from class: z2.I8
                        @Override // b2.d
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f44710b = new C4142r(new InterfaceC4938b() { // from class: z2.H8
            @Override // n3.InterfaceC4938b
            public final Object get() {
                return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("proto"), new b2.d() { // from class: z2.F8
                    @Override // b2.d
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    public static b2.c b(AbstractC6274t8 abstractC6274t8, InterfaceC6244q8 interfaceC6244q8) {
        int iA = abstractC6274t8.a();
        return interfaceC6244q8.zza() != 0 ? b2.c.d(interfaceC6244q8.a(iA, false)) : b2.c.e(interfaceC6244q8.a(iA, false));
    }

    @Override // z2.InterfaceC6254r8
    public final void a(InterfaceC6244q8 interfaceC6244q8) {
        if (this.f44711c.a() != 0) {
            ((b2.e) this.f44710b.get()).a(b(this.f44711c, interfaceC6244q8));
            return;
        }
        InterfaceC4938b interfaceC4938b = this.f44709a;
        if (interfaceC4938b != null) {
            ((b2.e) interfaceC4938b.get()).a(b(this.f44711c, interfaceC6244q8));
        }
    }
}
