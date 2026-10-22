package com.android.ttcjpaysdk.ocr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/BankCardOCRResult;", "Lcom/android/ttcjpaysdk/ocr/data/CJPayOCRResult;", "originalImage", "", "cardNumber", "", "cardNumberImage", "([BLjava/lang/String;Ljava/lang/String;)V", "getCardNumber", "()Ljava/lang/String;", "setCardNumber", "(Ljava/lang/String;)V", "getCardNumberImage", "setCardNumberImage", "getOriginalImage", "()[B", "setOriginalImage", "([B)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BankCardOCRResult extends CJPayOCRResult {
    private String cardNumber;
    private String cardNumberImage;
    private byte[] originalImage;

    public BankCardOCRResult() {
        this(null, null, null, 7, null);
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCardNumberImage() {
        return this.cardNumberImage;
    }

    public final byte[] getOriginalImage() {
        return this.originalImage;
    }

    public final void setCardNumber(String r100) {
        this.cardNumber = r100;
    }

    public final void setCardNumberImage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardNumberImage = r100;
    }

    public final void setOriginalImage(byte[] r100) {
        this.originalImage = r100;
    }

    public BankCardOCRResult(byte[] r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "cardNumberImage");
        this.originalImage = r100;
        this.cardNumber = r101;
        this.cardNumberImage = r102;
    }

    public /* synthetic */ BankCardOCRResult(byte[] r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
