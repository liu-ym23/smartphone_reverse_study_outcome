package c9;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppComments;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoFilterInterface;
import com.bytedanceos.common.model.AppList;
import com.bytedanceos.common.model.AppScreenShotsKt;
import com.bytedanceos.common.model.BaseAppInfo;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.model.CommentInfo;
import com.bytedanceos.common.model.GiftPackInfo;
import com.bytedanceos.common.model.GroupInfo;
import com.bytedanceos.common.model.ImagesInfo;
import com.bytedanceos.common.model.PageDataBean;
import com.bytedanceos.common.model.RecommendAppGroupInfo;
import com.bytedanceos.common.model.RelatedAppInfo;
import com.bytedanceos.common.model.RelatedAppInfos;
import com.bytedanceos.common.model.ReserveInfo;
import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.model.SearchResultInfo;
import com.bytedanceos.common.model.SplitInfo;
import com.bytedanceos.common.model.SupposeAppInfo;
import com.bytedanceos.common.model.TopAdAppInfo;
import com.bytedanceos.common.model.TopAdAppInfos;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.VideoInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.f0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.adapter.TopicListAdapter;
import com.google.gson.Gson;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ServerElements {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f6067a = null;

    /* JADX INFO: renamed from: c9.a$a, reason: collision with other inner class name */
    public class C0069a implements Comparator {
        public C0069a() {
        }

        public int a(AppInfoFilterInterface r10, AppInfoFilterInterface r11) {
            return BaseApplication.c().b().x(r10.getPackageNameForFilter()) - BaseApplication.c().b().x(r11.getPackageNameForFilter());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((AppInfoFilterInterface) r10, (AppInfoFilterInterface) r11);
        }
    }

    public class b implements Comparator {
        public b() {
        }

        public int a(SearchHotWords r10, SearchHotWords r11) {
            if (TextUtils.isEmpty(r10.getSort()) == false) goto L9;
            if (TextUtils.isEmpty(r11.getSort()) == false) goto L9;
            return 0;
        L9:
            if (TextUtils.isEmpty(r10.getSort()) == false) goto L13;
            return -1;
        L13:
            if (TextUtils.isEmpty(r11.getSort()) == false) goto L17;
            return 1;
        L17:
            return r10.getSort().compareTo(r11.getSort());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((SearchHotWords) r10, (SearchHotWords) r11);
        }
    }

    static {
        f6067a = new C0069a();
    }

    public static List A(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L13
        if (r12.isNull("permission") == true) goto L15;
        JSONArray r13 = r12.optJSONArray("permission");     // Catch: Exception -> L13
        int r14 = 0;
    L10:
        if (r14 >= r13.length()) goto L15;
        r11.add(r13.getString(r14));     // Catch: Exception -> L13
        r14 = r14 + 1;
    L15:
        return r11;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static AppList B(String r10, String r11) {
        return C(r10, r11, 1);
    }

    public static AppList C(String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        AppList r13 = new AppList();
        JSONObject r14 = new JSONObject(r10);     // Catch: Exception -> L17
        JSONObject r15 = r14.optJSONObject(ServerElements.BODY);     // Catch: Exception -> L17
        int r16 = 0;
        boolean r17 = r14.optJSONObject(ServerElements.HEAD).optBoolean(ServerElements.HAS_MORE, false);     // Catch: Exception -> L17
        JSONArray r18 = r15.optJSONArray(ServerElements.BANNER_LIST);     // Catch: Exception -> L17
        if (r18 != null) goto L10;
    L23:
        List<AppInfo> r19 = F(r15, r12, r11);     // Catch: Exception -> L17
        r13.setMore(r17);     // Catch: Exception -> L17
        r13.setDataList(r19);     // Catch: Exception -> L17
        int r20 = r15.optInt(ServerElements.LAST_APP_ID);     // Catch: Exception -> L17
        if (r20 <= 0) goto L28;
        r13.setLastId(r20);     // Catch: Exception -> L17
    L28:
        return r13;
    L10:
        if (r18.length() <= 0) goto L23;
        ArrayList r21 = new ArrayList();     // Catch: Exception -> L17
    L13:
        if (r16 >= r18.length()) goto L21;
        String r22 = r18.getString(r16);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r22) == true) goto L19;
        r21.add(r22);     // Catch: Exception -> L17
    L19:
        r16 = r16 + 1;     // Catch: Exception -> L17
        goto L13
    L21:
        if (r21.size() <= 0) goto L23;
        r13.setBannerUrls(r21);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public static int D(List r10) {
        int r11 = r10.size() / 3;
        if (r11 != 1) goto L5;
        return 106;
    L5:
        if (r11 == 2) goto L8;
        return 13;
    L8:
        return 107;
    }

    public static RecommendAppGroupInfo E(JSONObject r10) {
        RecommendAppGroupInfo r11 = new RecommendAppGroupInfo();
        r11.name = r10.optString("name");
        r11.identity = r10.optString("identity");
        r11.sort = r10.optString(ServerElements.SORT);
        r11.appInfoList = new ArrayList();
        JSONArray r12 = r10.getJSONArray(ServerElements.INFO);
        int r13 = 0;
    L4:
        if (r13 >= r12.length()) goto L6;
        AppInfo r14 = t(r12.optJSONObject(r13));
        r14.mApiUrl = BaseApplication.c().l();
        r11.appInfoList.add(r14);
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    public static List F(JSONObject r24, int r25, String r26) {
        String r10 = "apps";
        JSONArray r11 = r24.optJSONArray("apps");
        JSONObject r12 = r24.optJSONObject(ServerElements.PROMOTE);
        JSONArray r13 = r24.optJSONArray(ServerElements.AD_APPS);
        if (r12 == null) goto L5;
        JSONArray r14 = r12.optJSONArray(ServerElements.LIST);
        JSONArray r15 = r12.optJSONArray(ServerElements.GROUP);
        JSONArray r16 = r12.optJSONArray(ServerElements.BANNER);
    L6:
        if (r11 != null) goto L8;
        int r17 = 0;
    L9:
        if (r14 != null) goto L11;
        int r18 = 0;
    L12:
        if (r15 != null) goto L14;
        int r19 = 0;
    L15:
        if (r16 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = ((r17 + r18) + r19) + r110;
        GroupInfo[] r112 = new GroupInfo[r111];
        int r113 = r25 - 1;
        int r114 = c0.b("20") * r113;
        ArrayList r115 = new ArrayList();
        if (r13 == null) goto L30;
        if (r13.length() <= 0) goto L30;
        int r116 = 0;
    L24:
        if (r116 >= r13.length()) goto L30;
        JSONObject r20 = r13.getJSONObject(r116);
        if (e.x0(r20.optString("package")) == true) goto L28;
        r115.add(t(r20));
    L28:
        r116 = r116 + 1;
    L30:
        int r21 = 0;
    L32:
        if (r21 >= r17) goto L50;
        JSONObject r117 = r11.optJSONObject(r21);
        int r22 = r21 + 1;
        JSONArray r23 = r11;
        int r27 = (c0.b("20") * r113) + r22;
        StringBuilder r28 = new StringBuilder();
        int r29 = r17;
        r28.append("&position=");
        r28.append(r27);
        String r30 = r28.toString();
        AppInfo r31 = u(r117, r30);
        if (r31 != null) goto L37;
        r115 = r115;
    L49:
        r21 = r22;
        r17 = r29;
        r11 = r23;
        r115 = r115;
        goto L32
    L37:
        if (r31.isAD() == false) goto L45;
        if (r115.size() <= 0) goto L45;
        if (e.x0(r31.appPackageName) == false) goto L45;
        r31 = (AppInfo) r115.remove(0);
        r31.mJsonData = Q(new JSONObject(r31.mJsonData), r30);
    L45:
        int r32 = r117.optInt("location", 0);
        if (r32 != 0) goto L48;
        r31.mNumber = 0;
        r32 = r22;
    L48:
        r31.mNumber = r32 + r114;
        r31.mItemShowType = 0;
        r31.mApiUrl = r26;
        r112[r32 - 1] = GroupInfo.createNormal(r32, r31);
        goto L49
    L50:
        int r33 = 0;
    L51:
        if (r33 >= r18) goto L53;
        JSONObject r34 = r14.optJSONObject(r33);
        int r35 = r34.optInt("location");
        AppInfo r36 = t(r34);
        r36.mItemShowType = 3;
        r36.mNumber = r35 + r114;
        r36.mApiUrl = r26;
        r112[r35 - 1] = GroupInfo.createList(r35, r36);
        d9.a.e().E(0, r35);
        r33 = r33 + 1;
        goto L51
    L53:
        int r37 = 0;
    L55:
        if (r37 >= r110) goto L57;
        JSONObject r38 = r16.optJSONObject(r37);
        int r39 = r38.optInt("location");
        AppInfo r118 = new AppInfo();
        r118.appIcon = r38.optString(ServerElements.BANNER);
        r118.mNumber = r39 + r114;
        r118.mItemShowType = 2;
        r118.listShowType = r38.optString(ServerElements.OPERATIVE_TYPE);
        r118.appName = r38.optString("name");
        r118.appPackageName = r38.optString("package");
        r118.appId = r38.optString(ServerElements.TOPIC_ID);
        r118.setFrom(r38.optString("from"));
        r118.mSSTJ = r38.optString(ServerElements.SSTJ);
        r118.mApiUrl = r26;
        r118.mJsonData = P(r38);
        r112[r39 - 1] = GroupInfo.createBanner(r39, r118);
        d9.a.e().E(2, r39);
        r37 = r37 + 1;
        goto L55
    L57:
        int r40 = 0;
    L58:
        if (r40 >= r19) goto L64;
        JSONObject r41 = r15.optJSONObject(r40);
        String r42 = r41.optString("name");
        int r43 = r41.optInt("location");
        String r44 = r10;
        JSONArray r45 = r41.optJSONArray(r44);
        ArrayList r46 = new ArrayList();
        int r119 = 0;
    L61:
        if (r119 >= r45.length()) goto L63;
        AppInfo r120 = t(r45.optJSONObject(r119));
        r120.mItemShowType = 1;
        r120.mNumber = r43 + r114;
        r120.mApiUrl = r26;
        r46.add(r120);
        r119 = r119 + 1;
        goto L61
    L63:
        r112[r43 - 1] = GroupInfo.createGroup(r42, r43, r46);
        d9.a.e().E(1, r43);
        r40 = r40 + 1;
        r10 = r44;
        goto L58
    L64:
        ArrayList r47 = new ArrayList();
        int r48 = 0;
    L65:
        if (r48 >= r111) goto L70;
        GroupInfo r49 = r112[r48];
        if (r49 == null) goto L69;
        r47.addAll(r49.convert2List());
    L69:
        r48 = r48 + 1;
        goto L65
    L70:
        return r47;
    L17:
        r110 = r16.length();
        goto L18
    L14:
        r19 = r15.length();
        goto L15
    L11:
        r18 = r14.length();
        goto L12
    L8:
        r17 = r11.length();
        goto L9
    L5:
        r14 = null;
        r16 = null;
        r15 = null;
        goto L6
    }

    public static List G(String r10, String r11, String r12) {
        ArrayList r13 = new ArrayList();
    L25:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r13;
    L6:
        JSONObject r14 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L25
        if (r14 != null) goto L9;
        return r13;
    L9:
        JSONArray r15 = r14.optJSONArray("apps");     // Catch: Exception -> L25
        int r16 = 0;
        if (r15 == null) goto L33;
        if (r15.length() == 0) goto L33;
        int r17 = 0;
    L15:
        if (r17 >= r15.length()) goto L33;
        AppInfo r18 = t(r15.optJSONObject(r17));     // Catch: Exception -> L25
        if (r18.isSystemApp() == true) goto L31;
        if (r18.isAD() == true) goto L21;
    L27:
        r18.mApiUrl = r11;     // Catch: Exception -> L25
        r18.listShowType = "apps";     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r18.mOnlineTime) == true) goto L30;
        r18.listShowType = AppInfo.SEARCH_LIST_SHOW_RESERVATION_APPS;     // Catch: Exception -> L25
    L30:
        r13.add(r18);     // Catch: Exception -> L25
        goto L31
    L21:
        if (TextUtils.equals(r18.appName, r12) == true) goto L27;
        if (BaseApplication.c().b().b0(r18.appPackageName) == false) goto L27;
    L31:
        r17 = r17 + 1;     // Catch: Exception -> L25
    L33:
        if (r14.isNull(ServerElements.KEYWORDS) == false) goto L35;
        return r13;
    L35:
        JSONArray r19 = r14.optJSONArray(ServerElements.KEYWORDS);     // Catch: Exception -> L25
        if (r19 != null) goto L38;
    L43:
        return r13;
    L38:
        if (r19.length() == 0) goto L43;
    L39:
        if (r16 >= r19.length()) goto L43;
        AppInfo r110 = new AppInfo();     // Catch: Exception -> L25
        r110.appName = r19.getString(r16);     // Catch: Exception -> L25
        r110.mApiUrl = r11;     // Catch: Exception -> L25
        r110.listShowType = AppInfo.SEARCH_LIST_SHOW_WORDS;     // Catch: Exception -> L25
        r13.add(r110);     // Catch: Exception -> L25
        r16 = r16 + 1;
        goto L39
    }

    public static List H(String r10) {
        ArrayList r11 = new ArrayList();
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L20
        if (r12 != null) goto L9;
        return r11;
    L9:
        JSONArray r13 = r12.optJSONArray(ServerElements.HOT_APPS);     // Catch: Exception -> L20
        int r14 = 0;
        if (r13 != null) goto L12;
    L23:
        List r15 = g(r11, 8);
    L25:
        if (r14 >= r15.size()) goto L27;
        AppInfo r16 = (AppInfo) r15.get(r14);
        r14 = r14 + 1;
        d(r16, f0.c("1", r14));
        goto L25
    L27:
        return r15;
    L12:
        if (r13.length() == 0) goto L23;
        int r17 = 0;
    L15:
        if (r17 >= r13.length()) goto L23;
        AppInfo r18 = t(r13.optJSONObject(r17));     // Catch: Exception -> L20
        r18.mApiUrl = BaseApplication.c().l();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r18.appName) == true) goto L22;
        r11.add(r18);     // Catch: Exception -> L20
    L22:
        r17 = r17 + 1;
        goto L15
    }

    public static Map I(String r10) {
        HashMap r11 = new HashMap();
        ArrayList r12 = new ArrayList();
    L21:
        e = move-exception;
        e.printStackTrace();
        return r11;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        JSONObject r13 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L21
        if (r13 != null) goto L9;
        return r11;
    L9:
        JSONArray r14 = r13.optJSONArray(ServerElements.HOT_KEYWORDS);     // Catch: Exception -> L21
        if (r14 == null) goto L25;
        if (r14.length() == 0) goto L25;
        int r15 = 0;
    L15:
        if (r15 >= r14.length()) goto L25;
        SearchHotWords r16 = x(r14.optJSONObject(r15));     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r16.getKeyword()) == true) goto L23;
        if (TextUtils.isEmpty(r16.getSort()) == true) goto L23;
        r12.add(r16);     // Catch: Exception -> L21
    L23:
        r15 = r15 + 1;     // Catch: Exception -> L21
    L25:
        if (r13.has(ServerElements.HOT_KEYWORDS_LINE) == false) goto L27;
        String r17 = r13.optString(ServerElements.HOT_KEYWORDS_LINE);     // Catch: Exception -> L21
    L28:
        Collections.sort(r12, new b());     // Catch: Exception -> L21
        r11.put(r17, r12);     // Catch: Exception -> L21
        return r11;
    L27:
        r17 = null;
        goto L28
    }

    public static List J(String r10) {
        ArrayList r11 = new ArrayList();
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L20
        if (r12 != null) goto L9;
        return r11;
    L9:
        JSONArray r13 = r12.optJSONArray(ServerElements.RECOMMEND_APPS);     // Catch: Exception -> L20
        if (r13 != null) goto L12;
    L23:
        int r14 = 0;
    L25:
        if (r14 >= r11.size()) goto L31;
        List<AppInfo> r15 = g(((RecommendAppGroupInfo) r11.get(r14)).appInfoList, 6);
        String r16 = f0.e(r14);
        int r17 = 0;
    L28:
        if (r17 >= r15.size()) goto L30;
        AppInfo r18 = r15.get(r17);
        r17 = r17 + 1;
        d(r18, f0.c(r16, r17));
        goto L28
    L30:
        ((RecommendAppGroupInfo) r11.get(r14)).appInfoList = r15;
        r14 = r14 + 1;
        goto L25
    L31:
        return r11;
    L12:
        if (r13.length() == 0) goto L23;
        int r19 = 0;
    L15:
        if (r19 >= r13.length()) goto L23;
        RecommendAppGroupInfo r20 = E(r13.optJSONObject(r19));     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r20.name) == true) goto L22;
        r11.add(r20);     // Catch: Exception -> L20
    L22:
        r19 = r19 + 1;
        goto L15
    }

    public static String K(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r10).optJSONObject(ServerElements.BODY).optString(ServerElements.SHORT_URL);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static SupposeAppInfo L(Context r10, String r11) {
        SupposeAppInfo r12 = null;
        SupposeAppInfo r13 = (SupposeAppInfo) new Gson().fromJson(r11, SupposeAppInfo.class);     // Catch: Exception -> L10
        SupposeAppInfo.Body r14 = r13.getBody();     // Catch: Exception -> L8
        if (r14 == null) goto L17;
        h(r10, r14.getPromote_apps());     // Catch: Exception -> L8
        h(r10, r14.getAd_apps());     // Catch: Exception -> L8
        return r13;
    L17:
        return r13;
    L8:
        e = e;
        r12 = r13;
    L11:
        j.b("getSupposeAppList fail:" + e.getMessage());
        return r12;
    L10:
        e = e;
        goto L11
    }

    public static Topic M(JSONObject r10) {
        if (r10 == null) goto L4;
        Topic r11 = new Topic();
        r11.setTitle(r10.optString("name"));
        r11.setId(r10.optString(ServerElements.TOPIC_ID));
        r11.setImageResUrl(r10.optString(ServerElements.ICON));
        return r11;
    L4:
        return null;
    }

    public static Topic N(String r10) {
        Topic r11 = null;
        if (TextUtils.isEmpty(r10) == true) goto L43;
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject("topic");     // Catch: Exception -> L36
        Topic r13 = new Topic();     // Catch: Exception -> L36
        String r14 = "";
        if (r12 != null) goto L41;
        String r15 = "";
    L11:
        r13.setId(r15);     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        String r16 = r12.optString("type");     // Catch: Exception -> L8
    L15:
        r13.setType(r16);     // Catch: Exception -> L8
        if (r12 == null) goto L18;
        String r17 = r12.optString("name");     // Catch: Exception -> L8
    L19:
        r13.setTitle(r17);     // Catch: Exception -> L8
        if (r12 == null) goto L22;
        String r18 = r12.optString("package");     // Catch: Exception -> L8
    L23:
        r13.setPackageName(r18);     // Catch: Exception -> L8
        if (r12 == null) goto L26;
        String r19 = r12.optString(ServerElements.HEAD_BANNER);     // Catch: Exception -> L8
    L27:
        r13.setImageResUrl(r19);     // Catch: Exception -> L8
        if (r12 == null) goto L30;
        String r20 = r12.optString(ServerElements.BRIEF);     // Catch: Exception -> L8
    L31:
        r13.setDescription(r20);     // Catch: Exception -> L8
        if (r12 == null) goto L34;
        r14 = r12.optString(ServerElements.INTRODUCE);     // Catch: Exception -> L8
    L34:
        r13.setIntroduce(r14);     // Catch: Exception -> L8
        return r13;
    L8:
        e = e;
        r11 = r13;
    L37:
        e.printStackTrace();
        return r11;
    L30:
        r20 = "";
        goto L31
    L26:
        r19 = "";
        goto L27
    L22:
        r18 = "";
        goto L23
    L18:
        r17 = "";
        goto L19
    L14:
        r16 = "";
        goto L15
    L41:
        r15 = r12.optString("id");     // Catch: Exception -> L8
    L36:
        e = e;
        goto L37
    L43:
        return null;
    }

    public static String O(BaseAppInfo r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (TextUtils.isEmpty(r10.getImpression()) == true) goto L6;
        r12.put(ServerElements.ADS_IMPRESSION, r10.getImpression() + r11);
    L6:
        if (TextUtils.isEmpty(r10.getClick()) == true) goto L9;
        r12.put(ServerElements.ADS_CLICK, r10.getClick() + r11);
    L9:
        if (TextUtils.isEmpty(r10.getDownload_report()) == true) goto L12;
        r12.put(ServerElements.ADS_DOWNLOAD_REPORT, r10.getDownload_report());
    L12:
        return r12.toString();
    }

    public static String P(JSONObject r10) {
        return Q(r10, "");
    }

    public static String Q(JSONObject r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10.has(ServerElements.ADS_IMPRESSION) == false) goto L8;
        String r13 = r10.optString(ServerElements.ADS_IMPRESSION);
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r12.put(ServerElements.ADS_IMPRESSION, r13 + r11);
    L8:
        if (r10.has(ServerElements.ADS_CLICK) == false) goto L13;
        String r14 = r10.optString(ServerElements.ADS_CLICK);
        if (TextUtils.isEmpty(r14) == true) goto L13;
        r12.put(ServerElements.ADS_CLICK, r14 + r11);
    L13:
        if (r10.has(ServerElements.ADS_DOWNLOAD_REPORT) == false) goto L18;
        String r15 = r10.optString(ServerElements.ADS_DOWNLOAD_REPORT);
        if (TextUtils.isEmpty(r15) == true) goto L18;
        r12.put(ServerElements.ADS_DOWNLOAD_REPORT, r15 + r11);
    L18:
        return r12.toString();
    }

    public static AppInfo R(JSONObject r10, Context r11, String r12) {
        AppInfo r13 = new AppInfo();
        r13.appId = r10.optString("id", r10.getString("package"));
        r13.icp = r10.optString(ServerElements.ICP_NUMBER, "");
        r13.agreement = r10.optString(ServerElements.PRIVACY_AGREEMENT, "");
        r13.appIcon = r10.optString(ServerElements.LOGO);
        r13.appName = r10.getString("name");
        r13.sha256 = r10.optString(ServerElements.SIGN);
        r13.appPackageName = r10.getString("package");
        r13.appAliasName = r10.optString(ServerElements.CNAME);
        Category r14 = i(r10);
        if (r14 == null) goto L5;
        r13.mCategoryId = r14.getId();
        r13.appCategoryName = r14.getName();
    L5:
        String r15 = r10.optString(ServerElements.SECOND_CATEGORY_ID);
        r13.secondCategoryId = r15;
        int r16 = 0;
        if (r14 != null) goto L8;
    L17:
        r13.appVersionName = r10.optString("version");
        r13.appVersionCode = r10.optInt("version_code", 0);
        r13.appScores = Float.parseFloat(r10.optString(ServerElements.SCORES, "0.0f"));
        r13.appBytes = r10.optLong(ServerElements.FILESIZE);     // Catch: NumberFormatException -> L20
    L21:
        r13.appBrief = r10.optString(ServerElements.BRIEF);
        r13.recmd_brief = r10.optString(ServerElements.RECMD_BRIEF, "");
        r13.appCommentCnt = r10.optInt(ServerElements.COMMENTS, 0);
        r13.appDownloadUrl = r10.optString(ServerElements.DOWNLOAD_URL);
        JSONArray r17 = r10.optJSONArray(ServerElements.DOWNLOAD_URL_BACKUPS);
        if (r17 != null) goto L24;
    L33:
        r13.mDmUrl = r10.optString(ServerElements.DM_URL);
        r13.mMemUrl = r10.optString(ServerElements.MEM_URL);
        if (r10.has(ServerElements.FILE_MD5) == false) goto L36;
        r13.fileMd5 = r10.optString(ServerElements.FILE_MD5);
    L38:
        if (TextUtils.isEmpty(r13.appDownloadUrl) == false) goto L40;
        r13.appDownloadUrl = r10.optString(ServerElements.APKFILE);
    L40:
        r13.appShareUrl = r10.optString("share_download_url");
        r13.appDeveloper = r10.optString(ServerElements.DEVELOPER);
        r13.appDeveloperId = r10.optString(ServerElements.DEVER_ID);
        r13.appNewFeature = r10.optString(ServerElements.NEW_FEATURES);
        r13.appScalable = r10.optString(ServerElements.SCALABLE);
        String r18 = r10.optString(ServerElements.LAST_UPDATE_TIME);
        r13.appShowLastUpdateTime = r18;
        if (TextUtils.isEmpty(r18) == false) goto L43;
        r13.appShowLastUpdateTime = r10.optString(ServerElements.UPDATE_TIME);
    L43:
        boolean r19 = true;
        if (r10.optInt(ServerElements.IFGMS, 0) == 1) goto L47;
        r19 = false;
    L47:
        r13.mIsNeedGms = r19;
        r13.isCollected = BaseApplication.c().b().V(r13.appPackageName);
        r13.mAppType = r10.optInt("soft_type", 0);
        if (r10.isNull(ServerElements.PRINTSCREEN) == true) goto L57;
        JSONArray r20 = r10.optJSONArray(ServerElements.PRINTSCREEN);
        ArrayList r21 = new ArrayList();
    L51:
        if (r16 >= r20.length()) goto L56;
        if (TextUtils.isEmpty(r20.getString(r16)) == true) goto L55;
        r21.add(r20.getString(r16));
    L55:
        r16 = r16 + 1;
        goto L51
    L56:
        r13.appScreenSnaps = r21;
    L57:
        r13.appScreenShotsBySize = AppScreenShotsKt.parseScreenShotMap(r10);
        c(r13, r10.optJSONArray(ServerElements.LABEL), 8);
        if (r10.isNull("from") == true) goto L64;
        if (r10.optString("from").contains("{") == false) goto L62;
        JSONObject r22 = r10.optJSONObject("from");
        String r23 = r22.optString(ServerElements.MARK);
        String r24 = r22.optString("name");
        String r25 = r22.optString(ServerElements.LOGO);
        r13.setFrom(r23).setName(r24).setLogo(r25).setUrl(r22.optString("url"));
        goto L64
    L62:
        r13.setFrom(r10.optString("from"));
    L64:
        if (r10.isNull("source") == false) goto L66;
        r13.appSource = "local";
    L70:
        JSONObject r26 = r10.optJSONObject(ServerElements.VIDEO);
        if (r26 != null) goto L73;
    L75:
        r13.mSSTJ = r10.optString(ServerElements.SSTJ);
        r13.mNumber = r10.optInt("location");
        r13.mApiUrl = r10.optString(DownloadInfoColumns.COLUMN_API_URL);
        r13.mJsonData = P(r10);
        q(r13, r10.optJSONArray(ServerElements.GAME_GIFT_PACK), r12);
        r13.privacyAgreementUrl = r10.optString(ServerElements.PRIVACY_AGREEMENT);
        return r13;
    L73:
        if (r26.length() <= 0) goto L75;
        r13.mAppVideoType = r26.optInt(ServerElements.VIDEO_TYPE);
        r13.mAppVideoImage = r26.optString(ServerElements.VIDEO_IMAGE);
        r13.mAppVideoUrl = r26.optString("url");
        goto L75
    L66:
        if (TextUtils.equals(r10.getString("source"), "local") == false) goto L68;
        r13.appSource = "local";
        goto L70
    L68:
        r13.appSource = AppInfo.SEARCH_SOURCE_EXTENAL;
        goto L70
    L36:
        r13.fileMd5 = AppInfo.NO_MD5_KEY;
        goto L38
    L24:
        if (r17.length() <= 0) goto L33;
        ArrayList r27 = new ArrayList();
        int r28 = 0;
    L27:
        if (r28 >= r17.length()) goto L32;
        String r29 = r17.optString(r28, "");
        if (TextUtils.isEmpty(r29) == true) goto L31;
        r27.add(r29);
    L31:
        r28 = r28 + 1;
        goto L27
    L32:
        r13.appDownloadUrlBackups = r27;
    L20:
        r13.appBytes = 0;
        goto L21
    L8:
        if (TextUtils.isEmpty(r15) == false) goto L17;
        List<Category> r30 = r14.getChildCategories();
        if (r30 == null) goto L17;
        if (r30.isEmpty() == true) goto L17;
        r13.secondCategoryId = r30.get(0).getId();
        if (TextUtils.isEmpty(r13.appCategoryName) == true) goto L16;
        r13.appCategoryName += ",";
    L16:
        r13.appCategoryName += r30.get(0).getName();
        goto L17
    }

    public static List S(String r10) {
        ArrayList r11 = new ArrayList();
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return r11;
    L17:
        JSONArray r12 = new JSONArray(r10);     // Catch: Exception -> L14
        int r13 = 0;
    L7:
        if (r13 >= r12.length()) goto L16;
        JSONObject r14 = r12.optJSONObject(r13);     // Catch: Exception -> L14
        CommentInfo r15 = new CommentInfo();     // Catch: Exception -> L14
        r15.content = r14.optString(ServerElements.CONTENT);     // Catch: Exception -> L14
        r15.score = r14.optInt("score", 0);     // Catch: Exception -> L14
        r15.time = r14.optString("create_time");     // Catch: Exception -> L14
        r15.version = r14.optString("version");     // Catch: Exception -> L14
        r15.user = r14.optString("uid");     // Catch: Exception -> L14
        r15.nickname = r14.optString(ServerElements.NICKNAME);     // Catch: Exception -> L14
        r15.commentSupportTimes = r14.optInt(ServerElements.LIKE);     // Catch: Exception -> L14
        r15.comment_id = r14.optInt("id");     // Catch: Exception -> L14
        r15.app_id = r14.optInt("app_id");     // Catch: Exception -> L14
        boolean r16 = true;
        if (r14.optInt(ServerElements.IFLIKE, 0) == 1) goto L12;
        r16 = false;
    L12:
        r15.isLike = r16;     // Catch: Exception -> L14
        r15.isMyComment = TextUtils.equals(r15.user, AccountDataCache.b().k());     // Catch: Exception -> L14
        r11.add(r15);     // Catch: Exception -> L14
        r13 = r13 + 1;
    L16:
        return r11;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static void T(int r10, AppInfo r11, JSONObject r12) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 != 600002) goto L7;
    L8:
        r11.mDiffDownloadUrl = "no_diff_patch";
    L9:
        if (r12 != null) goto L12;
        return;
    L12:
        if (r11.appVersionCode == r12.optInt("version_code")) goto L15;
        j.n("diff patch params error.[" + r11.appVersionCode + LibrarianImpl.Constants.SEPARATOR + r12.optInt("version_code") + "][" + r11.appPackageName + LibrarianImpl.Constants.SEPARATOR + r12.optString("package") + "]");
        return;
    L15:
        String r13 = r12.optString(ServerElements.DOWNLOAD_URL);
        if (TextUtils.isEmpty(r13) == false) goto L19;
        j.n("diff patch url is null.");
        return;
    L19:
        String r14 = r12.optString(ServerElements.DIFF_FILE_MD5);
        r11.mDiffMD5 = r14;
        if (TextUtils.isEmpty(r14) == false) goto L23;
        j.n("md5 is null.");
        return;
    L23:
        StringBuilder r15 = new StringBuilder();
        r15.append(r13);
        if (TextUtils.isEmpty(r11.tabSource) == true) goto L27;
        r15.append("&source=");
        r15.append(r11.tabSource);
    L27:
        if (TextUtils.isEmpty(r11.mSSTJ) == true) goto L29;
        r15.append("&sstj=");
        r15.append(r11.mSSTJ);
    L29:
        String r16 = e.e0(r11.appDownloadUrl, "position");
        if (TextUtils.isEmpty(r16) == true) goto L32;
        r15.append("&position=");
        r15.append(r16);
    L32:
        r11.mDiffDownloadUrl = r15.toString();
        return;
    L7:
        if (r10 != 1700000) goto L9;
        goto L8
    }

    public static void U(int r10, AppInfo r11, String r12) {
        JSONArray r13 = new JSONObject(r12).optJSONObject(ServerElements.BODY).optJSONArray(ServerElements.APP);     // Catch: Exception -> L6
        if (r13.length() != 0) goto L8;
        j.n("diff patch is null.");     // Catch: Exception -> L6
        return;
    L8:
        T(r10, r11, (JSONObject) r13.get(0));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void V(Context r10, List r11, String r12) {
        if (r11 != null) goto L19;
        return;
    L19:
        SearchResultInfo.Body r13 = ((SearchResultInfo) new Gson().fromJson(r12, SearchResultInfo.class)).getBody();     // Catch: Exception -> L11
        if (r13 == null) goto L21;
        RelatedAppInfos r14 = r13.getRelated_apps();     // Catch: Exception -> L11
        if (r14 == null) goto L13;
        r14.setTotalAppsList(g(r14.getTotalAppsList(), 3));     // Catch: Exception -> L11
        if (r14.isAvailable() == false) goto L13;
        AppInfo r15 = new AppInfo();     // Catch: Exception -> L11
        r15.setAppExtraInfo(r14);     // Catch: Exception -> L11
        r11.add(0, r15);     // Catch: Exception -> L11
    L13:
        List<TopAdAppInfo> r16 = r13.getTopad_apps();     // Catch: Exception -> L11
        h(r10, r16);     // Catch: Exception -> L11
        if (c.a(r16) == true) goto L22;
        AppInfo r17 = new AppInfo();     // Catch: Exception -> L11
        r17.setAppExtraInfo(new TopAdAppInfos(r16));     // Catch: Exception -> L11
        r11.add(0, r17);     // Catch: Exception -> L11
        return;
    L22:
        return;
    L21:
        return;
    L11:
        e = move-exception;
        j.b("parseExtraAppInfo fail:" + e.getMessage());
    }

    public static PageDataBean W(JSONObject r10, String r11, int r12) {
        PageDataBean r13 = new PageDataBean();
        r13.apps = new ArrayList();
        r13.category = new Category();
        if (r10.has("category") == false) goto L5;
        JSONObject r14 = r10.optJSONObject("category");
        r13.category.setId(r14.optString("id"));
        r13.category.setName(r14.optString("name"));
        r13.name = r14.optString("name");
    L6:
        JSONArray r15 = r10.optJSONArray("apps");
        if (r15 != null) goto L9;
        return null;
    L9:
        if (r15.length() == 0) goto L29;
        int r16 = 0;
        int r17 = 0;
    L12:
        if (r17 >= r15.length()) goto L17;
        AppInfo r18 = t(r15.optJSONObject(r17));
        if (TextUtils.isEmpty(r18.appName) == true) goto L16;
        r13.apps.add(r18);
    L16:
        r17 = r17 + 1;
        goto L12
    L17:
        List r19 = g(r13.apps, 9);
        String r20 = BaseApplication.c().getResources().getString(R$string.tracker_app_detail);
        String.valueOf(r12);
    L19:
        if (r16 >= r19.size()) goto L21;
        AppInfo r21 = (AppInfo) r19.get(r16);
        r21.mPageTitle = r20;
        r21.mApiUrl = r11;
        r16 = r16 + 1;
        goto L19
    L21:
        r13.apps.clear();
        r13.apps.addAll(r19);
        return r13;
    L29:
        return null;
    L5:
        r13.category.setId(r10.optString("id"));
        r13.category.setName(r10.optString("name"));
        r13.name = r10.optString("name");
        goto L6
    }

    public static int X(HashMap r10, JSONArray r11) {
        int r12 = 0;
        r10.put(1, 0);
        r10.put(2, 0);
        r10.put(3, 0);
        r10.put(4, 0);
        r10.put(5, 0);
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r13 = 0;
    L7:
        if (r12 >= r11.length()) goto L9;
        JSONObject r14 = r11.optJSONObject(r12);
        int r15 = Integer.parseInt(r14.getString("score"));
        int r16 = Integer.parseInt(r14.getString("count"));
        r13 = r13 + r16;
        r10.put(Integer.valueOf(r15), Integer.valueOf(r16));
        r12 = r12 + 1;
        goto L7
    L9:
        return r13;
    }

    public static AppInfo a(BaseAppInfo r10, String r11) {
        AppInfo r12 = new AppInfo();
        r12.appId = r10.getId();
        r12.appIcon = r10.getLogo();
        r12.appName = r10.getName();
        r12.appBytes = r10.getFilesize();
        r12.appPackageName = r10.getPkg();
        r12.appCategoryName = r10.getCategory();
        r12.appVersionCode = r10.getVersion_code();
        r12.appVersionName = r10.getVersion();
        r12.appDownloadUrl = r10.getDownload_url();
        r12.mDsp = r10.getDsp();
        if (TextUtils.isEmpty(r12.appDownloadUrl) == false) goto L6;
        r12.appDownloadUrl = r10.getApkfile();
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r12.appDownloadUrl += r11;
    L8:
        r12.appShareUrl = r10.getShare_download_url();
        r12.mSSTJ = r10.getSstj();
        if (TextUtils.isEmpty(r10.getFrom()) == true) goto L12;
        r12.setFrom(r10.getFrom());
    L12:
        if (TextUtils.isEmpty(r10.getOperative_type()) == true) goto L14;
        r12.setOperative(r10.getOperative_type());
    L14:
        r12.appScores = r10.getScores();
        if (TextUtils.isEmpty(r10.getSource()) == false) goto L18;
        r12.appSource = "local";
    L21:
        r12.fileMd5 = r10.getFilemd5();
        boolean r13 = true;
        if (r10.getIfgms() == 1) goto L25;
        r13 = false;
    L25:
        r12.mIsNeedGms = r13;
        r12.recmd_brief = r10.getRecmd_brief();
        if (r10.getSoft_type() != 0) goto L28;
        r10.setSoft_type(0);
    L28:
        r12.mAppType = r10.getSoft_type();
        b(r12, r10.getLabel(), -1);
        r12.mJsonData = O(r10, r11);     // Catch: JSONException -> L31
    L33:
        return r12;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L18:
        if (TextUtils.equals(r10.getSource(), "local") == false) goto L20;
        r12.appSource = "local";
        goto L21
    L20:
        r12.appSource = AppInfo.SEARCH_SOURCE_EXTENAL;
        goto L21
    }

    public static void b(AppInfo r10, List r11, int r12) {
        if (r10 == null) goto L22;
        if (r11 != null) goto L5;
        return;
    L5:
        if (BaseApplication.c().e() != 0) goto L7;
        boolean r13 = true;
    L8:
        Iterator r14 = r11.iterator();
    L10:
        if (r14.hasNext() == false) goto L34;
        Integer r15 = (Integer) r14.next();
        if (r13 == false) goto L17;
        if (r15.intValue() == 8) goto L10;
    L17:
        if (r15.intValue() == r12) goto L18;
        if (r15.intValue() <= 0) goto L10;
        r10.mLabels.add(0, r15);
        goto L10
    L18:
        r10.mLabels.add(0, r15);
        return;
    L34:
        return;
    L7:
        r13 = false;
        goto L8
    }

    public static void c(AppInfo r10, JSONArray r11, int r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.length() <= 0) goto L23;
        int r13 = 0;
        if (BaseApplication.c().e() != 0) goto L8;
        boolean r14 = true;
    L10:
        if (r13 >= r11.length()) goto L24;
        int r15 = r11.optInt(r13);
        if (r14 == true) goto L14;
    L16:
        r10.mLabels.add(r13, Integer.valueOf(r15));
    L17:
        r13 = r13 + 1;
        goto L10
    L14:
        if (r15 != 8) goto L16;
    L24:
        return;
    L8:
        r14 = false;
        goto L10
    }

    public static void d(AppInfo r10, String r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L26;
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject(r10.mJsonData);     // Catch: JSONException -> L11
        String r14 = r13.optString(ServerElements.ADS_IMPRESSION);     // Catch: JSONException -> L11
        if (TextUtils.isEmpty(r14) == true) goto L13;
        r12.put(ServerElements.ADS_IMPRESSION, r14 + r11);     // Catch: JSONException -> L11
    L13:
        String r15 = r13.optString(ServerElements.ADS_CLICK);     // Catch: JSONException -> L11
        if (TextUtils.isEmpty(r15) == true) goto L16;
        r12.put(ServerElements.ADS_CLICK, r15 + r11);     // Catch: JSONException -> L11
    L16:
        String r16 = r13.optString(ServerElements.ADS_DOWNLOAD_REPORT);     // Catch: JSONException -> L11
        if (TextUtils.isEmpty(r16) == true) goto L19;
        r12.put(ServerElements.ADS_DOWNLOAD_REPORT, r16);     // Catch: JSONException -> L11
    L19:
        r10.mJsonData = r12.toString();     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void e(int r10, List r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        AppInfo r13 = (AppInfo) r11.get(r12);
        r12 = r12 + 1;
        d(r13, f0.c(f0.d(r10), r12));
        goto L4
    }

    public static void f(List r10, int r11, PageDataBean r12) {
        r10.add(new TopicListAdapter.TopicItem(r11, r12));
        r10.add(new TopicListAdapter.TopicItem(101));
    }

    public static List g(List r10, int r11) {
        if (r10 == null) goto L14;
        ArrayList r12 = new ArrayList(r10.size());
        Iterator r13 = r10.iterator();
    L5:
        if (r13.hasNext() == false) goto L9;
        AppInfoFilterInterface r14 = (AppInfoFilterInterface) r13.next();
        if (BaseApplication.c().b().b0(r14.getPackageNameForFilter()) == true) goto L5;
        r12.add(r14);
        goto L5
    L9:
        int r15 = r11 - r12.size();
        if (r15 <= 0) goto L12;
        r10.removeAll(r12);
        List r16 = r10.subList(0, Math.min(r15, r10.size()));
        Collections.sort(r16, f6067a);
        r12.addAll(r16);
        return r12;
    L12:
        List r17 = r12.subList(0, r11);
        Collections.sort(r17, f6067a);
        return r17;
    L14:
        return new ArrayList();
    }

    public static void h(Context r10, List r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L30;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L31;
        Object r13 = r12.next();
        if ((r13 instanceof BaseAppInfo) == true) goto L10;
        if ((r13 instanceof RelatedAppInfo) == false) goto L6;
        if (BaseApplication.c().b().b0(((RelatedAppInfo) r13).getPkg()) == false) goto L6;
        r12.remove();
        goto L6
    L10:
        if (BaseApplication.c().b().b0(((BaseAppInfo) r13).getPkg()) == false) goto L6;
        r12.remove();
        goto L6
    L31:
        return;
    L30:
        return;
    }

    public static Category i(JSONObject r10) {
        JSONArray r11 = r10.optJSONArray(ServerElements.CATEGORY_INFO);
        Category r12 = null;
        if (r11 == null) goto L21;
        int r13 = 1;
        if (r11.length() < 1) goto L21;
        String r14 = r11.optJSONObject(0).optString("id");
        String r15 = r11.optJSONObject(0).optString("name");
        if (TextUtils.isEmpty(r14) == false) goto L10;
        return null;
    L10:
        r12 = new Category();
        r12.setId(r14);
        r12.setName(r15);
        ArrayList r16 = new ArrayList(r11.length() - 1);
    L12:
        if (r13 >= r11.length()) goto L19;
        JSONObject r17 = r11.optJSONObject(r13);
        String r18 = r17.optString("id");
        String r19 = r17.optString("name");
        if (TextUtils.isEmpty(r18) == true) goto L17;
        Category r20 = new Category();
        r20.setName(r19);
        r20.setId(r18);
        r16.add(r20);
    L17:
        r13 = r13 + 1;
        goto L12
    L19:
        if (r16.isEmpty() == true) goto L21;
        r12.setChildCategories(r16);
    L21:
        return r12;
    }

    public static CommentInfo j(String r10) {
        CommentInfo r11 = new CommentInfo();
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return r11;
    L12:
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject(ServerElements.COMMENT);     // Catch: Exception -> L9
        if (r12 == null) goto L11;
        r11.content = r12.optString(ServerElements.CONTENT);     // Catch: Exception -> L9
        r11.score = r12.optInt("score", 0);     // Catch: Exception -> L9
    L11:
        return r11;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static AppComments k(String r10) {
        AppComments r11 = null;
        JSONArray r12 = null;
        if (TextUtils.isEmpty(r10) == false) goto L19;
        return null;
    L19:
        JSONObject r13 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject(ServerElements.APP_INFO);     // Catch: Exception -> L16
        if (r13 != null) goto L8;
        return null;
    L8:
        AppComments r14 = new AppComments();     // Catch: Exception -> L16
        r14.setAverageScore(Float.parseFloat(r13.optString(ServerElements.SCORES, "0.0")));     // Catch: Exception -> L12
        HashMap<Integer, Integer> r15 = new HashMap();     // Catch: Exception -> L12
        if (r13.isNull(ServerElements.SCORES_DETAIL) == true) goto L14;
        r12 = r13.optJSONArray(ServerElements.SCORES_DETAIL);     // Catch: Exception -> L12
    L14:
        r14.setScoresCnt(X(r15, r12));     // Catch: Exception -> L12
        r14.setScoreMap(r15);     // Catch: Exception -> L12
        r14.setCommentsCnt(r13.optInt(ServerElements.COMMENTS));     // Catch: Exception -> L12
        r14.setOnlyScore(false);     // Catch: Exception -> L12
        return r14;
    L12:
        e = e;
        r11 = r14;
    L17:
        e.printStackTrace();
        return r11;
    L16:
        e = e;
        goto L17
    }

    public static AppComments l(String r10, String r11) {
        AppComments r12 = null;
        JSONArray r13 = null;
        if (TextUtils.isEmpty(r10) == false) goto L26;
        return null;
    L26:
        JSONObject r14 = new JSONObject(r10);     // Catch: Exception -> L12
        JSONObject r15 = r14.optJSONObject(ServerElements.BODY);     // Catch: Exception -> L12
        if (r15 != null) goto L8;
        return null;
    L8:
        if (r11 == null) goto L14;
        r15 = r15.optJSONObject(r11);     // Catch: Exception -> L12
        if (r15 != null) goto L14;
        return null;
    L14:
        AppComments r16 = new AppComments();     // Catch: Exception -> L12
        r16.setAverageScore(Float.parseFloat(r15.optString(ServerElements.SCORES, "0.0")));     // Catch: Exception -> L18
        HashMap<Integer, Integer> r17 = new HashMap();     // Catch: Exception -> L18
        if (r15.isNull("score") == true) goto L20;
        r13 = r15.optJSONArray("score");     // Catch: Exception -> L18
    L20:
        r16.setScoresCnt(X(r17, r13));     // Catch: Exception -> L18
        r16.setScoreMap(r17);     // Catch: Exception -> L18
        r16.setCommentsCnt(r15.optInt("count"));     // Catch: Exception -> L18
        r16.setComments(S(r15.optString(ServerElements.COMMENTS)));     // Catch: Exception -> L18
        r16.setHasMore(r14.optJSONObject(ServerElements.HEAD).optBoolean(ServerElements.HAS_MORE, false));     // Catch: Exception -> L18
        r16.setOnlyScore(false);     // Catch: Exception -> L18
        return r16;
    L18:
        e = e;
        r12 = r16;
    L22:
        e.printStackTrace();
        return r12;
    L12:
        e = e;
        goto L22
    }

    public static AppInfo m(String r10) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        JSONObject r11 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject(ServerElements.APP_INFO);     // Catch: Exception -> L13
        if (r11 != null) goto L9;
    L17:
        return null;
    L9:
        if (r11.isNull("package") == true) goto L11;
    L15:
        return R(r11, BaseApplication.c(), null);
    L11:
        if (r11.isNull("name") == false) goto L15;
        goto L15
    }

    public static ArrayList n(String r11, String r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList();
        JSONObject r13 = new JSONObject(r11).getJSONObject(ServerElements.BODY);     // Catch: Exception -> L35
        if (r13 != null) goto L9;
        return null;
    L9:
        String[] r14 = {ServerElements.APP_DETAIL_RELATION, ServerElements.APP_DETAIL_CLASSICS};
        int r15 = 1;
        int r16 = 0;
    L11:
        if (r16 >= 2) goto L34;
        JSONObject r17 = r13.optJSONObject(r14[r16]);     // Catch: Exception -> L25
        String r18 = r17.optString("name");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r18) == true) goto L14;
        ArrayList r19 = new ArrayList();     // Catch: Exception -> L25
        JSONArray r20 = r17.optJSONArray("category");     // Catch: Exception -> L25
        if (r20 == null) goto L29;
        if (r20.length() == 0) goto L29;
        int r21 = 0;
    L21:
        if (r21 >= r20.length()) goto L29;
        PageDataBean r110 = W(r20.optJSONObject(r21), r12, r15);     // Catch: Exception -> L25
        if (r110 == null) goto L27;
        r19.add(r110);     // Catch: Exception -> L25
        r15 = r15 + 1;     // Catch: Exception -> L25
    L27:
        r21 = r21 + 1;     // Catch: Exception -> L25
    L29:
        if (r19.size() <= 0) goto L33;
        r10.add(new AbstractMap.SimpleEntry(r18, r19));     // Catch: Exception -> L25
    L33:
        r16 = r16 + 1;
        goto L11
    L14:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L34:
        return r10;
    L35:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static AppInfo o(String r10, Context r11) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        JSONObject r12 = new JSONObject(r10).optJSONObject(ServerElements.BODY).optJSONObject(ServerElements.APP);     // Catch: Exception -> L13
        if (r12 != null) goto L9;
    L17:
        return null;
    L9:
        if (r12.isNull("package") == true) goto L11;
    L15:
        return R(r12, r11, null);
    L11:
        if (r12.isNull("name") == false) goto L15;
        goto L15
    }

    public static AppInfo p(String r10, Context r11, String r12) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        JSONObject r13 = new JSONObject(r10).optJSONObject(ServerElements.BODY);     // Catch: Exception -> L13
        if (r13 != null) goto L9;
    L17:
        return null;
    L9:
        if (r13.isNull("package") == true) goto L11;
    L15:
        return R(r13, r11, r12);
    L11:
        if (r13.isNull("name") == false) goto L15;
        goto L15
    }

    public static void q(AppInfo r10, JSONArray r11, String r12) {
        if (r10 == null) goto L40;
        if (r11 == null) goto L41;
        ArrayList r13 = new ArrayList();
        int r14 = r11.length();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L33;
        GiftPackInfo r16 = new GiftPackInfo(r11.optJSONObject(r15), r10.mAppType);     // Catch: Exception -> L13
        if (r16.mCount != 0) goto L11;
    L31:
        r15 = r15 + 1;
        goto L6
    L11:
        if (TextUtils.equals(r16.mId, r12) == false) goto L16;
        r10.mGiftPackCode = r16.mGiftPackCode;     // Catch: Exception -> L13
    L16:
        if (TextUtils.isEmpty(r16.mAppDownloadUrl) == false) goto L19;
        r16.mAppDownloadUrl = r10.appDownloadUrl;     // Catch: Exception -> L13
    L19:
        if (TextUtils.isEmpty(r16.fileMd5) == false) goto L22;
        r16.fileMd5 = r10.fileMd5;     // Catch: Exception -> L13
    L22:
        if (TextUtils.isEmpty(r16.mPackageName) == false) goto L25;
        r16.mPackageName = r10.appPackageName;     // Catch: Exception -> L13
    L25:
        if (TextUtils.isEmpty(r16.mLogo) == false) goto L28;
        r16.mLogo = r10.appIcon;     // Catch: Exception -> L13
    L28:
        if (TextUtils.isEmpty(r16.mAppName) == false) goto L30;
        r16.mAppName = r10.appName;     // Catch: Exception -> L13
    L30:
        r16.mAppByte = r10.appBytes;     // Catch: Exception -> L13
        r13.add(r16);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L33:
        r10.mGameMode = r13;
        return;
    L41:
        return;
    }

    public static AppList r(String r10, String r11) {
        return s(r10, r11, null);
    }

    public static AppList s(String r20, String r21, String r22) {
        String r10 = ServerElements.IMAGES;
        if (TextUtils.isEmpty(r20) == false) goto L6;
        return null;
    L6:
        AppList r11 = new AppList();
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L10
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L10
        JSONObject r14 = new JSONObject(r20);     // Catch: Exception -> L10
        JSONObject r15 = r14.optJSONObject(ServerElements.BODY);     // Catch: Exception -> L10
        JSONObject r16 = r14.optJSONObject(ServerElements.HEAD);     // Catch: Exception -> L10
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L10
        boolean r18 = r16.optBoolean(ServerElements.HAS_MORE, false);     // Catch: Exception -> L10
        String r19 = "";
        boolean r110 = r16.optBoolean(ServerElements.FIRST_YYB, false);     // Catch: Exception -> L10
        JSONArray r23 = r16.optJSONArray(ServerElements.CONTEXTDATA);     // Catch: Exception -> L10
        if (r23 == null) goto L12;
        r17.put(ServerElements.CONTEXTDATA, r23);     // Catch: Exception -> L10
    L12:
        JSONArray r24 = r15.optJSONArray("apps");     // Catch: Exception -> L10
        if (r24 != null) goto L15;
        return r11;
    L15:
        if (r24.length() >= 2) goto L100;
    L43:
        int r111 = 0;
    L44:
        int r25 = r111;
    L46:
        if (r25 >= r24.length()) goto L79;
        JSONObject r26 = r24.optJSONObject(r25);     // Catch: Exception -> L25
        AppInfo r112 = t(r26);     // Catch: Exception -> L25
        if (r112 != null) goto L50;
    L51:
        r10 = r10;
        JSONArray r113 = r24;
        boolean r114 = r18;
    L78:
        r25 = r25 + 1;     // Catch: Exception -> L25
        r24 = r113;
        r18 = r114;
        r10 = r10;
        goto L46
    L50:
        if (r112.isSystemApp() == true) goto L51;
        r113 = r24;
        if (TextUtils.isEmpty(r112.mOnlineTime) == true) goto L57;
        r112.setAppExtraInfo(new ReserveInfo());     // Catch: Exception -> L25
    L55:
        r114 = r18;
    L69:
        r112.mNumber = r25 + 1;     // Catch: Exception -> L25
        r112.mApiUrl = r21;     // Catch: Exception -> L25
        r112.mSourcePkgName = r22;     // Catch: Exception -> L25
        if (TextUtils.equals("local", r112.appSource) == false) goto L72;
        r12.add(r112);     // Catch: Exception -> L25
    L74:
        if (TextUtils.isEmpty(r19) == false) goto L78;
        if (TextUtils.isEmpty(r112.traceId) == true) goto L78;
        r19 = r112.traceId;     // Catch: Exception -> L25
        goto L78
    L72:
        r13.add(r112);     // Catch: Exception -> L25
        goto L74
    L57:
        if (r26.has(r10) == false) goto L55;
        r114 = r18;
        if (BaseApplication.c().b().b0(r112.appPackageName) == false) goto L61;
        r10 = r10;
        goto L78
    L61:
        JSONArray r27 = r26.optJSONArray(r10);     // Catch: Exception -> L25
        if (r27 == null) goto L69;
        ImagesInfo r28 = new ImagesInfo();     // Catch: Exception -> L25
        ArrayList r115 = new ArrayList(3);     // Catch: Exception -> L25
        int r29 = 0;
    L65:
        if (r29 >= r27.length()) goto L67;
        r115.add((String) r27.get(r29));     // Catch: Exception -> L25
        r29 = r29 + 1;     // Catch: Exception -> L25
        goto L65
    L67:
        r28.setImageUrlList(r115);     // Catch: Exception -> L25
        r112.setAppExtraInfo(r28);     // Catch: Exception -> L25
        goto L69
    L79:
        boolean r116 = r18;
        if (r13.isEmpty() == true) goto L88;
        if (r110 == false) goto L83;
    L84:
        AppInfo r30 = new AppInfo();     // Catch: Exception -> L25
        r30.appSource = AppInfo.SEARCH_SOURCE_SPLIT;     // Catch: Exception -> L25
        r30.setAppExtraInfo(new SplitInfo());     // Catch: Exception -> L25
        r12.add(r30);     // Catch: Exception -> L25
        if (r17.optBoolean(ServerElements.FIRST_YYB, false) == false) goto L87;
        r17.put(ServerElements.FIRST_YYB, false);     // Catch: Exception -> L25
    L87:
        r12.addAll(r13);     // Catch: Exception -> L25
    L89:
        V(BaseApplication.c(), r12, r20);     // Catch: Exception -> L25
        AppList r31 = r11;
        r31.setMore(r116);     // Catch: Exception -> L93
        r31.setDataList(r12);     // Catch: Exception -> L93
        r31.setExtra(r17);     // Catch: Exception -> L93
        r31.setTraceId(r19);     // Catch: Exception -> L93
    L95:
        return r31;
    L93:
        e = e;
    L94:
        e.printStackTrace();
    L25:
        e = e;
        r31 = r11;
        goto L94
    L83:
        if (r17.optBoolean(ServerElements.FIRST_YYB, false) == false) goto L87;
    L88:
        r17.put(ServerElements.FIRST_YYB, r110);     // Catch: Exception -> L25
        goto L89
    L100:
        AppInfo r32 = t(r24.optJSONObject(0));     // Catch: Exception -> L25
        if (r32 == null) goto L27;
        r32.mNumber = 1;     // Catch: Exception -> L25
        r32.mApiUrl = r21;     // Catch: Exception -> L25
        r32.mSourcePkgName = r22;     // Catch: Exception -> L25
        if (TextUtils.isEmpty("") == false) goto L27;
        if (TextUtils.isEmpty(r32.traceId) == true) goto L27;
        r19 = r32.traceId;     // Catch: Exception -> L25
    L27:
        AppInfo r33 = t(r24.optJSONObject(1));     // Catch: Exception -> L25
        if (r33 == null) goto L34;
        r33.mNumber = 2;     // Catch: Exception -> L25
        r33.mApiUrl = r21;     // Catch: Exception -> L25
        r33.mSourcePkgName = r22;     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r19) == false) goto L34;
        if (TextUtils.isEmpty(r32.traceId) == true) goto L34;
        r19 = r32.traceId;     // Catch: Exception -> L25
    L34:
        if (r32 == null) goto L41;
        String r117 = r19;
        if (TextUtils.equals(AppInfo.SEARCH_SOURCE_EXTENAL, r32.appSource) == false) goto L42;
        if (r33 == null) goto L42;
        if (TextUtils.equals("local", r33.appSource) == false) goto L42;
        r12.add(r32);     // Catch: Exception -> L25
        r19 = r117;
        r111 = 1;
    L42:
        r19 = r117;
        goto L43
    L41:
        r117 = r19;
    L10:
        e = e;
        r31 = r11;
        goto L94
    }

    public static AppInfo t(JSONObject r10) {
        return u(r10, "");
    }

    public static AppInfo u(JSONObject r10, String r11) {
        AppInfo r12 = new AppInfo();
        r12.appId = r10.optString("id");
        r12.appIcon = r10.optString(ServerElements.LOGO);
        r12.appName = r10.optString("name");
        r12.mOnlineTime = r10.optString("online_time");
        r12.mStatus = r10.optInt("status");
        r12.appBytes = r10.optLong(ServerElements.FILESIZE);     // Catch: NumberFormatException -> L5
    L6:
        r12.appPackageName = r10.optString("package");
        r12.appCategoryName = r10.optString("category");
        r12.appVersionCode = r10.optInt("version_code", 0);
        r12.appVersionName = r10.optString("version");
        r12.mDmUrl = r10.optString(ServerElements.DM_URL);
        r12.mMemUrl = r10.optString(ServerElements.MEM_URL);
        if (r10.has(ServerElements.FILE_MD5) == false) goto L9;
        r12.fileMd5 = r10.optString(ServerElements.FILE_MD5);
    L10:
        r12.appShareUrl = r10.optString("share_download_url");
        r12.mSSTJ = r10.optString(ServerElements.SSTJ);
        if (r10.optString("from") == null) goto L14;
        r12.setFrom(r10.optString("from"));
    L14:
        if (r10.optString(ServerElements.OPERATIVE_TYPE) == null) goto L17;
        r12.setOperative(r10.optString(ServerElements.OPERATIVE_TYPE));
    L17:
        if (TextUtils.isEmpty(r12.appDownloadUrl) == false) goto L37;
        r12.appDownloadUrl = r10.optString(ServerElements.APKFILE);
    L37:
        r12.appScores = Float.parseFloat(r10.optString(ServerElements.SCORES));     // Catch: NumberFormatException -> L21
    L23:
        if (TextUtils.equals(r10.optString("source", "local"), "local") == false) goto L25;
        r12.appSource = "local";
    L26:
        boolean r13 = true;
        if (r10.optInt(ServerElements.IFGMS, 0) == 1) goto L30;
        r13 = false;
    L30:
        r12.mIsNeedGms = r13;
        r12.recmd_brief = r10.optString(ServerElements.RECMD_BRIEF, "");
        r12.mAppType = r10.optInt("soft_type", 0);
        c(r12, r10.optJSONArray(ServerElements.LABEL), -1);
        String r14 = r10.optString("trace_id");
        r12.traceId = r14;
        if (TextUtils.isEmpty(r14) == true) goto L33;
        r11 = r11 + "&trace_id=" + r12.traceId;
    L33:
        r12.mJsonData = Q(r10, r11);
        r12.mAppVideoImage = r10.optString(ServerElements.VIDEO_IMG);
        r12.mAppVideoUrl = r10.optString(ServerElements.VIDEO_PATH);
        r12.mDsp = r10.optString(ServerElements.DSP);
        return r12;
    L25:
        r12.appSource = AppInfo.SEARCH_SOURCE_EXTENAL;
    L21:
        r12.appScores = 0.0f;
        goto L23
    L9:
        r12.fileMd5 = AppInfo.NO_MD5_KEY;
    L5:
        r12.appBytes = 0;
        goto L6
    }

    public static AppComments v(String r10) {
        AppComments r11 = null;
        JSONArray r12 = null;
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return null;
    L16:
        JSONObject r13 = new JSONObject(r10);     // Catch: Exception -> L13
        JSONObject r14 = r13.optJSONObject(ServerElements.BODY);     // Catch: Exception -> L13
        AppComments r15 = new AppComments();     // Catch: Exception -> L13
        r15.setAverageScore(Float.parseFloat(r14.optString(ServerElements.SCORES, "0.0")));     // Catch: Exception -> L9
        HashMap r16 = new HashMap();     // Catch: Exception -> L9
        if (r14.isNull("score") == true) goto L11;
        r12 = r14.optJSONArray("score");     // Catch: Exception -> L9
    L11:
        r15.setScoresCnt(X(r16, r12));     // Catch: Exception -> L9
        r15.setCommentsCnt(r14.optInt("count"));     // Catch: Exception -> L9
        r15.setComments(S(r14.optString(ServerElements.COMMENTS)));     // Catch: Exception -> L9
        r15.setHasMore(r13.optJSONObject(ServerElements.HEAD).optBoolean(ServerElements.HAS_MORE, false));     // Catch: Exception -> L9
        r15.setOnlyScore(true);     // Catch: Exception -> L9
        return r15;
    L9:
        e = e;
        r11 = r15;
    L14:
        e.printStackTrace();
        return r11;
    L13:
        e = e;
        goto L14
    }

    public static List w(String r10, String r11, String r12) {
        ArrayList r13 = new ArrayList();
        if (r10 != null) goto L32;
        return r13;
    L32:
        JSONArray r14 = new JSONObject(r10).optJSONArray(ServerElements.BODY);     // Catch: Exception -> L11
        int r15 = 0;
    L6:
        if (r15 >= r14.length()) goto L31;
        JSONObject r16 = r14.optJSONObject(r15);     // Catch: Exception -> L11
        PageDataBean r17 = new PageDataBean();     // Catch: Exception -> L11
        r17.apps = new ArrayList();     // Catch: Exception -> L11
        r17.category = new Category();     // Catch: Exception -> L11
        JSONObject r18 = r16.optJSONObject("category");     // Catch: Exception -> L11
        r17.category.setId(r18.optString("id"));     // Catch: Exception -> L11
        r17.category.setName(r18.optString("name"));     // Catch: Exception -> L11
        String r19 = r18.optString("name");     // Catch: Exception -> L11
        r17.name = r19;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r19) == false) goto L13;
        r17.name = r12;     // Catch: Exception -> L11
    L13:
        JSONArray r20 = r16.optJSONArray("apps");     // Catch: Exception -> L11
        if (r20 == null) goto L29;
        if (r20.length() == 0) goto L29;
        int r21 = 0;
    L19:
        if (r21 >= r20.length()) goto L24;
        AppInfo r22 = t(r20.optJSONObject(r21));     // Catch: Exception -> L11
        r22.mApiUrl = r11;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r22.appName) == true) goto L23;
        r17.apps.add(r22);     // Catch: Exception -> L11
    L23:
        r21 = r21 + 1;     // Catch: Exception -> L11
        goto L19
    L24:
        List r23 = g(r17.apps, 9);     // Catch: Exception -> L11
        int r24 = 0;
    L26:
        if (r24 >= r23.size()) goto L28;
        AppInfo r25 = (AppInfo) r23.get(r24);     // Catch: Exception -> L11
        r24 = r24 + 1;     // Catch: Exception -> L11
        d(r25, f0.c(f0.e(r15), r24));     // Catch: Exception -> L11
        goto L26
    L28:
        r17.apps.clear();     // Catch: Exception -> L11
        r17.apps.addAll(r23);     // Catch: Exception -> L11
        r13.add(new TopicListAdapter.TopicItem(D(r23), r17));     // Catch: Exception -> L11
        r13.add(new TopicListAdapter.TopicItem(101));     // Catch: Exception -> L11
    L29:
        r15 = r15 + 1;
    L31:
        return r13;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public static SearchHotWords x(JSONObject r10) {
        SearchHotWords r11 = new SearchHotWords();
        r11.setKeyword(r10.optString("keyword"));
        r11.setPackageName(r10.optString("package"));
        if (r10.has(ServerElements.SORT) == false) goto L5;
        r11.setSort(r10.optString(ServerElements.SORT));
    L5:
        r11.setSSTJ(r10.optString(ServerElements.SSTJ));
        r11.setJsonData(P(r10));
        return r11;
    }

    public static List y(JSONArray r16, String r17, String r18) {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L91:
        if (r11 >= r16.length()) goto L90;
        JSONObject r12 = r16.getJSONObject(r11);     // Catch: Exception -> L11
        int r13 = Integer.parseInt(r12.optString(ServerElements.TEMPLATE));     // Catch: Exception -> L11
        PageDataBean r14 = new PageDataBean();     // Catch: Exception -> L11
        if (r13 != 10) goto L14;
        r14.apps = new ArrayList();     // Catch: Exception -> L11
        r14.groupId = r12.optString(ServerElements.GROUP_ID);     // Catch: Exception -> L11
        r14.cid = r12.optString("cid");     // Catch: Exception -> L11
        Category r15 = new Category();     // Catch: Exception -> L11
        r14.category = r15;     // Catch: Exception -> L11
        r15.setId(r12.optString(ServerElements.GROUP_ID));     // Catch: Exception -> L11
        r14.category.setName(r12.optString("name"));     // Catch: Exception -> L11
        String r19 = r12.optString("name");     // Catch: Exception -> L11
        r14.name = r19;     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r19) == false) goto L15;
        r14.name = r18;     // Catch: Exception -> L11
    L15:
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L11
        List r21 = new ArrayList();     // Catch: Exception -> L11
        JSONArray r110 = r12.optJSONArray("apps");     // Catch: Exception -> L11
        if (r13 != 10) goto L22;
        if (r110 == null) goto L88;
        if (r110.length() != 0) goto L22;
    L88:
        r11 = r11 + 1;
    L22:
        int r111 = 3;
        ArrayList r112 = null;
        if (r110 == null) goto L48;
        int r113 = 0;
    L26:
        if (r113 >= r110.length()) goto L48;
        JSONObject r22 = r110.getJSONObject(r113);     // Catch: Exception -> L11
        if (r13 != r111) goto L32;
        if (r112 != null) goto L31;
        r112 = new ArrayList();     // Catch: Exception -> L11
    L31:
        r112.add(M(r22));     // Catch: Exception -> L11
    L47:
        r113 = r113 + 1;     // Catch: Exception -> L11
        r111 = 3;
        goto L26
    L32:
        AppInfo r23 = t(r22);     // Catch: Exception -> L11
        r23.mApiUrl = r17;     // Catch: Exception -> L11
        if (r13 == 11) goto L44;
        if (r13 == 12) goto L44;
        if (r13 == 10) goto L40;
        r20.add(r23);     // Catch: Exception -> L11
        goto L47
    L40:
        if (TextUtils.isEmpty(r23.appName) == true) goto L47;
        r20.add(r23);     // Catch: Exception -> L11
    L44:
        if (r23.isAD() == false) goto L46;
        r21.add(r23);     // Catch: Exception -> L11
        goto L47
    L46:
        r20.add(r23);     // Catch: Exception -> L11
    L48:
        ArrayList r24 = new ArrayList();     // Catch: Exception -> L11
        if (r13 != 3) goto L51;
        r10.add(new TopicListAdapter.TopicItem(r13, r112));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(101));     // Catch: Exception -> L11
        goto L88
    L51:
        if (r13 == 6) goto L75;
        if (r13 == 7) goto L73;
        switch(r13) {
            case 10: goto L69;
            case 11: goto L59;
            case 12: goto L59;
            case 13: goto L69;
            case 14: goto L57;
            case 15: goto L56;
            default: goto L88;
        };     // Catch: Exception -> L11
    L56:
        VideoInfo r25 = new VideoInfo();     // Catch: Exception -> L11
        r25.mName = r12.optString("name");     // Catch: Exception -> L11
        r25.mImgUrl = r12.optString(ServerElements.VIDEO_IMG);     // Catch: Exception -> L11
        r25.mVideoUrl = r12.optString(ServerElements.VIDEO_PATH);     // Catch: Exception -> L11
        r10.add(0, new TopicListAdapter.TopicItem(r13, r25));     // Catch: Exception -> L11
        goto L88
    L57:
        AppInfo r26 = (AppInfo) r20.get(0);     // Catch: Exception -> L11
        d(r26, f0.c(String.valueOf(r11 + 1), 1));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(r13, r26));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(101));     // Catch: Exception -> L11
        goto L88
    L69:
        List r27 = g(r20, 9);     // Catch: Exception -> L11
        if (r27.isEmpty() == true) goto L88;
        r24.addAll(r27);     // Catch: Exception -> L11
        e(r11, r24);     // Catch: Exception -> L11
        r14.apps = r24;     // Catch: Exception -> L11
        f(r10, D(r24), r14);     // Catch: Exception -> L11
        goto L88
    L59:
        if (r21.isEmpty() == false) goto L61;
        int r28 = 0;
    L62:
        int r29 = Math.min(r14.adCount, r28);     // Catch: Exception -> L11
        int r30 = Math.min(r20.size(), (r14.rows * 4) - r29);     // Catch: Exception -> L11
        if (r30 < 0) goto L88;
        r24.addAll(r20.subList(0, r30));     // Catch: Exception -> L11
        r24.addAll(r21.subList(0, r29));     // Catch: Exception -> L11
        if (r24.isEmpty() == true) goto L88;
        e(r11, r24);     // Catch: Exception -> L11
        r14.apps = r24;     // Catch: Exception -> L11
        f(r10, r13, r14);     // Catch: Exception -> L11
        goto L88
    L61:
        r21 = g(r21, r14.adCount);     // Catch: Exception -> L11
        r28 = r21.size();     // Catch: Exception -> L11
        goto L62
    L73:
        e(r11, r20);     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(102));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(r13, r20));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(102));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(101));     // Catch: Exception -> L11
        goto L88
    L75:
        if (r10.size() > 1) goto L77;
    L79:
        Iterator r31 = r20.iterator();     // Catch: Exception -> L11
    L81:
        if (r31.hasNext() == false) goto L84;
        AppInfo r32 = (AppInfo) r31.next();     // Catch: Exception -> L11
        d(r32, f0.c(f0.d(r11), r20.indexOf(r32) + 1));     // Catch: Exception -> L11
        r10.add(new TopicListAdapter.TopicItem(r13, r32));     // Catch: Exception -> L11
        goto L81
    L84:
        if (r10.isEmpty() == true) goto L86;
        ((TopicListAdapter.TopicItem) r10.get(r10.size() - 1)).mHiddenDivideLine = true;     // Catch: Exception -> L11
    L86:
        r10.add(new TopicListAdapter.TopicItem(101));     // Catch: Exception -> L11
        goto L88
    L77:
        if (((TopicListAdapter.TopicItem) r10.get(r10.size() - 2)).mType != 6) goto L79;
        r10.remove(r10.size() - 1);     // Catch: Exception -> L11
        goto L79
    L14:
        r14.name = r12.optString("name");     // Catch: Exception -> L11
        r14.adCount = r12.optInt(ServerElements.AD_COUNT);     // Catch: Exception -> L11
        r14.groupId = r12.optString(ServerElements.GROUP_ID);     // Catch: Exception -> L11
        r14.rows = r12.optInt("rows");     // Catch: Exception -> L11
        r14.cid = r12.optString("cid");     // Catch: Exception -> L11
    L90:
        return r10;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L90
    }

    public static List z(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();
        return y(new JSONObject(r10).optJSONArray(ServerElements.BODY), r11, r12);
    L9:
        e = move-exception;
        e.printStackTrace();
        return r13;
    }
}
