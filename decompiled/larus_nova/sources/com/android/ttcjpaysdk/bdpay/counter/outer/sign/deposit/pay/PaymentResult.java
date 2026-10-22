package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.pay;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/pay/PaymentResult;", "", "code", "", "message", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCode", "()Ljava/lang/String;", "getData", "()Ljava/util/Map;", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isProcessing", "isSuccess", "toString", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentResult {
    private final String code;
    private final Map<String, String> data;
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaymentResult copy$default(PaymentResult r100, String r101, String r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Map<String, String> component3() {
        return this.data;
    }

    public final PaymentResult copy(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        return new PaymentResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PaymentResult) == true) goto L8;
        return false;
    L8:
        PaymentResult r101 = (PaymentResult) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.code.hashCode() * 31) + this.message.hashCode()) * 31;
        Map<String, String> r101 = this.data;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "PaymentResult(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public final boolean isProcessing() {
        return Intrinsics.areEqual(this.code, "3");
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual(this.code, "0");
    }

    public final String getCode() {
        return this.code;
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public PaymentResult(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.code = r100;
        this.message = r101;
        this.data = r102;
    }

    public /* synthetic */ PaymentResult(String r100, String r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
