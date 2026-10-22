package com.stepos.familyguard.ui.usage;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.InterfaceC0538s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.common.widget.PageIndicator;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractC0597f;
import com.stepos.familyguard.ui.usage.U;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import f2.C0711p;
import java.util.List;
import w2.H0;
import w2.InterfaceC1258w0;
import w2.InterfaceC1260x0;
import w2.InterfaceC1262y0;

/* renamed from: com.stepos.familyguard.ui.usage.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0592a extends x2.c implements View.OnTouchListener, InterfaceC0538s, AbstractC0597f.c, AbstractC0597f.b {

    /* renamed from: A, reason: collision with root package name */
    private long f14972A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f14973B;

    /* renamed from: C, reason: collision with root package name */
    protected U f14974C;

    /* renamed from: D, reason: collision with root package name */
    protected Context f14975D;

    /* renamed from: E, reason: collision with root package name */
    protected D2.r<String, Drawable> f14976E;

    /* renamed from: F, reason: collision with root package name */
    protected AbstractC0597f f14977F;

    /* renamed from: G, reason: collision with root package name */
    protected MyRecyclerView f14978G;

    /* renamed from: H, reason: collision with root package name */
    private InterfaceC1262y0 f14979H;

    /* renamed from: I, reason: collision with root package name */
    private InterfaceC1258w0 f14980I;

    /* renamed from: J, reason: collision with root package name */
    private InterfaceC1260x0 f14981J;

    /* renamed from: a, reason: collision with root package name */
    protected int f14982a;

    /* renamed from: b, reason: collision with root package name */
    protected int f14983b;

    /* renamed from: c, reason: collision with root package name */
    protected int f14984c;

    /* renamed from: d, reason: collision with root package name */
    protected int f14985d;

    /* renamed from: e, reason: collision with root package name */
    protected int f14986e;

    /* renamed from: f, reason: collision with root package name */
    protected int f14987f;

    /* renamed from: g, reason: collision with root package name */
    protected int f14988g;

    /* renamed from: h, reason: collision with root package name */
    protected int f14989h;

    /* renamed from: i, reason: collision with root package name */
    protected int f14990i;

    /* renamed from: j, reason: collision with root package name */
    protected int f14991j;

    /* renamed from: k, reason: collision with root package name */
    protected int f14992k;

    /* renamed from: l, reason: collision with root package name */
    protected int f14993l;

    /* renamed from: m, reason: collision with root package name */
    protected int f14994m;

    /* renamed from: n, reason: collision with root package name */
    protected int f14995n;

    /* renamed from: o, reason: collision with root package name */
    protected int f14996o;

    /* renamed from: p, reason: collision with root package name */
    protected int f14997p;

    /* renamed from: q, reason: collision with root package name */
    protected int f14998q;

    /* renamed from: r, reason: collision with root package name */
    protected int f14999r;

    /* renamed from: s, reason: collision with root package name */
    protected int f15000s;

    /* renamed from: t, reason: collision with root package name */
    protected int f15001t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f15002u = true;

    /* renamed from: v, reason: collision with root package name */
    protected int f15003v = 0;

    /* renamed from: w, reason: collision with root package name */
    protected int f15004w = 0;

    /* renamed from: x, reason: collision with root package name */
    protected int f15005x = 0;

    /* renamed from: y, reason: collision with root package name */
    protected int f15006y;

    /* renamed from: z, reason: collision with root package name */
    protected int f15007z;

    /* renamed from: com.stepos.familyguard.ui.usage.a$a, reason: collision with other inner class name */
    abstract class AbstractC0183a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private int f15008a;

        /* renamed from: com.stepos.familyguard.ui.usage.a$a$a, reason: collision with other inner class name */
        class C0184a extends ViewPager2.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AbstractViewOnTouchListenerC0592a f15010a;

            C0184a(AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592a) {
                this.f15010a = abstractViewOnTouchListenerC0592a;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void a(int i5) {
                super.a(i5);
                if (i5 != 0 || AbstractC0183a.this.f15008a < 0) {
                    return;
                }
                AbstractC0183a abstractC0183a = AbstractC0183a.this;
                AbstractViewOnTouchListenerC0592a.this.P(abstractC0183a.f15008a);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void b(int i5, float f5, int i6) {
                super.b(i5, f5, i6);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void c(int i5) {
                super.c(i5);
                AbstractC0183a.this.f15008a = i5;
                AbstractC0183a.this.d().setSelectedItemPosition(AbstractC0183a.this.f15008a);
            }
        }

        public AbstractC0183a(View view) {
            super(view);
            this.f15008a = -1;
            ViewPager2 viewPager2E = e();
            if (AbstractViewOnTouchListenerC0592a.this.f14977F == null) {
                AbstractViewOnTouchListenerC0592a.this.f14977F = AbstractViewOnTouchListenerC0592a.this.y(AbstractViewOnTouchListenerC0592a.this.f14975D, AbstractViewOnTouchListenerC0592a.this);
            }
            viewPager2E.setAdapter(AbstractViewOnTouchListenerC0592a.this.f14977F);
            viewPager2E.j(1, false);
            viewPager2E.setOverScrollMode(2);
            viewPager2E.g(new C0184a(AbstractViewOnTouchListenerC0592a.this));
            d().setItemCount(2);
            d().setSelectedItemPosition(1);
        }

        public void c(StatsDataSet statsDataSet) {
        }

        public abstract PageIndicator d();

        public abstract ViewPager2 e();
    }

    /* renamed from: com.stepos.familyguard.ui.usage.a$b */
    protected static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView[] f15012a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView[] f15013b;

        /* renamed from: c, reason: collision with root package name */
        j2.w f15014c;

        public b(View view) {
            super(view);
            this.f15012a = new TextView[]{(TextView) this.f15014c.b().findViewById(R.id.category_1_name), (TextView) this.f15014c.b().findViewById(R.id.category_2_name), (TextView) this.f15014c.b().findViewById(R.id.category_3_name)};
            TextView[] textViewArr = {(TextView) this.f15014c.b().findViewById(R.id.category_1_usage_time), (TextView) this.f15014c.b().findViewById(R.id.category_2_usage_time), (TextView) this.f15014c.b().findViewById(R.id.category_3_usage_time)};
            this.f15013b = textViewArr;
            j2.w wVarA = j2.w.a(view);
            this.f15014c = wVarA;
            T1.g.e(1.44f, wVarA.b());
            T1.g.c(1.18f, textViewArr[0]);
            T1.g.c(1.18f, textViewArr[1]);
            T1.g.c(1.18f, textViewArr[2]);
        }

        public void a(z2.d dVar) {
            if (dVar == null) {
                return;
            }
            int[] iArrR = dVar.r();
            long[] jArrS = dVar.s();
            Application applicationA = P1.a.a();
            for (int i5 = 0; i5 < iArrR.length; i5++) {
                long j5 = jArrS[i5];
                String string = applicationA.getString(W1.c.m(iArrR[i5]));
                String strM = C0711p.m(applicationA, j5);
                if (j5 == 0) {
                    ((View) this.f15012a[i5].getParent()).setVisibility(4);
                } else {
                    ((View) this.f15012a[i5].getParent()).setVisibility(0);
                    this.f15012a[i5].setText(string);
                    this.f15013b[i5].setText(strM);
                }
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.a$c */
    protected static class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        j2.x f15015a;

        public c(View view) {
            super(view);
            this.f15015a = j2.x.a(view);
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.a$d */
    static class d extends RecyclerView.ViewHolder {
        public d(View view) {
            super(view);
        }
    }

    public AbstractViewOnTouchListenerC0592a(Context context, D2.r<String, Drawable> rVar) {
        this.f14975D = context;
        S();
        this.f14976E = rVar;
    }

    private void D(int i5) {
        int iG = G(i5);
        int iH = H(i5);
        if (iH >= iG) {
            return;
        }
        int iMin = Math.min(iG, iH + 6);
        if (i5 == 2) {
            this.f15003v = iMin;
        } else if (i5 == 7) {
            this.f15004w = iMin;
        } else if (i5 != 8) {
            return;
        } else {
            this.f15005x = iMin;
        }
        this.f15001t = p();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        boolean z5 = this.f15002u;
        boolean z6 = !z5;
        if (z5 && G(7) <= 0) {
            R1.a.a("BaseDigitalWellbeingRecyclerViewAdapter", "ignore switch to category usage because category data is empty");
            return;
        }
        if (!z5 && G(2) <= 0) {
            R1.a.a("BaseDigitalWellbeingRecyclerViewAdapter", "ignore switch to package usage because package data is empty");
            return;
        }
        this.f15002u = z6;
        Q();
        this.f15001t = p();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(RecyclerView.ViewHolder viewHolder, View view) {
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        if (bindingAdapterPosition == this.f14989h) {
            D(2);
            return;
        }
        if (bindingAdapterPosition == this.f14992k) {
            D(7);
        } else if (bindingAdapterPosition == this.f14995n) {
            D(8);
        } else {
            this.f15001t = p();
            notifyDataSetChanged();
        }
    }

    private void R() {
        if (this.f15002u) {
            if (this.f15003v <= 0) {
                this.f15003v = Math.min(6, G(2));
            }
            this.f14992k = Integer.MIN_VALUE;
        } else {
            if (this.f15004w <= 0) {
                this.f15004w = Math.min(6, G(7));
            }
            this.f14989h = Integer.MIN_VALUE;
        }
        if (this.f15005x <= 0) {
            this.f15005x = Math.min(6, G(8));
        }
    }

    private void S() {
        int iB = C0711p.B(System.currentTimeMillis());
        if (iB == 0) {
            iB = 7;
        }
        this.f15006y = 1;
        this.f15007z = iB - 1;
        this.f14972A = C0711p.y();
    }

    private void X() {
        if (C0711p.y() == this.f14972A) {
            if (this.f14973B) {
                return;
            }
            S();
        } else {
            R1.a.a("BaseDigitalWellbeingRecyclerViewAdapter", "syncSelectedDayOnDayChanged() day changed, reselect today");
            S();
            AbstractC0597f abstractC0597f = this.f14977F;
            if (abstractC0597f != null) {
                abstractC0597f.n();
            }
        }
    }

    protected View A(Context context, ViewGroup viewGroup, int i5) {
        if (context == null) {
            return null;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        switch (i5) {
            case 0:
                View viewInflate = layoutInflaterFrom.inflate(R.layout.us_category_item, viewGroup, false);
                T1.g.c(1.18f, (TextView) viewInflate.findViewById(R.id.category_title));
                T1.g.c(1.18f, (TextView) viewInflate.findViewById(R.id.category_des));
                return viewInflate;
            case 1:
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.us_screen_usage_time_category_item, viewGroup, false);
                T1.g.c(1.18f, (TextView) viewInflate2.findViewById(R.id.category_title));
                T1.g.c(1.18f, (TextView) viewInflate2.findViewById(R.id.category_des));
                return viewInflate2;
            case 2:
            case 7:
            case 8:
                return layoutInflaterFrom.inflate(R.layout.us_progress_item, viewGroup, false);
            case 3:
                return x(viewGroup);
            case 4:
                return z(layoutInflaterFrom, viewGroup, 4);
            case 5:
                return z(layoutInflaterFrom, viewGroup, 5);
            case 6:
                return z(layoutInflaterFrom, viewGroup, 6);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
            default:
                return layoutInflaterFrom.inflate(R.layout.us_more_item, viewGroup, false);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return LayoutInflater.from(context).inflate(R.layout.us_categories_info_container_item, viewGroup, false);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return layoutInflaterFrom.inflate(R.layout.us_space_item, viewGroup, false);
        }
    }

    protected RecyclerView.ViewHolder B(View view, int i5) {
        switch (i5) {
            case 0:
            case 1:
                return new c(view);
            case 2:
                return new G(view, this.f14976E);
            case 3:
                return C(view);
            case 4:
                return new K(view);
            case 5:
                return new H(view);
            case 6:
                return new B(view);
            case 7:
                return new r(view);
            case 8:
                return new F(view, this.f14976E);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
            default:
                return new d(view);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return new b(view);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return new H0(view);
        }
    }

    protected abstract AbstractC0183a C(View view);

    public boolean E(int i5) {
        return H(i5) < G(i5);
    }

    protected abstract List<U.a> F();

    public int G(int i5) {
        if (this.f14974C == null) {
            return 0;
        }
        if (i5 == 2) {
            return K().size();
        }
        if (i5 == 7) {
            return F().size();
        }
        if (i5 == 8) {
            return J().size();
        }
        if (i5 == 9) {
            return 2;
        }
        return i5 == 0 ? 4 : 0;
    }

    public int H(int i5) {
        int i6;
        if (i5 == 2) {
            i6 = this.f15003v;
        } else if (i5 == 7) {
            i6 = this.f15004w;
        } else {
            if (i5 != 8) {
                return 0;
            }
            i6 = this.f15005x;
        }
        int iG = G(i5);
        if (iG <= 0) {
            return 0;
        }
        return i6 <= 0 ? Math.min(6, iG) : Math.min(i6, iG);
    }

    protected StatsDataSet I() {
        StatsDataSet[] statsDataSetArrM = M();
        if (statsDataSetArrM == null || statsDataSetArrM.length == 0) {
            return null;
        }
        return statsDataSetArrM[0];
    }

    protected abstract List<U.b> J();

    protected abstract List<U.c> K();

    protected abstract StatsDataSet L();

    protected StatsDataSet[] M() {
        U u5 = this.f14974C;
        if (u5 == null) {
            return null;
        }
        return u5.u();
    }

    protected void P(int i5) {
    }

    protected void Q() {
        if (this.f15002u) {
            this.f15003v = Math.min(6, G(2));
            this.f14992k = Integer.MIN_VALUE;
        } else {
            this.f15004w = Math.min(6, G(7));
            this.f14989h = Integer.MIN_VALUE;
        }
        this.f15005x = Math.min(6, G(8));
    }

    public void T(InterfaceC1258w0 interfaceC1258w0) {
        this.f14980I = interfaceC1258w0;
    }

    public void U(InterfaceC1260x0 interfaceC1260x0) {
        this.f14981J = interfaceC1260x0;
    }

    public void V(InterfaceC1262y0 interfaceC1262y0) {
        this.f14979H = interfaceC1262y0;
    }

    public void W(U u5) {
        this.f14974C = u5;
        if (u5 != null) {
            X();
            R();
            this.f15001t = p();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15001t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        int i6;
        if (i5 == this.f14982a) {
            return 1;
        }
        if (i5 == this.f14983b || i5 == this.f14984c || i5 == this.f14985d || i5 == this.f14986e) {
            return 0;
        }
        if (i5 == this.f14989h || i5 == this.f14995n || i5 == this.f14992k) {
            return 9;
        }
        boolean z5 = this.f15002u;
        if (z5 && i5 == this.f14987f) {
            return 2;
        }
        if (z5 && i5 == this.f14988g) {
            return 2;
        }
        if (z5 && i5 > this.f14987f && i5 < this.f14988g) {
            return 2;
        }
        if (!z5 && i5 == this.f14990i) {
            return 7;
        }
        if (!z5 && i5 == this.f14991j) {
            return 7;
        }
        if (!z5 && i5 > this.f14990i && i5 < this.f14991j) {
            return 7;
        }
        int i7 = this.f14993l;
        if (i5 == i7 || i5 == (i6 = this.f14994m)) {
            return 8;
        }
        if (i5 > i7 && i5 < i6) {
            return 8;
        }
        if (i5 == this.f14996o) {
            return 3;
        }
        if (i5 == this.f14997p) {
            return 4;
        }
        if (i5 == this.f14998q) {
            return 5;
        }
        if (i5 == this.f14999r) {
            return 6;
        }
        return super.getItemViewType(i5);
    }

    public void h(int i5, int i6, Object obj) {
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0597f.c
    public void i(int i5, int i6, Object obj) {
        boolean z5 = this.f15006y == i5 && this.f15007z == i6;
        this.f15006y = i5;
        this.f15007z = i6;
        this.f14973B = true;
        this.f14972A = C0711p.y();
        if (!z5) {
            Q();
        }
        this.f15001t = p();
        notifyDataSetChanged();
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c
    public int immersiveItemType(int i5) {
        int itemViewType = getItemViewType(i5);
        if (itemViewType == 12) {
            return 4;
        }
        if (i5 == this.f14982a + 1) {
            return 0;
        }
        if (i5 == this.f14983b + 1) {
            return this.f15002u ? G(2) <= 1 ? 3 : 0 : G(7) <= 1 ? 3 : 0;
        }
        if (itemViewType == 10) {
            return 2;
        }
        if (i5 == this.f14986e + 1) {
            return G(8) <= 1 ? 3 : 0;
        }
        if (i5 == this.f14984c + 1 || i5 == this.f14985d + 1) {
            return 3;
        }
        if (itemViewType == 9) {
            return 2;
        }
        if (itemViewType == 0 || itemViewType == 1) {
            return 4;
        }
        if (itemViewType == 4) {
            return 1;
        }
        if (i5 == this.f14988g && this.f15002u && !E(2)) {
            return 2;
        }
        if (i5 != this.f14991j || this.f15002u || E(7)) {
            return (i5 != this.f14994m || E(8)) ? 1 : 2;
        }
        return 2;
    }

    protected int n(int i5) {
        int iG = G(7);
        int iH = H(7);
        boolean zE = E(7);
        if (this.f15002u) {
            this.f14983b = Integer.MIN_VALUE;
            this.f14990i = Integer.MIN_VALUE;
            this.f14991j = Integer.MIN_VALUE;
            this.f14992k = Integer.MIN_VALUE;
            return i5;
        }
        if (iG <= 0) {
            this.f14983b = Integer.MIN_VALUE;
            this.f14987f = Integer.MIN_VALUE;
            this.f14988g = Integer.MIN_VALUE;
            this.f14989h = Integer.MIN_VALUE;
            return i5;
        }
        this.f14983b = i5;
        int i6 = i5 + 1;
        this.f14990i = i6;
        int i7 = i6 + iH;
        this.f14991j = i7 - 1;
        if (zE) {
            this.f14992k = i7;
            return i7 + 1;
        }
        this.f14992k = Integer.MIN_VALUE;
        return i7;
    }

    @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
        super.onBindViewHolder(viewHolder, i5);
        List<U.c> listK = K();
        List<U.b> listJ = J();
        List<U.a> listF = F();
        StatsDataSet statsDataSetL = L();
        if (viewHolder instanceof G) {
            G g5 = (G) viewHolder;
            int i6 = i5 - this.f14987f;
            if (listK == null || i6 < 0 || i6 >= listK.size()) {
                g5.d();
                return;
            }
            g5.f14905d.f17649e.setMax(Math.max(1L, C0711p.l(listK.get(0).f14934d)));
            g5.e(this.f14975D, listK.get(i6), this.f14979H);
            return;
        }
        if (viewHolder instanceof r) {
            r rVar = (r) viewHolder;
            int i7 = i5 - this.f14990i;
            if (listF == null || i7 < 0 || i7 >= listF.size()) {
                return;
            }
            rVar.f15150a.f17649e.setMax(Math.max(1L, C0711p.l(listF.get(0).f14930e)));
            rVar.b(this.f14975D, listF.get(i7), this.f14980I);
            return;
        }
        if (viewHolder instanceof F) {
            F f5 = (F) viewHolder;
            int i8 = i5 - this.f14993l;
            if (listJ == null || i8 < 0 || i8 >= listJ.size()) {
                f5.d();
                return;
            }
            f5.f14904d.f17649e.setMax(listJ.get(0).f14933c);
            f5.f14904d.f17648d.setVisibility(8);
            f5.e(this.f14975D, listJ.get(i8), this.f14981J);
            return;
        }
        if (viewHolder instanceof c) {
            j2.x xVar = ((c) viewHolder).f15015a;
            if (i5 == this.f14982a) {
                xVar.f17800c.setText(R.string.us_screen_usage);
                StatsDataSet statsDataSetI = I();
                if (statsDataSetI == null) {
                    xVar.f17799b.setVisibility(8);
                    return;
                }
                Context context = this.f14975D;
                String string = context.getString(R.string.us_until, T1.d.a(context, statsDataSetI.getUpdateTime()));
                xVar.f17799b.setVisibility(0);
                xVar.f17799b.setText(string);
                return;
            }
            if (i5 == this.f14983b) {
                xVar.f17800c.setText(R.string.us_frequently_used);
                xVar.f17799b.setVisibility(0);
                xVar.f17799b.setOnClickListener(new View.OnClickListener() { // from class: w2.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f23610a.N(view);
                    }
                });
                if (this.f15002u) {
                    xVar.f17799b.setText(R.string.us_show_category);
                    return;
                } else {
                    xVar.f17799b.setText(R.string.us_show_apps);
                    return;
                }
            }
            if (i5 == this.f14984c) {
                xVar.f17800c.setText(R.string.us_take_up_phone);
                xVar.f17799b.setVisibility(8);
                return;
            } else if (i5 == this.f14985d) {
                xVar.f17800c.setText(R.string.us_receive_notification);
                xVar.f17799b.setVisibility(8);
                return;
            } else {
                if (i5 == this.f14986e) {
                    xVar.f17800c.setText(R.string.us_frequently_used);
                    xVar.f17799b.setVisibility(8);
                    return;
                }
                return;
            }
        }
        if (viewHolder instanceof AbstractC0183a) {
            StatsDataSet[] statsDataSetArrM = M();
            if (statsDataSetArrM == null || statsDataSetL == null) {
                return;
            }
            this.f14977F.p(statsDataSetArrM);
            ((AbstractC0183a) viewHolder).c(statsDataSetL);
            return;
        }
        if (viewHolder instanceof K) {
            if (statsDataSetL == null) {
                return;
            }
            ((HistogramView) viewHolder.itemView.findViewById(R.id.day_histogram_view)).setData(new z2.d(statsDataSetL));
            return;
        }
        if (viewHolder instanceof H) {
            if (statsDataSetL == null) {
                return;
            }
            z2.j jVar = new z2.j(statsDataSetL.getChildren());
            HistogramView histogramView = (HistogramView) viewHolder.itemView.findViewById(R.id.day_histogram_view);
            int iA = (int) jVar.a();
            int iG = (int) jVar.g();
            String string2 = this.f14975D.getString(R.string.fg_common_count);
            histogramView.setYDimensionStrings(new String[]{iA + string2, ((iA + iG) / 2) + string2, iG + string2});
            if (statsDataSetL.getInterval() == com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
                new A2.H(1).b(histogramView, jVar);
                return;
            } else {
                histogramView.setData(jVar);
                return;
            }
        }
        if (!(viewHolder instanceof B)) {
            if (viewHolder instanceof d) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: w2.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f23613a.O(viewHolder, view);
                    }
                });
                return;
            }
            return;
        }
        if (statsDataSetL == null) {
            return;
        }
        z2.h hVar = new z2.h(statsDataSetL.getChildren());
        HistogramView histogramView2 = (HistogramView) viewHolder.itemView.findViewById(R.id.day_histogram_view);
        int iA2 = (int) hVar.a();
        int iG2 = (int) hVar.g();
        String string3 = this.f14975D.getString(R.string.us_widget_notification_label);
        histogramView2.setYDimensionStrings(new String[]{iA2 + string3, ((iA2 + iG2) / 2) + string3, iG2 + string3});
        if (statsDataSetL.getInterval() == com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
            new A2.H(1).b(histogramView2, hVar);
        } else {
            histogramView2.setData(hVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        if (this.f14978G == null && (viewGroup instanceof MyRecyclerView)) {
            this.f14978G = (MyRecyclerView) viewGroup;
        }
        return B(A(this.f14975D, viewGroup, i5), i5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    protected int p() {
        return q(0);
    }

    protected int q(int i5) {
        this.f14982a = i5;
        int i6 = i5 + 1;
        this.f14996o = i6;
        int iV = v(i6);
        int iS = this.f15002u ? s(iV) : n(iV);
        this.f14984c = iS;
        this.f14998q = iS + 1;
        this.f14985d = iS + 2;
        this.f14999r = iS + 3;
        return t(iS + 4);
    }

    protected int s(int i5) {
        int iG = G(2);
        int iH = H(2);
        boolean zE = E(2);
        if (!this.f15002u) {
            this.f14983b = Integer.MIN_VALUE;
            this.f14987f = Integer.MIN_VALUE;
            this.f14988g = Integer.MIN_VALUE;
            this.f14989h = Integer.MIN_VALUE;
            return i5;
        }
        if (iG <= 0) {
            this.f14983b = Integer.MIN_VALUE;
            this.f14987f = Integer.MIN_VALUE;
            this.f14988g = Integer.MIN_VALUE;
            this.f14989h = Integer.MIN_VALUE;
        } else {
            this.f14983b = i5;
            int i6 = i5 + 1;
            this.f14987f = i6;
            i5 = i6 + iH;
            this.f14988g = i5 - 1;
            if (zE) {
                this.f14989h = i5;
                i5++;
            } else {
                this.f14989h = Integer.MIN_VALUE;
            }
        }
        this.f14992k = Integer.MIN_VALUE;
        return i5;
    }

    protected int t(int i5) {
        int iG = G(8);
        int iH = H(8);
        boolean zE = E(8);
        if (iG <= 0) {
            this.f14986e = Integer.MIN_VALUE;
            this.f14993l = Integer.MIN_VALUE;
            this.f14994m = Integer.MIN_VALUE;
            this.f14995n = Integer.MIN_VALUE;
            return i5;
        }
        this.f14986e = i5;
        int i6 = i5 + 1;
        this.f14993l = i6;
        int i7 = i6 + iH;
        this.f14994m = i7 - 1;
        if (zE) {
            this.f14995n = i7;
            return i7 + 1;
        }
        this.f14995n = Integer.MIN_VALUE;
        return i7;
    }

    protected abstract int v(int i5);

    public void w() {
        D2.r<String, Drawable> rVar = this.f14976E;
        if (rVar != null) {
            rVar.a();
        }
    }

    protected abstract View x(ViewGroup viewGroup);

    protected abstract AbstractC0597f y(Context context, AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592a);

    protected abstract View z(LayoutInflater layoutInflater, ViewGroup viewGroup, int i5);
}
