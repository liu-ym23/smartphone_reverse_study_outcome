package ce5;

import android.app.Application;
import by4.d;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f23445h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f23446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserSession f23447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetService f23448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f23449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f23450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f23451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BenefitManagerAPI f23452g;

    /* JADX INFO: renamed from: ce5.a$a, reason: collision with other inner class name */
    public static final class C0436a implements d0c.c {
        public C0436a() {
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(f0c.h r100) {
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
        public final void onUserOffline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // d0c.c
        public final UserSession e9() {
            return ((com.ss.android.lark.passportc.convention.a) k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
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

    public static final class b implements d0c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vo5.a f23453a;

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOffline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void afterUserOnline(f0c.h r100) {
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
        public final void onUserOffline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // com.ss.android.lark.passportc.api.o
        public final void onUserOnline(f0c.h r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // d0c.c
        public final UserSession e9() {
            return this.f23453a.b();
        }

        @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
        public final l provideComponent() {
            UserSession r100 = e9();
            Application r101 = LarkContext.getApplication();
            Intrinsics.checkNotNull(r101);
            return ((v) k.a(r101, v.class)).c(r100);
        }

        @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
        public final /* bridge */ /* synthetic */ Object provideComponent() {
            return provideComponent();
        }

        public b(vo5.a r100) {
            this.f23453a = r100;
        }
    }

    public static final class c {
    }

    static {
    }

    public a() {
        this(new C0436a());
    }

    public a(d0c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeView");
        this.f23446a = r100.provideComponent();
        this.f23447b = r100.e9();
        this.f23448c = (NetService) a(NetService.class);
        this.f23449d = ((dn4.a) a(dn4.a.class)).a();
        this.f23450e = (h) a(h.class);
        this.f23451f = (d) a(d.class);
        this.f23452g = (BenefitManagerAPI) a(BenefitManagerAPI.class);
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        return (T) k.b(this.f23446a, r100);
    }

    public a(vo5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        this(new b(r100));
    }
}
