package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import w2.AbstractC1231i0;
import y2.C1320a;

/* renamed from: com.stepos.familyguard.ui.usage.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0612v extends AbstractC1231i0 {
    public C0612v(Context context, long j5) {
        super(context, j5);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView e0(Context context, ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(context).inflate(R.layout.us_week_usage_histogram_legacy, viewGroup, false);
        new A2.I(0).a(histogramView);
        histogramView.setChartLayerFactory(new C1320a(24));
        return histogramView;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder f0(View view) {
        return new K(view);
    }
}
