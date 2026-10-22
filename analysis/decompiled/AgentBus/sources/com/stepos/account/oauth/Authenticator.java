package com.stepos.account.oauth;

import a1.a;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.account.oauth.data.AccountInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Authenticator {
    static final String TAG = "[Cloud]Account.SDK";
    public static final long TIMEOUT_DEFAULT = 30;
    public static final long TIMEOUT_MAX = 120;
    private final List<AccountManagerFuture<Bundle>> mAccountManagerFutureList;
    private boolean mCanceled;
    private final Context mContext;
    private final String mScope;
    private OnUserInfoListener mUserInfoListener;
    private UserInfoTask mUserInfoTask;
    private String url;

    public interface FactorValidateListener {
        void failure(String str);

        void validateSuccess(String str);
    }

    public class UserInfoTask extends AsyncTask<String, Void, Map<String, Object>> {
        private final boolean mBindOasis;

        public UserInfoTask(boolean z4) {
            this.mBindOasis = z4;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x013d A[PHI: r6 r8 r10 r14
          0x013d: PHI (r6v9 java.net.HttpURLConnection) = 
          (r6v7 java.net.HttpURLConnection)
          (r6v17 java.net.HttpURLConnection)
          (r6v17 java.net.HttpURLConnection)
          (r6v17 java.net.HttpURLConnection)
         binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x013d: PHI (r8v9 ??) = (r8v7 ??), (r8v10 ??), (r8v10 ??), (r8v10 ??) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x013d: PHI (r10v6 ??) = (r10v4 ??), (r10v14 ??), (r10v14 ??), (r10v14 ??) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
          0x013d: PHI (r14v12 java.lang.String) = (r14v9 java.lang.String), (r14v23 java.lang.String), (r14v23 java.lang.String), (r14v23 java.lang.String) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0173  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v14, types: [java.io.DataOutputStream, java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v10, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v7, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00ec -> B:91:0x0152). Please report as a decompilation issue!!! */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.Map<java.lang.String, java.lang.Object> doInBackground(java.lang.String... r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.account.oauth.Authenticator.UserInfoTask.doInBackground(java.lang.String[]):java.util.Map");
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Map<String, Object> map) {
            if (Authenticator.this.mUserInfoListener != null) {
                int iIntValue = ((Integer) map.get("code")).intValue();
                if (iIntValue == 200) {
                    Authenticator.this.mUserInfoListener.onSuccess((JSONObject) map.get("value"));
                } else {
                    Authenticator.this.mUserInfoListener.onFailed(iIntValue, map.containsKey("value") ? (String) map.get("value") : OAuthConstants.UNKOWN_ERROR_MSG);
                }
            }
        }
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
        int i2 = bundle.containsKey("errorCode") ? bundle.getInt("errorCode") : -1;
        String string2 = bundle.containsKey("cacheAccountName") ? bundle.getString("cacheAccountName") : null;
        if (i2 >= 0) {
            arrayList.add(Integer.valueOf(i2));
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
        return a.m(new StringBuilder("https://i."), getHost(str), "/uc/oauth/member/getBasicInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError(OnAuthListener onAuthListener, int i2, String str, String str2) {
        if (onAuthListener == null || this.mCanceled) {
            return;
        }
        onAuthListener.onError(i2, str, str2);
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
        if (jSONObject == null || !jSONObject.has(OAuthConstants.KEY_OASIS_ACCOUNT_BOUND)) {
            return false;
        }
        Object objOpt = jSONObject.opt(OAuthConstants.KEY_OASIS_ACCOUNT_BOUND);
        return objOpt instanceof Boolean ? ((Boolean) objOpt).booleanValue() : TextUtils.equals("true", String.valueOf(objOpt));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readInputStream(InputStream inputStream) throws IOException {
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

    private void requestUserInfo(String str, OnUserInfoListener onUserInfoListener, boolean z4) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("token is null");
        }
        try {
            UserInfoTask userInfoTask = this.mUserInfoTask;
            if (userInfoTask != null && !userInfoTask.isCancelled()) {
                this.mUserInfoTask.cancel(true);
            }
            this.mUserInfoListener = onUserInfoListener;
            UserInfoTask userInfoTask2 = new UserInfoTask(z4);
            this.mUserInfoTask = userInfoTask2;
            userInfoTask2.execute(str);
        } catch (Exception e10) {
            if (onUserInfoListener != null) {
                onUserInfoListener.onFailed(OAuthConstants.UNKOWN_ERROR_CODE, e10.getMessage());
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
            UserInfoTask userInfoTask = this.mUserInfoTask;
            if (userInfoTask != null && !userInfoTask.isCancelled()) {
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
        } catch (Exception e10) {
            Log.e(TAG, "cancel error", e10);
        }
        this.mUserInfoListener = null;
    }

    public void factorValidate(Intent intent, FactorValidateListener factorValidateListener) {
        if (intent == null) {
            factorValidateListener.failure("Intent data is null.");
            return;
        }
        String stringExtra = intent.getStringExtra(OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (TextUtils.isEmpty(stringExtra)) {
            factorValidateListener.validateSuccess(intent.getStringExtra(OAuthConstants.FACTOR_RESULT_VALIDATE_CODE));
        } else {
            factorValidateListener.failure(stringExtra);
        }
    }

    public String[] getAuthToken(Activity activity) {
        return getAuthToken(true, activity);
    }

    public Intent getLinkOasisAccountIntent() {
        Intent intent = new Intent(OAuthConstants.LINK_OASIS_ACCOUNT_ACTION);
        intent.setPackage(OAuthConstants.ACCOUNT_TYPE);
        intent.addCategory("android.intent.category.DEFAULT");
        return intent;
    }

    public Account getLocalAccount() {
        return AccountUtil.getAccount(this.mContext);
    }

    public String getLocalAccountId() {
        return AccountUtil.getAccountUid(this.mContext);
    }

    public AccountInfo getLocalAccountInfo() {
        return AccountUtil.getAccountInfo(this.mContext);
    }

    public Intent getSimpleValidateMode(String str, String str2, String str3) {
        if (!isSupportFactorAuthenticator()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(OAuthConstants.FACTOR_ACTION);
        intent.setPackage(OAuthConstants.ACCOUNT_TYPE);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_TOKEN, str);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME, str2);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_SERVICE_NAME, str3);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_MODE, "SIMPLE");
        return intent;
    }

    public Intent getStrictValidateMode(String str, String str2, String str3) {
        if (!isSupportFactorAuthenticator()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(OAuthConstants.FACTOR_ACTION);
        intent.setPackage(OAuthConstants.ACCOUNT_TYPE);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_TOKEN, str);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME, str2);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_SERVICE_NAME, str3);
        intent.putExtra(OAuthConstants.FACTOR_PARAMS_MODE, "STRICT");
        return intent;
    }

    public void getUserInfo(String str, OnUserInfoListener onUserInfoListener) {
        requestUserInfo(str, onUserInfoListener, false);
    }

    public boolean isLoggedIn() {
        return AccountUtil.hasAccount(this.mContext);
    }

    public boolean isSupportFactorAuthenticator() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(OAuthConstants.ACCOUNT_TYPE, 128).metaData;
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
        Log.i(TAG, "env: " + str2 + ", url: " + this.url);
    }

    public String[] getAuthToken(boolean z4, Activity activity) {
        return getAuthToken(z4, 30L, activity);
    }

    public void getUserInfo(String str, OnUserInfoListener onUserInfoListener, boolean z4) {
        requestUserInfo(str, onUserInfoListener, z4);
    }

    public String[] getAuthToken(long j2, Activity activity) {
        return getAuthToken(true, j2, activity);
    }

    public String[] getAuthToken(boolean z4, long j2, Activity activity) throws AuthException {
        String string;
        if (j2 > 120) {
            j2 = 120;
        } else if (j2 < 0) {
            j2 = 30;
        }
        Log.d(TAG, "getAuthToken1  running... timeoutSeconds: " + j2);
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account account = AccountUtil.getAccount(this.mContext);
        if (account == null) {
            account = new Account("unknown", OAuthConstants.ACCOUNT_TYPE);
        }
        Account account2 = account;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z4);
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        this.mCanceled = false;
        AccountManagerFuture<Bundle> authToken = accountManager.getAuthToken(account2, this.mScope, bundle, activity, (AccountManagerCallback<Bundle>) null, (Handler) null);
        trackFuture(authToken);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[2];
        try {
            try {
                try {
                    Bundle result = authToken.getResult(j2, TimeUnit.SECONDS);
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
                } catch (OperationCanceledException e10) {
                    Log.w(TAG, "getAuthToken1, fail.", e10);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 > jCurrentTimeMillis && (jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000 > 25) {
                        throw new AuthException(10, this.mContext.getString(R.string.sync_timeout), e10);
                    }
                    throw new AuthException(4, this.mContext.getString(R.string.get_cancel), e10);
                }
            } catch (Exception e11) {
                Log.w(TAG, "getAuthToken1, fail.", e11);
                throw new AuthException(1, this.mContext.getString(R.string.error_is_throwed), e11);
            }
        } catch (Throwable th) {
            untrackFuture(authToken);
            throw th;
        }
    }

    public void getAuthToken(Activity activity, OnAuthListener onAuthListener) {
        getAuthToken(true, activity, onAuthListener);
    }

    public void getAuthToken(boolean z4, Activity activity, final OnAuthListener onAuthListener) {
        AccountManager accountManager = AccountManager.get(this.mContext);
        Account account = AccountUtil.getAccount(this.mContext);
        if (account == null) {
            account = new Account("unknown", OAuthConstants.ACCOUNT_TYPE);
        }
        Account account2 = account;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z4);
        this.mCanceled = false;
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        trackFuture(accountManager.getAuthToken(account2, this.mScope, bundle, activity, new AccountManagerCallback<Bundle>() { // from class: com.stepos.account.oauth.Authenticator.1
            @Override // android.accounts.AccountManagerCallback
            public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                String str = null;
                try {
                    try {
                    } catch (OperationCanceledException unused) {
                        Authenticator authenticator = Authenticator.this;
                        authenticator.handleError(onAuthListener, 4, authenticator.mContext.getString(R.string.get_cancel), null);
                    } catch (Exception e10) {
                        Authenticator authenticator2 = Authenticator.this;
                        authenticator2.handleError(onAuthListener, 1, authenticator2.mContext.getString(R.string.error_is_throwed), null);
                        Log.e(Authenticator.TAG, "[getAuthToken] " + e10.getMessage());
                    }
                    if (Authenticator.this.mCanceled) {
                        Log.d(Authenticator.TAG, "op canceled.");
                    } else {
                        Bundle result = accountManagerFuture.getResult();
                        if (result != null) {
                            if (result.containsKey("authtoken")) {
                                Authenticator.this.handleSuccess(onAuthListener, result.getString("authtoken"), result.getString("authsecret"));
                            } else if (result.containsKey("intent")) {
                                Authenticator.this.handleIntent(onAuthListener, (Intent) result.getParcelable("intent"));
                            } else if (result.containsKey("errorMessage")) {
                                try {
                                    List returnMessage = Authenticator.this.getReturnMessage(result);
                                    int iIntValue = ((Integer) returnMessage.get(0)).intValue();
                                    String str2 = (String) returnMessage.get(1);
                                    String str3 = (String) returnMessage.get(2);
                                    Authenticator authenticator3 = Authenticator.this;
                                    OnAuthListener onAuthListener2 = onAuthListener;
                                    if (!TextUtils.isEmpty(str3)) {
                                        str = str3;
                                    }
                                    authenticator3.handleError(onAuthListener2, iIntValue, str2, str);
                                } catch (Exception unused2) {
                                }
                            } else {
                                Authenticator authenticator4 = Authenticator.this;
                                authenticator4.handleError(onAuthListener, 11, authenticator4.mContext.getString(R.string.unkown_error), null);
                            }
                            return;
                        }
                        Authenticator authenticator5 = Authenticator.this;
                        authenticator5.handleError(onAuthListener, 5, authenticator5.mContext.getString(R.string.future_result_is_null), null);
                    }
                } finally {
                    Authenticator.this.untrackFuture(accountManagerFuture);
                }
            }
        }, (Handler) null));
    }
}
