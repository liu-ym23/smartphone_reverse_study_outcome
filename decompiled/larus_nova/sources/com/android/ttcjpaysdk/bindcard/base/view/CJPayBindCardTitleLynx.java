package com.android.ttcjpaysdk.bindcard.base.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayBindCardTitleLynx;", "Lcom/android/ttcjpaysdk/bindcard/base/view/CJPayBindCardTitle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getLayoutId", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardTitleLynx extends CJPayBindCardTitle {
    @Override // com.android.ttcjpaysdk.bindcard.base.view.CJPayBindCardTitle
    public int getLayoutId() {
        return R.layout.cj_pay_bind_card_title_layout_lynx;
    }

    public CJPayBindCardTitleLynx(Context r100) {
        super(r100);
    }

    public CJPayBindCardTitleLynx(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
