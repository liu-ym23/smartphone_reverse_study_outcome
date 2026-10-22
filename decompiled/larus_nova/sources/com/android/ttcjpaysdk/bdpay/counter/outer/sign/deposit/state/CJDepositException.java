package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state;

import com.bytedance.android.shopping.buynow.data.model.RequestErrorType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0005\u0006\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "BusinessError", RequestErrorType.NETWORK_ERROR, "PaymentError", "SystemError", "ValidationError", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$BusinessError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$NetworkError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$PaymentError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$SystemError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$ValidationError;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJDepositException extends Exception {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$BusinessError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "code", "", "message", "detailMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BusinessError extends CJDepositException {
        public BusinessError(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "detailMessage");
            super(r101, null);
        }

        public /* synthetic */ BusinessError(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = "";
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$NetworkError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NetworkError extends CJDepositException {
        /* JADX WARN: Multi-variable type inference failed */
        public NetworkError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public NetworkError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, null);
        }

        public /* synthetic */ NetworkError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "网络错误";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$PaymentError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PaymentError extends CJDepositException {
        /* JADX WARN: Multi-variable type inference failed */
        public PaymentError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public PaymentError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, null);
        }

        public /* synthetic */ PaymentError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "支付错误";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$SystemError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SystemError extends CJDepositException {
        /* JADX WARN: Multi-variable type inference failed */
        public SystemError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public SystemError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, null);
        }

        public /* synthetic */ SystemError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "系统错误";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException$ValidationError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ValidationError extends CJDepositException {
        /* JADX WARN: Multi-variable type inference failed */
        public ValidationError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ValidationError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100, null);
        }

        public /* synthetic */ ValidationError(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "验证错误";
        L5:
            this(r100);
        }
    }

    public /* synthetic */ CJDepositException(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    private CJDepositException(String r100) {
        super(r100);
    }
}
