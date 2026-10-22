package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private AsyncHttpClient f8562a = new AsyncHttpClient();

    /* renamed from: b, reason: collision with root package name */
    private Handler f8563b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    protected final Lock f8564c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private boolean f8565d = true;

    /* renamed from: e, reason: collision with root package name */
    private DistrictResult f8566e = null;

    /* renamed from: f, reason: collision with root package name */
    private SearchType f8567f;

    /* renamed from: com.baidu.platform.base.a$a, reason: collision with other inner class name */
    public class C0043a extends HttpClient.ProtoResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.platform.base.b f8568a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f8569b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f8570c;

        public C0043a(com.baidu.platform.base.b bVar, c cVar, Object obj) {
            this.f8568a = bVar;
            this.f8569b = cVar;
            this.f8570c = obj;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError httpStateError) {
            a.this.a(httpStateError, this.f8569b.a(), this.f8568a, this.f8570c);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSuccess(java.lang.String r10) {
            /*
                r9 = this;
                com.baidu.platform.base.a r0 = com.baidu.platform.base.a.this
                boolean r0 = com.baidu.platform.base.a.a(r0, r10)
                if (r0 != 0) goto L1f
                com.baidu.platform.base.b r0 = r9.f8568a
                boolean r0 = r0 instanceof com.baidu.platform.core.geocode.d
                if (r0 == 0) goto L15
                com.baidu.platform.base.a r0 = com.baidu.platform.base.a.this
                java.lang.String r0 = com.baidu.platform.base.a.b(r0, r10)
                goto L17
            L15:
                java.lang.String r0 = ""
            L17:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L1f
                r3 = r0
                goto L20
            L1f:
                r3 = r10
            L20:
                com.baidu.platform.base.a r2 = com.baidu.platform.base.a.this
                com.baidu.platform.base.c r10 = r9.f8569b
                java.lang.String r4 = r10.a()
                com.baidu.platform.base.b r5 = r9.f8568a
                java.lang.Object r6 = r9.f8570c
                com.baidu.platform.base.a r10 = com.baidu.platform.base.a.this
                com.baidu.mapapi.http.AsyncHttpClient r7 = com.baidu.platform.base.a.a(r10)
                r8 = r9
                com.baidu.platform.base.a.a(r2, r3, r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.base.a.C0043a.onSuccess(java.lang.String):void");
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.platform.base.b f8572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchResult f8573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f8574c;

        public b(com.baidu.platform.base.b bVar, SearchResult searchResult, Object obj) {
            this.f8572a = bVar;
            this.f8573b = searchResult;
            this.f8574c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8572a != null) {
                a.this.f8564c.lock();
                try {
                    this.f8572a.a(this.f8573b, this.f8574c);
                } finally {
                    a.this.f8564c.unlock();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        byte[] urlNeedInfo = {102, 97, 105, 108, 100};
        try {
            urlNeedInfo = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
        } catch (Exception unused) {
            Log.e("BaseSearch", "transform result failed");
        }
        return new String(urlNeedInfo).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        int iPermissionCheck;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") && !jSONObject.has("status_sp")) {
                return true;
            }
            int i4 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
            if ((i4 != 105 && i4 != 106) || (iPermissionCheck = PermissionCheck.permissionCheck()) == 0) {
                return true;
            }
            Log.e("BaseSearch", "permissionCheck result is: " + iPermissionCheck);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public boolean a(c cVar, Object obj, com.baidu.platform.base.b bVar) {
        if (bVar == null) {
            Log.e("a", "The SearchParser is null, must be applied.");
            return false;
        }
        SearchType searchTypeA = bVar.a();
        this.f8567f = searchTypeA;
        String strB = cVar.b(searchTypeA);
        if (strB == null) {
            Log.e("BaseSearch", "The sendurl is: " + strB);
            a(bVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, bVar);
            return false;
        }
        if (this.f8567f == SearchType.INTEGRAL_ROUTE && !PermissionUtils.getInstance().isIntegralRoutePlanAuthorized()) {
            Log.e("BaseSearch", "isIntegralRoutePlanAuthorized is false");
            a(bVar.a("{SDK_InnerError:{NO_ADVANCED_PERMISSION:IntegralRoutePlanAuthorized}}"), obj, bVar);
            return false;
        }
        this.f8562a.get(strB, new C0043a(bVar, cVar, obj));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.baidu.platform.base.b bVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult searchResultA = bVar.a(str);
        if (searchResultA != null) {
            searchResultA.setCustomExtra(str2);
        }
        searchResultA.status = a(str);
        if (a(bVar, searchResultA)) {
            a(asyncHttpClient, protoResultCallback, searchResultA);
            return;
        }
        if (bVar instanceof com.baidu.platform.core.district.b) {
            DistrictResult districtResult = this.f8566e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) searchResultA;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.f8566e.getCenterPt());
            }
            a(searchResultA, obj, bVar);
            this.f8565d = true;
            this.f8566e = null;
            ((com.baidu.platform.core.district.b) bVar).a(false);
            return;
        }
        a(searchResultA, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, String str, com.baidu.platform.base.b bVar, Object obj) {
        SearchResult searchResultA = bVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}");
        if (searchResultA != null) {
            searchResultA.setCustomExtra(str);
        }
        a(searchResultA, obj, bVar);
    }

    private void a(SearchResult searchResult, Object obj, com.baidu.platform.base.b bVar) {
        this.f8563b.post(new b(bVar, searchResult, obj));
    }

    private boolean a(com.baidu.platform.base.b bVar, SearchResult searchResult) {
        if (!(bVar instanceof com.baidu.platform.core.district.b)) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) searchResult;
        if (SearchResult.ERRORNO.RESULT_NOT_FOUND != districtResult.error || districtResult.getCityName() == null || !this.f8565d) {
            return false;
        }
        this.f8565d = false;
        this.f8566e = districtResult;
        ((com.baidu.platform.core.district.b) bVar).a(true);
        return true;
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.district.c(((DistrictResult) searchResult).getCityName()).b(this.f8567f), protoResultCallback);
    }

    private int a(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                if (!jSONObject.has("result") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null) {
                    return 10204;
                }
                return jSONObjectOptJSONObject.optInt("error");
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return 10204;
    }
}
