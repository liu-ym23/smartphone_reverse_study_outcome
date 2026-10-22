package com.android.server;

import android.R;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.PermissionChecker;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.NetworkScorerAppData;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkScorerAppManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "NetworkScorerAppManager";
    private static final boolean VERBOSE = false;
    private final Context mContext;
    private final SettingsFacade mSettingsFacade;

    public static class SettingsFacade {
        public SettingsFacade() {
        }

        public boolean putString(Context context, String name, String value) {
            return Settings.Global.putString(context.getContentResolver(), name, value);
        }

        public String getString(Context context, String name) {
            return Settings.Global.getString(context.getContentResolver(), name);
        }

        public boolean putInt(Context context, String name, int value) {
            return Settings.Global.putInt(context.getContentResolver(), name, value);
        }

        public int getInt(Context context, String name, int defaultValue) {
            return Settings.Global.getInt(context.getContentResolver(), name, defaultValue);
        }

        public int getSecureInt(Context context, String name, int defaultValue) {
            ContentResolver cr = context.getContentResolver();
            return Settings.Secure.getIntForUser(cr, name, defaultValue, cr.getUserId());
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        VERBOSE = Log.isLoggable(TAG, 2);
    }

    public NetworkScorerAppManager(Context context) {
        this(context, new SettingsFacade());
    }

    public NetworkScorerAppManager(Context context, SettingsFacade settingsFacade) {
        this.mContext = context;
        this.mSettingsFacade = settingsFacade;
    }

    public List<NetworkScorerAppData> getAllValidScorers() {
        if (VERBOSE == false) goto L5;
        Log.v(TAG, "getAllValidScorers()");
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        Intent serviceIntent = new Intent("android.net.action.RECOMMEND_NETWORKS");
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(serviceIntent, 128);
        if (resolveInfos == null) goto L26;
        if (resolveInfos.isEmpty() == true) goto L26;
        List<NetworkScorerAppData> appDataList = new ArrayList();
        int i = 0;
    L12:
        if (i >= resolveInfos.size()) goto L24;
        ServiceInfo serviceInfo = resolveInfos.get(i).serviceInfo;
        if (hasPermissions(serviceInfo.applicationInfo.uid, serviceInfo.packageName) == false) goto L20;
        if (VERBOSE == false) goto L18;
        Log.v(TAG, serviceInfo.packageName + " is a valid scorer/recommender.");
    L18:
        ComponentName serviceComponentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        String serviceLabel = getRecommendationServiceLabel(serviceInfo, pm);
        ComponentName useOpenWifiNetworksActivity = findUseOpenWifiNetworksActivity(serviceInfo);
        String networkAvailableNotificationChannelId = getNetworkAvailableNotificationChannelId(serviceInfo);
        appDataList.add(new NetworkScorerAppData(serviceInfo.applicationInfo.uid, serviceComponentName, serviceLabel, useOpenWifiNetworksActivity, networkAvailableNotificationChannelId));
    L22:
        i = i + 1;
        goto L12
    L20:
        if (VERBOSE == false) goto L22;
        Log.v(TAG, serviceInfo.packageName + " is NOT a valid scorer/recommender.");
        goto L22
    L24:
        return appDataList;
    L26:
        if (DEBUG == false) goto L29;
        Log.d(TAG, "Found 0 Services able to handle " + serviceIntent);
    L29:
        return Collections.emptyList();
    }

    private String getRecommendationServiceLabel(ServiceInfo serviceInfo, PackageManager pm) {
        if (serviceInfo.metaData == null) goto L7;
        String label = serviceInfo.metaData.getString("android.net.scoring.recommendation_service_label");
        if (TextUtils.isEmpty(label) == true) goto L7;
        return label;
    L7:
        CharSequence label2 = serviceInfo.loadLabel(pm);
        if (label2 != null) goto L11;
        return null;
    L11:
        return label2.toString();
    }

    private ComponentName findUseOpenWifiNetworksActivity(ServiceInfo serviceInfo) {
        if (serviceInfo.metaData == null) goto L5;
        String useOpenWifiPackage = serviceInfo.metaData.getString("android.net.wifi.use_open_wifi_package");
        if (TextUtils.isEmpty(useOpenWifiPackage) == true) goto L11;
        Intent enableUseOpenWifiIntent = new Intent("android.net.scoring.CUSTOM_ENABLE").setPackage(useOpenWifiPackage);
        ResolveInfo resolveActivityInfo = this.mContext.getPackageManager().resolveActivity(enableUseOpenWifiIntent, 0);
        if (VERBOSE == false) goto L17;
        Log.d(TAG, "Resolved " + enableUseOpenWifiIntent + " to " + resolveActivityInfo);
    L17:
        if (resolveActivityInfo != null) goto L19;
    L22:
        return null;
    L19:
        if (resolveActivityInfo.activityInfo == null) goto L22;
        return resolveActivityInfo.activityInfo.getComponentName();
    L11:
        if (DEBUG == false) goto L13;
        Log.d(TAG, "No use_open_wifi_package metadata found on " + serviceInfo.getComponentName());
    L13:
        return null;
    L5:
        if (DEBUG == false) goto L7;
        Log.d(TAG, "No metadata found on " + serviceInfo.getComponentName());
    L7:
        return null;
    }

    private static String getNetworkAvailableNotificationChannelId(ServiceInfo serviceInfo) {
        if (serviceInfo.metaData != null) goto L10;
        if (DEBUG == false) goto L11;
        Log.d(TAG, "No metadata found on " + serviceInfo.getComponentName());
        return null;
    L11:
        return null;
    L10:
        return serviceInfo.metaData.getString("android.net.wifi.notification_channel_id_network_available");
    }

    public NetworkScorerAppData getActiveScorer() {
        int enabledSetting = getNetworkRecommendationsEnabledSetting();
        if (enabledSetting != (-1)) goto L7;
        return null;
    L7:
        return getScorer(getNetworkRecommendationsPackage());
    }

    private NetworkScorerAppData getScorer(String packageName) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
        return null;
    L5:
        List<NetworkScorerAppData> apps = getAllValidScorers();
        int i = 0;
    L7:
        if (i >= apps.size()) goto L13;
        NetworkScorerAppData app = apps.get(i);
        if (app.getRecommendationServicePackageName().equals(packageName) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return app;
    L13:
        return null;
    }

    private boolean hasPermissions(int uid, String packageName) {
        if (hasScoreNetworksPermission(packageName) == true) goto L5;
    L7:
        return false;
    L5:
        if (canAccessLocation(uid, packageName) == false) goto L7;
        return true;
    }

    private boolean hasScoreNetworksPermission(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.checkPermission("android.permission.SCORE_NETWORKS", packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canAccessLocation(int uid, String packageName) {
        if (isLocationModeEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (PermissionChecker.checkPermissionForPreflight(this.mContext, "android.permission.ACCESS_COARSE_LOCATION", -1, uid, packageName) != 0) goto L7;
        return true;
    }

    private boolean isLocationModeEnabled() {
        if (this.mSettingsFacade.getSecureInt(this.mContext, "location_mode", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean setActiveScorer(String packageName) {
        String oldPackageName = getNetworkRecommendationsPackage();
        if (TextUtils.equals(oldPackageName, packageName) == false) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(packageName) == false) goto L10;
        Log.i(TAG, "Network scorer forced off, was: " + oldPackageName);
        setNetworkRecommendationsPackage(null);
        setNetworkRecommendationsEnabledSetting(-1);
        return true;
    L10:
        if (getScorer(packageName) == null) goto L13;
        Log.i(TAG, "Changing network scorer from " + oldPackageName + " to " + packageName);
        setNetworkRecommendationsPackage(packageName);
        setNetworkRecommendationsEnabledSetting(1);
        return true;
    L13:
        Log.w(TAG, "Requested network scorer is not valid: " + packageName);
        return false;
    }

    public void updateState() {
        int enabledSetting = getNetworkRecommendationsEnabledSetting();
        if (enabledSetting == (-1)) goto L5;
        String currentPackageName = getNetworkRecommendationsPackage();
        if (getScorer(currentPackageName) != null) goto L11;
        int newEnabledSetting = 0;
        String defaultPackageName = getDefaultPackageSetting();
        if (TextUtils.equals(currentPackageName, defaultPackageName) == false) goto L18;
    L23:
        setNetworkRecommendationsEnabledSetting(newEnabledSetting);
        return;
    L18:
        if (getScorer(defaultPackageName) == null) goto L23;
        if (DEBUG == false) goto L22;
        Log.d(TAG, "Defaulting the network recommendations app to: " + defaultPackageName);
    L22:
        setNetworkRecommendationsPackage(defaultPackageName);
        newEnabledSetting = 1;
        goto L23
    L11:
        if (VERBOSE == false) goto L13;
        Log.v(TAG, currentPackageName + " is the active scorer.");
    L13:
        setNetworkRecommendationsEnabledSetting(1);
        return;
    L5:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "Recommendations forced off.");
        return;
    }

    public void migrateNetworkScorerAppSettingIfNeeded() {
        String scorerAppPkgNameSetting = this.mSettingsFacade.getString(this.mContext, "network_scorer_app");
        if (TextUtils.isEmpty(scorerAppPkgNameSetting) == false) goto L5;
        return;
    L5:
        NetworkScorerAppData currentAppData = getActiveScorer();
        if (currentAppData != null) goto L9;
        return;
    L9:
        if (DEBUG == false) goto L11;
        Log.d(TAG, "Migrating Settings.Global.NETWORK_SCORER_APP (" + scorerAppPkgNameSetting + ")...");
    L11:
        ComponentName enableUseOpenWifiActivity = currentAppData.getEnableUseOpenWifiActivity();
        String useOpenWifiSetting = this.mSettingsFacade.getString(this.mContext, "use_open_wifi_package");
        if (TextUtils.isEmpty(useOpenWifiSetting) == false) goto L19;
        if (enableUseOpenWifiActivity == null) goto L19;
        if (scorerAppPkgNameSetting.equals(enableUseOpenWifiActivity.getPackageName()) == false) goto L19;
        this.mSettingsFacade.putString(this.mContext, "use_open_wifi_package", scorerAppPkgNameSetting);
        if (DEBUG == false) goto L19;
        Log.d(TAG, "Settings.Global.USE_OPEN_WIFI_PACKAGE set to '" + scorerAppPkgNameSetting + "'.");
    L19:
        this.mSettingsFacade.putString(this.mContext, "network_scorer_app", null);
        if (DEBUG == false) goto L23;
        Log.d(TAG, "Settings.Global.NETWORK_SCORER_APP migration complete.");
        String setting = this.mSettingsFacade.getString(this.mContext, "use_open_wifi_package");
        Log.d(TAG, "Settings.Global.USE_OPEN_WIFI_PACKAGE is: '" + setting + "'.");
        return;
    }

    private String getDefaultPackageSetting() {
        return this.mContext.getResources().getString(R.string.config_fusedLocationProviderPackageName);
    }

    private String getNetworkRecommendationsPackage() {
        return this.mSettingsFacade.getString(this.mContext, "network_recommendations_package");
    }

    private void setNetworkRecommendationsPackage(String packageName) {
        this.mSettingsFacade.putString(this.mContext, "network_recommendations_package", packageName);
        if (VERBOSE == false) goto L6;
        Log.d(TAG, "network_recommendations_package set to " + packageName);
        return;
    }

    private int getNetworkRecommendationsEnabledSetting() {
        return this.mSettingsFacade.getInt(this.mContext, "network_recommendations_enabled", 0);
    }

    private void setNetworkRecommendationsEnabledSetting(int value) {
        this.mSettingsFacade.putInt(this.mContext, "network_recommendations_enabled", value);
        if (VERBOSE == false) goto L6;
        Log.d(TAG, "network_recommendations_enabled set to " + value);
        return;
    }
}
