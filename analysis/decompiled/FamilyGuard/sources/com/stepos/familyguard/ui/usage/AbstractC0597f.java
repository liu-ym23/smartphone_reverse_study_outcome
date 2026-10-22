package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* renamed from: com.stepos.familyguard.ui.usage.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0597f extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    protected Context f15022a;

    /* renamed from: b, reason: collision with root package name */
    protected StatsDataSet[] f15023b;

    /* renamed from: c, reason: collision with root package name */
    protected c f15024c;

    /* renamed from: d, reason: collision with root package name */
    protected b f15025d;

    /* renamed from: e, reason: collision with root package name */
    protected A2.H f15026e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f15027f;

    /* renamed from: g, reason: collision with root package name */
    private int f15028g;

    /* renamed from: h, reason: collision with root package name */
    private int f15029h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.stepos.familyguard.ui.usage.f$a */
    static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public HistogramView f15030a;

        /* renamed from: b, reason: collision with root package name */
        public c f15031b;

        /* renamed from: c, reason: collision with root package name */
        public b f15032c;

        public a(View view, c cVar, b bVar) {
            super(view);
            this.f15030a = (HistogramView) view;
            this.f15031b = cVar;
            this.f15032c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i5, HistogramView histogramView, int i6, Object obj) {
            c cVar = this.f15031b;
            if (cVar != null) {
                cVar.i(i5, i6, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i5, HistogramView histogramView, boolean z5, int i6, Object obj) {
            this.f15032c.h(i5, i6, obj);
        }

        void c(StatsDataSet statsDataSet, A2.H h5, final int i5, int i6, int i7, boolean z5) {
            z2.d dVar = new z2.d(statsDataSet);
            int iC = h5.c(dVar);
            h5.b(this.f15030a, dVar);
            if (i5 != i6) {
                this.f15030a.p();
            } else if (z5) {
                this.f15030a.setSelectedIndex(i7);
            } else {
                this.f15030a.setSelectedIndex(iC);
            }
            if (this.f15030a.o()) {
                this.f15030a.setOnHistogramSelectedChangedListener(new HistogramView.c() { // from class: com.stepos.familyguard.ui.usage.d
                    @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.c
                    public final void a(HistogramView histogramView, int i8, Object obj) {
                        this.f15018a.d(i5, histogramView, i8, obj);
                    }
                });
            } else if (this.f15030a.m()) {
                this.f15030a.setOnHistogramHoveredChangedListener(new HistogramView.b() { // from class: com.stepos.familyguard.ui.usage.e
                    @Override // com.stepos.familyguard.ui.widget.chart.histogram.HistogramView.b
                    public final void a(HistogramView histogramView, boolean z6, int i8, Object obj) {
                        this.f15020a.e(i5, histogramView, z6, i8, obj);
                    }
                });
            }
        }
    }

    /* renamed from: com.stepos.familyguard.ui.usage.f$b */
    public interface b {
        void h(int i5, int i6, Object obj);
    }

    /* renamed from: com.stepos.familyguard.ui.usage.f$c */
    public interface c {
        void i(int i5, int i6, Object obj);
    }

    public AbstractC0597f(Context context, c cVar) {
        this(context, cVar, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }

    protected abstract HistogramView j(ViewGroup viewGroup);

    protected void k(int i5, int i6, Object obj) {
        b bVar = this.f15025d;
        if (bVar != null) {
            bVar.h(i5, i6, obj);
        }
    }

    protected void l(int i5, int i6, Object obj) {
        this.f15027f = true;
        this.f15028g = i5;
        this.f15029h = i6;
        c cVar = this.f15024c;
        if (cVar != null) {
            cVar.i(i5, i6, obj);
        }
    }

    public void n() {
        this.f15027f = false;
        this.f15028g = 1;
        this.f15029h = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).c(this.f15023b[i5], this.f15026e, i5, this.f15028g, this.f15029h, this.f15027f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new a(j(viewGroup), new c() { // from class: com.stepos.familyguard.ui.usage.b
            @Override // com.stepos.familyguard.ui.usage.AbstractC0597f.c
            public final void i(int i6, int i7, Object obj) {
                this.f15016a.l(i6, i7, obj);
            }
        }, new b() { // from class: com.stepos.familyguard.ui.usage.c
            @Override // com.stepos.familyguard.ui.usage.AbstractC0597f.b
            public final void h(int i6, int i7, Object obj) {
                this.f15017a.k(i6, i7, obj);
            }
        });
    }

    public void p(StatsDataSet[] statsDataSetArr) {
        this.f15023b = statsDataSetArr;
        notifyItemRangeChanged(0, 2);
    }

    public AbstractC0597f(Context context, b bVar) {
        this(context, null, bVar);
    }

    public AbstractC0597f(Context context, c cVar, b bVar) {
        this.f15026e = new A2.H(0);
        this.f15027f = false;
        this.f15028g = 1;
        this.f15029h = 1;
        this.f15022a = context;
        this.f15024c = cVar;
        this.f15025d = bVar;
    }
}
