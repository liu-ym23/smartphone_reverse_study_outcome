package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.AuthFailureError;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAuthenticator implements Authenticator {
    private final Account mAccount;
    private final AccountManager mAccountManager;
    private final String mAuthTokenType;
    private final boolean mNotifyAuthFailure;

    public AndroidAuthenticator(Context r10, Account r11, String r12) {
        this(r10, r11, r12, false);
    }

    public Account getAccount() {
        return this.mAccount;
    }

    @Override // com.android.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> r10 = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
        Bundle r11 = r10.getResult();     // Catch: Exception -> L22
        if (r10.isDone() == true) goto L7;
    L13:
        String r12 = null;
    L14:
        if (r12 != null) goto L21;
        String r13 = String.valueOf(this.mAuthTokenType);
        if (r13.length() == 0) goto L18;
        String r14 = "Got null auth token for type: ".concat(r13);
    L20:
        throw new AuthFailureError(r14);
    L18:
        r14 = new String("Got null auth token for type: ");
        goto L20
    L21:
        return r12;
    L7:
        if (r10.isCancelled() == true) goto L13;
        if (r11.containsKey(MemorySourceLinkType.INTENT) == true) goto L12;
        r12 = r11.getString("authtoken");
        goto L14
    L12:
        throw new AuthFailureError((Intent) r11.getParcelable(MemorySourceLinkType.INTENT));
    L22:
        e = move-exception;
        throw new AuthFailureError("Error while retrieving auth token", e);
    }

    public String getAuthTokenType() {
        return this.mAuthTokenType;
    }

    @Override // com.android.volley.toolbox.Authenticator
    public void invalidateAuthToken(String r10) {
        this.mAccountManager.invalidateAuthToken(this.mAccount.type, r10);
    }

    public AndroidAuthenticator(Context r10, Account r11, String r12, boolean r13) {
        this(AccountManager.get(r10), r11, r12, r13);
    }

    public AndroidAuthenticator(AccountManager r10, Account r11, String r12, boolean r13) {
        this.mAccountManager = r10;
        this.mAccount = r11;
        this.mAuthTokenType = r12;
        this.mNotifyAuthFailure = r13;
    }
}
