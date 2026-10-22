package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation.view;

import android.view.View;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation.CJOperationViewConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u001a\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/operation/view/ICJUnifyOperationView;", "", "getDefaultSelected", "", "()Ljava/lang/Boolean;", "getTitleText", "", "getView", "Landroid/view/View;", "isRecSelected", "setRecSelected", "", "selected", "updateData", "viewConfig", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/operation/CJOperationViewConfig;", "resetState", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJUnifyOperationView {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Boolean getDefaultSelected(ICJUnifyOperationView r100) {
            return null;
        }

        public static Boolean isRecSelected(ICJUnifyOperationView r100) {
            return null;
        }

        public static /* synthetic */ void updateData$default(ICJUnifyOperationView r100, CJOperationViewConfig r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.updateData(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateData");
        }
    }

    Boolean getDefaultSelected();

    String getTitleText();

    View getView();

    Boolean isRecSelected();

    void setRecSelected(boolean r100);

    void updateData(CJOperationViewConfig r100, boolean r101);
}
