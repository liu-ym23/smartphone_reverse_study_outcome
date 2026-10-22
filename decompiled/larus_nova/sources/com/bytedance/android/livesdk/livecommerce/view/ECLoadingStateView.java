package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.StatusDegradeView;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.core.widget.j;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECLoadingStateView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f153165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f153166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f153167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECHostNetErrorLayout f153168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f153169e;

    public ECLoadingStateView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        setOrientation(1);
        setGravity(17);
        View.inflate(r100, R.layout.ec_layout_loading_status, this);
        this.f153166b = (TextView) findViewById(R.id.tv_status_text);
        this.f153168d = (ECHostNetErrorLayout) findViewById(R.id.ecnel_net_error);
        this.f153167c = (LinearLayout) findViewById(R.id.ll_tv_container);
        ECLiveDegradeHelper.f153042c.getClass();
        if (ECLiveDegradeHelper.a("promotion_list_loading_degrade", ECLiveDegradeHelper.b().getEnablePromotionListLoadingDegrade()) != 1) goto L5;
        StatusDegradeView r101 = (StatusDegradeView) findViewById(R.id.sv_loading_degrade);
        r101.setVisibility(0);
        this.f153169e = r101;
        return;
    L5:
        StatusView r102 = (StatusView) findViewById(R.id.sv_loading);
        r102.setVisibility(0);
        this.f153169e = r102;
    }

    public void setRetryClickListener(View.OnClickListener r100) {
        this.f153165a = r100;
        this.f153168d.setRetryClickListener(r100);
    }

    public ECLoadingStateView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public ECLoadingStateView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
