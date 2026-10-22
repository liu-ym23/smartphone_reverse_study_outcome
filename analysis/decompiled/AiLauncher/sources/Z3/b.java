package Z3;

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
import com.stepos.account.oauth.AuthException;
import com.stepos.account.oauth.R$string;
import com.stepos.net.exception.ApiErrorCode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7280a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7281b;

    /* renamed from: c, reason: collision with root package name */
    public final List<AccountManagerFuture<Bundle>> f7282c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7283d;

    /* renamed from: e, reason: collision with root package name */
    public AsyncTaskC0123b f7284e;

    /* renamed from: f, reason: collision with root package name */
    public d f7285f;

    /* renamed from: g, reason: collision with root package name */
    public String f7286g;

    public class a implements AccountManagerCallback<Bundle> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7287a;

        public a(c cVar) {
            this.f7287a = cVar;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            String str = null;
            try {
                try {
                } finally {
                    b.this.B(accountManagerFuture);
                }
            } catch (OperationCanceledException unused) {
                b bVar = b.this;
                bVar.u(this.f7287a, 4, bVar.f7280a.getString(R$string.get_cancel), null);
            } catch (Exception e10) {
                b bVar2 = b.this;
                bVar2.u(this.f7287a, 1, bVar2.f7280a.getString(R$string.error_is_throwed), null);
                Log.e("[Cloud]Account.SDK", "[getAuthToken] " + e10.getMessage());
            }
            if (b.this.f7283d) {
                Log.d("[Cloud]Account.SDK", "op canceled.");
            } else {
                Bundle result = accountManagerFuture.getResult();
                if (result != null) {
                    if (result.containsKey("authtoken")) {
                        b.this.w(this.f7287a, result.getString("authtoken"), result.getString("authsecret"));
                    } else if (result.containsKey("intent")) {
                        b.this.v(this.f7287a, (Intent) result.getParcelable("intent"));
                    } else if (result.containsKey("errorMessage")) {
                        try {
                            List listR = b.this.r(result);
                            int iIntValue = ((Integer) listR.get(0)).intValue();
                            String str2 = (String) listR.get(1);
                            String str3 = (String) listR.get(2);
                            b bVar3 = b.this;
                            c cVar = this.f7287a;
                            if (!TextUtils.isEmpty(str3)) {
                                str = str3;
                            }
                            bVar3.u(cVar, iIntValue, str2, str);
                        } catch (Exception unused2) {
                        }
                    } else {
                        b bVar4 = b.this;
                        bVar4.u(this.f7287a, 11, bVar4.f7280a.getString(R$string.unkown_error), null);
                    }
                    return;
                }
                b bVar5 = b.this;
                bVar5.u(this.f7287a, 5, bVar5.f7280a.getString(R$string.future_result_is_null), null);
            }
        }
    }

    /* renamed from: Z3.b$b, reason: collision with other inner class name */
    public class AsyncTaskC0123b extends AsyncTask<String, Void, Map<String, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f7289a;

        public AsyncTaskC0123b(boolean z10) {
            this.f7289a = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0149 A[PHI: r4 r6 r7 r12
          0x0149: PHI (r4v9 ??) = (r4v7 ??), (r4v10 ??), (r4v10 ??), (r4v10 ??) binds: [B:56:0x0176, B:38:0x0144, B:74:0x0149, B:39:0x0146] A[DONT_GENERATE, DONT_INLINE]
          0x0149: PHI (r6v8 java.net.HttpURLConnection) = 
          (r6v6 java.net.HttpURLConnection)
          (r6v13 java.net.HttpURLConnection)
          (r6v13 java.net.HttpURLConnection)
          (r6v13 java.net.HttpURLConnection)
         binds: [B:56:0x0176, B:38:0x0144, B:74:0x0149, B:39:0x0146] A[DONT_GENERATE, DONT_INLINE]
          0x0149: PHI (r7v6 ??) = (r7v4 ??), (r7v18 ??), (r7v18 ??), (r7v18 ??) binds: [B:56:0x0176, B:38:0x0144, B:74:0x0149, B:39:0x0146] A[DONT_GENERATE, DONT_INLINE]
          0x0149: PHI (r12v12 java.lang.String) = (r12v9 java.lang.String), (r12v23 java.lang.String), (r12v23 java.lang.String), (r12v23 java.lang.String) binds: [B:56:0x0176, B:38:0x0144, B:74:0x0149, B:39:0x0146] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v10, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v18, types: [java.io.DataOutputStream, java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v22 */
        /* JADX WARN: Type inference failed for: r7v23 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0176 -> B:40:0x0149). Please report as a decompilation issue!!! */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.Map<java.lang.String, java.lang.Object> doInBackground(java.lang.String... r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 409
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: Z3.b.AsyncTaskC0123b.doInBackground(java.lang.String[]):java.util.Map");
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Map<String, Object> map) {
            if (b.this.f7285f != null) {
                int iIntValue = ((Integer) map.get("code")).intValue();
                if (iIntValue == 200) {
                    b.this.f7285f.a((JSONObject) map.get(UxipConstants.f30680s));
                } else {
                    b.this.f7285f.onFailed(iIntValue, map.containsKey(UxipConstants.f30680s) ? (String) map.get(UxipConstants.f30680s) : "unkown errror");
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    public b(Context context, String str) {
        this(context, str, q(context));
    }

    public static String o(String str) {
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

    public static String q(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "net_env");
    }

    public static String s(String str) {
        return "https://i." + o(str) + "/uc/oauth/member/getBasicInfo";
    }

    public static boolean x(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("oasisAccountBound")) {
            return false;
        }
        Object objOpt = jSONObject.opt("oasisAccountBound");
        return objOpt instanceof Boolean ? ((Boolean) objOpt).booleanValue() : TextUtils.equals("true", String.valueOf(objOpt));
    }

    public final void A(AccountManagerFuture<Bundle> accountManagerFuture) {
        synchronized (this.f7282c) {
            this.f7282c.add(accountManagerFuture);
        }
    }

    public final void B(AccountManagerFuture<Bundle> accountManagerFuture) {
        synchronized (this.f7282c) {
            this.f7282c.remove(accountManagerFuture);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String k() {
        /*
            r12 = this;
            java.lang.String r0 = "userId"
            android.content.Context r1 = r12.f7280a
            java.lang.String r2 = ""
            java.lang.String r3 = "[Cloud]Account.SDK"
            if (r1 != 0) goto L10
            java.lang.String r12 = "getAccountIdByOtherSign: context is null"
            android.util.Log.w(r3, r12)
            return r2
        L10:
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r4 = "content://com.stepos.account/login_account_id"
            android.net.Uri r6 = android.net.Uri.parse(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getAccountIdByOtherSign start, pkg="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r11 = ", uri="
            r4.append(r11)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r3, r4)
            r4 = 0
            android.content.Context r12 = r12.f7280a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            if (r4 != 0) goto L62
            java.lang.String r12 = "getAccountIdByOtherSign cursor=null"
            android.util.Log.w(r3, r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            if (r4 == 0) goto L54
            r4.close()
        L54:
            return r2
        L55:
            r0 = move-exception
            r12 = r0
            goto Ld7
        L59:
            r0 = move-exception
            r12 = r0
            goto L97
        L5c:
            r0 = move-exception
            r12 = r0
            goto Lb7
        L5f:
            r0 = move-exception
            r12 = r0
            goto Lce
        L62:
            boolean r12 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            if (r12 != 0) goto L71
            java.lang.String r12 = "getAccountIdByOtherSign cursor empty"
            android.util.Log.w(r3, r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            r4.close()
            return r2
        L71:
            int r12 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            if (r12 >= 0) goto L80
            java.lang.String r12 = "getAccountIdByOtherSign missing column: userId"
            android.util.Log.w(r3, r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            r4.close()
            return r2
        L80:
            java.lang.String r12 = r4.getString(r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            if (r0 == 0) goto L93
            java.lang.String r12 = "getAccountIdByOtherSign success but userId empty"
            android.util.Log.i(r3, r12)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59 java.lang.IllegalArgumentException -> L5c java.lang.SecurityException -> L5f
            r4.close()
            return r2
        L93:
            r4.close()
            return r12
        L97:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r0.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = "getAccountIdByOtherSign fail, pkg="
            r0.append(r5)     // Catch: java.lang.Throwable -> L55
            r0.append(r1)     // Catch: java.lang.Throwable -> L55
            r0.append(r11)     // Catch: java.lang.Throwable -> L55
            r0.append(r6)     // Catch: java.lang.Throwable -> L55
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L55
            android.util.Log.e(r3, r0, r12)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto Ld6
        Lb3:
            r4.close()
            goto Ld6
        Lb7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r0.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = "getAccountIdByOtherSign IllegalArgumentException, uri may not supported: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L55
            r0.append(r6)     // Catch: java.lang.Throwable -> L55
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L55
            android.util.Log.e(r3, r0, r12)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto Ld6
            goto Lb3
        Lce:
            java.lang.String r0 = "getAccountIdByOtherSign SecurityException, check permission com.stepos.account.permission.READ_ACCOUNT_INFO"
            android.util.Log.e(r3, r0, r12)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto Ld6
            goto Lb3
        Ld6:
            return r2
        Ld7:
            if (r4 == 0) goto Ldc
            r4.close()
        Ldc:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: Z3.b.k():java.lang.String");
    }

    public void l(boolean z10, Activity activity, c cVar) {
        AccountManager accountManager = AccountManager.get(this.f7280a);
        Account accountA = Z3.a.a(this.f7280a);
        if (accountA == null) {
            accountA = new Account("unknown", "com.stepos.account");
        }
        Account account = accountA;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z10);
        this.f7283d = false;
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        A(accountManager.getAuthToken(account, this.f7281b, bundle, activity, new a(cVar), (Handler) null));
    }

    public String[] m(boolean z10, long j10, Activity activity) throws AuthException {
        String string;
        if (j10 > 120) {
            j10 = 120;
        } else if (j10 < 0) {
            j10 = 30;
        }
        Log.d("[Cloud]Account.SDK", "getAuthToken1  running... timeoutSeconds: " + j10);
        AccountManager accountManager = AccountManager.get(this.f7280a);
        Account accountA = Z3.a.a(this.f7280a);
        if (accountA == null) {
            accountA = new Account("unknown", "com.stepos.account");
        }
        Account account = accountA;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z10);
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        this.f7283d = false;
        AccountManagerFuture<Bundle> authToken = accountManager.getAuthToken(account, this.f7281b, bundle, activity, (AccountManagerCallback<Bundle>) null, (Handler) null);
        A(authToken);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[2];
        try {
            try {
                Bundle result = authToken.getResult(j10, TimeUnit.SECONDS);
                B(authToken);
                Log.d("[Cloud]Account.SDK", "getAuthToken1  mCanceled: " + this.f7283d);
                if (this.f7283d) {
                    string = null;
                } else {
                    if (!result.containsKey("authtoken")) {
                        if (result.containsKey("intent")) {
                            throw new AuthException((Intent) result.getParcelable("intent"));
                        }
                        if (!result.containsKey("errorMessage")) {
                            throw new AuthException(11, this.f7280a.getString(R$string.unkown_error));
                        }
                        List<Object> listR = r(result);
                        throw new AuthException(((Integer) listR.get(0)).intValue(), (String) listR.get(1), (String) listR.get(2));
                    }
                    string = result.getString("authtoken");
                    strArr[0] = string;
                    strArr[1] = result.getString("authsecret");
                }
                if (!TextUtils.isEmpty(string)) {
                    return strArr;
                }
                if (authToken.isDone()) {
                    throw new AuthException(8, String.format(this.f7280a.getString(R$string.scope_null_token), this.f7281b));
                }
                Log.w("[Cloud]Account.SDK", "getAutoToken1. accountManagerFuture: " + authToken);
                throw new AuthException(6, this.f7280a.getString(R$string.unsupport_operation));
            } catch (OperationCanceledException e10) {
                Log.w("[Cloud]Account.SDK", "getAuthToken1, fail.", e10);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 <= jCurrentTimeMillis || (jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000 <= 25) {
                    throw new AuthException(4, this.f7280a.getString(R$string.get_cancel), e10);
                }
                throw new AuthException(10, this.f7280a.getString(R$string.sync_timeout), e10);
            } catch (Exception e11) {
                Log.w("[Cloud]Account.SDK", "getAuthToken1, fail.", e11);
                throw new AuthException(1, this.f7280a.getString(R$string.error_is_throwed), e11);
            }
        } catch (Throwable th) {
            B(authToken);
            throw th;
        }
    }

    public String[] n(boolean z10, Activity activity) throws AuthException {
        return m(z10, 30L, activity);
    }

    public Intent p() {
        Intent intent = new Intent("com.stepos.account.action.LINK_OASIS_ACCOUNT");
        intent.setPackage("com.stepos.account");
        intent.addCategory("android.intent.category.DEFAULT");
        return intent;
    }

    public final List<Object> r(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString("errorMessage");
        int i10 = bundle.containsKey("errorCode") ? bundle.getInt("errorCode") : -1;
        String string2 = bundle.containsKey("cacheAccountName") ? bundle.getString("cacheAccountName") : null;
        if (i10 >= 0) {
            arrayList.add(Integer.valueOf(i10));
            arrayList.add(string);
        } else if ("params not legal!".equalsIgnoreCase(string)) {
            arrayList.add(7);
            arrayList.add(this.f7280a.getString(R$string.context_is_null));
        } else if ("get token failed!".equalsIgnoreCase(string)) {
            arrayList.add(2);
            arrayList.add(this.f7280a.getString(R$string.get_token_failed));
        } else {
            if (("unknown type : " + this.f7281b).equalsIgnoreCase(string)) {
                arrayList.add(8);
                arrayList.add(String.format(this.f7280a.getString(R$string.scope_null_token), this.f7281b));
            } else if (!TextUtils.isEmpty(string) && string.startsWith("uid =") && string.contains("not match package")) {
                arrayList.add(9);
                arrayList.add(this.f7280a.getString(R$string.uid_not_match));
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

    public void t(String str, d dVar, boolean z10) {
        z(str, dVar, z10);
    }

    public final void u(c cVar, int i10, String str, String str2) {
        if (cVar == null || this.f7283d) {
            return;
        }
        cVar.c(i10, str, str2);
    }

    public final void v(c cVar, Intent intent) {
        if (cVar == null || this.f7283d) {
            return;
        }
        cVar.b(intent);
    }

    public final void w(c cVar, String str, String str2) {
        if (cVar == null || this.f7283d) {
            return;
        }
        cVar.a(str, str2);
    }

    public final String y(InputStream inputStream) throws Exception {
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

    public final void z(String str, d dVar, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("token is null");
        }
        try {
            AsyncTaskC0123b asyncTaskC0123b = this.f7284e;
            if (asyncTaskC0123b != null && !asyncTaskC0123b.isCancelled()) {
                this.f7284e.cancel(true);
            }
            this.f7285f = dVar;
            AsyncTaskC0123b asyncTaskC0123b2 = new AsyncTaskC0123b(z10);
            this.f7284e = asyncTaskC0123b2;
            asyncTaskC0123b2.execute(str);
        } catch (Exception e10) {
            if (dVar != null) {
                dVar.onFailed(ApiErrorCode.NETWORK_UNAVAILABLE, e10.getMessage());
            }
        }
    }

    public b(Context context, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        str = TextUtils.isEmpty(str) ? "basic" : str;
        this.f7280a = context.getApplicationContext();
        this.f7281b = str;
        this.f7282c = new ArrayList();
        this.f7286g = s(str2);
        Log.i("[Cloud]Account.SDK", "env: " + str2 + ", url: " + this.f7286g);
    }
}
