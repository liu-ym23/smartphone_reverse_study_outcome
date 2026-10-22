package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0006H&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/AbsCJPayOFullScreenWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "closeAddiSwitch", "", "getExtTeaParams", "Lorg/json/JSONObject;", "isShowKeepDialog", "", LiveCommonConstants.REASON_ON_DEDTROY, "updateCheckoutResponse", "responseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "isSilentReload", "updatePayStatus", "status", "", "updateUIOnCancel", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsCJPayOFullScreenWrapper extends BaseWrapper {
    public abstract void closeAddiSwitch();

    public abstract JSONObject getExtTeaParams();

    public abstract boolean isShowKeepDialog();

    public abstract void onDestroy();

    public abstract void updateCheckoutResponse(CJPayCheckoutCounterResponseBean r100, boolean r101);

    public abstract void updatePayStatus(String r100);

    public abstract void updateUIOnCancel();

    public AbsCJPayOFullScreenWrapper(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
    }

    public static /* synthetic */ void updateCheckoutResponse$default(AbsCJPayOFullScreenWrapper r100, CJPayCheckoutCounterResponseBean r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.updateCheckoutResponse(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCheckoutResponse");
    }
}
