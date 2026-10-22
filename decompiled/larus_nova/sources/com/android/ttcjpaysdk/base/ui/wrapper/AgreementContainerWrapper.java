package com.android.ttcjpaysdk.base.ui.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class AgreementContainerWrapper extends BaseWrapper {
    public TextView mAgreementCheckboxBgView;
    public FrameLayout mAgreementCheckboxLayout;
    public ImageView mAgreementCheckboxView;
    public TextView mAgreementContentView;
    public TextView mAgreementTipView;
    private final boolean mIsHideCheckboxView;

    private void initAction() {
        FrameLayout r100 = this.mAgreementCheckboxLayout;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new AnonymousClass1(this));
    L5:
        TextView r101 = this.mAgreementTipView;
        if (r101 == null) goto L9;
        r101.setOnClickListener(new AnonymousClass2(this));
        return;
    }

    private void bindViews(View r100) {
        this.mAgreementCheckboxLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_checkbox_layout);
        this.mAgreementCheckboxView = (ImageView) r100.findViewById(R.id.cj_pay_checkbox);
        this.mAgreementCheckboxBgView = (TextView) r100.findViewById(R.id.cj_pay_checkbox_bg);
        this.mAgreementTipView = (TextView) r100.findViewById(R.id.cj_pay_checkbox_tip);
        this.mAgreementContentView = (TextView) r100.findViewById(R.id.cj_pay_checkbox_notice);
        this.mAgreementCheckboxView.setTag(Integer.valueOf(this.mIsHideCheckboxView ? 1 : 0));
        this.mAgreementContentView.setSingleLine();
        this.mAgreementContentView.setEllipsize(TextUtils.TruncateAt.END);
        TextView r101 = this.mAgreementContentView;
        int r102 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(getContext());
        Context r103 = getContext();
        if (this.mIsHideCheckboxView == false) goto L5;
        float r104 = 187.0f;
    L6:
        r101.setMaxWidth(r102 - CJPayBasicUtils.dipToPX(r103, r104));
        FrameLayout r105 = this.mAgreementCheckboxLayout;
        if (this.mIsHideCheckboxView == false) goto L9;
        int r106 = 8;
    L10:
        r105.setVisibility(r106);
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = 167.0f;
        goto L6
    }

    public void setJumpClickListener(View.OnClickListener r100) {
        if (r100 == null) goto L8;
        TextView r101 = this.mAgreementContentView;
        if (r101 == null) goto L9;
        r101.setOnClickListener(r100);
        return;
    L9:
        return;
    }

    public void setSelectedStatus(boolean r100) {
        ImageView r101 = this.mAgreementCheckboxView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mAgreementCheckboxBgView != null) goto L7;
        return;
    L7:
        if (this.mIsHideCheckboxView == true) goto L21;
        r101.setTag(Integer.valueOf(r100 ? 1 : 0));
        TextView r102 = this.mAgreementCheckboxBgView;
        if (r100 == false) goto L12;
        int r103 = 0;
    L13:
        r102.setVisibility(r103);
        ImageView r104 = this.mAgreementCheckboxView;
        if (r100 == false) goto L16;
        int r105 = R.drawable.cj_pay_icon_agreement_check_box_pressed;
    L17:
        r104.setImageResource(r105);
        return;
    L16:
        r105 = R.drawable.cj_pay_icon_agreement_check_box_normal;
        goto L17
    L12:
        r103 = 8;
        goto L13
    }

    public AgreementContainerWrapper(View r100, boolean r101) {
        super(r100);
        this.mIsHideCheckboxView = r101;
        bindViews(r100);
        initAction();
    }
}
