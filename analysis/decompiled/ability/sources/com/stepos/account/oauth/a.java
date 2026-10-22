package com.stepos.account.oauth;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.ability.R;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements AccountManagerCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnAuthListener f3446a;
    public final /* synthetic */ Authenticator b;

    public a(Authenticator authenticator, OnAuthListener onAuthListener) {
        this.b = authenticator;
        this.f3446a = onAuthListener;
    }

    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture accountManagerFuture) {
        OnAuthListener onAuthListener = this.f3446a;
        Authenticator authenticator = this.b;
        String str = null;
        try {
            try {
            } finally {
                authenticator.untrackFuture(accountManagerFuture);
            }
        } catch (OperationCanceledException unused) {
            authenticator.handleError(onAuthListener, 4, authenticator.mContext.getString(R.string.get_cancel), null);
        } catch (Exception e) {
            authenticator.handleError(onAuthListener, 1, authenticator.mContext.getString(R.string.error_is_throwed), null);
            Log.e("[Cloud]Account.SDK", "[getAuthToken] " + e.getMessage());
        }
        if (authenticator.mCanceled) {
            Log.d("[Cloud]Account.SDK", "op canceled.");
            return;
        }
        Bundle bundle = (Bundle) accountManagerFuture.getResult();
        if (bundle == null) {
            authenticator.handleError(onAuthListener, 5, authenticator.mContext.getString(R.string.future_result_is_null), null);
            return;
        }
        if (bundle.containsKey("authtoken")) {
            authenticator.handleSuccess(onAuthListener, bundle.getString("authtoken"), bundle.getString("authsecret"));
        } else if (bundle.containsKey("intent")) {
            authenticator.handleIntent(onAuthListener, (Intent) bundle.getParcelable("intent"));
        } else if (bundle.containsKey("errorMessage")) {
            try {
                List returnMessage = authenticator.getReturnMessage(bundle);
                int iIntValue = ((Integer) returnMessage.get(0)).intValue();
                String str2 = (String) returnMessage.get(1);
                String str3 = (String) returnMessage.get(2);
                if (!TextUtils.isEmpty(str3)) {
                    str = str3;
                }
                authenticator.handleError(onAuthListener, iIntValue, str2, str);
            } catch (Exception unused2) {
            }
        } else {
            authenticator.handleError(onAuthListener, 11, authenticator.mContext.getString(R.string.unkown_error), null);
        }
    }
}
