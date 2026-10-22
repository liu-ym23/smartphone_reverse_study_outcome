package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CleanerConfig {
    private static final int FORCE_CLEAN_ID = -1;
    private static final String KEY_CLEAN_FINISH = "key_clean_finish";
    private static final String KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY = "key_download_cache_clean_strategy";
    private static final String TAG = "CleanerConfig";
    private volatile Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private volatile Set<Integer> mCleanDownloadIdSet;
    private volatile Map<Integer, CleanItem> mCleanItemMaps;
    private volatile Map<Integer, String> mFileDirPathMap;
    private volatile Map<Integer, String> mFileNameMap;
    private volatile boolean mFinish;
    private volatile Map<Integer, CleanItem> mNeedCleanItemMaps;
    private volatile Set<Integer> mOnlyCleanFileSet;
    private String mPackageName;
    private volatile Map<Integer, String> mTempSavePath;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.CleanerConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CleanItem {
        boolean finish;
        List<String> prefixUrls;
        Set<String> savePaths;
        Set<String> scenes;
        final /* synthetic */ CleanerConfig this$0;

        private CleanItem(CleanerConfig r1) {
            this.this$0 = r1;
            this.scenes = new HashSet();
            this.prefixUrls = new ArrayList();
            this.savePaths = new HashSet();
        }

        /* synthetic */ CleanItem(CleanerConfig r1, AnonymousClass1 r2) {
            this(r1);
        }

        public String toString() {
            return "CleanItem{finish=" + this.finish + ", scenes=" + this.scenes + ", prefixUrls=" + this.prefixUrls + ", savePaths=" + this.savePaths + '}';
        }
    }

    public CleanerConfig() {
        this.mCleanItemMaps = new HashMap();
        this.mNeedCleanItemMaps = new HashMap();
        this.mCleanCacheKeyMaps = new HashMap();
        this.mCleanDownloadIdSet = new HashSet();
        this.mFileDirPathMap = new HashMap();
        this.mFileNameMap = new HashMap();
        this.mTempSavePath = new HashMap();
        this.mOnlyCleanFileSet = new HashSet();
        this.mFinish = false;
    }

    public void init() {
        parseCleanSetting(getString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY));     // Catch: Throwable -> L15
        parseCleanSetting(DownloadSetting.getGlobalSettings());     // Catch: Throwable -> L15
        if (this.mCleanItemMaps.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, CleanItem>> r0 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        CleanItem r2 = (CleanItem) ZeusTransformUtils.preCheckCast(r1.getValue(), CleanItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r2.finish == true) goto L8;
        this.mNeedCleanItemMaps.put((Integer) r1.getKey(), r2);     // Catch: Throwable -> L15
        goto L8
    L13:
        this.mPackageName = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }

    private void addToCleanDownloadIdSet(int r2) {
        if (this.mFinish == false) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        return;
    L7:
        Set<Integer> r0 = this.mCleanDownloadIdSet;
        monitor-enter(r0);
        this.mCleanDownloadIdSet.add(Integer.valueOf(r2));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeFromCleanDownloadIdSet(int r3) {
        Set<Integer> r0 = this.mCleanDownloadIdSet;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCleanDownloadIdSet.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mCleanDownloadIdSet.remove(Integer.valueOf(r3));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public boolean isNoCacheNeedClean() {
        Set<Integer> r0 = this.mCleanDownloadIdSet;
        monitor-enter(r0);
        boolean r1 = this.mCleanDownloadIdSet.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isExistInCleanSet(int r2) {
        if (this.mFinish == false) goto L6;
        return false;
    L6:
        Set<Integer> r0 = this.mCleanDownloadIdSet;
        monitor-enter(r0);
        boolean r1 = this.mCleanDownloadIdSet.contains(Integer.valueOf(r2));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private void saveFilePath(DownloadInfo r4) {
        if (TextUtils.isEmpty(r4.getSavePath()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getName()) == true) goto L11;
        this.mFileDirPathMap.put(Integer.valueOf(r4.getId()), r4.getSavePath());
        this.mFileNameMap.put(Integer.valueOf(r4.getId()), r4.getName());
        if (TextUtils.isEmpty(r4.getTempPath()) == true) goto L12;
        this.mTempSavePath.put(Integer.valueOf(r4.getId()), r4.getTempPath());
        return;
    L12:
        return;
    }

    public String getSavePath(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.mFileDirPathMap.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
    }

    public String getName(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.mFileNameMap.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
    }

    public String getTempSavePath(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.mTempSavePath.get(Integer.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
    }

    public boolean isOnlyCleanFile(int r1) {
        return this.mOnlyCleanFileSet.contains(Integer.valueOf(r1));
    }

    public boolean updateCleanDownloadId(DownloadInfo r7) {
        if (this.mNeedCleanItemMaps.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<Integer, CleanItem>> r0 = this.mNeedCleanItemMaps.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (matchCleanItem((CleanItem) ZeusTransformUtils.preCheckCast(r2.getValue(), CleanItem.class, "com.obric.aiagent.plugin"), r7) == false) goto L7;
        addCleanDownloadItem(((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue(), r7, false);
        return true;
    L12:
        return false;
    }

    public boolean forceUpdateCleanDownloadId(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        addCleanDownloadItem(-1, r2, r3);
        return true;
    }

    private void addCleanDownloadItem(int r4, DownloadInfo r5, boolean r6) {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(this.mCleanCacheKeyMaps.get(Integer.valueOf(r4)), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r0.add(Integer.valueOf(r5.getId()));
        addToCleanDownloadIdSet(r5.getId());
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r4), r0);
        saveFilePath(r5);
        if (r6 == false) goto L9;
        this.mOnlyCleanFileSet.add(Integer.valueOf(r5.getId()));
        return;
    }

    private boolean matchCleanItem(CleanItem r8, DownloadInfo r9) {
        if (r8 == null) goto L43;
        if (r9 == null) goto L43;
        if (TextUtils.isEmpty(r9.getSavePath()) == true) goto L10;
        return false;
    L10:
        if (r8.scenes.isEmpty() == true) goto L17;
        if (TextUtils.isEmpty(r9.getMonitorScene()) == true) goto L17;
        if (r8.scenes.contains(r9.getMonitorScene()) == false) goto L17;
        return true;
    L17:
        if (r8.prefixUrls.isEmpty() == true) goto L28;
        String r1 = r9.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        Iterator<String> r3 = r8.prefixUrls.iterator();
    L23:
        if (r3.hasNext() == false) goto L28;
        if (r1.startsWith((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L23;
        return true;
    L28:
        if (r8.savePaths.isEmpty() == true) goto L43;
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L43;
        String r10 = r9.getSavePath();
        if (TextUtils.isEmpty(r10) == false) goto L35;
        return false;
    L35:
        if (r10.indexOf(this.mPackageName) > 0) goto L38;
        return false;
    L38:
        if (r10.endsWith("/") == false) goto L41;
        r10 = r10.substring(0, r10.length() - 1);
    L41:
        if (r8.savePaths.contains(r10) == false) goto L43;
        return true;
    L43:
        return false;
    }

    public Map<Integer, List<Integer>> getCleanCacheKeyMaps() {
        return this.mCleanCacheKeyMaps;
    }

    private void parseCleanSetting(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        parseCleanSetting(new JSONObject(r2));
    }

    private void parseCleanSetting(JSONObject r12) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "parseCleanSetting", "Run");
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        JSONArray r13 = r12.optJSONArray(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP);
        if (r13 != null) goto L10;
        return;
    L10:
        if (r13.length() <= 0) goto L82;
        int r3 = 0;
    L14:
        if (r3 >= r13.length()) goto L63;
        JSONObject r4 = r13.getJSONObject(r3);
        int r5 = r4.optInt(DownloadSettingKeys.CacheCleaner.CLEAN_ID);
        if (this.mCleanItemMaps.containsKey(Integer.valueOf(r5)) == true) goto L61;
        CleanItem r6 = new CleanItem(this, null);
        r6.finish = r4.optBoolean(KEY_CLEAN_FINISH);
        if (r6.finish == false) goto L21;
        this.mCleanItemMaps.put(Integer.valueOf(r5), r6);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r5), new ArrayList());
        goto L61
    L21:
        JSONArray r7 = r4.optJSONArray(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST);
        if (r7 != null) goto L24;
    L32:
        JSONArray r8 = r4.optJSONArray(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST);
        if (r8 != null) goto L35;
    L43:
        JSONArray r9 = r4.optJSONArray(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST);
        if (r9 == null) goto L55;
        if (r9.length() <= 0) goto L55;
        int r10 = 0;
    L49:
        if (r10 >= r9.length()) goto L55;
        String r11 = r9.optString(r10);
        if (TextUtils.isEmpty(r11) == true) goto L53;
        r6.savePaths.add(r11);
    L53:
        r10 = r10 + 1;
    L55:
        if (r6.scenes.isEmpty() == true) goto L57;
    L60:
        this.mCleanItemMaps.put(Integer.valueOf(r5), r6);
        this.mCleanCacheKeyMaps.put(Integer.valueOf(r5), new ArrayList());
        goto L61
    L57:
        if (r6.prefixUrls.isEmpty() == false) goto L60;
        if (r6.savePaths.isEmpty() == true) goto L61;
    L35:
        if (r8.length() <= 0) goto L43;
        int r14 = 0;
    L38:
        if (r14 >= r8.length()) goto L43;
        String r15 = r8.optString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L42;
        r6.prefixUrls.add(r15);
    L42:
        r14 = r14 + 1;
        goto L38
    L24:
        if (r7.length() <= 0) goto L32;
        int r16 = 0;
    L27:
        if (r16 >= r7.length()) goto L32;
        String r17 = r7.optString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L31;
        r6.scenes.add(r17);
    L31:
        r16 = r16 + 1;
    L61:
        r3 = r3 + 1;
        goto L14
    L63:
        if (Logger.debug() == false) goto L81;
        Logger.globalDebug(TAG, "parseCleanSetting", "Result: " + this.mCleanItemMaps);
        return;
    L81:
        return;
    }

    public void updateCleanSetting(int r13) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "updateCleanSetting", "Run:" + r13);
    L6:
        if (this.mCleanItemMaps.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mCleanItemMaps.get(Integer.valueOf(r13)) != null) goto L10;
        return;
    L10:
        if (((CleanItem) ZeusTransformUtils.preCheckCast(this.mCleanItemMaps.get(Integer.valueOf(r13)), CleanItem.class, "com.obric.aiagent.plugin")).finish == true) goto L56;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L40
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<Map.Entry<Integer, CleanItem>> r5 = this.mCleanItemMaps.entrySet().iterator();     // Catch: Throwable -> L40
    L14:
        if (r5.hasNext() == false) goto L38;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L40
        r7.put(DownloadSettingKeys.CacheCleaner.CLEAN_ID, r6.getKey());     // Catch: Throwable -> L40
        CleanItem r8 = (CleanItem) ZeusTransformUtils.preCheckCast(r6.getValue(), CleanItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r8.finish == false) goto L18;
    L21:
        boolean r9 = true;
    L22:
        r8.finish = r9;     // Catch: Throwable -> L40
        r7.put(KEY_CLEAN_FINISH, r8.finish);     // Catch: Throwable -> L40
        if (r8.finish == true) goto L24;
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r11 = r8.scenes.iterator();     // Catch: Throwable -> L40
    L27:
        if (r11.hasNext() == false) goto L29;
        r10.put((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        goto L27
    L29:
        r7.put(DownloadSettingKeys.CacheCleaner.MONITOR_SCENE_LIST, r10);     // Catch: Throwable -> L40
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r14 = r8.prefixUrls.iterator();     // Catch: Throwable -> L40
    L31:
        if (r14.hasNext() == false) goto L33;
        r12.put((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        goto L31
    L33:
        r7.put(DownloadSettingKeys.CacheCleaner.URL_PREFIX_LIST, r12);     // Catch: Throwable -> L40
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L40
        Iterator<String> r16 = r8.savePaths.iterator();     // Catch: Throwable -> L40
    L35:
        if (r16.hasNext() == false) goto L37;
        r15.put((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        goto L35
    L37:
        r7.put(DownloadSettingKeys.CacheCleaner.SAVE_PATH_LIST, r15);     // Catch: Throwable -> L40
        r3.put(r7);     // Catch: Throwable -> L40
        goto L14
    L24:
        r3.put(r7);     // Catch: Throwable -> L40
        goto L14
    L18:
        if (((Integer) ZeusTransformUtils.preCheckCast(r6.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue() == r13) goto L21;
        r9 = false;
        goto L22
    L38:
        r0.put(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP, r3);     // Catch: Throwable -> L40
        putString(KEY_DOWNLOAD_CACHE_CLEAN_STRATEGY, r0.toString());     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "updateCleanSetting", "Error:" + th);
        return;
    }

    private SharedPreferences getDownloadCacheSp() {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
    }

    private String getString(String r2) {
        return getDownloadCacheSp().getString(r2, "");
    }

    private void putString(String r1, String r2) {
        getDownloadCacheSp().edit().putString(r1, r2).apply();
    }

    public void finish() {
        this.mFinish = true;
        this.mCleanItemMaps.clear();
        this.mNeedCleanItemMaps.clear();
        this.mCleanCacheKeyMaps.clear();
        this.mFileDirPathMap.clear();
        this.mFileNameMap.clear();
        this.mTempSavePath.clear();
        this.mOnlyCleanFileSet.clear();
        Set<Integer> r0 = this.mCleanDownloadIdSet;
        monitor-enter(r0);
        this.mCleanDownloadIdSet.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
