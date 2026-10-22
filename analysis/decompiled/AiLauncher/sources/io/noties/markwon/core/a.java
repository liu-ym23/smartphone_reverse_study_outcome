package io.noties.markwon.core;

import Yb.A;
import Yb.AbstractC1128b;
import Yb.q;
import Yb.s;
import Yb.t;
import Yb.v;
import Yb.w;
import Yb.x;
import Yb.y;
import Yb.z;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import io.noties.markwon.core.CoreProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u8.AbstractC5589a;
import u8.k;
import u8.m;
import u8.r;
import u8.u;
import w8.C5741a;

/* loaded from: classes4.dex */
public class a extends AbstractC5589a {

    /* renamed from: a, reason: collision with root package name */
    public final List<p> f34207a = new ArrayList(0);

    /* renamed from: b, reason: collision with root package name */
    public boolean f34208b;

    /* renamed from: io.noties.markwon.core.a$a, reason: collision with other inner class name */
    public class C0417a implements m.c<A> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, A a10) {
            mVar.q(a10);
            int length = mVar.length();
            mVar.builder().append((char) 160);
            mVar.F(a10, length);
            mVar.v(a10);
        }
    }

    public class b implements m.c<Yb.l> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.l lVar) {
            mVar.q(lVar);
            int length = mVar.length();
            mVar.g(lVar);
            CoreProps.f34203d.e(mVar.r(), Integer.valueOf(lVar.n()));
            mVar.F(lVar, length);
            mVar.v(lVar);
        }
    }

    public class c implements m.c<x> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, x xVar) {
            mVar.builder().append(' ');
        }
    }

    public class d implements m.c<Yb.k> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.k kVar) {
            mVar.C();
        }
    }

    public class e implements m.c<w> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, w wVar) {
            boolean z10 = a.z(wVar);
            if (!z10) {
                mVar.q(wVar);
            }
            int length = mVar.length();
            mVar.g(wVar);
            CoreProps.f34205f.e(mVar.r(), Boolean.valueOf(z10));
            mVar.F(wVar, length);
            if (z10) {
                return;
            }
            mVar.v(wVar);
        }
    }

    public class f implements m.c<q> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, q qVar) {
            int length = mVar.length();
            mVar.g(qVar);
            CoreProps.f34204e.e(mVar.r(), qVar.m());
            mVar.F(qVar, length);
        }
    }

    public class g implements m.c<z> {
        public g() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, z zVar) {
            String strM = zVar.m();
            mVar.builder().d(strM);
            if (a.this.f34207a.isEmpty()) {
                return;
            }
            int length = mVar.length() - strM.length();
            Iterator it = a.this.f34207a.iterator();
            while (it.hasNext()) {
                ((p) it.next()).a(mVar, strM, length);
            }
        }
    }

    public class h implements m.c<y> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, y yVar) {
            int length = mVar.length();
            mVar.g(yVar);
            mVar.F(yVar, length);
        }
    }

    public class i implements m.c<Yb.i> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.i iVar) {
            int length = mVar.length();
            mVar.g(iVar);
            mVar.F(iVar, length);
        }
    }

    public class j implements m.c<Yb.c> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.c cVar) {
            mVar.q(cVar);
            int length = mVar.length();
            mVar.g(cVar);
            mVar.F(cVar, length);
            mVar.v(cVar);
        }
    }

    public class k implements m.c<Yb.e> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.e eVar) {
            int length = mVar.length();
            mVar.builder().append((char) 160).d(eVar.m()).append((char) 160);
            mVar.F(eVar, length);
        }
    }

    public class l implements m.c<Yb.j> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.j jVar) {
            a.J(mVar, jVar.q(), jVar.r(), jVar);
        }
    }

    public class m implements m.c<Yb.p> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.p pVar) {
            a.J(mVar, null, pVar.n(), pVar);
        }
    }

    public class n implements m.c<Yb.o> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.o oVar) {
            u uVar = mVar.z().e().get(Yb.o.class);
            if (uVar == null) {
                mVar.g(oVar);
                return;
            }
            int length = mVar.length();
            mVar.g(oVar);
            if (length == mVar.length()) {
                mVar.builder().append((char) 65532);
            }
            u8.g gVarZ = mVar.z();
            boolean z10 = oVar.f() instanceof q;
            String strB = gVarZ.b().b(oVar.m());
            r rVarR = mVar.r();
            io.noties.markwon.image.g.f34287a.e(rVarR, strB);
            io.noties.markwon.image.g.f34288b.e(rVarR, Boolean.valueOf(z10));
            io.noties.markwon.image.g.f34289c.e(rVarR, null);
            mVar.d(length, uVar.a(gVarZ, rVarR));
        }
    }

    public class o implements m.c<t> {
        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, t tVar) {
            int length = mVar.length();
            mVar.g(tVar);
            AbstractC1128b abstractC1128bF = tVar.f();
            if (abstractC1128bF instanceof v) {
                v vVar = (v) abstractC1128bF;
                int iQ = vVar.q();
                CoreProps.f34200a.e(mVar.r(), CoreProps.ListItemType.ORDERED);
                CoreProps.f34202c.e(mVar.r(), Integer.valueOf(iQ));
                vVar.s(vVar.q() + 1);
            } else {
                CoreProps.f34200a.e(mVar.r(), CoreProps.ListItemType.BULLET);
                CoreProps.f34201b.e(mVar.r(), Integer.valueOf(a.C(tVar)));
            }
            mVar.F(tVar, length);
            if (mVar.h(tVar)) {
                mVar.C();
            }
        }
    }

    public interface p {
        void a(u8.m mVar, String str, int i10);
    }

    public static void A(m.b bVar) {
        bVar.a(q.class, new f());
    }

    public static void B(m.b bVar) {
        bVar.a(t.class, new o());
    }

    public static int C(Yb.u uVar) {
        int i10 = 0;
        for (Yb.u uVarF = uVar.f(); uVarF != null; uVarF = uVarF.f()) {
            if (uVarF instanceof t) {
                i10++;
            }
        }
        return i10;
    }

    public static void D(m.b bVar) {
        bVar.a(v.class, new v8.b());
    }

    public static void E(m.b bVar) {
        bVar.a(w.class, new e());
    }

    public static void F(m.b bVar) {
        bVar.a(x.class, new c());
    }

    public static void G(m.b bVar) {
        bVar.a(y.class, new h());
    }

    public static void I(m.b bVar) {
        bVar.a(A.class, new C0417a());
    }

    public static void J(u8.m mVar, String str, String str2, Yb.u uVar) {
        mVar.q(uVar);
        int length = mVar.length();
        mVar.builder().append((char) 160).append('\n').append(mVar.z().f().a(str, str2));
        mVar.C();
        mVar.builder().append((char) 160);
        CoreProps.f34206g.e(mVar.r(), str);
        mVar.F(uVar, length);
        mVar.v(uVar);
    }

    public static void p(m.b bVar) {
        bVar.a(Yb.c.class, new j());
    }

    public static void q(m.b bVar) {
        bVar.a(Yb.d.class, new v8.b());
    }

    public static void r(m.b bVar) {
        bVar.a(Yb.e.class, new k());
    }

    public static a s() {
        return new a();
    }

    public static void t(m.b bVar) {
        bVar.a(Yb.i.class, new i());
    }

    public static void u(m.b bVar) {
        bVar.a(Yb.j.class, new l());
    }

    public static void v(m.b bVar) {
        bVar.a(Yb.k.class, new d());
    }

    public static void w(m.b bVar) {
        bVar.a(Yb.l.class, new b());
    }

    public static void x(m.b bVar) {
        bVar.a(Yb.o.class, new n());
    }

    public static void y(m.b bVar) {
        bVar.a(Yb.p.class, new m());
    }

    public static boolean z(w wVar) {
        AbstractC1128b abstractC1128bF = wVar.f();
        if (abstractC1128bF == null) {
            return false;
        }
        Yb.u uVarF = abstractC1128bF.f();
        if (uVarF instanceof s) {
            return ((s) uVarF).n();
        }
        return false;
    }

    public final void H(m.b bVar) {
        bVar.a(z.class, new g());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void a(k.a aVar) {
        w8.b bVar = new w8.b();
        aVar.a(y.class, new w8.h()).a(Yb.i.class, new w8.d()).a(Yb.c.class, new C5741a()).a(Yb.e.class, new w8.c()).a(Yb.j.class, bVar).a(Yb.p.class, bVar).a(t.class, new w8.g()).a(Yb.l.class, new w8.e()).a(q.class, new w8.f()).a(A.class, new w8.i());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        H(bVar);
        G(bVar);
        t(bVar);
        p(bVar);
        r(bVar);
        u(bVar);
        y(bVar);
        x(bVar);
        q(bVar);
        D(bVar);
        B(bVar);
        I(bVar);
        w(bVar);
        F(bVar);
        v(bVar);
        E(bVar);
        A(bVar);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void e(TextView textView) {
        if (this.f34208b || textView.getMovementMethod() != null) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void j(TextView textView, Spanned spanned) {
        x8.h.a(textView, spanned);
        if (spanned instanceof Spannable) {
            x8.k.a((Spannable) spanned, textView);
        }
    }

    public a o(p pVar) {
        this.f34207a.add(pVar);
        return this;
    }
}
