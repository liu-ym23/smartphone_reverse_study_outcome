package com.android.ttcjpaysdk.bdpay.counter.outer.base;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/base/CJOuterBizCallback;", "", "finishProcess", "", "result", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJDyPayResult;", "delayTime", "", "eventParams", "", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJOuterBizCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void finishProcess$default(CJOuterBizCallback r100, CJDyPayResult r101, long r102, Map r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = 50;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.finishProcess(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishProcess");
        }
    }

    void finishProcess(CJDyPayResult r100, long r101, Map<String, Object> r102);
}
