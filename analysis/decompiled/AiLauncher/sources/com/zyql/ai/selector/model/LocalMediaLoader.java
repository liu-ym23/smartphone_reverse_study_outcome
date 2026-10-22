package com.zyql.ai.selector.model;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.ValueOf;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Deprecated
/* loaded from: classes4.dex */
public final class LocalMediaLoader {
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    private static final String TAG = "LocalMediaLoader";
    private final Context mContext;
    private static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    private static final String[] PROJECTION = {StepOSRecipientEmailHistory._ID, "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", PictureConfig.EXTRA_BUCKET_ID, "date_added"};
    private final boolean isAndroidQ = SdkVersionUtils.checkedAndroid_Q();
    private final PictureSelectionConfig config = PictureSelectionConfig.getInstance();

    public LocalMediaLoader(Context context) {
        this.mContext = context.getApplicationContext();
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

    private LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        if (!this.config.isFallbackVersion) {
            for (LocalMediaFolder localMediaFolder : list) {
                String name = localMediaFolder.getName();
                if (!TextUtils.isEmpty(name) && name.equals(str3)) {
                    return localMediaFolder;
                }
            }
            LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
            localMediaFolder2.setName(str3);
            localMediaFolder2.setFirstImagePath(str);
            localMediaFolder2.setFirstMimeType(str2);
            list.add(localMediaFolder2);
            return localMediaFolder2;
        }
        File parentFile = new File(str).getParentFile();
        for (LocalMediaFolder localMediaFolder3 : list) {
            String name2 = localMediaFolder3.getName();
            if (!TextUtils.isEmpty(name2) && parentFile != null && name2.equals(parentFile.getName())) {
                return localMediaFolder3;
            }
        }
        LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
        localMediaFolder4.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder4.setFirstImagePath(str);
        localMediaFolder4.setFirstMimeType(str2);
        list.add(localMediaFolder4);
        return localMediaFolder4;
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
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.model.LocalMediaLoader.getQueryMimeCondition():java.lang.String");
    }

    private String getRealPathAndroid_Q(long j10) {
        return QUERY_URI.buildUpon().appendPath(ValueOf.toString(Long.valueOf(j10))).build().toString();
    }

    private String getSelection() {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, queryMimeCondition);
        }
        if (i10 == 1) {
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i10 == 2) {
            return getSelectionArgsForVideoOrAudioMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i10 != 3) {
            return null;
        }
        return getSelectionArgsForVideoOrAudioMediaCondition(durationCondition, queryMimeCondition);
    }

    private String[] getSelectionArgs() {
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
        return "(media_type=?" + str3 + " OR media_type=? AND " + str + ") AND " + str2;
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String[] getSelectionArgsForSingleMediaType(int i10) {
        return new String[]{String.valueOf(i10)};
    }

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, new Comparator() { // from class: com.zyql.ai.selector.model.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LocalMediaLoader.a((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01bc A[EDGE_INSN: B:104:0x01bc->B:70:0x01bc BREAK  A[LOOP:0: B:9:0x008b->B:78:0x0216], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8 A[Catch: all -> 0x00a2, Exception -> 0x00a5, PHI: r8
      0x00e8: PHI (r8v6 java.lang.String) = (r8v5 java.lang.String), (r8v12 java.lang.String), (r8v12 java.lang.String) binds: [B:21:0x00c0, B:28:0x00d7, B:30:0x00dd] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x00a2, blocks: (B:4:0x001c, B:6:0x0031, B:8:0x0066, B:9:0x008b, B:11:0x009b, B:17:0x00aa, B:19:0x00b4, B:20:0x00b8, B:22:0x00c2, B:24:0x00c8, B:27:0x00d3, B:29:0x00d9, B:68:0x01b6, B:70:0x01bc, B:72:0x01c2, B:74:0x01ed, B:76:0x01fe, B:75:0x01f6, B:26:0x00ce, B:33:0x00e8, B:35:0x00ee, B:38:0x00f9, B:40:0x00ff, B:43:0x010a, B:45:0x0132, B:48:0x013e, B:50:0x0144, B:52:0x014c, B:55:0x0152, B:57:0x0156, B:67:0x016a, B:85:0x022d), top: B:100:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0216 A[LOOP:0: B:9:0x008b->B:78:0x0216, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.zyql.ai.selector.entity.LocalMediaFolder> loadAllMedia() {
        /*
            Method dump skipped, instructions count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.model.LocalMediaLoader.loadAllMedia():java.util.List");
    }
}
