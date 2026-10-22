package bmb;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f19669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f19670b;

    /* JADX INFO: renamed from: bmb.a$a, reason: collision with other inner class name */
    public static final class C0316a implements c {
        public C0316a() {
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.CC.$default$generatedComponent(this);
        }

        @Override // com.ss.android.lark.passportc.api.r
        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOffline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // d0c.c
        public final UserSession e9() {
            return ((j) k.a(LarkContext.getApplication(), j.class)).f();
        }

        @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
        public final l provideComponent() {
            UserSession r100 = e9();
            return ((v) k.a(LarkContext.getApplication(), v.class)).c(r100);
        }

        @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
        public final /* bridge */ /* synthetic */ Object provideComponent() {
            return provideComponent();
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
        C0316a r100 = new C0316a();
        Intrinsics.checkNotNullParameter(r100, "userScopeView");
        l r101 = r100.provideComponent();
        this.f19669a = r101;
        r100.e9();
        Intrinsics.checkNotNullParameter(dn4.a.class, "userScopeApi");
        this.f19670b = ((dn4.a) k.b(r101, dn4.a.class)).a();
    }
}
