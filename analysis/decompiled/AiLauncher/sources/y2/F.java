package y2;

import android.content.Context;
import c2.C1489a;
import h3.C4142r;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public final class F implements t {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC4938b f43813a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4938b f43814b;

    /* renamed from: c, reason: collision with root package name */
    public final w f43815c;

    public F(Context context, w wVar) {
        this.f43815c = wVar;
        C1489a c1489a = C1489a.f15422g;
        e2.r.f(context);
        final b2.f fVarG = e2.r.c().g(c1489a);
        if (c1489a.a().contains(b2.b.b("json"))) {
            this.f43813a = new C4142r(new InterfaceC4938b() { // from class: y2.C
                @Override // n3.InterfaceC4938b
                public final Object get() {
                    return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("json"), new b2.d() { // from class: y2.E
                        @Override // b2.d
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f43814b = new C4142r(new InterfaceC4938b() { // from class: y2.D
            @Override // n3.InterfaceC4938b
            public final Object get() {
                return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("proto"), new b2.d() { // from class: y2.B
                    @Override // b2.d
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }
}
