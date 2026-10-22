package com.android.ttcjpaysdk.bdpay.counter.outer.customView;

import android.view.View;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.base.ui.data.PayAddiType;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J+\u0010\u000b\u001a\u00020\u00032!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\rH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/customView/ICJPayAddiView;", "", "bindData", "", "payAddiItem", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "addiType", "Lcom/android/ttcjpaysdk/base/ui/data/PayAddiType;", "closeSwitch", "getView", "Landroid/view/View;", "setActionCallback", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", ReportConstant.COMMON_ACTION_TYPE, "setSwitchListener", "listener", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/customView/SwitchListener;", "setViewVisibility", "visible", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayAddiView {
    void bindData(CJPayAddiItemInfo r100, PayAddiType r101);

    void closeSwitch();

    View getView();

    void setActionCallback(Function1<? super String, Unit> r100);

    void setSwitchListener(SwitchListener r100);

    void setViewVisibility(boolean r100);
}
