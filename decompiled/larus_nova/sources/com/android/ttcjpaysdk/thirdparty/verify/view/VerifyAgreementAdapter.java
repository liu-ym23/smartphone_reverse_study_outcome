package com.android.ttcjpaysdk.thirdparty.verify.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserAgreement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class VerifyAgreementAdapter extends BaseAdapter {
    private Context mContext;
    private List<CJPayUserAgreement> mData;
    private boolean mHasAgreeButton;
    private LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int r100, String r101, String r102);
    }

    public class ViewHolder {
        RelativeLayout agreementDescLayout;
        TextView agreementDescView;
        final /* synthetic */ VerifyAgreementAdapter this$0;

        private ViewHolder(VerifyAgreementAdapter r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ ViewHolder(VerifyAgreementAdapter r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CJPayUserAgreement> r100 = this.mData;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public static /* synthetic */ OnItemClickListener access$100(VerifyAgreementAdapter r100) {
        return r100.mOnItemClickListener;
    }

    public void dataChangedNotify(List<CJPayUserAgreement> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L9;
        this.mData.clear();
        this.mData.addAll(r100);
        notifyDataSetChanged();
        return;
    }

    @Override // android.widget.Adapter
    public CJPayUserAgreement getItem(int r100) {
        return (CJPayUserAgreement) ListProtector.get(this.mData, r100);
    }

    public void setOnItemClickListener(OnItemClickListener r100) {
        this.mOnItemClickListener = r100;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r100) {
        return getItem(r100);
    }

    public VerifyAgreementAdapter(Context r100, boolean r101) {
        this.mData = new ArrayList();
        this.mContext = r100;
        this.mHasAgreeButton = r101;
        this.mInflater = LayoutInflater.from(r100);
    }

    @Override // android.widget.Adapter
    public View getView(final int r100, View r101, ViewGroup r102) {
        final CJPayUserAgreement r103 = getItem(r100);
        if (r101 != null) goto L5;
        r101 = this.mInflater.inflate(R.layout.cj_pay_item_verify_agreement_layout, null);
        ViewHolder r104 = new ViewHolder(this, null);
        r104.agreementDescLayout = (RelativeLayout) r101.findViewById(R.id.cj_pay_agreement_layout);
        TextView r105 = (TextView) r101.findViewById(R.id.cj_pay_agreement_desc);
        r104.agreementDescView = r105;
        r105.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r104.agreementDescView.setSingleLine();
        r104.agreementDescView.setMaxWidth(CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this.mContext) - CJPayBasicUtils.dipToPX(this.mContext, 66.0f));
        r101.setTag(r104);
    L7:
        if (TextUtils.isEmpty(r103.title) == true) goto L10;
        r104.agreementDescView.setText(r103.title);
    L10:
        if (TextUtils.isEmpty(r103.content_url) == true) goto L12;
        r104.agreementDescLayout.setOnClickListener(new AnonymousClass1(this, r100, r103));
    L12:
        return r101;
    L5:
        r104 = (ViewHolder) r101.getTag();
        goto L7
    }
}
