package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.common.widget.PageIndicator;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a;
import com.stepos.familyguard.ui.usage.U;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;
import java.util.List;
import org.libpag.BuildConfig;
import y2.C1320a;

/* loaded from: classes.dex */
public class V extends AbstractViewOnTouchListenerC0592a {

    /* renamed from: K, reason: collision with root package name */
    private int f14968K;

    /* renamed from: L, reason: collision with root package name */
    private j2.H f14969L;

    public class a extends AbstractViewOnTouchListenerC0592a.AbstractC0183a {

        /* renamed from: c, reason: collision with root package name */
        public boolean f14970c;

        public a(View view) {
            super(view);
            this.f14970c = false;
        }

        @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a.AbstractC0183a
        public void c(StatsDataSet statsDataSet) throws Resources.NotFoundException {
            V.this.f14969L = j2.H.a(this.itemView);
            if (this.f14970c) {
                V.this.f14969L.f17670g.setVisibility(4);
                return;
            }
            V.this.f14969L.f17670g.setVisibility(0);
            V.this.f14969L.f17665b.setText(statsDataSet.getStartTime() <= C0711p.y() - 604800000 ? V.this.f14975D.getString(R.string.us_last_week) : V.this.f14975D.getString(R.string.us_this_week));
            V.this.f14969L.f17672i.setText(BuildConfig.FLAVOR);
            V.this.f14969L.f17668e.b().setTime(statsDataSet.getUsingTime());
            z2.d dVar = new z2.d(statsDataSet);
            TextView textView = V.this.f14969L.f17667d;
            Context context = V.this.f14975D;
            textView.setText(context.getString(R.string.us_usage_day_average, C0711p.m(context, (long) dVar.d())));
        }

        @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a.AbstractC0183a
        public PageIndicator d() {
            return (PageIndicator) this.itemView.findViewById(R.id.horizontalPageIndicator);
        }

        @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a.AbstractC0183a
        public ViewPager2 e() {
            return (ViewPager2) this.itemView.findViewById(R.id.view_pager);
        }
    }

    public V(Context context, D2.r<String, Drawable> rVar) {
        super(context, rVar);
        this.f14968K = 1;
    }

    private void b0(int i5) {
        boolean z5 = this.f14968K != i5;
        this.f14968K = i5;
        if (z5) {
            Q();
        }
        this.f15001t = p();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(HistogramView histogramView, boolean z5, int i5, Object obj) {
        MyRecyclerView myRecyclerView = this.f14978G;
        if (myRecyclerView != null) {
            myRecyclerView.setScrollable(!z5);
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected View A(Context context, ViewGroup viewGroup, int i5) {
        return i5 == 10 ? LayoutInflater.from(context).inflate(R.layout.us_categories_info_container_item, viewGroup, false) : super.A(context, viewGroup, i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected RecyclerView.ViewHolder B(View view, int i5) {
        return super.B(view, i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected AbstractViewOnTouchListenerC0592a.AbstractC0183a C(View view) {
        return new a(view);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.a> F() {
        return this.f14974C.n(com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal(), this.f14968K);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.b> J() {
        return this.f14974C.m(com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal(), this.f14968K);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.c> K() {
        return this.f14974C.o(com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal(), this.f14968K);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected StatsDataSet L() {
        int i5;
        StatsDataSet[] statsDataSetArrM = M();
        if (statsDataSetArrM == null || (i5 = this.f14968K) < 0 || i5 >= statsDataSetArrM.length) {
            return null;
        }
        return statsDataSetArrM[i5];
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected void P(int i5) {
        super.P(i5);
        b0(i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (i5 == this.f15000s) {
            return 10;
        }
        return super.getItemViewType(i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a, com.stepos.familyguard.ui.usage.AbstractC0597f.b
    public void h(int i5, int i6, Object obj) {
        if (i6 != -1) {
            this.f14969L.f17670g.setVisibility(4);
        } else {
            this.f14969L.f17670g.setVisibility(0);
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a, stepos.support.v7.widget.StepOSRecyclerView.c
    public int immersiveItemType(int i5) {
        if (getItemViewType(i5) == 10) {
            return 2;
        }
        return super.immersiveItemType(i5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a, x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
        StatsDataSet statsDataSetL;
        super.onBindViewHolder(viewHolder, i5);
        if (!(viewHolder instanceof AbstractViewOnTouchListenerC0592a.b) || (statsDataSetL = L()) == null) {
            return;
        }
        ((AbstractViewOnTouchListenerC0592a.b) viewHolder).a(new z2.d(statsDataSetL));
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected int v(int i5) {
        this.f15000s = i5 + 1;
        return i5 + 2;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected View x(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f14975D).inflate(R.layout.us_view_pager, viewGroup, false);
        T1.g.c(1.18f, (TextView) viewInflate.findViewById(R.id.des));
        T1.g.e(1.18f, (ViewGroup) viewInflate.findViewById(R.id.digit_container));
        T1.g.e(1.18f, (ViewGroup) viewInflate.findViewById(R.id.date_container));
        return viewInflate;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected AbstractC0597f y(Context context, AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592a) {
        return new C0613w(context, abstractViewOnTouchListenerC0592a);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected View z(LayoutInflater layoutInflater, ViewGroup viewGroup, int i5) {
        int i6;
        int i7;
        if (i5 != 6) {
            i6 = R.layout.us_week_pickup_histogram;
            i7 = 1;
        } else {
            i6 = R.layout.us_week_notify_histogram;
            i7 = 2;
        }
        View viewInflate = layoutInflater.inflate(i6, viewGroup, false);
        HistogramView histogramView = (HistogramView) viewInflate.findViewById(R.id.day_histogram_view);
        new A2.H(i7).a(histogramView);
        histogramView.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: w2.G1
            @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
            public final void a(HistogramView histogramView2, boolean z5, int i8, Object obj) {
                this.f23563a.c0(histogramView2, z5, i8, obj);
            }
        });
        histogramView.setChartLayerFactory(new C1320a(i5));
        return viewInflate;
    }
}
