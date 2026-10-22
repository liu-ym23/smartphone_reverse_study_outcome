package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayTradeInfoReqBean;", "", "exts", "", "", "(Ljava/util/Map;)V", "callerRiskInfo", "getCallerRiskInfo", "()Ljava/lang/String;", "setCallerRiskInfo", "(Ljava/lang/String;)V", "getExts", "()Ljava/util/Map;", "setExts", "lastPayProcessInfo", "getLastPayProcessInfo", "setLastPayProcessInfo", "appendExts", "", "ext", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTradeInfoReqBean {
    private String callerRiskInfo;
    private Map<String, ? extends Object> exts;
    private String lastPayProcessInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayTradeInfoReqBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getCallerRiskInfo() {
        return this.callerRiskInfo;
    }

    public final Map<String, Object> getExts() {
        return this.exts;
    }

    public final String getLastPayProcessInfo() {
        return this.lastPayProcessInfo;
    }

    public CJPayTradeInfoReqBean(Map<String, ? extends Object> r100) {
        this.exts = r100;
    }

    public final void appendExts(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, ? extends Object> r102 = this.exts;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        r101.putAll(r100);
        this.exts = r101;
    }

    public final void setCallerRiskInfo(String r100) {
        this.callerRiskInfo = r100;
    }

    public final void setExts(Map<String, ? extends Object> r100) {
        this.exts = r100;
    }

    public final void setLastPayProcessInfo(String r100) {
        this.lastPayProcessInfo = r100;
    }

    public /* synthetic */ CJPayTradeInfoReqBean(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
