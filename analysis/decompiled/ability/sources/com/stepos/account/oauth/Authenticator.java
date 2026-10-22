package com.stepos.account.oauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.stepos.ability.R;
import com.stepos.statsrpk.d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Authenticator {
    static final String TAG = "[Cloud]Account.SDK";
    public static final long TIMEOUT_DEFAULT = 30;
    public static final long TIMEOUT_MAX = 120;
    private final List<AccountManagerFuture<Bundle>> mAccountManagerFutureList;
    private boolean mCanceled;
    private final Context mContext;
    private final String mScope;
    private OnUserInfoListener mUserInfoListener;
    private b mUserInfoTask;
    private String url;

    public interface FactorValidateListener {
        void failure(String str);

        void validateSuccess(String str);
    }

    public Authenticator(Context context, String str) {
        this(context, str, getNetEnv(context));
    }

    private static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "stepaos.com";
        }
        str.getClass();
        switch (str) {
            case "dev":
                return "d-stepaos.com";
            case "stg":
                return "s-stepaos.com";
            case "test":
                return "t-stepaos.com";
            default:
                return "stepaos.com";
        }
    }

    private static String getNetEnv(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "net_env");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> getReturnMessage(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString("errorMessage");
        int i = bundle.containsKey("errorCode") ? bundle.getInt("errorCode") : -1;
        String string2 = bundle.containsKey("cacheAccountName") ? bundle.getString("cacheAccountName") : null;
        if (i >= 0) {
            arrayList.add(Integer.valueOf(i));
            arrayList.add(string);
        } else if ("params not legal!".equalsIgnoreCase(string)) {
            arrayList.add(7);
            arrayList.add(this.mContext.getString(R.string.context_is_null));
        } else if ("get token failed!".equalsIgnoreCase(string)) {
            arrayList.add(2);
            arrayList.add(this.mContext.getString(R.string.get_token_failed));
        } else {
            if (("unknown type : " + this.mScope).equalsIgnoreCase(string)) {
                arrayList.add(8);
                arrayList.add(String.format(this.mContext.getString(R.string.scope_null_token), this.mScope));
            } else if (!TextUtils.isEmpty(string) && string.startsWith("uid =") && string.contains("not match package")) {
                arrayList.add(9);
                arrayList.add(this.mContext.getString(R.string.uid_not_match));
            } else {
                arrayList.add(3);
                arrayList.add(string);
            }
        }
        if (string2 == null) {
            string2 = "";
        }
        arrayList.add(string2);
        return arrayList;
    }

    private static String getUrl(String str) {
        return B7.a.q(new StringBuilder("https://i."), getHost(str), "/uc/oauth/member/getBasicInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(OnAuthListener onAuthListener, int i, String str, String str2) {
        if (onAuthListener == null || this.mCanceled) {
            return;
        }
        onAuthListener.onError(i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntent(OnAuthListener onAuthListener, Intent intent) {
        if (onAuthListener == null || this.mCanceled) {
            return;
        }
        onAuthListener.onHandleIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(OnAuthListener onAuthListener, String str, String str2) {
        if (onAuthListener == null || this.mCanceled) {
            return;
        }
        onAuthListener.onSuccess(str, str2);
    }

    public static boolean isOasisAccountBound(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("oasisAccountBound")) {
            return false;
        }
        Object objOpt = jSONObject.opt("oasisAccountBound");
        return objOpt instanceof Boolean ? ((Boolean) objOpt).booleanValue() : TextUtils.equals("true", String.valueOf(objOpt));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readInputStream(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return stringBuffer.toString();
            }
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }
    }

    private void requestUserInfo(String str, OnUserInfoListener onUserInfoListener, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("token is null");
        }
        try {
            b bVar = this.mUserInfoTask;
            if (bVar != null && !bVar.isCancelled()) {
                this.mUserInfoTask.cancel(true);
            }
            this.mUserInfoListener = onUserInfoListener;
            b bVar2 = new b(this, z10);
            this.mUserInfoTask = bVar2;
            bVar2.execute(str);
        } catch (Exception e) {
            if (onUserInfoListener != null) {
                onUserInfoListener.onFailed(-1000, e.getMessage());
            }
        }
    }

    private void trackFuture(AccountManagerFuture<Bundle> accountManagerFuture) {
        synchronized (this.mAccountManagerFutureList) {
            this.mAccountManagerFutureList.add(accountManagerFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void untrackFuture(AccountManagerFuture<Bundle> accountManagerFuture) {
        synchronized (this.mAccountManagerFutureList) {
            this.mAccountManagerFutureList.remove(accountManagerFuture);
        }
    }

    public void cancel() {
        this.mCanceled = true;
        try {
            b bVar = this.mUserInfoTask;
            if (bVar != null && !bVar.isCancelled()) {
                this.mUserInfoTask.cancel(true);
            }
            synchronized (this.mAccountManagerFutureList) {
                try {
                    Iterator<AccountManagerFuture<Bundle>> it = this.mAccountManagerFutureList.iterator();
                    while (it.hasNext()) {
                        it.next().cancel(true);
                    }
                    this.mAccountManagerFutureList.clear();
                } finally {
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "cancel error", e);
        }
        this.mUserInfoListener = null;
    }

    public void factorValidate(Intent intent, FactorValidateListener factorValidateListener) {
        if (intent == null) {
            factorValidateListener.failure("Intent data is null.");
            return;
        }
        String stringExtra = intent.getStringExtra("message");
        if (TextUtils.isEmpty(stringExtra)) {
            factorValidateListener.validateSuccess(intent.getStringExtra("validate_code"));
        } else {
            factorValidateListener.failure(stringExtra);
        }
    }

    public String[] getAuthToken(Activity activity) throws AuthException {
        return getAuthToken(true, activity);
    }

    public Intent getLinkOasisAccountIntent() {
        Intent intent = new Intent("com.stepos.account.action.LINK_OASIS_ACCOUNT");
        intent.setPackage("com.stepos.account");
        intent.addCategory("android.intent.category.DEFAULT");
        return intent;
    }

    public Account getLocalAccount() {
        return d.y(this.mContext);
    }

    public String getLocalAccountId() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        Account accountY = d.y(context);
        return accountY == null ? "" : accountY.name;
    }

    public K4.a getLocalAccountInfo() {
        Context context = this.mContext;
        Account accountY = d.y(context);
        if (accountY == null) {
            return null;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            return new K4.a(accountManager.getUserData(accountY, "nickname"), accountManager.getUserData(accountY, "phone"), accountManager.getUserData(accountY, "account_icon"));
        } catch (Exception unused) {
            return new K4.a(null, null, null);
        }
    }

    public Intent getSimpleValidateMode(String str, String str2, String str3) {
        if (!isSupportFactorAuthenticator()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.stepos.account.factor.authentication");
        intent.setPackage("com.stepos.account");
        intent.putExtra("factor_token", str);
        intent.putExtra("packageName", str2);
        intent.putExtra("serviceName", str3);
        intent.putExtra("factor_mode", "SIMPLE");
        return intent;
    }

    public Intent getStrictValidateMode(String str, String str2, String str3) {
        if (!isSupportFactorAuthenticator()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.stepos.account.factor.authentication");
        intent.setPackage("com.stepos.account");
        intent.putExtra("factor_token", str);
        intent.putExtra("packageName", str2);
        intent.putExtra("serviceName", str3);
        intent.putExtra("factor_mode", "STRICT");
        return intent;
    }

    public void getUserInfo(String str, OnUserInfoListener onUserInfoListener) {
        requestUserInfo(str, onUserInfoListener, false);
    }

    public boolean isLoggedIn() {
        Context context = this.mContext;
        return (context == null || d.y(context) == null) ? false : true;
    }

    public boolean isSupportFactorAuthenticator() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo("com.stepos.account", 128).metaData;
            if (bundle != null) {
                return bundle.getBoolean("support_factor_authenticator");
            }
        } catch (Throwable th) {
            Log.e(TAG, "isSupportFactorAuthenticator fail", th);
        }
        return false;
    }

    public boolean isSupportLinkOasisAccount() {
        return (this.mContext == null || getLinkOasisAccountIntent().resolveActivity(this.mContext.getPackageManager()) == null) ? false : true;
    }

    public Authenticator(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        str = TextUtils.isEmpty(str) ? "basic" : str;
        this.mContext = context.getApplicationContext();
        this.mScope = str;
        this.mAccountManagerFutureList = new ArrayList();
        this.url = getUrl(str2);
        StringBuilder sbV = B7.a.v("env: ", str2, ", url: ");
        sbV.append(this.url);
        Log.i(TAG, sbV.toString());
    }

    public String[] getAuthToken(boolean z10, Activity activity) throws AuthException {
        return getAuthToken(z10, 30L, activity);
    }

    public void getUserInfo(String str, OnUserInfoListener onUserInfoListener, boolean z10) {
        requestUserInfo(str, onUserInfoListener, z10);
    }

    public String[] getAuthToken(long j5, Activity activity) throws AuthException {
        return getAuthToken(true, j5, activity);
    }

    public String[] getAuthToken(boolean z10, long j5, Activity activity) throws AuthException {
        String string;
        if (j5 > 120) {
            j5 = 120;
        } else if (j5 < 0) {
            j5 = 30;
        }
        Log.d(TAG, "getAuthToken1  running... timeoutSeconds: " + j5);
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account accountY = d.y(this.mContext);
        if (accountY == null) {
            accountY = new Account(EnvironmentCompat.MEDIA_UNKNOWN, "com.stepos.account");
        }
        Account account = accountY;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z10);
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        this.mCanceled = false;
        AccountManagerFuture<Bundle> authToken = accountManager.getAuthToken(account, this.mScope, bundle, activity, (AccountManagerCallback<Bundle>) null, (Handler) null);
        trackFuture(authToken);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[2];
        try {
            try {
                Bundle result = authToken.getResult(j5, TimeUnit.SECONDS);
                untrackFuture(authToken);
                Log.d(TAG, "getAuthToken1  mCanceled: " + this.mCanceled);
                if (this.mCanceled) {
                    string = null;
                } else {
                    if (!result.containsKey("authtoken")) {
                        if (!result.containsKey("intent")) {
                            if (result.containsKey("errorMessage")) {
                                List<Object> returnMessage = getReturnMessage(result);
                                throw new AuthException(((Integer) returnMessage.get(0)).intValue(), (String) returnMessage.get(1), (String) returnMessage.get(2));
                            }
                            throw new AuthException(11, this.mContext.getString(R.string.unkown_error));
                        }
                        throw new AuthException((Intent) result.getParcelable("intent"));
                    }
                    string = result.getString("authtoken");
                    strArr[0] = string;
                    strArr[1] = result.getString("authsecret");
                }
                if (!TextUtils.isEmpty(string)) {
                    return strArr;
                }
                if (!authToken.isDone()) {
                    Log.w(TAG, "getAutoToken1. accountManagerFuture: " + authToken);
                    throw new AuthException(6, this.mContext.getString(R.string.unsupport_operation));
                }
                throw new AuthException(8, String.format(this.mContext.getString(R.string.scope_null_token), this.mScope));
            } catch (OperationCanceledException e) {
                Log.w(TAG, "getAuthToken1, fail.", e);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 > jCurrentTimeMillis && (jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000 > 25) {
                    throw new AuthException(10, this.mContext.getString(R.string.sync_timeout), e);
                }
                throw new AuthException(4, this.mContext.getString(R.string.get_cancel), e);
            } catch (Exception e6) {
                Log.w(TAG, "getAuthToken1, fail.", e6);
                throw new AuthException(1, this.mContext.getString(R.string.error_is_throwed), e6);
            }
        } catch (Throwable th) {
            untrackFuture(authToken);
            throw th;
        }
    }

    public void getAuthToken(Activity activity, OnAuthListener onAuthListener) {
        getAuthToken(true, activity, onAuthListener);
    }

    public void getAuthToken(boolean z10, Activity activity, OnAuthListener onAuthListener) {
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account accountY = d.y(this.mContext);
        if (accountY == null) {
            accountY = new Account(EnvironmentCompat.MEDIA_UNKNOWN, "com.stepos.account");
        }
        Account account = accountY;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z10);
        this.mCanceled = false;
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        trackFuture(accountManager.getAuthToken(account, this.mScope, bundle, activity, new a(this, onAuthListener), (Handler) null));
    }
}
