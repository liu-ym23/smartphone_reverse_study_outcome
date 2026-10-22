package com.obric.matrix.platform.sdk.ones.account.api;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.account.AccountInfo;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAccountManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0014\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u0014\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0019H&J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountManager;", "", "accountInfo", "Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "addAccountStatusListener", "", "accountStatusListener", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;", "init", "asyncInit", "", "innerToken", "", "isLogin", AccountInfoBundleKey.LOGOUT_SCENE, "", "removeAccountStatusListener", AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, "phoneNumber", "updateAccountInfo", "updateAccountInfoAsync", "callback", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;", "updateXttTokenMap", "updateXttTokenMapAsync", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;", "xttTokenMap", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAccountManager {

    /* JADX INFO: compiled from: IAccountManager.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void updateAccountInfoAsync$default(IAccountManager r0, IUpdateAccountInfoCallback r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.updateAccountInfoAsync(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAccountInfoAsync");
        }

        public static /* synthetic */ void updateXttTokenMapAsync$default(IAccountManager r0, IUpdateTokenMapCallback r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.updateXttTokenMapAsync(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateXttTokenMapAsync");
        }
    }

    AccountInfo accountInfo();

    void addAccountStatusListener(IAccountStatusListener r1);

    void init(boolean r1);

    String innerToken();

    boolean isLogin();

    int logoutScene();

    void removeAccountStatusListener(IAccountStatusListener r1);

    void setLoginPhoneNumber(String r1);

    void updateAccountInfo();

    void updateAccountInfoAsync(IUpdateAccountInfoCallback r1);

    void updateXttTokenMap();

    void updateXttTokenMapAsync(IUpdateTokenMapCallback r1);

    Map<String, String> xttTokenMap();
}
