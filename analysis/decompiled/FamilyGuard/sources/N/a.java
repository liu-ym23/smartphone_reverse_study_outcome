package N;

import W3.C0403n;
import android.content.Context;
import com.stepos.minor.Minor;
import i4.InterfaceC0772l;
import j4.k;
import j4.l;
import java.util.List;
import m4.InterfaceC0868a;
import s4.F0;
import s4.I;
import s4.J;
import s4.W;

/* loaded from: classes.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N.a$a, reason: collision with other inner class name */
    public static final class C0061a extends l implements InterfaceC0772l<Context, List<? extends L.d<O.d>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0061a f4162a = new C0061a();

        C0061a() {
            super(1);
        }

        @Override // i4.InterfaceC0772l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List<L.d<O.d>> invoke(Context context) {
            k.g(context, "it");
            return C0403n.h();
        }
    }

    public static final InterfaceC0868a<Context, L.f<O.d>> a(String str, M.b<O.d> bVar, InterfaceC0772l<? super Context, ? extends List<? extends L.d<O.d>>> interfaceC0772l, I i5) {
        k.g(str, Minor.COLUMN_NAME);
        k.g(interfaceC0772l, "produceMigrations");
        k.g(i5, "scope");
        return new c(str, bVar, interfaceC0772l, i5);
    }

    public static /* synthetic */ InterfaceC0868a b(String str, M.b bVar, InterfaceC0772l interfaceC0772l, I i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            bVar = null;
        }
        if ((i6 & 4) != 0) {
            interfaceC0772l = C0061a.f4162a;
        }
        if ((i6 & 8) != 0) {
            i5 = J.a(W.b().C(F0.b(null, 1, null)));
        }
        return a(str, bVar, interfaceC0772l, i5);
    }
}
