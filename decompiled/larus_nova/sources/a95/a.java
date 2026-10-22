package a95;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import jdb.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2276d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vo5.a f2277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserSession f2278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f2279c;

    /* JADX INFO: renamed from: a95.a$a, reason: collision with other inner class name */
    public static final class C0032a implements vo5.a {
        public C0032a() {
        }

        @Override // vo5.a
        public final UserSession b() {
            return ((com.ss.android.lark.passportc.convention.a) k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
        }

        @Override // vo5.a
        public final <T> T a(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "userScopeApi");
            UserSession r101 = b();
            return (T) k.b(((v) k.a(LarkContext.getApplication(), v.class)).c(r101), r100);
        }
    }

    public static final class b {
        @JvmStatic
        public static a a(a r100) {
            if (r100 != null) goto L4;
            tt5.a.d("DriveUserComponentAbility", "provideUserComponent empty ability");
        L4:
            if (r100 == null) goto L6;
            return r100;
        L6:
            return new a();
        }
    }

    static {
    }

    public a() {
        this(new C0032a());
    }

    public a(vo5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentDelegate");
        this.f2277a = r100;
        this.f2278b = r100.b();
        this.f2279c = ((dn4.a) a(dn4.a.class)).a();
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "userScopeApi");
        return (T) this.f2277a.a(r100);
    }
}
