package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.larus.nova.R;
import ue4.b;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayTextLoadingView extends FrameLayout {
    private boolean isShow;
    private TTCJPayLoadingAdapter mAdapter;
    private Object mAdapterView;
    private View mDefaultLoadingLayout;
    private TextView mDefaultLoadingText;
    private View mDefaultLoadingView;
    private String messageInfo;

    public void hide() {
        this.isShow = false;
        TTCJPayLoadingAdapter r100 = this.mAdapter;
        if (r100 == null) goto L8;
        Object r101 = this.mAdapterView;
        if (r101 == null) goto L8;
        r100.onHide(r101);
        return;
    L8:
        View r102 = this.mDefaultLoadingView;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        View r103 = this.mDefaultLoadingLayout;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        setPayMessage("");
    }

    public void show() {
        show(true);
    }

    public boolean isShow() {
        return this.isShow;
    }

    public CJPayTextLoadingView(Context r100) {
        this(r100, null);
    }

    public void setPayMessage(String r100) {
        this.messageInfo = r100;
    }

    public void show(boolean r100) {
        this.isShow = true;
        if (this.mAdapter != null) goto L5;
    L30:
        View r101 = this.mDefaultLoadingView;
        if (r101 == null) goto L33;
        r101.setVisibility(0);
    L33:
        View r102 = this.mDefaultLoadingLayout;
        if (r102 == null) goto L37;
        r102.setVisibility(0);
    L37:
        if (this.mDefaultLoadingText != null) goto L39;
        return;
    L39:
        if (TextUtils.isEmpty(this.messageInfo) == true) goto L41;
        this.mDefaultLoadingText.setText(this.messageInfo);
        return;
    L41:
        this.mDefaultLoadingText.setText(R.string.cj_pay_h5_loading_tip);
        return;
    L5:
        if (this.mAdapterView == null) goto L30;
        if (TextUtils.isEmpty(this.messageInfo) == false) goto L9;
    L28:
        this.mAdapter.onShow(this.mAdapterView);
        this.mAdapter.textAndBackgroundVisible(this.mAdapterView, r100);
        return;
    L9:
        if (getContext() == null) goto L28;
        TTCJPayLoadingAdapter r103 = this.mAdapter;
        Context r104 = getContext();
        if (TextUtils.isEmpty(this.messageInfo) == true) goto L13;
        String r105 = this.messageInfo;
    L14:
        Object r106 = r103.initLoadingView(r104, r105);
        this.mAdapterView = r106;
        LinearLayout r107 = (LinearLayout) ((FrameLayout) ((RelativeLayout) ((View) r106).getRootView()).getChildAt(0)).getChildAt(0);     // Catch: Exception -> L20
        r107.setMinimumWidth(CJPayBasicUtils.dipToPX(getContext(), 85.0f));     // Catch: Exception -> L20
        r107.setMinimumHeight(CJPayBasicUtils.dipToPX(getContext(), 85.0f));     // Catch: Exception -> L20
        r107.setGravity(17);     // Catch: Exception -> L20
        r107.setPadding(CJPayBasicUtils.dipToPX(getContext(), 16.0f), 0, CJPayBasicUtils.dipToPX(getContext(), 16.0f), 0);     // Catch: Exception -> L20
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107.getLayoutParams();     // Catch: Exception -> L20
        r108.width = -2;     // Catch: Exception -> L20
        r108.height = CJPayBasicUtils.dipToPX(getContext(), 85.0f);     // Catch: Exception -> L20
        removeAllViews();     // Catch: Exception -> L20
        Object r109 = this.mAdapterView;     // Catch: Exception -> L20
        if ((r109 instanceof View) == false) goto L18;
        addView((View) r109);     // Catch: Exception -> L20
    L18:
        invalidate();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTextLoadingView#show", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTextLoadingView#show", e);
        TTCJPayLoadingAdapter r110 = this.mAdapter;
        Context r111 = getContext();
        if (TextUtils.isEmpty(this.messageInfo) == true) goto L24;
        String r112 = this.messageInfo;
    L25:
        Object r113 = r110.initLoadingView(r111, r112);
        this.mAdapterView = r113;
        if ((r113 instanceof View) == false) goto L28;
        addView((View) r113);
        goto L28
    L24:
        r112 = getContext().getString(R.string.cj_pay_h5_loading_tip);
        goto L25
    L13:
        r105 = getContext().getString(R.string.cj_pay_h5_loading_tip);
        goto L14
    }

    public CJPayTextLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void init(Context r100, AttributeSet r101) {
        TTCJPayLoadingAdapter<? extends Object> r102 = CJEnv.f().hostLoadingAdapter();
        this.mAdapter = r102;
        if (r102 == null) goto L10;
        Object r103 = r102.initLoadingView(r100, b.f(r100, R.string.cj_pay_h5_loading_tip));
        this.mAdapterView = r103;
        if ((r103 instanceof View) == false) goto L14;
        if (r101 != null) goto L8;
        addView((View) r103, new FrameLayout.LayoutParams(-1, -1));
        return;
    L8:
        addView((View) r103, generateLayoutParams(r101));
        return;
    L14:
        return;
    L10:
        View r104 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_text_loading_layout, this);
        this.mDefaultLoadingView = r104;
        if (r104 == null) goto L16;
        this.mDefaultLoadingLayout = r104.findViewById(R.id.cj_pay_text_loading_layout);
        this.mDefaultLoadingText = (TextView) this.mDefaultLoadingView.findViewById(R.id.tv_loading_text);
        return;
    }

    public CJPayTextLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.messageInfo = "";
        init(r100, r101);
    }
}
