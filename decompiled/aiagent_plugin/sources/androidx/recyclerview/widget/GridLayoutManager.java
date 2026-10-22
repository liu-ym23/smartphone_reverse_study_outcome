package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final String TAG = "GridLayoutManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f2287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View[] f2288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final SparseIntArray f2289e;
    final SparseIntArray f;
    b g;
    final Rect h;
    private boolean z;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int r1) {
            return 1;
        }

        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int a(int r1, int r2) {
            return r1 % r2;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f2290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f2291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2293d;

        public abstract int a(int r1);

        public b() {
            this.f2290a = new SparseIntArray();
            this.f2291b = new SparseIntArray();
            this.f2292c = false;
            this.f2293d = false;
        }

        public void a() {
            this.f2290a.clear();
        }

        public void b() {
            this.f2291b.clear();
        }

        int b(int r3, int r4) {
            if (this.f2292c == false) goto L5;
            int r0 = this.f2290a.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = a(r3, r4);
            this.f2290a.put(r3, r5);
            return r5;
        L5:
            return a(r3, r4);
        }

        int c(int r3, int r4) {
            if (this.f2293d == false) goto L5;
            int r0 = this.f2291b.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = d(r3, r4);
            this.f2291b.put(r3, r5);
            return r5;
        L5:
            return d(r3, r4);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int a(int r6, int r7) {
            int r0 = a(r6);
            if (r0 != r7) goto L6;
            return 0;
        L6:
            if (this.f2292c == false) goto L10;
            int r2 = a(this.f2290a, r6);
            if (r2 < 0) goto L10;
            int r3 = this.f2290a.get(r2) + a(r2);
        L17:
            r2 = r2 + 1;
        L11:
            if (r2 >= r6) goto L19;
            int r4 = a(r2);
            r3 = r3 + r4;
            if (r3 != r7) goto L15;
            r3 = 0;
            goto L17
        L15:
            if (r3 <= r7) goto L17;
            r3 = r4;
            goto L17
        L19:
            if ((r0 + r3) > r7) goto L21;
            return r3;
        L21:
            return 0;
        L10:
            r2 = 0;
            r3 = 0;
            goto L11
        }

        static int a(SparseIntArray r4, int r5) {
            int r0 = r4.size() - 1;
            int r1 = 0;
        L3:
            if (r1 > r0) goto L8;
            int r2 = (r1 + r0) >>> 1;
            if (r4.keyAt(r2) < r5) goto L6;
            r0 = r2 - 1;
            goto L3
        L6:
            r1 = r2 + 1;
            goto L3
        L8:
            int r3 = r1 - 1;
            if (r3 >= 0) goto L11;
            return -1;
        L11:
            if (r3 < r4.size()) goto L13;
            return -1;
        L13:
            return r4.keyAt(r3);
        }

        public int d(int r7, int r8) {
            if (this.f2293d == false) goto L9;
            int r0 = a(this.f2291b, r7);
            if (r0 == (-1)) goto L9;
            int r2 = this.f2291b.get(r0);
            int r3 = r0 + 1;
            int r4 = b(r0, r8) + a(r0);
            if (r4 != r8) goto L10;
            r2 = r2 + 1;
            r4 = 0;
        L10:
            int r1 = a(r7);
        L11:
            if (r3 >= r7) goto L19;
            int r5 = a(r3);
            r4 = r4 + r5;
            if (r4 != r8) goto L15;
            r2 = r2 + 1;
            r4 = 0;
        L17:
            r3 = r3 + 1;
            goto L11
        L15:
            if (r4 <= r8) goto L17;
            r2 = r2 + 1;
            r4 = r5;
            goto L17
        L19:
            if ((r4 + r1) > r8) goto L21;
            return r2;
        L21:
            return r2 + 1;
        L9:
            r2 = 0;
            r3 = 0;
            r4 = 0;
            goto L10
        }
    }

    public GridLayoutManager(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        this.f2285a = false;
        this.f2286b = -1;
        this.f2289e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(a(r7, r8, r5, r6).f2355b);
    }

    public GridLayoutManager(Context r3, int r4, int r5, boolean r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r5, r6);
        this.f2285a = false;
        this.f2286b = -1;
        this.f2289e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(r4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(boolean r1) {
        if (r1 == true) goto L6;
        super.a(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int a(RecyclerView.n r3, RecyclerView.r r4) {
        if (this.i != 0) goto L7;
        return this.f2286b;
    L7:
        if (r4.e() >= 1) goto L11;
        return 0;
    L11:
        return a(r3, r4, r4.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int b(RecyclerView.n r3, RecyclerView.r r4) {
        if (this.i != 1) goto L7;
        return this.f2286b;
    L7:
        if (r4.e() >= 1) goto L11;
        return 0;
    L11:
        return a(r3, r4, r4.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView.n r8, RecyclerView.r r9, View r10, androidx.core.view.accessibility.b r11) {
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, LayoutParams.class) == true) goto L6;
        super.a(r10, r11);
        return;
    L6:
        LayoutParams r12 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0, LayoutParams.class, "com.obric.aiagent.plugin");
        int r13 = a(r8, r9, r12.getViewLayoutPosition());
        if (this.i != 0) goto L9;
        r11.c(androidx.core.view.accessibility.b.g.a(r12.getSpanIndex(), r12.getSpanSize(), r13, 1, false, false));
        return;
    L9:
        r11.c(androidx.core.view.accessibility.b.g.a(r13, 1, r12.getSpanIndex(), r12.getSpanSize(), false, false));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public void c(RecyclerView.n r2, RecyclerView.r r3) {
        if (r3.a() == false) goto L5;
        O();
    L5:
        super.c(r2, r3);
        N();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView.r r1) {
        super.a(r1);
        this.f2285a = false;
    }

    private void N() {
        this.f2289e.clear();
        this.f.clear();
    }

    private void O() {
        int r0 = x();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(i(r1).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r3 = r2.getViewLayoutPosition();
        this.f2289e.put(r3, r2.getSpanSize());
        this.f.put(r3, r2.getSpanIndex());
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3) {
        this.g.a();
        this.g.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1) {
        this.g.a();
        this.g.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void b(RecyclerView r1, int r2, int r3) {
        this.g.a();
        this.g.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, Object r4) {
        this.g.a();
        this.g.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(RecyclerView r1, int r2, int r3, int r4) {
        this.g.a();
        this.g.b();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        if (this.i != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(Context r2, AttributeSet r3) {
        return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L7:
        return new LayoutParams(r3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean a(RecyclerView.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    private void P() {
        if (h() != 1) goto L5;
        int r0 = A() - E();
        int r1 = C();
    L6:
        m(r0 - r1);
        return;
    L5:
        r0 = B() - F();
        r1 = D();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void a(Rect r5, int r6, int r7) {
        if (this.f2287c != null) goto L5;
        super.a(r5, r6, r7);
    L5:
        int r0 = C() + E();
        int r1 = D() + F();
        if (this.i != 1) goto L8;
        int r8 = a(r7, r5.height() + r1, J());
        int[] r9 = this.f2287c;
        int r10 = a(r6, r9[r9.length - 1] + r0, I());
    L9:
        f(r10, r8);
        return;
    L8:
        r10 = a(r6, r5.width() + r0, I());
        int[] r11 = this.f2287c;
        r8 = a(r7, r11[r11.length - 1] + r1, J());
        goto L9
    }

    private void m(int r3) {
        this.f2287c = a(this.f2287c, this.f2286b, r3);
    }

    static int[] a(int[] r5, int r6, int r7) {
        int r0 = 1;
        if (r5 != null) goto L5;
    L8:
        r5 = new int[r6 + 1];
    L9:
        int r1 = 0;
        r5[0] = 0;
        int r2 = r7 / r6;
        int r8 = r7 % r6;
        int r3 = 0;
    L10:
        if (r0 > r6) goto L18;
        r1 = r1 + r8;
        if (r1 > 0) goto L14;
    L16:
        int r4 = r2;
    L17:
        r3 = r3 + r4;
        r5[r0] = r3;
        r0 = r0 + 1;
        goto L10
    L14:
        if ((r6 - r1) >= r8) goto L16;
        r4 = r2 + 1;
        r1 = r1 - r6;
        goto L17
    L18:
        return r5;
    L5:
        if (r5.length != (r6 + 1)) goto L8;
        if (r5[r5.length - 1] == r7) goto L9;
        goto L8
    }

    int a(int r3, int r4) {
        if (this.i == 1) goto L5;
    L8:
        int[] r2 = this.f2287c;
        return r2[r4 + r3] - r2[r3];
    L5:
        if (i() == false) goto L8;
        int[] r0 = this.f2287c;
        int r5 = this.f2286b;
        return r0[r5 - r3] - r0[(r5 - r3) - r4];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.n r2, RecyclerView.r r3, LinearLayoutManager.a r4, int r5) {
        super.a(r2, r3, r4, r5);
        P();
        if (r3.e() > 0) goto L5;
    L7:
        Q();
        return;
    L5:
        if (r3.a() == true) goto L7;
        b(r2, r3, r4, r5);
        goto L7
    }

    private void Q() {
        View[] r0 = this.f2288d;
        if (r0 != null) goto L5;
    L6:
        this.f2288d = new View[this.f2286b];
        return;
    L5:
        if (r0.length != this.f2286b) goto L6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int a(int r1, RecyclerView.n r2, RecyclerView.r r3) {
        P();
        Q();
        return super.a(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int b(int r1, RecyclerView.n r2, RecyclerView.r r3) {
        P();
        Q();
        return super.b(r1, r2, r3);
    }

    private void b(RecyclerView.n r5, RecyclerView.r r6, LinearLayoutManager.a r7, int r8) {
        if (r8 != 1) goto L5;
        boolean r9 = true;
    L6:
        int r1 = b(r5, r6, r7.f2311b);
        if (r9 == false) goto L12;
    L8:
        if (r1 <= 0) goto L23;
        if (r7.f2311b <= 0) goto L24;
        r7.f2311b--;
        r1 = b(r5, r6, r7.f2311b);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r10 = r6.e() - 1;
        int r0 = r7.f2311b;
    L13:
        if (r0 >= r10) goto L17;
        int r2 = r0 + 1;
        int r3 = b(r5, r6, r2);
        if (r3 <= r1) goto L17;
        r0 = r2;
        r1 = r3;
    L17:
        r7.f2311b = r0;
        return;
    L5:
        r9 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View a(RecyclerView.n r11, RecyclerView.r r12, boolean r13, boolean r14) {
        int r15 = x();
        int r0 = -1;
        int r1 = 1;
        if (r14 == false) goto L5;
        int r16 = x() - 1;
        r1 = -1;
    L6:
        int r17 = r12.e();
        j();
        int r2 = this.j.c();
        int r3 = this.j.d();
        View r4 = null;
        View r5 = null;
    L7:
        if (r16 == r0) goto L27;
        View r6 = i(r16);
        int r7 = d(r6);
        if (r7 < 0) goto L26;
        if (r7 >= r17) goto L26;
        if (b(r11, r12, r7) != 0) goto L26;
        if (((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin")).isItemRemoved() == false) goto L19;
        if (r5 != null) goto L26;
        r5 = r6;
        goto L26
    L19:
        if (this.j.a(r6) < r3) goto L21;
    L24:
        if (r4 != null) goto L26;
        r4 = r6;
        goto L26
    L21:
        if (this.j.b(r6) < r2) goto L24;
        return r6;
    L26:
        r16 = r16 + r1;
        goto L7
    L27:
        if (r4 == null) goto L30;
        return r4;
    L30:
        return r5;
    L5:
        r0 = r15;
        r16 = 0;
        goto L6
    }

    private int a(RecyclerView.n r1, RecyclerView.r r2, int r3) {
        if (r2.a() == false) goto L5;
        int r4 = r1.b(r3);
        if (r4 != (-1)) goto L11;
        a(TAG, "Cannot find span size for pre layout position. " + r3);
        return 0;
    L11:
        return this.g.c(r4, this.f2286b);
    L5:
        return this.g.c(r3, this.f2286b);
    }

    private int b(RecyclerView.n r2, RecyclerView.r r3, int r4) {
        if (r3.a() == false) goto L5;
        int r5 = this.f.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.b(r4);
        if (r6 != (-1)) goto L14;
        a(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 0;
    L14:
        return this.g.b(r6, this.f2286b);
    L5:
        return this.g.b(r4, this.f2286b);
    }

    private int c(RecyclerView.n r2, RecyclerView.r r3, int r4) {
        if (r3.a() == false) goto L5;
        int r5 = this.f2289e.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.b(r4);
        if (r6 != (-1)) goto L14;
        a(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 1;
    L14:
        return this.g.a(r6);
    L5:
        return this.g.a(r4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.r r6, LinearLayoutManager.c r7, RecyclerView.h.a r8) {
        RecyclerView.h.a r9 = (RecyclerView.h.a) ZeusTransformUtils.wrapperContextForParams(r8, RecyclerView.h.a.class, "com.obric.aiagent.plugin");
        int r0 = this.f2286b;
        int r2 = 0;
    L4:
        if (r2 >= this.f2286b) goto L9;
        if (r7.a(r6) == false) goto L13;
        if (r0 <= 0) goto L14;
        int r3 = r7.f2322d;
        r9.b(r3, Math.max(0, r7.g));
        r0 = r0 - this.g.a(r3);
        r7.f2322d += r7.f2323e;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v22 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.n r19, RecyclerView.r r20, LinearLayoutManager.c r21, LinearLayoutManager.b r22) {
        int r3 = this.j.i();
        ?? r5 = 0;
        if (r3 == 1073741824) goto L5;
        boolean r9 = true;
    L7:
        if (x() <= 0) goto L9;
        int r10 = this.f2287c[this.f2286b];
    L10:
        if (r9 == false) goto L13;
        P();
    L13:
        if (r21.f2323e != 1) goto L15;
        boolean r11 = true;
    L16:
        int r12 = this.f2286b;
        if (r11 == true) goto L19;
        r12 = b(r19, r20, r21.f2322d) + c(r19, r20, r21.f2322d);
    L19:
        int r13 = 0;
    L21:
        if (r13 >= this.f2286b) goto L36;
        if (r21.a(r20) == false) goto L36;
        if (r12 <= 0) goto L36;
        int r14 = r21.f2322d;
        int r15 = c(r19, r20, r14);
        if (r15 > this.f2286b) goto L35;
        r12 = r12 - r15;
        if (r12 < 0) goto L36;
        View r4 = r21.a(r19);
        if (r4 == null) goto L36;
        this.f2288d[r13] = r4;
        r13 = r13 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r14 + " requires " + r15 + " spans but GridLayoutManager has only " + this.f2286b + " spans.");
    L36:
        if (r13 != 0) goto L39;
        r22.f2316b = true;
        return;
    L39:
        float r6 = 0.0f;
        a(r19, r20, r13, r11);
        int r0 = 0;
        int r1 = 0;
    L41:
        if (r0 >= r13) goto L57;
        View r16 = this.f2288d[r0];
        if (r21.l != null) goto L47;
        if (r11 == false) goto L46;
        b(r16);
    L50:
        b(r16, this.h);
        a(r16, r3, r5);
        int r17 = this.j.e(r16);
        if (r17 <= r1) goto L53;
        r1 = r17;
    L53:
        float r18 = (this.j.f(r16) * 1.0f) / ((LayoutParams) ZeusTransformUtils.preCheckCast(r16.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mSpanSize;
        if (r18 <= r6) goto L56;
        r6 = r18;
    L56:
        r0 = r0 + 1;
        r5 = 0;
        goto L41
    L46:
        b(r16, r5);
        goto L50
    L47:
        if (r11 == false) goto L49;
        a(r16);
        goto L50
    L49:
        a(r16, r5);
        goto L50
    L57:
        if (r9 == false) goto L64;
        a(r6, r10);
        int r2 = 0;
        r1 = 0;
    L59:
        if (r2 >= r13) goto L64;
        View r7 = this.f2288d[r2];
        a(r7, 1073741824, true);
        int r8 = this.j.e(r7);
        if (r8 <= r1) goto L63;
        r1 = r8;
    L63:
        r2 = r2 + 1;
    L64:
        int r23 = 0;
    L65:
        if (r23 >= r13) goto L75;
        View r24 = this.f2288d[r23];
        if (this.j.e(r24) == r1) goto L74;
        LayoutParams r25 = (LayoutParams) ZeusTransformUtils.preCheckCast(r24.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r26 = r25.mDecorInsets;
        int r27 = ((r26.top + r26.bottom) + r25.topMargin) + r25.bottomMargin;
        int r110 = ((r26.left + r26.right) + r25.leftMargin) + r25.rightMargin;
        int r28 = a(r25.mSpanIndex, r25.mSpanSize);
        if (this.i != 1) goto L71;
        int r29 = a(r28, 1073741824, r110, r25.width, false);
        int r30 = View.MeasureSpec.makeMeasureSpec(r1 - r27, 1073741824);
    L72:
        a(r24, r29, r30, true);
        goto L74
    L71:
        int r111 = View.MeasureSpec.makeMeasureSpec(r1 - r110, 1073741824);
        r30 = a(r28, 1073741824, r27, r25.height, false);
        r29 = r111;
    L74:
        r23 = r23 + 1;
        goto L65
    L75:
        int r112 = 0;
        r22.f2315a = r1;
        if (this.i != 1) goto L83;
        if (r21.f != (-1)) goto L80;
        int r31 = r21.f2320b;
        int r32 = r31 - r1;
    L81:
        int r33 = 0;
        int r34 = 0;
    L86:
        if (r112 >= r13) goto L101;
        View r35 = this.f2288d[r112];
        LayoutParams r113 = (LayoutParams) ZeusTransformUtils.preCheckCast(r35.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (this.i == 1) goto L90;
        int r36 = D() + this.f2287c[r113.mSpanIndex];
        int r114 = r36;
        int r115 = r33;
        int r116 = r34;
        r31 = this.j.f(r35) + r36;
    L95:
        a(r35, r116, r114, r115, r31);
        if (r113.isItemRemoved() == false) goto L98;
    L99:
        r22.f2317c = true;
    L100:
        r22.f2318d |= r35.hasFocusable();
        r112 = r112 + 1;
        r31 = r31;
        r33 = r115;
        r34 = r116;
        r32 = r114;
        goto L86
    L98:
        if (r113.isItemChanged() == false) goto L100;
    L90:
        if (i() == false) goto L92;
        int r37 = C() + this.f2287c[this.f2286b - r113.mSpanIndex];
        r115 = r37;
        r116 = r37 - this.j.f(r35);
    L93:
        r114 = r32;
        goto L95
    L92:
        int r38 = C() + this.f2287c[r113.mSpanIndex];
        r116 = r38;
        r115 = this.j.f(r35) + r38;
        goto L93
    L101:
        Arrays.fill(this.f2288d, null);
        return;
    L80:
        int r39 = r21.f2320b;
        r32 = r39;
        r31 = r1 + r39;
        goto L81
    L83:
        if (r21.f != (-1)) goto L85;
        int r40 = r21.f2320b;
        r34 = r40 - r1;
        r32 = 0;
        r33 = r40;
        r31 = 0;
        goto L86
    L85:
        int r41 = r21.f2320b;
        r33 = r1 + r41;
        r34 = r41;
        r31 = 0;
        r32 = 0;
        goto L86
    L15:
        r11 = false;
        goto L16
    L9:
        r10 = 0;
        goto L10
    L5:
        r9 = false;
        goto L7
    }

    private void a(View r9, int r10, boolean r11) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r9.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r1 = r0.mDecorInsets;
        int r2 = ((r1.top + r1.bottom) + r0.topMargin) + r0.bottomMargin;
        int r3 = ((r1.left + r1.right) + r0.leftMargin) + r0.rightMargin;
        int r4 = a(r0.mSpanIndex, r0.mSpanSize);
        if (this.i != 1) goto L5;
        int r12 = a(r4, r10, r3, r0.width, false);
        int r5 = a(this.j.f(), z(), r2, r0.height, true);
    L6:
        a(r9, r12, r5, r11);
        return;
    L5:
        int r13 = a(r4, r10, r2, r0.height, false);
        int r6 = a(this.j.f(), y(), r3, r0.width, true);
        r5 = r13;
        r12 = r6;
        goto L6
    }

    private void a(float r2, int r3) {
        m(Math.max(Math.round(r2 * this.f2286b), r3));
    }

    private void a(View r4, int r5, int r6, boolean r7) {
        RecyclerView.LayoutParams r0 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L5;
        boolean r3 = a(r4, r5, r6, r0);
    L6:
        if (r3 == false) goto L9;
        r4.measure(r5, r6);
        return;
    L9:
        return;
    L5:
        r3 = b(r4, r5, r6, r0);
        goto L6
    }

    private void a(RecyclerView.n r7, RecyclerView.r r8, int r9, boolean r10) {
        int r0 = 0;
        int r1 = -1;
        if (r10 == false) goto L5;
        int r11 = 1;
        r1 = r9;
        int r12 = 0;
    L6:
        if (r12 == r1) goto L8;
        View r2 = this.f2288d[r12];
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r3.mSpanSize = c(r7, r8, d(r2));
        r3.mSpanIndex = r0;
        r0 = r0 + r3.mSpanSize;
        r12 = r12 + r11;
        goto L6
    L8:
        return;
    L5:
        r12 = r9 - 1;
        r11 = -1;
        goto L6
    }

    public int b() {
        return this.f2286b;
    }

    public void a(int r3) {
        if (r3 != this.f2286b) goto L5;
        return;
    L5:
        this.f2285a = true;
        if (r3 < 1) goto L10;
        this.f2286b = r3;
        this.g.a();
        q();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public View a(View r24, int r25, RecyclerView.n r26, RecyclerView.r r27) {
        RecyclerView.n r1 = r26;
        RecyclerView.r r2 = r27;
        View r3 = e(r24);
        View r4 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r7 = "com.obric.aiagent.plugin";
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r6 = r5.mSpanIndex;
        int r8 = r5.mSpanIndex + r5.mSpanSize;
        if (super.a(r24, r25, r26, r27) != null) goto L9;
        return null;
    L9:
        if (f(r25) != 1) goto L11;
        boolean r9 = true;
    L13:
        if (r9 == this.k) goto L15;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        int r11 = x() - 1;
        int r12 = -1;
        int r13 = -1;
    L21:
        if (this.i == 1) goto L23;
    L25:
        boolean r14 = false;
    L26:
        int r15 = a(r1, r2, r11);
        int r16 = -1;
        int r17 = -1;
        int r18 = r13;
        int r19 = 0;
        int r110 = 0;
        int r111 = r11;
        View r20 = null;
    L27:
        if (r111 == r12) goto L81;
        int r112 = r12;
        int r113 = a(r1, r2, r111);
        View r21 = i(r111);
        if (r21 == r3) goto L81;
        if (r21.hasFocusable() == false) goto L37;
        if (r113 == r15) goto L37;
        if (r4 != null) goto L81;
        View r114 = r3;
        View r22 = r20;
        String r23 = r7;
        int r28 = r16;
        int r29 = r17;
    L78:
        int r30 = r28;
    L79:
        r20 = r22;
    L80:
        r111 = r111 + r18;
        r1 = r26;
        r16 = r30;
        r17 = r29;
        r12 = r112;
        r3 = r114;
        r7 = r23;
        r2 = r27;
    L37:
        LayoutParams r31 = (LayoutParams) ZeusTransformUtils.preCheckCast(r21.getLayoutParams(), LayoutParams.class, r7);
        int r115 = r31.mSpanIndex;
        r114 = r3;
        r23 = r7;
        int r32 = r31.mSpanIndex + r31.mSpanSize;
        if (r21.hasFocusable() == false) goto L43;
        if (r115 != r6) goto L43;
        if (r32 != r8) goto L43;
        return r21;
    L43:
        if (r21.hasFocusable() == false) goto L46;
        if (r4 != null) goto L46;
    L48:
        r22 = r20;
        r28 = r16;
        r29 = r17;
        boolean r33 = true;
    L73:
        if (r33 == false) goto L78;
        if (r21.hasFocusable() == false) goto L77;
        r30 = r31.mSpanIndex;
        r19 = Math.min(r32, r8) - Math.max(r115, r6);
        r4 = r21;
        goto L79
    L77:
        int r34 = r31.mSpanIndex;
        r110 = Math.min(r32, r8) - Math.max(r115, r6);
        r20 = r21;
        r29 = r34;
        r30 = r28;
    L46:
        if (r21.hasFocusable() == true) goto L49;
        if (r20 == null) goto L48;
    L49:
        int r35 = Math.min(r32, r8) - Math.max(r115, r6);
        if (r21.hasFocusable() == false) goto L59;
        if (r35 > r19) goto L48;
        if (r35 != r19) goto L71;
        if (r115 <= r16) goto L56;
        boolean r36 = true;
    L57:
        if (r14 != r36) goto L71;
    L56:
        r36 = false;
    L71:
        r22 = r20;
        r28 = r16;
        r29 = r17;
    L72:
        r33 = false;
        goto L73
    L59:
        if (r4 != null) goto L71;
        r22 = r20;
        r28 = r16;
        boolean r37 = false;
        if (a(r21, false, true) == false) goto L70;
        if (r35 <= r110) goto L64;
        r33 = true;
        r29 = r17;
        goto L73
    L64:
        if (r35 != r110) goto L70;
        r29 = r17;
        if (r115 <= r29) goto L68;
        r37 = true;
    L68:
        if (r14 != r37) goto L72;
        r33 = true;
    L70:
        r29 = r17;
    L81:
        View r210 = r20;
        if (r4 == null) goto L85;
        return r4;
    L85:
        return r210;
    L23:
        if (i() == false) goto L25;
        r14 = true;
        goto L26
    L19:
        r12 = x();
        r13 = 1;
        r11 = 0;
        goto L21
    L15:
        r10 = false;
        goto L17
    L11:
        r9 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public boolean c() {
        if (this.n == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f2285a == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int b(RecyclerView.r r2) {
        if (this.z == false) goto L7;
        return i(r2);
    L7:
        return super.b(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int c(RecyclerView.r r2) {
        if (this.z == false) goto L7;
        return i(r2);
    L7:
        return super.c(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int d(RecyclerView.r r2) {
        if (this.z == false) goto L7;
        return j(r2);
    L7:
        return super.d(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.h
    public int e(RecyclerView.r r2) {
        if (this.z == false) goto L7;
        return j(r2);
    L7:
        return super.e(r2);
    }

    private int i(RecyclerView.r r7) {
        if (x() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r7.e() == 0) goto L17;
        j();
        View r0 = a(!l(), true);
        View r3 = b(!l(), true);
        if (r0 == null) goto L17;
        if (r3 == null) goto L17;
        if (l() == false) goto L14;
        int r1 = this.j.b(r3) - this.j.a(r0);
        int r2 = this.g.c(d(r0), this.f2286b);
        int r4 = this.g.c(d(r3), this.f2286b);
        return (int) ((r1 / ((r4 - r2) + 1)) * (this.g.c(r7.e() - 1, this.f2286b) + 1));
    L14:
        return this.g.c(r7.e() - 1, this.f2286b) + 1;
    }

    private int j(RecyclerView.r r10) {
        if (x() != 0) goto L5;
    L19:
        return 0;
    L5:
        if (r10.e() == 0) goto L19;
        j();
        boolean r0 = l();
        View r2 = a(!r0, true);
        View r4 = b(!r0, true);
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r5 = this.g.c(d(r2), this.f2286b);
        int r6 = this.g.c(d(r4), this.f2286b);
        int r7 = Math.min(r5, r6);
        int r8 = Math.max(r5, r6);
        int r11 = this.g.c(r10.e() - 1, this.f2286b) + 1;
        if (this.k == false) goto L14;
        int r12 = Math.max(0, (r11 - r8) - 1);
    L15:
        if (r0 == true) goto L18;
        return r12;
    L18:
        return Math.round((r12 * (Math.abs(this.j.b(r4) - this.j.a(r2)) / ((this.g.c(d(r4), this.f2286b) - this.g.c(d(r2), this.f2286b)) + 1))) + (this.j.c() - this.j.a(r2)));
    L14:
        r12 = Math.max(0, r7);
        goto L15
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
