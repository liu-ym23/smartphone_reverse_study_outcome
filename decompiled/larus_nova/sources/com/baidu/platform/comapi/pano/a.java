package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.mt.protector.impl.UriProtector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AsyncHttpClient f33375a;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.pano.a$a, reason: collision with other inner class name */
    public class C0667a extends HttpClient.ProtoResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f33377b;

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError r100) {
            this.f33376a.a(r100);
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String r100) {
            this.f33376a.a(a.a(this.f33377b, r100));
        }

        public C0667a(a r100, b r101) {
            this.f33377b = r100;
            this.f33376a = r101;
        }
    }

    public interface b<T> {
        void a(HttpClient.HttpStateError r100);

        void a(T r100);
    }

    public a() {
        this.f33375a = new AsyncHttpClient();
    }

    private com.baidu.platform.comapi.pano.b a(String r100) {
        if (r100 == null) goto L32;
        if (r100.equals("") == true) goto L32;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L28
        JSONObject r102 = r101.optJSONObject("result");
        if (r102 != null) goto L12;
        return new com.baidu.platform.comapi.pano.b(PanoStateError.f33372c);
    L12:
        if (r102.optInt("error") != 0) goto L27;
        JSONArray r103 = r101.optJSONArray("content");
        if (r103 == null) goto L16;
        com.baidu.platform.comapi.pano.b r104 = null;
        int r105 = 0;
    L19:
        if (r105 >= r103.length()) goto L25;
        JSONObject r106 = r103.optJSONObject(r105).optJSONObject("poiinfo");
        if (r106 == null) goto L24;
        r104 = new com.baidu.platform.comapi.pano.b(PanoStateError.f33370a);
        r104.a(r106.optString("PID"));
        r104.a(r106.optInt("hasstreet"));
    L24:
        r105 = r105 + 1;
        goto L19
    L25:
        return r104;
    L16:
        return new com.baidu.platform.comapi.pano.b(PanoStateError.f33372c);
    L27:
        return new com.baidu.platform.comapi.pano.b(PanoStateError.f33371b);
    L28:
        e = move-exception;
        e.printStackTrace();
        return new com.baidu.platform.comapi.pano.b(PanoStateError.f33372c);
    L32:
        return new com.baidu.platform.comapi.pano.b(PanoStateError.f33372c);
    }

    private String a(Uri.Builder r100) {
        Uri.Builder r101 = UriProtector.parse(r100.build().toString() + HttpClient.getPhoneInfo()).buildUpon();
        r101.appendQueryParameter("sign", AppMD5.getSignMD5String(r101.build().getEncodedQuery()));
        return r101.build().toString();
    }

    public void a(String r100, b<com.baidu.platform.comapi.pano.b> r101) {
        Uri.Builder r102 = new Uri.Builder();
        if (HttpClient.isHttpsEnable == false) goto L5;
        r102.scheme("https");
    L6:
        r102.encodedAuthority("api.map.baidu.com");
        r102.path("/sdkproxy/lbs_androidsdk/pano/v1/");
        a(r102, "qt", AppletNaviType.POI);
        a(r102, "uid", r100);
        a(r102, "action", "0");
        String r103 = HttpClient.getAuthToken();
        if (r103 != null) goto L10;
        r101.a(new com.baidu.platform.comapi.pano.b(PanoStateError.f33373d));
        return;
    L10:
        a(r102, "token", r103);
        String r104 = a(r102);
        this.f33375a.get(r104, new C0667a(this, r101));
        return;
    L5:
        r102.scheme("http");
        goto L6
    }

    public static /* synthetic */ com.baidu.platform.comapi.pano.b a(a r100, String r101) {
        return r100.a(r101);
    }

    private void a(Uri.Builder r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r100.appendQueryParameter(r101, r102);
        return;
    }
}
