package com.bytedance.android.shopping.widget.buybutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f187307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f187308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f187309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f187310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f187311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f187312f;

    public final TextView getBuyText() {
        return this.f187309c;
    }

    public final View getBuyTextContainer() {
        return this.f187308b;
    }

    public final View getProductButtonContainer() {
        return this.f187307a;
    }

    public final TextView getSubBuyText() {
        return this.f187310d;
    }

    public final View getSubBuyTextContainer() {
        return this.f187311e;
    }

    public final View getTriangleView() {
        return this.f187312f;
    }

    public final void setBuyText(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187309c = r100;
    }

    public final void setBuyTextContainer(View r100) {
        this.f187308b = r100;
    }

    public final void setProductButtonContainer(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187307a = r100;
    }

    public final void setSubBuyText(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187310d = r100;
    }

    public final void setSubBuyTextContainer(View r100) {
        this.f187311e = r100;
    }

    public final void setTriangleView(View r100) {
        this.f187312f = r100;
    }

    public j(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        if (r101 == false) goto L5;
        LayoutInflater.from(r100).inflate(R.layout.shopping_match_purchase_click_single_button, this);
    L6:
        View r102 = findViewById(R.id.product_buy_container);
        this.f187307a = r102;
        if (r101 == false) goto L9;
        int r103 = g1.f45599a;
        r102.setBackgroundColor(g1.a.a(r100, R.color.shopping_match_purchase_activity_bg_end));
    L9:
        this.f187308b = findViewById(R.id.fl_buy_text_container);
        this.f187309c = (TextView) findViewById(R.id.tv_buy_text);
        this.f187310d = (TextView) findViewById(R.id.tv_buy_sub_text);
        this.f187311e = findViewById(R.id.fl_buy_sub_text_container);
        this.f187312f = findViewById(R.id.triangle);
        return;
    L5:
        LayoutInflater.from(r100).inflate(R.layout.shopping_click_single_button, this);
        goto L6
    }
}
