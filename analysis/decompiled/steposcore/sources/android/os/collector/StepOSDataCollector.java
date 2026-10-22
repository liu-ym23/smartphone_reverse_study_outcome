package android.os.collector;

import android.annotation.SystemApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

@SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
/* loaded from: classes.dex */
public final class StepOSDataCollector {
    private static final int FUSE_FLUSH_THRESHOLD = 200;
    private static final String TAG = "StepOSDataCollector";
    private static final String[] MEDIA_FILE_PROJECTION = {"media_type", "_display_name", "_data", "_size", "mime_type", "owner_package_name", "_id"};
    private static final ThreadLocal<String> sScanCaller = new ThreadLocal<>();
    private static final ThreadLocal<List<Long>> sFusePendingIds = new ThreadLocal<>();

    private StepOSDataCollector() {
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void setMediaScanCaller(String packageName) {
        sScanCaller.set(packageName);
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void clearMediaScanCaller() {
        sScanCaller.remove();
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void notifyMediaFileInsert(ContentValues values, Uri uri, String filePath, String ownerPackage, boolean isSelfCall) {
        if (values == null) {
            return;
        }
        Integer isPending = values.getAsInteger("is_pending");
        if (isPending != null && isPending.intValue() != 0) {
            return;
        }
        Integer mediaType = values.getAsInteger("media_type");
        Long size = values.getAsLong("_size");
        write(mediaType != null ? mediaType.intValue() : 0, uri, values.getAsString("_display_name"), filePath, size != null ? size.longValue() : 0L, values.getAsString("mime_type"), ownerPackage, isSelfCall);
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void notifyMediaFilePublished(ContentResolver resolver, Uri uri) throws Throwable {
        Uri uri2;
        Exception e;
        Cursor c;
        Throwable th;
        if (resolver != null && uri != null) {
            try {
                c = resolver.query(uri, MEDIA_FILE_PROJECTION, null, null);
            } catch (Exception e2) {
                uri2 = uri;
                e = e2;
            }
            try {
                if (c != null) {
                    try {
                        if (c.moveToFirst()) {
                            uri2 = uri;
                            try {
                                write(c.getInt(0), uri2, c.getString(1), c.getString(2), c.getLong(3), c.getString(4), c.getString(5), false);
                                if (c != null) {
                                    c.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                if (c == null) {
                                    throw th;
                                }
                                try {
                                    c.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        uri2 = uri;
                        th = th4;
                    }
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e3) {
                e = e3;
                Log.w(TAG, "notifyMediaFilePublished failed for " + uri2, e);
            }
        }
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void onFusePendingScanned(ContentResolver resolver, Uri filesUri, long id) {
        List<Long> ids = sFusePendingIds.get();
        if (ids == null) {
            ids = new ArrayList();
            sFusePendingIds.set(ids);
        }
        ids.add(Long.valueOf(id));
        if (ids.size() >= 200) {
            flushFusePendingScanned(resolver, filesUri);
        }
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    public static void flushFusePendingScanned(ContentResolver resolver, Uri filesUri) {
        List<Long> ids = sFusePendingIds.get();
        if (ids == null) {
            return;
        }
        sFusePendingIds.remove();
        if (resolver == null || filesUri == null) {
            return;
        }
        if (ids.isEmpty()) {
            return;
        }
        StringBuilder where = new StringBuilder("_id").append(" IN (");
        String[] args = new String[ids.size()];
        int i = 0;
        while (i < ids.size()) {
            where.append(i == 0 ? "?" : ",?");
            args[i] = Long.toString(ids.get(i).longValue());
            i++;
        }
        where.append(") AND ").append("is_pending").append("=0");
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            Cursor c = resolver.query(filesUri, MEDIA_FILE_PROJECTION, where.toString(), args, null);
            if (c != null) {
                while (c.moveToNext()) {
                    try {
                        write(c.getInt(0), ContentUris.withAppendedId(filesUri, c.getLong(6)), c.getString(1), c.getString(2), c.getLong(3), c.getString(4), c.getString(5), false);
                    } finally {
                    }
                }
                if (c != null) {
                    c.close();
                    return;
                }
                return;
            }
            if (c != null) {
                c.close();
            }
        } catch (Exception e2) {
            e = e2;
            Log.w(TAG, "flushFusePendingScanned failed for " + ids.size() + " rows", e);
        }
    }

    private static void write(int fileType, Uri uri, String fileName, String filePath, long fileSize, String mimeType, String ownerPackage, boolean isSelfCall) {
        IStepOSDataCollectStub.get().onWriteMediaFileData(fileType, uri != null ? uri.toString() : null, fileName, filePath, fileSize, mimeType, ownerPackage, System.currentTimeMillis(), isSelfCall, sScanCaller.get());
    }
}
