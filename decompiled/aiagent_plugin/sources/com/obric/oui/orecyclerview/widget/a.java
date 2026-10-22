package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes4.dex */
final class a implements s.a {
    private static final String TAG = "AHT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<b> f35681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f35682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InterfaceC0964a f35683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Runnable f35684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f35685e;
    final s f;
    private androidx.core.util.f.a<b> g;
    private int h;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdapterHelper.java */
    interface InterfaceC0964a {
        RecyclerView.v a(int r1);

        void a(int r1, int r2);

        void a(int r1, int r2, Object r3);

        void a(b r1);

        void b(int r1, int r2);

        void b(b r1);

        void c(int r1, int r2);

        void d(int r1, int r2);
    }

    /* JADX INFO: compiled from: AdapterHelper.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35689d;

        b(int r1, int r2, int r3, Object r4) {
            this.f35686a = r1;
            this.f35687b = r2;
            this.f35689d = r3;
            this.f35688c = r4;
        }

        String a() {
            int r1 = this.f35686a;
            if (r1 != 1) goto L5;
            return "add";
        L5:
            if (r1 != 2) goto L7;
            return "rm";
        L7:
            if (r1 != 4) goto L9;
            return "up";
        L9:
            if (r1 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f35687b + "c:" + this.f35689d + ",p:" + this.f35688c + "]";
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            int r0 = this.f35686a;
            if (r0 == r6.f35686a) goto L12;
            return false;
        L12:
            if (r0 != 8) goto L21;
            if (Math.abs(this.f35689d - this.f35687b) != 1) goto L21;
            if (this.f35689d != r6.f35687b) goto L21;
            if (this.f35687b != r6.f35689d) goto L21;
            return true;
        L21:
            if (this.f35689d == r6.f35689d) goto L24;
            return false;
        L24:
            if (this.f35687b == r6.f35687b) goto L26;
            return false;
        L26:
            Object r4 = this.f35688c;
            if (r4 == null) goto L32;
            if (r4.equals(r6.f35688c) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r6.f35688c == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.f35686a * 31) + this.f35687b) * 31) + this.f35689d;
        }
    }

    a(InterfaceC0964a r3) {
        this((InterfaceC0964a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0964a.class, "com.obric.aiagent.plugin"), false);
    }

    a(InterfaceC0964a r3, boolean r4) {
        InterfaceC0964a r5 = (InterfaceC0964a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0964a.class, "com.obric.aiagent.plugin");
        this.g = new androidx.core.util.f.b(30);
        this.f35681a = new ArrayList();
        this.f35682b = new ArrayList();
        this.h = 0;
        this.f35683c = r5;
        this.f35685e = r4;
        this.f = new s(this);
    }

    void a() {
        a(this.f35681a);
        a(this.f35682b);
        this.h = 0;
    }

    void b() {
        this.f.a(this.f35681a);
        int r0 = this.f35681a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f35681a.get(r1), b.class, "com.obric.aiagent.plugin");
        int r3 = r2.f35686a;
        if (r3 != 1) goto L7;
        f(r2);
    L17:
        Runnable r4 = this.f35684d;
        if (r4 == null) goto L20;
        r4.run();
    L20:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        c(r2);
        goto L17
    L9:
        if (r3 != 4) goto L11;
        d(r2);
        goto L17
    L11:
        if (r3 != 8) goto L17;
        b(r2);
        goto L17
    L21:
        this.f35681a.clear();
    }

    void c() {
        int r0 = this.f35682b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.f35683c.b((b) ZeusTransformUtils.preCheckCast(this.f35682b.get(r2), b.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L3
    L5:
        a(this.f35682b);
        this.h = 0;
    }

    private void b(b r1) {
        g(r1);
    }

    private void c(b r11) {
        int r0 = r11.f35687b;
        int r1 = r11.f35687b + r11.f35689d;
        int r2 = r11.f35687b;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L23;
        if (this.f35683c.a(r2) == null) goto L8;
    L14:
        if (r4 != 0) goto L16;
        e(a(2, r0, r5, null));
        boolean r6 = true;
    L17:
        byte r7 = 1;
    L18:
        if (r6 == false) goto L20;
        r2 = r2 - r5;
        r1 = r1 - r5;
        r5 = 1;
    L21:
        r2 = r2 + 1;
        r4 = r7;
        goto L4
    L20:
        r5 = r5 + 1;
        goto L21
    L16:
        r6 = false;
        goto L17
    L8:
        if (d(r2) == true) goto L14;
        if (r4 != 1) goto L12;
        g(a(2, r0, r5, null));
        r6 = true;
    L13:
        r7 = 0;
        goto L18
    L12:
        r6 = false;
        goto L13
    L23:
        if (r5 == r11.f35689d) goto L25;
        a(r11);
        r11 = a(2, r0, r5, null);
    L25:
        if (r4 != 0) goto L27;
        e(r11);
        return;
    L27:
        g(r11);
    }

    private void d(b r10) {
        int r0 = r10.f35687b;
        int r1 = r10.f35687b + r10.f35689d;
        int r2 = r10.f35687b;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L18;
        if (this.f35683c.a(r2) == null) goto L8;
    L13:
        if (r4 != 0) goto L15;
        e(a(4, r0, r5, r10.f35688c));
        r0 = r2;
        r5 = 0;
    L15:
        r4 = 1;
    L16:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L4
    L8:
        if (d(r2) == true) goto L13;
        if (r4 != 1) goto L12;
        g(a(4, r0, r5, r10.f35688c));
        r0 = r2;
        r5 = 0;
    L12:
        r4 = 0;
        goto L16
    L18:
        if (r5 == r10.f35689d) goto L20;
        Object r3 = r10.f35688c;
        a(r10);
        r10 = a(4, r0, r5, r3);
    L20:
        if (r4 != 0) goto L22;
        e(r10);
        return;
    L22:
        g(r10);
    }

    private void e(b r13) {
        if (r13.f35686a == 1) goto L37;
        if (r13.f35686a == 8) goto L37;
        int r0 = d(r13.f35687b, r13.f35686a);
        int r2 = r13.f35687b;
        int r3 = r13.f35686a;
        if (r3 == 2) goto L12;
        if (r3 != 4) goto L11;
        int r4 = 1;
    L13:
        int r7 = 1;
        int r8 = 1;
    L15:
        if (r7 >= r13.f35689d) goto L32;
        int r9 = d(r13.f35687b + (r4 * r7), r13.f35686a);
        int r10 = r13.f35686a;
        if (r10 == 2) goto L23;
        if (r10 == 4) goto L21;
    L19:
        boolean r11 = false;
    L25:
        if (r11 == false) goto L27;
        r8 = r8 + 1;
    L31:
        r7 = r7 + 1;
        goto L15
    L27:
        b r1 = a(r13.f35686a, r0, r8, r13.f35688c);
        a(r1, r2);
        a(r1);
        if (r13.f35686a != 4) goto L30;
        r2 = r2 + r8;
    L30:
        r8 = 1;
        r0 = r9;
        goto L31
    L21:
        if (r9 != (r0 + 1)) goto L19;
    L22:
        r11 = true;
        goto L25
    L23:
        if (r9 != r0) goto L19;
    L32:
        Object r5 = r13.f35688c;
        a(r13);
        if (r8 <= 0) goto L41;
        b r14 = a(r13.f35686a, r0, r8, r5);
        a(r14, r2);
        a(r14);
        return;
    L41:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r13);
    L12:
        r4 = 0;
    L37:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void a(b r3, int r4) {
        this.f35683c.a(r3);
        int r0 = r3.f35686a;
        if (r0 != 2) goto L5;
        this.f35683c.a(r4, r3.f35689d);
        return;
    L5:
        if (r0 != 4) goto L8;
        this.f35683c.a(r4, r3.f35689d, r3.f35688c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    private int d(int r7, int r8) {
        int r0 = this.f35682b.size() - 1;
    L4:
        if (r0 < 0) goto L44;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f35682b.get(r0), b.class, "com.obric.aiagent.plugin");
        if (r3.f35686a != 8) goto L32;
        if (r3.f35687b >= r3.f35689d) goto L10;
        int r2 = r3.f35687b;
        int r4 = r3.f35689d;
    L11:
        if (r7 < r2) goto L26;
        if (r7 > r4) goto L26;
        if (r2 != r3.f35687b) goto L20;
        if (r8 != 1) goto L17;
        r3.f35689d++;
    L19:
        r7 = r7 + 1;
    L43:
        r0 = r0 - 1;
        goto L4
    L17:
        if (r8 != 2) goto L19;
        r3.f35689d--;
        goto L19
    L20:
        if (r8 != 1) goto L22;
        r3.f35687b++;
    L24:
        r7 = r7 - 1;
        goto L43
    L22:
        if (r8 != 2) goto L24;
        r3.f35687b--;
    L26:
        if (r7 >= r3.f35687b) goto L43;
        if (r8 != 1) goto L29;
        r3.f35687b++;
        r3.f35689d++;
        goto L43
    L29:
        if (r8 != 2) goto L43;
        r3.f35687b--;
        r3.f35689d--;
        goto L43
    L10:
        r2 = r3.f35689d;
        r4 = r3.f35687b;
        goto L11
    L32:
        if (r3.f35687b <= r7) goto L34;
        if (r8 != 1) goto L41;
        r3.f35687b++;
        goto L43
    L41:
        if (r8 != 2) goto L43;
        r3.f35687b--;
        goto L43
    L34:
        if (r3.f35686a != 1) goto L37;
        r7 = r7 - r3.f35689d;
        goto L43
    L37:
        if (r3.f35686a != 2) goto L43;
        r7 = r7 + r3.f35689d;
        goto L43
    L44:
        int r9 = this.f35682b.size() - 1;
    L45:
        if (r9 < 0) goto L57;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f35682b.get(r9), b.class, "com.obric.aiagent.plugin");
        if (r1.f35686a != 8) goto L54;
        if (r1.f35689d != r1.f35687b) goto L51;
    L52:
        this.f35682b.remove(r9);
        a(r1);
    L56:
        r9 = r9 - 1;
        goto L45
    L51:
        if (r1.f35689d >= 0) goto L56;
    L54:
        if (r1.f35689d > 0) goto L56;
        this.f35682b.remove(r9);
        a(r1);
        goto L56
    L57:
        return r7;
    }

    private boolean d(int r8) {
        int r0 = this.f35682b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f35682b.get(r2), b.class, "com.obric.aiagent.plugin");
        if (r3.f35686a != 8) goto L10;
        if (a(r3.f35689d, r2 + 1) != r8) goto L17;
        return true;
    L17:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r3.f35686a != 1) goto L17;
        int r4 = r3.f35687b + r3.f35689d;
        int r5 = r3.f35687b;
    L12:
        if (r5 >= r4) goto L17;
        if (a(r5, r2 + 1) == r8) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return true;
    L18:
        return false;
    }

    private void f(b r1) {
        g(r1);
    }

    private void g(b r3) {
        this.f35682b.add(r3);
        int r0 = r3.f35686a;
        if (r0 != 1) goto L5;
        this.f35683c.c(r3.f35687b, r3.f35689d);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.f35683c.b(r3.f35687b, r3.f35689d);
        return;
    L7:
        if (r0 != 4) goto L9;
        this.f35683c.a(r3.f35687b, r3.f35689d, r3.f35688c);
        return;
    L9:
        if (r0 != 8) goto L12;
        this.f35683c.d(r3.f35687b, r3.f35689d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r3);
    }

    boolean d() {
        if (this.f35681a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean a(int r1) {
        if ((this.h & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int b(int r2) {
        return a(r2, 0);
    }

    int a(int r5, int r6) {
        int r0 = this.f35682b.size();
    L3:
        if (r6 >= r0) goto L28;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f35682b.get(r6), b.class, "com.obric.aiagent.plugin");
        if (r1.f35686a != 8) goto L16;
        if (r1.f35687b != r5) goto L10;
        r5 = r1.f35689d;
    L27:
        r6 = r6 + 1;
        goto L3
    L10:
        if (r1.f35687b >= r5) goto L13;
        r5 = r5 - 1;
    L13:
        if (r1.f35689d > r5) goto L27;
        r5 = r5 + 1;
        goto L27
    L16:
        if (r1.f35687b > r5) goto L27;
        if (r1.f35686a != 2) goto L25;
        if (r5 < (r1.f35687b + r1.f35689d)) goto L21;
        r5 = r5 - r1.f35689d;
        goto L27
    L21:
        return -1;
    L25:
        if (r1.f35686a != 1) goto L27;
        r5 = r5 + r1.f35689d;
        goto L27
    L28:
        return r5;
    }

    boolean a(int r5, int r6, Object r7) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.f35681a.add(a(4, r5, r6, r7));
        this.h |= 4;
        if (this.f35681a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean b(int r5, int r6) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.f35681a.add(a(1, r5, r6, null));
        this.h |= 1;
        if (this.f35681a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean c(int r6, int r7) {
        if (r7 >= 1) goto L5;
        return false;
    L5:
        this.f35681a.add(a(2, r6, r7, null));
        this.h |= 2;
        if (this.f35681a.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean a(int r5, int r6, int r7) {
        if (r5 != r6) goto L6;
        return false;
    L6:
        if (r7 != 1) goto L12;
        this.f35681a.add(a(8, r5, r6, null));
        this.h |= 8;
        if (this.f35681a.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    void e() {
        c();
        int r0 = this.f35681a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f35681a.get(r2), b.class, "com.obric.aiagent.plugin");
        int r4 = r3.f35686a;
        if (r4 != 1) goto L7;
        this.f35683c.b(r3);
        this.f35683c.c(r3.f35687b, r3.f35689d);
    L17:
        Runnable r5 = this.f35684d;
        if (r5 == null) goto L20;
        r5.run();
    L20:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.f35683c.b(r3);
        this.f35683c.a(r3.f35687b, r3.f35689d);
        goto L17
    L9:
        if (r4 != 4) goto L11;
        this.f35683c.b(r3);
        this.f35683c.a(r3.f35687b, r3.f35689d, r3.f35688c);
        goto L17
    L11:
        if (r4 != 8) goto L17;
        this.f35683c.b(r3);
        this.f35683c.d(r3.f35687b, r3.f35689d);
        goto L17
    L21:
        a(this.f35681a);
        this.h = 0;
    }

    public int c(int r6) {
        int r0 = this.f35681a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L31;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f35681a.get(r1), b.class, "com.obric.aiagent.plugin");
        int r3 = r2.f35686a;
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L21;
        if (r3 != 8) goto L30;
        if (r2.f35687b != r6) goto L15;
        r6 = r2.f35689d;
        goto L30
    L15:
        if (r2.f35687b >= r6) goto L18;
        r6 = r6 - 1;
    L18:
        if (r2.f35689d > r6) goto L30;
        r6 = r6 + 1;
    L30:
        r1 = r1 + 1;
        goto L3
    L21:
        if (r2.f35687b > r6) goto L30;
        if ((r2.f35687b + r2.f35689d) > r6) goto L24;
        r6 = r6 - r2.f35689d;
        goto L30
    L24:
        return -1;
    L28:
        if (r2.f35687b > r6) goto L30;
        r6 = r6 + r2.f35689d;
        goto L30
    L31:
        return r6;
    }

    boolean f() {
        if (this.f35682b.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f35681a.isEmpty() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public b a(int r3, int r4, int r5, Object r6) {
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.g.a(), b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        r2.f35686a = r3;
        r2.f35687b = r4;
        r2.f35689d = r5;
        r2.f35688c = r6;
        return r2;
    L7:
        return new b(r3, r4, r5, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void a(b r2) {
        if (this.f35685e == true) goto L6;
        r2.f35688c = null;
        this.g.a(r2);
        return;
    }

    void a(List<b> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        a((b) ZeusTransformUtils.preCheckCast(r7.get(r2), b.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L3
    L5:
        r7.clear();
    }
}
