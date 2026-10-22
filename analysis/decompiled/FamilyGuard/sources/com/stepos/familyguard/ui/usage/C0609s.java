package com.stepos.familyguard.ui.usage;

import A2.C0270i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import j2.C0783F;
import java.util.List;
import y2.C1320a;

/* renamed from: com.stepos.familyguard.ui.usage.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0609s extends AbstractViewOnTouchListenerC0592a {

    /* renamed from: com.stepos.familyguard.ui.usage.s$a */
    public class a extends AbstractViewOnTouchListenerC0592a.AbstractC0183a {

        /* renamed from: c, reason: collision with root package name */
        private final C0783F f15151c;

        public a(View view) {
            super(view);
            this.f15151c = C0783F.a(view);
        }

        @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a.AbstractC0183a
        public void c(StatsDataSet statsDataSet) throws Resources.NotFoundException {
            this.f15151c.f17653b.setText(C0711p.i(C0609s.this.f14975D, statsDataSet.getStartTime()));
            this.f15151c.f17659h.setText(C0711p.u(C0609s.this.f14975D, statsDataSet.getStartTime()));
            this.f15151c.f17656e.b().setTime(statsDataSet.getUsingTime());
            TextView textView = this.f15151c.f17655d;
            Context context = C0609s.this.f14975D;
            textView.setText(context.getString(R.string.us_longest_used, C0711p.m(context, statsDataSet.getLongestUseTime())));
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

    public C0609s(Context context, D2.r<String, Drawable> rVar) {
        super(context, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(HistogramView histogramView, boolean z5, int i5, Object obj) {
        MyRecyclerView myRecyclerView = this.f14978G;
        if (myRecyclerView != null) {
            myRecyclerView.setScrollable(!z5);
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected AbstractViewOnTouchListenerC0592a.AbstractC0183a C(View view) {
        return new a(view);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.a> F() {
        return this.f14974C.n(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), Z());
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.b> J() {
        return this.f14974C.m(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), Z());
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected List<U.c> K() {
        return this.f14974C.o(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), Z());
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected StatsDataSet L() {
        int i5;
        StatsDataSet statsDataSet;
        int i6;
        StatsDataSet[] statsDataSetArrM = M();
        if (statsDataSetArrM == null || (i5 = this.f15006y) < 0 || i5 >= statsDataSetArrM.length || (statsDataSet = statsDataSetArrM[i5]) == null || statsDataSet.getChildren() == null || (i6 = this.f15007z) < 0 || i6 >= statsDataSet.getChildren().length) {
            return null;
        }
        return statsDataSet.getChildren()[this.f15007z];
    }

    protected int Z() {
        int i5 = this.f15006y;
        int i6 = this.f15007z;
        return i5 == 0 ? i6 : i6 + 7;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (i5 == this.f15000s) {
            return 10;
        }
        return super.getItemViewType(i5);
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
        this.f14997p = i5 + 1;
        this.f15000s = i5 + 2;
        return i5 + 3;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected View x(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f14975D).inflate(R.layout.us_selectable_view_pager, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.des);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.digit_container);
        T1.g.c(1.18f, textView);
        T1.g.e(1.18f, viewGroup2);
        return viewInflate;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected AbstractC0597f y(Context context, AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592a) {
        return new I(context, abstractViewOnTouchListenerC0592a);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0592a
    protected View z(LayoutInflater layoutInflater, ViewGroup viewGroup, int i5) {
        View viewInflate = layoutInflater.inflate(i5 != 4 ? i5 != 6 ? R.layout.us_day_pickup_histogram : R.layout.us_day_notify_histogram : R.layout.us_day_usage_histogram, viewGroup, false);
        HistogramView histogramView = (HistogramView) viewInflate.findViewById(R.id.day_histogram_view);
        new C0270i().a(histogramView);
        histogramView.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: w2.x
            @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
            public final void a(HistogramView histogramView2, boolean z5, int i6, Object obj) {
                this.f23682a.a0(histogramView2, z5, i6, obj);
            }
        });
        if (i5 == 4) {
            histogramView.setChartLayerFactory(new C1320a(i5, (FrameLayout) ((ViewGroup) viewGroup.getParent()).findViewById(R.id.balloonFrame)));
            return viewInflate;
        }
        histogramView.setChartLayerFactory(new C1320a(i5));
        return viewInflate;
    }
}
