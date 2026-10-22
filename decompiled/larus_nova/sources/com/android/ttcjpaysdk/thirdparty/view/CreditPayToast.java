package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class CreditPayToast {
    private Context context;
    private TextView exceptionRecommendView;
    private TextView exceptionResultView;
    private Toast toast;

    public void initToast() {
        if (this.toast != null) goto L10;
        this.toast = new Toast(this.context);
        View r100 = LayoutInflater.from(this.context).inflate(R.layout.cj_pay_activity_h5_activate_layout, null, false);
        r100.findViewById(R.id.cj_pay_activity_h5_activate_exception_view).setVisibility(0);
        this.exceptionResultView = (TextView) r100.findViewById(R.id.cj_pay_activity_h5_activate_exception_result);
        this.exceptionRecommendView = (TextView) r100.findViewById(R.id.cj_pay_activity_h5_activate_exception_recommend);
        int r101 = ((CJPayBasicUtils.getScreenHeight(this.context) - CJPayBasicUtils.dipToPX(this.context, 122.0f)) - CJPayBasicUtils.getStatusBarHeight(this.context)) / 2;
        if (r101 <= 0) goto L7;
        this.toast.setGravity(49, 0, r101);
    L8:
        this.toast.setView(r100);
        return;
    L7:
        this.toast.setGravity(17, 0, 0);
        goto L8
    }

    public void show() {
        this.toast.show();
    }

    public CreditPayToast(Context r100) {
        this.toast = null;
        this.context = r100;
    }

    public void setRecommend(String r100) {
        this.exceptionRecommendView.setText(r100);
    }

    public void setResult(String r100) {
        this.exceptionResultView.setText(r100);
    }

    public void setShowTime(int r100) {
        this.toast.setDuration(r100);
    }
}
