package org.c.a.j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.c.a.l.f;
import org.c.a.l.g;
import org.c.a.l.h;
import org.c.a.l.i;
import org.c.a.l.j;
import org.c.a.l.k;
import org.c.a.l.l;
import org.c.a.l.m;
import org.c.a.l.n;
import org.c.a.l.o;
import org.c.a.l.p;
import org.c.a.l.q;
import org.c.a.l.r;
import org.c.a.l.s;
import org.c.a.l.t;
import org.c.a.l.u;
import org.c.a.l.v;
import org.c.a.l.w;

/* JADX INFO: compiled from: ScannerImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Character, String> f40487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Character, Integer> f40488b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f40489c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final org.c.a.h.b f40490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f40491e;
    private int f;
    private List<v> g;
    private v h;
    private int i;
    private int j;
    private org.c.a.m.a<Integer> k;
    private boolean l;
    private boolean m;
    private Map<Integer, e> n;

    /* JADX INFO: compiled from: ScannerImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f40492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f40493b;

        public a(Boolean r1, int r2) {
            this.f40492a = r1;
            this.f40493b = r2;
        }

        public boolean a() {
            Boolean r0 = this.f40492a;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.booleanValue() == true) goto L8;
            return false;
        }

        public boolean b() {
            Boolean r0 = this.f40492a;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.booleanValue() == false) goto L7;
            return true;
        }

        public int c() {
            return this.f40493b;
        }
    }

    static {
        f40489c = Pattern.compile("[^0-9A-Fa-f]");
        HashMap r0 = new HashMap();
        f40487a = r0;
        HashMap r1 = new HashMap();
        f40488b = r1;
        r0.put('0', "\u0000");
        r0.put('a', "\u0007");
        r0.put('b', "\b");
        r0.put('t', "\t");
        r0.put('n', "\n");
        r0.put('v', "\u000b");
        r0.put('f', "\f");
        r0.put('r', "\r");
        r0.put('e', "\u001b");
        r0.put(' ', " ");
        r0.put('\"', "\"");
        r0.put('\\', "\\");
        r0.put('N', "\u0085");
        r0.put('_', " ");
        r0.put('L', "\u2028");
        r0.put('P', "\u2029");
        r1.put('x', 2);
        r1.put('u', 4);
        r1.put('U', 8);
    }

    public d(org.c.a.h.b r3) {
        this.f40491e = false;
        this.f = 0;
        this.i = 0;
        this.j = -1;
        this.m = true;
        this.l = false;
        this.f40490d = r3;
        this.g = new ArrayList(100);
        this.k = new org.c.a.m.a(10);
        this.n = new LinkedHashMap();
        i();
    }

    @Override // org.c.a.j.b
    public boolean a(v.a... r5) {
    L3:
        if (c() == false) goto L6;
        d();
        goto L3
    L6:
        if (this.g.isEmpty() == false) goto L8;
    L17:
        return false;
    L8:
        if (r5.length != 0) goto L10;
        return true;
    L10:
        v.a r4 = ((v) ZeusTransformUtils.preCheckCast(this.g.get(0), v.class, "com.obric.aiagent.plugin")).b();
        int r0 = 0;
    L12:
        if (r0 >= r5.length) goto L17;
        if (r4 == r5[r0]) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return true;
    }

    @Override // org.c.a.j.b
    public v a() {
    L3:
        if (c() == false) goto L6;
        d();
        goto L3
    L6:
        return (v) ZeusTransformUtils.preCheckCast(this.g.get(0), v.class, "com.obric.aiagent.plugin");
    }

    @Override // org.c.a.j.b
    public v b() {
        this.i++;
        return (v) ZeusTransformUtils.preCheckCast(this.g.remove(0), v.class, "com.obric.aiagent.plugin");
    }

    private void a(v r1) {
        this.h = r1;
        this.g.add(r1);
    }

    private void a(int r2, v r3) {
        if (r2 != this.g.size()) goto L5;
        this.h = r3;
    L5:
        this.g.add(r2, r3);
    }

    private void a(List<v> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.h = (v) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), v.class, "com.obric.aiagent.plugin");
        this.g.addAll(r5);
    }

    private boolean c() {
        if (this.f40491e == false) goto L6;
        return false;
    L6:
        if (this.g.isEmpty() == false) goto L8;
        return true;
    L8:
        f();
        if (e() == this.i) goto L11;
        return false;
    L11:
        return true;
    }

    private void d() {
        K();
        f();
        a(this.f40490d.d());
        int r0 = this.f40490d.c();
        if (r0 != 0) goto L5;
        j();
        return;
    L5:
        if (r0 != 42) goto L7;
        v();
        return;
    L7:
        if (r0 == 58) goto L71;
        if (r0 != 91) goto L11;
        n();
        return;
    L11:
        if (r0 != 93) goto L13;
        p();
        return;
    L13:
        if (r0 != 33) goto L15;
        x();
        return;
    L15:
        if (r0 != 34) goto L17;
        B();
        return;
    L17:
        if (r0 == 62) goto L59;
        if (r0 == 63) goto L55;
        switch(r0) {
            case 37: goto L51;
            case 38: goto L48;
            case 39: goto L46;
            default: goto L21;
        };
    L21:
        switch(r0) {
            case 44: goto L44;
            case 45: goto L37;
            case 46: goto L33;
            default: goto L22;
        };
    L22:
        switch(r0) {
            case 123: goto L30;
            case 124: goto L27;
            case 125: goto L24;
            default: goto L75;
        };
    L24:
        q();
        return;
    L30:
        o();
        return;
    L27:
        if (this.f != 0) goto L75;
        y();
        return;
    L75:
        if (J() == false) goto L78;
        C();
        return;
    L78:
        String r1 = a(String.valueOf(Character.toChars(r0)));
        if (r0 != 9) goto L82;
        r1 = r1 + "(TAB)";
    L82:
        throw new c("while scanning for the next token", null, String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", new Object[]{r1, r1}), this.f40490d.a());
    L44:
        r();
        return;
    L33:
        if (F() == false) goto L75;
        m();
        return;
    L37:
        if (E() == false) goto L41;
        l();
        return;
    L41:
        if (G() == false) goto L75;
        s();
        return;
    L46:
        A();
        return;
    L48:
        w();
        return;
    L51:
        if (D() == false) goto L75;
        k();
        return;
    L55:
        if (H() == false) goto L75;
        t();
        return;
    L59:
        if (this.f != 0) goto L75;
        z();
        return;
    L71:
        if (I() == false) goto L75;
        u();
    }

    private String a(String r5) {
        Iterator<Character> r4 = f40487a.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Character r0 = (Character) ZeusTransformUtils.preCheckCast(r4.next(), Character.class, "com.obric.aiagent.plugin");
        if (((String) ZeusTransformUtils.preCheckCast(f40487a.get(r0), String.class, "com.obric.aiagent.plugin")).equals(r5) == false) goto L4;
        return "\\" + r0;
    L9:
        return r5;
    }

    private int e() {
        if (this.n.isEmpty() == false) goto L5;
        return -1;
    L5:
        return ((e) ZeusTransformUtils.preCheckCast(this.n.values().iterator().next(), e.class, "com.obric.aiagent.plugin")).a();
    }

    private void f() {
        if (this.n.isEmpty() == true) goto L16;
        Iterator<e> r0 = this.n.values().iterator();
    L6:
        if (r0.hasNext() == false) goto L24;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin");
        if (r1.e() != this.f40490d.f()) goto L12;
        if ((this.f40490d.e() - r1.d()) <= 1024) goto L6;
    L12:
        if (r1.f() == true) goto L15;
        r0.remove();
        goto L6
    L15:
        throw new c("while scanning a simple key", r1.c(), "could not find expected ':'", this.f40490d.a());
    L24:
        return;
    }

    private void g() {
        if (this.f == 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r3 = r0;
        boolean r1 = this.m;
        if (r1 == true) goto L14;
        if (r3 == false) goto L14;
        throw new org.c.a.c.c("A simple key is required only if it is the first token in the current line");
    L14:
        if (r1 == false) goto L17;
        h();
        e r2 = new e(this.i + this.g.size(), r3, this.f40490d.e(), this.f40490d.f(), this.f40490d.d(), this.f40490d.a());
        this.n.put(Integer.valueOf(this.f), r2);
        return;
    L17:
        return;
    L5:
        if (this.j != this.f40490d.d()) goto L7;
        r0 = true;
        goto L8
    }

    private void h() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.n.remove(Integer.valueOf(this.f)), e.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f() == true) goto L8;
        return;
    L8:
        throw new c("while scanning a simple key", r0.c(), "could not find expected ':'", this.f40490d.a());
    }

    private void a(int r5) {
        if (this.f == 0) goto L6;
        return;
    L6:
        if (this.j <= r5) goto L8;
        org.c.a.c.a r0 = this.f40490d.a();
        this.j = ((Integer) ZeusTransformUtils.preCheckCast(this.k.a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        a(new org.c.a.l.c(r0, r0));
        goto L6
    }

    private boolean b(int r3) {
        int r0 = this.j;
        if (r0 >= r3) goto L6;
        this.k.a(Integer.valueOf(r0));
        this.j = r3;
        return true;
    L6:
        return false;
    }

    private void i() {
        org.c.a.c.a r0 = this.f40490d.a();
        a(new s(r0, r0));
    }

    private void j() {
        a(-1);
        h();
        this.m = false;
        this.n.clear();
        org.c.a.c.a r0 = this.f40490d.a();
        a(new r(r0, r0));
        this.f40491e = true;
    }

    private void k() {
        a(-1);
        h();
        this.m = false;
        a(L());
    }

    private void l() {
        a(true);
    }

    private void m() {
        a(false);
    }

    private void a(boolean r4) {
        a(-1);
        h();
        this.m = false;
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b(3);
        org.c.a.c.a r1 = this.f40490d.a();
        if (r4 == false) goto L5;
        v r5 = new j(r0, r1);
    L6:
        a(r5);
        return;
    L5:
        r5 = new i(r0, r1);
        goto L6
    }

    private void n() {
        b(false);
    }

    private void o() {
        b(true);
    }

    private void b(boolean r4) {
        g();
        this.f++;
        this.m = true;
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b(1);
        org.c.a.c.a r1 = this.f40490d.a();
        if (r4 == false) goto L5;
        v r5 = new m(r0, r1);
    L6:
        a(r5);
        return;
    L5:
        r5 = new o(r0, r1);
        goto L6
    }

    private void p() {
        c(false);
    }

    private void q() {
        c(true);
    }

    private void c(boolean r3) {
        h();
        this.f--;
        this.m = false;
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b();
        org.c.a.c.a r1 = this.f40490d.a();
        if (r3 == false) goto L5;
        v r4 = new l(r0, r1);
    L6:
        a(r4);
        return;
    L5:
        r4 = new n(r0, r1);
        goto L6
    }

    private void r() {
        this.m = true;
        h();
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b();
        a(new k(r0, this.f40490d.a()));
    }

    private void s() {
        if (this.f == 0) goto L5;
    L11:
        this.m = true;
        h();
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b();
        a(new org.c.a.l.d(r0, this.f40490d.a()));
        return;
    L5:
        if (this.m == false) goto L10;
        if (b(this.f40490d.d()) == false) goto L11;
        org.c.a.c.a r1 = this.f40490d.a();
        a(new f(r1, r1));
        goto L11
    L10:
        throw new c(null, null, "sequence entries are not allowed here", this.f40490d.a());
    }

    private void t() {
        if (this.f != 0) goto L12;
        if (this.m == false) goto L10;
        if (b(this.f40490d.d()) == false) goto L12;
        org.c.a.c.a r0 = this.f40490d.a();
        a(new org.c.a.l.e(r0, r0));
        goto L12
    L10:
        throw new c(null, null, "mapping keys are not allowed here", this.f40490d.a());
    L12:
        if (this.f != 0) goto L14;
        boolean r1 = true;
    L15:
        this.m = r1;
        h();
        org.c.a.c.a r2 = this.f40490d.a();
        this.f40490d.b();
        a(new p(r2, this.f40490d.a()));
        return;
    L14:
        r1 = false;
        goto L15
    }

    private void u() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.n.remove(Integer.valueOf(this.f)), e.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 == null) goto L10;
        a(r0.a() - this.i, new p(r0.c(), r0.c()));
        if (this.f == 0) goto L7;
    L9:
        this.m = false;
    L25:
        org.c.a.c.a r2 = this.f40490d.a();
        this.f40490d.b();
        a(new w(r2, this.f40490d.a()));
        return;
    L7:
        if (b(r0.b()) == false) goto L9;
        a(r0.a() - this.i, new org.c.a.l.e(r0.c(), r0.c()));
        goto L9
    L10:
        int r3 = this.f;
        if (r3 == 0) goto L13;
    L17:
        if (r3 != 0) goto L22;
        if (b(this.f40490d.d()) == false) goto L22;
        org.c.a.c.a r4 = this.f40490d.a();
        a(new org.c.a.l.e(r4, r4));
    L22:
        if (this.f != 0) goto L24;
        r1 = true;
    L24:
        this.m = r1;
        h();
        goto L25
    L13:
        if (this.m == true) goto L17;
        throw new c(null, null, "mapping values are not allowed here", this.f40490d.a());
    }

    private void v() {
        g();
        this.m = false;
        a(d(false));
    }

    private void w() {
        g();
        this.m = false;
        a(d(true));
    }

    private void x() {
        g();
        this.m = false;
        a(M());
    }

    private void y() {
        a('|');
    }

    private void z() {
        a('>');
    }

    private void a(char r2) {
        this.m = true;
        h();
        a(c(r2));
    }

    private void A() {
        b('\'');
    }

    private void B() {
        b('\"');
    }

    private void b(char r2) {
        g();
        this.m = false;
        a(d(r2));
    }

    private void C() {
        g();
        this.m = false;
        a(O());
    }

    private boolean D() {
        if (this.f40490d.d() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean E() {
        if (this.f40490d.d() == 0) goto L5;
        return false;
    L5:
        if ("---".equals(this.f40490d.d(3)) == true) goto L7;
        return false;
    L7:
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(3)) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private boolean F() {
        if (this.f40490d.d() == 0) goto L5;
        return false;
    L5:
        if ("...".equals(this.f40490d.d(3)) == true) goto L7;
        return false;
    L7:
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(3)) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private boolean G() {
        return org.c.a.j.a.f40485d.a(this.f40490d.c(1));
    }

    private boolean H() {
        if (this.f == 0) goto L6;
        return true;
    L6:
        return org.c.a.j.a.f40485d.a(this.f40490d.c(1));
    }

    private boolean I() {
        if (this.f == 0) goto L6;
        return true;
    L6:
        return org.c.a.j.a.f40485d.a(this.f40490d.c(1));
    }

    private boolean J() {
        int r0 = this.f40490d.c();
        if (org.c.a.j.a.f40485d.b(r0, "-?:,[]{}#&*!|>'\"%@`") == false) goto L5;
        return true;
    L5:
        if (org.c.a.j.a.f40485d.b(this.f40490d.c(1)) == true) goto L7;
    L13:
        return false;
    L7:
        if (r0 != 45) goto L9;
        return true;
    L9:
        if (this.f != 0) goto L13;
        if ("?:".indexOf(r0) == (-1)) goto L13;
        return true;
    }

    private void K() {
        if (this.f40490d.e() == 0) goto L5;
    L7:
        int r3 = -1;
        boolean r2 = false;
    L8:
        if (r2 == true) goto L43;
        org.c.a.c.a r4 = this.f40490d.a();
        int r5 = this.f40490d.d();
        int r6 = 0;
    L11:
        if (this.f40490d.c(r6) != 32) goto L13;
        r6 = r6 + 1;
        goto L11
    L13:
        if (r6 <= 0) goto L16;
        this.f40490d.b(r6);
    L16:
        if (this.f40490d.c() != 35) goto L31;
        if (r5 == 0) goto L24;
        v r7 = this.h;
        if (r7 != null) goto L21;
    L22:
        org.c.a.a.c r8 = org.c.a.a.c.f40342c;
        int r9 = this.f40490d.d();
    L27:
        g r10 = a(r8);
        if (this.l == false) goto L30;
        a(r10);
    L30:
        r3 = r9;
        boolean r11 = true;
    L32:
        String r12 = R();
        if (r12.length() != 0) goto L35;
        r2 = true;
        goto L8
    L35:
        if (this.l == false) goto L40;
        if (r11 == true) goto L40;
        if (r5 != 0) goto L40;
        a(new g(org.c.a.a.c.f40340a, r12, r4, this.f40490d.a()));
    L40:
        if (this.f != 0) goto L8;
        this.m = true;
        goto L8
    L21:
        if (r7.b() != v.a.f40517d) goto L22;
    L24:
        if (r3 != this.f40490d.d()) goto L26;
        r9 = r3;
        r8 = org.c.a.a.c.f40342c;
        goto L27
    L26:
        r8 = org.c.a.a.c.f40341b;
        r9 = -1;
        goto L27
    L31:
        r11 = false;
        goto L32
    L43:
        return;
    L5:
        if (this.f40490d.c() != 65279) goto L7;
        this.f40490d.b();
        goto L7
    }

    private g a(org.c.a.a.c r5) {
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b();
        int r1 = 0;
    L4:
        if (org.c.a.j.a.f40483b.b(this.f40490d.c(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return new g(r5, this.f40490d.e(r1), r0, this.f40490d.a());
    }

    private List<v> L() {
        org.c.a.c.a r0 = this.f40490d.a();
        this.f40490d.b();
        String r1 = a(r0);
        if ("YAML".equals(r1) == false) goto L6;
        List r2 = b(r0);
        org.c.a.c.a r4 = this.f40490d.a();
    L16:
        return a(new v[]{new h(r1, r2, r0, r4), g(r0)});
    L6:
        if ("TAG".equals(r1) == false) goto L8;
        r2 = d(r0);
        r4 = this.f40490d.a();
        goto L16
    L8:
        r4 = this.f40490d.a();
        int r3 = 0;
    L10:
        if (org.c.a.j.a.f40483b.b(this.f40490d.c(r3)) == false) goto L12;
        r3 = r3 + 1;
        goto L10
    L12:
        if (r3 <= 0) goto L14;
        this.f40490d.b(r3);
    L14:
        r2 = null;
        goto L16
    }

    private String a(org.c.a.c.a r9) {
        int r1 = 0;
        int r0 = this.f40490d.c(0);
    L4:
        if (org.c.a.j.a.g.a(r0) == false) goto L7;
        r1 = r1 + 1;
        r0 = this.f40490d.c(r1);
        goto L4
    L7:
        if (r1 == 0) goto L14;
        String r2 = this.f40490d.e(r1);
        int r3 = this.f40490d.c();
        if (org.c.a.j.a.f40484c.b(r3) == true) goto L12;
        return r2;
    L12:
        throw new c("while scanning a directive", r9, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(r3)) + "(" + r3 + ")", this.f40490d.a());
    L14:
        throw new c("while scanning a directive", r9, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(r0)) + "(" + r0 + ")", this.f40490d.a());
    }

    private List<Integer> b(org.c.a.c.a r9) {
    L3:
        if (this.f40490d.c() != 32) goto L5;
        this.f40490d.b();
        goto L3
    L5:
        Integer r0 = c(r9);
        int r1 = this.f40490d.c();
        if (r1 != 46) goto L14;
        this.f40490d.b();
        Integer r2 = c(r9);
        int r3 = this.f40490d.c();
        if (org.c.a.j.a.f40484c.b(r3) == true) goto L12;
        ArrayList r8 = new ArrayList(2);
        r8.add(r0);
        r8.add(r2);
        return r8;
    L12:
        throw new c("while scanning a directive", r9, "expected a digit or ' ', but found " + String.valueOf(Character.toChars(r3)) + "(" + r3 + ")", this.f40490d.a());
    L14:
        throw new c("while scanning a directive", r9, "expected a digit or '.', but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    }

    private Integer c(org.c.a.c.a r6) {
        int r0 = this.f40490d.c();
        if (Character.isDigit(r0) == false) goto L11;
        int r7 = 0;
    L6:
        if (Character.isDigit(this.f40490d.c(r7)) == false) goto L9;
        r7 = r7 + 1;
        goto L6
    L9:
        return Integer.valueOf(Integer.parseInt(this.f40490d.e(r7)));
    L11:
        throw new c("while scanning a directive", r6, "expected a digit, but found " + String.valueOf(Character.toChars(r0)) + "(" + r0 + ")", this.f40490d.a());
    }

    private List<String> d(org.c.a.c.a r4) {
    L3:
        if (this.f40490d.c() != 32) goto L5;
        this.f40490d.b();
        goto L3
    L5:
        String r0 = e(r4);
    L7:
        if (this.f40490d.c() != 32) goto L9;
        this.f40490d.b();
        goto L7
    L9:
        String r3 = f(r4);
        ArrayList r5 = new ArrayList(2);
        r5.add(r0);
        r5.add(r3);
        return r5;
    }

    private String e(org.c.a.c.a r6) {
        String r0 = a("directive", r6);
        int r1 = this.f40490d.c();
        if (r1 != 32) goto L6;
        return r0;
    L6:
        throw new c("while scanning a directive", r6, "expected ' ', but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    }

    private String f(org.c.a.c.a r6) {
        String r0 = b("directive", r6);
        int r1 = this.f40490d.c();
        if (org.c.a.j.a.f40484c.b(r1) == true) goto L6;
        return r0;
    L6:
        throw new c("while scanning a directive", r6, "expected ' ', but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    }

    private g g(org.c.a.c.a r6) {
    L3:
        if (this.f40490d.c() != 32) goto L5;
        this.f40490d.b();
        goto L3
    L5:
        g r0 = null;
        if (this.f40490d.c() != 35) goto L10;
        g r1 = a(org.c.a.a.c.f40342c);
        if (this.l == false) goto L10;
        r0 = r1;
    L10:
        int r2 = this.f40490d.c();
        if (R().length() != 0) goto L16;
        if (r2 == 0) goto L16;
        throw new c("while scanning a directive", r6, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(r2)) + "(" + r2 + ")", this.f40490d.a());
    L16:
        return r0;
    }

    private v d(boolean r11) {
        org.c.a.c.a r0 = this.f40490d.a();
        if (this.f40490d.c() != 42) goto L5;
        String r1 = "alias";
    L6:
        this.f40490d.b();
        int r2 = 0;
        int r3 = this.f40490d.c(0);
    L8:
        if (org.c.a.j.a.f40485d.b(r3, ":,[]{}/.*&") == false) goto L11;
        r2 = r2 + 1;
        r3 = this.f40490d.c(r2);
        goto L8
    L11:
        if (r2 == 0) goto L22;
        String r4 = this.f40490d.e(r2);
        int r5 = this.f40490d.c();
        if (org.c.a.j.a.f40485d.b(r5, "?:,]}%@`") == true) goto L20;
        org.c.a.c.a r10 = this.f40490d.a();
        if (r11 == false) goto L18;
        return new org.c.a.l.b(r4, r0, r10);
    L18:
        return new org.c.a.l.a(r4, r0, r10);
    L20:
        throw new c("while scanning an " + r1, r0, "unexpected character found " + String.valueOf(Character.toChars(r5)) + "(" + r5 + ")", this.f40490d.a());
    L22:
        throw new c("while scanning an " + r1, r0, "unexpected character found " + String.valueOf(Character.toChars(r3)) + "(" + r3 + ")", this.f40490d.a());
    L5:
        r1 = "anchor";
        goto L6
    }

    private v M() {
        org.c.a.c.a r0 = this.f40490d.a();
        boolean r2 = true;
        int r1 = this.f40490d.c(1);
        String r6 = "!";
        String r8 = null;
        if (r1 != 60) goto L10;
        this.f40490d.b(2);
        r6 = b("tag", r0);
        int r3 = this.f40490d.c();
        if (r3 != 62) goto L8;
        this.f40490d.b();
    L24:
        int r4 = this.f40490d.c();
        if (org.c.a.j.a.f40484c.b(r4) == true) goto L29;
        return new t(new u(r8, r6), r0, this.f40490d.a());
    L29:
        throw new c("while scanning a tag", r0, "expected ' ', but found '" + String.valueOf(Character.toChars(r4)) + "' (" + r4 + ")", this.f40490d.a());
    L8:
        throw new c("while scanning a tag", r0, "expected '>', but found '" + String.valueOf(Character.toChars(r3)) + "' (" + r3 + ")", this.f40490d.a());
    L10:
        if (org.c.a.j.a.f40485d.a(r1) == false) goto L12;
        this.f40490d.b();
        goto L24
    L12:
        int r9 = 1;
    L14:
        if (org.c.a.j.a.f40484c.b(r1) == false) goto L19;
        if (r1 == 33) goto L20;
        r9 = r9 + 1;
        r1 = this.f40490d.c(r9);
    L20:
        if (r2 == false) goto L22;
        r6 = a("tag", r0);
    L23:
        r8 = r6;
        r6 = b("tag", r0);
        goto L24
    L22:
        this.f40490d.b();
        goto L23
    L19:
        r2 = false;
        goto L20
    }

    private List<v> c(char r17) {
        int r1 = 0;
        if (r17 != '>') goto L5;
        boolean r3 = true;
    L6:
        StringBuilder r5 = new StringBuilder();
        org.c.a.c.a r10 = this.f40490d.a();
        this.f40490d.b();
        a r6 = h(r10);
        int r7 = r6.c();
        g r13 = i(r10);
        int r8 = this.j + 1;
        if (r8 >= 1) goto L10;
        r8 = 1;
    L10:
        if (r7 != (-1)) goto L12;
        Object[] r9 = N();
        String r12 = (String) ZeusTransformUtils.preCheckCast(r9[0], String.class, "com.obric.aiagent.plugin");
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(r9[1], Integer.class, "com.obric.aiagent.plugin")).intValue();
        org.c.a.c.a r14 = (org.c.a.c.a) ZeusTransformUtils.preCheckCast(r9[2], org.c.a.c.a.class, "com.obric.aiagent.plugin");
        int r15 = Math.max(r8, r11);
    L13:
        String r16 = "";
    L15:
        if (this.f40490d.d() != r15) goto L43;
        if (this.f40490d.c() == 0) goto L43;
        r5.append(r12);
        if (" \t".indexOf(this.f40490d.c()) != (-1)) goto L21;
        int r18 = 1;
    L22:
        int r19 = r1;
    L24:
        if (org.c.a.j.a.f40483b.b(this.f40490d.c(r19)) == false) goto L26;
        r19 = r19 + 1;
        goto L24
    L26:
        r5.append(this.f40490d.e(r19));
        String r110 = R();
        Object[] r111 = c(r15);
        String r2 = (String) ZeusTransformUtils.preCheckCast(r111[r1], String.class, "com.obric.aiagent.plugin");
        org.c.a.c.a r112 = (org.c.a.c.a) ZeusTransformUtils.preCheckCast(r111[1], org.c.a.c.a.class, "com.obric.aiagent.plugin");
        if (this.f40490d.d() != r15) goto L42;
        if (this.f40490d.c() == 0) goto L42;
        if (r3 == false) goto L40;
        if ("\n".equals(r110) == false) goto L40;
        if (r18 == 0) goto L40;
        if (" \t".indexOf(this.f40490d.c()) != (-1)) goto L40;
        if (r2.length() != 0) goto L41;
        r5.append(" ");
    L41:
        r16 = r110;
        r14 = r112;
        r12 = r2;
        r1 = 0;
    L40:
        r5.append(r110);
    L42:
        r16 = r110;
        org.c.a.c.a r113 = r112;
        r12 = r2;
    L45:
        if (r6.a() == false) goto L48;
        r5.append(r16);
    L48:
        if (r6.b() == false) goto L51;
        r5.append(r12);
    L51:
        return a(new v[]{r13, new q(r5.toString(), false, r10, r113, org.c.a.a.d.a(Character.valueOf(r17)))});
    L21:
        r18 = r1;
    L43:
        r113 = r14;
        goto L45
    L12:
        r15 = (r8 + r7) - 1;
        Object[] r20 = c(r15);
        r12 = (String) ZeusTransformUtils.preCheckCast(r20[0], String.class, "com.obric.aiagent.plugin");
        r14 = (org.c.a.c.a) ZeusTransformUtils.preCheckCast(r20[1], org.c.a.c.a.class, "com.obric.aiagent.plugin");
        goto L13
    L5:
        r3 = false;
        goto L6
    }

    private a h(org.c.a.c.a r9) {
        int r0 = this.f40490d.c();
        Boolean r5 = null;
        int r6 = -1;
        if (r0 == 45) goto L19;
        if (r0 == 43) goto L19;
        if (Character.isDigit(r0) == false) goto L29;
        r6 = Integer.parseInt(String.valueOf(Character.toChars(r0)));
        if (r6 == 0) goto L18;
        this.f40490d.b();
        int r1 = this.f40490d.c();
        if (r1 == 45) goto L13;
        if (r1 != 43) goto L29;
    L13:
        if (r1 != 43) goto L15;
        Boolean r2 = Boolean.TRUE;
    L16:
        r5 = r2;
        this.f40490d.b();
        goto L29
    L15:
        r2 = Boolean.FALSE;
        goto L16
    L18:
        throw new c("while scanning a block scalar", r9, "expected indentation indicator in the range 1-9, but found 0", this.f40490d.a());
    L29:
        int r3 = this.f40490d.c();
        if (org.c.a.j.a.f40484c.b(r3) == true) goto L34;
        return new a(r5, r6);
    L34:
        throw new c("while scanning a block scalar", r9, "expected chomping or indentation indicators, but found " + String.valueOf(Character.toChars(r3)) + "(" + r3 + ")", this.f40490d.a());
    L19:
        if (r0 != 43) goto L21;
        Boolean r4 = Boolean.TRUE;
    L22:
        r5 = r4;
        this.f40490d.b();
        int r7 = this.f40490d.c();
        if (Character.isDigit(r7) == false) goto L29;
        r6 = Integer.parseInt(String.valueOf(Character.toChars(r7)));
        if (r6 == 0) goto L28;
        this.f40490d.b();
        goto L29
    L28:
        throw new c("while scanning a block scalar", r9, "expected indentation indicator in the range 1-9, but found 0", this.f40490d.a());
    L21:
        r4 = Boolean.FALSE;
        goto L22
    }

    private g i(org.c.a.c.a r6) {
    L3:
        if (this.f40490d.c() != 32) goto L5;
        this.f40490d.b();
        goto L3
    L5:
        g r0 = null;
        if (this.f40490d.c() != 35) goto L8;
        r0 = a(org.c.a.a.c.f40342c);
    L8:
        int r1 = this.f40490d.c();
        if (R().length() != 0) goto L14;
        if (r1 == 0) goto L14;
        throw new c("while scanning a block scalar", r6, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    L14:
        return r0;
    }

    private Object[] N() {
        StringBuilder r0 = new StringBuilder();
        org.c.a.c.a r1 = this.f40490d.a();
        int r3 = 0;
    L4:
        if (org.c.a.j.a.f40482a.a(this.f40490d.c(), " \r") == false) goto L12;
        if (this.f40490d.c() != 32) goto L7;
        this.f40490d.b();
        if (this.f40490d.d() <= r3) goto L4;
        r3 = this.f40490d.d();
        goto L4
    L7:
        r0.append(R());
        r1 = this.f40490d.a();
        goto L4
    L12:
        return new Object[]{r0.toString(), Integer.valueOf(r3), r1};
    }

    private Object[] c(int r6) {
        StringBuilder r0 = new StringBuilder();
        org.c.a.c.a r1 = this.f40490d.a();
        int r2 = this.f40490d.d();
    L4:
        if (r2 >= r6) goto L8;
        if (this.f40490d.c() != 32) goto L8;
        this.f40490d.b();
        r2 = r2 + 1;
    L8:
        String r3 = R();
        if (r3.length() == 0) goto L16;
        r0.append(r3);
        r1 = this.f40490d.a();
        int r4 = this.f40490d.d();
    L11:
        if (r4 >= r6) goto L8;
        if (this.f40490d.c() != 32) goto L8;
        this.f40490d.b();
        r4 = r4 + 1;
        goto L11
    L16:
        return new Object[]{r0.toString(), r1};
    }

    private v d(char r10) {
        if (r10 != '\"') goto L5;
        boolean r0 = true;
    L6:
        StringBuilder r1 = new StringBuilder();
        org.c.a.c.a r6 = this.f40490d.a();
        int r2 = this.f40490d.c();
        this.f40490d.b();
        r1.append(a(r0, r6));
    L8:
        if (this.f40490d.c() == r2) goto L10;
        r1.append(j(r6));
        r1.append(a(r0, r6));
        goto L8
    L10:
        this.f40490d.b();
        org.c.a.c.a r7 = this.f40490d.a();
        return new q(r1.toString(), false, r6, r7, org.c.a.a.d.a(Character.valueOf(r10)));
    L5:
        r0 = false;
        goto L6
    }

    private String a(boolean r8, org.c.a.c.a r9) {
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = 0;
    L5:
        if (org.c.a.j.a.f40485d.b(this.f40490d.c(r1), "'\"\\") == false) goto L7;
        r1 = r1 + 1;
        goto L5
    L7:
        if (r1 == 0) goto L9;
        r0.append(this.f40490d.e(r1));
    L9:
        int r2 = this.f40490d.c();
        if (r8 == true) goto L15;
        if (r2 != 39) goto L15;
        if (this.f40490d.c(1) != 39) goto L15;
        r0.append("'");
        this.f40490d.b(2);
    L15:
        if (r8 == false) goto L17;
        if (r2 != 39) goto L17;
    L20:
        r0.appendCodePoint(r2);
        this.f40490d.b();
    L17:
        if (r8 == true) goto L21;
        if ("\"\\".indexOf(r2) != (-1)) goto L20;
    L21:
        if (r8 == false) goto L44;
        if (r2 != 92) goto L44;
        this.f40490d.b();
        int r3 = this.f40490d.c();
        if (Character.isSupplementaryCodePoint(r3) == true) goto L30;
        Map<Character, String> r4 = f40487a;
        char r5 = (char) r3;
        if (r4.containsKey(Character.valueOf(r5)) == false) goto L30;
        r0.append((String) ZeusTransformUtils.preCheckCast(r4.get(Character.valueOf(r5)), String.class, "com.obric.aiagent.plugin"));
        this.f40490d.b();
    L30:
        if (Character.isSupplementaryCodePoint(r3) == true) goto L39;
        Map<Character, Integer> r6 = f40488b;
        char r7 = (char) r3;
        if (r6.containsKey(Character.valueOf(r7)) == false) goto L39;
        int r10 = ((Integer) ZeusTransformUtils.preCheckCast(r6.get(Character.valueOf(r7)), Integer.class, "com.obric.aiagent.plugin")).intValue();
        this.f40490d.b();
        String r11 = this.f40490d.d(r10);
        if (f40489c.matcher(r11).find() == true) goto L37;
        r0.append(new String(Character.toChars(Integer.parseInt(r11, 16))));
        this.f40490d.b(r10);
        goto L3
    L37:
        throw new c("while scanning a double-quoted scalar", r9, "expected escape sequence of " + r10 + " hexadecimal numbers, but found: " + r11, this.f40490d.a());
    L39:
        if (R().length() == 0) goto L42;
        r0.append(k(r9));
        goto L3
    L42:
        throw new c("while scanning a double-quoted scalar", r9, "found unknown escape character " + String.valueOf(Character.toChars(r3)) + "(" + r3 + ")", this.f40490d.a());
    L44:
        return r0.toString();
    }

    private String j(org.c.a.c.a r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (" \t".indexOf(this.f40490d.c(r1)) == (-1)) goto L6;
        r1 = r1 + 1;
        goto L4
    L6:
        String r2 = this.f40490d.e(r1);
        if (this.f40490d.c() == 0) goto L21;
        String r3 = R();
        if (r3.length() == 0) goto L17;
        String r4 = k(r5);
        if ("\n".equals(r3) == true) goto L14;
        r0.append(r3);
    L16:
        r0.append(r4);
    L19:
        return r0.toString();
    L14:
        if (r4.length() != 0) goto L16;
        r0.append(" ");
        goto L16
    L17:
        r0.append(r2);
        goto L19
    L21:
        throw new c("while scanning a quoted scalar", r5, "found unexpected end of stream", this.f40490d.a());
    }

    private String k(org.c.a.c.a r5) {
        StringBuilder r0 = new StringBuilder();
    L3:
        String r1 = this.f40490d.d(3);
        if ("---".equals(r1) == true) goto L8;
        if ("...".equals(r1) == true) goto L8;
    L10:
        if (" \t".indexOf(this.f40490d.c()) == (-1)) goto L12;
        this.f40490d.b();
        goto L10
    L12:
        String r2 = R();
        if (r2.length() == 0) goto L16;
        r0.append(r2);
        goto L3
    L16:
        return r0.toString();
    L8:
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(3)) == false) goto L10;
        throw new c("while scanning a quoted scalar", r5, "found unexpected document separator", this.f40490d.a());
    }

    private v O() {
        StringBuilder r0 = new StringBuilder();
        org.c.a.c.a r1 = this.f40490d.a();
        int r2 = this.j + 1;
        org.c.a.c.a r6 = r1;
        String r5 = "";
    L4:
        if (this.f40490d.c() == 35) goto L34;
        int r9 = 0;
    L7:
        int r10 = this.f40490d.c(r9);
        if (org.c.a.j.a.f40485d.a(r10) == true) goto L23;
        if (r10 != 58) goto L18;
        org.c.a.j.a r11 = org.c.a.j.a.f40485d;
        int r12 = this.f40490d.c(r9 + 1);
        if (this.f == 0) goto L14;
        String r13 = ",[]{}";
    L16:
        if (r11.a(r12, r13) == true) goto L23;
    L14:
        r13 = "";
    L18:
        if (this.f == 0) goto L22;
        if (",?[]{}".indexOf(r10) != (-1)) goto L23;
    L22:
        r9 = r9 + 1;
    L23:
        if (r9 == 0) goto L34;
        this.m = false;
        r0.append(r5);
        r0.append(this.f40490d.e(r9));
        r6 = this.f40490d.a();
        r5 = Q();
        if (r5.length() == 0) goto L34;
        if (this.f40490d.c() == 35) goto L34;
        if (this.f != 0) goto L4;
        if (this.f40490d.d() >= r2) goto L4;
    L34:
        return new q(r0.toString(), r1, r6, true);
    }

    private boolean P() {
        int r0 = this.f40490d.d();
        int r2 = 0;
    L3:
        int r3 = this.f40490d.c(r2);
        if (r3 == 0) goto L18;
        if (org.c.a.j.a.f40485d.a(r3) == false) goto L18;
        r2 = r2 + 1;
        if (org.c.a.j.a.f40482a.a(r3) == true) goto L16;
        if (r3 != 13) goto L14;
        if (this.f40490d.c(r2 + 1) == 10) goto L16;
    L14:
        if (r3 == 65279) goto L16;
        r0 = r0 + 1;
    L16:
        r0 = 0;
    L18:
        if (this.f40490d.c(r2) != 35) goto L20;
    L39:
        return true;
    L20:
        if (this.f40490d.c(r2 + 1) == 0) goto L39;
        int r4 = this.f;
        if (r4 == 0) goto L24;
    L26:
        if (r4 != 0) goto L38;
        int r1 = 1;
    L28:
        int r5 = r2 + r1;
        int r6 = this.f40490d.c(r5);
        if (r6 == 0) goto L38;
        if (org.c.a.j.a.f40485d.a(r6) == true) goto L38;
        if (r6 != 58) goto L37;
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(r5 + 1)) == false) goto L37;
        return true;
    L37:
        r1 = r1 + 1;
    L38:
        return false;
    L24:
        if (r0 >= this.j) goto L26;
        goto L26
    }

    private String Q() {
        int r0 = 0;
    L4:
        if (this.f40490d.c(r0) == 32) goto L47;
        if (this.f40490d.c(r0) == 9) goto L47;
        String r1 = this.f40490d.e(r0);
        String r2 = R();
        if (r2.length() == 0) goto L46;
        this.m = true;
        String r3 = this.f40490d.d(3);
        if ("---".equals(r3) == false) goto L13;
    L45:
        return "";
    L13:
        if ("...".equals(r3) == false) goto L18;
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(3)) == true) goto L45;
    L18:
        if (this.l == true) goto L20;
    L22:
        StringBuilder r4 = new StringBuilder();
    L24:
        if (this.f40490d.c() == 32) goto L25;
        String r7 = R();
        if (r7.length() == 0) goto L36;
        r4.append(r7);
        String r8 = this.f40490d.d(3);
        if ("---".equals(r8) == true) goto L34;
        if ("...".equals(r8) == false) goto L24;
        if (org.c.a.j.a.f40485d.a(this.f40490d.c(3)) == false) goto L24;
    L34:
        return "";
    L36:
        if ("\n".equals(r2) == true) goto L40;
        return r2 + r4;
    L40:
        if (r4.length() != 0) goto L44;
        return " ";
    L44:
        return r4.toString();
    L25:
        this.f40490d.b();
        goto L24
    L20:
        if (P() == false) goto L22;
        return "";
    L46:
        return r1;
    L47:
        r0 = r0 + 1;
        goto L4
    }

    private String a(String r10, org.c.a.c.a r11) {
        int r0 = this.f40490d.c();
        if (r0 != 33) goto L17;
        int r6 = 1;
        int r1 = this.f40490d.c(1);
        if (r1 == 32) goto L15;
        int r7 = 1;
    L8:
        if (org.c.a.j.a.g.a(r1) == false) goto L10;
        r7 = r7 + 1;
        r1 = this.f40490d.c(r7);
        goto L8
    L10:
        if (r1 != 33) goto L12;
        r6 = 1 + r7;
        goto L15
    L12:
        this.f40490d.b(r7);
        throw new c("while scanning a " + r10, r11, "expected '!', but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    L15:
        return this.f40490d.e(r6);
    L17:
        throw new c("while scanning a " + r10, r11, "expected '!', but found " + String.valueOf(Character.toChars(r0)) + "(" + r0 + ")", this.f40490d.a());
    }

    private String b(String r6, org.c.a.c.a r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.f40490d.c(0);
        int r3 = 0;
    L4:
        if (org.c.a.j.a.f.a(r1) == false) goto L10;
        if (r1 != 37) goto L8;
        r0.append(this.f40490d.e(r3));
        r0.append(c(r6, r7));
        r3 = 0;
    L9:
        r1 = this.f40490d.c(r3);
        goto L4
    L8:
        r3 = r3 + 1;
        goto L9
    L10:
        if (r3 == 0) goto L13;
        r0.append(this.f40490d.e(r3));
    L13:
        if (r0.length() == 0) goto L17;
        return r0.toString();
    L17:
        throw new c("while scanning a " + r6, r7, "expected URI, but found " + String.valueOf(Character.toChars(r1)) + "(" + r1 + ")", this.f40490d.a());
    }

    private String c(String r9, org.c.a.c.a r10) {
        int r1 = 1;
    L4:
        if (this.f40490d.c(r1 * 3) != 37) goto L6;
        r1 = r1 + 1;
        goto L4
    L6:
        org.c.a.c.a r2 = this.f40490d.a();
        ByteBuffer r3 = ByteBuffer.allocate(r1);
    L8:
        if (this.f40490d.c() != 37) goto L14;
        this.f40490d.b();
        r3.put((byte) Integer.parseInt(this.f40490d.d(2), 16));     // Catch: NumberFormatException -> L12
        this.f40490d.b(2);
    L12:
        int r4 = this.f40490d.c();
        String r5 = String.valueOf(Character.toChars(r4));
        int r0 = this.f40490d.c(1);
        throw new c("while scanning a " + r9, r10, "expected URI escape sequence of 2 hexadecimal numbers, but found " + r5 + "(" + r4 + ") and " + String.valueOf(Character.toChars(r0)) + "(" + r0 + ")", this.f40490d.a());
    L14:
        r3.flip();
        return org.c.a.m.b.a(r3);
    L17:
        e = move-exception;
        throw new c("while scanning a " + r9, r10, "expected URI in UTF-8: " + e.getMessage(), r2);
    }

    private String R() {
        int r0 = this.f40490d.c();
        if (r0 == 13) goto L17;
        if (r0 == 10) goto L17;
        if (r0 == 133) goto L17;
        if (r0 != 8232) goto L11;
    L15:
        this.f40490d.b();
        return String.valueOf(Character.toChars(r0));
    L11:
        if (r0 == 8233) goto L15;
        return "";
    L17:
        if (r0 == 13) goto L19;
    L21:
        this.f40490d.b();
        return "\n";
    L19:
        if (10 != this.f40490d.c(1)) goto L21;
        this.f40490d.b(2);
        return "\n";
    }

    private List<v> a(v... r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L15;
        if (r5[r1] == null) goto L14;
        if (this.l == false) goto L11;
    L13:
        r0.add(r5[r1]);
        goto L14
    L11:
        if (ZeusTransformUtils.instanceOf(r5[r1], g.class) == false) goto L13;
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return r0;
    }
}
