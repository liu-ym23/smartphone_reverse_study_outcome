package com.android.ttcjpaysdk.bdpay.counter.outer.sign.common;

import com.bytedance.android.shopping.buynow.data.model.RequestErrorType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getErrorInfo", "BusinessError", RequestErrorType.NETWORK_ERROR, "SystemError", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$BusinessError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$NetworkError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$SystemError;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJSignException extends Exception {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$BusinessError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "code", "", "message", "detailMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDetailMessage", "getErrorInfo", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BusinessError extends CJSignException {
        private final String code;
        private final String detailMessage;

        @Override // com.android.ttcjpaysdk.bdpay.counter.outer.sign.common.CJSignException
        public String getErrorInfo() {
            return "[" + this.code + "]-" + getMessage() + '-' + this.detailMessage;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDetailMessage() {
            return this.detailMessage;
        }

        public BusinessError(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "detailMessage");
            super(r101, null);
            this.code = r100;
            this.detailMessage = r102;
        }

        public /* synthetic */ BusinessError(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = "";
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$NetworkError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NetworkError extends CJSignException {
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
            r100 = "网络异常，请重试";
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException$SystemError;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "message", "", "(Ljava/lang/String;)V", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SystemError extends CJSignException {
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

    public /* synthetic */ CJSignException(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public String getErrorInfo() {
        return String.valueOf(getMessage());
    }

    private CJSignException(String r100) {
        super(r100);
    }
}
