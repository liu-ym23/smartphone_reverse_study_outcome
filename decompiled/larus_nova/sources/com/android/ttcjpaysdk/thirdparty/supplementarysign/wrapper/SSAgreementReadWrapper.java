package com.android.ttcjpaysdk.thirdparty.supplementarysign.wrapper;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.theme.widget.CJPaySquareCheckBox;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserAgreement;
import com.android.ttcjpaysdk.thirdparty.utils.CJPayStyleUtils;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SSAgreementReadWrapper extends BaseWrapper {
    private List<CJPayUserAgreement> mAgreements;
    private String mCustomText;
    private CJPaySquareCheckBox mIvAgreementCheckbox;
    private boolean mNeedCheckBox;
    private OnActionListener mOnActionListener;
    private TextView mTvAgreementContent;

    public interface OnActionListener {
        void onAgreementClick();

        void onCheckStatusChanged(boolean r100);
    }

    private void initAgreementContent() {
        List<CJPayUserAgreement> r100 = this.mAgreements;
        if (r100 != null) goto L5;
    L6:
        this.mTvAgreementContent.setVisibility(8);
    L7:
        this.mTvAgreementContent.setOnClickListener(new AnonymousClass2(this));
        String r101 = getContext().getString(R.string.cj_pay_ss_read_and_agree);
        if (this.mNeedCheckBox == true) goto L11;
        r101 = getContext().getString(R.string.cj_pay_ss_read);
    L11:
        if (TextUtils.isEmpty(this.mCustomText) == true) goto L13;
        r101 = this.mCustomText;
    L13:
        SpannableStringBuilder r102 = new SpannableStringBuilder(r101);
        Iterator<CJPayUserAgreement> r103 = this.mAgreements.iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        CJPayUserAgreement r104 = r103.next();
        int r105 = r102.length();
        r102.append(r104.title);
        r102.setSpan(new ForegroundColorSpan(CJPayStyleUtils.getAgreementColorFromSettings(getContext())), r105, r102.length(), 17);
        goto L15
    L17:
        this.mTvAgreementContent.setText(r102);
        return;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L6
    }

    public void checkAgreement() {
        this.mIvAgreementCheckbox.setChecked(true);
    }

    public boolean isChecked() {
        return this.mIvAgreementCheckbox.isChecked();
    }

    private void initCheckBox() {
        checkAgreement();
        this.mIvAgreementCheckbox.setOnCheckedChangeListener(new AnonymousClass1(this));
        if (this.mNeedCheckBox == true) goto L6;
        this.mIvAgreementCheckbox.setVisibility(8);
        this.mTvAgreementContent.setPadding(CJPayBasicUtils.dipToPX(getContext(), 8.0f), this.mTvAgreementContent.getPaddingTop(), this.mTvAgreementContent.getPaddingRight(), this.mTvAgreementContent.getPaddingBottom());
        return;
    }

    public static /* synthetic */ OnActionListener access$000(SSAgreementReadWrapper r100) {
        return r100.mOnActionListener;
    }

    public void setOnActionListener(OnActionListener r100) {
        this.mOnActionListener = r100;
    }

    public SSAgreementReadWrapper(View r100, List<CJPayUserAgreement> r101, String r102, boolean r103) {
        super(r100);
        this.mAgreements = r101;
        this.mCustomText = r102;
        this.mNeedCheckBox = r103;
        this.mIvAgreementCheckbox = (CJPaySquareCheckBox) r100.findViewById(R.id.cj_pay_ss_agreement_checkbox);
        this.mTvAgreementContent = (TextView) r100.findViewById(R.id.cj_pay_ss_agreement_content);
        initCheckBox();
        initAgreementContent();
    }
}
