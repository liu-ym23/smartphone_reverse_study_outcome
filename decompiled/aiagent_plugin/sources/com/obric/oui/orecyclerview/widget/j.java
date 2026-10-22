package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiffUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<c> f35775a = null;

    /* JADX INFO: compiled from: DiffUtil.java */
    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int r1, int r2);

        public abstract int b();

        public abstract boolean b(int r1, int r2);

        public Object c(int r1, int r2) {
            return null;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f35776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35777b;

        b(int r1) {
            int[] r2 = new int[r1];
            this.f35776a = r2;
            this.f35777b = r2.length / 2;
        }

        int a(int r2) {
            return this.f35776a[r2 + this.f35777b];
        }

        int[] a() {
            return this.f35776a;
        }

        void a(int r2, int r3) {
            this.f35776a[r2 + this.f35777b] = r3;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35780c;

        c(int r1, int r2, int r3) {
            this.f35778a = r1;
            this.f35779b = r2;
            this.f35780c = r3;
        }

        int a() {
            return this.f35778a + this.f35780c;
        }

        int b() {
            return this.f35779b + this.f35780c;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<c> f35781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f35782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f35783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f35784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35785e;
        private final int f;
        private final boolean g;

        d(a r3, List<c> r4, int[] r5, int[] r6, boolean r7) {
            this.f35781a = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f35782b = r5;
            this.f35783c = r6;
            Arrays.fill(r5, 0);
            Arrays.fill(r6, 0);
            this.f35784d = r3;
            this.f35785e = r3.a();
            this.f = r3.b();
            this.g = r7;
            a();
            b();
        }

        private void a() {
            if (this.f35781a.isEmpty() == false) goto L5;
            c r0 = null;
        L6:
            if (r0 != null) goto L8;
        L11:
            this.f35781a.add(0, new c(0, 0, 0));
        L12:
            this.f35781a.add(new c(this.f35785e, this.f, 0));
            return;
        L8:
            if (r0.f35778a != 0) goto L11;
            if (r0.f35779b == 0) goto L12;
        L5:
            r0 = (c) ZeusTransformUtils.preCheckCast(this.f35781a.get(0), c.class, "com.obric.aiagent.plugin");
            goto L6
        }

        private void b() {
            Iterator<c> r0 = this.f35781a.iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
            int r2 = 0;
        L7:
            if (r2 >= r1.f35780c) goto L4;
            int r3 = r1.f35778a + r2;
            int r4 = r1.f35779b + r2;
            if (this.f35784d.b(r3, r4) == false) goto L11;
            int r5 = 1;
        L12:
            this.f35782b[r3] = (r4 << 4) | r5;
            this.f35783c[r4] = (r3 << 4) | r5;
            r2 = r2 + 1;
            goto L7
        L11:
            r5 = 2;
            goto L12
        L14:
            if (this.g == false) goto L21;
            c();
            return;
        }

        private void c() {
            Iterator<c> r0 = this.f35781a.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L13;
            c r2 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        L7:
            if (r1 >= r2.f35778a) goto L12;
            if (this.f35782b[r1] != 0) goto L11;
            a(r1);
        L11:
            r1 = r1 + 1;
            goto L7
        L12:
            r1 = r2.a();
            goto L4
        }

        private void a(int r7) {
            int r0 = this.f35781a.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L19;
            c r3 = (c) ZeusTransformUtils.preCheckCast(this.f35781a.get(r1), c.class, "com.obric.aiagent.plugin");
        L6:
            if (r2 >= r3.f35779b) goto L18;
            if (this.f35783c[r2] != 0) goto L17;
            if (this.f35784d.a(r7, r2) == false) goto L17;
            if (this.f35784d.b(r7, r2) == false) goto L14;
            int r4 = 8;
        L15:
            this.f35782b[r7] = (r2 << 4) | r4;
            this.f35783c[r2] = (r7 << 4) | r4;
            return;
        L14:
            r4 = 4;
        L17:
            r2 = r2 + 1;
            goto L6
        L18:
            r2 = r3.b();
            r1 = r1 + 1;
            goto L3
        }

        public void a(RecyclerView.a r2) {
            a(new com.obric.oui.orecyclerview.widget.b(r2));
        }

        public void a(q r14) {
            q r15 = (q) ZeusTransformUtils.wrapperContextForParams(r14, q.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.orecyclerview.widget.e.class) == false) goto L5;
            com.obric.oui.orecyclerview.widget.e r16 = (com.obric.oui.orecyclerview.widget.e) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.orecyclerview.widget.e.class, "com.obric.aiagent.plugin");
        L6:
            int r0 = this.f35785e;
            ArrayDeque r2 = new ArrayDeque();
            int r3 = this.f35785e;
            int r4 = this.f;
            int r5 = this.f35781a.size() - 1;
        L7:
            if (r5 < 0) goto L38;
            c r7 = (c) ZeusTransformUtils.preCheckCast(this.f35781a.get(r5), c.class, "com.obric.aiagent.plugin");
            int r8 = r7.a();
            int r9 = r7.b();
        L9:
            int r10 = 0;
            if (r3 <= r8) goto L20;
            r3 = r3 - 1;
            int r11 = this.f35782b[r3];
            if ((r11 & 12) != 0) goto L13;
            r16.b(r3, 1);
            r0 = r0 - 1;
            goto L9
        L13:
            int r12 = r11 >> 4;
            f r13 = a(r2, r12, false);
            if (r13 != null) goto L15;
            r2.add(new f(r3, (r0 - r3) - 1, true));
            goto L9
        L15:
            int r17 = (r0 - r13.f35787b) - 1;
            r16.c(r3, r17);
            if ((r11 & 4) == 0) goto L9;
            r16.a(r17, 1, this.f35784d.c(r3, r12));
        L20:
            if (r4 <= r9) goto L30;
            r4 = r4 - 1;
            int r18 = this.f35783c[r4];
            if ((r18 & 12) != 0) goto L23;
            r16.a(r3, 1);
            r0 = r0 + 1;
            goto L20
        L23:
            int r19 = r18 >> 4;
            f r110 = a(r2, r19, true);
            if (r110 == null) goto L25;
            r16.c((r0 - r110.f35787b) - 1, r3);
            if ((r18 & 4) == 0) goto L20;
            r16.a(r3, 1, this.f35784d.c(r19, r4));
            goto L20
        L25:
            r2.add(new f(r4, r0 - r3, false));
            goto L20
        L30:
            int r6 = r7.f35778a;
            int r20 = r7.f35779b;
        L32:
            if (r10 >= r7.f35780c) goto L37;
            if ((this.f35782b[r6] & 15) != 2) goto L36;
            r16.a(r6, 1, this.f35784d.c(r6, r20));
        L36:
            r6 = r6 + 1;
            r20 = r20 + 1;
            r10 = r10 + 1;
            goto L32
        L37:
            r3 = r7.f35778a;
            r4 = r7.f35779b;
            r5 = r5 - 1;
            goto L7
        L38:
            r16.a();
            return;
        L5:
            r16 = new com.obric.oui.orecyclerview.widget.e(r15);
            goto L6
        }

        private static f a(Collection<f> r3, int r4, boolean r5) {
            Iterator r6 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L10;
            f r0 = (f) ZeusTransformUtils.preCheckCast(r6.next(), f.class, "com.obric.aiagent.plugin");
            if (r0.f35786a != r4) goto L4;
            if (r0.f35788c != r5) goto L4;
            r6.remove();
        L12:
            if (r6.hasNext() == false) goto L17;
            f r7 = (f) ZeusTransformUtils.preCheckCast(r6.next(), f.class, "com.obric.aiagent.plugin");
            if (r5 == true) goto L15;
            r7.f35787b++;
            goto L12
        L15:
            r7.f35787b--;
            goto L12
        L17:
            return r0;
        L10:
            r0 = null;
            goto L12
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    public static abstract class e<T> {
        public abstract boolean a(T r1, T r2);

        public abstract boolean b(T r1, T r2);

        public Object c(T r1, T r2) {
            return null;
        }

        public e() {
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f35788c;

        f(int r1, int r2, boolean r3) {
            this.f35786a = r1;
            this.f35787b = r2;
            this.f35788c = r3;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f35791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35792d;

        public g() {
        }

        public g(int r1, int r2, int r3, int r4) {
            this.f35789a = r1;
            this.f35790b = r2;
            this.f35791c = r3;
            this.f35792d = r4;
        }

        int a() {
            return this.f35790b - this.f35789a;
        }

        int b() {
            return this.f35792d - this.f35791c;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f35793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f35794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f35796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f35797e;

        h() {
        }

        boolean a() {
            if ((this.f35796d - this.f35794b) == (this.f35795c - this.f35793a)) goto L5;
            return true;
        L5:
            return false;
        }

        boolean b() {
            if ((this.f35796d - this.f35794b) <= (this.f35795c - this.f35793a)) goto L5;
            return true;
        L5:
            return false;
        }

        int c() {
            return Math.min(this.f35795c - this.f35793a, this.f35796d - this.f35794b);
        }

        c d() {
            if (a() == true) goto L5;
            int r1 = this.f35793a;
            return new c(r1, this.f35794b, this.f35795c - r1);
        L5:
            if (this.f35797e == false) goto L9;
            return new c(this.f35793a, this.f35794b, c());
        L9:
            if (b() == false) goto L13;
            return new c(this.f35793a, this.f35794b + 1, c());
        L13:
            return new c(this.f35793a + 1, this.f35794b, c());
        }
    }

    static {
        f35775a = new AnonymousClass1();
    }

    public static d a(a r1) {
        return a(r1, true);
    }

    public static d a(a r10, boolean r11) {
        int r0 = r10.a();
        int r1 = r10.b();
        ArrayList r4 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r2.add(new g(0, r0, 0, r1));
        int r3 = ((((r0 + r1) + 1) / 2) * 2) + 1;
        b r5 = new b(r3);
        b r6 = new b(r3);
        ArrayList r7 = new ArrayList();
    L4:
        if (r2.isEmpty() == true) goto L16;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r2.remove(r2.size() - 1), g.class, "com.obric.aiagent.plugin");
        h r9 = a(r8, r10, r5, r6);
        if (r9 != null) goto L8;
        r7.add(r8);
        goto L4
    L8:
        if (r9.c() <= 0) goto L11;
        r4.add(r9.d());
    L11:
        if (r7.isEmpty() == false) goto L13;
        g r12 = new g();
    L14:
        r12.f35789a = r8.f35789a;
        r12.f35791c = r8.f35791c;
        r12.f35790b = r9.f35793a;
        r12.f35792d = r9.f35794b;
        r2.add(r12);
        r8.f35790b = r8.f35790b;
        r8.f35792d = r8.f35792d;
        r8.f35789a = r9.f35795c;
        r8.f35791c = r9.f35796d;
        r2.add(r8);
        goto L4
    L13:
        r12 = (g) ZeusTransformUtils.preCheckCast(r7.remove(r7.size() - 1), g.class, "com.obric.aiagent.plugin");
        goto L14
    L16:
        Collections.sort(r4, f35775a);
        return new d(r10, r4, r5.a(), r6.a(), r11);
    }

    private static h a(g r4, a r5, b r6, b r7) {
        if (r4.a() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r4.b() < 1) goto L16;
        int r0 = ((r4.a() + r4.b()) + 1) / 2;
        r6.a(1, r4.f35789a);
        r7.a(1, r4.f35790b);
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L16;
        h r3 = a(r4, r5, r6, r7, r2);
        if (r3 != null) goto L11;
        h r8 = b(r4, r5, r6, r7, r2);
        if (r8 != null) goto L14;
        r2 = r2 + 1;
        goto L8
    L14:
        return r8;
    L11:
        return r3;
    }

    private static h a(g r11, a r12, b r13, b r14, int r15) {
        boolean r2 = true;
        if ((Math.abs(r11.a() - r11.b()) % 2) == 1) goto L6;
        r2 = false;
    L6:
        int r0 = r11.a() - r11.b();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L39;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r13.a(r4 - 1);
        int r6 = r5 + 1;
    L15:
        int r7 = (r11.f35791c + (r6 - r11.f35789a)) - r4;
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 - 1;
    L22:
        if (r6 >= r11.f35790b) goto L28;
        if (r7 >= r11.f35792d) goto L28;
        if (r12.a(r6, r7) == false) goto L28;
        r6 = r6 + 1;
        r7 = r7 + 1;
    L28:
        r13.a(r4, r6);
        if (r2 == false) goto L38;
        int r9 = r0 - r4;
        if (r9 < (r3 + 1)) goto L38;
        if (r9 > (r15 - 1)) goto L38;
        if (r14.a(r9) > r6) goto L38;
        h r16 = new h();
        r16.f35793a = r5;
        r16.f35794b = r8;
        r16.f35795c = r6;
        r16.f35796d = r7;
        r16.f35797e = false;
        return r16;
    L38:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r13.a(r4 + 1) <= r13.a(r4 - 1)) goto L13;
    L14:
        r5 = r13.a(r4 + 1);
        r6 = r5;
        goto L15
    L39:
        return null;
    }

    private static h b(g r11, a r12, b r13, b r14, int r15) {
        if (((r11.a() - r11.b()) % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        int r2 = r11.a() - r11.b();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L38;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r14.a(r4 - 1);
        int r6 = r5 - 1;
    L15:
        int r7 = r11.f35792d - ((r11.f35790b - r6) - r4);
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 + 1;
    L22:
        if (r6 <= r11.f35789a) goto L28;
        if (r7 <= r11.f35791c) goto L28;
        if (r12.a(r6 - 1, r7 - 1) == false) goto L28;
        r6 = r6 - 1;
        r7 = r7 - 1;
    L28:
        r14.a(r4, r6);
        if (r0 == false) goto L37;
        int r9 = r2 - r4;
        if (r9 < r3) goto L37;
        if (r9 > r15) goto L37;
        if (r13.a(r9) < r6) goto L37;
        h r16 = new h();
        r16.f35793a = r6;
        r16.f35794b = r7;
        r16.f35795c = r5;
        r16.f35796d = r8;
        r16.f35797e = true;
        return r16;
    L37:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r14.a(r4 + 1) >= r14.a(r4 - 1)) goto L13;
    L14:
        r5 = r14.a(r4 + 1);
        r6 = r5;
        goto L15
    L38:
        return null;
    L5:
        r0 = false;
        goto L6
    }
}
