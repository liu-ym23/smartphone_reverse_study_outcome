package com.obric.matrix.platform.sdk.ones.account.api;

import com.obric.matrix.platform.sdk.ones.account.a;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\fH&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountManager;", "", "", "asyncInit", "", "init", "(Z)V", "isLogin", "()Z", "", "logoutScene", "()I", "", "innerToken", "()Ljava/lang/String;", "Lcom/obric/matrix/platform/sdk/ones/account/a;", "accountInfo", "()Lcom/obric/matrix/platform/sdk/ones/account/a;", "updateAccountInfo", "()V", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;", "callback", "updateAccountInfoAsync", "(Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateAccountInfoCallback;)V", "", "xttTokenMap", "()Ljava/util/Map;", "updateXttTokenMap", "Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;", "updateXttTokenMapAsync", "(Lcom/obric/matrix/platform/sdk/ones/account/api/IUpdateTokenMapCallback;)V", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;", "accountStatusListener", "addAccountStatusListener", "(Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountStatusListener;)V", "removeAccountStatusListener", "phoneNumber", "setLoginPhoneNumber", "(Ljava/lang/String;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAccountManager {
    @NotNull
    a accountInfo();

    void addAccountStatusListener(@NotNull IAccountStatusListener r10);

    void init(boolean r10);

    @NotNull
    String innerToken();

    boolean isLogin();

    int logoutScene();

    void removeAccountStatusListener(@NotNull IAccountStatusListener r10);

    void setLoginPhoneNumber(@NotNull String r10);

    void updateAccountInfo();

    void updateAccountInfoAsync(@Nullable IUpdateAccountInfoCallback r10);

    void updateXttTokenMap();

    void updateXttTokenMapAsync(@Nullable IUpdateTokenMapCallback r10);

    @NotNull
    Map<String, String> xttTokenMap();
}
