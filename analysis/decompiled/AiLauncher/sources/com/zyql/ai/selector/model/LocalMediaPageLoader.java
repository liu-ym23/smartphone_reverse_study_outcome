package com.zyql.ai.selector.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.entity.MediaData;
import com.zyql.ai.selector.listener.OnQueryDataResultListener;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.ValueOf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class LocalMediaPageLoader {
    private static final String COLUMN_BUCKET_ID = "bucket_id";
    private static final String COLUMN_COUNT = "count";
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    private static final String TAG = "LocalMediaPageLoader";

    @SuppressLint({"StaticFieldLeak"})
    private static LocalMediaPageLoader instance;
    private final PictureSelectionConfig config = PictureSelectionConfig.getInstance();
    private final Context mContext;
    private static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    private static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final String[] PROJECTION_29 = {StepOSRecipientEmailHistory._ID, "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
    private static final String[] PROJECTION = {StepOSRecipientEmailHistory._ID, "_data", "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type", "COUNT(*) AS count"};
    private static final String[] PROJECTION_PAGE = {StepOSRecipientEmailHistory._ID, "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", "bucket_id", "date_added"};

    public LocalMediaPageLoader(Context context) {
        this.mContext = context;
    }

    public static /* synthetic */ int a(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    private String getDurationCondition() {
        int i10 = this.config.videoMaxSecond;
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(0L, r0.videoMinSecond)), Math.max(0L, (long) this.config.videoMinSecond) == 0 ? "" : "=", Long.valueOf(i10 == 0 ? Long.MAX_VALUE : i10));
    }

    private String getFileSizeCondition() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        long j10 = pictureSelectionConfig.filterMaxFileSize;
        if (j10 == 0) {
            j10 = Long.MAX_VALUE;
        }
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", Long.valueOf(Math.max(0L, pictureSelectionConfig.filterMinFileSize)), Math.max(0L, this.config.filterMinFileSize) == 0 ? "" : "=", Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("mime_type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUri(Cursor cursor) {
        return getRealPathAndroid_Q(cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("_data"));
    }

    public static LocalMediaPageLoader getInstance(Context context) {
        if (instance == null) {
            synchronized (LocalMediaPageLoader.class) {
                try {
                    if (instance == null) {
                        instance = new LocalMediaPageLoader(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPageSelection(long j10) {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            return getPageSelectionArgsForAllMediaCondition(j10, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i10 == 1) {
            return getPageSelectionArgsForImageMediaCondition(j10, queryMimeCondition, fileSizeCondition);
        }
        if (i10 == 2 || i10 == 3) {
            return getPageSelectionArgsForVideoOrAudioMediaCondition(j10, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getPageSelectionArgs(long j10) {
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            return j10 == -1 ? new String[]{String.valueOf(1), String.valueOf(3)} : new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString(Long.valueOf(j10))};
        }
        if (i10 == 1) {
            return getSelectionArgsForPageSingleMediaType(1, j10);
        }
        if (i10 == 2) {
            return getSelectionArgsForPageSingleMediaType(3, j10);
        }
        if (i10 != 3) {
            return null;
        }
        return getSelectionArgsForPageSingleMediaType(2, j10);
    }

    private static String getPageSelectionArgsForAllMediaCondition(long j10, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        sb2.append(str);
        sb2.append(" OR ");
        sb2.append("media_type");
        sb2.append("=? AND ");
        sb2.append(str2);
        sb2.append(") AND ");
        if (j10 == -1) {
            sb2.append(str3);
            return sb2.toString();
        }
        sb2.append("bucket_id");
        sb2.append("=? AND ");
        sb2.append(str3);
        return sb2.toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long j10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        if (j10 == -1) {
            sb2.append(str);
            sb2.append(") AND ");
            sb2.append(str2);
            return sb2.toString();
        }
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append("bucket_id");
        sb2.append("=? AND ");
        sb2.append(str2);
        return sb2.toString();
    }

    private static String getPageSelectionArgsForVideoOrAudioMediaCondition(long j10, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        sb2.append(str);
        sb2.append(" AND ");
        sb2.append(str2);
        sb2.append(") AND ");
        if (j10 == -1) {
            sb2.append(str3);
            return sb2.toString();
        }
        sb2.append("bucket_id");
        sb2.append("=? AND ");
        sb2.append(str3);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getQueryMimeCondition() {
        /*
            r10 = this;
            com.zyql.ai.selector.config.PictureSelectionConfig r0 = r10.config
            java.util.HashSet<java.lang.String> r0 = r0.queryMimeTypeHashSet
            if (r0 != 0) goto Lb
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
        Lb:
            com.zyql.ai.selector.config.PictureSelectionConfig r1 = r10.config
            java.lang.String r1 = r1.specifiedFormat
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            com.zyql.ai.selector.config.PictureSelectionConfig r1 = r10.config
            java.lang.String r1 = r1.specifiedFormat
            r0.add(r1)
        L1c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
            r3 = -1
        L26:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto La3
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L39
            goto L26
        L39:
            com.zyql.ai.selector.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.zyql.ai.selector.config.PictureMimeType.ofVideo()
            java.lang.String r7 = "audio"
            java.lang.String r8 = "image"
            if (r5 != r6) goto L54
            boolean r5 = r4.startsWith(r8)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r7)
            if (r5 == 0) goto L84
            goto L26
        L54:
            com.zyql.ai.selector.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.zyql.ai.selector.config.PictureMimeType.ofImage()
            java.lang.String r9 = "video"
            if (r5 != r6) goto L6d
            boolean r5 = r4.startsWith(r7)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r9)
            if (r5 == 0) goto L84
            goto L26
        L6d:
            com.zyql.ai.selector.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.zyql.ai.selector.config.PictureMimeType.ofAudio()
            if (r5 != r6) goto L84
            boolean r5 = r4.startsWith(r9)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r8)
            if (r5 == 0) goto L84
            goto L26
        L84:
            int r3 = r3 + 1
            if (r3 != 0) goto L8b
            java.lang.String r5 = " AND "
            goto L8d
        L8b:
            java.lang.String r5 = " OR "
        L8d:
            r1.append(r5)
            java.lang.String r5 = "mime_type"
            r1.append(r5)
            java.lang.String r5 = "='"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = "'"
            r1.append(r4)
            goto L26
        La3:
            com.zyql.ai.selector.config.PictureSelectionConfig r2 = r10.config
            int r2 = r2.chooseMode
            int r3 = com.zyql.ai.selector.config.PictureMimeType.ofVideo()
            if (r2 == r3) goto Lc2
            com.zyql.ai.selector.config.PictureSelectionConfig r10 = r10.config
            boolean r10 = r10.isGif
            if (r10 != 0) goto Lc2
            java.lang.String r10 = com.zyql.ai.selector.config.PictureMimeType.ofGIF()
            boolean r10 = r0.contains(r10)
            if (r10 != 0) goto Lc2
            java.lang.String r10 = " AND (mime_type!='image/gif' AND mime_type!='image/*')"
            r1.append(r10)
        Lc2:
            java.lang.String r10 = r1.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.model.LocalMediaPageLoader.getQueryMimeCondition():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getRealPathAndroid_Q(long j10) {
        return QUERY_URI.buildUpon().appendPath(ValueOf.toString(Long.valueOf(j10))).build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelection() {
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            return getSelectionArgsForAllMediaCondition(getDurationCondition(), fileSizeCondition, queryMimeCondition);
        }
        if (i10 == 1) {
            return getSelectionArgsForImageMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        if (i10 == 2 || i10 == 3) {
            return getSelectionArgsForVideoOrAudioMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getSelectionArgs() {
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            return getSelectionArgsForAllMediaType();
        }
        if (i10 == 1) {
            return getSelectionArgsForSingleMediaType(1);
        }
        if (i10 == 2) {
            return getSelectionArgsForSingleMediaType(3);
        }
        if (i10 != 3) {
            return null;
        }
        return getSelectionArgsForSingleMediaType(2);
    }

    private static String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        sb2.append(str3);
        sb2.append(" OR ");
        sb2.append("media_type");
        sb2.append("=? AND ");
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append(str2);
        if (SdkVersionUtils.checkedAndroid_Q()) {
            return sb2.toString();
        }
        sb2.append(")");
        sb2.append(GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            sb2.append("media_type");
            sb2.append("=?");
            sb2.append(str);
            sb2.append(" AND ");
            sb2.append(str2);
            return sb2.toString();
        }
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append(str2);
        sb2.append(")");
        sb2.append(GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int i10, long j10) {
        return j10 == -1 ? new String[]{String.valueOf(i10)} : new String[]{String.valueOf(i10), ValueOf.toString(Long.valueOf(j10))};
    }

    private static String[] getSelectionArgsForSingleMediaType(int i10) {
        return new String[]{String.valueOf(i10)};
    }

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            sb2.append("media_type");
            sb2.append("=?");
            sb2.append(str);
            sb2.append(" AND ");
            sb2.append(str2);
            return sb2.toString();
        }
        sb2.append("(");
        sb2.append("media_type");
        sb2.append("=?");
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append(str2);
        sb2.append(")");
        sb2.append(GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    public static void setInstanceNull() {
        instance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, new Comparator() { // from class: com.zyql.ai.selector.model.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LocalMediaPageLoader.a((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    public String getFirstCover(long j10) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = SdkVersionUtils.checkedAndroid_R() ? this.mContext.getContentResolver().query(QUERY_URI, new String[]{StepOSRecipientEmailHistory._ID, "_data"}, MediaUtils.createQueryArgsBundle(getPageSelection(j10), getPageSelectionArgs(j10), 1, 0), null) : this.mContext.getContentResolver().query(QUERY_URI, new String[]{StepOSRecipientEmailHistory._ID, "_data"}, getPageSelection(j10), getPageSelectionArgs(j10), "_id DESC limit 1 offset 0");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (!cursorQuery.moveToFirst()) {
                            if (!cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                        String realPathAndroid_Q = SdkVersionUtils.checkedAndroid_Q() ? getRealPathAndroid_Q(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(StepOSRecipientEmailHistory._ID))) : cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (!cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return realPathAndroid_Q;
                    }
                } catch (Exception e10) {
                    cursor = cursorQuery;
                    exc = e10;
                    try {
                        exc.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null || cursor2.isClosed()) {
                            throw th;
                        }
                        cursor2.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = cursorQuery;
                    th = th3;
                    if (cursor2 != null) {
                        throw th;
                    }
                    throw th;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Exception e11) {
            exc = e11;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
        return null;
    }

    public void loadAllMedia(final OnQueryDataResultListener<LocalMediaFolder> onQueryDataResultListener) {
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.zyql.ai.selector.model.LocalMediaPageLoader.2
            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            public List<LocalMediaFolder> doInBackground() {
                int i10;
                Cursor cursorQuery = LocalMediaPageLoader.this.mContext.getContentResolver().query(LocalMediaPageLoader.QUERY_URI, SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.PROJECTION_29 : LocalMediaPageLoader.PROJECTION, LocalMediaPageLoader.this.getSelection(), LocalMediaPageLoader.this.getSelectionArgs(), LocalMediaPageLoader.ORDER_BY);
                try {
                    if (cursorQuery != null) {
                        try {
                            int count = cursorQuery.getCount();
                            ArrayList arrayList = new ArrayList();
                            if (count > 0) {
                                if (SdkVersionUtils.checkedAndroid_Q()) {
                                    HashMap map = new HashMap();
                                    while (cursorQuery.moveToNext()) {
                                        long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                        Long l10 = (Long) map.get(Long.valueOf(j10));
                                        map.put(Long.valueOf(j10), l10 == null ? 1L : Long.valueOf(l10.longValue() + 1));
                                    }
                                    if (cursorQuery.moveToFirst()) {
                                        HashSet hashSet = new HashSet();
                                        i10 = 0;
                                        do {
                                            long j11 = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                            if (!hashSet.contains(Long.valueOf(j11))) {
                                                LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                                localMediaFolder.setBucketId(j11);
                                                String string = cursorQuery.getString(cursorQuery.getColumnIndex(LocalMediaPageLoader.COLUMN_BUCKET_DISPLAY_NAME));
                                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                                                Long l11 = (Long) map.get(Long.valueOf(j11));
                                                long jLongValue = l11.longValue();
                                                long j12 = cursorQuery.getLong(cursorQuery.getColumnIndex(StepOSRecipientEmailHistory._ID));
                                                localMediaFolder.setName(string);
                                                localMediaFolder.setImageNum(ValueOf.toInt(l11));
                                                localMediaFolder.setFirstImagePath(LocalMediaPageLoader.getRealPathAndroid_Q(j12));
                                                localMediaFolder.setFirstMimeType(string2);
                                                arrayList.add(localMediaFolder);
                                                hashSet.add(Long.valueOf(j11));
                                                i10 = (int) (i10 + jLongValue);
                                            }
                                        } while (cursorQuery.moveToNext());
                                    } else {
                                        i10 = 0;
                                    }
                                } else {
                                    cursorQuery.moveToFirst();
                                    int i11 = 0;
                                    do {
                                        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                                        long j13 = cursorQuery.getLong(cursorQuery.getColumnIndex("bucket_id"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(LocalMediaPageLoader.COLUMN_BUCKET_DISPLAY_NAME));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                                        int i12 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                                        localMediaFolder2.setBucketId(j13);
                                        localMediaFolder2.setFirstImagePath(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                                        localMediaFolder2.setName(string3);
                                        localMediaFolder2.setFirstMimeType(string4);
                                        localMediaFolder2.setImageNum(i12);
                                        arrayList.add(localMediaFolder2);
                                        i11 += i12;
                                    } while (cursorQuery.moveToNext());
                                    i10 = i11;
                                }
                                LocalMediaPageLoader.this.sortFolder(arrayList);
                                LocalMediaFolder localMediaFolder3 = new LocalMediaFolder();
                                localMediaFolder3.setImageNum(i10);
                                localMediaFolder3.setChecked(true);
                                localMediaFolder3.setBucketId(-1L);
                                if (cursorQuery.moveToFirst()) {
                                    localMediaFolder3.setFirstImagePath(SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.getFirstUri(cursorQuery) : LocalMediaPageLoader.getFirstUrl(cursorQuery));
                                    localMediaFolder3.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(cursorQuery));
                                }
                                localMediaFolder3.setName(LocalMediaPageLoader.this.config.chooseMode == PictureMimeType.ofAudio() ? LocalMediaPageLoader.this.mContext.getString(R.string.picture_all_audio) : LocalMediaPageLoader.this.mContext.getString(R.string.picture_camera_roll));
                                localMediaFolder3.setOfAllType(LocalMediaPageLoader.this.config.chooseMode);
                                localMediaFolder3.setCameraFolder(true);
                                arrayList.add(0, localMediaFolder3);
                                if (!cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            Log.i(LocalMediaPageLoader.TAG, "loadAllMedia Data Error: " + e10.getMessage());
                            if (cursorQuery.isClosed()) {
                                return null;
                            }
                            cursorQuery.close();
                            return null;
                        }
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return new ArrayList();
                } catch (Throwable th) {
                    if (!cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }

            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMediaFolder> list) {
                OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 == null || list == null) {
                    return;
                }
                onQueryDataResultListener2.onComplete(list, 1, false);
            }
        });
    }

    public void loadPageMediaData(long j10, int i10, int i11, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        loadPageMediaData(j10, i10, i11, this.config.pageSize, onQueryDataResultListener);
    }

    public void loadPageMediaData(long j10, int i10, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        int i11 = this.config.pageSize;
        loadPageMediaData(j10, i10, i11, i11, onQueryDataResultListener);
    }

    public void loadPageMediaData(final long j10, final int i10, final int i11, final int i12, final OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<MediaData>() { // from class: com.zyql.ai.selector.model.LocalMediaPageLoader.1
            /* JADX WARN: Removed duplicated region for block: B:134:0x025e A[EDGE_INSN: B:134:0x025e->B:90:0x025e BREAK  A[LOOP:0: B:25:0x0124->B:91:0x025f], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x018c A[Catch: all -> 0x0139, Exception -> 0x013d, PHI: r3
              0x018c: PHI (r3v10 java.lang.String) = (r3v9 java.lang.String), (r3v44 java.lang.String), (r3v44 java.lang.String) binds: [B:42:0x016a, B:48:0x0183, B:50:0x0189] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {Exception -> 0x013d, blocks: (B:24:0x011b, B:25:0x0124, B:27:0x0132, B:33:0x0142, B:35:0x014c, B:88:0x0258, B:95:0x026b, B:99:0x0276, B:38:0x0156, B:40:0x0160, B:41:0x0164, B:43:0x016c, B:45:0x0172, B:47:0x017b, B:49:0x0185, B:46:0x0177, B:52:0x018c, B:54:0x0196, B:57:0x01a1, B:59:0x01ab, B:62:0x01b6, B:64:0x01e4, B:67:0x01f8, B:69:0x01fe, B:71:0x0208, B:75:0x021a, B:77:0x0224, B:87:0x0240), top: B:125:0x011b }] */
            /* JADX WARN: Removed duplicated region for block: B:91:0x025f A[LOOP:0: B:25:0x0124->B:91:0x025f, LOOP_END] */
            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.zyql.ai.selector.entity.MediaData doInBackground() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 721
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.model.LocalMediaPageLoader.AnonymousClass1.doInBackground():com.zyql.ai.selector.entity.MediaData");
            }

            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            public void onSuccess(MediaData mediaData) {
                OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 == null || mediaData == null) {
                    return;
                }
                onQueryDataResultListener2.onComplete(mediaData.data, i10, mediaData.isHasNextMore);
            }
        });
    }
}
