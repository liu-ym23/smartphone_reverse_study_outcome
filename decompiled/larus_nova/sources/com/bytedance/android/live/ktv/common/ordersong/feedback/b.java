package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvFeedbackDialog f70162a;

    public b(KtvFeedbackDialog r100) {
        this.f70162a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((TextView) this.f70162a.X90(R.id.tv_feedback_exhibition)).setVisibility(4);
        ((LinearLayout) this.f70162a.X90(R.id.feedback_container)).setVisibility(0);
    }
}
