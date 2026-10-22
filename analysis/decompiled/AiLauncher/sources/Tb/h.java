package Tb;

import Tb.c;
import Tb.i;
import Tb.j;
import Tb.k;
import Tb.l;
import Tb.o;
import Tb.s;
import Yb.A;
import Yb.AbstractC1128b;
import ac.AbstractC1285f;
import ac.InterfaceC1283d;
import ac.InterfaceC1284e;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;
import bc.InterfaceC1477a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class h implements InterfaceC1287h {

    /* renamed from: p, reason: collision with root package name */
    public static final Set<Class<? extends AbstractC1128b>> f5947p = new LinkedHashSet(Arrays.asList(Yb.c.class, Yb.l.class, Yb.j.class, Yb.m.class, A.class, Yb.s.class, Yb.p.class));

    /* renamed from: q, reason: collision with root package name */
    public static final Map<Class<? extends AbstractC1128b>, InterfaceC1284e> f5948q;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f5949a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5952d;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5956h;

    /* renamed from: i, reason: collision with root package name */
    public final List<InterfaceC1284e> f5957i;

    /* renamed from: j, reason: collision with root package name */
    public final Zb.c f5958j;

    /* renamed from: k, reason: collision with root package name */
    public final List<InterfaceC1477a> f5959k;

    /* renamed from: l, reason: collision with root package name */
    public final g f5960l;

    /* renamed from: b, reason: collision with root package name */
    public int f5950b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f5951c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f5953e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f5954f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f5955g = 0;

    /* renamed from: m, reason: collision with root package name */
    public final Map<String, Yb.r> f5961m = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public List<InterfaceC1283d> f5962n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public Set<InterfaceC1283d> f5963o = new LinkedHashSet();

    public static class a implements InterfaceC1286g {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1283d f5964a;

        public a(InterfaceC1283d interfaceC1283d) {
            this.f5964a = interfaceC1283d;
        }

        @Override // ac.InterfaceC1286g
        public CharSequence a() {
            InterfaceC1283d interfaceC1283d = this.f5964a;
            if (!(interfaceC1283d instanceof q)) {
                return null;
            }
            CharSequence charSequenceI = ((q) interfaceC1283d).i();
            if (charSequenceI.length() == 0) {
                return null;
            }
            return charSequenceI;
        }

        @Override // ac.InterfaceC1286g
        public InterfaceC1283d b() {
            return this.f5964a;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(Yb.c.class, new c.a());
        map.put(Yb.l.class, new j.a());
        map.put(Yb.j.class, new i.a());
        map.put(Yb.m.class, new k.b());
        map.put(A.class, new s.a());
        map.put(Yb.s.class, new o.a());
        map.put(Yb.p.class, new l.a());
        f5948q = Collections.unmodifiableMap(map);
    }

    public h(List<InterfaceC1284e> list, Zb.c cVar, List<InterfaceC1477a> list2) {
        this.f5957i = list;
        this.f5958j = cVar;
        this.f5959k = list2;
        g gVar = new g();
        this.f5960l = gVar;
        g(gVar);
    }

    public static List<InterfaceC1284e> l(List<InterfaceC1284e> list, Set<Class<? extends AbstractC1128b>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<Class<? extends AbstractC1128b>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(f5948q.get(it.next()));
        }
        return arrayList;
    }

    public static Set<Class<? extends AbstractC1128b>> s() {
        return f5947p;
    }

    @Override // ac.InterfaceC1287h
    public boolean a() {
        return this.f5956h;
    }

    @Override // ac.InterfaceC1287h
    public CharSequence b() {
        return this.f5949a;
    }

    @Override // ac.InterfaceC1287h
    public int c() {
        return this.f5951c;
    }

    @Override // ac.InterfaceC1287h
    public int d() {
        return this.f5955g;
    }

    @Override // ac.InterfaceC1287h
    public int e() {
        return this.f5953e;
    }

    @Override // ac.InterfaceC1287h
    public InterfaceC1283d f() {
        return this.f5962n.get(r1.size() - 1);
    }

    public final void g(InterfaceC1283d interfaceC1283d) {
        this.f5962n.add(interfaceC1283d);
        this.f5963o.add(interfaceC1283d);
    }

    @Override // ac.InterfaceC1287h
    public int getIndex() {
        return this.f5950b;
    }

    public final <T extends InterfaceC1283d> T h(T t10) {
        while (!f().h(t10.e())) {
            n(f());
        }
        f().e().b(t10.e());
        g(t10);
        return t10;
    }

    public final void i(q qVar) {
        for (Yb.r rVar : qVar.j()) {
            qVar.e().i(rVar);
            String strN = rVar.n();
            if (!this.f5961m.containsKey(strN)) {
                this.f5961m.put(strN, rVar);
            }
        }
    }

    public final void j() {
        CharSequence charSequenceSubSequence;
        if (this.f5952d) {
            int i10 = this.f5950b + 1;
            CharSequence charSequence = this.f5949a;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i10, charSequence.length());
            int iA = Xb.d.a(this.f5951c);
            StringBuilder sb2 = new StringBuilder(charSequenceSubSequence2.length() + iA);
            for (int i11 = 0; i11 < iA; i11++) {
                sb2.append(' ');
            }
            sb2.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb2.toString();
        } else {
            CharSequence charSequence2 = this.f5949a;
            charSequenceSubSequence = charSequence2.subSequence(this.f5950b, charSequence2.length());
        }
        f().f(charSequenceSubSequence);
    }

    public final void k() {
        if (this.f5949a.charAt(this.f5950b) != '\t') {
            this.f5950b++;
            this.f5951c++;
        } else {
            this.f5950b++;
            int i10 = this.f5951c;
            this.f5951c = i10 + Xb.d.a(i10);
        }
    }

    public final void m() {
        this.f5962n.remove(r1.size() - 1);
    }

    public final void n(InterfaceC1283d interfaceC1283d) {
        if (f() == interfaceC1283d) {
            m();
        }
        if (interfaceC1283d instanceof q) {
            i((q) interfaceC1283d);
        }
        interfaceC1283d.g();
    }

    public final Yb.h o() {
        p(this.f5962n);
        w();
        return this.f5960l.e();
    }

    public final void p(List<InterfaceC1283d> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n(list.get(size));
        }
    }

    public final d q(InterfaceC1283d interfaceC1283d) {
        a aVar = new a(interfaceC1283d);
        Iterator<InterfaceC1284e> it = this.f5957i.iterator();
        while (it.hasNext()) {
            AbstractC1285f abstractC1285fA = it.next().a(this, aVar);
            if (abstractC1285fA instanceof d) {
                return (d) abstractC1285fA;
            }
        }
        return null;
    }

    public final void r() {
        int i10 = this.f5950b;
        int i11 = this.f5951c;
        this.f5956h = true;
        int length = this.f5949a.length();
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = this.f5949a.charAt(i10);
            if (cCharAt == '\t') {
                i10++;
                i11 += 4 - (i11 % 4);
            } else if (cCharAt != ' ') {
                this.f5956h = false;
                break;
            } else {
                i10++;
                i11++;
            }
        }
        this.f5953e = i10;
        this.f5954f = i11;
        this.f5955g = i11 - this.f5951c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        y(r10.f5953e);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.CharSequence r11) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Tb.h.t(java.lang.CharSequence):void");
    }

    public Yb.h u(String str) {
        int i10 = 0;
        while (true) {
            int iC = Xb.d.c(str, i10);
            if (iC == -1) {
                break;
            }
            t(str.substring(i10, iC));
            i10 = iC + 1;
            if (i10 < str.length() && str.charAt(iC) == '\r' && str.charAt(i10) == '\n') {
                i10 = iC + 2;
            }
        }
        if (str.length() > 0 && (i10 == 0 || i10 < str.length())) {
            t(str.substring(i10));
        }
        return o();
    }

    public final void v() {
        InterfaceC1283d interfaceC1283dF = f();
        m();
        this.f5963o.remove(interfaceC1283dF);
        if (interfaceC1283dF instanceof q) {
            i((q) interfaceC1283dF);
        }
        interfaceC1283dF.e().l();
    }

    public final void w() {
        Zb.a aVarA = this.f5958j.a(new m(this.f5959k, this.f5961m));
        Iterator<InterfaceC1283d> it = this.f5963o.iterator();
        while (it.hasNext()) {
            it.next().b(aVarA);
        }
    }

    public final void x(int i10) {
        int i11;
        int i12 = this.f5954f;
        if (i10 >= i12) {
            this.f5950b = this.f5953e;
            this.f5951c = i12;
        }
        int length = this.f5949a.length();
        while (true) {
            i11 = this.f5951c;
            if (i11 >= i10 || this.f5950b == length) {
                break;
            } else {
                k();
            }
        }
        if (i11 <= i10) {
            this.f5952d = false;
            return;
        }
        this.f5950b--;
        this.f5951c = i10;
        this.f5952d = true;
    }

    public final void y(int i10) {
        int i11 = this.f5953e;
        if (i10 >= i11) {
            this.f5950b = i11;
            this.f5951c = this.f5954f;
        }
        int length = this.f5949a.length();
        while (true) {
            int i12 = this.f5950b;
            if (i12 >= i10 || i12 == length) {
                break;
            } else {
                k();
            }
        }
        this.f5952d = false;
    }
}
