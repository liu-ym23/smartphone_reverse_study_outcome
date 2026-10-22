package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChildHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callback f15389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f15390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f15391c;

    public interface Callback {
        void addView(View r10, int r11);

        void attachViewToParent(View r10, int r11, ViewGroup.LayoutParams r12);

        void detachViewFromParent(int r10);

        View getChildAt(int r10);

        int getChildCount();

        RecyclerView.t getChildViewHolder(View r10);

        int indexOfChild(View r10);

        void onEnteredHiddenState(View r10);

        void onLeftHiddenState(View r10);

        void removeAllViews();

        void removeViewAt(int r10);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f15393b;

        public a() {
            this.f15392a = 0;
        }

        public void a(int r10) {
            if (r10 < 64) goto L7;
            a r11 = this.f15393b;
            if (r11 == null) goto L9;
            r11.a(r10 - 64);
            return;
        L9:
            return;
        L7:
            this.f15392a &= ~(1 << r10);
        }

        public int b(int r10) {
            a r11 = this.f15393b;
            if (r11 != null) goto L9;
            if (r10 >= 64) goto L6;
            long r12 = this.f15392a;
            return Long.bitCount(((1 << r10) - 1) & r12);
        L6:
            return Long.bitCount(this.f15392a);
        L9:
            if (r10 >= 64) goto L13;
            long r13 = this.f15392a;
            return Long.bitCount(((1 << r10) - 1) & r13);
        L13:
            return r11.b(r10 - 64) + Long.bitCount(this.f15392a);
        }

        public final void c() {
            if (this.f15393b != null) goto L6;
            this.f15393b = new a();
            return;
        }

        public boolean d(int r10) {
            if (r10 < 64) goto L6;
            c();
            return this.f15393b.d(r10 - 64);
        L6:
            long r11 = this.f15392a;
            if (((1 << r10) & r11) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        public void e(int r10, boolean r11) {
            if (r10 < 64) goto L5;
            c();
            this.f15393b.e(r10 - 64, r11);
            return;
        L5:
            long r12 = this.f15392a;
            if ((Long.MIN_VALUE & r12) == 0) goto L8;
            boolean r13 = true;
        L9:
            long r14 = (1 << r10) - 1;
            this.f15392a = ((r12 & (~r14)) << 1) | (r12 & r14);
            if (r11 == false) goto L12;
            h(r10);
        L13:
            if (r13 == false) goto L15;
        L16:
            c();
            this.f15393b.e(0, r13);
            return;
        L15:
            if (this.f15393b != null) goto L16;
            return;
        L12:
            a(r10);
            goto L13
        L8:
            r13 = false;
            goto L9
        }

        public boolean f(int r11) {
            if (r11 < 64) goto L6;
            c();
            return this.f15393b.f(r11 - 64);
        L6:
            long r10 = 1 << r11;
            long r12 = this.f15392a;
            if ((r12 & r10) == 0) goto L9;
            boolean r13 = true;
        L10:
            long r14 = r12 & (~r10);
            this.f15392a = r14;
            long r15 = r10 - 1;
            this.f15392a = (r14 & r15) | Long.rotateRight((~r15) & r14, 1);
            a r16 = this.f15393b;
            if (r16 != null) goto L13;
        L16:
            return r13;
        L13:
            if (r16.d(0) == false) goto L15;
            h(63);
        L15:
            this.f15393b.f(0);
            goto L16
        L9:
            r13 = false;
            goto L10
        }

        public void g() {
            this.f15392a = 0;
            a r10 = this.f15393b;
            if (r10 == null) goto L6;
            r10.g();
            return;
        }

        public void h(int r10) {
            if (r10 < 64) goto L5;
            c();
            this.f15393b.h(r10 - 64);
            return;
        L5:
            this.f15392a |= 1 << r10;
        }

        public String toString() {
            if (this.f15393b != null) goto L6;
            return Long.toBinaryString(this.f15392a);
        L6:
            return this.f15393b.toString() + "xx" + Long.toBinaryString(this.f15392a);
        }
    }

    public ChildHelper(Callback r10) {
        this.f15389a = r10;
        this.f15390b = new a();
        this.f15391c = new ArrayList();
    }

    public void a(View r10, int r11, boolean r12) {
        if (r11 >= 0) goto L4;
        int r13 = this.f15389a.getChildCount();
    L5:
        this.f15390b.e(r13, r12);
        if (r12 == false) goto L8;
        l(r10);
    L8:
        this.f15389a.addView(r10, r13);
        return;
    L4:
        r13 = h(r11);
        goto L5
    }

    public void b(View r10, boolean r11) {
        a(r10, -1, r11);
    }

    public void c(View r10, int r11, ViewGroup.LayoutParams r12, boolean r13) {
        if (r11 >= 0) goto L4;
        int r14 = this.f15389a.getChildCount();
    L5:
        this.f15390b.e(r14, r13);
        if (r13 == false) goto L8;
        l(r10);
    L8:
        this.f15389a.attachViewToParent(r10, r14, r12);
        return;
    L4:
        r14 = h(r11);
        goto L5
    }

    public void d(int r10) {
        int r11 = h(r10);
        this.f15390b.f(r11);
        this.f15389a.detachViewFromParent(r11);
    }

    public View e(int r10) {
        int r11 = this.f15391c.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        View r13 = (View) this.f15391c.get(r12);
        RecyclerView.t r14 = this.f15389a.getChildViewHolder(r13);
        if (r14.o() != r10) goto L11;
        if (r14.v() == true) goto L11;
        if (r14.x() == true) goto L11;
        return r13;
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return null;
    }

    public View f(int r10) {
        int r11 = h(r10);
        return this.f15389a.getChildAt(r11);
    }

    public int g() {
        return this.f15389a.getChildCount() - this.f15391c.size();
    }

    public final int h(int r10) {
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        int r11 = this.f15389a.getChildCount();
        int r12 = r10;
    L6:
        if (r12 >= r11) goto L14;
        int r13 = r10 - (r12 - this.f15390b.b(r12));
        if (r13 == 0) goto L10;
        r12 = r12 + r13;
    L10:
        if (this.f15390b.d(r12) == false) goto L12;
        r12 = r12 + 1;
        goto L10
    L12:
        return r12;
    L14:
        return -1;
    }

    public View i(int r10) {
        return this.f15389a.getChildAt(r10);
    }

    public int j() {
        return this.f15389a.getChildCount();
    }

    public void k(View r10) {
        int r11 = this.f15389a.indexOfChild(r10);
        if (r11 < 0) goto L7;
        this.f15390b.h(r11);
        l(r10);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r10);
    }

    public final void l(View r10) {
        this.f15391c.add(r10);
        this.f15389a.onEnteredHiddenState(r10);
    }

    public int m(View r10) {
        int r11 = this.f15389a.indexOfChild(r10);
        if (r11 != (-1)) goto L6;
        return -1;
    L6:
        if (this.f15390b.d(r11) == false) goto L9;
        return -1;
    L9:
        return r11 - this.f15390b.b(r11);
    }

    public boolean n(View r10) {
        return this.f15391c.contains(r10);
    }

    public void o() {
        this.f15390b.g();
        int r10 = this.f15391c.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        this.f15389a.onLeftHiddenState((View) this.f15391c.get(r10));
        this.f15391c.remove(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        this.f15389a.removeAllViews();
    }

    public void p(View r10) {
        int r11 = this.f15389a.indexOfChild(r10);
        if (r11 >= 0) goto L6;
        return;
    L6:
        if (this.f15390b.f(r11) == false) goto L8;
        t(r10);
    L8:
        this.f15389a.removeViewAt(r11);
    }

    public void q(int r10) {
        int r11 = h(r10);
        View r12 = this.f15389a.getChildAt(r11);
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.f15390b.f(r11) == false) goto L8;
        t(r12);
    L8:
        this.f15389a.removeViewAt(r11);
    }

    public boolean r(View r10) {
        int r11 = this.f15389a.indexOfChild(r10);
        if (r11 != (-1)) goto L7;
        t(r10);
        return true;
    L7:
        if (this.f15390b.d(r11) == false) goto L10;
        this.f15390b.f(r11);
        t(r10);
        this.f15389a.removeViewAt(r11);
        return true;
    L10:
        return false;
    }

    public void s(View r10) {
        int r11 = this.f15389a.indexOfChild(r10);
        if (r11 < 0) goto L11;
        if (this.f15390b.d(r11) == false) goto L9;
        this.f15390b.a(r11);
        t(r10);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r10);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r10);
    }

    public final boolean t(View r10) {
        if (this.f15391c.remove(r10) == false) goto L6;
        this.f15389a.onLeftHiddenState(r10);
        return true;
    L6:
        return false;
    }

    public String toString() {
        return this.f15390b.toString() + ", hidden list:" + this.f15391c.size();
    }
}
