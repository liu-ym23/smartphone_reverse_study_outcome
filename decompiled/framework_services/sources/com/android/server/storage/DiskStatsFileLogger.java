package com.android.server.storage;

import android.content.pm.PackageStats;
import android.os.Environment;
import android.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DiskStatsFileLogger {
    public static final String APP_CACHES_KEY = "cacheSizes";
    public static final String APP_CACHE_AGG_KEY = "cacheSize";
    public static final String APP_DATA_KEY = "appDataSizes";
    public static final String APP_DATA_SIZE_AGG_KEY = "appDataSize";
    public static final String APP_SIZES_KEY = "appSizes";
    public static final String APP_SIZE_AGG_KEY = "appSize";
    public static final String AUDIO_KEY = "audioSize";
    public static final String DOWNLOADS_KEY = "downloadsSize";
    public static final String LAST_QUERY_TIMESTAMP_KEY = "queryTime";
    public static final String MISC_KEY = "otherSize";
    public static final String PACKAGE_NAMES_KEY = "packageNames";
    public static final String PHOTOS_KEY = "photosSize";
    public static final String SYSTEM_KEY = "systemSize";
    private static final String TAG = "DiskStatsLogger";
    public static final String VIDEOS_KEY = "videosSize";
    private long mDownloadsSize;
    private List<PackageStats> mPackageStats;
    private FileCollector.MeasurementResult mResult;
    private long mSystemSize;

    public DiskStatsFileLogger(FileCollector.MeasurementResult result, FileCollector.MeasurementResult downloadsResult, List<PackageStats> stats, long systemSize) {
        this.mResult = result;
        this.mDownloadsSize = downloadsResult.totalAccountedSize();
        this.mSystemSize = systemSize;
        this.mPackageStats = stats;
    }

    public void dumpToFile(File file) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        JSONObject representation = getJsonRepresentation();
        if (representation == null) goto L5;
        pw.println(representation);
    L5:
        pw.close();
    }

    private JSONObject getJsonRepresentation() {
        JSONObject json = new JSONObject();
        json.put(LAST_QUERY_TIMESTAMP_KEY, System.currentTimeMillis());     // Catch: JSONException -> L5
        json.put(PHOTOS_KEY, this.mResult.imagesSize);     // Catch: JSONException -> L5
        json.put(VIDEOS_KEY, this.mResult.videosSize);     // Catch: JSONException -> L5
        json.put(AUDIO_KEY, this.mResult.audioSize);     // Catch: JSONException -> L5
        json.put(DOWNLOADS_KEY, this.mDownloadsSize);     // Catch: JSONException -> L5
        json.put(SYSTEM_KEY, this.mSystemSize);     // Catch: JSONException -> L5
        json.put(MISC_KEY, this.mResult.miscSize);     // Catch: JSONException -> L5
        addAppsToJson(json);     // Catch: JSONException -> L5
        return json;
    L5:
        e = move-exception;
        Log.e(TAG, e.toString());
        return null;
    }

    private void addAppsToJson(JSONObject json) throws JSONException {
        JSONArray names = new JSONArray();
        JSONArray appSizeList = new JSONArray();
        JSONArray appDataSizeList = new JSONArray();
        JSONArray cacheSizeList = new JSONArray();
        long appSizeSum = 0;
        long appDataSizeSum = 0;
        long cacheSizeSum = 0;
        boolean isExternal = Environment.isExternalStorageEmulated();
        Iterator<Map.Entry<String, PackageStats>> r12 = filterOnlyPrimaryUser().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<String, PackageStats> entry = r12.next();
        PackageStats stat = entry.getValue();
        boolean isExternal2 = isExternal;
        Iterator<Map.Entry<String, PackageStats>> r16 = r12;
        long appSize = stat.codeSize;
        long appSize2 = stat.dataSize;
        long appDataSize = stat.cacheSize;
        if (isExternal2 == false) goto L8;
        long cacheSize = stat.externalCodeSize;
        long appSize3 = appSize + cacheSize;
        long appDataSize2 = appSize2 + stat.externalDataSize;
        long appDataSizeSum2 = appDataSize2;
        long cacheSizeSum2 = appDataSize + stat.externalCacheSize;
        long appSize4 = appSize3;
    L9:
        long appSizeSum2 = appSizeSum + appSize4;
        names.put(stat.packageName);
        appSizeList.put(appSize4);
        appDataSizeList.put(appDataSizeSum2);
        cacheSizeList.put(cacheSizeSum2);
        isExternal = isExternal2;
        r12 = r16;
        appDataSizeSum = appDataSizeSum + appDataSizeSum2;
        cacheSizeSum = cacheSizeSum + cacheSizeSum2;
        appSizeSum = appSizeSum2;
        goto L4
    L8:
        appSize4 = appSize;
        appDataSizeSum2 = appSize2;
        cacheSizeSum2 = appDataSize;
        goto L9
    L10:
        json.put(PACKAGE_NAMES_KEY, names);
        json.put(APP_SIZES_KEY, appSizeList);
        json.put(APP_CACHES_KEY, cacheSizeList);
        json.put(APP_DATA_KEY, appDataSizeList);
        json.put(APP_SIZE_AGG_KEY, appSizeSum);
        json.put(APP_CACHE_AGG_KEY, cacheSizeSum);
        json.put(APP_DATA_SIZE_AGG_KEY, appDataSizeSum);
    }

    private ArrayMap<String, PackageStats> filterOnlyPrimaryUser() {
        ArrayMap<String, PackageStats> packageMap = new ArrayMap();
        Iterator<PackageStats> r1 = this.mPackageStats.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        PackageStats stat = r1.next();
        if (stat.userHandle != 0) goto L4;
        PackageStats existingStats = packageMap.get(stat.packageName);
        if (existingStats != null) goto L10;
        packageMap.put(stat.packageName, new PackageStats(stat));
        goto L4
    L10:
        existingStats.cacheSize += stat.cacheSize;
        existingStats.codeSize += stat.codeSize;
        existingStats.dataSize += stat.dataSize;
        existingStats.externalCacheSize += stat.externalCacheSize;
        existingStats.externalCodeSize += stat.externalCodeSize;
        existingStats.externalDataSize += stat.externalDataSize;
        goto L4
    L13:
        return packageMap;
    }
}
