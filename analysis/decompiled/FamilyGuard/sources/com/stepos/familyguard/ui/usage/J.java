package com.stepos.familyguard.ui.usage;

import A2.C0270i;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import y2.C1320a;

/* loaded from: classes.dex */
public class J extends AbstractViewOnTouchListenerC0600i {
    public J(Context context) {
        super(context);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView a0(Context context, ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(context).inflate(R.layout.us_day_notify_histogram_legacy, viewGroup, false);
        new C0270i().a(histogramView);
        histogramView.setChartLayerFactory(new C1320a(26));
        return histogramView;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder b0(View view) {
        return new B(view);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView c0(Context context, ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(context).inflate(R.layout.us_day_pickup_histogram_legacy, viewGroup, false);
        new C0270i().a(histogramView);
        histogramView.setChartLayerFactory(new C1320a(25));
        return histogramView;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder d0(View view) {
        return new H(view);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected HistogramView e0(Context context, ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(context).inflate(R.layout.us_day_usage_histogram_legacy, viewGroup, false);
        new C0270i().a(histogramView);
        histogramView.setChartLayerFactory(new C1320a(24));
        return histogramView;
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i
    protected RecyclerView.ViewHolder f0(View view) {
        return new K(view);
    }
}
