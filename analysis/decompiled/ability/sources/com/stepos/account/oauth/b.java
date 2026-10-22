package com.stepos.account.oauth;

import android.os.AsyncTask;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3447a;
    public final /* synthetic */ Authenticator b;

    public b(Authenticator authenticator, boolean z10) {
        this.b = authenticator;
        this.f3447a = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013d A[PHI: r0 r9 r11 r13
      0x013d: PHI (r0v13 java.lang.String) = (r0v10 java.lang.String), (r0v23 java.lang.String), (r0v23 java.lang.String), (r0v23 java.lang.String) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r9v9 java.net.HttpURLConnection) = 
      (r9v7 java.net.HttpURLConnection)
      (r9v15 java.net.HttpURLConnection)
      (r9v15 java.net.HttpURLConnection)
      (r9v15 java.net.HttpURLConnection)
     binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r11v9 ??) = (r11v7 ??), (r11v10 ??), (r11v10 ??), (r11v10 ??) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r13v6 ??) = (r13v4 ??), (r13v13 ??), (r13v13 ??), (r13v13 ??) binds: [B:56:0x016a, B:38:0x0138, B:74:0x013d, B:39:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
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
    /* JADX WARN: Type inference failed for: r11v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00ec -> B:91:0x0152). Please report as a decompilation issue!!! */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.account.oauth.b.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Map map = (Map) obj;
        Authenticator authenticator = this.b;
        if (authenticator.mUserInfoListener != null) {
            int iIntValue = ((Integer) map.get("code")).intValue();
            if (iIntValue == 200) {
                authenticator.mUserInfoListener.onSuccess((JSONObject) map.get("value"));
            } else {
                authenticator.mUserInfoListener.onFailed(iIntValue, map.containsKey("value") ? (String) map.get("value") : "unkown errror");
            }
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
    }
}
