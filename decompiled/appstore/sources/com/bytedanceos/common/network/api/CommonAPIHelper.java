package com.bytedanceos.common.network.api;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.AdsReportRecordInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Model;
import com.bytedanceos.common.model.SearchParams;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.model.database.columns.AdsReportRecordColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.FetchURLDataCallBack;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.networkv2.params.NetValue;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q8.b;
import y8.d;
import y8.g;

/* JADX INFO: loaded from: classes2.dex */
public class CommonAPIHelper extends BaseAPIHelper {
    public CommonAPIHelper() {
    }

    public static void A(AppInfo r10, FetchDataCallBack r11) {
        JSONObject r12 = e.w(r10);
        if (r12 != null) goto L6;
        j.e("params error," + r10.appPackageName + " | " + r10.appVersionCode);
        r11.onFetchDataFailed(1700000, null, null, null);
        return;
    L6:
        JSONArray r13 = new JSONArray();
        r13.put(r12);
        BaseAPIHelper.i(5, 2, 1700000, null, null, r13.toString(), r11, null);
    }

    public static void B(Model r10, FetchDataCallBack r11) {
        HashMap r12 = new HashMap();
        r12.put("id", r10.getId());
        r12.put("package", r10.getName());
        if (BaseApplication.c().o() == false) goto L5;
        r12.put("source", String.valueOf(1));
    L6:
        BaseAPIHelper.i(5, 2, 1400004, null, r12, null, r11, r10);
        return;
    L5:
        r12.put("source", String.valueOf(2));
        goto L6
    }

    public static void C(AppInfo r10, int r11, FetchDataCallBack r12) {
        HashMap r13 = new HashMap();
        r13.put("size", "16");
        r13.put("page", String.valueOf(r11));
        r13.put("type", NetValue.TYPE_RANK);
        r13.put("packagename", r10.appPackageName);
        if (r10.isGame() == true) goto L6;
        r13.put(NetKey.PAGE_SOURCE, "1");
        int r14 = 2;
    L5:
        int r15 = r14;
        if (TextUtils.isEmpty(r10.secondCategoryId) == false) goto L10;
    L12:
        boolean r16 = false;
    L13:
        if (r16 == false) goto L15;
        String r17 = r10.secondCategoryId;
    L16:
        BaseAPIHelper.k(r15, 1, 400004, new Object[]{r17}, r13, null, r12);
        return;
    L15:
        r17 = r10.mCategoryId;
        goto L16
    L10:
        if (AdReportParam.ClickPosType.SKIP.equals(r10.secondCategoryId) == true) goto L12;
        r16 = true;
        goto L13
    L6:
        r14 = 3;
        goto L5
    }

    public static void D(List r10, FetchDataCallBack r11) {
        JSONArray r12 = new JSONArray();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        AppInfo r14 = (AppInfo) r13.next();
        JSONObject r15 = new JSONObject();
        r15.put("package", r14.appPackageName);     // Catch: JSONException -> L8
        r12.put(r15);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L11:
        if (r12.length() == 0) goto L14;
        String r16 = r12.toString();
    L13:
        String r17 = r16;
        if (BaseApplication.c().o() == false) goto L19;
        int r18 = 2;
    L20:
        BaseAPIHelper.k(r18, 2, 600006, null, null, r17, r11);
        return;
    L19:
        r18 = 3;
        goto L20
    L14:
        r16 = null;
        goto L13
    }

    public static void E(FetchDataCallBack r10) {
        if (BaseApplication.c().o() == false) goto L6;
        int r11 = 2;
    L7:
        BaseAPIHelper.h(r11, 1, 600001, null, null, null, r10);
        return;
    L6:
        r11 = 3;
        goto L7
    }

    public static void F(int r10, FetchDataCallBack r11) {
        BaseAPIHelper.h(r10, 1, 600003, null, null, null, r11);
    }

    public static void G(FetchDataCallBack r10) {
        R(2, Topic.ID_ONE_STEP, NetValue.AppStatusType.REQUEST_DOWNLOAD, 1, 400005, r10);
    }

    public static void H(int r10, FetchDataCallBack r11) {
        R(2, Topic.ID_ONE_STEP, "20", r10, 200004, r11);
    }

    public static void I(int r10, Object r11, FetchDataCallBack r12) {
        BaseAPIHelper.l(r10, 1, 700002, new Object[]{r11}, null, null, r12, r11);
    }

    public static void J(int r10, Object r11, int r12, int r13, FetchDataCallBack r14) {
        HashMap r15 = new HashMap();
        r15.put("page_id", String.valueOf(r12));
        r15.put("tid", r11.toString());
        BaseAPIHelper.k(r10, 1, r13, null, r15, null, r14);
    }

    public static void K(int r10, Object r11, int r12, FetchDataCallBack r13) {
        J(r10, r11, r12, 2000001, r13);
    }

    public static void L(String r10, FetchURLDataCallBack r11, CountDownLatch r12) {
        BaseAPIHelper.g(1, r10, new Object[]{""}, null, null, new d(0, r10, r11, r12));
    }

    public static void M(String r10) {
        HashMap r11 = new HashMap();
        r11.put("kwd", r10);
        if (BaseApplication.c().o() == false) goto L5;
        r11.put("source", String.valueOf(1));
    L6:
        BaseAPIHelper.i(5, 1, 500001, null, r11, null, b.c(), r10);
        return;
    L5:
        r11.put("source", String.valueOf(2));
        goto L6
    }

    public static void N() {
        if (BaseApplication.c().o() == false) goto L6;
        int r10 = 2;
    L5:
        int r11 = r10;
        BaseAPIHelper.h(r11, 1, 1100000, null, null, null, b.c());
        return;
    L6:
        r10 = 3;
        goto L5
    }

    public static void O(int r10, Object r11, int r12, FetchDataCallBack r13) {
        R(r10, r11, "20", r12, 200003, r13);
    }

    public static void P(String r10, FetchDataCallBack r11) {
        HashMap r12 = new HashMap();
        r12.put(ServerElements.DOWNLOAD_URL, r10);
        if (BaseApplication.c().o() == false) goto L6;
        int r13 = 2;
    L7:
        BaseAPIHelper.h(r13, 1, 1100001, null, r12, null, r11);
        return;
    L6:
        r13 = 3;
        goto L7
    }

    public static void Q(int r10, Object r11, int r12, FetchDataCallBack r13) {
        R(r10, r11, "20", r12, 200001, r13);
    }

    public static void R(int r10, Object r11, String r12, int r13, int r14, FetchDataCallBack r15) {
        HashMap r16 = new HashMap();
        r16.put("size", r12);
        r16.put("page", String.valueOf(r13));
        r16.put("tid", r11.toString());
        String r17 = "1";
        if (r14 != 200003) goto L6;
        r16.put("type", "2");
    L8:
        if (r14 == 200003) goto L11;
        r17 = AdReportParam.ClickPosType.SKIP;
    L11:
        r16.put("referer", r17);
        BaseAPIHelper.k(r10, 1, r14, null, r16, null, r15);
        return;
    L6:
        if (r14 != 400005) goto L8;
        r16.put(NetKey.PAGE_SOURCE, "1");
        goto L8
    }

    public static void S(FetchDataCallBack r10, String r11, String r12) {
        HashMap r13 = new HashMap();
        r13.put("name", r11);
        r13.put("package", r12);
        if (BaseApplication.c().o() == false) goto L5;
        r13.put("source", String.valueOf(1));
    L6:
        BaseAPIHelper.k(5, 1, 2200000, null, r13, null, r10);
        return;
    L5:
        r13.put("source", String.valueOf(2));
        goto L6
    }

    public static void T(List r10, FetchDataCallBack r11, int r12) {
        JSONArray r13 = new JSONArray();
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L11;
        AppInfo r15 = (AppInfo) r14.next();
        JSONObject r16 = new JSONObject();
        r16.put("package", r15.appPackageName);     // Catch: JSONException -> L8
        r16.put("status", r12);     // Catch: JSONException -> L8
        r16.put("op_time", r15.appOpTime);     // Catch: JSONException -> L8
        r13.put(r16);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L11:
        if (r13.length() == 0) goto L14;
        String r17 = r13.toString();
    L13:
        String r18 = r17;
        if (BaseApplication.c().o() == false) goto L19;
        int r19 = 2;
    L20:
        BaseAPIHelper.k(r19, 2, 600004, null, null, r18, r11);
        return;
    L19:
        r19 = 3;
        goto L20
    L14:
        r17 = null;
        goto L13
    }

    public static void U(String r10, AppInfo r11, String r12, int r13) {
        JSONObject r14 = new JSONObject();
        r14.put(ServerElements.CODE, r13);     // Catch: JSONException -> L5
        r14.put("reason", r12);     // Catch: JSONException -> L5
        r14.put(NetKey.OSVER, e.U(true));     // Catch: JSONException -> L5
    L8:
        if (r14.length() != 0) goto L10;
        String r15 = "";
    L11:
        j.n("reportFailedReason: " + r15);
        s.b(r10, r11, r15);
        return;
    L10:
        r15 = r14.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static void V(AppInfo r10) {
        s.a("30", r10);
    }

    public static void W(int r13, List r14, FetchDataCallBack r15, String r16, boolean r17) {
        JSONArray r10 = new JSONArray();
        long r11 = System.currentTimeMillis();
        Iterator r12 = r14.iterator();
    L3:
        String r18 = null;
        if (r12.hasNext() == false) goto L10;
        AppInfo r19 = (AppInfo) r12.next();
        JSONObject r20 = e.w(r19);
        if (r20 == null) goto L7;
        r10.put(r20);
        goto L3
    L7:
        j.e("reportUpdates params error," + r19.appPackageName + " | " + r19.appVersionCode);
        r15.onFetchDataFailed(600002, null, null, null);
        return;
    L10:
        j.e("get update params time:" + (System.currentTimeMillis() - r11));
        if (r10.length() == 0) goto L13;
        r18 = r10.toString();
    L13:
        String r110 = r18;
        HashMap r111 = new HashMap();
        r111.put("from", r16);
        if (r17 == false) goto L16;
        r111.put("action", "push");
    L16:
        BaseAPIHelper.k(r13, 2, 600002, null, r111, r110, r15);
    }

    public static void X(FetchDataCallBack r10, String r11) {
        HashMap r12 = new HashMap();
        r12.put("package", r11);
        BaseAPIHelper.k(5, 1, 2300000, null, r12, null, r10);
    }

    public static void Y(int r10, SearchParams r11) {
        HashMap r12 = new HashMap();
        r12.put("page", String.valueOf(r11.mPageNo));
        r12.put("size", "20");
        r12.put("kwd", r11.mSearchKey);
        JSONObject r13 = r11.mParams;
        if (r13 != null) goto L5;
    L7:
        boolean r14 = BaseApplication.c().o();
        int r15 = 2;
        if (r14 == false) goto L10;
        r12.put("version", String.valueOf(2));
        int r16 = 2;
    L12:
        if (TextUtils.isEmpty(r11.mSource) == false) goto L16;
        if (r14 == false) goto L15;
        r15 = 1;
    L15:
        r12.put("source", String.valueOf(r15));
    L18:
        if (TextUtils.isEmpty(r11.mTraceId) == true) goto L20;
        r12.put("trace_id", r11.mTraceId);
    L20:
        r12.put("package", r11.mPackage);
        BaseAPIHelper.l(r16, 1, r10, null, r12, null, b.c(), r11.mSearchFrom);
        return;
    L16:
        r12.put("source", r11.mSource);
        goto L18
    L10:
        r16 = 3;
        goto L12
    L5:
        if (TextUtils.isEmpty(r13.optString(ServerElements.CONTEXTDATA)) == true) goto L7;
        r12.put(ServerElements.CONTEXTDATA, r11.mParams.optString(ServerElements.CONTEXTDATA));
        goto L7
    }

    public static void Z(int r10, SearchParams r11) {
        if (BaseApplication.c().o() == false) goto L5;
        r11.mSource = "1";
    L6:
        Y(r10, r11);
        return;
    L5:
        r11.mSource = "4";
        goto L6
    }

    public static void a0(AdsReportRecordInfo r10, FetchURLDataCallBack r11) {
        d r12 = new d(1800000, r10.mReportUrl, r11, r10);
        HashMap r13 = new HashMap();
        r13.put("timestamp", String.valueOf(r10.mEventTime));
        r13.put(AdsReportRecordColumns.ADS_IS_UPDATE, String.valueOf(r10.mAppUpdate));
        int r14 = r10.mEventType;
        if (r14 != 5) goto L6;
        r13.put("event_type", String.valueOf(1));
    L11:
        BaseAPIHelper.g(1, r10.mReportUrl, null, r13, null, r12);
        return;
    L6:
        if (r14 != 6) goto L9;
        r13.put("event_type", String.valueOf(2));
        goto L11
    L9:
        if (r14 != 7) goto L11;
        r13.put("event_type", String.valueOf(3));
        goto L11
    }

    public static void b0(String r10, FetchDataCallBack r11) {
        BaseAPIHelper.h(5, 2, 1300000, null, null, r10, r11);
    }

    public static void c0(String r10, int r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return;
    L10:
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L7
        r13.put("search_keywords", r10);     // Catch: Exception -> L7
        r13.put("search_result", r11);     // Catch: Exception -> L7
        r13.put("automated_keywords", r12);     // Catch: Exception -> L7
        BaseAPIHelper.i(5, 2, 1900000, null, null, r13.toString(), null, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d0(int r10, int r11, int r12, FetchDataCallBack r13, Object r14) {
        String r15 = null;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        r16.put("app_id", r11);     // Catch: Exception -> L6
        r16.put("comment_id", r12);     // Catch: Exception -> L6
    L11:
        if (r16 != null) goto L13;
    L15:
        BaseAPIHelper.i(r10, 2, 700010, null, null, r15, r13, r14);
        return;
    L13:
        if (r16.length() == 0) goto L15;
        r15 = r16.toString();
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r16 = null;
        goto L10
    }

    public static void e0(FetchDataCallBack r10) {
        Map<String, AppInfo> r11 = DataBaseManager.AccountTable.getMyAppsToReport(BaseApplication.c());
        if (r11 != null) goto L5;
    L9:
        if (r10 == null) goto L12;
        r10.onFetchDataSuccess(600004, 0, null, null, null);
        return;
    L12:
        return;
    L5:
        if (r11.isEmpty() == true) goto L9;
        T(new ArrayList(r11.values()), r10, 1);
    }

    public static void f0(FetchDataCallBack r13) {
        List<AppInfo> r10 = DataBaseManager.AccountCollectionsTable.getCollectionsToReport(BaseApplication.c());
        if (r10 != null) goto L5;
    L27:
        if (r13 == null) goto L36;
        r13.onFetchDataSuccess(600005, 0, null, null, null);
        return;
    L36:
        return;
    L5:
        if (r10.isEmpty() == true) goto L27;
        JSONArray r11 = new JSONArray();
        Iterator<AppInfo> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        AppInfo r14 = r12.next();
        JSONObject r15 = new JSONObject();
        r15.put("package", r14.appPackageName);     // Catch: JSONException -> L13
        r15.put("status", r14.isCollected ? 1 : 0);     // Catch: JSONException -> L13
        r11.put(r15);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L16:
        if (r11.length() == 0) goto L19;
        String r16 = r11.toString();
    L18:
        String r17 = r16;
        if (BaseApplication.c().o() == false) goto L24;
        int r18 = 2;
    L25:
        BaseAPIHelper.k(r18, 2, 600005, null, null, r17, r13);
        return;
    L24:
        r18 = 3;
        goto L25
    L19:
        r16 = null;
        goto L18
    }

    public static void g0(int r10, int r11, int r12, FetchDataCallBack r13, Object r14) {
        String r15 = null;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        r16.put("app_id", r11);     // Catch: Exception -> L6
        r16.put("comment_id", r12);     // Catch: Exception -> L6
    L11:
        if (r16 != null) goto L13;
    L15:
        BaseAPIHelper.i(r10, 2, 700012, null, null, r15, r13, r14);
        return;
    L13:
        if (r16.length() == 0) goto L15;
        r15 = r16.toString();
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r16 = null;
        goto L10
    }

    public static void n(int r10, String r11, String r12, String r13, String r14, String r15, FetchDataCallBack r16) {
        HashMap r17 = new HashMap();
        r17.put("package", r11);
        r17.put("version", r12);
        r17.put("version_code", r13);
        r17.put("score", r14);
        r17.put(ServerElements.CONTENT, r15);
        BaseAPIHelper.h(r10, 2, 700007, null, null, g.a(r17), r16);
    }

    public static void o(FetchDataCallBack r10, String r11) {
        HashMap r12 = new HashMap();
        r12.put("package", r11);
        BaseAPIHelper.k(5, 1, 2100000, null, r12, null, r10);
    }

    public static void p(FetchDataCallBack r10, ArrayList r11) {
        T(r11, r10, 2);
    }

    public static void q(int r10, Object r11, int r12, FetchDataCallBack r13) {
        Object[] r14 = {r11};
        HashMap r15 = new HashMap();
        r15.put("size", "20");
        r15.put("page", String.valueOf(r12));
        AppInfo r16 = BaseApplication.c().b().D((String) r11);
        if (r16 == null) goto L5;
        r15.put("version", "" + r16.appVersionCode);
    L5:
        BaseAPIHelper.l(r10, 1, 700004, r14, r15, null, r13, Integer.valueOf(r12));
    }

    public static void r(int r10, int r11, String r12, FetchDataCallBack r13) {
        HashMap r14 = new HashMap();
        r14.put("package", r12);
        BaseAPIHelper.l(r10, 1, r11, null, r14, null, r13, r12);
    }

    public static void s(int r10, Object r11, FetchDataCallBack r12) {
        BaseAPIHelper.l(r10, 1, 700001, new Object[]{r11}, null, null, r12, r11);
    }

    public static void t(int r10, Object r11, int r12, int r13, FetchDataCallBack r14) {
        HashMap r15 = new HashMap();
        r15.put("size", String.valueOf(r12));
        r15.put("page", String.valueOf(r13));
        r15.put(ServerElements.IFLIKE, "1");
        BaseAPIHelper.k(r10, 1, 700005, new Object[]{r11}, r15, null, r14);
    }

    public static void u(Object r10, FetchDataCallBack r11, String r12) {
        BaseAPIHelper.j(5, 1, 700006, new Object[]{r10}, null, null, r11, null, r12);
    }

    public static void v(long r10, int r11, FetchDataCallBack r12) {
        HashMap r13 = new HashMap();
        r13.put("page", String.valueOf(r11));
        r13.put(ServerElements.GROUP_ID, String.valueOf(r10));
        Object[] r14 = {Long.valueOf(r10), Long.valueOf(r10)};
        if (BaseApplication.c().o() == false) goto L6;
        int r15 = 2;
    L7:
        BaseAPIHelper.k(r15, 1, 2000003, r14, r13, null, r12);
        return;
    L6:
        r15 = 3;
        goto L7
    }

    public static void w(Object r10, String r11, int r12, FetchDataCallBack r13) {
        HashMap r14 = new HashMap();
        r14.put("size", "20");
        r14.put("page", String.valueOf(r12));
        r14.put("type", NetValue.TYPE_RANK);
        Object[] r15 = {r10, r11};
        if (BaseApplication.c().o() == false) goto L6;
        int r16 = 2;
    L7:
        BaseAPIHelper.k(r16, 1, 400003, r15, r14, null, r13);
        return;
    L6:
        r16 = 3;
        goto L7
    }

    public static void x(String r10, FetchDataCallBack r11) {
        HashMap r12 = new HashMap(1);
        r12.put("cid", r10);
        if (BaseApplication.c().o() == false) goto L6;
        int r13 = 2;
    L7:
        BaseAPIHelper.k(r13, 1, 2000002, null, r12, null, r11);
        return;
    L6:
        r13 = 3;
        goto L7
    }

    public static void y(int r10, Object r11, FetchDataCallBack r12) {
        BaseAPIHelper.h(r10, 1, 700008, new Object[]{r11}, null, null, r12);
    }

    public static void z(int r10, Object r11, Object r12, int r13, FetchDataCallBack r14) {
        String r15 = null;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        r16.put(ServerElements.DEVELOPER, String.valueOf(r11));     // Catch: Exception -> L6
        r16.put("size", "20");     // Catch: Exception -> L6
        r16.put("page", String.valueOf(r13));     // Catch: Exception -> L6
        r16.put(ServerElements.DEVER_ID, String.valueOf(r12));     // Catch: Exception -> L6
    L11:
        if (r16 != null) goto L13;
    L15:
        BaseAPIHelper.h(r10, 2, 700011, null, null, r15, r14);
        return;
    L13:
        if (r16.length() == 0) goto L15;
        r15 = r16.toString();
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r16 = null;
        goto L10
    }
}
