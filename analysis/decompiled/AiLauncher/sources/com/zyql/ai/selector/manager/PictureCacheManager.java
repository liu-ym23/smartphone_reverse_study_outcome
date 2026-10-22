package com.zyql.ai.selector.manager;

import android.content.Context;
import android.os.Environment;
import com.zyql.ai.selector.PictureMediaScannerConnection;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.listener.OnCallbackListener;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class PictureCacheManager {
    public static void deleteAllCacheDirFile(Context context) {
        deleteAllCacheDirFile(context, false, null);
    }

    public static void deleteAllCacheDirRefreshFile(Context context) {
        deleteAllCacheDirFile(context, true, null);
    }

    public static void deleteCacheDirFile(String str) {
        deleteCacheDirFile(str, (OnCallbackListener<String>) null);
    }

    public static void deleteCacheRefreshDirFile(Context context, int i10) {
        deleteCacheDirFile(context, i10, true, null);
    }

    public static void deleteAllCacheDirFile(Context context, OnCallbackListener<String> onCallbackListener) {
        deleteAllCacheDirFile(context, false, onCallbackListener);
    }

    public static void deleteCacheDirFile(String str, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile() && file.delete() && onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    private static void deleteAllCacheDirFile(final Context context, boolean z10, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null && (fileArrListFiles3 = externalFilesDir.listFiles()) != null) {
            for (final File file : fileArrListFiles3) {
                if (file.isFile() && file.delete()) {
                    if (z10) {
                        PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.zyql.ai.selector.manager.PictureCacheManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                new PictureMediaScannerConnection(context, file.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 != null && (fileArrListFiles2 = externalFilesDir2.listFiles()) != null) {
            for (final File file2 : fileArrListFiles2) {
                if (file2.isFile() && file2.delete()) {
                    if (z10) {
                        PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.zyql.ai.selector.manager.PictureCacheManager.3
                            @Override // java.lang.Runnable
                            public void run() {
                                new PictureMediaScannerConnection(context, file2.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file2.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 == null || (fileArrListFiles = externalFilesDir3.listFiles()) == null) {
            return;
        }
        for (final File file3 : fileArrListFiles) {
            if (file3.isFile() && file3.delete()) {
                if (z10) {
                    PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.zyql.ai.selector.manager.PictureCacheManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            new PictureMediaScannerConnection(context, file3.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file3.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteCacheDirFile(Context context, int i10) {
        deleteCacheDirFile(context, i10, false, null);
    }

    public static void deleteCacheDirFile(Context context, int i10, OnCallbackListener<String> onCallbackListener) {
        deleteCacheDirFile(context, i10, false, onCallbackListener);
    }

    private static void deleteCacheDirFile(final Context context, int i10, boolean z10, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles;
        File externalFilesDir = context.getExternalFilesDir(i10 == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (final File file : fileArrListFiles) {
            if (file.isFile() && file.delete()) {
                if (z10) {
                    PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.zyql.ai.selector.manager.PictureCacheManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            new PictureMediaScannerConnection(context, file.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }
}
