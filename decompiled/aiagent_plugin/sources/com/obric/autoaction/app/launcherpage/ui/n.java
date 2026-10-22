package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.orecyclerview.widget.ODragItemTouchHelper;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SortableTaskListController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n<T extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView f24455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<T> f24456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<T, Boolean> f24457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<T, String> f24458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.m<List<String>, l, x> f24459e;
    private final String f;
    private final long g;
    private boolean h;
    private d.h.a.a<x> i;
    private boolean j;
    private Long k;
    private final int[] l;
    private final ODragItemTouchHelper m;

    /* JADX INFO: compiled from: SortableTaskListController.kt */
    public static final class a implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<T> f24460a;

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        a(n<T> r1) {
            this.f24460a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r3, MotionEvent r4) {
            d.h.b.o.e(r3, "rv");
            d.h.b.o.e(r4, "e");
            n.a(this.f24460a)[0] = (int) r4.getRawX();
            n.a(this.f24460a)[1] = (int) r4.getRawY();
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r3, MotionEvent r4) {
            d.h.b.o.e(r3, "rv");
            d.h.b.o.e(r4, "e");
            n.a(this.f24460a)[0] = (int) r4.getRawX();
            n.a(this.f24460a)[1] = (int) r4.getRawY();
        }
    }

    /* JADX INFO: compiled from: SortableTaskListController.kt */
    public static final class b implements ODragItemTouchHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<T> f24461a;

        b(n<T> r1) {
            this.f24461a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.ODragItemTouchHelper.a
        public boolean a(RecyclerView.v r3, int r4) {
            d.h.b.o.e(r3, "viewHolder");
            n<T> r5 = this.f24461a;
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
            b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
            Object r6 = d.n.f(n.c(r5).b(r4));     // Catch: Throwable -> L5
        L8:
            if (d.n.b(r6) == false) goto L10;
            r6 = null;
        L10:
            h r7 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L15;
            return false;
        L15:
            return ((Boolean) ZeusTransformUtils.preCheckCast(n.b(this.f24461a).invoke(r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L5:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
            goto L8
        }

        @Override // com.obric.oui.orecyclerview.widget.ODragItemTouchHelper.a
        public void a(RecyclerView.v r7) {
            d.h.b.o.e(r7, "viewHolder");
            n.a(this.f24461a, false);
            n.b(this.f24461a, false);
            a();
            int r0 = r7.j();
            n.c(this.f24461a).c(r0);
            Loog.INSTANCE.i(n.d(this.f24461a), "drag start position=" + r0 + ", taskId=" + o.a(n.c(this.f24461a), r0, n.e(this.f24461a)));
            n<T> r1 = this.f24461a;
            d.h.a.a<x> r2 = null;
            if (ZeusTransformUtils.instanceOf(r7, com.obric.autoaction.app.launcherpage.ui.b.class) == false) goto L5;
            com.obric.autoaction.app.launcherpage.ui.b r3 = (com.obric.autoaction.app.launcherpage.ui.b) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.ui.b.class, "com.obric.aiagent.plugin");
        L6:
            if (r3 == null) goto L8;
            r2 = r3.a(n.a(this.f24461a));
        L8:
            n.a(r1, r2);
            c(r7, ZeusTransformUtils.mapRes(R.style.OUIShadow_3_1, "style", "OUIShadow_3_1"));
            a(r7, true);
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.obric.oui.orecyclerview.widget.ODragItemTouchHelper.a
        public boolean a(RecyclerView.v r5, int r6, int r7) {
            d.h.b.o.e(r5, "viewHolder");
            boolean r1 = false;
            if (a(r7) == true) goto L5;
            return false;
        L5:
            boolean r0 = n.c(this.f24461a).a(r6, r7);
            n<T> r2 = this.f24461a;
            if (n.f(r2) == true) goto L8;
            if (r0 == true) goto L8;
        L9:
            n.a(r2, r1);
            if (r0 == false) goto L12;
            com.obric.autogui.util.ui.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 5);
            Loog.INSTANCE.i(n.d(this.f24461a), "drag move from=" + r6 + ", to=" + r7 + ", movedTaskId=" + o.a(n.c(this.f24461a), r7, n.e(this.f24461a)));
        L12:
            return r0;
        L8:
            r1 = true;
            goto L9
        }

        @Override // com.obric.oui.orecyclerview.widget.ODragItemTouchHelper.a
        public void b(RecyclerView.v r2, int r3) {
            d.h.b.o.e(r2, "viewHolder");
            if (n.g(this.f24461a) == true) goto L10;
            if (r3 <= 0) goto L11;
            n.b(this.f24461a, true);
            d.h.a.a r4 = n.h(this.f24461a);
            if (r4 == null) goto L8;
            r4.invoke();
        L8:
            n.a(this.f24461a, null);
            return;
        L11:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ODragItemTouchHelper.a
        public void b(RecyclerView.v r10) {
            d.h.b.o.e(r10, "viewHolder");
            b();
            a(r10, false);
            c(r10, ZeusTransformUtils.mapRes(R.style.OUIShadow_None, "style", "OUIShadow_None"));
            boolean r11 = n.g(this.f24461a);
            n.b(this.f24461a, false);
            if (r11 == false) goto L8;
            d.h.a.a r12 = n.h(this.f24461a);
            if (r12 == null) goto L7;
            r12.invoke();
        L7:
            n.a(this.f24461a, null);
        L8:
            d.m<List<T>, l> r13 = n.c(this.f24461a).d();
            List r1 = (List) ZeusTransformUtils.preCheckCast(r13.c(), List.class, "com.obric.aiagent.plugin");
            l r14 = (l) ZeusTransformUtils.preCheckCast(r13.d(), l.class, "com.obric.aiagent.plugin");
            if (n.f(this.f24461a) == false) goto L23;
            if (r14 == null) goto L23;
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1.subList(r14.a(), r14.b() + 1), Iterable.class, "com.obric.aiagent.plugin");
            d.h.a.b r3 = n.e(this.f24461a);
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r5 = r2.iterator();
        L14:
            if (r5.hasNext() == false) goto L18;
            Object r6 = r3.invoke(r5.next());
            if (r6 == null) goto L14;
            r4.add(r6);
            goto L14
        L18:
            List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.i(n.d(this.f24461a), "drag end range=" + r14.a() + '-' + r14.b() + ", crossedCount=" + r7.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.l(r7), String.class, "com.obric.aiagent.plugin")) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.n(r7), String.class, "com.obric.aiagent.plugin")));
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L21;
            n.c(this.f24461a).a(true);
            n.i(this.f24461a).invoke(r7, r14);
            return;
        L21:
            n.c(this.f24461a).a(false);
            return;
        L23:
            Loog.INSTANCE.i(n.d(this.f24461a), "drag end no order change, orderChanged=" + n.f(this.f24461a) + ", range=" + r14);
            n.c(this.f24461a).a(false);
        }

        private final void a() {
            RecyclerView.e r0 = n.j(this.f24461a).getItemAnimator();
            if (r0 == null) goto L9;
            n<T> r3 = this.f24461a;
            if (n.k(r3) != null) goto L7;
            n.a(r3, Long.valueOf(r0.f()));
        L7:
            r0.a(n.l(r3));
            return;
        }

        private final void b() {
            Long r0 = n.k(this.f24461a);
            if (r0 == null) goto L8;
            long r1 = r0.longValue();
            n.a(this.f24461a, null);
            RecyclerView.e r4 = n.j(this.f24461a).getItemAnimator();
            if (r4 == null) goto L9;
            r4.a(r1);
            return;
        L9:
            return;
        }

        private final void a(RecyclerView.v r1, boolean r2) {
            r1.f35660b.setSelected(r2);
            r1.f35660b.invalidate();
        }

        private final void c(RecyclerView.v r2, int r3) {
            View r1 = r2.f35660b;
            if (ZeusTransformUtils.instanceOf(r1, OUICardConstraintLayout.class) == false) goto L5;
            OUICardConstraintLayout r4 = (OUICardConstraintLayout) ZeusTransformUtils.preCheckCast(r1, OUICardConstraintLayout.class, "com.obric.aiagent.plugin");
        L6:
            if (r4 == null) goto L9;
            r4.setShadowStyle(r3);
            r4.invalidate();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        private final boolean a(int r5) {
            if (r5 != (-1)) goto L5;
            return false;
        L5:
            n<T> r2 = this.f24461a;
            d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L8
            b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            Object r6 = d.n.f(n.c(r2).b(r5));     // Catch: Throwable -> L8
        L11:
            if (d.n.b(r6) == false) goto L13;
            r6 = null;
        L13:
            h r7 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L17;
            return false;
        L17:
            return ((Boolean) ZeusTransformUtils.preCheckCast(n.b(this.f24461a).invoke(r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L8:
            th = move-exception;
            d.n.a r8 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
            goto L11
        }
    }

    public n(RecyclerView r3, m<T> r4, d.h.a.b<? super T, Boolean> r5, d.h.a.b<? super T, String> r6, d.h.a.m<? super List<String>, ? super l, x> r7) {
        d.h.a.b<T, Boolean> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, String> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<List<String>, l, x> r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "recyclerView");
        d.h.b.o.e(r4, "adapter");
        d.h.b.o.e(r8, "canDragItem");
        d.h.b.o.e(r9, "taskIdProvider");
        d.h.b.o.e(r10, "onOrderChanged");
        this.f24455a = r3;
        this.f24456b = r4;
        this.f24457c = r8;
        this.f24458d = r9;
        this.f24459e = r10;
        this.f = "SortableTaskListController";
        this.g = 250;
        this.l = new int[2];
        this.m = new ODragItemTouchHelper((RecyclerView.a) ZeusTransformUtils.preCheckCast(r4, RecyclerView.a.class, "com.obric.aiagent.plugin"), (ODragItemTouchHelper.a) ZeusTransformUtils.preCheckCast(new b(this), ODragItemTouchHelper.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(n r2, d.h.a.a r3) {
        r2.i = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(n r0, Long r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(n r0, boolean r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ int[] a(n r0) {
        return r0.l;
    }

    public static final /* synthetic */ d.h.a.b b(n r0) {
        return r0.f24457c;
    }

    public static final /* synthetic */ void b(n r0, boolean r1) {
        r0.j = r1;
    }

    public static final /* synthetic */ m c(n r0) {
        return r0.f24456b;
    }

    public static final /* synthetic */ String d(n r0) {
        return r0.f;
    }

    public static final /* synthetic */ d.h.a.b e(n r0) {
        return r0.f24458d;
    }

    public static final /* synthetic */ boolean f(n r0) {
        return r0.h;
    }

    public static final /* synthetic */ boolean g(n r0) {
        return r0.j;
    }

    public static final /* synthetic */ d.h.a.a h(n r0) {
        return r0.i;
    }

    public static final /* synthetic */ d.h.a.m i(n r0) {
        return r0.f24459e;
    }

    public static final /* synthetic */ RecyclerView j(n r0) {
        return r0.f24455a;
    }

    public static final /* synthetic */ Long k(n r0) {
        return r0.k;
    }

    public static final /* synthetic */ long l(n r2) {
        return r2.g;
    }

    public final void a() {
        d r0 = (d) ZeusTransformUtils.preCheckCast(this.f24456b, d.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(new k(), c.class, "com.obric.aiagent.plugin");
        g r2 = r0.b();
        if (r2.a().containsKey(k.class) == true) goto L13;
        r2.a().put(k.class, r1);
        this.f24455a.setClipToPadding(false);
        this.f24455a.setClipChildren(false);
        ViewParent r3 = this.f24455a.getParent();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L7;
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L8:
        if (r4 == null) goto L10;
        r4.setClipChildren(false);
    L10:
        this.f24455a.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new a(this), RecyclerView.l.class, "com.obric.aiagent.plugin"));
        this.m.a(true);
        this.m.a(this.f24455a);
        return;
    L7:
        r4 = null;
        goto L8
    L13:
        throw new RuntimeException("already contains control type :" + k.class);
    }
}
