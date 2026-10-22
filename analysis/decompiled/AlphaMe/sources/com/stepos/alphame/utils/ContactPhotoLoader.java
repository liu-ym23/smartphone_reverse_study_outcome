package com.stepos.alphame.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ContactPhotoLoader {
    private static final int LOOKUP_INDEX_DISPLAY_NAME = 2;
    private static final int LOOKUP_INDEX_PHOTO_THUMBNAIL_URI = 1;
    private static final int LOOKUP_INDEX_PHOTO_URI = 0;
    private static final String[] LOOKUP_PROJECT = {"photo_uri", "photo_thumb_uri", "display_name"};
    private static final String TAG = "ContactPhotoLoader";

    public static class MemberInfo {
        public String displayName;
        public String lookupKey;
        public long photoId;
        public String photoThumbnailUri;
        public String photoUri;

        private MemberInfo() {
        }

        public /* synthetic */ MemberInfo(int i4) {
            this();
        }
    }

    public static Bitmap buildContactPhoto(Context context, String str) {
        MemberInfo memberInfo = new MemberInfo(0);
        memberInfo.displayName = str;
        return loadPhoto(context, memberInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap buildDefaultPhoto(android.content.Context r26, java.lang.String r27, java.lang.String r28) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1083
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.utils.ContactPhotoLoader.buildDefaultPhoto(android.content.Context, java.lang.String, java.lang.String):android.graphics.Bitmap");
    }

    private static MemberInfo loadContactInfo(Context context, String str) {
        Cursor cursorQuery = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MemberInfo memberInfo = new MemberInfo(0);
        memberInfo.lookupKey = str;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), LOOKUP_PROJECT, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    memberInfo.displayName = cursorQuery.getString(2);
                    memberInfo.photoUri = cursorQuery.getString(0);
                    memberInfo.photoThumbnailUri = cursorQuery.getString(1);
                }
            } catch (Exception e4) {
                Log.w(TAG, "", e4);
                if (cursorQuery != null) {
                }
            }
            return memberInfo;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static Bitmap loadContactPhoto(Context context, String str) {
        return loadPhoto(context, loadContactInfo(context, str));
    }

    private static Bitmap loadPhoto(Context context, MemberInfo memberInfo) throws IOException {
        String str = null;
        if (memberInfo == null) {
            Log.w(TAG, "loadPhoto, memerInfo = null");
            return null;
        }
        long j4 = memberInfo.photoId;
        Bitmap bitmapLoadPhoto = j4 != 0 ? loadPhoto(context, j4) : null;
        if (bitmapLoadPhoto == null && !TextUtils.isEmpty(memberInfo.photoThumbnailUri)) {
            bitmapLoadPhoto = loadPhoto(context, memberInfo.photoThumbnailUri);
        }
        if (bitmapLoadPhoto == null && !TextUtils.isEmpty(memberInfo.photoUri)) {
            bitmapLoadPhoto = loadPhoto(context, memberInfo.photoUri);
        }
        if (bitmapLoadPhoto != null) {
            return bitmapLoadPhoto;
        }
        String str2 = memberInfo.displayName;
        String str3 = memberInfo.lookupKey;
        if (str3 == null) {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str2)) {
                str = str2;
                str2 = str3;
            } else {
                str = str2;
            }
        }
        return buildDefaultPhoto(context, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[PHI: r0 r8
      0x0037: PHI (r0v5 android.graphics.Bitmap) = (r0v12 android.graphics.Bitmap), (r0v8 android.graphics.Bitmap) binds: [B:20:0x0046, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0037: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v6 android.database.Cursor) binds: [B:20:0x0046, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap loadPhoto(android.content.Context r8, long r9) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            android.net.Uri r2 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r8 = 1
            java.lang.String[] r3 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r4 = "data15"
            r7 = 0
            r3[r7] = r4     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r4 = "_id=?"
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r5[r7] = r8     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r8 == 0) goto L35
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r9 == 0) goto L35
            byte[] r9 = r8.getBlob(r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            int r10 = r9.length     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r9, r7, r10)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L35
        L30:
            r9 = move-exception
            r0 = r8
            goto L4a
        L33:
            r9 = move-exception
            goto L3f
        L35:
            if (r8 == 0) goto L49
        L37:
            r8.close()
            goto L49
        L3b:
            r9 = move-exception
            goto L4a
        L3d:
            r9 = move-exception
            r8 = r0
        L3f:
            java.lang.String r10 = "ContactPhotoLoader"
            java.lang.String r1 = ""
            android.util.Log.w(r10, r1, r9)     // Catch: java.lang.Throwable -> L30
            if (r8 == 0) goto L49
            goto L37
        L49:
            return r0
        L4a:
            if (r0 == 0) goto L4f
            r0.close()
        L4f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.utils.ContactPhotoLoader.loadPhoto(android.content.Context, long):android.graphics.Bitmap");
    }

    private static Bitmap loadPhoto(Context context, String str) throws IOException {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(Uri.parse(str));
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            } finally {
            }
        } catch (Exception e4) {
            Log.w(TAG, "", e4);
        }
        return bitmapDecodeStream;
    }
}
