package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CronetSsCallConfig {
    private static final int CONNECT_INTERVAL = 4000;
    private static final String KEY_BLOCK_ERROR_CODE_LIST = "block_code_list";
    private static final String KEY_BYPASS_ROUTE_SELECTION_ENABLED = "bypass_rs_enabled";
    private static final String KEY_CONCURRENT_HOST_GROUP = "concurrent_hosts";
    private static final String KEY_CONCURRENT_REQUEST_ENABLED = "enabled_v2";
    private static final String KEY_CONNECT_TIME_INTERVAL = "connect_interval_millis";
    private static final String KEY_CONTINUE_FAILED_COUNTS = "fail_count";
    private static final String KEY_FORBIDDEN_SECONDS = "forbid_seconds";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_MAX_WAIT_SECONDS = "max_wait_seconds";
    private static final String KEY_PATH_EQUAL_GROUP = "equal_group";
    private static final String KEY_PATH_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PATH_PREFIX_GROUP = "prefix_group";
    private static final String KEY_REFINE_WITH_CONCURRENT_ROUTE = "concurrent_route";
    private static final String KEY_REFINE_WITH_ROUTE_SELECTION = "rs_name";
    private static final String KEY_REQUEST_FINISH_FIX_ENABLED = "fin_fix_enabled";
    private static final String KEY_RETRY_FOR_NOT_2XX_CODE = "retry_for_not_2xx_code";
    private static final String KEY_URL_MATCH_RULE = "match_rules";
    private static final String TAG = "CronetSsCallConfig";
    private static volatile CronetSsCallConfig sInstance;
    private volatile int mConcurrentRequestEnabled;
    private List<UrlMatchRule> mUrlMatchRuleList;

    static class UrlMatchRule {
        Set<Integer> mBlockErrorCodeSet;
        boolean mBypassRouteSelectionEnabled;
        final List<String> mConcurrentHostList;
        int mConnectTimeInterval;
        volatile int mContinueFailedCount;
        boolean mEnableRequestReportFix;
        List<String> mEqualPathList;
        int mForbiddenDurationSeconds;
        volatile long mForbiddenTimeStart;
        final List<String> mHostList;
        volatile boolean mIsForbidden;
        int mMaxFailedCount;
        List<Pattern> mPatternPathList;
        List<String> mPrefixPathList;
        String mRefineRsName;
        boolean mRetryForNot2xxCode;
        String mRuleId;
        int mTNCRequestMaxWaitTime;

        public UrlMatchRule(List<String> r2, List<String> r3) {
            this.mEnableRequestReportFix = false;
            this.mTNCRequestMaxWaitTime = 0;
            this.mHostList = r2;
            this.mConcurrentHostList = r3;
            this.mForbiddenTimeStart = SystemClock.uptimeMillis();
            this.mContinueFailedCount = 0;
            this.mMaxFailedCount = Integer.MAX_VALUE;
            this.mForbiddenDurationSeconds = 0;
            this.mIsForbidden = false;
            this.mRuleId = UUID.randomUUID().toString();
            this.mRetryForNot2xxCode = false;
            this.mConnectTimeInterval = CronetSsCallConfig.CONNECT_INTERVAL;
            this.mBypassRouteSelectionEnabled = true;
            this.mRefineRsName = null;
        }

        public List<String> getDomainList() {
            return this.mConcurrentHostList;
        }

        public String getRuleId() {
            return this.mRuleId;
        }
    }

    static {
    }

    public static CronetSsCallConfig inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetSsCallConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetSsCallConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetSsCallConfig.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CronetSsCallConfig() {
        this.mConcurrentRequestEnabled = 0;
        this.mUrlMatchRuleList = new CopyOnWriteArrayList();
    }

    public boolean isConcurrentRequestEnabled() {
        if (this.mConcurrentRequestEnabled <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public UrlMatchRule getUrlMatchRuleFromRequest(Request r4) {
        recoverRuleStatusFromForbidden();
        Iterator<UrlMatchRule> r0 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UrlMatchRule r1 = r0.next();
        if (isUrlMatchRule(r4, r1) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public boolean inBlockErrorCode(int r3, String r4) {
        if (r3 != 0) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        UrlMatchRule r2 = getRuleById(r4);
        if (r2 == null) goto L14;
        if (r2.mBlockErrorCodeSet == null) goto L14;
        return r2.mBlockErrorCodeSet.contains(Integer.valueOf(r3));
    }

    private UrlMatchRule getRuleById(String r3) {
        Iterator<UrlMatchRule> r2 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        UrlMatchRule r0 = r2.next();
        if (r0.getRuleId().equals(r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private void recoverRuleStatusFromForbidden() {
        Iterator<UrlMatchRule> r6 = this.mUrlMatchRuleList.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        UrlMatchRule r0 = r6.next();
        if (r0.mIsForbidden == false) goto L4;
        long r1 = SystemClock.uptimeMillis() - r0.mForbiddenTimeStart;
        if (r1 <= (r0.mForbiddenDurationSeconds * 1000)) goto L11;
        r0.mIsForbidden = false;
    L11:
        if (Logger.debug() == false) goto L4;
        Logger.d(TAG, "Rule id: " + r0.mRuleId + " has forbidden duration: " + r1 + " fail count: " + r0.mContinueFailedCount + " forbidden duration: " + (r0.mForbiddenDurationSeconds * 1000));
        goto L4
    }

    private boolean isUrlMatchRule(Request r6, UrlMatchRule r7) {
        if (r7.mForbiddenDurationSeconds > 0) goto L5;
    L7:
        String r5 = r6.getUrl();
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return false;
    L10:
        Iterator<String> r1 = r7.mHostList.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (UrlUtils.matchPattern(r6.getHost(), r1.next()) == false) goto L12;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        String r8 = r6.getPath();
        if (TextUtils.isEmpty(r8) == false) goto L26;
        return false;
    L26:
        if (isEmpty(r7.mEqualPathList) == true) goto L34;
        Iterator<String> r9 = r7.mEqualPathList.iterator();
    L29:
        if (r9.hasNext() == false) goto L34;
        if (r8.equals(r9.next()) == false) goto L29;
        return true;
    L34:
        if (isEmpty(r7.mPrefixPathList) == true) goto L42;
        Iterator<String> r10 = r7.mPrefixPathList.iterator();
    L37:
        if (r10.hasNext() == false) goto L42;
        if (r8.startsWith(r10.next()) == false) goto L37;
        return true;
    L42:
        if (isEmpty(r7.mPatternPathList) == true) goto L51;
        Iterator<Pattern> r11 = r7.mPatternPathList.iterator();
    L45:
        if (r11.hasNext() == false) goto L51;
        Pattern r12 = r11.next();
        if (r12 == null) goto L45;
        if (r12.matcher(r8).matches() == false) goto L45;
        return true;
    L51:
        return false;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "host not match: " + r5);
    L21:
        return false;
    L16:
        r2 = false;
        goto L17
    L5:
        if (r7.mIsForbidden == false) goto L7;
        return false;
    }

    public void onNetConfigChanged(String r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r4);
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        return;
    L17:
        JSONObject r0 = new JSONObject(r4);     // Catch: Throwable -> L13
        int r1 = 0;
        this.mConcurrentRequestEnabled = r0.optInt(KEY_CONCURRENT_REQUEST_ENABLED, 0);     // Catch: Throwable -> L13
        this.mUrlMatchRuleList.clear();     // Catch: Throwable -> L13
        JSONArray r5 = r0.getJSONArray(KEY_URL_MATCH_RULE);     // Catch: Throwable -> L13
    L10:
        if (r1 >= r5.length()) goto L21;
        parseUrlMatchRule((JSONObject) r5.get(r1));     // Catch: Throwable -> L13
        r1 = r1 + 1;
        goto L10
    L21:
        return;
    L14:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "parse json config error");
        return;
    }

    private static boolean parseJSONArrayList(JSONObject r2, String r3, List<String> r4) {
        int r0 = 0;
        if (r2 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (r4 == null) goto L19;
        JSONArray r5 = r2.optJSONArray(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r0 >= r5.length()) goto L17;
        String r6 = r5.optString(r0);
        if (TextUtils.isEmpty(r6) == true) goto L16;
        r4.add(r6);
    L16:
        r0 = r0 + 1;
        goto L12
    L17:
        return true;
    }

    private void parseUrlMatchRule(JSONObject r9) throws JSONException {
        ArrayList r0 = new ArrayList();
        parseJSONArrayList(r9, KEY_HOST_GROUP, r0);
        ArrayList r1 = new ArrayList();
        parseJSONArrayList(r9, KEY_CONCURRENT_HOST_GROUP, r1);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (r1.size() < 2) goto L57;
        UrlMatchRule r2 = new UrlMatchRule(r0, r1);
        ArrayList r3 = new ArrayList();
        if (parseJSONArrayList(r9, KEY_PATH_EQUAL_GROUP, r3) == false) goto L10;
        r2.mEqualPathList = r3;
    L10:
        ArrayList r4 = new ArrayList();
        if (parseJSONArrayList(r9, KEY_PATH_PREFIX_GROUP, r4) == false) goto L13;
        r2.mPrefixPathList = r4;
    L13:
        ArrayList r5 = new ArrayList();
        JSONArray r6 = r9.optJSONArray(KEY_PATH_PATTERN_GROUP);
        int r7 = 0;
        if (r6 == null) goto L23;
        int r8 = 0;
    L17:
        if (r8 >= r6.length()) goto L22;
        String r10 = r6.optString(r8);
        if (TextUtils.isEmpty(r10) == true) goto L21;
        r5.add(Pattern.compile(r10, 2));     // Catch: Throwable -> L49
    L21:
        r8 = r8 + 1;
        goto L17
    L22:
        r2.mPatternPathList = r5;
    L23:
        r2.mMaxFailedCount = r9.optInt(KEY_CONTINUE_FAILED_COUNTS, Integer.MAX_VALUE);
        r2.mForbiddenDurationSeconds = r9.optInt(KEY_FORBIDDEN_SECONDS, 0);
        r2.mConnectTimeInterval = r9.optInt(KEY_CONNECT_TIME_INTERVAL, CONNECT_INTERVAL);
        boolean r11 = true;
        if (r9.optInt(KEY_BYPASS_ROUTE_SELECTION_ENABLED, 1) <= 0) goto L26;
        boolean r12 = true;
    L27:
        r2.mBypassRouteSelectionEnabled = r12;
        r2.mRefineRsName = r9.optString(KEY_REFINE_WITH_CONCURRENT_ROUTE);
        if (TextUtils.isEmpty(r2.mRefineRsName) == false) goto L31;
        r2.mRefineRsName = r9.optString(KEY_REFINE_WITH_ROUTE_SELECTION, null);
    L31:
        if (r9.optInt(KEY_REQUEST_FINISH_FIX_ENABLED, 0) <= 0) goto L33;
        boolean r13 = true;
    L34:
        r2.mEnableRequestReportFix = r13;
        r2.mTNCRequestMaxWaitTime = r9.optInt(KEY_MAX_WAIT_SECONDS, 0);
        if (r2.mConnectTimeInterval > 0) goto L38;
        return;
    L38:
        if (r9.optInt(KEY_RETRY_FOR_NOT_2XX_CODE, 0) > 0) goto L41;
        r11 = false;
    L41:
        r2.mRetryForNot2xxCode = r11;
        HashSet r14 = new HashSet();
        JSONArray r15 = r9.optJSONArray(KEY_BLOCK_ERROR_CODE_LIST);
        if (r15 != null) goto L44;
    L47:
        this.mUrlMatchRuleList.add(r2);
        return;
    L44:
        if (r7 >= r15.length()) goto L46;
        r14.add(Integer.valueOf(r15.optInt(r7)));
        r7 = r7 + 1;
        goto L44
    L46:
        r2.mBlockErrorCodeSet = r14;
        goto L47
    L33:
        r13 = false;
        goto L34
    L26:
        r12 = false;
        goto L27
    }

    private static boolean isEmpty(List<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private void tryForbiddenCurrentRule(UrlMatchRule r5, boolean r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "Forbidden: " + r5.mIsForbidden + " failed count: " + r5.mContinueFailedCount + " max count: " + r5.mMaxFailedCount);
    L5:
        if (r6 == true) goto L7;
        int r4 = r5.mContinueFailedCount + 1;
        r5.mContinueFailedCount = r4;
        if (r4 >= r5.mMaxFailedCount) goto L17;
        return;
    L17:
        if (r5.mIsForbidden == true) goto L20;
        r5.mIsForbidden = true;
        r5.mForbiddenTimeStart = SystemClock.uptimeMillis();
    L20:
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "Forbidden: " + r5.mIsForbidden + " failed count: " + r5.mContinueFailedCount);
        return;
    L23:
        return;
    L7:
        if (r5.mContinueFailedCount == 0) goto L9;
    L11:
        r5.mContinueFailedCount = 0;
        r5.mIsForbidden = false;
        return;
    L9:
        if (r5.mIsForbidden == true) goto L11;
    }

    public void notifyConcurrentRequestFinished(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        UrlMatchRule r4 = getRuleById(r2);
        if (r4 != null) goto L8;
        return;
    L8:
        tryForbiddenCurrentRule(r4, r3);
    }
}
