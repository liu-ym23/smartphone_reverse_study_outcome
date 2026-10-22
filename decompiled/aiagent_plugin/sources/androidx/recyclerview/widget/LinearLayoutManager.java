package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.h implements RecyclerView.q.b {
    private static final String TAG = "LinearLayoutManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f2305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2309e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    u j;
    boolean k;
    int l;
    int m;
    SavedState n;
    final a o;
    private int[] z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel r2) {
            this.mAnchorPosition = r2.readInt();
            this.mAnchorOffset = r2.readInt();
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.mAnchorLayoutFromEnd = r0;
        }

        public SavedState(SavedState r2) {
            this.mAnchorPosition = r2.mAnchorPosition;
            this.mAnchorOffset = r2.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r2.mAnchorLayoutFromEnd;
        }

        boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mAnchorPosition);
            r1.writeInt(this.mAnchorOffset);
            r1.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        u f2310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2314e;

        a() {
            a();
        }

        void a() {
            this.f2311b = -1;
            this.f2312c = Integer.MIN_VALUE;
            this.f2313d = false;
            this.f2314e = false;
        }

        void b() {
            if (this.f2313d == false) goto L5;
            int r0 = this.f2310a.d();
        L6:
            this.f2312c = r0;
            return;
        L5:
            r0 = this.f2310a.c();
            goto L6
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2311b + ", mCoordinate=" + this.f2312c + ", mLayoutFromEnd=" + this.f2313d + ", mValid=" + this.f2314e + '}';
        }

        boolean a(View r2, RecyclerView.r r3) {
            RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r1.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r1.getViewLayoutPosition() < 0) goto L9;
            if (r1.getViewLayoutPosition() >= r3.e()) goto L9;
            return true;
        }

        public void a(View r5, int r6) {
            int r0 = this.f2310a.b();
            if (r0 < 0) goto L6;
            b(r5, r6);
            return;
        L6:
            this.f2311b = r6;
            if (this.f2313d == false) goto L13;
            int r7 = (this.f2310a.d() - r0) - this.f2310a.b(r5);
            this.f2312c = this.f2310a.d() - r7;
            if (r7 <= 0) goto L19;
            int r2 = this.f2312c - this.f2310a.e(r5);
            int r1 = this.f2310a.c();
            int r3 = r2 - (r1 + Math.min(this.f2310a.a(r5) - r1, 0));
            if (r3 >= 0) goto L20;
            this.f2312c += Math.min(r7, -r3);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r8 = this.f2310a.a(r5);
            int r4 = r8 - this.f2310a.c();
            this.f2312c = r8;
            if (r4 <= 0) goto L22;
            int r9 = (this.f2310a.d() - Math.min(0, (this.f2310a.d() - r0) - this.f2310a.b(r5))) - (r8 + this.f2310a.e(r5));
            if (r9 >= 0) goto L23;
            this.f2312c -= Math.min(r4, -r9);
            return;
        L23:
            return;
        }

        public void b(View r2, int r3) {
            if (this.f2313d == false) goto L5;
            this.f2312c = this.f2310a.b(r2) + this.f2310a.b();
        L6:
            this.f2311b = r3;
            return;
        L5:
            this.f2312c = this.f2310a.a(r2);
            goto L6
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2318d;

        public b() {
        }

        void a() {
            this.f2315a = 0;
            this.f2316b = false;
            this.f2317c = false;
            this.f2318d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2323e;
        int f;
        int g;
        int h;
        int i;
        boolean j;
        int k;
        List<RecyclerView.u> l;
        boolean m;

        c() {
            this.f2319a = true;
            this.h = 0;
            this.i = 0;
            this.j = false;
            this.l = null;
        }

        boolean a(RecyclerView.r r1) {
            int r0 = this.f2322d;
            if (r0 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r0 >= r1.e()) goto L7;
            return true;
        }

        View a(RecyclerView.n r3) {
            if (this.l != null) goto L5;
            View r4 = r3.c(this.f2322d);
            this.f2322d += this.f2323e;
            return r4;
        L5:
            return b();
        }

        private View b() {
            int r0 = this.l.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L12;
            View r2 = ((RecyclerView.u) ZeusTransformUtils.preCheckCast(this.l.get(r1), RecyclerView.u.class, "com.obric.aiagent.plugin")).f2390a;
            RecyclerView.LayoutParams r3 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r3.isItemRemoved() == true) goto L11;
            if (this.f2322d != r3.getViewLayoutPosition()) goto L11;
            a(r2);
            return r2;
        L11:
            r1 = r1 + 1;
            goto L3
        L12:
            return null;
        }

        public void a() {
            a(null);
        }

        public void a(View r3) {
            View r4 = b(r3);
            if (r4 != null) goto L5;
            this.f2322d = -1;
            return;
        L5:
            this.f2322d = ((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin")).getViewLayoutPosition();
        }

        public View b(View r9) {
            int r0 = this.l.size();
            View r1 = null;
            int r2 = Integer.MAX_VALUE;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L18;
            View r4 = ((RecyclerView.u) ZeusTransformUtils.preCheckCast(this.l.get(r3), RecyclerView.u.class, "com.obric.aiagent.plugin")).f2390a;
            RecyclerView.LayoutParams r5 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r4 == r9) goto L17;
            if (r5.isItemRemoved() == true) goto L17;
            int r6 = (r5.getViewLayoutPosition() - this.f2322d) * this.f2323e;
            if (r6 < 0) goto L17;
            if (r6 >= r2) goto L17;
            r1 = r4;
            if (r6 == 0) goto L18;
            r2 = r6;
        L17:
            r3 = r3 + 1;
        L18:
            return r1;
        }
    }

    void a(RecyclerView.n r1, RecyclerView.r r2, a r3, int r4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean d() {
        return true;
    }

    public LinearLayoutManager(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 1, false);
    }

    public LinearLayoutManager(Context r3, int r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.i = 1;
        this.f2307c = false;
        this.k = false;
        this.f2308d = false;
        this.f2309e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        this.z = new int[2];
        b(r4);
        b(r5);
    }

    public LinearLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        this.i = 1;
        this.f2307c = false;
        this.k = false;
        this.f2308d = false;
        this.f2309e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a();
        this.g = new b();
        this.h = 2;
        this.z = new int[2];
        RecyclerView.h.b r9 = a(r7, r8, r5, r6);
        b(r9.f2354a);
        b(r9.f2356c);
        a(r9.f2357d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, RecyclerView.n r2) {
        super.a(r1, r2);
        if (this.f == false) goto L6;
        c(r2);
        r2.a();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(AccessibilityEvent r2) {
        super.a(r2);
        if (x() <= 0) goto L6;
        r2.setFromIndex(o());
        r2.setToIndex(p());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public Parcelable e() {
        if (this.n != null) goto L5;
        SavedState r0 = new SavedState();
        if (x() <= 0) goto L12;
        j();
        boolean r1 = this.f2306b ^ this.k;
        r0.mAnchorLayoutFromEnd = r1;
        if (r1 == false) goto L11;
        View r2 = O();
        r0.mAnchorOffset = this.j.d() - this.j.b(r2);
        r0.mAnchorPosition = d(r2);
    L13:
        return r0;
    L11:
        View r3 = N();
        r0.mAnchorPosition = d(r3);
        r0.mAnchorOffset = this.j.a(r3) - this.j.c();
        goto L13
    L12:
        r0.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.n);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == false) goto L9;
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        this.n = r5;
        if (this.l == (-1)) goto L7;
        r5.invalidateAnchor();
    L7:
        q();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean f() {
        if (this.i != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean g() {
        if (this.i == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void a(boolean r2) {
        a(null);
        if (this.f2308d != r2) goto L5;
        return;
    L5:
        this.f2308d = r2;
        q();
    }

    public int h() {
        return this.i;
    }

    public void b(int r3) {
        if (r3 != 0) goto L4;
    L8:
        a(null);
        if (r3 == this.i) goto L11;
    L12:
        u r0 = u.a(this, r3);
        this.j = r0;
        this.o.f2310a = r0;
        this.i = r3;
        q();
        return;
    L11:
        if (this.j == null) goto L12;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r3);
    }

    private void b() {
        if (this.i != 1) goto L5;
    L8:
        this.k = this.f2307c;
        return;
    L5:
        if (i() == false) goto L8;
        this.k = !this.f2307c;
    }

    public void b(boolean r2) {
        a(null);
        if (r2 != this.f2307c) goto L5;
        return;
    L5:
        this.f2307c = r2;
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public View c(int r3) {
        int r0 = x();
        if (r0 != 0) goto L6;
        return null;
    L6:
        int r1 = r3 - d(i(0));
        if (r1 < 0) goto L13;
        if (r1 >= r0) goto L13;
        View r2 = i(r1);
        if (d(r2) != r3) goto L13;
        return r2;
    L13:
        return super.c(r3);
    }

    @Deprecated
    public int f(RecyclerView.r r1) {
        if (r1.d() == true) goto L5;
        return 0;
    L5:
        return this.j.f();
    }

    public void a(RecyclerView.r r3, int[] r4) {
        int r5 = f(r3);
        if (this.f2305a.f != (-1)) goto L5;
        int r2 = 0;
    L6:
        r4[0] = r5;
        r4[1] = r2;
        return;
    L5:
        r2 = r5;
        r5 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r3, RecyclerView.r r4, int r5) {
        p r6 = new p((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r6.c(r5);
        a(r6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q.b
    public PointF d(int r4) {
        if (x() != 0) goto L6;
        return null;
    L6:
        boolean r0 = false;
        int r2 = 1;
        if (r4 >= d(i(0))) goto L10;
        r0 = true;
    L10:
        if (r0 == this.k) goto L13;
        r2 = -1;
    L13:
        if (this.i != 0) goto L17;
        return new PointF(r2, 0.0f);
    L17:
        return new PointF(0.0f, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void c(RecyclerView.n r9, RecyclerView.r r10) {
        int r1 = -1;
        if (this.n != null) goto L7;
        if (this.l != (-1)) goto L7;
    L10:
        SavedState r0 = this.n;
        if (r0 != null) goto L13;
    L15:
        j();
        this.f2305a.f2319a = false;
        b();
        View r2 = G();
        if (this.o.f2314e == true) goto L18;
    L28:
        this.o.a();
        this.o.f2313d = this.k ^ this.f2308d;
        a(r9, r10, this.o);
        this.o.f2314e = true;
    L29:
        c r3 = this.f2305a;
        if (r3.k < 0) goto L32;
        int r4 = 1;
    L33:
        r3.f = r4;
        int[] r5 = this.z;
        r5[0] = 0;
        r5[1] = 0;
        a(r10, r5);
        int r6 = Math.max(0, this.z[0]) + this.j.c();
        int r7 = Math.max(0, this.z[1]) + this.j.g();
        if (r10.a() == false) goto L50;
        int r8 = this.l;
        if (r8 == (-1)) goto L50;
        if (this.m == Integer.MIN_VALUE) goto L50;
        View r11 = c(r8);
        if (r11 == null) goto L50;
        if (this.k == false) goto L44;
        int r12 = this.j.d() - this.j.b(r11);
        int r13 = this.m;
    L45:
        int r14 = r12 - r13;
        if (r14 <= 0) goto L48;
        r6 = r6 + r14;
        goto L50
    L48:
        r7 = r7 - r14;
        goto L50
    L44:
        r13 = this.j.a(r11) - this.j.c();
        r12 = this.m;
    L50:
        if (this.o.f2313d == false) goto L55;
        if (this.k == false) goto L56;
    L53:
        r1 = 1;
    L56:
        a(r9, r10, this.o, r1);
        a(r9);
        this.f2305a.m = m();
        this.f2305a.j = r10.a();
        this.f2305a.i = 0;
        if (this.o.f2313d == false) goto L64;
        b(this.o);
        this.f2305a.h = r6;
        a(r9, this.f2305a, r10, false);
        int r15 = this.f2305a.f2320b;
        int r16 = this.f2305a.f2322d;
        if (this.f2305a.f2321c <= 0) goto L61;
        r7 = r7 + this.f2305a.f2321c;
    L61:
        a(this.o);
        this.f2305a.h = r7;
        this.f2305a.f2322d += this.f2305a.f2323e;
        a(r9, this.f2305a, r10, false);
        int r17 = this.f2305a.f2320b;
        if (this.f2305a.f2321c <= 0) goto L71;
        int r18 = this.f2305a.f2321c;
        g(r16, r15);
        this.f2305a.h = r18;
        a(r9, this.f2305a, r10, false);
        r15 = this.f2305a.f2320b;
    L71:
        if (x() > 0) goto L73;
    L77:
        b(r9, r10, r15, r17);
        if (r10.a() == true) goto L80;
        this.j.a();
    L81:
        this.f2306b = this.f2308d;
        return;
    L80:
        this.o.a();
        goto L81
    L73:
        if ((this.k ^ this.f2308d) == false) goto L75;
        int r19 = a(r17, r9, r10, true);
        int r20 = r15 + r19;
        int r21 = r17 + r19;
        int r22 = b(r20, r9, r10, false);
    L76:
        r15 = r20 + r22;
        r17 = r21 + r22;
        goto L77
    L75:
        int r23 = b(r15, r9, r10, true);
        r20 = r15 + r23;
        r21 = r17 + r23;
        r22 = a(r21, r9, r10, false);
        goto L76
    L64:
        a(this.o);
        this.f2305a.h = r7;
        a(r9, this.f2305a, r10, false);
        r17 = this.f2305a.f2320b;
        int r24 = this.f2305a.f2322d;
        if (this.f2305a.f2321c <= 0) goto L67;
        r6 = r6 + this.f2305a.f2321c;
    L67:
        b(this.o);
        this.f2305a.h = r6;
        this.f2305a.f2322d += this.f2305a.f2323e;
        a(r9, this.f2305a, r10, false);
        r15 = this.f2305a.f2320b;
        if (this.f2305a.f2321c <= 0) goto L71;
        int r25 = this.f2305a.f2321c;
        a(r24, r17);
        this.f2305a.h = r25;
        a(r9, this.f2305a, r10, false);
        r17 = this.f2305a.f2320b;
        goto L71
    L55:
        if (this.k == false) goto L53;
    L32:
        r4 = -1;
        goto L33
    L18:
        if (this.l != (-1)) goto L28;
        if (this.n != null) goto L28;
        if (r2 == null) goto L29;
        if (this.j.a(r2) < this.j.d()) goto L26;
    L27:
        this.o.a(r2, d(r2));
        goto L29
    L26:
        if (this.j.b(r2) > this.j.c()) goto L29;
    L13:
        if (r0.hasValidAnchor() == false) goto L15;
        this.l = this.n.mAnchorPosition;
    L7:
        if (r10.e() != 0) goto L10;
        c(r9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView.r r1) {
        super.a(r1);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    private void b(RecyclerView.n r16, RecyclerView.r r17, int r18, int r19) {
        if (r17.b() == true) goto L5;
        return;
    L5:
        if (x() != 0) goto L7;
        return;
    L7:
        if (r17.a() == false) goto L9;
        return;
    L9:
        if (c() == false) goto L41;
        List<RecyclerView.u> r3 = r16.c();
        int r4 = r3.size();
        int r6 = d(i(0));
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L12:
        if (r7 >= r4) goto L27;
        RecyclerView.u r10 = (RecyclerView.u) ZeusTransformUtils.preCheckCast(r3.get(r7), RecyclerView.u.class, "com.obric.aiagent.plugin");
        if (r10.t() == true) goto L26;
        byte r12 = 1;
        if (r10.e() >= r6) goto L19;
        boolean r11 = true;
    L21:
        if (r11 == this.k) goto L23;
        r12 = -1;
    L23:
        if (r12 != (-1)) goto L25;
        r8 = r8 + this.j.e(r10.f2390a);
        goto L26
    L25:
        r9 = r9 + this.j.e(r10.f2390a);
        goto L26
    L19:
        r11 = false;
    L26:
        r7 = r7 + 1;
        goto L12
    L27:
        this.f2305a.l = r3;
        if (r8 <= 0) goto L30;
        g(d(N()), r18);
        this.f2305a.h = r8;
        this.f2305a.f2321c = 0;
        this.f2305a.a();
        a(r16, this.f2305a, r17, false);
    L30:
        if (r9 <= 0) goto L32;
        a(d(O()), r19);
        this.f2305a.h = r9;
        this.f2305a.f2321c = 0;
        this.f2305a.a();
        a(r16, this.f2305a, r17, false);
    L32:
        this.f2305a.l = null;
        return;
    }

    private void a(RecyclerView.n r2, RecyclerView.r r3, a r4) {
        if (a(r3, r4) == false) goto L6;
        return;
    L6:
        if (b(r2, r3, r4) == false) goto L8;
        return;
    L8:
        r4.b();
        if (this.f2308d == false) goto L11;
        int r1 = r3.e() - 1;
    L12:
        r4.f2311b = r1;
        return;
    L11:
        r1 = 0;
        goto L12
    }

    private boolean b(RecyclerView.n r5, RecyclerView.r r6, a r7) {
        boolean r1 = false;
        if (x() != 0) goto L5;
        return false;
    L5:
        View r0 = G();
        if (r0 == null) goto L12;
        if (r7.a(r0, r6) == false) goto L12;
        r7.a(r0, d(r0));
        return true;
    L12:
        if (this.f2306b == this.f2308d) goto L14;
        return false;
    L14:
        View r8 = a(r5, r6, r7.f2313d, this.f2308d);
        if (r8 == null) goto L35;
        r7.b(r8, d(r8));
        if (r6.a() == false) goto L19;
    L34:
        return true;
    L19:
        if (c() == false) goto L34;
        int r9 = this.j.a(r8);
        int r10 = this.j.b(r8);
        int r2 = this.j.c();
        int r4 = this.j.d();
        if (r10 > r2) goto L24;
        if (r9 >= r2) goto L24;
        boolean r3 = true;
    L25:
        if (r9 < r4) goto L28;
        if (r10 <= r4) goto L28;
        r1 = true;
    L28:
        if (r3 == true) goto L31;
        if (r1 == false) goto L34;
    L31:
        if (r7.f2313d == false) goto L33;
        r2 = r4;
    L33:
        r7.f2312c = r2;
    L24:
        r3 = false;
        goto L25
    L35:
        return false;
    }

    private boolean a(RecyclerView.r r5, a r6) {
        boolean r1 = false;
        if (r5.a() == true) goto L60;
        int r0 = this.l;
        if (r0 == (-1)) goto L60;
        if (r0 >= 0) goto L10;
    L59:
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r0 >= r5.e()) goto L59;
        r6.f2311b = this.l;
        SavedState r7 = this.n;
        if (r7 == null) goto L22;
        if (r7.hasValidAnchor() == false) goto L22;
        r6.f2313d = this.n.mAnchorLayoutFromEnd;
        if (r6.f2313d == false) goto L19;
        r6.f2312c = this.j.d() - this.n.mAnchorOffset;
    L20:
        return true;
    L19:
        r6.f2312c = this.j.c() + this.n.mAnchorOffset;
    L22:
        if (this.m != Integer.MIN_VALUE) goto L54;
        View r8 = c(this.l);
        if (r8 == null) goto L43;
        if (this.j.e(r8) <= this.j.f()) goto L30;
        r6.b();
        return true;
    L30:
        if ((this.j.a(r8) - this.j.c()) >= 0) goto L34;
        r6.f2312c = this.j.c();
        r6.f2313d = false;
        return true;
    L34:
        if ((this.j.d() - this.j.b(r8)) >= 0) goto L38;
        r6.f2312c = this.j.d();
        r6.f2313d = true;
        return true;
    L38:
        if (r6.f2313d == false) goto L40;
        int r9 = this.j.b(r8) + this.j.b();
    L41:
        r6.f2312c = r9;
    L53:
        return true;
    L40:
        r9 = this.j.a(r8);
        goto L41
    L43:
        if (x() > 0) goto L45;
    L52:
        r6.b();
        goto L53
    L45:
        if (this.l >= d(i(0))) goto L47;
        boolean r10 = true;
    L49:
        if (r10 != this.k) goto L51;
        r1 = true;
    L51:
        r6.f2313d = r1;
        goto L52
    L47:
        r10 = false;
        goto L49
    L54:
        r6.f2313d = this.k;
        if (this.k == false) goto L57;
        r6.f2312c = this.j.d() - this.m;
    L58:
        return true;
    L57:
        r6.f2312c = this.j.c() + this.m;
    L60:
        return false;
    }

    private int a(int r2, RecyclerView.n r3, RecyclerView.r r4, boolean r5) {
        int r0 = this.j.d() - r2;
        if (r0 <= 0) goto L11;
        int r6 = -c(-r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L10;
        int r8 = this.j.d() - r7;
        if (r8 <= 0) goto L10;
        this.j.a(r8);
        return r8 + r6;
    L10:
        return r6;
    L11:
        return 0;
    }

    private int b(int r2, RecyclerView.n r3, RecyclerView.r r4, boolean r5) {
        int r0 = r2 - this.j.c();
        if (r0 <= 0) goto L10;
        int r6 = -c(r0, r3, r4);
        int r7 = r2 + r6;
        if (r5 == false) goto L12;
        int r8 = r7 - this.j.c();
        if (r8 <= 0) goto L13;
        this.j.a(-r8);
        return r6 - r8;
    L13:
        return r6;
    L12:
        return r6;
    L10:
        return 0;
    }

    private void a(a r2) {
        a(r2.f2311b, r2.f2312c);
    }

    private void a(int r4, int r5) {
        this.f2305a.f2321c = this.j.d() - r5;
        c r0 = this.f2305a;
        if (this.k == false) goto L5;
        int r1 = -1;
    L6:
        r0.f2323e = r1;
        this.f2305a.f2322d = r4;
        this.f2305a.f = 1;
        this.f2305a.f2320b = r5;
        this.f2305a.g = Integer.MIN_VALUE;
        return;
    L5:
        r1 = 1;
        goto L6
    }

    private void b(a r2) {
        g(r2.f2311b, r2.f2312c);
    }

    private void g(int r3, int r4) {
        this.f2305a.f2321c = r4 - this.j.c();
        this.f2305a.f2322d = r3;
        c r5 = this.f2305a;
        if (this.k == false) goto L5;
        int r0 = 1;
    L6:
        r5.f2323e = r0;
        this.f2305a.f = -1;
        this.f2305a.f2320b = r4;
        this.f2305a.g = Integer.MIN_VALUE;
        return;
    L5:
        r0 = -1;
        goto L6
    }

    public boolean i() {
        if (v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void j() {
        if (this.f2305a != null) goto L6;
        this.f2305a = k();
        return;
    }

    c k() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void e(int r1) {
        this.l = r1;
        this.m = Integer.MIN_VALUE;
        SavedState r2 = this.n;
        if (r2 == null) goto L5;
        r2.invalidateAnchor();
    L5:
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int a(int r3, RecyclerView.n r4, RecyclerView.r r5) {
        if (this.i != 1) goto L7;
        return 0;
    L7:
        return c(r3, r4, r5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int b(int r2, RecyclerView.n r3, RecyclerView.r r4) {
        if (this.i != 0) goto L7;
        return 0;
    L7:
        return c(r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int d(RecyclerView.r r1) {
        return i(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int e(RecyclerView.r r1) {
        return i(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g(RecyclerView.r r1) {
        return j(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int h(RecyclerView.r r1) {
        return j(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int b(RecyclerView.r r1) {
        return k(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int c(RecyclerView.r r1) {
        return k(r1);
    }

    private int i(RecyclerView.r r8) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return x.a(r8, this.j, a(!this.f2309e, true), b(!this.f2309e, true), this, this.f2309e, this.k);
    }

    private int j(RecyclerView.r r7) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return x.a(r7, this.j, a(!this.f2309e, true), b(!this.f2309e, true), this, this.f2309e);
    }

    private int k(RecyclerView.r r7) {
        if (x() != 0) goto L6;
        return 0;
    L6:
        j();
        return x.b(r7, this.j, a(!this.f2309e, true), b(!this.f2309e, true), this, this.f2309e);
    }

    public boolean l() {
        return this.f2309e;
    }

    private void a(int r5, int r6, boolean r7, RecyclerView.r r8) {
        this.f2305a.m = m();
        this.f2305a.f = r5;
        int[] r0 = this.z;
        boolean r1 = false;
        r0[0] = 0;
        int r2 = 1;
        r0[1] = 0;
        a(r8, r0);
        int r9 = Math.max(0, this.z[0]);
        int r3 = Math.max(0, this.z[1]);
        if (r5 != 1) goto L5;
        r1 = true;
    L5:
        c r10 = this.f2305a;
        if (r1 == false) goto L8;
        int r4 = r3;
    L9:
        r10.h = r4;
        c r11 = this.f2305a;
        if (r1 == true) goto L13;
        r9 = r3;
    L13:
        r11.i = r9;
        if (r1 == false) goto L19;
        this.f2305a.h += this.j.g();
        View r12 = O();
        c r13 = this.f2305a;
        if (this.k == false) goto L18;
        r2 = -1;
    L18:
        r13.f2323e = r2;
        this.f2305a.f2322d = d(r12) + this.f2305a.f2323e;
        this.f2305a.f2320b = this.j.b(r12);
        int r14 = this.j.b(r12) - this.j.d();
    L24:
        this.f2305a.f2321c = r6;
        if (r7 == false) goto L27;
        this.f2305a.f2321c -= r14;
    L27:
        this.f2305a.g = r14;
        return;
    L19:
        View r15 = N();
        this.f2305a.h += this.j.c();
        c r16 = this.f2305a;
        if (this.k == true) goto L23;
        r2 = -1;
    L23:
        r16.f2323e = r2;
        this.f2305a.f2322d = d(r15) + this.f2305a.f2323e;
        this.f2305a.f2320b = this.j.a(r15);
        r14 = (-this.j.a(r15)) + this.j.c();
        goto L24
    L8:
        r4 = r9;
        goto L9
    }

    boolean m() {
        if (this.j.h() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.j.e() != 0) goto L7;
        return true;
    }

    void a(RecyclerView.r r2, c r3, RecyclerView.h.a r4) {
        RecyclerView.h.a r1 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r4, RecyclerView.h.a.class, "com.obric.aiagent.plugin");
        int r5 = r3.f2322d;
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 >= r2.e()) goto L9;
        r1.b(r5, Math.max(0, r3.g));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(int r6, RecyclerView.h.a r7) {
        RecyclerView.h.a r8 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r7, RecyclerView.h.a.class, "com.obric.aiagent.plugin");
        SavedState r0 = this.n;
        int r1 = -1;
        if (r0 != null) goto L5;
    L7:
        b();
        boolean r2 = this.k;
        int r3 = this.l;
        if (r3 != (-1)) goto L12;
        if (r2 == false) goto L11;
        r3 = r6 - 1;
        goto L12
    L11:
        r3 = 0;
    L12:
        if (r2 == true) goto L15;
        r1 = 1;
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.h) goto L21;
        if (r3 < 0) goto L25;
        if (r3 >= r6) goto L26;
        r8.b(r3, 0);
        r3 = r3 + r1;
        r4 = r4 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r0.hasValidAnchor() == false) goto L7;
        r2 = this.n.mAnchorLayoutFromEnd;
        r3 = this.n.mAnchorPosition;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(int r3, int r4, RecyclerView.r r5, RecyclerView.h.a r6) {
        RecyclerView.h.a r7 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r6, RecyclerView.h.a.class, "com.obric.aiagent.plugin");
        if (this.i == 0) goto L7;
        r3 = r4;
    L7:
        if (x() == 0) goto L16;
        if (r3 == 0) goto L17;
        j();
        if (r3 <= 0) goto L13;
        int r0 = 1;
    L14:
        a(r0, Math.abs(r3), true, r5);
        a(r5, this.f2305a, r7);
        return;
    L13:
        r0 = -1;
        goto L14
    L17:
        return;
    }

    int c(int r6, RecyclerView.n r7, RecyclerView.r r8) {
        if (x() == 0) goto L17;
        if (r6 == 0) goto L17;
        j();
        this.f2305a.f2319a = true;
        if (r6 <= 0) goto L9;
        int r0 = 1;
    L10:
        int r3 = Math.abs(r6);
        a(r0, r3, true, r8);
        int r2 = this.f2305a.g + a(r7, this.f2305a, r8, false);
        if (r2 >= 0) goto L13;
        return 0;
    L13:
        if (r3 <= r2) goto L15;
        r6 = r0 * r2;
    L15:
        this.j.a(-r6);
        this.f2305a.k = r6;
        return r6;
    L9:
        r0 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(String r2) {
        if (this.n != null) goto L6;
        super.a(r2);
        return;
    }

    private void a(RecyclerView.n r1, int r2, int r3) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r3 <= r2) goto L8;
        int r4 = r3 - 1;
    L6:
        if (r4 < r2) goto L10;
        a(r4, r1);
        r4 = r4 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r2 <= r3) goto L13;
        a(r2, r1);
        r2 = r2 - 1;
        goto L8
    }

    private void b(RecyclerView.n r5, int r6, int r7) {
        if (r6 >= 0) goto L4;
        return;
    L4:
        int r8 = r6 - r7;
        int r9 = x();
        if (this.k == false) goto L16;
        int r10 = r9 - 1;
        int r0 = r10;
    L7:
        if (r0 < 0) goto L32;
        View r1 = i(r0);
        if (this.j.b(r1) > r8) goto L14;
        if (this.j.c(r1) > r8) goto L14;
        r0 = r0 - 1;
    L14:
        a(r5, r10, r0);
        return;
    L32:
        return;
    L16:
        int r2 = 0;
    L17:
        if (r2 >= r9) goto L33;
        View r3 = i(r2);
        if (this.j.b(r3) > r8) goto L24;
        if (this.j.c(r3) > r8) goto L24;
        r2 = r2 + 1;
    L24:
        a(r5, 0, r2);
        return;
    }

    private void c(RecyclerView.n r5, int r6, int r7) {
        int r0 = x();
        if (r6 >= 0) goto L5;
        return;
    L5:
        int r1 = (this.j.e() - r6) + r7;
        if (this.k == false) goto L17;
        int r8 = 0;
    L8:
        if (r8 >= r0) goto L33;
        View r2 = i(r8);
        if (this.j.a(r2) < r1) goto L15;
        if (this.j.d(r2) < r1) goto L15;
        r8 = r8 + 1;
    L15:
        a(r5, 0, r8);
        return;
    L33:
        return;
    L17:
        int r3 = r0 - 1;
        int r9 = r3;
    L18:
        if (r9 < 0) goto L34;
        View r10 = i(r9);
        if (this.j.a(r10) < r1) goto L25;
        if (this.j.d(r10) < r1) goto L25;
        r9 = r9 - 1;
    L25:
        a(r5, r3, r9);
        return;
    }

    private void a(RecyclerView.n r4, c r5) {
        if (r5.f2319a == true) goto L5;
        return;
    L5:
        if (r5.m == true) goto L14;
        int r0 = r5.g;
        int r1 = r5.i;
        if (r5.f != (-1)) goto L10;
        c(r4, r0, r1);
        return;
    L10:
        b(r4, r0, r1);
        return;
    }

    int a(RecyclerView.n r8, c r9, RecyclerView.r r10, boolean r11) {
        int r0 = r9.f2321c;
        if (r9.g != Integer.MIN_VALUE) goto L5;
    L8:
        int r1 = r9.f2321c + r9.h;
        b r3 = this.g;
    L10:
        if (r9.m == true) goto L13;
        if (r1 > 0) goto L13;
    L34:
        return r0 - r9.f2321c;
    L13:
        if (r9.a(r10) == false) goto L34;
        r3.a();
        a(r8, r10, r9, r3);
        if (r3.f2316b == true) goto L34;
        r9.f2320b += r3.f2315a * r9.f;
        if (r3.f2317c == true) goto L20;
    L23:
        r9.f2321c -= r3.f2315a;
        r1 = r1 - r3.f2315a;
    L25:
        if (r9.g == Integer.MIN_VALUE) goto L30;
        r9.g += r3.f2315a;
        if (r9.f2321c >= 0) goto L29;
        r9.g += r9.f2321c;
    L29:
        a(r8, r9);
    L30:
        if (r11 == false) goto L10;
        if (r3.f2318d == false) goto L10;
    L20:
        if (r9.l != null) goto L23;
        if (r10.a() == true) goto L25;
    L5:
        if (r9.f2321c >= 0) goto L7;
        r9.g += r9.f2321c;
    L7:
        a(r8, r9);
        goto L8
    }

    void a(RecyclerView.n r8, RecyclerView.r r9, c r10, b r11) {
        View r12 = r10.a(r8);
        if (r12 != null) goto L6;
        r11.f2316b = true;
        return;
    L6:
        RecyclerView.LayoutParams r6 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r10.l != null) goto L15;
        boolean r0 = this.k;
        if (r10.f != (-1)) goto L11;
        boolean r3 = true;
    L12:
        if (r0 != r3) goto L14;
        b(r12);
    L22:
        a(r12, 0, 0);
        r11.f2315a = this.j.e(r12);
        if (this.i == 1) goto L25;
        int r1 = D();
        int r2 = this.j.f(r12) + r1;
        if (r10.f != (-1)) goto L35;
        int r4 = r10.f2320b;
        int r5 = r1;
        int r7 = r4;
        int r13 = r2;
        int r14 = r10.f2320b - r11.f2315a;
    L36:
        a(r12, r14, r5, r7, r13);
        if (r6.isItemRemoved() == false) goto L39;
    L40:
        r11.f2317c = true;
    L41:
        r11.f2318d = r12.hasFocusable();
        return;
    L39:
        if (r6.isItemChanged() == false) goto L41;
    L35:
        int r15 = r10.f2320b;
        r7 = r10.f2320b + r11.f2315a;
        r5 = r1;
        r13 = r2;
        r14 = r15;
        goto L36
    L25:
        if (i() == false) goto L27;
        int r16 = A() - E();
        r14 = r16 - this.j.f(r12);
    L29:
        if (r10.f != (-1)) goto L31;
        int r17 = r10.f2320b;
        r5 = r10.f2320b - r11.f2315a;
        r7 = r16;
        r13 = r17;
        goto L36
    L31:
        int r18 = r10.f2320b;
        r13 = r10.f2320b + r11.f2315a;
        r7 = r16;
        r5 = r18;
        goto L36
    L27:
        r14 = C();
        r16 = this.j.f(r12) + r14;
        goto L29
    L14:
        b(r12, 0);
        goto L22
    L11:
        r3 = false;
        goto L12
    L15:
        boolean r19 = this.k;
        if (r10.f != (-1)) goto L18;
        boolean r20 = true;
    L19:
        if (r19 != r20) goto L21;
        a(r12);
        goto L22
    L21:
        a(r12, 0);
        goto L22
    L18:
        r20 = false;
        goto L19
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    boolean n() {
        if (z() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (y() == 1073741824) goto L9;
        if (M() == false) goto L9;
        return true;
    }

    int f(int r5) {
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L36;
        if (r5 == 17) goto L31;
        if (r5 == 33) goto L26;
        if (r5 == 66) goto L21;
        if (r5 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.i != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.i != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.i != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.i != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.i != 1) goto L39;
        return 1;
    L39:
        if (i() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.i != 1) goto L46;
        return -1;
    L46:
        if (i() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    private View N() {
        if (this.k == false) goto L5;
        int r0 = x() - 1;
    L7:
        return i(r0);
    L5:
        r0 = 0;
        goto L7
    }

    private View O() {
        if (this.k == false) goto L5;
        int r0 = 0;
    L7:
        return i(r0);
    L5:
        r0 = x() - 1;
        goto L7
    }

    View a(boolean r3, boolean r4) {
        if (this.k == false) goto L7;
        return a(x() - 1, -1, r3, r4);
    L7:
        return a(0, x(), r3, r4);
    }

    View b(boolean r3, boolean r4) {
        if (this.k == false) goto L7;
        return a(0, x(), r3, r4);
    L7:
        return a(x() - 1, -1, r3, r4);
    }

    View a(RecyclerView.n r17, RecyclerView.r r18, boolean r19, boolean r20) {
        j();
        int r1 = x();
        int r2 = -1;
        if (r20 == false) goto L5;
        int r3 = x() - 1;
        int r5 = -1;
    L6:
        int r6 = r18.e();
        int r7 = this.j.c();
        int r8 = this.j.d();
        View r9 = null;
        View r10 = null;
        View r11 = null;
    L7:
        if (r3 == r2) goto L37;
        View r12 = i(r3);
        int r13 = d(r12);
        int r14 = this.j.a(r12);
        int r15 = this.j.b(r12);
        if (r13 < 0) goto L36;
        if (r13 >= r6) goto L36;
        if (((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r12.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin")).isItemRemoved() == false) goto L15;
        if (r11 != null) goto L36;
        r11 = r12;
        goto L36
    L15:
        if (r15 > r7) goto L18;
        if (r14 >= r7) goto L18;
        boolean r4 = true;
    L19:
        if (r14 < r8) goto L22;
        if (r15 <= r8) goto L22;
        boolean r16 = true;
    L23:
        if (r4 == true) goto L27;
        if (r16 == true) goto L27;
        return r12;
    L27:
        if (r19 == false) goto L32;
        if (r16 == true) goto L33;
        if (r9 != null) goto L36;
    L35:
        r9 = r12;
    L33:
        r10 = r12;
        goto L36
    L32:
        if (r4 == true) goto L33;
        if (r9 != null) goto L36;
    L22:
        r16 = false;
    L18:
        r4 = false;
    L36:
        r3 = r3 + r5;
        goto L7
    L37:
        if (r9 != null) goto L54;
        if (r10 == null) goto L42;
        return r10;
    L42:
        return r11;
    L54:
        return r9;
    L5:
        r2 = r1;
        r5 = 1;
        r3 = 0;
        goto L6
    }

    private View P() {
        if (this.k == false) goto L6;
        return R();
    L6:
        return S();
    }

    private View Q() {
        if (this.k == false) goto L6;
        return S();
    L6:
        return R();
    }

    private View R() {
        return b(0, x());
    }

    private View S() {
        return b(x() - 1, -1);
    }

    public int o() {
        View r0 = a(0, x(), false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return d(r0);
    }

    public int p() {
        View r0 = a(x() - 1, -1, false, true);
        if (r0 != null) goto L6;
        return -1;
    L6:
        return d(r0);
    }

    View a(int r2, int r3, boolean r4, boolean r5) {
        j();
        int r0 = 320;
        if (r4 == false) goto L5;
        int r6 = 24579;
    L6:
        if (r5 == true) goto L10;
        r0 = 0;
    L10:
        if (this.i != 0) goto L13;
        return this.r.a(r2, r3, r6, r0);
    L13:
        return this.s.a(r2, r3, r6, r0);
    L5:
        r6 = 320;
        goto L6
    }

    View b(int r4, int r5) {
        j();
        if (r5 <= r4) goto L5;
        byte r0 = 1;
    L8:
        if (r0 != 0) goto L12;
        return i(r4);
    L12:
        if (this.j.a(i(r4)) >= this.j.c()) goto L14;
        int r1 = 16644;
        int r2 = 16388;
    L16:
        if (this.i != 0) goto L19;
        return this.r.a(r4, r5, r1, r2);
    L19:
        return this.s.a(r4, r5, r1, r2);
    L14:
        r1 = 4161;
        r2 = 4097;
        goto L16
    L5:
        if (r5 >= r4) goto L7;
        r0 = -1;
        goto L8
    L7:
        r0 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public View a(View r4, int r5, RecyclerView.n r6, RecyclerView.r r7) {
        b();
        if (x() != 0) goto L5;
        return null;
    L5:
        int r8 = f(r5);
        if (r8 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        j();
        a(r8, (int) (this.j.f() * 0.33333334f), false, r7);
        this.f2305a.g = Integer.MIN_VALUE;
        this.f2305a.f2319a = false;
        a(r6, this.f2305a, r7, true);
        if (r8 != (-1)) goto L11;
        View r9 = Q();
    L12:
        if (r8 != (-1)) goto L14;
        View r3 = N();
    L16:
        if (r3.hasFocusable() == false) goto L20;
        if (r9 != null) goto L19;
        return null;
    L19:
        return r3;
    L20:
        return r9;
    L14:
        r3 = O();
        goto L16
    L11:
        r9 = P();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean c() {
        if (this.n == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f2306b != this.f2308d) goto L7;
        return true;
    }
}
