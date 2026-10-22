package com.android.ttcjpaysdk.bdpay.counter.outer.sign;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.AssetInfo;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignContract;", "", "()V", "SIGN_STATUS_FAIL", "", "SIGN_STATUS_PROCESSING", "SIGN_STATUS_SUCCEED", "IAction", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignContract {
    public static final CJSignContract INSTANCE = null;
    public static final String SIGN_STATUS_FAIL = "FAIL";
    public static final String SIGN_STATUS_PROCESSING = "PROCESSING";
    public static final String SIGN_STATUS_SUCCEED = "SUCCESS";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignContract$IAction;", "", "gotoLogin", "", "gotoSwitchAccount", "onDeductAssetChange", UriUtil.LOCAL_ASSET_SCHEME, "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "onSignConfirm", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IAction {
        void gotoLogin();

        void gotoSwitchAccount();

        void onDeductAssetChange(AssetInfo r100);

        void onSignConfirm();
    }

    static {
        INSTANCE = new CJSignContract();
    }

    private CJSignContract() {
    }
}
