package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/QuerySignInfoResp;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "data", "Lcom/android/ttcjpaysdk/integrated/counter/data/QuerySignInfo;", "error", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;", "(Ljava/lang/String;Lcom/android/ttcjpaysdk/integrated/counter/data/QuerySignInfo;Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;)V", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuerySignInfoResp implements CJPayObject, Serializable {
    public String code;
    public QuerySignInfo data;
    public CounterTradeErrorBean error;

    public QuerySignInfoResp() {
        this(null, null, null, 7, null);
    }

    public QuerySignInfoResp(String r100, QuerySignInfo r101, CounterTradeErrorBean r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.code = r100;
        this.data = r101;
        this.error = r102;
    }

    public /* synthetic */ QuerySignInfoResp(String r110, QuerySignInfo r111, CounterTradeErrorBean r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 2) == 0) goto L9;
        QuerySignInfo r101 = new QuerySignInfo(null, null, false, null, null, 0, 0, 0, null, null, null, null, UnixStat.PERM_MASK, null);
    L11:
        if ((r211 & 4) == 0) goto L13;
        CounterTradeErrorBean r102 = new CounterTradeErrorBean();
    L14:
        this(r100, r101, r102);
        return;
    L13:
        r102 = r210;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
