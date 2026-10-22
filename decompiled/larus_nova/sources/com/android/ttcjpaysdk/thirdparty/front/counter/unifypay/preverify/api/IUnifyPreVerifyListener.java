package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyAction;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyResultAction;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.PreVerifyTypeStrategy;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/IUnifyPreVerifyListener;", "", "onPreVerifyAction", "", "resultAction", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyAction;", "data", "Lorg/json/JSONObject;", "onPreVerifyResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyResultAction;", "onPreVerifyTypeChanged", "previousType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "newTypeStrategy", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyTypeStrategy;", "extData", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IUnifyPreVerifyListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onPreVerifyAction$default(IUnifyPreVerifyListener r100, PreVerifyAction r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = new JSONObject();
        L6:
            r100.onPreVerifyAction(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPreVerifyAction");
        }

        public static /* synthetic */ void onPreVerifyResult$default(IUnifyPreVerifyListener r100, PreVerifyResultAction r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = new JSONObject();
        L6:
            r100.onPreVerifyResult(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPreVerifyResult");
        }

        public static /* synthetic */ void onPreVerifyTypeChanged$default(IUnifyPreVerifyListener r100, UnifyPreVerifyType r101, PreVerifyTypeStrategy r102, JSONObject r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.onPreVerifyTypeChanged(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPreVerifyTypeChanged");
        }
    }

    void onPreVerifyAction(PreVerifyAction r100, JSONObject r101);

    void onPreVerifyResult(PreVerifyResultAction r100, JSONObject r101);

    void onPreVerifyTypeChanged(UnifyPreVerifyType r100, PreVerifyTypeStrategy r101, JSONObject r102);
}
