package ccom.obric.matrix.sdk.network;

import com.android.ttcjpaysdk.bdpay.counter.outer.CJCallbackOuterManager;
import com.bytedance.common.utility.CommonHttpException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lccom/obric/matrix/sdk/network/CustomHttpException;", "Lcom/bytedance/common/utility/CommonHttpException;", CJCallbackOuterManager.KEY_RESPONSE_CODE, "", "internalErrorCode", "exceptionStr", "", "(IILjava/lang/String;)V", "mInternalErrorCode", "getInternalErrorCode", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomHttpException extends CommonHttpException {
    private final int mInternalErrorCode;

    public final int getInternalErrorCode() {
        return this.mInternalErrorCode;
    }

    public CustomHttpException(int r100, int r101, String r102) {
        super(r100, r102);
        this.mInternalErrorCode = r101;
    }
}
