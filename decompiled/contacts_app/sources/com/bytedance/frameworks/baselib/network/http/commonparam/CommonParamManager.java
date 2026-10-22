package com.bytedance.frameworks.baselib.network.http.commonparam;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CommonParamManager {
    private static final int MAX_PARAM_LEVEL = 0;
    private static final int MIN_PARAM_LEVEL = 1;
    private static final String TAG = "CommonParamManager";
    private static volatile CommonParamManager sInstance;
    private CommonParamConfig mCommonParamConfig;
    private volatile boolean mForceAddMinParamsEnabled;

    public static CommonParamManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CommonParamManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CommonParamManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CommonParamManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CommonParamManager() {
        this.mForceAddMinParamsEnabled = false;
    }

    public CommonParamConfig getCommonParamConfig() {
        return this.mCommonParamConfig;
    }

    public void setCommonParamConfig(CommonParamConfig r2) {
        if (this.mCommonParamConfig != null) goto L10;
        if (r2 == null) goto L8;
        this.mCommonParamConfig = r2;
        return;
    L8:
        throw new IllegalArgumentException("config is null, please init CommonParamConfig before.");
    L10:
        throw new IllegalStateException("CommonParamConfig has been initialized before.");
    }

    public void setForceAddMinParamsEnabled(boolean r1) {
        this.mForceAddMinParamsEnabled = r1;
    }

    public String addCommonParams(Request r8, String r9) {
        if (this.mCommonParamConfig.isCustomCommonParamLevelEnabled() == true) goto L5;
        Set<String> r0 = this.mCommonParamConfig.getDomainFilterSet();
        if (isEmptySet(r0) == false) goto L9;
        return r9;
    L9:
        Iterator<String> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        if (UrlUtils.matchPattern(r8.getHost(), r1.next()) == false) goto L11;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L23;
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "Domain not match: " + r9);
    L21:
        return r9;
    L23:
        if (TextUtils.isEmpty(r8.getPath()) == false) goto L29;
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "Path is empty: " + r8.getPath());
    L27:
        return r9;
    L29:
        if (this.mForceAddMinParamsEnabled == false) goto L36;
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "ForceAddMinParams match url: " + r9);
    L34:
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1), r9, true);
    L36:
        if (isMatchPathRule(this.mCommonParamConfig.getAddMaxParamsEqualPathSet(), this.mCommonParamConfig.getAddMaxParamsPrefixPathSet(), this.mCommonParamConfig.getAddMaxParamsPatternSet(), r8.getPath()) == false) goto L43;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "AddMaxParamsPathFilterMap match: " + r9);
    L41:
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(0), r9, false);
    L43:
        if (isMatchPathRule(this.mCommonParamConfig.getAddMinParamsEqualPathSet(), this.mCommonParamConfig.getAddMinParamsPrefixPathSet(), this.mCommonParamConfig.getAddMinParamsPatternSet(), r8.getPath()) == false) goto L50;
        if (Logger.debug() == false) goto L48;
        Logger.d(TAG, "AddMinParamsPathFilterMap match: " + r9);
    L48:
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1), r9, true);
    L50:
        if (this.mCommonParamConfig.addMinCommonParamsWhenDomainMatch() == false) goto L57;
        if (Logger.debug() == false) goto L55;
        Logger.d(TAG, "addMinCommonParamsWhenDomainMatch is enabled.");
    L55:
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1), r9, true);
    L57:
        if (Logger.debug() == false) goto L60;
        Logger.d(TAG, "add max common params by default.");
    L60:
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(0), r9, false);
    L15:
        r2 = false;
        goto L17
    L5:
        return addCommonParamsByQueryMap(NetworkParams.addCommonParamsByLevel(r9, true, r8.getCommonParamLevel()), r9, false);
    }

    private boolean isMatchPathRule(Set<String> r2, Set<String> r3, Set<Pattern> r4, String r5) {
        if (isEmptySet(r2) == true) goto L11;
        Iterator<String> r1 = r2.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        if (r5.equals(r1.next()) == false) goto L6;
        return true;
    L11:
        if (isEmptySet(r3) == true) goto L19;
        Iterator<String> r6 = r3.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        if (r5.startsWith(r6.next()) == false) goto L14;
        return true;
    L19:
        if (isEmptySet(r4) == true) goto L28;
        Iterator<Pattern> r7 = r4.iterator();
    L22:
        if (r7.hasNext() == false) goto L45;
        Pattern r8 = r7.next();
        if (r8 == null) goto L22;
        if (r8.matcher(r5).matches() == false) goto L22;
        return true;
    L45:
        return false;
    L28:
        return false;
    }

    private String addCommonParamsByQueryMap(Map<String, String> r5, String r6, boolean r7) {
        if (r5 != null) goto L4;
    L31:
        return r6;
    L4:
        if (r5.isEmpty() == true) goto L31;
        StringBuilder r0 = new StringBuilder(r6);
        if (r6.indexOf(63) >= 0) goto L9;
        r0.append("?");
    L10:
        ArrayList r8 = new ArrayList();
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, String> r1 = r9.next();
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L12;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L12;
        Set<String> r2 = this.mCommonParamConfig.getMinParamsExcludeSet();
        if (r7 == false) goto L25;
        if (isEmptySet(r2) == true) goto L25;
        if (r2.contains(r1.getKey()) == true) goto L12;
    L25:
        r8.add(new Pair(r1.getKey(), r1.getValue()));
        goto L12
    L26:
        r0.append(NetworkUtils.format(r8, "UTF-8"));
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "addCommonParamsByQueryMap url: " + r0.toString());
    L30:
        return r0.toString();
    L9:
        r0.append("&");
        goto L10
    }

    private static boolean isEmptySet(Set<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }
}
