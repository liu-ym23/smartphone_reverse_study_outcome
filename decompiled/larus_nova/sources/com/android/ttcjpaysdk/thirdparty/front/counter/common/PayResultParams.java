package com.android.ttcjpaysdk.thirdparty.front.counter.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/common/PayResultParams;", "", "()V", "cashDeskStyle", "", "getCashDeskStyle", "()I", "setCashDeskStyle", "(I)V", "isFromInsufficientBalance", "", "()Z", "setFromInsufficientBalance", "(Z)V", "isFromOuterPay", "setFromOuterPay", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PayResultParams {
    private int cashDeskStyle;
    private boolean isFromInsufficientBalance;
    private boolean isFromOuterPay;

    public PayResultParams() {
    }

    public final int getCashDeskStyle() {
        return this.cashDeskStyle;
    }

    public final boolean isFromInsufficientBalance() {
        return this.isFromInsufficientBalance;
    }

    public final boolean isFromOuterPay() {
        return this.isFromOuterPay;
    }

    public final void setCashDeskStyle(int r100) {
        this.cashDeskStyle = r100;
    }

    public final void setFromInsufficientBalance(boolean r100) {
        this.isFromInsufficientBalance = r100;
    }

    public final void setFromOuterPay(boolean r100) {
        this.isFromOuterPay = r100;
    }
}
