package com.obric.oui.orecyclerview.widget;

import androidx.core.util.Pools$Pool;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AdapterHelper implements OpReorderer.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pools$Pool f15377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f15379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callback f15380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f15381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OpReorderer f15383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15384h;

    public interface Callback {
        RecyclerView.t findViewHolder(int r10);

        void markViewHoldersUpdated(int r10, int r11, Object r12);

        void offsetPositionsForAdd(int r10, int r11);

        void offsetPositionsForMove(int r10, int r11);

        void offsetPositionsForRemovingInvisible(int r10, int r11);

        void offsetPositionsForRemovingLaidOutOrNewView(int r10, int r11);

        void onDispatchFirstPass(a r10);

        void onDispatchSecondPass(a r10);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15388d;

        public a(int r10, int r11, int r12, Object r13) {
            this.f15385a = r10;
            this.f15386b = r11;
            this.f15388d = r12;
            this.f15387c = r13;
        }

        public String a() {
            int r10 = this.f15385a;
            if (r10 != 1) goto L5;
            return "add";
        L5:
            if (r10 != 2) goto L7;
            return "rm";
        L7:
            if (r10 != 4) goto L9;
            return "up";
        L9:
            if (r10 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            int r12 = this.f15385a;
            if (r12 == r11.f15385a) goto L12;
            return false;
        L12:
            if (r12 != 8) goto L21;
            if (Math.abs(this.f15388d - this.f15386b) != 1) goto L21;
            if (this.f15388d != r11.f15386b) goto L21;
            if (this.f15386b != r11.f15388d) goto L21;
            return true;
        L21:
            if (this.f15388d == r11.f15388d) goto L24;
            return false;
        L24:
            if (this.f15386b == r11.f15386b) goto L26;
            return false;
        L26:
            Object r13 = this.f15387c;
            if (r13 == null) goto L32;
            if (r13.equals(r11.f15387c) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r11.f15387c == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.f15385a * 31) + this.f15386b) * 31) + this.f15388d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f15386b + "c:" + this.f15388d + ",p:" + this.f15387c + "]";
        }
    }

    public AdapterHelper(Callback r10) {
        this(r10, false);
    }

    public final void a(a r10) {
        p(r10);
    }

    public final void b(a r10) {
        p(r10);
    }

    public int c(int r10) {
        int r11 = this.f15378b.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L30;
        a r13 = (a) this.f15378b.get(r12);
        int r14 = r13.f15385a;
        if (r14 == 1) goto L27;
        if (r14 != 2) goto L9;
        int r15 = r13.f15386b;
        if (r15 > r10) goto L29;
        int r16 = r13.f15388d;
        if ((r15 + r16) > r10) goto L23;
        r10 = r10 - r16;
        goto L29
    L23:
        return -1;
    L29:
        r12 = r12 + 1;
        goto L3
    L9:
        if (r14 != 8) goto L29;
        int r17 = r13.f15386b;
        if (r17 != r10) goto L14;
        r10 = r13.f15388d;
        goto L29
    L14:
        if (r17 >= r10) goto L17;
        r10 = r10 - 1;
    L17:
        if (r13.f15388d > r10) goto L29;
        r10 = r10 + 1;
        goto L29
    L27:
        if (r13.f15386b > r10) goto L29;
        r10 = r10 + r13.f15388d;
        goto L29
    L30:
        return r10;
    }

    public final void d(a r11) {
        int r10 = r11.f15386b;
        int r12 = r11.f15388d + r10;
        byte r13 = -1;
        int r14 = r10;
        int r15 = 0;
    L4:
        if (r14 >= r12) goto L23;
        if (this.f15380d.findViewHolder(r14) == null) goto L8;
    L14:
        if (r13 != 0) goto L16;
        i(obtainUpdateOp(2, r10, r15, null));
        boolean r16 = true;
    L17:
        byte r17 = 1;
    L18:
        if (r16 == false) goto L20;
        r14 = r14 - r15;
        r12 = r12 - r15;
        r15 = 1;
    L21:
        r14 = r14 + 1;
        r13 = r17;
        goto L4
    L20:
        r15 = r15 + 1;
        goto L21
    L16:
        r16 = false;
        goto L17
    L8:
        if (f(r14) == true) goto L14;
        if (r13 != 1) goto L12;
        p(obtainUpdateOp(2, r10, r15, null));
        r16 = true;
    L13:
        r17 = 0;
        goto L18
    L12:
        r16 = false;
        goto L13
    L23:
        if (r15 == r11.f15388d) goto L25;
        recycleUpdateOp(r11);
        r11 = obtainUpdateOp(2, r10, r15, null);
    L25:
        if (r13 != 0) goto L27;
        i(r11);
        return;
    L27:
        p(r11);
    }

    public final void e(a r10) {
        int r11 = r10.f15386b;
        int r12 = r10.f15388d + r11;
        int r13 = 0;
        byte r14 = -1;
        int r15 = r11;
    L4:
        if (r11 >= r12) goto L18;
        if (this.f15380d.findViewHolder(r11) == null) goto L8;
    L13:
        if (r14 != 0) goto L15;
        i(obtainUpdateOp(4, r15, r13, r10.f15387c));
        r15 = r11;
        r13 = 0;
    L15:
        r14 = 1;
    L16:
        r13 = r13 + 1;
        r11 = r11 + 1;
        goto L4
    L8:
        if (f(r11) == true) goto L13;
        if (r14 != 1) goto L12;
        p(obtainUpdateOp(4, r15, r13, r10.f15387c));
        r15 = r11;
        r13 = 0;
    L12:
        r14 = 0;
        goto L16
    L18:
        if (r13 == r10.f15388d) goto L20;
        Object r16 = r10.f15387c;
        recycleUpdateOp(r10);
        r10 = obtainUpdateOp(4, r15, r13, r16);
    L20:
        if (r14 != 0) goto L22;
        i(r10);
        return;
    L22:
        p(r10);
    }

    public final boolean f(int r10) {
        int r11 = this.f15379c.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        a r13 = (a) this.f15379c.get(r12);
        int r14 = r13.f15385a;
        if (r14 == 8) goto L7;
        if (r14 != 1) goto L16;
        int r15 = r13.f15386b;
        int r16 = r13.f15388d + r15;
    L11:
        if (r15 >= r16) goto L16;
        if (l(r15, r12 + 1) == r10) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return true;
    L16:
        r12 = r12 + 1;
        goto L3
    L7:
        if (l(r13.f15388d, r12 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    public void g() {
        int r10 = this.f15379c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f15380d.onDispatchSecondPass((a) this.f15379c.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        r(this.f15379c);
        this.f15384h = 0;
    }

    public void h() {
        g();
        int r10 = this.f15378b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        a r12 = (a) this.f15378b.get(r11);
        int r13 = r12.f15385a;
        if (r13 != 1) goto L7;
        this.f15380d.onDispatchSecondPass(r12);
        this.f15380d.offsetPositionsForAdd(r12.f15386b, r12.f15388d);
    L17:
        Runnable r14 = this.f15381e;
        if (r14 == null) goto L20;
        r14.run();
    L20:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        this.f15380d.onDispatchSecondPass(r12);
        this.f15380d.offsetPositionsForRemovingInvisible(r12.f15386b, r12.f15388d);
        goto L17
    L9:
        if (r13 != 4) goto L11;
        this.f15380d.onDispatchSecondPass(r12);
        this.f15380d.markViewHoldersUpdated(r12.f15386b, r12.f15388d, r12.f15387c);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        this.f15380d.onDispatchSecondPass(r12);
        this.f15380d.offsetPositionsForMove(r12.f15386b, r12.f15388d);
        goto L17
    L21:
        r(this.f15378b);
        this.f15384h = 0;
    }

    public final void i(a r12) {
        int r10 = r12.f15385a;
        if (r10 == 1) goto L35;
        if (r10 == 8) goto L35;
        int r11 = t(r12.f15386b, r10);
        int r13 = r12.f15386b;
        int r14 = r12.f15385a;
        if (r14 == 2) goto L12;
        if (r14 != 4) goto L11;
        int r15 = 1;
    L13:
        int r16 = 1;
        int r17 = 1;
    L15:
        if (r16 >= r12.f15388d) goto L30;
        int r18 = t(r12.f15386b + (r15 * r16), r12.f15385a);
        int r19 = r12.f15385a;
        if (r19 == 2) goto L23;
        if (r19 == 4) goto L21;
    L25:
        a r20 = obtainUpdateOp(r19, r11, r17, r12.f15387c);
        j(r20, r13);
        recycleUpdateOp(r20);
        if (r12.f15385a != 4) goto L28;
        r13 = r13 + r17;
    L28:
        r17 = 1;
        r11 = r18;
    L29:
        r16 = r16 + 1;
        goto L15
    L21:
        if (r18 != (r11 + 1)) goto L25;
    L24:
        r17 = r17 + 1;
        goto L29
    L23:
        if (r18 != r11) goto L25;
    L30:
        Object r21 = r12.f15387c;
        recycleUpdateOp(r12);
        if (r17 <= 0) goto L39;
        a r110 = obtainUpdateOp(r12.f15385a, r11, r17, r21);
        j(r110, r13);
        recycleUpdateOp(r110);
        return;
    L39:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r12);
    L12:
        r15 = 0;
    L35:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void j(a r10, int r11) {
        this.f15380d.onDispatchFirstPass(r10);
        int r12 = r10.f15385a;
        if (r12 != 2) goto L5;
        this.f15380d.offsetPositionsForRemovingInvisible(r11, r10.f15388d);
        return;
    L5:
        if (r12 != 4) goto L8;
        this.f15380d.markViewHoldersUpdated(r11, r10.f15388d, r10.f15387c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public int k(int r10) {
        return l(r10, 0);
    }

    public int l(int r10, int r11) {
        int r12 = this.f15379c.size();
    L3:
        if (r11 >= r12) goto L27;
        a r13 = (a) this.f15379c.get(r11);
        int r14 = r13.f15385a;
        if (r14 != 8) goto L14;
        int r15 = r13.f15386b;
        if (r15 != r10) goto L9;
        r10 = r13.f15388d;
    L26:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r15 >= r10) goto L12;
        r10 = r10 - 1;
    L12:
        if (r13.f15388d > r10) goto L26;
        r10 = r10 + 1;
        goto L26
    L14:
        int r16 = r13.f15386b;
        if (r16 > r10) goto L26;
        if (r14 != 2) goto L24;
        int r17 = r13.f15388d;
        if (r10 < (r16 + r17)) goto L20;
        r10 = r10 - r17;
        goto L26
    L20:
        return -1;
    L24:
        if (r14 != 1) goto L26;
        r10 = r10 + r13.f15388d;
        goto L26
    L27:
        return r10;
    }

    public boolean m(int r10) {
        if ((this.f15384h & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        if (this.f15378b.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        if (this.f15379c.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f15378b.isEmpty() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.OpReorderer.Callback
    public a obtainUpdateOp(int r10, int r11, int r12, Object r13) {
        a r14 = (a) this.f15377a.acquire();
        if (r14 == null) goto L7;
        r14.f15385a = r10;
        r14.f15386b = r11;
        r14.f15388d = r12;
        r14.f15387c = r13;
        return r14;
    L7:
        return new a(r10, r11, r12, r13);
    }

    public final void p(a r10) {
        this.f15379c.add(r10);
        int r11 = r10.f15385a;
        if (r11 != 1) goto L5;
        this.f15380d.offsetPositionsForAdd(r10.f15386b, r10.f15388d);
        return;
    L5:
        if (r11 != 2) goto L7;
        this.f15380d.offsetPositionsForRemovingLaidOutOrNewView(r10.f15386b, r10.f15388d);
        return;
    L7:
        if (r11 != 4) goto L9;
        this.f15380d.markViewHoldersUpdated(r10.f15386b, r10.f15388d, r10.f15387c);
        return;
    L9:
        if (r11 != 8) goto L12;
        this.f15380d.offsetPositionsForMove(r10.f15386b, r10.f15388d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r10);
    }

    public void q() {
        this.f15383g.b(this.f15378b);
        int r10 = this.f15378b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        a r12 = (a) this.f15378b.get(r11);
        int r13 = r12.f15385a;
        if (r13 != 1) goto L7;
        a(r12);
    L17:
        Runnable r14 = this.f15381e;
        if (r14 == null) goto L20;
        r14.run();
    L20:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        d(r12);
        goto L17
    L9:
        if (r13 != 4) goto L11;
        e(r12);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        b(r12);
        goto L17
    L21:
        this.f15378b.clear();
    }

    public void r(List r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        recycleUpdateOp((a) r10.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        r10.clear();
    }

    @Override // com.obric.oui.orecyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(a r10) {
        if (this.f15382f == true) goto L6;
        r10.f15387c = null;
        this.f15377a.release(r10);
        return;
    }

    public void s() {
        r(this.f15378b);
        r(this.f15379c);
        this.f15384h = 0;
    }

    public final int t(int r10, int r11) {
        int r12 = this.f15379c.size() - 1;
    L4:
        if (r12 < 0) goto L40;
        a r13 = (a) this.f15379c.get(r12);
        int r14 = r13.f15385a;
        if (r14 != 8) goto L29;
        int r15 = r13.f15386b;
        int r16 = r13.f15388d;
        if (r15 >= r16) goto L10;
        int r17 = r15;
        int r18 = r16;
    L11:
        if (r10 < r17) goto L24;
        if (r10 > r18) goto L24;
        if (r17 != r15) goto L19;
        if (r11 != 1) goto L16;
        r13.f15388d = r16 + 1;
    L18:
        r10 = r10 + 1;
    L39:
        r12 = r12 - 1;
        goto L4
    L16:
        if (r11 != 2) goto L18;
        r13.f15388d = r16 - 1;
        goto L18
    L19:
        if (r11 != 1) goto L21;
        r13.f15386b = r15 + 1;
    L23:
        r10 = r10 - 1;
        goto L39
    L21:
        if (r11 != 2) goto L23;
        r13.f15386b = r15 - 1;
    L24:
        if (r10 >= r15) goto L39;
        if (r11 != 1) goto L27;
        r13.f15386b = r15 + 1;
        r13.f15388d = r16 + 1;
        goto L39
    L27:
        if (r11 != 2) goto L39;
        r13.f15386b = r15 - 1;
        r13.f15388d = r16 - 1;
        goto L39
    L10:
        r18 = r15;
        r17 = r16;
        goto L11
    L29:
        int r19 = r13.f15386b;
        if (r19 > r10) goto L35;
        if (r14 != 1) goto L33;
        r10 = r10 - r13.f15388d;
        goto L39
    L33:
        if (r14 != 2) goto L39;
        r10 = r10 + r13.f15388d;
        goto L39
    L35:
        if (r11 != 1) goto L37;
        r13.f15386b = r19 + 1;
        goto L39
    L37:
        if (r11 != 2) goto L39;
        r13.f15386b = r19 - 1;
        goto L39
    L40:
        int r110 = this.f15379c.size() - 1;
    L41:
        if (r110 < 0) goto L52;
        a r20 = (a) this.f15379c.get(r110);
        if (r20.f15385a != 8) goto L49;
        int r21 = r20.f15388d;
        if (r21 == r20.f15386b) goto L47;
        if (r21 < 0) goto L47;
    L51:
        r110 = r110 - 1;
    L47:
        this.f15379c.remove(r110);
        recycleUpdateOp(r20);
        goto L51
    L49:
        if (r20.f15388d > 0) goto L51;
        this.f15379c.remove(r110);
        recycleUpdateOp(r20);
        goto L51
    L52:
        return r10;
    }

    public AdapterHelper(Callback r10, boolean r11) {
        this.f15377a = new androidx.core.util.d(30);
        this.f15378b = new ArrayList();
        this.f15379c = new ArrayList();
        this.f15384h = 0;
        this.f15380d = r10;
        this.f15382f = r11;
        this.f15383g = new OpReorderer(this);
    }
}
