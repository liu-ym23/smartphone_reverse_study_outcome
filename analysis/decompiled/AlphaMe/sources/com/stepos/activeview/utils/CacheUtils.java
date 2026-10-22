package com.stepos.activeview.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

/* loaded from: classes.dex */
public class CacheUtils {
    private static final int MILLIS_ONE_HOUR = 3600000;
    private static String SP_NAME = "activecache";
    private static volatile CacheUtils mCacheUtilsInstance;
    private static SharedPreferences mSharedPreferences;
    private Context mContext;

    private CacheUtils(Context context) {
        this.mContext = context;
        mSharedPreferences = context.getSharedPreferences(SP_NAME, 0);
    }

    public static CacheUtils getInstance(Context context) {
        if (mCacheUtilsInstance == null) {
            synchronized (CacheUtils.class) {
                try {
                    if (mCacheUtilsInstance == null) {
                        mCacheUtilsInstance = new CacheUtils(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return mCacheUtilsInstance;
    }

    public int clearCacheFolder(String str, int i4) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        return clearCacheFolder(new File(str), System.currentTimeMillis(), i4 * 3600000);
    }

    public String getSharePreferenceValue(String str) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, "");
        }
        return null;
    }

    public boolean isCached(String str) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public void removeSharedPreference(String str) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.apply();
        }
    }

    public void saveToSharedPreferences(String str, String str2) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }

    private int clearCacheFolder(File file, long j4, long j5) {
        int i4;
        Exception e4;
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            i4 = 0;
            for (File file2 : file.listFiles()) {
                try {
                    if (file2.lastModified() + j5 <= j4) {
                        if (file2.isDirectory()) {
                            FileUtil.deleteDirectory(file2.getAbsolutePath());
                        } else {
                            FileUtil.deleteFile(file2.getAbsolutePath());
                        }
                        i4++;
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    e4.printStackTrace();
                    return i4;
                }
            }
        } catch (Exception e6) {
            i4 = 0;
            e4 = e6;
        }
        return i4;
    }
}
