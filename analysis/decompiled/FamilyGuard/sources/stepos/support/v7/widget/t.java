package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class t extends SimpleItemAnimator {

    /* renamed from: o, reason: collision with root package name */
    private static TimeInterpolator f22118o;

    /* renamed from: p, reason: collision with root package name */
    private static final Interpolator f22119p = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: q, reason: collision with root package name */
    private static final Interpolator f22120q = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: r, reason: collision with root package name */
    private static final Interpolator f22121r = new PathInterpolator(0.1f, 0.0f, 0.2f, 1.0f);

    /* renamed from: s, reason: collision with root package name */
    private static float f22122s = 0.94f;

    /* renamed from: l, reason: collision with root package name */
    private final RecyclerView f22134l;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<l> f22123a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<i> f22124b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<k> f22125c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<j> f22126d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<ArrayList<i>> f22127e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<ArrayList<k>> f22128f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<ArrayList<j>> f22129g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f22130h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f22131i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f22132j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f22133k = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private int f22135m = 200;

    /* renamed from: n, reason: collision with root package name */
    private float f22136n = f22122s;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f22137a;

        a(ArrayList arrayList) {
            this.f22137a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f22137a;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                t.this.n((k) obj);
            }
            this.f22137a.clear();
            t.this.f22128f.remove(this.f22137a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f22139a;

        b(ArrayList arrayList) {
            this.f22139a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f22139a;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                t.this.m((j) obj);
            }
            this.f22139a.clear();
            t.this.f22129g.remove(this.f22139a);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f22141a;

        c(ArrayList arrayList) {
            this.f22141a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f22141a;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                t.this.l((i) obj);
            }
            this.f22141a.clear();
            t.this.f22127e.remove(this.f22141a);
        }
    }

    class d extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f22143a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ S f22144b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l lVar, S s5) {
            super(null);
            this.f22143a = lVar;
            this.f22144b = s5;
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void d(View view) {
            this.f22144b.j(null);
            view.setTag(-1912602624, null);
            H.n0(view, 1.0f);
            H.A0(view, 1.0f);
            H.z0(view, 1.0f);
            H.F0(view, 0.0f);
            t.this.dispatchRemoveFinished(this.f22143a.f22177a);
            t.this.f22132j.remove(this.f22143a.f22177a);
            t.this.dispatchFinishedWhenDone();
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void e(View view) {
            t.this.dispatchRemoveStarting(this.f22143a.f22177a);
        }
    }

    class e extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f22146a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ S f22147b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(i iVar, S s5) {
            super(null);
            this.f22146a = iVar;
            this.f22147b = s5;
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void c(View view) {
            H.n0(view, 1.0f);
            H.A0(view, 1.0f);
            H.z0(view, 1.0f);
            H.F0(view, 0.0f);
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void d(View view) {
            this.f22147b.j(null);
            view.setTag(-1912602624, null);
            t.this.dispatchAddFinished(this.f22146a.f22161a);
            t.this.f22130h.remove(this.f22146a.f22161a);
            t.this.dispatchFinishedWhenDone();
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void e(View view) {
            t.this.dispatchAddStarting(this.f22146a.f22161a);
        }
    }

    class f extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f22149a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22150b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f22151c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ S f22152d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(k kVar, int i5, int i6, S s5) {
            super(null);
            this.f22149a = kVar;
            this.f22150b = i5;
            this.f22151c = i6;
            this.f22152d = s5;
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void c(View view) {
            if (this.f22150b != 0) {
                H.E0(view, 0.0f);
            }
            if (this.f22151c != 0) {
                H.F0(view, 0.0f);
            }
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void d(View view) {
            this.f22152d.j(null);
            view.setTag(-1912602624, null);
            t.this.dispatchMoveFinished(this.f22149a.f22170a);
            t.this.f22131i.remove(this.f22149a.f22170a);
            t.this.dispatchFinishedWhenDone();
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void e(View view) {
            t.this.dispatchMoveStarting(this.f22149a.f22170a);
        }
    }

    class g extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f22154a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ S f22155b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(j jVar, S s5) {
            super(null);
            this.f22154a = jVar;
            this.f22155b = s5;
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void d(View view) {
            this.f22155b.j(null);
            H.n0(view, 1.0f);
            H.E0(view, 0.0f);
            H.F0(view, 0.0f);
            t.this.dispatchChangeFinished(this.f22154a.f22164a, true);
            t.this.f22133k.remove(this.f22154a.f22164a);
            t.this.dispatchFinishedWhenDone();
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void e(View view) {
            t.this.dispatchChangeStarting(this.f22154a.f22164a, true);
        }
    }

    class h extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f22157a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ S f22158b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f22159c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j jVar, S s5, View view) {
            super(null);
            this.f22157a = jVar;
            this.f22158b = s5;
            this.f22159c = view;
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void d(View view) {
            this.f22158b.j(null);
            H.n0(this.f22159c, 1.0f);
            H.E0(this.f22159c, 0.0f);
            H.F0(this.f22159c, 0.0f);
            t.this.dispatchChangeFinished(this.f22157a.f22165b, false);
            t.this.f22133k.remove(this.f22157a.f22165b);
            t.this.dispatchFinishedWhenDone();
        }

        @Override // stepos.support.v7.widget.t.m, androidx.core.view.T
        public void e(View view) {
            t.this.dispatchChangeStarting(this.f22157a.f22165b, false);
        }
    }

    private static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f22161a;

        /* renamed from: b, reason: collision with root package name */
        public int f22162b;

        /* renamed from: c, reason: collision with root package name */
        public int f22163c;

        /* synthetic */ i(RecyclerView.ViewHolder viewHolder, int i5, a aVar) {
            this(viewHolder, i5);
        }

        private i(RecyclerView.ViewHolder viewHolder, int i5) {
            this.f22161a = viewHolder;
            this.f22162b = i5;
        }
    }

    private static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f22164a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f22165b;

        /* renamed from: c, reason: collision with root package name */
        public int f22166c;

        /* renamed from: d, reason: collision with root package name */
        public int f22167d;

        /* renamed from: e, reason: collision with root package name */
        public int f22168e;

        /* renamed from: f, reason: collision with root package name */
        public int f22169f;

        /* synthetic */ j(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i5, int i6, int i7, int i8, a aVar) {
            this(viewHolder, viewHolder2, i5, i6, i7, i8);
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f22164a + ", newHolder=" + this.f22165b + ", fromX=" + this.f22166c + ", fromY=" + this.f22167d + ", toX=" + this.f22168e + ", toY=" + this.f22169f + '}';
        }

        private j(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f22164a = viewHolder;
            this.f22165b = viewHolder2;
        }

        private j(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i5, int i6, int i7, int i8) {
            this(viewHolder, viewHolder2);
            this.f22166c = i5;
            this.f22167d = i6;
            this.f22168e = i7;
            this.f22169f = i8;
        }
    }

    private static class k {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f22170a;

        /* renamed from: b, reason: collision with root package name */
        public int f22171b;

        /* renamed from: c, reason: collision with root package name */
        public int f22172c;

        /* renamed from: d, reason: collision with root package name */
        public int f22173d;

        /* renamed from: e, reason: collision with root package name */
        public int f22174e;

        /* renamed from: f, reason: collision with root package name */
        public int f22175f;

        /* renamed from: g, reason: collision with root package name */
        public int f22176g;

        /* synthetic */ k(RecyclerView.ViewHolder viewHolder, int i5, int i6, int i7, int i8, int i9, int i10, a aVar) {
            this(viewHolder, i5, i6, i7, i8, i9, i10);
        }

        private k(RecyclerView.ViewHolder viewHolder, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f22170a = viewHolder;
            this.f22171b = i5;
            this.f22172c = i6;
            this.f22173d = i7;
            this.f22174e = i8;
            this.f22175f = i9;
            this.f22176g = i10;
        }
    }

    private static class l {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f22177a;

        /* renamed from: b, reason: collision with root package name */
        public int f22178b;

        /* synthetic */ l(RecyclerView.ViewHolder viewHolder, int i5, a aVar) {
            this(viewHolder, i5);
        }

        private l(RecyclerView.ViewHolder viewHolder, int i5) {
            this.f22177a = viewHolder;
            this.f22178b = i5;
        }
    }

    private static class m implements T {
        private m() {
        }

        @Override // androidx.core.view.T
        public void c(View view) {
        }

        @Override // androidx.core.view.T
        public void d(View view) {
        }

        @Override // androidx.core.view.T
        public void e(View view) {
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    public t(RecyclerView recyclerView) {
        this.f22134l = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    private void endChangeAnimation(List<j> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            j jVar = list.get(size);
            if (r(jVar, viewHolder) && jVar.f22164a == null && jVar.f22165b == null) {
                list.remove(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(i iVar) {
        View view = iVar.f22161a.itemView;
        S sD = H.d(view);
        e eVar = new e(iVar, sD);
        u(view, eVar);
        this.f22130h.add(iVar.f22161a);
        sD.b(1.0f).g(1.0f).f(1.0f).p(0.0f).h(this.f22135m).i(f22119p).j(eVar).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(j jVar) {
        RecyclerView.ViewHolder viewHolder = jVar.f22164a;
        View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = jVar.f22165b;
        View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            S sH = H.d(view).h(getChangeDuration());
            this.f22133k.add(jVar.f22164a);
            sH.o(jVar.f22168e - jVar.f22166c);
            sH.p(jVar.f22169f - jVar.f22167d);
            sH.b(0.0f).j(new g(jVar, sH)).n();
        }
        if (view2 != null) {
            S sD = H.d(view2);
            this.f22133k.add(jVar.f22165b);
            sD.o(0.0f).p(0.0f).h(getChangeDuration()).b(1.0f).j(new h(jVar, sD, view2)).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(k kVar) {
        View view = kVar.f22170a.itemView;
        int i5 = kVar.f22174e - kVar.f22172c;
        int i6 = kVar.f22175f - kVar.f22173d;
        if (i5 != 0) {
            H.d(view).o(0.0f);
        }
        if (i6 != 0) {
            H.d(view).p(0.0f);
        }
        S sD = H.d(view);
        f fVar = new f(kVar, i5, i6, sD);
        u(view, fVar);
        this.f22131i.add(kVar.f22170a);
        sD.l(50L).h(350L).i(f22121r).j(fVar).n();
    }

    private void o(l lVar) {
        View view = lVar.f22177a.itemView;
        S sD = H.d(view);
        d dVar = new d(lVar, sD);
        u(view, dVar);
        this.f22132j.add(lVar.f22177a);
        sD.h(this.f22135m).b(0.0f).g(this.f22136n).f(this.f22136n).p(lVar.f22178b).i(f22120q).j(dVar).n();
    }

    private int p(int i5) {
        for (int i6 = 0; i6 < this.f22125c.size(); i6++) {
            if (this.f22125c.get(i6).f22171b == i5) {
                return this.f22125c.get(i6).f22176g;
            }
        }
        return -1;
    }

    private void q(j jVar) {
        RecyclerView.ViewHolder viewHolder = jVar.f22164a;
        if (viewHolder != null) {
            r(jVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = jVar.f22165b;
        if (viewHolder2 != null) {
            r(jVar, viewHolder2);
        }
    }

    private boolean r(j jVar, RecyclerView.ViewHolder viewHolder) {
        boolean z5 = false;
        if (jVar.f22165b == viewHolder) {
            jVar.f22165b = null;
        } else {
            if (jVar.f22164a != viewHolder) {
                return false;
            }
            jVar.f22164a = null;
            z5 = true;
        }
        H.n0(viewHolder.itemView, 1.0f);
        H.E0(viewHolder.itemView, 0.0f);
        H.F0(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z5);
        return true;
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (f22118o == null) {
            f22118o = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f22118o);
        endAnimation(viewHolder);
    }

    private int s(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return 0;
        }
        int iP = p(viewHolder.getLayoutPosition());
        return iP == -1 ? viewHolder.itemView.getBottom() : iP;
    }

    private void t(ArrayList<i> arrayList) {
        int i5;
        int top;
        View view;
        v(arrayList);
        int i6 = 0;
        int i7 = 0;
        int iS = 0;
        while (i6 < arrayList.size()) {
            if (i6 == 0) {
                int i8 = arrayList.get(0).f22162b;
                if (arrayList.get(0).f22162b == 0) {
                    iS = 0;
                } else {
                    RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.f22134l.findViewHolderForLayoutPosition(i8 - 1);
                    if (viewHolderFindViewHolderForLayoutPosition != null && (view = viewHolderFindViewHolderForLayoutPosition.itemView) != null) {
                        iS = view.getBottom();
                    }
                }
                arrayList.get(0).f22163c = 0;
                i5 = i8;
                top = 0;
            } else {
                i5 = arrayList.get(i6).f22162b;
                if (i5 - i7 == 1) {
                    top = arrayList.get(i6).f22161a.itemView.getTop() - iS;
                    arrayList.get(i6).f22163c = top;
                } else {
                    iS = s(this.f22134l.findViewHolderForLayoutPosition(i5 - 1));
                    top = arrayList.get(i6).f22161a.itemView.getTop() - iS;
                    arrayList.get(i6).f22163c = top;
                }
            }
            if (top != 0) {
                H.F0(arrayList.get(i6).f22161a.itemView, -top);
            }
            i6++;
            i7 = i5;
        }
    }

    private void u(View view, m mVar) {
        if (view.getTag(-1912602624) != null) {
            m mVar2 = (m) view.getTag(-1912602624);
            mVar2.c(view);
            mVar2.d(view);
        }
        view.setTag(-1912602624, mVar);
    }

    private void v(ArrayList<i> arrayList) {
        int i5 = 0;
        while (true) {
            if (i5 >= arrayList.size() - 1) {
                return;
            }
            for (int i6 = 1; i6 < arrayList.size() - i5; i6++) {
                int i7 = i6 - 1;
                if (arrayList.get(i7).f22162b - arrayList.get(i6).f22162b > 0) {
                    i iVar = arrayList.get(i7);
                    arrayList.set(i7, arrayList.get(i6));
                    arrayList.set(i6, iVar);
                }
            }
            i5++;
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        H.n0(viewHolder.itemView, 0.0f);
        H.A0(viewHolder.itemView, this.f22136n);
        H.z0(viewHolder.itemView, this.f22136n);
        this.f22124b.add(new i(viewHolder, viewHolder.getLayoutPosition(), null));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i5, int i6, int i7, int i8) {
        if (viewHolder == viewHolder2) {
            dispatchChangeFinished(viewHolder, true);
            return false;
        }
        float fG = H.G(viewHolder.itemView);
        float fH = H.H(viewHolder.itemView);
        float fO = H.o(viewHolder.itemView);
        resetAnimation(viewHolder);
        int i9 = (int) ((i7 - i5) - fG);
        int i10 = (int) ((i8 - i6) - fH);
        H.E0(viewHolder.itemView, fG);
        H.F0(viewHolder.itemView, fH);
        H.n0(viewHolder.itemView, fO);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            H.E0(viewHolder2.itemView, -i9);
            H.F0(viewHolder2.itemView, -i10);
            H.n0(viewHolder2.itemView, 0.0f);
        }
        this.f22126d.add(new j(viewHolder, viewHolder2, i5, i6, i7, i8, null));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i5, int i6, int i7, int i8) {
        View view = viewHolder.itemView;
        int iG = (int) (i5 + H.G(view));
        int iH = (int) (i6 + H.H(viewHolder.itemView));
        resetAnimation(viewHolder);
        int i9 = i7 - iG;
        int i10 = i8 - iH;
        if (i9 == 0 && i10 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i9 != 0) {
            H.E0(view, -i9);
        }
        if (i10 != 0) {
            H.F0(view, -i10);
        }
        this.f22125c.add(new k(viewHolder, viewHolder.getLayoutPosition(), iG, iH, i7, i8, iH + viewHolder.itemView.getHeight(), null));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        int i5;
        View view;
        int bottom;
        int top;
        resetAnimation(viewHolder);
        View view2 = viewHolder.itemView;
        int layoutPosition = viewHolder.getLayoutPosition();
        if (layoutPosition == -1) {
            bottom = this.f22134l.getPaddingTop();
            top = view2.getTop();
        } else {
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = this.f22134l.findViewHolderForLayoutPosition(layoutPosition);
            if (viewHolderFindViewHolderForLayoutPosition == null || (view = viewHolderFindViewHolderForLayoutPosition.itemView) == null) {
                i5 = 0;
                this.f22123a.add(new l(viewHolder, i5, null));
                return true;
            }
            bottom = view.getBottom();
            top = view2.getTop();
        }
        i5 = bottom - top;
        this.f22123a.add(new l(viewHolder, i5, null));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return true;
    }

    void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            H.d(list.get(size).itemView).c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        H.d(view).c();
        int size = this.f22125c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f22125c.get(size).f22170a == viewHolder) {
                H.F0(view, 0.0f);
                H.E0(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.f22125c.remove(size);
            }
        }
        endChangeAnimation(this.f22126d, viewHolder);
        if (this.f22123a.remove(viewHolder)) {
            H.n0(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f22124b.remove(viewHolder)) {
            H.n0(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f22129g.size() - 1; size2 >= 0; size2--) {
            ArrayList<j> arrayList = this.f22129g.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f22129g.remove(size2);
            }
        }
        for (int size3 = this.f22128f.size() - 1; size3 >= 0; size3--) {
            ArrayList<k> arrayList2 = this.f22128f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f22170a == viewHolder) {
                    H.F0(view, 0.0f);
                    H.E0(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f22128f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f22127e.size() - 1; size5 >= 0; size5--) {
            ArrayList<i> arrayList3 = this.f22127e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                H.n0(view, 1.0f);
                H.A0(view, 1.0f);
                H.z0(view, 1.0f);
                H.F0(view, 0.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f22127e.remove(size5);
                }
            }
        }
        this.f22132j.remove(viewHolder);
        this.f22130h.remove(viewHolder);
        this.f22133k.remove(viewHolder);
        this.f22131i.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.f22125c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            k kVar = this.f22125c.get(size);
            View view = kVar.f22170a.itemView;
            H.F0(view, 0.0f);
            H.E0(view, 0.0f);
            dispatchMoveFinished(kVar.f22170a);
            this.f22125c.remove(size);
        }
        for (int size2 = this.f22123a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f22123a.get(size2).f22177a);
            this.f22123a.remove(size2);
        }
        int size3 = this.f22124b.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            i iVar = this.f22124b.get(size3);
            View view2 = iVar.f22161a.itemView;
            H.n0(view2, 1.0f);
            H.A0(view2, 1.0f);
            H.z0(view2, 1.0f);
            H.F0(view2, 0.0f);
            dispatchAddFinished(iVar.f22161a);
            this.f22124b.remove(size3);
        }
        for (int size4 = this.f22126d.size() - 1; size4 >= 0; size4--) {
            q(this.f22126d.get(size4));
        }
        this.f22126d.clear();
        if (isRunning()) {
            for (int size5 = this.f22128f.size() - 1; size5 >= 0; size5--) {
                ArrayList<k> arrayList = this.f22128f.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    k kVar2 = arrayList.get(size6);
                    View view3 = kVar2.f22170a.itemView;
                    H.F0(view3, 0.0f);
                    H.E0(view3, 0.0f);
                    dispatchMoveFinished(kVar2.f22170a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f22128f.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f22127e.size() - 1; size7 >= 0; size7--) {
                ArrayList<i> arrayList2 = this.f22127e.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder = arrayList2.get(size8).f22161a;
                    View view4 = viewHolder.itemView;
                    H.n0(view4, 1.0f);
                    H.A0(view4, 1.0f);
                    H.z0(view4, 1.0f);
                    H.F0(view4, 0.0f);
                    dispatchAddFinished(viewHolder);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f22127e.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f22129g.size() - 1; size9 >= 0; size9--) {
                ArrayList<j> arrayList3 = this.f22129g.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    q(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f22129g.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.f22132j);
            cancelAll(this.f22131i);
            cancelAll(this.f22130h);
            cancelAll(this.f22133k);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.f22124b.isEmpty() && this.f22126d.isEmpty() && this.f22125c.isEmpty() && this.f22123a.isEmpty() && this.f22131i.isEmpty() && this.f22132j.isEmpty() && this.f22130h.isEmpty() && this.f22133k.isEmpty() && this.f22128f.isEmpty() && this.f22127e.isEmpty() && this.f22129g.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean zIsEmpty = this.f22123a.isEmpty();
        boolean zIsEmpty2 = this.f22125c.isEmpty();
        boolean zIsEmpty3 = this.f22126d.isEmpty();
        boolean zIsEmpty4 = this.f22124b.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        t(this.f22124b);
        ArrayList<l> arrayList = this.f22123a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            l lVar = arrayList.get(i5);
            i5++;
            o(lVar);
        }
        this.f22123a.clear();
        if (!zIsEmpty2) {
            ArrayList<k> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f22125c);
            this.f22128f.add(arrayList2);
            this.f22125c.clear();
            a aVar = new a(arrayList2);
            if (zIsEmpty) {
                aVar.run();
            } else {
                H.c0(arrayList2.get(0).f22170a.itemView, aVar, 0L);
            }
        }
        if (!zIsEmpty3) {
            ArrayList<j> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f22126d);
            this.f22129g.add(arrayList3);
            this.f22126d.clear();
            b bVar = new b(arrayList3);
            if (zIsEmpty) {
                bVar.run();
            } else {
                H.c0(arrayList3.get(0).f22164a.itemView, bVar, 0L);
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList<i> arrayList4 = new ArrayList<>();
        arrayList4.addAll(this.f22124b);
        this.f22127e.add(arrayList4);
        this.f22124b.clear();
        c cVar = new c(arrayList4);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            cVar.run();
        } else {
            H.c0(arrayList4.get(0).f22161a.itemView, cVar, 0L);
        }
    }
}
