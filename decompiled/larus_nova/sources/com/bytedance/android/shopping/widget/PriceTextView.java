package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes14.dex */
public class PriceTextView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f187223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f187224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f187225c;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f187223a = new TextView(getContext());
        this.f187224b = new TextView(getContext());
        this.f187225c = new TextView(getContext());
        addView(this.f187223a);
        addView(this.f187224b);
        addView(this.f187225c);
        setOrientation(0);
    }

    public PriceTextView(Context r100) {
        super(r100);
    }

    public PriceTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
