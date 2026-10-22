package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes4.dex */
class f {
    private static final String TAG = "ChildrenHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f35733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f35734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f35735c;

    /* JADX INFO: compiled from: ChildHelper.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f35736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f35737b;

        a() {
            this.f35736a = 0;
        }

        void a(int r5) {
            if (r5 < 64) goto L5;
            b();
            this.f35737b.a(r5 - 64);
            return;
        L5:
            this.f35736a |= 1 << r5;
        }

        private void b() {
            if (this.f35737b != null) goto L6;
            this.f35737b = new a();
            return;
        }

        void b(int r5) {
            if (r5 < 64) goto L7;
            a r4 = this.f35737b;
            if (r4 == null) goto L9;
            r4.b(r5 - 64);
            return;
        L9:
            return;
        L7:
            this.f35736a &= ~(1 << r5);
        }

        boolean c(int r5) {
            if (r5 < 64) goto L6;
            b();
            return this.f35737b.c(r5 - 64);
        L6:
            long r0 = this.f35736a;
            if (((1 << r5) & r0) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        void a() {
            this.f35736a = 0;
            a r2 = this.f35737b;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }

        void insert(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            b();
            this.f35737b.insert(r10 - 64, r11);
            return;
        L5:
            long r0 = this.f35736a;
            if ((Long.MIN_VALUE & r0) == 0) goto L8;
            boolean r2 = true;
        L9:
            long r7 = (1 << r10) - 1;
            this.f35736a = ((r0 & (~r7)) << 1) | (r0 & r7);
            if (r11 == false) goto L12;
            a(r10);
        L13:
            if (r2 == false) goto L15;
        L16:
            b();
            this.f35737b.insert(0, r2);
            return;
        L15:
            if (this.f35737b != null) goto L16;
            return;
        L12:
            b(r10);
            goto L13
        L8:
            r2 = false;
            goto L9
        }

        boolean d(int r11) {
            if (r11 < 64) goto L6;
            b();
            return this.f35737b.d(r11 - 64);
        L6:
            long r2 = 1 << r11;
            long r4 = this.f35736a;
            if ((r4 & r2) == 0) goto L9;
            boolean r12 = true;
        L10:
            long r5 = r4 & (~r2);
            this.f35736a = r5;
            long r3 = r2 - 1;
            this.f35736a = (r5 & r3) | Long.rotateRight((~r3) & r5, 1);
            a r0 = this.f35737b;
            if (r0 != null) goto L13;
        L16:
            return r12;
        L13:
            if (r0.c(0) == false) goto L15;
            a(63);
        L15:
            this.f35737b.d(0);
            goto L16
        L9:
            r12 = false;
            goto L10
        }

        int e(int r5) {
            a r0 = this.f35737b;
            if (r0 != null) goto L9;
            if (r5 >= 64) goto L6;
            long r1 = this.f35736a;
            return Long.bitCount(((1 << r5) - 1) & r1);
        L6:
            return Long.bitCount(this.f35736a);
        L9:
            if (r5 >= 64) goto L13;
            long r2 = this.f35736a;
            return Long.bitCount(((1 << r5) - 1) & r2);
        L13:
            return r0.e(r5 - 64) + Long.bitCount(this.f35736a);
        }

        public String toString() {
            if (this.f35737b != null) goto L6;
            return Long.toBinaryString(this.f35736a);
        L6:
            return this.f35737b.toString() + "xx" + Long.toBinaryString(this.f35736a);
        }
    }

    /* JADX INFO: compiled from: ChildHelper.java */
    interface b {
        int a();

        int a(View r1);

        void a(int r1);

        void a(View r1, int r2);

        void a(View r1, int r2, ViewGroup.LayoutParams r3);

        View b(int r1);

        RecyclerView.v b(View r1);

        void b();

        void c(int r1);

        void c(View r1);

        void d(View r1);
    }

    f(b r3) {
        this.f35733a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f35734b = new a();
        this.f35735c = new ArrayList();
    }

    private void g(View r2) {
        this.f35735c.add(r2);
        this.f35733a.c(r2);
    }

    private boolean h(View r2) {
        if (this.f35735c.remove(r2) == false) goto L6;
        this.f35733a.d(r2);
        return true;
    L6:
        return false;
    }

    void a(View r2, boolean r3) {
        a(r2, -1, r3);
    }

    void a(View r2, int r3, boolean r4) {
        if (r3 >= 0) goto L4;
        int r5 = this.f35733a.a();
    L5:
        this.f35734b.insert(r5, r4);
        if (r4 == false) goto L8;
        g(r2);
    L8:
        this.f35733a.a(r2, r5);
        return;
    L4:
        r5 = f(r3);
        goto L5
    }

    private int f(int r5) {
        if (r5 >= 0) goto L5;
        return -1;
    L5:
        int r1 = this.f35733a.a();
        int r2 = r5;
    L6:
        if (r2 >= r1) goto L14;
        int r3 = r5 - (r2 - this.f35734b.e(r2));
        if (r3 == 0) goto L10;
        r2 = r2 + r3;
    L10:
        if (this.f35734b.c(r2) == false) goto L12;
        r2 = r2 + 1;
        goto L10
    L12:
        return r2;
    L14:
        return -1;
    }

    void a(View r3) {
        int r0 = this.f35733a.a(r3);
        if (r0 >= 0) goto L6;
        return;
    L6:
        if (this.f35734b.d(r0) == false) goto L8;
        h(r3);
    L8:
        this.f35733a.a(r0);
    }

    void a(int r3) {
        int r4 = f(r3);
        View r0 = this.f35733a.b(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f35734b.d(r4) == false) goto L8;
        h(r0);
    L8:
        this.f35733a.a(r4);
    }

    View b(int r1) {
        int r2 = f(r1);
        return this.f35733a.b(r2);
    }

    void a() {
        this.f35734b.a();
        int r0 = this.f35735c.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.f35733a.d((View) ZeusTransformUtils.preCheckCast(this.f35735c.get(r0), View.class, "com.obric.aiagent.plugin"));
        this.f35735c.remove(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        this.f35733a.b();
    }

    View c(int r6) {
        int r0 = this.f35735c.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.f35735c.get(r1), View.class, "com.obric.aiagent.plugin");
        RecyclerView.v r3 = this.f35733a.b(r2);
        if (r3.h() != r6) goto L11;
        if (r3.u() == true) goto L11;
        if (r3.x() == true) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return null;
    }

    void a(View r2, int r3, ViewGroup.LayoutParams r4, boolean r5) {
        if (r3 >= 0) goto L4;
        int r6 = this.f35733a.a();
    L5:
        this.f35734b.insert(r6, r5);
        if (r5 == false) goto L8;
        g(r2);
    L8:
        this.f35733a.a(r2, r6, r4);
        return;
    L4:
        r6 = f(r3);
        goto L5
    }

    int b() {
        return this.f35733a.a() - this.f35735c.size();
    }

    int c() {
        return this.f35733a.a();
    }

    View d(int r1) {
        return this.f35733a.b(r1);
    }

    void e(int r2) {
        int r3 = f(r2);
        this.f35734b.d(r3);
        this.f35733a.c(r3);
    }

    int b(View r3) {
        int r4 = this.f35733a.a(r3);
        if (r4 != (-1)) goto L6;
        return -1;
    L6:
        if (this.f35734b.c(r4) == false) goto L9;
        return -1;
    L9:
        return r4 - this.f35734b.e(r4);
    }

    boolean c(View r1) {
        return this.f35735c.contains(r1);
    }

    void d(View r3) {
        int r0 = this.f35733a.a(r3);
        if (r0 < 0) goto L7;
        this.f35734b.a(r0);
        g(r3);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }

    void e(View r3) {
        int r0 = this.f35733a.a(r3);
        if (r0 < 0) goto L11;
        if (this.f35734b.c(r0) == false) goto L9;
        this.f35734b.b(r0);
        h(r3);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r3);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r3);
    }

    public String toString() {
        return this.f35734b.toString() + ", hidden list:" + this.f35735c.size();
    }

    boolean f(View r4) {
        int r0 = this.f35733a.a(r4);
        if (r0 != (-1)) goto L7;
        h(r4);
        return true;
    L7:
        if (this.f35734b.c(r0) == false) goto L10;
        this.f35734b.d(r0);
        h(r4);
        this.f35733a.a(r0);
        return true;
    L10:
        return false;
    }
}
