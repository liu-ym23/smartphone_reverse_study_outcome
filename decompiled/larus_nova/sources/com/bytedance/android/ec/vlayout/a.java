package com.bytedance.android.ec.vlayout;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import un.f;
import vn.g;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f<Integer> f49094c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f<Integer> f49095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f49096b;

    public abstract void a(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103, int r104, b r105);

    public abstract void b(RecyclerView.Recycler r100, RecyclerView.State r101, b r102);

    public void c(RecyclerView.State r100, VirtualLayoutManager.c r101, b r102) {
    }

    public abstract void d(b r100);

    public abstract int e(int r100, boolean r101, boolean r102, b r103);

    public abstract void f(RecyclerView.Recycler r100, RecyclerView.State r101, VirtualLayoutManager.e r102, g r103, b r104);

    public View g() {
        return null;
    }

    public abstract int h();

    public abstract boolean i();

    public void k(int r100, b r101, boolean r102) {
    }

    public void l() {
    }

    public void m(int r100, b r101) {
    }

    public void n(int r100, b r101) {
    }

    public void o(int r100) {
    }

    public void p(VirtualLayoutManager.c r100) {
    }

    public void q(int r100, int r101, int r102) {
    }

    public abstract void r(int r100);

    static {
        Integer r100 = Integer.MIN_VALUE;
        if (r100 == null) goto L14;
        if (Integer.MAX_VALUE == null) goto L12;
        if (r100.compareTo(Integer.MAX_VALUE) > 0) goto L10;
        f49094c = new f(-1, -1);
        return;
    L10:
        throw new IllegalArgumentException("lower must be less than or equal to upper");
    L12:
        throw new IllegalArgumentException("upper must not be null");
    L14:
        throw new IllegalArgumentException("lower must not be null");
    }

    public a() {
        this.f49095a = f49094c;
        this.f49096b = new LinkedList();
    }

    public boolean j(int r100) {
        return !this.f49095a.a(Integer.valueOf(r100));
    }

    public final void s(int r100, int r101) {
        if (r101 < r100) goto L20;
        if (r100 != (-1)) goto L9;
        if (r101 != (-1)) goto L9;
        this.f49095a = f49094c;
        o(r100);
        return;
    L9:
        if (((r101 - r100) + 1) != h()) goto L18;
        if (r100 == ((Integer) this.f49095a.f550758b).intValue()) goto L13;
    L15:
        f<Integer> r102 = new f(Integer.valueOf(r100), Integer.valueOf(r101));
        this.f49095a = r102;
        Objects.toString(r102);
        new Throwable();
        o(r100);
        return;
    L13:
        if (r101 != ((Integer) this.f49095a.f550757a).intValue()) goto L15;
        return;
    L18:
        throw new MismatchChildCountException("ItemCount mismatch when range: " + this.f49095a.toString() + " childCount: " + h());
    L20:
        throw new IllegalArgumentException("end should be larger or equeal then start position");
    }
}
