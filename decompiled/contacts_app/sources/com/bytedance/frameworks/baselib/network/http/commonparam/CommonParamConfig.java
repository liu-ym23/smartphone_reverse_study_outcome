package com.bytedance.frameworks.baselib.network.http.commonparam;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommonParamConfig {
    public static final String EQUAL_MATCH = "equal_match";
    private static final String KEY_EQUAL_GROUP = "equal_group";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_L0_PATH = "L0_path";
    private static final String KEY_L1_PATH = "L1_path";
    private static final String KEY_MIN_PARAMS_EXCLUDE = "min_params_exclude";
    private static final String KEY_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PREFIX_GROUP = "prefix_group";
    public static final String PATTERN_MATCH = "pattern_match";
    public static final String PREFIX_MATCH = "prefix_match";
    private static final String TAG = "CommonParamConfig";
    private CopyOnWriteArraySet<String> mAddMaxParamsEqualPathSet;
    private CopyOnWriteArraySet<Pattern> mAddMaxParamsPatternSet;
    private CopyOnWriteArraySet<String> mAddMaxParamsPrefixPathSet;
    private volatile boolean mAddMinCommonParamsWhenDomainMatch;
    private CopyOnWriteArraySet<String> mAddMinParamsEqualPathSet;
    private CopyOnWriteArraySet<Pattern> mAddMinParamsPatternSet;
    private CopyOnWriteArraySet<String> mAddMinParamsPrefixPathSet;
    private volatile boolean mCustomCommonParamLevelEnabled;
    private CopyOnWriteArraySet<String> mDomainFilterSet;
    private volatile String mLocalConfig;
    private CopyOnWriteArraySet<String> mMinParamsExcludeSet;
    private volatile boolean mNewStrategyEnabled;

    public static final class Builder {
        private CopyOnWriteArraySet<String> mAddMaxParamsEqualPathSet;
        private CopyOnWriteArraySet<Pattern> mAddMaxParamsPatternSet;
        private CopyOnWriteArraySet<String> mAddMaxParamsPrefixPathSet;
        private CopyOnWriteArraySet<String> mAddMinParamsEqualPathSet;
        private CopyOnWriteArraySet<Pattern> mAddMinParamsPatternSet;
        private CopyOnWriteArraySet<String> mAddMinParamsPrefixPathSet;
        private boolean mCustomCommonParamLevelEnabled;
        private CopyOnWriteArraySet<String> mDomainFilterSet;
        private boolean mMinCommonParamsWhenDomainMatch;
        private CopyOnWriteArraySet<String> mMinParamsExcludeSet;
        private boolean mNewStrategyEnabled;

        public Builder() {
            this.mDomainFilterSet = new CopyOnWriteArraySet();
            this.mAddMaxParamsEqualPathSet = new CopyOnWriteArraySet();
            this.mAddMaxParamsPrefixPathSet = new CopyOnWriteArraySet();
            this.mAddMaxParamsPatternSet = new CopyOnWriteArraySet();
            this.mAddMinParamsEqualPathSet = new CopyOnWriteArraySet();
            this.mAddMinParamsPrefixPathSet = new CopyOnWriteArraySet();
            this.mAddMinParamsPatternSet = new CopyOnWriteArraySet();
            this.mMinParamsExcludeSet = new CopyOnWriteArraySet();
        }

        static /* synthetic */ boolean access$000(Builder r0) {
            return r0.mNewStrategyEnabled;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.mCustomCommonParamLevelEnabled;
        }

        static /* synthetic */ CopyOnWriteArraySet access$1000(Builder r0) {
            return r0.mMinParamsExcludeSet;
        }

        static /* synthetic */ boolean access$200(Builder r0) {
            return r0.mMinCommonParamsWhenDomainMatch;
        }

        static /* synthetic */ CopyOnWriteArraySet access$300(Builder r0) {
            return r0.mDomainFilterSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$400(Builder r0) {
            return r0.mAddMaxParamsEqualPathSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$500(Builder r0) {
            return r0.mAddMaxParamsPrefixPathSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$600(Builder r0) {
            return r0.mAddMaxParamsPatternSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$700(Builder r0) {
            return r0.mAddMinParamsEqualPathSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$800(Builder r0) {
            return r0.mAddMinParamsPrefixPathSet;
        }

        static /* synthetic */ CopyOnWriteArraySet access$900(Builder r0) {
            return r0.mAddMinParamsPatternSet;
        }

        public Builder enableNewAddcommonParamsStrategy(boolean r1) {
            this.mNewStrategyEnabled = r1;
            return this;
        }

        public Builder enableCustomCommonParamLevel(boolean r1) {
            this.mCustomCommonParamLevelEnabled = r1;
            return this;
        }

        public Builder enableMinCommonParamsWhenDomainMatch(boolean r1) {
            this.mMinCommonParamsWhenDomainMatch = r1;
            return this;
        }

        public Builder setDomainFilterList(List<String> r3) {
            if (CommonParamConfig.access$1100(r3) == true) goto L10;
            Iterator<String> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            String r0 = r4.next();
            this.mDomainFilterSet.add(r0);
            goto L6
        L8:
            return this;
        L10:
            throw new IllegalArgumentException("domainFilterList can not be null or empty.");
        }

        public Builder setMinParamsExcludeList(List<String> r3) {
            if (CommonParamConfig.access$1100(r3) == true) goto L10;
            Iterator<String> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            String r0 = r4.next();
            this.mMinParamsExcludeSet.add(r0);
            goto L6
        L8:
            return this;
        L10:
            throw new IllegalArgumentException("minParamsExcludeList can not be null or empty.");
        }

        public Builder setAddMaxParamsPathFilterMap(Map<String, List<String>> r4) {
            if (r4 == null) goto L30;
            if (r4.isEmpty() == true) goto L30;
            List<String> r0 = r4.get(CommonParamConfig.EQUAL_MATCH);
            if (CommonParamConfig.access$1100(r0) == true) goto L11;
            Iterator<String> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L11;
            String r2 = r1.next();
            this.mAddMaxParamsEqualPathSet.add(r2);
        L11:
            List<String> r3 = r4.get(CommonParamConfig.PREFIX_MATCH);
            if (CommonParamConfig.access$1100(r3) == true) goto L17;
            Iterator<String> r5 = r3.iterator();
        L15:
            if (r5.hasNext() == false) goto L17;
            String r6 = r5.next();
            this.mAddMaxParamsPrefixPathSet.add(r6);
        L17:
            List<String> r7 = r4.get(CommonParamConfig.PATTERN_MATCH);
            if (r7 != null) goto L20;
        L28:
            return this;
        L20:
            if (r7.isEmpty() == true) goto L28;
            Iterator<String> r8 = r7.iterator();
        L23:
            if (r8.hasNext() == false) goto L28;
            String r9 = r8.next();
            if (TextUtils.isEmpty(r9) == true) goto L23;
            this.mAddMaxParamsPatternSet.add(Pattern.compile(r9, 2));     // Catch: Throwable -> L31
        L30:
            throw new IllegalArgumentException("addMaxParamsPathFilterMap can not be null or empty.");
        }

        public Builder setAddMinParamsPathFilterMap(Map<String, List<String>> r4) {
            if (r4 == null) goto L28;
            if (r4.isEmpty() == true) goto L28;
            List<String> r0 = r4.get(CommonParamConfig.EQUAL_MATCH);
            if (CommonParamConfig.access$1100(r0) == true) goto L11;
            Iterator<String> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L11;
            String r2 = r1.next();
            this.mAddMinParamsEqualPathSet.add(r2);
        L11:
            List<String> r3 = r4.get(CommonParamConfig.PREFIX_MATCH);
            if (CommonParamConfig.access$1100(r3) == true) goto L17;
            Iterator<String> r5 = r3.iterator();
        L15:
            if (r5.hasNext() == false) goto L17;
            String r6 = r5.next();
            this.mAddMinParamsPrefixPathSet.add(r6);
        L17:
            List<String> r7 = r4.get(CommonParamConfig.PATTERN_MATCH);
            if (CommonParamConfig.access$1100(r7) == true) goto L26;
            Iterator<String> r8 = r7.iterator();
        L21:
            if (r8.hasNext() == false) goto L26;
            String r9 = r8.next();
            if (TextUtils.isEmpty(r9) == true) goto L21;
            this.mAddMinParamsPatternSet.add(Pattern.compile(r9, 2));     // Catch: Throwable -> L29
        L26:
            return this;
        L28:
            throw new IllegalArgumentException("addMinParamsPathFilterMap can not be null or empty.");
        }

        public CommonParamConfig build() {
            return new CommonParamConfig(this);
        }
    }

    static /* synthetic */ boolean access$1100(List r0) {
        return isEmptyList(r0);
    }

    public CommonParamConfig(Builder r2) {
        this.mNewStrategyEnabled = Builder.access$000(r2);
        this.mCustomCommonParamLevelEnabled = Builder.access$100(r2);
        this.mAddMinCommonParamsWhenDomainMatch = Builder.access$200(r2);
        this.mDomainFilterSet = Builder.access$300(r2);
        this.mAddMaxParamsEqualPathSet = Builder.access$400(r2);
        this.mAddMaxParamsPrefixPathSet = Builder.access$500(r2);
        this.mAddMaxParamsPatternSet = Builder.access$600(r2);
        this.mAddMinParamsEqualPathSet = Builder.access$700(r2);
        this.mAddMinParamsPrefixPathSet = Builder.access$800(r2);
        this.mAddMinParamsPatternSet = Builder.access$900(r2);
        this.mMinParamsExcludeSet = Builder.access$1000(r2);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean isNewStrategyEnabled() {
        return this.mNewStrategyEnabled;
    }

    public boolean isCustomCommonParamLevelEnabled() {
        return this.mCustomCommonParamLevelEnabled;
    }

    public boolean addMinCommonParamsWhenDomainMatch() {
        return this.mAddMinCommonParamsWhenDomainMatch;
    }

    public Set<String> getDomainFilterSet() {
        return this.mDomainFilterSet;
    }

    public Set<String> getAddMaxParamsEqualPathSet() {
        return this.mAddMaxParamsEqualPathSet;
    }

    public Set<String> getAddMaxParamsPrefixPathSet() {
        return this.mAddMaxParamsPrefixPathSet;
    }

    public Set<Pattern> getAddMaxParamsPatternSet() {
        return this.mAddMaxParamsPatternSet;
    }

    public Set<String> getAddMinParamsEqualPathSet() {
        return this.mAddMinParamsEqualPathSet;
    }

    public Set<String> getAddMinParamsPrefixPathSet() {
        return this.mAddMinParamsPrefixPathSet;
    }

    public Set<Pattern> getAddMinParamsPatternSet() {
        return this.mAddMinParamsPatternSet;
    }

    public Set<String> getMinParamsExcludeSet() {
        return this.mMinParamsExcludeSet;
    }

    public void onNetConfigChanged(String r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onNetConfigChanged config: " + r7);
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mLocalConfig) == false) goto L11;
    L25:
        JSONObject r0 = new JSONObject(r7);     // Catch: Throwable -> L24
        this.mLocalConfig = r7;     // Catch: Throwable -> L24
        parseArraySetStringConfig(r0.optJSONArray(KEY_HOST_GROUP), this.mDomainFilterSet);     // Catch: Throwable -> L24
        parseArraySetStringConfig(r0.optJSONArray(KEY_MIN_PARAMS_EXCLUDE), this.mMinParamsExcludeSet);     // Catch: Throwable -> L24
        JSONObject r8 = r0.optJSONObject(KEY_L0_PATH);     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        parseArraySetStringConfig(r8.optJSONArray(KEY_EQUAL_GROUP), this.mAddMaxParamsEqualPathSet);     // Catch: Throwable -> L24
        parseArraySetStringConfig(r8.optJSONArray(KEY_PREFIX_GROUP), this.mAddMaxParamsPrefixPathSet);     // Catch: Throwable -> L24
        parseArraySetPatternConfig(r8.optJSONArray(KEY_PATTERN_GROUP), this.mAddMaxParamsPatternSet);     // Catch: Throwable -> L24
    L20:
        JSONObject r9 = r0.optJSONObject(KEY_L1_PATH);     // Catch: Throwable -> L24
        if (r9 == null) goto L28;
        parseArraySetStringConfig(r9.optJSONArray(KEY_EQUAL_GROUP), this.mAddMinParamsEqualPathSet);     // Catch: Throwable -> L24
        parseArraySetStringConfig(r9.optJSONArray(KEY_PREFIX_GROUP), this.mAddMinParamsPrefixPathSet);     // Catch: Throwable -> L24
        parseArraySetPatternConfig(r9.optJSONArray(KEY_PATTERN_GROUP), this.mAddMinParamsPatternSet);     // Catch: Throwable -> L24
        return;
    L28:
        return;
    L29:
        return;
    L11:
        if (this.mLocalConfig.equals(r7) == false) goto L25;
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "Config is same with local config, do not parse.");
        return;
    }

    private static void parseArraySetPatternConfig(JSONArray r4, Set<Pattern> r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L27;
        HashSet r0 = new HashSet();
        Iterator<Pattern> r1 = r5.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r0.add(r1.next().toString());
        goto L7
    L9:
        int r2 = 0;
    L20:
        if (r2 >= r4.length()) goto L29;
        String r3 = r4.getString(r2);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r3) == true) goto L17;
        if (r0.contains(r3) == true) goto L17;
        r5.add(Pattern.compile(r3, 2));     // Catch: JSONException -> L19
    L17:
        r2 = r2 + 1;
        goto L20
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    private static void parseArraySetStringConfig(JSONArray r2, Set<String> r3) {
        if (r2 == null) goto L10;
        if (r3 == null) goto L15;
        int r0 = 0;
    L12:
        if (r0 >= r2.length()) goto L17;
        r3.add(r2.getString(r0));     // Catch: JSONException -> L11
        r0 = r0 + 1;
        goto L12
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    private static boolean isEmptyList(List<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }
}
