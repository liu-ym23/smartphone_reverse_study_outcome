package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import np0.c;

/* JADX INFO: loaded from: classes46.dex */
public final class RecyclerViewScrollReportHelper<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends T> f84299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f84300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends T> f84301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f84302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f84303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<T> f84304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f84305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f84306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f84307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a<T> f84308j;

    public interface a<T> {
        void a(T r100, int r101);

        boolean b(T r100, T r101);
    }

    public final void d(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        this.f84299a = new ArrayList(r100);
        this.f84305g.post(new c(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(RecyclerViewScrollReportHelper r100, List r101) {
        RecyclerView.LayoutManager r102 = r100.f84305g.getLayoutManager();
        if (r102 == null) goto L28;
        int r103 = ((LinearLayoutManager) r102).findFirstVisibleItemPosition();
        RecyclerView.LayoutManager r104 = r100.f84305g.getLayoutManager();
        if (r104 == null) goto L26;
        int r105 = ((LinearLayoutManager) r104).findLastVisibleItemPosition();
        if (r103 >= 0) goto L9;
        return;
    L9:
        if (r105 >= r101.size()) goto L34;
        if (r103 > r105) goto L23;
        int r106 = r103;
    L12:
        Iterator<T> r107 = r100.f84301c.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        T r108 = r107.next();
        if (r100.f84308j.b((T) ListProtector.get(r101, r106), r108) == false) goto L14;
    L19:
        if (r108 != null) goto L21;
        r100.c(ListProtector.get(r101, r106), r106);
    L21:
        if (r106 == r105) goto L23;
        r106 = r106 + 1;
        goto L12
    L18:
        r108 = null;
    L23:
        r100.f84301c = r101.subList(r103, r105 + 1);
        r100.f84302d = r103;
        r100.f84303e = r105;
        return;
    L34:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(RecyclerViewScrollReportHelper r100, int r101) {
        List<? extends T> r102 = r100.f84299a;
        if (r102 == null) goto L31;
        RecyclerView.LayoutManager r103 = r100.f84305g.getLayoutManager();
        if (r103 == null) goto L30;
        int r104 = ((LinearLayoutManager) r103).findFirstVisibleItemPosition();
        RecyclerView.LayoutManager r105 = r100.f84305g.getLayoutManager();
        if (r105 == null) goto L28;
        int r106 = ((LinearLayoutManager) r105).findLastVisibleItemPosition();
        if (r104 < 0) goto L34;
        ArrayList r107 = (ArrayList) r102;
        if (r106 >= r107.size()) goto L35;
        if (r101 <= 0) goto L20;
        int r108 = r100.f84303e;
        if (r108 < 0) goto L20;
        int r109 = r108 + 1;
        if (r109 > r106) goto L26;
    L17:
        r100.c(ListProtector.get(r102, r109), r109);
        if (r109 == r106) goto L26;
        r109 = r109 + 1;
    L26:
        r100.f84301c = r107.subList(r104, r106 + 1);
        r100.f84302d = r104;
        r100.f84303e = r106;
        return;
    L20:
        if (r101 >= 0) goto L26;
        if (r100.f84302d > r107.size()) goto L26;
        int r110 = r100.f84302d;
        int r111 = r104;
    L24:
        if (r111 >= r110) goto L26;
        r100.c(ListProtector.get(r102, r111), r111);
        r111 = r111 + 1;
        goto L24
    L35:
        return;
    L34:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void c(T r100, int r101) {
        boolean r102 = this.f84304f.contains(r100);
        if (this.f84307i != 2) goto L6;
        if (r102 == true) goto L7;
        this.f84308j.a(r100, r101);
    L7:
        if (r102 == true) goto L10;
        this.f84304f.add(r100);
        return;
    L10:
        return;
    L6:
        this.f84308j.a(r100, r101);
        goto L7
    }

    public RecyclerViewScrollReportHelper(RecyclerView r100, int r101, int r102, a<T> r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f84305g = r100;
        this.f84306h = r101;
        this.f84307i = r102;
        this.f84308j = r103;
        this.f84300b = true;
        this.f84301c = new ArrayList();
        this.f84302d = -1;
        this.f84303e = -1;
        this.f84304f = new LinkedHashSet();
        r100.addOnScrollListener(new AnonymousClass1(this));
    }
}
