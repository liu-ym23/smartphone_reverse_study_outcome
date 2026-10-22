package com.android.ttcjpaysdk.base.service.bean;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/IntegratedCounterParams;", "Ljava/io/Serializable;", "()V", "cashDeskStyle", "", "combinePayMethod", "", "dmSessionIdForForeignCard", "hasVoucher", "", "jhResultPageStyle", "tradeNoSp", "copy", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedCounterParams implements Serializable {
    public int cashDeskStyle;
    public String combinePayMethod;
    public String dmSessionIdForForeignCard;
    public boolean hasVoucher;
    public String jhResultPageStyle;
    public String tradeNoSp;

    public IntegratedCounterParams() {
    }

    public final IntegratedCounterParams copy() {
        IntegratedCounterParams r100 = new IntegratedCounterParams();
        r100.cashDeskStyle = this.cashDeskStyle;
        r100.combinePayMethod = this.combinePayMethod;
        r100.tradeNoSp = this.tradeNoSp;
        r100.hasVoucher = this.hasVoucher;
        r100.jhResultPageStyle = this.jhResultPageStyle;
        r100.dmSessionIdForForeignCard = this.dmSessionIdForForeignCard;
        return r100;
    }
}
