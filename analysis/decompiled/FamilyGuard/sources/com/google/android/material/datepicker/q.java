package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
class q extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    static final int f12774g = w.i().getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    private static final int f12775h = (w.i().getMaximum(5) + w.i().getMaximum(7)) - 1;

    /* renamed from: a, reason: collision with root package name */
    final p f12776a;

    /* renamed from: b, reason: collision with root package name */
    final d<?> f12777b;

    /* renamed from: c, reason: collision with root package name */
    private Collection<Long> f12778c;

    /* renamed from: d, reason: collision with root package name */
    c f12779d;

    /* renamed from: e, reason: collision with root package name */
    final a f12780e;

    /* renamed from: f, reason: collision with root package name */
    final g f12781f;

    q(p pVar, d<?> dVar, a aVar, g gVar) {
        this.f12776a = pVar;
        this.f12777b = dVar;
        this.f12780e = aVar;
        this.f12781f = gVar;
        this.f12778c = dVar.u();
    }

    private String c(Context context, long j5) {
        return e.a(context, j5, l(j5), k(j5), g(j5));
    }

    private void f(Context context) {
        if (this.f12779d == null) {
            this.f12779d = new c(context);
        }
    }

    private boolean j(long j5) {
        Iterator<Long> it = this.f12777b.u().iterator();
        while (it.hasNext()) {
            if (w.a(j5) == w.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j5) {
        return w.g().getTimeInMillis() == j5;
    }

    private void o(TextView textView, long j5, int i5) {
        boolean zJ;
        b bVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j5);
        textView.setContentDescription(strC);
        boolean zR = this.f12780e.F().r(j5);
        if (zR) {
            textView.setEnabled(true);
            zJ = j(j5);
            textView.setSelected(zJ);
            bVar = zJ ? this.f12779d.f12668b : l(j5) ? this.f12779d.f12669c : this.f12779d.f12667a;
        } else {
            zJ = false;
            textView.setEnabled(false);
            bVar = this.f12779d.f12673g;
        }
        boolean z5 = zJ;
        g gVar = this.f12781f;
        if (gVar == null || i5 == -1) {
            bVar.d(textView);
            return;
        }
        p pVar = this.f12776a;
        int i6 = pVar.f12769c;
        int i7 = pVar.f12768b;
        bVar.e(textView, gVar.a(context, i6, i7, i5, zR, z5), this.f12781f.F(context, i6, i7, i5, zR, z5));
        textView.setCompoundDrawables(this.f12781f.f(context, i6, i7, i5, zR, z5), this.f12781f.B(context, i6, i7, i5, zR, z5), this.f12781f.A(context, i6, i7, i5, zR, z5), this.f12781f.c(context, i6, i7, i5, zR, z5));
        textView.setContentDescription(this.f12781f.D(context, i6, i7, i5, zR, z5, strC));
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j5) {
        if (p.H(j5).equals(this.f12776a)) {
            int iL = this.f12776a.L(j5);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(iL) - materialCalendarGridView.getFirstVisiblePosition()), j5, iL);
        }
    }

    int a(int i5) {
        return b() + (i5 - 1);
    }

    int b() {
        return this.f12776a.J(this.f12780e.H());
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i5) {
        if (i5 < b() || i5 > m()) {
            return null;
        }
        return Long.valueOf(this.f12776a.K(n(i5)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = a1.C0415h.f6877k
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.p r8 = r5.f12776a
            int r2 = r8.f12771e
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.o(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.q.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    boolean g(long j5) {
        Iterator<D.d<Long, Long>> it = this.f12777b.e().iterator();
        while (it.hasNext()) {
            Long l5 = it.next().f1000b;
            if (l5 != null && l5.longValue() == j5) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f12775h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i5) {
        return i5 / this.f12776a.f12770d;
    }

    boolean h(int i5) {
        return i5 % this.f12776a.f12770d == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean i(int i5) {
        return (i5 + 1) % this.f12776a.f12770d == 0;
    }

    boolean k(long j5) {
        Iterator<D.d<Long, Long>> it = this.f12777b.e().iterator();
        while (it.hasNext()) {
            Long l5 = it.next().f999a;
            if (l5 != null && l5.longValue() == j5) {
                return true;
            }
        }
        return false;
    }

    int m() {
        return (b() + this.f12776a.f12771e) - 1;
    }

    int n(int i5) {
        return (i5 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f12778c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, it.next().longValue());
        }
        d<?> dVar = this.f12777b;
        if (dVar != null) {
            Iterator<Long> it2 = dVar.u().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f12778c = this.f12777b.u();
        }
    }

    boolean r(int i5) {
        return i5 >= b() && i5 <= m();
    }
}
