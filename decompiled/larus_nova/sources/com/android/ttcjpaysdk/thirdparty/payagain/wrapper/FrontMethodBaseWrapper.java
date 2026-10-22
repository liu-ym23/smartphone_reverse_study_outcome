package com.android.ttcjpaysdk.thirdparty.payagain.wrapper;

import android.view.View;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import com.android.ttcjpaysdk.thirdparty.payagain.adapter.FrontMethodAdapter;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001:\u0001+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH&J\"\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u001cH&J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0007H&J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\tH\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\tH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/wrapper/FrontMethodBaseWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "data", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "anim", "", "hasCombine", "", "(Landroid/view/View;Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;IZ)V", "getAnim", "()I", "getHasCombine", "()Z", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;)V", "onMethodWrapperListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/wrapper/FrontMethodBaseWrapper$OnMethodWrapperListener;", "getOnMethodWrapperListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/wrapper/FrontMethodBaseWrapper$OnMethodWrapperListener;", "setOnMethodWrapperListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/wrapper/FrontMethodBaseWrapper$OnMethodWrapperListener;)V", "dataChangedNotify", "", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "getCardInfoList", "frontPreTradeInfo", "getPanelRootView", "initView", "notifyItemChanged", "index", "showEmptyView", "show", "showSecurityLoading", "isShow", "isPayScene", "OnMethodWrapperListener", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FrontMethodBaseWrapper extends BaseWrapper {
    private final int anim;
    private final boolean hasCombine;
    private FrontMethodAdapter.OnMethodAdapterListener onMethodAdapterListener;
    private OnMethodWrapperListener onMethodWrapperListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/wrapper/FrontMethodBaseWrapper$OnMethodWrapperListener;", "", "onExitClick", "", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMethodWrapperListener {
        void onExitClick();
    }

    public abstract void dataChangedNotify(ArrayList<FrontPaymentMethodInfo> r100);

    public abstract ArrayList<FrontPaymentMethodInfo> getCardInfoList(FrontPreTradeInfo r100);

    public abstract View getPanelRootView();

    public abstract void initView();

    public abstract void notifyItemChanged(int r100);

    public void showEmptyView(boolean r100) {
    }

    public void showSecurityLoading(boolean r100, boolean r101) {
    }

    public final int getAnim() {
        return this.anim;
    }

    public final boolean getHasCombine() {
        return this.hasCombine;
    }

    public final FrontMethodAdapter.OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    public final OnMethodWrapperListener getOnMethodWrapperListener() {
        return this.onMethodWrapperListener;
    }

    public final void setOnMethodAdapterListener(FrontMethodAdapter.OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    public final void setOnMethodWrapperListener(OnMethodWrapperListener r100) {
        this.onMethodWrapperListener = r100;
    }

    public FrontMethodBaseWrapper(View r100, FrontPreTradeInfo r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.anim = r102;
        this.hasCombine = r103;
    }

    public static /* synthetic */ void showSecurityLoading$default(FrontMethodBaseWrapper r100, boolean r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        r100.showSecurityLoading(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSecurityLoading");
    }
}
