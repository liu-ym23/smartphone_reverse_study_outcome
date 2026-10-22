package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api;

import android.view.View;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base.UnifyPreVerifyBaseVM;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/IUnifyPreVerifyComponent;", "", "getEmbeddedView", "Landroid/view/View;", "getPreVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "handleTradeConfirmFailed", "", "handleTradeConfirmIntercept", "", "cashierResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "preVM", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/base/UnifyPreVerifyBaseVM;", "handleTradeConfirmResp", "onEmbeddedViewHide", "homePageStatus", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "onEmbeddedViewResume", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IUnifyPreVerifyComponent {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean handleTradeConfirmResp$default(IUnifyPreVerifyComponent r100, ICJUnifyPayTradeConfirmResp r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.handleTradeConfirmResp(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleTradeConfirmResp");
        }

        public static /* synthetic */ void onEmbeddedViewHide$default(IUnifyPreVerifyComponent r100, UnifyPayHomepageState r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onEmbeddedViewHide(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEmbeddedViewHide");
        }
    }

    View getEmbeddedView();

    UnifyPreVerifyType getPreVerifyType();

    void handleTradeConfirmFailed();

    boolean handleTradeConfirmIntercept(ICJUnifyPayTradeConfirmResp r100, UnifyPreVerifyBaseVM r101);

    boolean handleTradeConfirmResp(ICJUnifyPayTradeConfirmResp r100);

    void onEmbeddedViewHide(UnifyPayHomepageState r100);

    void onEmbeddedViewResume();
}
