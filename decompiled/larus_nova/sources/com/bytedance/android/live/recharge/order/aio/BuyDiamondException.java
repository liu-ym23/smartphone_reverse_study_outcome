package com.bytedance.android.live.recharge.order.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tw0.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/BuyDiamondException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ltw0/h;", "toBuyDiamondResponse", "", "errorCode", "I", "getErrorCode", "()I", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorPrompt", "getErrorPrompt", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BuyDiamondException extends RuntimeException {
    private final int errorCode;
    private final String errorMessage;
    private final String errorPrompt;

    public final h toBuyDiamondResponse() {
        h r100 = new h();
        r100.e(OrderResultCode.Failure);
        r100.b(this.errorCode);
        r100.c(this.errorMessage);
        r100.d(this.errorPrompt);
        return r100;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getErrorPrompt() {
        return this.errorPrompt;
    }

    public BuyDiamondException(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Intrinsics.checkNotNullParameter(r102, "errorPrompt");
        this.errorCode = r100;
        this.errorMessage = r101;
        this.errorPrompt = r102;
    }

    public /* synthetic */ BuyDiamondException(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
