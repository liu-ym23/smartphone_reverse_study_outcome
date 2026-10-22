package com.bytedance.frameworks.baselib.network.queryfilter;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.ContactsUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class QueryFilterEngine {
    private static final String CIPHER_VERSION_HEADER = "x-tt-cipher-version";
    private static final String CIPHER_VERSION_VALUE = "1.0.0";
    private static final String ENCRYPT_INFO_HEADER = "x-tt-encrypt-info";
    private static final String KEY_ACTION_NAME = "action";
    private static final String KEY_ACTION_PARAM = "param";
    private static final String KEY_ACTION_PRIORITY = "act_priority";
    public static final String KEY_L0_PARAMS = "L0_params";
    public static final String KEY_QUERY_FILTER_CONFIG = "query_filter_actions";
    public static final String KEY_QUERY_FILTER_ENABLED = "query_filter_enabled";
    private static final String KEY_SET_REQ_PRIORITY = "set_req_priority";
    private static final String TAG = "QueryFilterEngine";
    private static volatile QueryFilterEngine sInstance;
    private boolean mEnableNewSpaceEncodeRule;
    private List<String> mL0ParamsList;
    private volatile String mLocalConfig;
    private boolean mOptRetrofitLog;
    private List<QueryFilterAction> mQueryFilterActions;
    private volatile boolean mQueryFilterEnabled;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType = null;

        static {
            int[] r0 = new int[RetrofitMetrics.EncryptType.values().length];
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType = r0;
            r0[RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_QUERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    class SortActionByPriority implements Comparator<QueryFilterAction> {
        final /* synthetic */ QueryFilterEngine this$0;

        SortActionByPriority(QueryFilterEngine r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(QueryFilterAction r1, QueryFilterAction r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(QueryFilterAction r1, QueryFilterAction r2) {
            return r1.getPriority() - r2.getPriority();
        }
    }

    public static QueryFilterEngine inst() {
        if (sInstance != null) goto L15;
        monitor-enter(QueryFilterEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new QueryFilterEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(QueryFilterEngine.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void setLocalCommonParamsConfig(String r5) throws JSONException {
        JSONObject r0 = new JSONObject(r5).getJSONObject("data");     // Catch: JSONException -> L9
        boolean r2 = false;
        int r1 = r0.optInt(KEY_QUERY_FILTER_ENABLED, 0);     // Catch: JSONException -> L9
        if (r1 <= 0) goto L5;
        r2 = true;
    L5:
        enableQueryFilterEngine(r2);     // Catch: JSONException -> L9
        parseL0ParamsString(r0.optString(KEY_L0_PARAMS, ""));     // Catch: JSONException -> L9
        if (r1 <= 0) goto L14;
        parseCommonParamsConfig(r0.getString(KEY_QUERY_FILTER_CONFIG));     // Catch: JSONException -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Logger.e(TAG, "Local common params config is invalid: " + r5);
        throw e;
    }

    public void enableQueryFilterEngine(boolean r1) {
        this.mQueryFilterEnabled = r1;
    }

    public void onNetConfigChanged(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r3 + " enabled: " + this.mQueryFilterEnabled);
    L6:
        if (this.mQueryFilterEnabled == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        parseCommonParamsConfig(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void parseL0ParamsString(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.mL0ParamsList.clear();
        JSONArray r0 = new JSONArray(r4);     // Catch: JSONException -> L11
        int r5 = 0;
    L8:
        if (r5 >= r0.length()) goto L17;
        String r1 = r0.getString(r5);     // Catch: JSONException -> L11
        this.mL0ParamsList.add(r1);     // Catch: JSONException -> L11
        r5 = r5 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public Map<String, String> removeL0CommonParams(Map<String, String> r2) {
        if (r2 != null) goto L4;
    L10:
        return r2;
    L4:
        if (r2.isEmpty() == true) goto L10;
        Iterator<String> r1 = this.mL0ParamsList.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.remove(r1.next());
        goto L8
    }

    public String filterUrlWithCommonParams(String r15) {
        if (this.mQueryFilterEnabled == true) goto L5;
    L48:
        return r15;
    L5:
        if (TextUtils.isEmpty(r15) == true) goto L48;
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L42
        Pair<String, String> r1 = UrlUtils.parseUrlWithValueList(r15, r0);     // Catch: Throwable -> L42
        if (r1 != null) goto L10;
    L41:
        return r15;
    L10:
        if (r0.isEmpty() == true) goto L41;
        if (dispatchQueryMap(new Request(HttpMethodContrants.GET, r15, null, null, 0, false, -1, false, null), r0) == true) goto L15;
        return r15;
    L15:
        UrlBuilder r2 = new UrlBuilder(((String) r1.first) + ((String) r1.second));     // Catch: Throwable -> L42
        if (r0.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, List<String>>> r3 = r0.entrySet().iterator();     // Catch: Throwable -> L42
    L19:
        if (r3.hasNext() == false) goto L34;
        Map.Entry<String, List<String>> r4 = r3.next();     // Catch: Throwable -> L42
        if (r4 == null) goto L19;
        if (r4.getKey() == null) goto L19;
        List<String> r5 = r4.getValue();     // Catch: Throwable -> L42
        if (r5 == null) goto L19;
        if (r5.isEmpty() == true) goto L19;
        Iterator<String> r6 = r5.iterator();     // Catch: Throwable -> L42
    L32:
        if (r6.hasNext() == false) goto L19;
        r2.addParam(r4.getKey(), r6.next());     // Catch: Throwable -> L42
    L34:
        String r7 = r2.build();     // Catch: Throwable -> L42
        String r16 = Uri.parse(r15).getEncodedFragment();     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r16) == true) goto L45;
        r7 = r7 + ContactsUtils.CHAR_POUND + r16;     // Catch: Throwable -> L39
    L45:
        if (this.mEnableNewSpaceEncodeRule == true) goto L47;
        return r7;
    L47:
        return UrlUtils.replacePlusInEncodeUrl(r7);
    L39:
        th = move-exception;
        th = th;
        r15 = r7;
    L43:
        th.printStackTrace();
        r7 = r15;
    L42:
        th = th;
        goto L43
    }

    public Request filterQuery(Request r8) {
        if (this.mQueryFilterEnabled == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "Query filter engine is not enabled");
    L7:
        return null;
    L9:
        if (r8.isPureRequest() == false) goto L11;
        return null;
    L11:
        String r1 = r8.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L54;
        return null;
    L54:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L51
        Pair<String, String> r2 = UrlUtils.parseUrlWithValueList(r1, r3);     // Catch: Throwable -> L51
        if (r2 != null) goto L18;
        return null;
    L18:
        if (dispatchQueryMap(r8, r3) == true) goto L21;
        return null;
    L21:
        if (r8.isQueryEncryptEnabled() == true) goto L23;
    L29:
        String r7 = null;
    L30:
        UrlBuilder r0 = new UrlBuilder(((String) r2.first) + ((String) r2.second));     // Catch: Throwable -> L51
        if (r3.isEmpty() == true) goto L49;
        Iterator<Map.Entry<String, List<String>>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L51
    L34:
        if (r4.hasNext() == false) goto L49;
        Map.Entry<String, List<String>> r5 = r4.next();     // Catch: Throwable -> L51
        if (r5 == null) goto L34;
        if (r5.getKey() == null) goto L34;
        List<String> r6 = r5.getValue();     // Catch: Throwable -> L51
        if (r6 == null) goto L34;
        if (r6.isEmpty() == true) goto L34;
        Iterator<String> r9 = r6.iterator();     // Catch: Throwable -> L51
    L47:
        if (r9.hasNext() == false) goto L34;
        r0.addParam(r5.getKey(), r9.next());     // Catch: Throwable -> L51
    L49:
        Request.Builder r10 = r8.newBuilder();     // Catch: Throwable -> L51
        tryEncryptRequest(r10, r8, r7);     // Catch: Throwable -> L51
        r10.url(r0.build());     // Catch: Throwable -> L51
        return r10.build();
    L23:
        if (r3.containsKey("x-tt-encrypt-queries") == false) goto L29;
        List<String> r11 = r3.get("x-tt-encrypt-queries");     // Catch: Throwable -> L51
        if (r11 == null) goto L29;
        if (r11.size() <= 0) goto L29;
        r7 = r11.get(0);     // Catch: Throwable -> L51
        r3.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public List<QueryFilterAction> getQueryFilterActionsForTesting() {
        return this.mQueryFilterActions;
    }

    private QueryFilterEngine() {
        this.mQueryFilterEnabled = false;
        this.mQueryFilterActions = new CopyOnWriteArrayList();
        this.mL0ParamsList = new CopyOnWriteArrayList();
        this.mEnableNewSpaceEncodeRule = false;
        this.mOptRetrofitLog = true;
    }

    private JSONArray dispatchQueryActionInfo(List<QueryActionInfo> r10) {
        JSONArray r0 = new JSONArray();
        Iterator<QueryActionInfo> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L21;
        QueryActionInfo r1 = r11.next();
        long r2 = r1.getDispatchActionDuration();     // Catch: JSONException -> L18
        if (this.mOptRetrofitLog == false) goto L13;
        if (r1.isActionHit() == true) goto L13;
        if (r2 <= 0) goto L4;
    L13:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L18
        r4.put(BaseHttpRequestInfo.KEY_HIT, r1.isActionHit());     // Catch: JSONException -> L18
        r4.put("priority", r1.getActionPriority());     // Catch: JSONException -> L18
        if (r2 <= 0) goto L16;
        r4.put("consume", r2);     // Catch: JSONException -> L18
    L16:
        r0.put(r4);     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L21:
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "action info: " + r0.toString());
    L23:
        return r0;
    }

    private boolean dispatchQueryMap(Request r5, Map<String, List<String>> r6) {
        ArrayList r0 = new ArrayList();
        boolean r1 = false;
        r5.setQueryFilterPriority(0);
        Iterator<QueryFilterAction> r2 = this.mQueryFilterActions.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r2.next().takeAction(r5, r6, r0) == false) goto L4;
        r1 = true;
        goto L4
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "dispatchQueryMap hit: " + r1);
    L12:
        if (r5.getMetrics() == null) goto L14;
        r5.getMetrics().dispatchQueryActionInfo = dispatchQueryActionInfo(r0);
    L14:
        return r1;
    }

    private synchronized void parseCommonParamsConfig(String r5) throws JSONException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.mLocalConfig) == false) goto L6;
    L12:
        ArrayList<QueryFilterAction> r0 = new ArrayList();     // Catch: Throwable -> L19
        JSONArray r1 = new JSONArray(r5);     // Catch: Throwable -> L19
        int r2 = 0;
    L14:
        if (r2 >= r1.length()) goto L16;
        parseActionInfo(r1.getJSONObject(r2), r0);     // Catch: Throwable -> L19
        r2 = r2 + 1;     // Catch: Throwable -> L19
        goto L14
    L16:
        Collections.sort(r0, new SortActionByPriority(this));     // Catch: Throwable -> L19
        this.mQueryFilterActions.clear();     // Catch: Throwable -> L19
        this.mQueryFilterActions.addAll(r0);     // Catch: Throwable -> L19
        this.mLocalConfig = r5;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        if (this.mLocalConfig.equals(r5) == false) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "Config is same with local config, do not parse.");     // Catch: Throwable -> L19
    L10:
        monitor-exit(this);
    }

    private void parseActionInfo(JSONObject r4, ArrayList<QueryFilterAction> r5) throws JSONException {
        String r3 = r4.getString("action");
        int r0 = r4.getInt(KEY_ACTION_PRIORITY);
        if (r0 >= 0) goto L5;
        return;
    L5:
        JSONObject r1 = r4.getJSONObject("param");
        int r6 = r4.optInt(KEY_SET_REQ_PRIORITY, r0);
        if (r6 != (-1)) goto L8;
        r6 = Integer.MAX_VALUE;
    L8:
        QueryFilterAction r7 = QueryFilterAction.createQueryFilterAction(r3, r0, r6, r1);
        if (r7 == null) goto L12;
        r5.add(r7);
        return;
    }

    private static void tryEncryptRequest(Request.Builder r7, Request r8, String r9) {
        if ((r8.getBody() instanceof AbsTypedOutput) == false) goto L7;
        boolean r0 = ((AbsTypedOutput) r8.getBody()).isBodyEncrypted();
        if (r0 == false) goto L9;
        Logger.i(TAG, "Request body has been encrypted before.");
    L9:
        if (r8.isQueryEncryptEnabled() == false) goto L11;
    L14:
        ArrayList r1 = new ArrayList();
        if (TextUtils.isEmpty(r9) == true) goto L18;
        r1.add(new Header("x-tt-encrypt-queries", r9));
    L18:
        if (r8.getHeaders() == null) goto L20;
        r1.addAll(r8.getHeaders());
    L20:
        RetrofitMetrics r10 = r8.getMetrics();
        if (r0 == false) goto L23;
    L29:
        RetrofitMetrics.EncryptType r2 = RetrofitMetrics.EncryptType.ENCRYPT_NONE;
        if (r0 == true) goto L32;
    L34:
        if (r0 == false) goto L37;
        addRequestEncryptHeaders(r1, RetrofitMetrics.EncryptType.ENCRYPT_BODY);
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_BODY;
    L39:
        if (r10 == null) goto L41;
        r10.setEncryptType(r2);
    L41:
        r7.headers(r1);
        return;
    L37:
        if (r8.isQueryEncryptEnabled() == false) goto L39;
        addRequestEncryptHeaders(r1, RetrofitMetrics.EncryptType.ENCRYPT_QUERY);
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_QUERY;
        goto L39
    L32:
        if (r8.isQueryEncryptEnabled() == false) goto L34;
        addRequestEncryptHeaders(r1, RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY);
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY;
        goto L39
    L23:
        if (r8.isBodyEncryptEnabled() == false) goto L29;
        TypedOutput r3 = r8.getBody();
        if ((r3 instanceof AbsTypedOutput) == false) goto L29;
        long r4 = System.currentTimeMillis();
        r0 = ((AbsTypedOutput) r3).interceptRequestBody();
        if (r10 == null) goto L29;
        r10.bodyEncryptDuration = System.currentTimeMillis() - r4;
        goto L29
    L11:
        if (r8.isBodyEncryptEnabled() == true) goto L14;
        if (r0 == true) goto L14;
        return;
    L7:
        r0 = false;
        goto L9
    }

    private static void addRequestEncryptHeaders(List<Header> r4, RetrofitMetrics.EncryptType r5) {
        int r6 = AnonymousClass1.$SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[r5.ordinal()];
        if (r6 != 1) goto L5;
        r4.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "2"));
        return;
    L5:
        if (r6 != 2) goto L7;
        r4.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "1"));
        return;
    L7:
        if (r6 != 3) goto L15;
        r4.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "0"));
        return;
    }

    static void parseArrayListConfig(JSONArray r3, List<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public void setEnableNewSpaceEncodeRule(boolean r1) {
        this.mEnableNewSpaceEncodeRule = r1;
    }

    public boolean getEnableNewSpaceEncodeRule() {
        return this.mEnableNewSpaceEncodeRule;
    }

    public void setOptRetrofitLog(boolean r1) {
        this.mOptRetrofitLog = r1;
    }
}
