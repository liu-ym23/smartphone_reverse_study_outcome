package com.android.ttcjpaysdk.thirdparty.agreement.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAgreementAdapter extends BaseAdapter {
    private Context context;
    private List<CJPayCardProtocolBean> data;
    private boolean hasAgreeButton;
    private LayoutInflater inflater;

    public class ViewHolder {
        ConstraintLayout agreementDescLayout;
        TextView agreementDescView;
        final /* synthetic */ CJPayAgreementAdapter this$0;

        private ViewHolder(CJPayAgreementAdapter r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ ViewHolder(CJPayAgreementAdapter r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CJPayCardProtocolBean> r100 = this.data;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public static /* synthetic */ Context access$100(CJPayAgreementAdapter r100) {
        return r100.context;
    }

    public void dataChangedNotify(List<CJPayCardProtocolBean> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L9;
        this.data.clear();
        this.data.addAll(r100);
        notifyDataSetChanged();
        return;
    }

    @Override // android.widget.Adapter
    public CJPayCardProtocolBean getItem(int r100) {
        return (CJPayCardProtocolBean) ListProtector.get(this.data, r100);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r100) {
        return getItem(r100);
    }

    public CJPayAgreementAdapter(Context r100, boolean r101) {
        this.data = new ArrayList();
        this.context = r100;
        this.hasAgreeButton = r101;
        this.inflater = LayoutInflater.from(r100);
    }

    @Override // android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        final CJPayCardProtocolBean r103 = getItem(r100);
        if (r101 != null) goto L5;
        r101 = this.inflater.inflate(R.layout.cj_pay_item_bdpay_agreement_layout, null);
        ViewHolder r104 = new ViewHolder(this, null);
        r104.agreementDescLayout = (ConstraintLayout) r101.findViewById(R.id.cj_pay_agreement_layout);
        r104.agreementDescView = (TextView) r101.findViewById(R.id.cj_pay_agreement_desc);
        r101.setTag(r104);
    L7:
        if (TextUtils.isEmpty(r103.name) == true) goto L10;
        r104.agreementDescView.setText(r103.name);
    L10:
        if (getCount() > 1) goto L12;
        r104.agreementDescLayout.setBackgroundResource(R.drawable.cj_pay_bg_card_container);
    L19:
        if (TextUtils.isEmpty(r103.template_url) == true) goto L21;
        r104.agreementDescLayout.setOnClickListener(new AnonymousClass1(this, r103));
    L21:
        return r101;
    L12:
        if (r100 != 0) goto L15;
        r104.agreementDescLayout.setBackgroundResource(R.drawable.cj_pay_bg_card_item_top);
        goto L19
    L15:
        if (r100 != (getCount() - 1)) goto L17;
        r104.agreementDescLayout.setBackgroundResource(R.drawable.cj_pay_bg_card_item_bottom);
        goto L19
    L17:
        r104.agreementDescLayout.setBackgroundResource(R.drawable.cj_pay_bg_card_item_middle);
        goto L19
    L5:
        r104 = (ViewHolder) r101.getTag();
        goto L7
    }
}
