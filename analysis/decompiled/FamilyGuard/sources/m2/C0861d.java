package m2;

import R4.u;
import S4.h;
import com.stepos.familyguard.net.entity.BaseEntity;
import n2.C0874a;
import n2.C0877d;
import n2.C0878e;
import n2.C0879f;
import n2.C0880g;
import o2.InterfaceC0901b;

/* renamed from: m2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0861d {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0859b f18811a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2.d$a */
    static class a implements InterfaceC0859b {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0864g f18812a;

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> void g(BaseEntity<T> baseEntity) {
            if (baseEntity == null) {
                throw new C0877d(0, null);
            }
            int i5 = baseEntity.code;
            if (i5 != 200) {
                throw new C0877d(C0858a.e(i5, baseEntity.message), baseEntity.message);
            }
        }

        @Override // m2.InterfaceC0859b
        public x3.f<BaseEntity<String>> a(String str, long j5) {
            return this.f18812a.a(C0880g.k().a("phone", str).a("smsType", 2).a("underagId", Long.valueOf(j5)).b()).o(new C0860c());
        }

        @Override // m2.InterfaceC0859b
        public x3.f<BaseEntity<String>> b(String str) {
            return this.f18812a.a(C0880g.k().a("phone", str).a("smsType", 1).b()).o(new C0860c());
        }

        @Override // m2.InterfaceC0859b
        public x3.f<BaseEntity<String>> c(String str, long j5) {
            return this.f18812a.a(C0880g.k().a("phone", str).a("smsType", 3).a("underagId", Long.valueOf(j5)).b()).o(new C0860c());
        }

        @Override // m2.InterfaceC0859b
        public x3.f<BaseEntity<Long>> d(int i5, String str, long j5, String str2) {
            return this.f18812a.c(C0880g.k().a("smsType", Integer.valueOf(i5)).a("phone", str).a("underagId", Long.valueOf(j5)).a("code", str2).b()).o(new C0860c());
        }

        @Override // m2.InterfaceC0859b
        public x3.f<BaseEntity<String>> e(long j5, String str) {
            return this.f18812a.b(C0880g.k().a("relationId", Long.valueOf(j5)).a("content", str).b()).o(new C0860c());
        }

        private a() {
            this(false);
        }

        private a(boolean z5) {
            InterfaceC0901b interfaceC0901bA;
            try {
                interfaceC0901bA = o2.c.a();
            } catch (Exception e6) {
                e6.printStackTrace();
                interfaceC0901bA = null;
            }
            this.f18812a = (InterfaceC0864g) new u.b().d(C0863f.b()).g(C0878e.b(interfaceC0901bA, new C0879f("FamilyGuardServer", z5))).b(C0874a.f("FamilyGuardServer")).a(h.d()).e().c(InterfaceC0864g.class);
        }
    }

    public static synchronized InterfaceC0859b a() {
        try {
            if (f18811a == null) {
                f18811a = new a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f18811a;
    }
}
