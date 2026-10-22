package com.android.ttcjpaysdk.thirdparty.counter.action;

import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J3\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/action/IPasswordFreeAction;", "", "closeGuide", "", "getPanelHeight", "", "showGuide", "responseBean", "Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;", "animTask", "Lkotlin/Function0;", "lastPageHeight", "(Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;)V", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPasswordFreeAction {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showGuide$default(IPasswordFreeAction r100, CJPayCounterTradeQueryResponseBean r101, Function0 r102, Integer r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.showGuide(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showGuide");
        }
    }

    void closeGuide();

    int getPanelHeight();

    void showGuide(CJPayCounterTradeQueryResponseBean r100, Function0<Unit> r101, Integer r102);
}
