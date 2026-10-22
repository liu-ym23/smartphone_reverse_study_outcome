package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper$ViewDropHandler, RecyclerView$SmoothScroller$ScrollVectorProvider {
    public int A;
    public boolean B;
    public SavedState C;
    public final a D;
    public final b E;
    public int F;
    public int[] G;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15396r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f15397s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f15398t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15399u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f15401w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15402x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15403y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f15404z;

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mAnchorPosition);
            r10.writeInt(this.mAnchorOffset);
            r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel r10) {
            this.mAnchorPosition = r10.readInt();
            this.mAnchorOffset = r10.readInt();
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.mAnchorLayoutFromEnd = r11;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState r10) {
            this.mAnchorPosition = r10.mAnchorPosition;
            this.mAnchorOffset = r10.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f15405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15409e;

        public a() {
            e();
        }

        public void a() {
            if (this.f15408d == false) goto L5;
            int r10 = this.f15405a.i();
        L6:
            this.f15407c = r10;
            return;
        L5:
            r10 = this.f15405a.l();
            goto L6
        }

        public void b(View r10, int r11) {
            if (this.f15408d == false) goto L5;
            this.f15407c = this.f15405a.d(r10) + this.f15405a.n();
        L6:
            this.f15406b = r11;
            return;
        L5:
            this.f15407c = this.f15405a.g(r10);
            goto L6
        }

        public void c(View r10, int r11) {
            int r12 = this.f15405a.n();
            if (r12 < 0) goto L6;
            b(r10, r11);
            return;
        L6:
            this.f15406b = r11;
            if (this.f15408d == false) goto L13;
            int r13 = (this.f15405a.i() - r12) - this.f15405a.d(r10);
            this.f15407c = this.f15405a.i() - r13;
            if (r13 <= 0) goto L19;
            int r14 = this.f15407c - this.f15405a.e(r10);
            int r15 = this.f15405a.l();
            int r16 = r14 - (r15 + Math.min(this.f15405a.g(r10) - r15, 0));
            if (r16 >= 0) goto L20;
            this.f15407c += Math.min(r13, -r16);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r17 = this.f15405a.g(r10);
            int r18 = r17 - this.f15405a.l();
            this.f15407c = r17;
            if (r18 <= 0) goto L22;
            int r19 = (this.f15405a.i() - Math.min(0, (this.f15405a.i() - r12) - this.f15405a.d(r10))) - (r17 + this.f15405a.e(r10));
            if (r19 >= 0) goto L23;
            this.f15407c -= Math.min(r18, -r19);
            return;
        L23:
            return;
        }

        public boolean d(View r10, RecyclerView.q r11) {
            RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            if (r12.c() == false) goto L5;
        L9:
            return false;
        L5:
            if (r12.a() < 0) goto L9;
            if (r12.a() >= r11.b()) goto L9;
            return true;
        }

        public void e() {
            this.f15406b = -1;
            this.f15407c = Integer.MIN_VALUE;
            this.f15408d = false;
            this.f15409e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f15406b + ", mCoordinate=" + this.f15407c + ", mLayoutFromEnd=" + this.f15408d + ", mValid=" + this.f15409e + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15413d;

        public b() {
        }

        public void a() {
            this.f15410a = 0;
            this.f15411b = false;
            this.f15412c = false;
            this.f15413d = false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f15423j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f15424k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f15425l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f15426m;

        public c() {
            this.f15414a = true;
            this.f15421h = 0;
            this.f15422i = 0;
            this.f15423j = false;
            this.f15425l = null;
        }

        public void a() {
            b(null);
        }

        public void b(View r10) {
            View r11 = f(r10);
            if (r11 != null) goto L5;
            this.f15417d = -1;
            return;
        L5:
            this.f15417d = ((RecyclerView.LayoutParams) r11.getLayoutParams()).a();
        }

        public boolean c(RecyclerView.q r10) {
            int r11 = this.f15417d;
            if (r11 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11 >= r10.b()) goto L7;
            return true;
        }

        public View d(RecyclerView.o r10) {
            if (this.f15425l != null) goto L5;
            View r11 = r10.n(this.f15417d);
            this.f15417d += this.f15418e;
            return r11;
        L5:
            return e();
        }

        public final View e() {
            int r10 = this.f15425l.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L12;
            View r12 = ((RecyclerView.t) this.f15425l.get(r11)).f15566a;
            RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12.getLayoutParams();
            if (r13.c() == true) goto L11;
            if (this.f15417d != r13.a()) goto L11;
            b(r12);
            return r12;
        L11:
            r11 = r11 + 1;
            goto L3
        L12:
            return null;
        }

        public View f(View r10) {
            int r11 = this.f15425l.size();
            View r12 = null;
            int r13 = Channel.UNLIMITED;
            int r14 = 0;
        L3:
            if (r14 >= r11) goto L18;
            View r15 = ((RecyclerView.t) this.f15425l.get(r14)).f15566a;
            RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r15.getLayoutParams();
            if (r15 == r10) goto L17;
            if (r16.c() == true) goto L17;
            int r17 = (r16.a() - this.f15417d) * this.f15418e;
            if (r17 < 0) goto L17;
            if (r17 >= r13) goto L17;
            r12 = r15;
            if (r17 == 0) goto L18;
            r13 = r17;
        L17:
            r14 = r14 + 1;
        L18:
            return r12;
        }
    }

    public LinearLayoutManager(Context r10) {
        this(r10, 1, false);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public View A(int r10) {
        int r11 = H();
        if (r11 != 0) goto L6;
        return null;
    L6:
        int r12 = r10 - e0(G(0));
        if (r12 < 0) goto L13;
        if (r12 >= r11) goto L13;
        View r13 = G(r12);
        if (e0(r13) != r10) goto L13;
        return r13;
    L13:
        return super.A(r10);
    }

    public void A1(RecyclerView.q r10, int[] r11) {
        int r12 = Y1(r10);
        if (this.f15397s.f15419f != (-1)) goto L5;
        int r13 = 0;
    L6:
        r11[0] = r12;
        r11[1] = r13;
        return;
    L5:
        r13 = r12;
        r12 = 0;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams B() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void B1(RecyclerView.q r10, c r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r13 = r11.f15417d;
        if (r13 >= 0) goto L5;
        return;
    L5:
        if (r13 >= r10.b()) goto L9;
        r12.addPosition(r13, Math.max(0, r11.f15420g));
        return;
    }

    public final int C1(RecyclerView.q r10) {
        if (H() != 0) goto L6;
        return 0;
    L6:
        H1();
        return i.a(r10, this.f15398t, L1(!this.f15403y, true), K1(!this.f15403y, true), this, this.f15403y);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void D0(RecyclerView r10, RecyclerView.o r11) {
        super.D0(r10, r11);
        if (this.B == false) goto L6;
        d1(r11);
        r11.c();
        return;
    }

    public final int D1(RecyclerView.q r10) {
        if (H() != 0) goto L6;
        return 0;
    L6:
        H1();
        return i.b(r10, this.f15398t, L1(!this.f15403y, true), K1(!this.f15403y, true), this, this.f15403y, this.f15401w);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public View E0(View r10, int r11, RecyclerView.o r12, RecyclerView.q r13) {
        j2();
        if (H() != 0) goto L5;
        return null;
    L5:
        int r14 = F1(r11);
        if (r14 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        H1();
        s2(r14, (int) (this.f15398t.m() * 0.33333334f), false, r13);
        c r15 = this.f15397s;
        r15.f15420g = Integer.MIN_VALUE;
        r15.f15414a = false;
        I1(r12, r15, r13, true);
        if (r14 != (-1)) goto L11;
        View r16 = S1();
    L12:
        if (r14 != (-1)) goto L14;
        View r17 = X1();
    L16:
        if (r17.hasFocusable() == false) goto L20;
        if (r16 != null) goto L19;
        return null;
    L19:
        return r17;
    L20:
        return r16;
    L14:
        r17 = W1();
        goto L16
    L11:
        r16 = R1();
        goto L12
    }

    public final int E1(RecyclerView.q r10) {
        if (H() != 0) goto L6;
        return 0;
    L6:
        H1();
        return i.c(r10, this.f15398t, L1(!this.f15403y, true), K1(!this.f15403y, true), this, this.f15403y);
    }

    public int F1(int r10) {
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L36;
        if (r10 == 17) goto L31;
        if (r10 == 33) goto L26;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.f15396r != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.f15396r != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.f15396r != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.f15396r != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.f15396r != 1) goto L39;
        return 1;
    L39:
        if (a2() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.f15396r != 1) goto L46;
        return -1;
    L46:
        if (a2() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    public c G1() {
        return new c();
    }

    public void H1() {
        if (this.f15397s != null) goto L6;
        this.f15397s = G1();
        return;
    }

    public int I1(RecyclerView.o r10, c r11, RecyclerView.q r12, boolean r13) {
        int r14 = r11.f15416c;
        int r15 = r11.f15420g;
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r14 >= 0) goto L6;
        r11.f15420g = r15 + r14;
    L6:
        e2(r10, r11);
    L7:
        int r16 = r11.f15416c + r11.f15421h;
        b r17 = this.E;
    L9:
        if (r11.f15426m == true) goto L12;
        if (r16 > 0) goto L12;
    L33:
        return r14 - r11.f15416c;
    L12:
        if (r11.c(r12) == false) goto L33;
        r17.a();
        b2(r10, r12, r11, r17);
        if (r17.f15411b == true) goto L33;
        r11.f15415b += r17.f15410a * r11.f15419f;
        if (r17.f15412c == true) goto L19;
    L22:
        int r18 = r11.f15416c;
        int r19 = r17.f15410a;
        r11.f15416c = r18 - r19;
        r16 = r16 - r19;
    L23:
        int r20 = r11.f15420g;
        if (r20 == Integer.MIN_VALUE) goto L29;
        int r21 = r20 + r17.f15410a;
        r11.f15420g = r21;
        int r22 = r11.f15416c;
        if (r22 >= 0) goto L28;
        r11.f15420g = r21 + r22;
    L28:
        e2(r10, r11);
    L29:
        if (r13 == false) goto L9;
        if (r17.f15413d == false) goto L9;
    L19:
        if (r11.f15425l != null) goto L22;
        if (r12.d() == true) goto L23;
        goto L22
    }

    public final View J1() {
        return P1(0, H());
    }

    public View K1(boolean r10, boolean r11) {
        if (this.f15401w == false) goto L7;
        return Q1(0, H(), r10, r11);
    L7:
        return Q1(H() - 1, -1, r10, r11);
    }

    public View L1(boolean r10, boolean r11) {
        if (this.f15401w == false) goto L7;
        return Q1(H() - 1, -1, r10, r11);
    L7:
        return Q1(0, H(), r10, r11);
    }

    public int M1() {
        View r10 = Q1(0, H(), false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return e0(r10);
    }

    public final View N1() {
        return P1(H() - 1, -1);
    }

    public int O1() {
        View r10 = Q1(H() - 1, -1, false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return e0(r10);
    }

    public View P1(int r10, int r11) {
        H1();
        if (r11 > r10) goto L7;
        if (r11 < r10) goto L7;
        return G(r10);
    L7:
        if (this.f15398t.g(G(r10)) >= this.f15398t.l()) goto L9;
        int r12 = 16644;
        int r13 = 16388;
    L11:
        if (this.f15396r != 0) goto L14;
        return this.f15499e.a(r10, r11, r12, r13);
    L14:
        return this.f15500f.a(r10, r11, r12, r13);
    L9:
        r12 = 4161;
        r13 = 4097;
        goto L11
    }

    public View Q1(int r10, int r11, boolean r12, boolean r13) {
        H1();
        int r14 = 320;
        if (r12 == false) goto L5;
        int r15 = 24579;
    L6:
        if (r13 == true) goto L10;
        r14 = 0;
    L10:
        if (this.f15396r != 0) goto L13;
        return this.f15499e.a(r10, r11, r15, r14);
    L13:
        return this.f15500f.a(r10, r11, r15, r14);
    L5:
        r15 = 320;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void R0(RecyclerView.o r10, RecyclerView.q r11) {
        int r12 = -1;
        if (this.C != null) goto L7;
        if (this.f15404z != (-1)) goto L7;
    L10:
        SavedState r13 = this.C;
        if (r13 != null) goto L13;
    L15:
        H1();
        this.f15397s.f15414a = false;
        j2();
        View r14 = S();
        a r15 = this.D;
        if (r15.f15409e == true) goto L18;
    L28:
        r15.e();
        a r16 = this.D;
        r16.f15408d = this.f15401w ^ this.f15402x;
        r2(r10, r11, r16);
        this.D.f15409e = true;
    L29:
        c r17 = this.f15397s;
        if (r17.f15424k < 0) goto L32;
        int r18 = 1;
    L33:
        r17.f15419f = r18;
        int[] r19 = this.G;
        r19[0] = 0;
        r19[1] = 0;
        A1(r11, r19);
        int r20 = Math.max(0, this.G[0]) + this.f15398t.l();
        int r21 = Math.max(0, this.G[1]) + this.f15398t.j();
        if (r11.d() == false) goto L49;
        int r22 = this.f15404z;
        if (r22 == (-1)) goto L49;
        if (this.A == Integer.MIN_VALUE) goto L49;
        View r23 = A(r22);
        if (r23 == null) goto L49;
        if (this.f15401w == false) goto L45;
        int r24 = this.f15398t.i() - this.f15398t.d(r23);
        int r25 = this.A;
    L44:
        int r26 = r24 - r25;
        if (r26 <= 0) goto L48;
        r20 = r20 + r26;
        goto L49
    L48:
        r21 = r21 - r26;
        goto L49
    L45:
        r25 = this.f15398t.g(r23) - this.f15398t.l();
        r24 = this.A;
    L49:
        a r27 = this.D;
        if (r27.f15408d == false) goto L55;
        if (this.f15401w == false) goto L56;
    L53:
        r12 = 1;
    L56:
        d2(r10, r11, r27, r12);
        u(r10);
        this.f15397s.f15426m = i2();
        this.f15397s.f15423j = r11.d();
        this.f15397s.f15422i = 0;
        a r28 = this.D;
        if (r28.f15408d == false) goto L64;
        w2(r28);
        c r29 = this.f15397s;
        r29.f15421h = r20;
        I1(r10, r29, r11, false);
        c r30 = this.f15397s;
        int r31 = r30.f15415b;
        int r32 = r30.f15417d;
        int r33 = r30.f15416c;
        if (r33 <= 0) goto L61;
        r21 = r21 + r33;
    L61:
        u2(this.D);
        c r34 = this.f15397s;
        r34.f15421h = r21;
        r34.f15417d += r34.f15418e;
        I1(r10, r34, r11, false);
        c r35 = this.f15397s;
        int r36 = r35.f15415b;
        int r37 = r35.f15416c;
        if (r37 <= 0) goto L71;
        v2(r32, r31);
        c r38 = this.f15397s;
        r38.f15421h = r37;
        I1(r10, r38, r11, false);
        r31 = this.f15397s.f15415b;
    L71:
        if (H() > 0) goto L73;
    L77:
        c2(r10, r11, r31, r36);
        if (r11.d() == true) goto L80;
        this.f15398t.r();
    L81:
        this.f15399u = this.f15402x;
        return;
    L80:
        this.D.e();
        goto L81
    L73:
        if ((this.f15401w ^ this.f15402x) == false) goto L76;
        int r39 = U1(r36, r10, r11, true);
        int r40 = r31 + r39;
        int r41 = r36 + r39;
        int r42 = V1(r40, r10, r11, false);
    L75:
        r31 = r40 + r42;
        r36 = r41 + r42;
        goto L77
    L76:
        int r43 = V1(r31, r10, r11, true);
        r40 = r31 + r43;
        r41 = r36 + r43;
        r42 = U1(r41, r10, r11, false);
        goto L75
    L64:
        u2(r28);
        c r44 = this.f15397s;
        r44.f15421h = r21;
        I1(r10, r44, r11, false);
        c r45 = this.f15397s;
        r36 = r45.f15415b;
        int r46 = r45.f15417d;
        int r47 = r45.f15416c;
        if (r47 <= 0) goto L67;
        r20 = r20 + r47;
    L67:
        w2(this.D);
        c r48 = this.f15397s;
        r48.f15421h = r20;
        r48.f15417d += r48.f15418e;
        I1(r10, r48, r11, false);
        c r49 = this.f15397s;
        r31 = r49.f15415b;
        int r50 = r49.f15416c;
        if (r50 <= 0) goto L71;
        t2(r46, r36);
        c r51 = this.f15397s;
        r51.f15421h = r50;
        I1(r10, r51, r11, false);
        r36 = this.f15397s.f15415b;
        goto L71
    L55:
        if (this.f15401w == false) goto L53;
    L32:
        r18 = -1;
        goto L33
    L18:
        if (this.f15404z != (-1)) goto L28;
        if (this.C != null) goto L28;
        if (r14 == null) goto L29;
        if (this.f15398t.g(r14) < this.f15398t.i()) goto L26;
    L27:
        this.D.c(r14, e0(r14));
        goto L29
    L26:
        if (this.f15398t.d(r14) > this.f15398t.l()) goto L29;
    L13:
        if (r13.hasValidAnchor() == false) goto L15;
        this.f15404z = this.C.mAnchorPosition;
    L7:
        if (r11.b() != 0) goto L10;
        d1(r10);
    }

    public final View R1() {
        if (this.f15401w == false) goto L6;
        return J1();
    L6:
        return N1();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void S0(RecyclerView.q r10) {
        super.S0(r10);
        this.C = null;
        this.f15404z = -1;
        this.A = Integer.MIN_VALUE;
        this.D.e();
    }

    public final View S1() {
        if (this.f15401w == false) goto L6;
        return N1();
    L6:
        return J1();
    }

    public View T1(RecyclerView.o r17, RecyclerView.q r18, boolean r19, boolean r20) {
        H1();
        int r10 = H();
        if (r20 == false) goto L5;
        int r11 = H() - 1;
        int r12 = -1;
        int r13 = -1;
    L6:
        int r14 = r18.b();
        int r15 = this.f15398t.l();
        int r16 = this.f15398t.i();
        View r21 = null;
        View r110 = null;
        View r111 = null;
    L7:
        if (r11 == r12) goto L37;
        View r112 = G(r11);
        int r113 = e0(r112);
        int r114 = this.f15398t.g(r112);
        int r115 = this.f15398t.d(r112);
        if (r113 < 0) goto L36;
        if (r113 >= r14) goto L36;
        if (((RecyclerView.LayoutParams) r112.getLayoutParams()).c() == false) goto L15;
        if (r111 != null) goto L36;
        r111 = r112;
        goto L36
    L15:
        if (r115 > r15) goto L18;
        if (r114 >= r15) goto L18;
        boolean r116 = true;
    L19:
        if (r114 < r16) goto L22;
        if (r115 <= r16) goto L22;
        boolean r117 = true;
    L23:
        if (r116 == true) goto L27;
        if (r117 == true) goto L27;
        return r112;
    L27:
        if (r19 == false) goto L32;
        if (r117 == true) goto L33;
        if (r21 != null) goto L36;
    L35:
        r21 = r112;
    L33:
        r110 = r112;
        goto L36
    L32:
        if (r116 == true) goto L33;
        if (r21 != null) goto L36;
    L22:
        r117 = false;
    L18:
        r116 = false;
    L36:
        r11 = r11 + r13;
        goto L7
    L37:
        if (r21 != null) goto L54;
        if (r110 == null) goto L42;
        return r110;
    L42:
        return r111;
    L54:
        return r21;
    L5:
        r12 = r10;
        r11 = 0;
        r13 = 1;
        goto L6
    }

    public final int U1(int r10, RecyclerView.o r11, RecyclerView.q r12, boolean r13) {
        int r14 = this.f15398t.i() - r10;
        if (r14 <= 0) goto L11;
        int r15 = -k2(-r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L10;
        int r17 = this.f15398t.i() - r16;
        if (r17 <= 0) goto L10;
        this.f15398t.q(r17);
        return r17 + r15;
    L10:
        return r15;
    L11:
        return 0;
    }

    public final int V1(int r10, RecyclerView.o r11, RecyclerView.q r12, boolean r13) {
        int r14 = r10 - this.f15398t.l();
        if (r14 <= 0) goto L10;
        int r15 = -k2(r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L12;
        int r17 = r16 - this.f15398t.l();
        if (r17 <= 0) goto L13;
        this.f15398t.q(-r17);
        return r15 - r17;
    L13:
        return r15;
    L12:
        return r15;
    L10:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void W0(Parcelable r10) {
        if ((r10 instanceof SavedState) == false) goto L9;
        SavedState r11 = (SavedState) r10;
        this.C = r11;
        if (this.f15404z == (-1)) goto L7;
        r11.invalidateAnchor();
    L7:
        l1();
        return;
    }

    public final View W1() {
        if (this.f15401w == false) goto L5;
        int r10 = 0;
    L7:
        return G(r10);
    L5:
        r10 = H() - 1;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public Parcelable X0() {
        if (this.C != null) goto L5;
        SavedState r10 = new SavedState();
        if (H() <= 0) goto L12;
        H1();
        boolean r11 = this.f15399u ^ this.f15401w;
        r10.mAnchorLayoutFromEnd = r11;
        if (r11 == false) goto L11;
        View r12 = W1();
        r10.mAnchorOffset = this.f15398t.i() - this.f15398t.d(r12);
        r10.mAnchorPosition = e0(r12);
    L13:
        return r10;
    L11:
        View r13 = X1();
        r10.mAnchorPosition = e0(r13);
        r10.mAnchorOffset = this.f15398t.g(r13) - this.f15398t.l();
        goto L13
    L12:
        r10.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.C);
    }

    public final View X1() {
        if (this.f15401w == false) goto L5;
        int r10 = H() - 1;
    L7:
        return G(r10);
    L5:
        r10 = 0;
        goto L7
    }

    public int Y1(RecyclerView.q r10) {
        if (r10.c() == true) goto L5;
        return 0;
    L5:
        return this.f15398t.m();
    }

    public boolean Z1() {
        return this.f15402x;
    }

    public boolean a2() {
        if (W() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void b2(RecyclerView.o r10, RecyclerView.q r11, c r12, b r13) {
        View r14 = r12.d(r10);
        if (r14 != null) goto L6;
        r13.f15411b = true;
        return;
    L6:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r12.f15425l != null) goto L15;
        boolean r16 = this.f15401w;
        if (r12.f15419f != (-1)) goto L11;
        boolean r17 = true;
    L12:
        if (r16 != r17) goto L14;
        c(r14);
    L22:
        v0(r14, 0, 0);
        r13.f15410a = this.f15398t.e(r14);
        if (this.f15396r == 1) goto L25;
        int r18 = d0();
        int r19 = this.f15398t.f(r14) + r18;
        if (r12.f15419f != (-1)) goto L35;
        int r110 = r12.f15415b;
        int r20 = r110;
        int r21 = r18;
        int r22 = r19;
        int r23 = r110 - r13.f15410a;
    L36:
        u0(r14, r23, r21, r20, r22);
        if (r15.c() == false) goto L39;
    L40:
        r13.f15412c = true;
    L41:
        r13.f15413d = r14.hasFocusable();
        return;
    L39:
        if (r15.b() == false) goto L41;
    L35:
        int r111 = r12.f15415b;
        r21 = r18;
        r20 = r13.f15410a + r111;
        r22 = r19;
        r23 = r111;
        goto L36
    L25:
        if (a2() == false) goto L27;
        int r24 = k0() - c0();
        r23 = r24 - this.f15398t.f(r14);
    L29:
        if (r12.f15419f != (-1)) goto L31;
        int r112 = r12.f15415b;
        r22 = r112;
        r20 = r24;
        r21 = r112 - r13.f15410a;
        goto L36
    L31:
        int r113 = r12.f15415b;
        r21 = r113;
        r20 = r24;
        r22 = r13.f15410a + r113;
        goto L36
    L27:
        r23 = b0();
        r24 = this.f15398t.f(r14) + r23;
        goto L29
    L14:
        d(r14, 0);
        goto L22
    L11:
        r17 = false;
        goto L12
    L15:
        boolean r25 = this.f15401w;
        if (r12.f15419f != (-1)) goto L18;
        boolean r26 = true;
    L19:
        if (r25 != r26) goto L21;
        a(r14);
        goto L22
    L21:
        b(r14, 0);
        goto L22
    L18:
        r26 = false;
        goto L19
    }

    public final void c2(RecyclerView.o r11, RecyclerView.q r12, int r13, int r14) {
        if (r12.f() == true) goto L5;
        return;
    L5:
        if (H() != 0) goto L7;
        return;
    L7:
        if (r12.d() == false) goto L9;
        return;
    L9:
        if (z1() == false) goto L39;
        List r10 = r11.j();
        int r15 = r10.size();
        int r16 = e0(G(0));
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L12:
        if (r17 >= r15) goto L25;
        RecyclerView.t r20 = (RecyclerView.t) r10.get(r17);
        if (r20.x() == true) goto L24;
        if (r20.o() >= r16) goto L19;
        boolean r21 = true;
    L21:
        if (r21 == this.f15401w) goto L23;
        r18 = r18 + this.f15398t.e(r20.f15566a);
        goto L24
    L23:
        r19 = r19 + this.f15398t.e(r20.f15566a);
        goto L24
    L19:
        r21 = false;
    L24:
        r17 = r17 + 1;
        goto L12
    L25:
        this.f15397s.f15425l = r10;
        if (r18 <= 0) goto L28;
        v2(e0(X1()), r13);
        c r110 = this.f15397s;
        r110.f15421h = r18;
        r110.f15416c = 0;
        r110.a();
        I1(r11, this.f15397s, r12, false);
    L28:
        if (r19 <= 0) goto L30;
        t2(e0(W1()), r14);
        c r111 = this.f15397s;
        r111.f15421h = r19;
        r111.f15416c = 0;
        r111.a();
        I1(r11, this.f15397s, r12, false);
    L30:
        this.f15397s.f15425l = null;
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r10) {
        if (H() != 0) goto L6;
        return null;
    L6:
        boolean r11 = false;
        int r12 = 1;
        if (r10 >= e0(G(0))) goto L10;
        r11 = true;
    L10:
        if (r11 == this.f15401w) goto L13;
        r12 = -1;
    L13:
        if (this.f15396r != 0) goto L17;
        return new PointF(r12, 0.0f);
    L17:
        return new PointF(0.0f, r12);
    }

    public void d2(RecyclerView.o r10, RecyclerView.q r11, a r12, int r13) {
    }

    public final void e2(RecyclerView.o r10, c r11) {
        if (r11.f15414a == true) goto L5;
        return;
    L5:
        if (r11.f15426m == true) goto L14;
        int r12 = r11.f15420g;
        int r13 = r11.f15422i;
        if (r11.f15419f != (-1)) goto L10;
        g2(r10, r12, r13);
        return;
    L10:
        h2(r10, r12, r13);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void f(String r10) {
        if (this.C != null) goto L6;
        super.f(r10);
        return;
    }

    public final void f2(RecyclerView.o r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return;
    L4:
        if (r12 <= r11) goto L8;
        int r13 = r12 - 1;
    L6:
        if (r13 < r11) goto L10;
        g1(r13, r10);
        r13 = r13 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r11 <= r12) goto L13;
        g1(r11, r10);
        r11 = r11 - 1;
        goto L8
    }

    public final void g2(RecyclerView.o r10, int r11, int r12) {
        int r13 = H();
        if (r11 >= 0) goto L5;
        return;
    L5:
        int r14 = (this.f15398t.h() - r11) + r12;
        if (this.f15401w == false) goto L17;
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L33;
        View r16 = G(r15);
        if (this.f15398t.g(r16) < r14) goto L15;
        if (this.f15398t.p(r16) < r14) goto L15;
        r15 = r15 + 1;
    L15:
        f2(r10, 0, r15);
        return;
    L33:
        return;
    L17:
        int r17 = r13 - 1;
        int r18 = r17;
    L18:
        if (r18 < 0) goto L34;
        View r19 = G(r18);
        if (this.f15398t.g(r19) < r14) goto L25;
        if (this.f15398t.p(r19) < r14) goto L25;
        r18 = r18 - 1;
    L25:
        f2(r10, r17, r18);
        return;
    }

    public final void h2(RecyclerView.o r10, int r11, int r12) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        int r13 = r11 - r12;
        int r14 = H();
        if (this.f15401w == false) goto L16;
        int r15 = r14 - 1;
        int r16 = r15;
    L7:
        if (r16 < 0) goto L32;
        View r17 = G(r16);
        if (this.f15398t.d(r17) > r13) goto L14;
        if (this.f15398t.o(r17) > r13) goto L14;
        r16 = r16 - 1;
    L14:
        f2(r10, r15, r16);
        return;
    L32:
        return;
    L16:
        int r18 = 0;
    L17:
        if (r18 >= r14) goto L33;
        View r19 = G(r18);
        if (this.f15398t.d(r19) > r13) goto L24;
        if (this.f15398t.o(r19) > r13) goto L24;
        r18 = r18 + 1;
    L24:
        f2(r10, 0, r18);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean i() {
        if (this.f15396r != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i2() {
        if (this.f15398t.k() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f15398t.h() != 0) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean j() {
        if (this.f15396r == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void j2() {
        if (this.f15396r != 1) goto L5;
    L8:
        this.f15401w = this.f15400v;
        return;
    L5:
        if (a2() == false) goto L8;
        this.f15401w = !this.f15400v;
    }

    public int k2(int r10, RecyclerView.o r11, RecyclerView.q r12) {
        if (H() == 0) goto L17;
        if (r10 == 0) goto L17;
        H1();
        this.f15397s.f15414a = true;
        if (r10 <= 0) goto L9;
        int r13 = 1;
    L10:
        int r14 = Math.abs(r10);
        s2(r13, r14, true, r12);
        c r15 = this.f15397s;
        int r16 = r15.f15420g + I1(r11, r15, r12, false);
        if (r16 >= 0) goto L13;
        return 0;
    L13:
        if (r14 <= r16) goto L15;
        r10 = r13 * r16;
    L15:
        this.f15398t.q(-r10);
        this.f15397s.f15424k = r10;
        return r10;
    L9:
        r13 = -1;
    L17:
        return 0;
    }

    public void l2(int r10, int r11) {
        this.f15404z = r10;
        this.A = r11;
        SavedState r12 = this.C;
        if (r12 == null) goto L5;
        r12.invalidateAnchor();
    L5:
        l1();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void m(int r10, int r11, RecyclerView.q r12, RecyclerView.LayoutManager.LayoutPrefetchRegistry r13) {
        if (this.f15396r == 0) goto L7;
        r10 = r11;
    L7:
        if (H() == 0) goto L16;
        if (r10 == 0) goto L17;
        H1();
        if (r10 <= 0) goto L13;
        int r14 = 1;
    L14:
        s2(r14, Math.abs(r10), true, r12);
        B1(r12, this.f15397s, r13);
        return;
    L13:
        r14 = -1;
        goto L14
    L17:
        return;
    }

    public void m2(int r10) {
        if (r10 != 0) goto L4;
    L8:
        f(null);
        if (r10 == this.f15396r) goto L11;
    L12:
        f r11 = f.b(this, r10);
        this.f15398t = r11;
        this.D.f15405a = r11;
        this.f15396r = r10;
        l1();
        return;
    L11:
        if (this.f15398t == null) goto L12;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void n(int r10, RecyclerView.LayoutManager.LayoutPrefetchRegistry r11) {
        SavedState r12 = this.C;
        int r13 = -1;
        if (r12 != null) goto L5;
    L7:
        j2();
        boolean r14 = this.f15401w;
        int r15 = this.f15404z;
        if (r15 != (-1)) goto L12;
        if (r14 == false) goto L11;
        r15 = r10 - 1;
        goto L12
    L11:
        r15 = 0;
    L12:
        if (r14 == true) goto L15;
        r13 = 1;
    L15:
        int r16 = 0;
    L17:
        if (r16 >= this.F) goto L21;
        if (r15 < 0) goto L25;
        if (r15 >= r10) goto L26;
        r11.addPosition(r15, 0);
        r15 = r15 + r13;
        r16 = r16 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r12.hasValidAnchor() == false) goto L7;
        SavedState r17 = this.C;
        r14 = r17.mAnchorLayoutFromEnd;
        r15 = r17.mAnchorPosition;
        goto L12
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean n0() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int n1(int r10, RecyclerView.o r11, RecyclerView.q r12) {
        if (this.f15396r != 1) goto L7;
        return 0;
    L7:
        return k2(r10, r11, r12);
    }

    public void n2(boolean r10) {
        f(null);
        if (r10 != this.f15400v) goto L5;
        return;
    L5:
        this.f15400v = r10;
        l1();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int o(RecyclerView.q r10) {
        return C1(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void o1(int r10) {
        this.f15404z = r10;
        this.A = Integer.MIN_VALUE;
        SavedState r11 = this.C;
        if (r11 == null) goto L5;
        r11.invalidateAnchor();
    L5:
        l1();
    }

    public void o2(boolean r10) {
        f(null);
        if (this.f15402x != r10) goto L5;
        return;
    L5:
        this.f15402x = r10;
        l1();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        if (H() <= 0) goto L6;
        r10.setFromIndex(M1());
        r10.setToIndex(O1());
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int p(RecyclerView.q r10) {
        return D1(r10);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int p1(int r10, RecyclerView.o r11, RecyclerView.q r12) {
        if (this.f15396r != 0) goto L7;
        return 0;
    L7:
        return k2(r10, r11, r12);
    }

    public final boolean p2(RecyclerView.o r10, RecyclerView.q r11, a r12) {
        boolean r13 = false;
        if (H() != 0) goto L5;
        return false;
    L5:
        View r14 = S();
        if (r14 != null) goto L8;
    L11:
        boolean r15 = this.f15399u;
        boolean r16 = this.f15402x;
        if (r15 == r16) goto L14;
        return false;
    L14:
        View r17 = T1(r10, r11, r12.f15408d, r16);
        if (r17 == null) goto L35;
        r12.b(r17, e0(r17));
        if (r11.d() == false) goto L19;
    L34:
        return true;
    L19:
        if (z1() == false) goto L34;
        int r18 = this.f15398t.g(r17);
        int r19 = this.f15398t.d(r17);
        int r20 = this.f15398t.l();
        int r21 = this.f15398t.i();
        if (r19 > r20) goto L24;
        if (r18 >= r20) goto L24;
        boolean r22 = true;
    L25:
        if (r18 < r21) goto L28;
        if (r19 <= r21) goto L28;
        r13 = true;
    L28:
        if (r22 == true) goto L31;
        if (r13 == false) goto L34;
    L31:
        if (r12.f15408d == false) goto L33;
        r20 = r21;
    L33:
        r12.f15407c = r20;
    L24:
        r22 = false;
        goto L25
    L35:
        return false;
    L8:
        if (r12.d(r14, r11) == false) goto L11;
        r12.c(r14, e0(r14));
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper$ViewDropHandler
    public void prepareForDrop(View r10, View r11, int r12, int r13) {
        f("Cannot drop a view during a scroll or layout calculation");
        H1();
        j2();
        int r14 = e0(r10);
        int r15 = e0(r11);
        if (r14 >= r15) goto L5;
        byte r16 = 1;
    L7:
        if (this.f15401w == false) goto L11;
        if (r16 != 1) goto L10;
        l2(r15, this.f15398t.i() - (this.f15398t.g(r11) + this.f15398t.e(r10)));
        return;
    L10:
        l2(r15, this.f15398t.i() - this.f15398t.d(r11));
        return;
    L11:
        if (r16 != (-1)) goto L13;
        l2(r15, this.f15398t.g(r11));
        return;
    L13:
        l2(r15, this.f15398t.d(r11) - this.f15398t.e(r10));
        return;
    L5:
        r16 = -1;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int q(RecyclerView.q r10) {
        return E1(r10);
    }

    public final boolean q2(RecyclerView.q r10, a r11) {
        boolean r12 = false;
        if (r10.d() == true) goto L60;
        int r13 = this.f15404z;
        if (r13 == (-1)) goto L60;
        if (r13 >= 0) goto L10;
    L59:
        this.f15404z = -1;
        this.A = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r13 >= r10.b()) goto L59;
        r11.f15406b = this.f15404z;
        SavedState r14 = this.C;
        if (r14 == null) goto L22;
        if (r14.hasValidAnchor() == false) goto L22;
        boolean r15 = this.C.mAnchorLayoutFromEnd;
        r11.f15408d = r15;
        if (r15 == false) goto L19;
        r11.f15407c = this.f15398t.i() - this.C.mAnchorOffset;
    L20:
        return true;
    L19:
        r11.f15407c = this.f15398t.l() + this.C.mAnchorOffset;
    L22:
        if (this.A != Integer.MIN_VALUE) goto L54;
        View r16 = A(this.f15404z);
        if (r16 == null) goto L43;
        if (this.f15398t.e(r16) <= this.f15398t.m()) goto L30;
        r11.a();
        return true;
    L30:
        if ((this.f15398t.g(r16) - this.f15398t.l()) >= 0) goto L34;
        r11.f15407c = this.f15398t.l();
        r11.f15408d = false;
        return true;
    L34:
        if ((this.f15398t.i() - this.f15398t.d(r16)) >= 0) goto L38;
        r11.f15407c = this.f15398t.i();
        r11.f15408d = true;
        return true;
    L38:
        if (r11.f15408d == false) goto L40;
        int r17 = this.f15398t.d(r16) + this.f15398t.n();
    L41:
        r11.f15407c = r17;
    L53:
        return true;
    L40:
        r17 = this.f15398t.g(r16);
        goto L41
    L43:
        if (H() > 0) goto L45;
    L52:
        r11.a();
        goto L53
    L45:
        if (this.f15404z >= e0(G(0))) goto L47;
        boolean r18 = true;
    L49:
        if (r18 != this.f15401w) goto L51;
        r12 = true;
    L51:
        r11.f15408d = r12;
        goto L52
    L47:
        r18 = false;
        goto L49
    L54:
        boolean r19 = this.f15401w;
        r11.f15408d = r19;
        if (r19 == false) goto L57;
        r11.f15407c = this.f15398t.i() - this.A;
    L58:
        return true;
    L57:
        r11.f15407c = this.f15398t.l() + this.A;
    L60:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int r(RecyclerView.q r10) {
        return C1(r10);
    }

    public final void r2(RecyclerView.o r10, RecyclerView.q r11, a r12) {
        if (q2(r11, r12) == false) goto L6;
        return;
    L6:
        if (p2(r10, r11, r12) == false) goto L8;
        return;
    L8:
        r12.a();
        if (this.f15402x == false) goto L11;
        int r13 = r11.b() - 1;
    L12:
        r12.f15406b = r13;
        return;
    L11:
        r13 = 0;
        goto L12
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int s(RecyclerView.q r10) {
        return D1(r10);
    }

    public final void s2(int r10, int r11, boolean r12, RecyclerView.q r13) {
        this.f15397s.f15426m = i2();
        this.f15397s.f15419f = r10;
        int[] r14 = this.G;
        boolean r15 = false;
        r14[0] = 0;
        int r16 = 1;
        r14[1] = 0;
        A1(r13, r14);
        int r17 = Math.max(0, this.G[0]);
        int r18 = Math.max(0, this.G[1]);
        if (r10 != 1) goto L5;
        r15 = true;
    L5:
        c r19 = this.f15397s;
        if (r15 == false) goto L8;
        int r20 = r18;
    L9:
        r19.f15421h = r20;
        if (r15 == true) goto L13;
        r17 = r18;
    L13:
        r19.f15422i = r17;
        if (r15 == false) goto L19;
        r19.f15421h = r20 + this.f15398t.j();
        View r21 = W1();
        c r22 = this.f15397s;
        if (this.f15401w == false) goto L18;
        r16 = -1;
    L18:
        r22.f15418e = r16;
        int r23 = e0(r21);
        c r24 = this.f15397s;
        r22.f15417d = r23 + r24.f15418e;
        r24.f15415b = this.f15398t.d(r21);
        int r25 = this.f15398t.d(r21) - this.f15398t.i();
    L24:
        c r26 = this.f15397s;
        r26.f15416c = r11;
        if (r12 == false) goto L27;
        r26.f15416c = r11 - r25;
    L27:
        r26.f15420g = r25;
        return;
    L19:
        View r27 = X1();
        this.f15397s.f15421h += this.f15398t.l();
        c r28 = this.f15397s;
        if (this.f15401w == true) goto L23;
        r16 = -1;
    L23:
        r28.f15418e = r16;
        int r29 = e0(r27);
        c r30 = this.f15397s;
        r28.f15417d = r29 + r30.f15418e;
        r30.f15415b = this.f15398t.g(r27);
        r25 = (-this.f15398t.g(r27)) + this.f15398t.l();
        goto L24
    L8:
        r20 = r17;
        goto L9
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int t(RecyclerView.q r10) {
        return E1(r10);
    }

    public final void t2(int r10, int r11) {
        this.f15397s.f15416c = this.f15398t.i() - r11;
        c r12 = this.f15397s;
        if (this.f15401w == false) goto L5;
        int r13 = -1;
    L6:
        r12.f15418e = r13;
        r12.f15417d = r10;
        r12.f15419f = 1;
        r12.f15415b = r11;
        r12.f15420g = Integer.MIN_VALUE;
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public final void u2(a r10) {
        t2(r10.f15406b, r10.f15407c);
    }

    public final void v2(int r10, int r11) {
        this.f15397s.f15416c = r11 - this.f15398t.l();
        c r12 = this.f15397s;
        r12.f15417d = r10;
        if (this.f15401w == false) goto L5;
        int r13 = 1;
    L6:
        r12.f15418e = r13;
        r12.f15419f = -1;
        r12.f15415b = r11;
        r12.f15420g = Integer.MIN_VALUE;
        return;
    L5:
        r13 = -1;
        goto L6
    }

    public final void w2(a r10) {
        v2(r10.f15406b, r10.f15407c);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean x1() {
        if (U() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (l0() == 1073741824) goto L9;
        if (m0() == false) goto L9;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean z1() {
        if (this.C == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f15399u != this.f15402x) goto L7;
        return true;
    }

    public LinearLayoutManager(Context r10, int r11, boolean r12) {
        this.f15396r = 1;
        this.f15400v = false;
        this.f15401w = false;
        this.f15402x = false;
        this.f15403y = true;
        this.f15404z = -1;
        this.A = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        m2(r11);
        n2(r12);
    }
}
