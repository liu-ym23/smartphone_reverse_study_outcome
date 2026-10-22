package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterHelper implements OpReorderer.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pools$Pool f4030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callback f4033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f4034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OpReorderer f4036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4037h;

    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int r10);

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
        public int f4038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f4040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4041d;

        public a(int r10, int r11, int r12, Object r13) {
            this.f4038a = r10;
            this.f4039b = r11;
            this.f4041d = r12;
            this.f4040c = r13;
        }

        public String a() {
            int r10 = this.f4038a;
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
            int r12 = this.f4038a;
            if (r12 == r11.f4038a) goto L12;
            return false;
        L12:
            if (r12 != 8) goto L21;
            if (Math.abs(this.f4041d - this.f4039b) != 1) goto L21;
            if (this.f4041d != r11.f4039b) goto L21;
            if (this.f4039b != r11.f4041d) goto L21;
            return true;
        L21:
            if (this.f4041d == r11.f4041d) goto L24;
            return false;
        L24:
            if (this.f4039b == r11.f4039b) goto L26;
            return false;
        L26:
            Object r13 = this.f4040c;
            if (r13 == null) goto L32;
            if (r13.equals(r11.f4040c) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r11.f4040c == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.f4038a * 31) + this.f4039b) * 31) + this.f4041d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f4039b + "c:" + this.f4041d + ",p:" + this.f4040c + "]";
        }
    }

    public AdapterHelper(Callback r10) {
        this(r10, false);
    }

    public final void a(a r10) {
        t(r10);
    }

    public final void b(a r10) {
        t(r10);
    }

    public int c(int r10) {
        int r11 = this.f4031b.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L30;
        a r13 = (a) this.f4031b.get(r12);
        int r14 = r13.f4038a;
        if (r14 == 1) goto L27;
        if (r14 != 2) goto L9;
        int r15 = r13.f4039b;
        if (r15 > r10) goto L29;
        int r16 = r13.f4041d;
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
        int r17 = r13.f4039b;
        if (r17 != r10) goto L14;
        r10 = r13.f4041d;
        goto L29
    L14:
        if (r17 >= r10) goto L17;
        r10 = r10 - 1;
    L17:
        if (r13.f4041d > r10) goto L29;
        r10 = r10 + 1;
        goto L29
    L27:
        if (r13.f4039b > r10) goto L29;
        r10 = r10 + r13.f4041d;
        goto L29
    L30:
        return r10;
    }

    public final void d(a r11) {
        int r10 = r11.f4039b;
        int r12 = r11.f4041d + r10;
        byte r13 = -1;
        int r14 = r10;
        int r15 = 0;
    L4:
        if (r14 >= r12) goto L23;
        if (this.f4033d.findViewHolder(r14) == null) goto L8;
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
        t(obtainUpdateOp(2, r10, r15, null));
        r16 = true;
    L13:
        r17 = 0;
        goto L18
    L12:
        r16 = false;
        goto L13
    L23:
        if (r15 == r11.f4041d) goto L25;
        recycleUpdateOp(r11);
        r11 = obtainUpdateOp(2, r10, r15, null);
    L25:
        if (r13 != 0) goto L27;
        i(r11);
        return;
    L27:
        t(r11);
    }

    public final void e(a r10) {
        int r11 = r10.f4039b;
        int r12 = r10.f4041d + r11;
        int r13 = 0;
        byte r14 = -1;
        int r15 = r11;
    L4:
        if (r11 >= r12) goto L18;
        if (this.f4033d.findViewHolder(r11) == null) goto L8;
    L13:
        if (r14 != 0) goto L15;
        i(obtainUpdateOp(4, r15, r13, r10.f4040c));
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
        t(obtainUpdateOp(4, r15, r13, r10.f4040c));
        r15 = r11;
        r13 = 0;
    L12:
        r14 = 0;
        goto L16
    L18:
        if (r13 == r10.f4041d) goto L20;
        Object r16 = r10.f4040c;
        recycleUpdateOp(r10);
        r10 = obtainUpdateOp(4, r15, r13, r16);
    L20:
        if (r14 != 0) goto L22;
        i(r10);
        return;
    L22:
        t(r10);
    }

    public final boolean f(int r10) {
        int r11 = this.f4032c.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        a r13 = (a) this.f4032c.get(r12);
        int r14 = r13.f4038a;
        if (r14 == 8) goto L7;
        if (r14 != 1) goto L16;
        int r15 = r13.f4039b;
        int r16 = r13.f4041d + r15;
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
        if (l(r13.f4041d, r12 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    public void g() {
        int r10 = this.f4032c.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f4033d.onDispatchSecondPass((a) this.f4032c.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        v(this.f4032c);
        this.f4037h = 0;
    }

    public void h() {
        g();
        int r10 = this.f4031b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        a r12 = (a) this.f4031b.get(r11);
        int r13 = r12.f4038a;
        if (r13 != 1) goto L7;
        this.f4033d.onDispatchSecondPass(r12);
        this.f4033d.offsetPositionsForAdd(r12.f4039b, r12.f4041d);
    L17:
        Runnable r14 = this.f4034e;
        if (r14 == null) goto L20;
        r14.run();
    L20:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        this.f4033d.onDispatchSecondPass(r12);
        this.f4033d.offsetPositionsForRemovingInvisible(r12.f4039b, r12.f4041d);
        goto L17
    L9:
        if (r13 != 4) goto L11;
        this.f4033d.onDispatchSecondPass(r12);
        this.f4033d.markViewHoldersUpdated(r12.f4039b, r12.f4041d, r12.f4040c);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        this.f4033d.onDispatchSecondPass(r12);
        this.f4033d.offsetPositionsForMove(r12.f4039b, r12.f4041d);
        goto L17
    L21:
        v(this.f4031b);
        this.f4037h = 0;
    }

    public final void i(a r12) {
        int r10 = r12.f4038a;
        if (r10 == 1) goto L35;
        if (r10 == 8) goto L35;
        int r11 = x(r12.f4039b, r10);
        int r13 = r12.f4039b;
        int r14 = r12.f4038a;
        if (r14 == 2) goto L12;
        if (r14 != 4) goto L11;
        int r15 = 1;
    L13:
        int r16 = 1;
        int r17 = 1;
    L15:
        if (r16 >= r12.f4041d) goto L30;
        int r18 = x(r12.f4039b + (r15 * r16), r12.f4038a);
        int r19 = r12.f4038a;
        if (r19 == 2) goto L23;
        if (r19 == 4) goto L21;
    L25:
        a r20 = obtainUpdateOp(r19, r11, r17, r12.f4040c);
        j(r20, r13);
        recycleUpdateOp(r20);
        if (r12.f4038a != 4) goto L28;
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
        Object r21 = r12.f4040c;
        recycleUpdateOp(r12);
        if (r17 <= 0) goto L39;
        a r110 = obtainUpdateOp(r12.f4038a, r11, r17, r21);
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
        this.f4033d.onDispatchFirstPass(r10);
        int r12 = r10.f4038a;
        if (r12 != 2) goto L5;
        this.f4033d.offsetPositionsForRemovingInvisible(r11, r10.f4041d);
        return;
    L5:
        if (r12 != 4) goto L8;
        this.f4033d.markViewHoldersUpdated(r11, r10.f4041d, r10.f4040c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public int k(int r10) {
        return l(r10, 0);
    }

    public int l(int r10, int r11) {
        int r12 = this.f4032c.size();
    L3:
        if (r11 >= r12) goto L27;
        a r13 = (a) this.f4032c.get(r11);
        int r14 = r13.f4038a;
        if (r14 != 8) goto L14;
        int r15 = r13.f4039b;
        if (r15 != r10) goto L9;
        r10 = r13.f4041d;
    L26:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r15 >= r10) goto L12;
        r10 = r10 - 1;
    L12:
        if (r13.f4041d > r10) goto L26;
        r10 = r10 + 1;
        goto L26
    L14:
        int r16 = r13.f4039b;
        if (r16 > r10) goto L26;
        if (r14 != 2) goto L24;
        int r17 = r13.f4041d;
        if (r10 < (r16 + r17)) goto L20;
        r10 = r10 - r17;
        goto L26
    L20:
        return -1;
    L24:
        if (r14 != 1) goto L26;
        r10 = r10 + r13.f4041d;
        goto L26
    L27:
        return r10;
    }

    public boolean m(int r10) {
        if ((this.f4037h & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        if (this.f4031b.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        if (this.f4032c.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f4031b.isEmpty() == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public a obtainUpdateOp(int r10, int r11, int r12, Object r13) {
        a r14 = (a) this.f4030a.acquire();
        if (r14 == null) goto L7;
        r14.f4038a = r10;
        r14.f4039b = r11;
        r14.f4041d = r12;
        r14.f4040c = r13;
        return r14;
    L7:
        return new a(r10, r11, r12, r13);
    }

    public boolean p(int r10, int r11, Object r12) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.f4031b.add(obtainUpdateOp(4, r10, r11, r12));
        this.f4037h |= 4;
        if (this.f4031b.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean q(int r10, int r11) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.f4031b.add(obtainUpdateOp(1, r10, r11, null));
        this.f4037h |= 1;
        if (this.f4031b.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean r(int r10, int r11, int r12) {
        if (r10 != r11) goto L6;
        return false;
    L6:
        if (r12 != 1) goto L12;
        this.f4031b.add(obtainUpdateOp(8, r10, r11, null));
        this.f4037h |= 8;
        if (this.f4031b.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(a r10) {
        if (this.f4035f == true) goto L6;
        r10.f4040c = null;
        this.f4030a.release(r10);
        return;
    }

    public boolean s(int r10, int r11) {
        if (r11 >= 1) goto L5;
        return false;
    L5:
        this.f4031b.add(obtainUpdateOp(2, r10, r11, null));
        this.f4037h |= 2;
        if (this.f4031b.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public final void t(a r10) {
        this.f4032c.add(r10);
        int r11 = r10.f4038a;
        if (r11 != 1) goto L5;
        this.f4033d.offsetPositionsForAdd(r10.f4039b, r10.f4041d);
        return;
    L5:
        if (r11 != 2) goto L7;
        this.f4033d.offsetPositionsForRemovingLaidOutOrNewView(r10.f4039b, r10.f4041d);
        return;
    L7:
        if (r11 != 4) goto L9;
        this.f4033d.markViewHoldersUpdated(r10.f4039b, r10.f4041d, r10.f4040c);
        return;
    L9:
        if (r11 != 8) goto L12;
        this.f4033d.offsetPositionsForMove(r10.f4039b, r10.f4041d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r10);
    }

    public void u() {
        this.f4036g.b(this.f4031b);
        int r10 = this.f4031b.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L21;
        a r12 = (a) this.f4031b.get(r11);
        int r13 = r12.f4038a;
        if (r13 != 1) goto L7;
        a(r12);
    L17:
        Runnable r14 = this.f4034e;
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
        this.f4031b.clear();
    }

    public void v(List r10) {
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

    public void w() {
        v(this.f4031b);
        v(this.f4032c);
        this.f4037h = 0;
    }

    public final int x(int r10, int r11) {
        int r12 = this.f4032c.size() - 1;
    L4:
        if (r12 < 0) goto L40;
        a r13 = (a) this.f4032c.get(r12);
        int r14 = r13.f4038a;
        if (r14 != 8) goto L29;
        int r15 = r13.f4039b;
        int r16 = r13.f4041d;
        if (r15 >= r16) goto L10;
        int r17 = r15;
        int r18 = r16;
    L11:
        if (r10 < r17) goto L24;
        if (r10 > r18) goto L24;
        if (r17 != r15) goto L19;
        if (r11 != 1) goto L16;
        r13.f4041d = r16 + 1;
    L18:
        r10 = r10 + 1;
    L39:
        r12 = r12 - 1;
        goto L4
    L16:
        if (r11 != 2) goto L18;
        r13.f4041d = r16 - 1;
        goto L18
    L19:
        if (r11 != 1) goto L21;
        r13.f4039b = r15 + 1;
    L23:
        r10 = r10 - 1;
        goto L39
    L21:
        if (r11 != 2) goto L23;
        r13.f4039b = r15 - 1;
    L24:
        if (r10 >= r15) goto L39;
        if (r11 != 1) goto L27;
        r13.f4039b = r15 + 1;
        r13.f4041d = r16 + 1;
        goto L39
    L27:
        if (r11 != 2) goto L39;
        r13.f4039b = r15 - 1;
        r13.f4041d = r16 - 1;
        goto L39
    L10:
        r18 = r15;
        r17 = r16;
        goto L11
    L29:
        int r19 = r13.f4039b;
        if (r19 > r10) goto L35;
        if (r14 != 1) goto L33;
        r10 = r10 - r13.f4041d;
        goto L39
    L33:
        if (r14 != 2) goto L39;
        r10 = r10 + r13.f4041d;
        goto L39
    L35:
        if (r11 != 1) goto L37;
        r13.f4039b = r19 + 1;
        goto L39
    L37:
        if (r11 != 2) goto L39;
        r13.f4039b = r19 - 1;
        goto L39
    L40:
        int r110 = this.f4032c.size() - 1;
    L41:
        if (r110 < 0) goto L52;
        a r20 = (a) this.f4032c.get(r110);
        if (r20.f4038a != 8) goto L49;
        int r21 = r20.f4041d;
        if (r21 == r20.f4039b) goto L47;
        if (r21 < 0) goto L47;
    L51:
        r110 = r110 - 1;
    L47:
        this.f4032c.remove(r110);
        recycleUpdateOp(r20);
        goto L51
    L49:
        if (r20.f4041d > 0) goto L51;
        this.f4032c.remove(r110);
        recycleUpdateOp(r20);
        goto L51
    L52:
        return r10;
    }

    public AdapterHelper(Callback r10, boolean r11) {
        this.f4030a = new androidx.core.util.d(30);
        this.f4031b = new ArrayList();
        this.f4032c = new ArrayList();
        this.f4037h = 0;
        this.f4033d = r10;
        this.f4035f = r11;
        this.f4036g = new OpReorderer(this);
    }
}
