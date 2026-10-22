package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.method;

import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/CJStandardMethodHost;", "", "getHostActivity", "Landroidx/fragment/app/FragmentActivity;", "handleBackFromMethodPage", "", "forceRefresh", "", "onPaymentMethodSelectedFromMethodPage", "newMethod", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "shouldUpdateCheckedStatusOnMethodClick", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJStandardMethodHost {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean shouldUpdateCheckedStatusOnMethodClick(CJStandardMethodHost r100, AssetInfoBean r101) {
            Intrinsics.checkNotNullParameter(r101, "newMethod");
            return true;
        }

        public static /* synthetic */ void handleBackFromMethodPage$default(CJStandardMethodHost r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.handleBackFromMethodPage(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleBackFromMethodPage");
        }
    }

    FragmentActivity getHostActivity();

    void handleBackFromMethodPage(boolean r100);

    void onPaymentMethodSelectedFromMethodPage(AssetInfoBean r100);

    boolean shouldUpdateCheckedStatusOnMethodClick(AssetInfoBean r100);
}
