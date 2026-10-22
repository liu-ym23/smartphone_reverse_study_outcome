package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.L;
import androidx.core.view.AbstractC0457b;
import g.C0728a;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.view.menu.i;
import stepos.support.v7.widget.ActionMenuView;

/* loaded from: classes.dex */
public class d extends stepos.support.v7.view.menu.b implements AbstractC0457b.a {

    /* renamed from: A, reason: collision with root package name */
    private final SparseBooleanArray f21918A;

    /* renamed from: B, reason: collision with root package name */
    private View f21919B;

    /* renamed from: C, reason: collision with root package name */
    private h f21920C;

    /* renamed from: D, reason: collision with root package name */
    private c f21921D;

    /* renamed from: E, reason: collision with root package name */
    private f f21922E;

    /* renamed from: F, reason: collision with root package name */
    private C0248d f21923F;

    /* renamed from: G, reason: collision with root package name */
    final i f21924G;

    /* renamed from: H, reason: collision with root package name */
    int f21925H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f21926I;

    /* renamed from: k, reason: collision with root package name */
    private g f21927k;

    /* renamed from: l, reason: collision with root package name */
    private TouchDelegate f21928l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f21929m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21930n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21931o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f21932p;

    /* renamed from: q, reason: collision with root package name */
    private int f21933q;

    /* renamed from: r, reason: collision with root package name */
    private int f21934r;

    /* renamed from: s, reason: collision with root package name */
    private int f21935s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21936t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f21937u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f21938v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f21939w;

    /* renamed from: x, reason: collision with root package name */
    private int f21940x;

    /* renamed from: y, reason: collision with root package name */
    private int f21941y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f21942z;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f21943a;

        a(View view) {
            this.f21943a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f21943a;
            if (view == null || view.getWindowToken() == null || !d.this.f21921D.r()) {
                return;
            }
            this.f21943a.setAlpha(0.2f);
        }
    }

    class b implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f21945a;

        b(View view) {
            this.f21945a = view;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f21945a.setAlpha(1.0f);
        }
    }

    private class c extends stepos.support.v7.view.menu.g {

        /* renamed from: w, reason: collision with root package name */
        private stepos.support.v7.view.menu.j f21947w;

        public c(Context context, stepos.support.v7.view.menu.j jVar) {
            super(context, jVar, null, false, d.this.Q() ? X4.a.f5841q : C0728a.f16837n);
            this.f21947w = jVar;
            if (!((stepos.support.v7.view.menu.f) jVar.getItem()).m()) {
                t(d.this.f21927k == null ? (View) ((stepos.support.v7.view.menu.b) d.this).f21257i : d.this.f21927k);
            }
            u(d.this.f21924G);
            int size = jVar.size();
            boolean z5 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                MenuItem item = jVar.getItem(i5);
                if (item.isVisible() && item.getIcon() != null) {
                    z5 = true;
                    break;
                }
                i5++;
            }
            v(z5);
        }

        @Override // stepos.support.v7.view.menu.g, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            d.this.f21921D = null;
            d.this.f21925H = 0;
        }
    }

    /* renamed from: stepos.support.v7.widget.d$d, reason: collision with other inner class name */
    private class C0248d extends ActionMenuItemView.c {
        private C0248d() {
        }

        @Override // stepos.support.v7.view.menu.ActionMenuItemView.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a() {
            if (d.this.f21921D != null) {
                return d.this.f21921D.p();
            }
            return null;
        }

        /* synthetic */ C0248d(d dVar, a aVar) {
            this();
        }
    }

    private class e extends Y4.b {
        public e(View view) {
            super(view, X4.a.f5835k);
        }
    }

    private class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private h f21951a;

        public f(h hVar) {
            this.f21951a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((stepos.support.v7.view.menu.b) d.this).f21251c.d();
            View view = (View) ((stepos.support.v7.view.menu.b) d.this).f21257i;
            if (view != null && view.getWindowToken() != null && this.f21951a.y()) {
                d.this.f21920C = this.f21951a;
                d.this.f21927k.setAlpha(0.2f);
            }
            d.this.f21922E = null;
        }
    }

    private class g extends androidx.appcompat.widget.r implements ActionMenuView.b {

        /* renamed from: d, reason: collision with root package name */
        private final float[] f21953d;

        /* renamed from: e, reason: collision with root package name */
        private final int f21954e;

        /* renamed from: f, reason: collision with root package name */
        private final Paint f21955f;

        /* renamed from: g, reason: collision with root package name */
        private final float f21956g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f21957h;

        class a extends L {

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ d f21959j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, d dVar) {
                super(view);
                this.f21959j = dVar;
            }

            @Override // androidx.appcompat.widget.L
            public boolean c() {
                d.this.a0();
                return true;
            }

            @Override // androidx.appcompat.widget.L
            public boolean d() {
                if (d.this.f21922E != null) {
                    return false;
                }
                d.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.L
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public q b() {
                if (d.this.f21920C == null) {
                    return null;
                }
                return d.this.f21920C.p();
            }
        }

        public g(Context context) {
            super(context, null, d.this.f21926I ? X4.a.f5840p : C0728a.f16836m);
            this.f21953d = new float[2];
            this.f21954e = -65536;
            setId(X4.f.f5971S);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new a(this, d.this));
            if (d.this.Q()) {
                setBackgroundDrawable(d.this.new e(this));
            }
            if (d.this.f21942z != null) {
                setImageDrawable(d.this.f21942z);
            }
            setContentDescription(getResources().getString(g.h.f16963b));
            this.f21956g = context.getResources().getDimension(H1.f.f2164z);
            Paint paint = new Paint();
            this.f21955f = paint;
            paint.setAntiAlias(true);
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // stepos.support.v7.widget.ActionMenuView.b
        public boolean a() {
            return false;
        }

        @Override // stepos.support.v7.widget.ActionMenuView.b
        public boolean b() {
            return false;
        }

        public void f(boolean z5) {
            if (this.f21957h != z5) {
                this.f21957h = z5;
                invalidate();
            }
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f21957h) {
                try {
                    Matrix matrix = (Matrix) N1.h.b(this).b("mDrawMatrix").get(this);
                    canvas.save();
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                    if (matrix != null) {
                        canvas.concat(matrix);
                    }
                    float f5 = getDrawable().getBounds().right;
                    float f6 = this.f21956g;
                    canvas.drawCircle(f5 + f6, r0.top + f6, f6, this.f21955f);
                    canvas.restore();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.view.View
        protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
            super.onLayout(z5, i5, i6, i7, i8);
            int i9 = (int) (getResources().getDisplayMetrics().density * 52.0f);
            int i10 = i7 - i5;
            if (i10 < i9) {
                int i11 = (i9 - i10) / 2;
                Rect rect = new Rect(i5 - i11, i6, i7 + i11, i8);
                View view = (View) getParent();
                d.this.f21928l = new TouchDelegate(rect, this);
                view.setTouchDelegate(d.this.f21928l);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            d.this.a0();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i5, int i6, int i7, int i8) {
            boolean frame = super.setFrame(i5, i6, i7, i8);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            int paddingLeft = getPaddingLeft() - getPaddingRight();
            int paddingTop = getPaddingTop() - getPaddingBottom();
            if (drawable != null && background != null && (paddingLeft != 0 || paddingTop != 0)) {
                int width = getWidth();
                int height = getHeight();
                int i9 = width / 2;
                int i10 = height / 2;
                int i11 = (width + paddingLeft) / 2;
                int i12 = (height + paddingTop) / 2;
                androidx.core.graphics.drawable.a.l(background, i11 - i9, i12 - i10, i11 + i9, i12 + i10);
            }
            return frame;
        }
    }

    private class h extends stepos.support.v7.view.menu.g {
        public h(Context context, stepos.support.v7.view.menu.d dVar, View view, boolean z5) {
            super(context, dVar, view, z5, d.this.Q() ? X4.a.f5841q : C0728a.f16837n);
            n(d.this.Q() ? 4 : 3);
            w(8388613);
            u(d.this.f21924G);
        }

        @Override // stepos.support.v7.view.menu.g, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            if (((stepos.support.v7.view.menu.b) d.this).f21251c != null) {
                ((stepos.support.v7.view.menu.b) d.this).f21251c.close();
            }
            d.this.f21920C = null;
            d.this.f21927k.setAlpha(1.0f);
        }
    }

    private class i implements h.a {
        private i() {
        }

        @Override // stepos.support.v7.view.menu.h.a
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
            if (dVar instanceof stepos.support.v7.view.menu.j) {
                dVar.D().e(false);
            }
            h.a aVarL = d.this.l();
            if (aVarL != null) {
                aVarL.a(dVar, z5);
            }
        }

        @Override // stepos.support.v7.view.menu.h.a
        public boolean b(stepos.support.v7.view.menu.d dVar) {
            if (dVar == null) {
                return false;
            }
            d.this.f21925H = ((stepos.support.v7.view.menu.j) dVar).getItem().getItemId();
            h.a aVarL = d.this.l();
            return aVarL != null && aVarL.b(dVar);
        }

        /* synthetic */ i(d dVar, a aVar) {
            this();
        }
    }

    public d(Context context) {
        super(context, X4.h.f6032d, X4.h.f6038j);
        this.f21918A = new SparseBooleanArray();
        this.f21924G = new i(this, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View J(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f21257i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof i.a) && ((i.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    private boolean K() {
        ArrayList<stepos.support.v7.view.menu.f> arrayListE = this.f21251c.E();
        int size = arrayListE.size();
        int i5 = this.f21933q;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            stepos.support.v7.view.menu.f fVar = arrayListE.get(i8);
            if (fVar.s()) {
                i6++;
            } else if (fVar.r()) {
                i7++;
            } else {
                z5 = true;
            }
        }
        boolean z6 = this.f21931o && z5;
        SparseBooleanArray sparseBooleanArray = this.f21918A;
        sparseBooleanArray.clear();
        int i9 = this.f21937u ? i5 / this.f21941y : 0;
        int i10 = i6 + i7;
        if ((i10 > i9) | z6) {
            i9--;
        }
        if (i10 >= i9) {
            i10 = i9;
        }
        int i11 = 0;
        while (i11 < size && i10 > 0) {
            stepos.support.v7.view.menu.f fVar2 = arrayListE.get(i11);
            if (fVar2.s() || fVar2.r()) {
                i10--;
                fVar2.y(true);
                int groupId = fVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
            } else {
                fVar2.y(false);
            }
            i11++;
        }
        for (int i12 = i11; i12 < size; i12++) {
            arrayListE.get(i11).y(false);
        }
        return true;
    }

    public boolean I() {
        return N() | M();
    }

    public Drawable L() {
        g gVar = this.f21927k;
        if (gVar != null) {
            return gVar.getDrawable();
        }
        if (this.f21930n) {
            return this.f21929m;
        }
        return null;
    }

    public boolean M() {
        Object obj;
        f fVar = this.f21922E;
        if (fVar != null && (obj = this.f21257i) != null) {
            ((View) obj).removeCallbacks(fVar);
            this.f21922E = null;
            return true;
        }
        h hVar = this.f21920C;
        if (hVar == null) {
            return false;
        }
        hVar.o();
        return true;
    }

    public boolean N() {
        c cVar = this.f21921D;
        if (cVar == null) {
            return false;
        }
        cVar.o();
        return true;
    }

    public boolean O() {
        return this.f21922E != null || P();
    }

    public boolean P() {
        h hVar = this.f21920C;
        return hVar != null && hVar.r();
    }

    public boolean Q() {
        return this.f21926I;
    }

    public void R(Configuration configuration) throws Resources.NotFoundException {
        if (!this.f21936t) {
            this.f21935s = this.f21250b.getResources().getInteger(X4.g.f6028a);
        }
        stepos.support.v7.view.menu.d dVar = this.f21251c;
        if (dVar != null) {
            dVar.J(true);
        }
    }

    public void S(boolean z5) {
        this.f21939w = z5;
    }

    public void T(boolean z5) {
        if (this.f21926I != z5) {
            this.f21926I = z5;
            q(z5 ? X4.h.f6039k : X4.h.f6038j);
            Object obj = this.f21257i;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z5) {
                return;
            }
            this.f21932p = false;
            this.f21938v = false;
            this.f21936t = false;
            f(this.f21250b, this.f21251c);
        }
    }

    public void U(int i5) {
        this.f21935s = i5;
        this.f21936t = true;
    }

    public void V(ActionMenuView actionMenuView) {
        this.f21257i = actionMenuView;
        actionMenuView.b(this.f21251c);
    }

    public void W(Drawable drawable) {
        this.f21942z = drawable;
        g gVar = this.f21927k;
        if (gVar != null) {
            gVar.setImageDrawable(drawable);
        }
    }

    public void X(Drawable drawable) {
        g gVar = this.f21927k;
        if (gVar != null) {
            gVar.setImageDrawable(drawable);
        } else {
            this.f21930n = true;
            this.f21929m = drawable;
        }
    }

    public void Y(boolean z5) {
        this.f21931o = z5;
        this.f21932p = true;
    }

    public void Z(int i5, boolean z5) {
        this.f21933q = i5;
        this.f21937u = z5;
        this.f21938v = true;
    }

    @Override // stepos.support.v7.view.menu.b, stepos.support.v7.view.menu.h
    public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
        I();
        super.a(dVar, z5);
    }

    public boolean a0() {
        stepos.support.v7.view.menu.d dVar;
        if (!this.f21931o || P() || (dVar = this.f21251c) == null || this.f21257i == null || this.f21922E != null || dVar.z().isEmpty()) {
            return false;
        }
        f fVar = new f(new h(this.f21250b, this.f21251c, this.f21927k, true));
        this.f21922E = fVar;
        ((View) this.f21257i).post(fVar);
        super.e(null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // stepos.support.v7.view.menu.b, stepos.support.v7.view.menu.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r8) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.d.b(boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    @Override // stepos.support.v7.view.menu.h
    public boolean c() {
        int i5;
        int iO;
        int i6;
        int i7;
        boolean z5;
        int i8;
        if (this.f21926I) {
            return K();
        }
        ArrayList<stepos.support.v7.view.menu.f> arrayListE = this.f21251c.E();
        int size = arrayListE.size();
        int i9 = this.f21935s;
        int i10 = this.f21934r;
        ?? r5 = 0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f21257i;
        boolean z6 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            stepos.support.v7.view.menu.f fVar = arrayListE.get(i13);
            if (fVar.s()) {
                i11++;
            } else if (fVar.r()) {
                i12++;
            } else {
                z6 = true;
            }
            if (this.f21939w && fVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (this.f21931o && (z6 || i12 + i11 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = this.f21918A;
        sparseBooleanArray.clear();
        if (this.f21937u) {
            int i15 = this.f21940x;
            iO = i10 / i15;
            i5 = i15 + ((i10 % i15) / iO);
        } else {
            i5 = 0;
            iO = 0;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            stepos.support.v7.view.menu.f fVar2 = arrayListE.get(i16);
            if (fVar2.s()) {
                View viewM = m(fVar2, this.f21919B, viewGroup);
                if (this.f21919B == null) {
                    this.f21919B = viewM;
                }
                if (this.f21937u) {
                    iO -= ActionMenuView.O(viewM, i5, iO, iMakeMeasureSpec, r5);
                } else {
                    viewM.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewM.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                int groupId = fVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                fVar2.y(true);
                i6 = size;
                i7 = i14;
                z5 = r5;
            } else if (fVar2.r()) {
                int groupId2 = fVar2.getGroupId();
                boolean z7 = sparseBooleanArray.get(groupId2);
                boolean z8 = (i14 > 0 || z7) && i10 > 0 && (!this.f21937u || iO > 0);
                i6 = size;
                if (z8) {
                    View viewM2 = m(fVar2, this.f21919B, viewGroup);
                    i8 = i14;
                    if (this.f21919B == null) {
                        this.f21919B = viewM2;
                    }
                    if (this.f21937u) {
                        int iO2 = ActionMenuView.O(viewM2, i5, iO, iMakeMeasureSpec, 0);
                        iO -= iO2;
                        if (iO2 == 0) {
                            z8 = false;
                        }
                    } else {
                        viewM2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewM2.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z8 &= !this.f21937u ? i16 != 0 ? i10 < 0 : i10 + i17 <= 0 : i10 < 0;
                } else {
                    i8 = i14;
                }
                if (z8 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z7) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i18 = 0; i18 < i16; i18++) {
                        stepos.support.v7.view.menu.f fVar3 = arrayListE.get(i18);
                        if (fVar3.getGroupId() == groupId2) {
                            if (fVar3.m()) {
                                i8++;
                            }
                            fVar3.y(false);
                        }
                    }
                }
                int i19 = i8;
                if (z8) {
                    i19--;
                }
                fVar2.y(z8);
                i7 = i19;
                z5 = false;
            } else {
                i6 = size;
                i7 = i14;
                z5 = r5;
                fVar2.y(z5);
            }
            i16++;
            r5 = z5;
            size = i6;
            i14 = i7;
        }
        return true;
    }

    @Override // stepos.support.v7.view.menu.b, stepos.support.v7.view.menu.h
    public boolean e(stepos.support.v7.view.menu.j jVar) {
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        stepos.support.v7.view.menu.j jVar2 = jVar;
        while (jVar2.c0() != this.f21251c) {
            jVar2 = (stepos.support.v7.view.menu.j) jVar2.c0();
        }
        View viewJ = J(jVar2.getItem());
        if (viewJ == null && (viewJ = this.f21927k) == null) {
            return false;
        }
        this.f21925H = jVar.getItem().getItemId();
        c cVar = new c(this.f21250b, jVar);
        this.f21921D = cVar;
        cVar.w(8388613);
        this.f21921D.n(4);
        this.f21921D.t(viewJ);
        this.f21921D.x();
        viewJ.post(new a(viewJ));
        this.f21921D.p().K(new b(viewJ));
        super.e(jVar);
        return true;
    }

    @Override // stepos.support.v7.view.menu.b, stepos.support.v7.view.menu.h
    public void f(Context context, stepos.support.v7.view.menu.d dVar) {
        super.f(context, dVar);
        Resources resources = context.getResources();
        b5.a aVarB = b5.a.b(context);
        if (!this.f21932p) {
            this.f21931o = aVarB.j();
        }
        if (!this.f21938v) {
            this.f21933q = aVarB.d();
        }
        if (!this.f21936t) {
            this.f21935s = aVarB.e();
        }
        int measuredWidth = this.f21933q;
        if (this.f21931o) {
            if (this.f21927k == null) {
                g gVar = new g(this.f21249a);
                this.f21927k = gVar;
                if (this.f21930n) {
                    gVar.setImageDrawable(this.f21929m);
                    this.f21929m = null;
                    this.f21930n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f21927k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f21927k.getMeasuredWidth();
        } else {
            this.f21927k = null;
        }
        this.f21934r = measuredWidth;
        this.f21940x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f21919B = null;
        this.f21941y = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    @Override // stepos.support.v7.view.menu.b
    protected void h(View view, int i5) {
        super.h(view, i5);
        if ((this.f21257i instanceof ActionMenuView) && (view instanceof ActionMenuItemView)) {
            ((ActionMenuView.d) view.getLayoutParams()).f21549a = ((ActionMenuItemView) view).x();
        }
    }

    @Override // stepos.support.v7.view.menu.b
    public void i(stepos.support.v7.view.menu.f fVar, i.a aVar) {
        ((ActionMenuItemView) aVar).setIsInSplit(this.f21926I);
        aVar.d(fVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f21257i);
        if (this.f21923F == null) {
            this.f21923F = new C0248d(this, null);
        }
        actionMenuItemView.setPopupCallback(this.f21923F);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // stepos.support.v7.view.menu.b
    public i.a j(ViewGroup viewGroup) {
        i.a aVarJ = super.j(viewGroup);
        if (aVarJ instanceof View) {
        }
        return aVarJ;
    }

    @Override // stepos.support.v7.view.menu.b
    public boolean k(ViewGroup viewGroup, int i5) {
        if (viewGroup.getChildAt(i5) == this.f21927k) {
            return false;
        }
        return super.k(viewGroup, i5);
    }

    @Override // stepos.support.v7.view.menu.b
    public View m(stepos.support.v7.view.menu.f fVar, View view, ViewGroup viewGroup) {
        View actionView = fVar.getActionView();
        if (actionView == null || fVar.k()) {
            actionView = super.m(fVar, view, viewGroup);
        }
        actionView.setVisibility(fVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
            return actionView;
        }
        if ((layoutParams instanceof ActionMenuView.d) && (actionView instanceof ActionMenuItemView)) {
            ((ActionMenuView.d) layoutParams).f21549a = ((ActionMenuItemView) actionView).x();
        }
        return actionView;
    }

    @Override // stepos.support.v7.view.menu.b
    public stepos.support.v7.view.menu.i n(ViewGroup viewGroup) {
        stepos.support.v7.view.menu.i iVarN = super.n(viewGroup);
        ((ActionMenuView) iVarN).setPresenter(this);
        return iVarN;
    }

    @Override // stepos.support.v7.view.menu.b
    public boolean r(int i5, stepos.support.v7.view.menu.f fVar) {
        return fVar.m();
    }
}
