package com.stepos.agentframework.adapter.coze.util;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.stepos.agentframework.adapter.bff.BffConstant;

/* loaded from: classes3.dex */
public class UriToPathUtil {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[PHI: r8
      0x0030: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:21:0x003d, B:14:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            if (r8 == 0) goto L2e
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2b
            if (r9 == 0) goto L2e
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2b
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2b
            r8.close()
            return r9
        L27:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L41
        L2b:
            r0 = move-exception
            r9 = r0
            goto L3a
        L2e:
            if (r8 == 0) goto L40
        L30:
            r8.close()
            goto L40
        L34:
            r0 = move-exception
            r9 = r0
            goto L41
        L37:
            r0 = move-exception
            r9 = r0
            r8 = r7
        L3a:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L27
            if (r8 == 0) goto L40
            goto L30
        L40:
            return r7
        L41:
            if (r7 == 0) goto L46
            r7.close()
        L46:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.util.UriToPathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getPathFromDocumentUri(android.content.Context r6, android.net.Uri r7) {
        /*
            boolean r0 = isExternalStorageDocument(r7)
            r1 = 1
            r2 = 0
            java.lang.String r3 = ":"
            r4 = 0
            if (r0 == 0) goto L38
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String[] r6 = r6.split(r3)
            r7 = r6[r2]
            java.lang.String r0 = "primary"
            boolean r7 = r0.equalsIgnoreCase(r7)
            if (r7 == 0) goto Lae
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r7.append(r0)
            java.lang.String r0 = "/"
            r7.append(r0)
            r6 = r6[r1]
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            return r6
        L38:
            boolean r0 = isDownloadsDocument(r7)
            if (r0 == 0) goto L59
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String r0 = "content://downloads/public_downloads"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            long r1 = r7.longValue()
            android.net.Uri r7 = android.content.ContentUris.withAppendedId(r0, r1)
            java.lang.String r6 = getDataColumn(r6, r7, r4, r4)
            return r6
        L59:
            boolean r0 = isMediaDocument(r7)
            if (r0 == 0) goto Lae
            java.lang.String r7 = android.provider.DocumentsContract.getDocumentId(r7)
            java.lang.String[] r7 = r7.split(r3)
            r0 = r7[r2]
            r0.getClass()
            int r3 = r0.hashCode()
            r5 = -1
            switch(r3) {
                case 93166550: goto L8c;
                case 100313435: goto L81;
                case 112202875: goto L76;
                default: goto L74;
            }
        L74:
            r2 = r5
            goto L95
        L76:
            java.lang.String r2 = "video"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L7f
            goto L74
        L7f:
            r2 = 2
            goto L95
        L81:
            java.lang.String r2 = "image"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L8a
            goto L74
        L8a:
            r2 = r1
            goto L95
        L8c:
            java.lang.String r3 = "audio"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L95
            goto L74
        L95:
            switch(r2) {
                case 0: goto L9f;
                case 1: goto L9c;
                case 2: goto L99;
                default: goto L98;
            }
        L98:
            goto La1
        L99:
            android.net.Uri r4 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto La1
        L9c:
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto La1
        L9f:
            android.net.Uri r4 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        La1:
            r7 = r7[r1]
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.lang.String r0 = "_id=?"
            java.lang.String r6 = getDataColumn(r6, r4, r0, r7)
            return r6
        Lae:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.util.UriToPathUtil.getPathFromDocumentUri(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String getRealPath(Context context, Uri uri) {
        if (BffConstant.Type.File.equals(uri.getScheme())) {
            return uri.getPath();
        }
        if ("content".equals(uri.getScheme())) {
            return DocumentsContract.isDocumentUri(context, uri) ? getPathFromDocumentUri(context, uri) : getDataColumn(context, uri, null, null);
        }
        return null;
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
